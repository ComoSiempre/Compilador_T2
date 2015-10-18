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
    
}
