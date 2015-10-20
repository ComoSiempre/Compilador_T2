/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import syntaxVisitor.GrapherVisitor;

/**
 * Clase usada para la crecion de nodos de operaciones.
 * gramaticas 20, 22, 24, 26, 28.
 * @author Jonathan Vasquez - Eduardo Tapia.
 */
public class Expression extends Nodo implements visitaNodo {

    Nodo operacion1; //variable que puede ser tanto un Nodo expresion como Var(con variable o numero).
    String operador; // puede ser un operador de la gramatica relop, mulop, addop, powop.
    Nodo operacion2; //variable que puede ser un numero (String en .cup) o un Nodo Var o Call o Expression.
    /**
     * constructor 1. usado en caso que que el operador este ligado con dos Nodos expresiones.
     * @param op1 
     * @param op 
     * @param ex 
     */
    public Expression(Nodo op1, String op, Nodo ex){
        this.operacion1=op1;
        this.operador=op;
        this.operacion2=ex;
        
    }
//    /**
//     * constructor 2. usado en caso de que la expresion consiste en una operacion con numeros.
//     * @param op1
//     * @param op
//     * @param numero 
//     */
//    public Expression(Nodo op1, String op, int numero){
//        this.operacion1=op1;
//        this.operador=op;
//        this.operacion2=numero;
//    }
//    /**
//     * contrcutor 3, usado en caso de que exista un numero en la drivacion de la izquierda en las gramaticas.
//     * @param numero
//     * @param op
//     * @param op2 
//     */
//    public Expression(int numero, String op, Nodo op2){
//        this.operacion1=numero;
//        this.operador=op;
//        this.operacion2=op2;
//    }
//    /**
//     * contructor 4, usado en caso que la operacion es directamente ligada a numeros.
//     * @param numero1
//     * @param op
//     * @param numero2 
//     */
//    public Expression(int numero1, String op, int numero2){
//        this.operacion1=numero1;
//        this.operador=op;
//        this.operacion2=numero2;
//    }
    
    public String toGrapher(int contNodos){
        return "\"nodo"+contNodos+"\"[label=\""+this.operador+"\"]; \n";
    }
    
    public Nodo getOperador1(){
        return this.operacion1;
    }
    public Nodo getOperador2(){
        return this.operacion2;
    }
    
    
    @Override
    public void aceptar(GrapherVisitor v) {
        v.visitar(this);
    }
    
    
}
