/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import java.util.ArrayList;
import syntaxVisitor.GrapherVisitor;

/**
 *
 * @author jona
 */
public class Compound extends Nodo implements visitaNodo {

    //lista que guarda los nodos de variables locales.
    ArrayList<Nodo> listaLocalVar=new ArrayList<Nodo>();
    //lista que guarda los nodos Statements.
    ArrayList<Nodo> listaStatements = new ArrayList<Nodo>();
    
    //constructor que guarda las lista ya llenadas.
    public Compound(ArrayList<Nodo> local, ArrayList<Nodo> sta){
        this.listaLocalVar=local;
        this.listaStatements=sta;
    }
    
    public String toGrapher(int contNodos){
        return "\"nodo"+contNodos+"\"[label=\"Compound Statement\"]; \n";
    }
    public ArrayList<Nodo> getLocalVar(){
        return this.listaLocalVar;
    }
    public ArrayList<Nodo> getStatements(){
        return this.listaStatements;
    }
    @Override
    public void aceptar(GrapherVisitor v) {
        v.visitar(this);
    }
    
}
