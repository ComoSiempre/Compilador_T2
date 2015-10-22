/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import java.util.ArrayList;
import syntaxVisitor.GrapherVisitor;

/**
 * Clase Nodo que guarda los datos de llas gramaticas 31 a 33.
 * @author Jonathan Vasquez - Eduardo Tapia.
 */
public class Call extends Nodo implements visitaNodo {
    String ID;
    ArrayList<Nodo> listaArgs= new ArrayList<Nodo>();
    
    public Call(){}
    
    public void agregarArgumento(Nodo Expression){
        this.listaArgs.add(Expression);
    }
    public void setID(String id){
        this.ID=id;
    }
    public ArrayList<Nodo> getArgs(){
        return this.listaArgs;
    }
    /**
     * metodo que genera el codigo en graphviz del nodo call.
     * @param contNodos la cantidad de nodos visitados.
     * @return codigo generado.
     */
    public String toGrapher(int contNodos){
        return "\"nodo"+contNodos+"\"[label=\"Call : "+this.ID+"\"]; \n";
    }
    @Override
    public void aceptar(GrapherVisitor v) {
        v.visitar(this);
    }
    
}
