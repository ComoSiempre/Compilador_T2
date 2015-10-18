/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syntaxVisitor;

import ast.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import visitor.visitor;

/**
 *
 * @author jona
 */
public class GrapherVisitor implements visitor {
    String pathBase; //guardo la direccion del proyecto.
    int cantNodosVisitados; //contador de nodos visitados, nesesario para la creacion de nodos en el graphviz.
    String codigoGraph; //variable que guarda el codigo nesesario para la creacion grafica del AST en graphviz.
    Stack<String> auxPadres= new Stack<>(); //pila usada para guardar los padres en las visitas, nesesario para la creacion de nodods en graphviz.
    public GrapherVisitor(String pathBase){
        this.cantNodosVisitados=0;
        this.pathBase=pathBase;
        this.codigoGraph="";
    }
    /**
     * * metodo que genera la imagen del AST.
     * @param pathBase la direccion base del proyecto.
     */
    public void generarGraph() {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("cod.txt"));
            //System.out.println(this.codigoGraph);
            writer.write("digraph G { \n");
            writer.write(this.codigoGraph);
            writer.flush();
            writer.write("}");
            writer.close();
            String dotPath="C:\\graphviz-2.38\\release\\bin\\dot.exe";//path del instalable del graphviz.
            String fileInputPath=pathBase+"/cod.txt"; //txt del codigo .dot del arbol
            String fileOutputPath = pathBase +"/testCod.png"; //salida de la imagen del codigo.
            String tParam = "-Tpng";
            String tOParam = "-o";
            String [] cmd = new String[5];//variable para guardar el codigo en consola.
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
            System.out.println("Imagen creada");
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
    }
    
    @Override
    public void visitar(Program program) {
        //obtengo el identificador dl primer nodo.
        String ident = program.toGrapher(this.cantNodosVisitados);
        //agrego el identificador al codigo.
        this.codigoGraph += ident;
        //sepero el nombre del identificador del nombre asignadodentro del nodo, posicion 0.
        String [] delimitador= ident.split("\\[");
        //obtengo la id del nodo 'sin el ;'.
        this.auxPadres.push(delimitador[0]);
        //cuento como nodo visitado.
        this.cantNodosVisitados++;
        //obtengo la lista de declaraciones dentro del nodo Program.
        ArrayList<Nodo> lista = program.getDeclaraciones();
        //visito los siguientes nodos (hijos).
        for(Nodo nodo : lista ){
            nodo.aceptar(this);
        }
        //elimino el padre actual.
        this.auxPadres.pop();
        try{
            this.generarGraph();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }

    @Override
    public void visitar(VarDec vardeclaration) {
        //obtengo el codigo del nodo y lo agrego a la cadena general del cosigo graph
        this.codigoGraph +=vardeclaration.toGrapher(this.auxPadres.peek(), this.cantNodosVisitados);
        //cuanto como nodo visitado.
        this.cantNodosVisitados++;
    }

    @Override
    public void visitar(FunDec function) {
        //obtengo el ident del nodo funcion.
        String ident = function.toGrapher(this.cantNodosVisitados);
        //agrego el ident a la cadena de codigo graph.
        this.codigoGraph += ident;
        String [] delimitador= ident.split("\\[");
        //creo el enlace del padre con el nuevo nodo funcion.
        String enlace = this.auxPadres.peek()+"->"+delimitador[0]+"; \n";
        //guardo el enlace en el codigo.
        this.codigoGraph += enlace;
        //guardo el nuevo nodo en la pila.
        this.auxPadres.push(delimitador[0]);
        //cuento como nodo visitado.
        this.cantNodosVisitados++;
        //visito los nodos de parametros.
        for(Nodo nodo : function.getListaParametros()){
            nodo.aceptar(this);
        }
        //visito el nodo Compound.
        function.getCompound().aceptar(this);
        //elimino el padre de la pila . (raiz del sub arbol contando desde aqui).
        this.auxPadres.pop();
    }

    @Override
    public void visitar(Param parametro) {
        //enlazo el codigo del nodo param a la cadena de codigo general del graphviz. 
        this.codigoGraph += parametro.toGrapher(this.auxPadres.peek(), this.cantNodosVisitados);
        //cuento como nodo visitado.
        this.cantNodosVisitados++;
    }

    @Override
    public void visitar(Compound componente) {
        //obtengo el codigo del nodo Compound.
        String ident = componente.toGrapher(this.cantNodosVisitados);
        //se une con la cadena general de codigo graphviz.
        this.codigoGraph += ident;
        String [] delimitador = ident.split("\\[");
        //creo el enlace del padre con el nuevo nodo Compound.
        String enlace = this.auxPadres.peek()+"->"+delimitador[0]+"; \n";
        //se une el codigo a l codigo general.
        this.codigoGraph += enlace;
        //guardo en la pila al padre.
        this.auxPadres.push(delimitador[0]);
        //cuento como nodo visitado.
        this.cantNodosVisitados++;
        //visito los nodos de variables locales.
        for(Nodo nodo : componente.getLocalVar()){
            nodo.aceptar(this);
        }
        //visito los nodos de sentencias.
        for(Nodo nodo : componente.getStatements()){
            nodo.aceptar(this);
            
        }
        
        //elimino el padre de la pila.
        this.auxPadres.pop();
    }
    
}
