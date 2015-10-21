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
    int valor; //variable que guardara el valor de las operaciones de +,-,*,/,^,**.
    boolean esComparacion=false; //variable flag que verificara si la expresion es una operacion o comparacion(EQ,LT,LEQ,etc..)
    
    
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
    /**
     * metodo que hace el calculo de 2 numeros segun un operador.
     * @param operador que puede ser +, -, *, /.
     */
    private void calcular2NUM(String operador){
        switch (operador) {
            case "+":
                this.valor = ((Var) this.operacion1).getNumeroExpresion() + ((Var) this.operacion2).getNumeroExpresion();
                break;
            case "-":
                this.valor = ((Var) this.operacion1).getNumeroExpresion() - ((Var) this.operacion2).getNumeroExpresion();
                break;
            case "*":
                this.valor = ((Var) this.operacion1).getNumeroExpresion() * ((Var) this.operacion2).getNumeroExpresion();
                break;
            case "/":
                this.valor = ((Var) this.operacion1).getNumeroExpresion() / ((Var) this.operacion2).getNumeroExpresion();
                break;
        }

    }
    /**
     * metodo que calcula la operacion de el resultado de una expresion y un numero.
     * @param operador 
     */
    private void calcular1Exp1NUM(String operador){
        switch (operador) {
            case "+":
                this.valor = ((Expression) this.operacion1).getValor() + ((Var) this.operacion2).getNumeroExpresion();
                break;
            case "-":
                this.valor = ((Expression) this.operacion1).getValor() - ((Var) this.operacion2).getNumeroExpresion();
                break;
            case "*":
                this.valor = ((Expression) this.operacion1).getValor() * ((Var) this.operacion2).getNumeroExpresion();
                break;
            case "/":
                this.valor = ((Expression) this.operacion1).getValor() / ((Var) this.operacion2).getNumeroExpresion();
                break;
        }

    }
    /**
     * metodo que calcula la operacion de el resultado de una expresion y un numero.
     * @param operador 
     */
    private void calcular1NUM1Exp(String operador){
        switch (operador) {
            case "+":
                this.valor = ((Var) this.operacion1).getNumeroExpresion() + ((Expression) this.operacion2).getValor();
                break;
            case "-":
                this.valor = ((Var) this.operacion1).getNumeroExpresion() - ((Expression) this.operacion2).getValor();
                break;
            case "*":
                this.valor = ((Var) this.operacion1).getNumeroExpresion() * ((Expression) this.operacion2).getValor();;
                break;
            case "/":
                this.valor = ((Var) this.operacion1).getNumeroExpresion() / ((Expression) this.operacion2).getValor();
                break;
        }

    }
    /**
     * metodo que calcula el resultado de la operacion entre los resultados de las 2 expresiones.
     * @param operador 
     */
    private void calcular2Exp(String operador){
        switch (operador) {
            case "+":
                this.valor = ((Expression) this.operacion1).getValor() + ((Expression) this.operacion2).getValor();
                break;
            case "-":
                this.valor = ((Expression) this.operacion1).getValor() - ((Expression) this.operacion2).getValor();
                break;
            case "*":
                this.valor = ((Expression) this.operacion1).getValor() * ((Expression) this.operacion2).getValor();;
                break;
            case "/":
                this.valor = ((Expression) this.operacion1).getValor() / ((Expression) this.operacion2).getValor();
                break;
        }

    }
    public void calculoValor(){
        //se verifica todas las posibilidades de operacion.
        //se verifica que operacion1 y operacion2 sean Var numero.
        if(this.operacion1 instanceof Var && this.operacion2 instanceof Var){
            //verifico que las operaciones sean numeros.
            if((((Var)this.operacion1).getID() ==null && ((Var)this.operacion1).getExpression() == null)
                                &&(((Var)this.operacion2).getID() ==null && ((Var)this.operacion2).getExpression() == null)){
                                //las dos espresiones son numeros.
                                //se realiza la operacion y se guarda el resultado en el nodo.
                                calcular2NUM(this.operador);
                                
                            }
        }
        //se verifica que op1 es Expresion de otra operacion y op2 sea Var numero.
        if(this.operacion1 instanceof Expression && this.operacion2 instanceof Var){
            //se verifica que Var sea nodo numero.
            if(((Var)this.operacion2).getID()==null && ((Var)this.operacion2).getExpression()==null){
                //el nodo Var es un numero.
                calcular1Exp1NUM(this.operador);
            }
            
        }
        //se verifica que op1 sea Var numero y op2 sea Expresion de otra operacion.
        if(this.operacion1 instanceof Var && this.operacion2 instanceof Expression){
            //se verifica que Var sea nodo numero.
            if(((Var)this.operacion1).getID()==null && ((Var)this.operacion1).getExpression()==null){
                //el nodo Var es un numero.
                calcular1NUM1Exp(this.operador);
            }
        }
        //se verifica que la operacion sea entre 2 expresiones.
        if(this.operacion1 instanceof Expression && this.operacion2 instanceof Expression){
            //verifico que las expresiones sea de operaciones calculables.
            if(((Expression)this.operacion1).getEsComparacion()==false && ((Expression)this.operacion2).getEsComparacion()==false){
                //las espresiones son calculables, por lo que tiene valor.
                calcular2Exp(this.operador);
            }
        }
    }
    public String toGrapher(int contNodos){
        if(this.esComparacion==false){
            return "\"nodo"+contNodos+"\"[label=\""+this.operador+"\nValue: "+this.valor+"\"]; \n";
        }else{
            return "\"nodo"+contNodos+"\"[label=\""+this.operador+"\"]; \n";
        }
        
    }
    /**
     * metodo usado en caso de que sea una operacion de asignacion, expression -> var ASSIGN expresion (gramatica 20).
     */
    public void asignarValor(){
        this.valor=((Expression)this.operacion2).getValor();
    }
    public Nodo getOperador1(){
        return this.operacion1;
    }
    public Nodo getOperador2(){
        return this.operacion2;
    }
    public int getValor(){
        return this.valor;
    }
    public boolean getEsComparacion(){
        return this.esComparacion;
    }
    public void setEsComparacion(boolean flag){
        this.esComparacion=flag;
    }
    
    @Override
    public void aceptar(GrapherVisitor v) {
        v.visitar(this);
    }
    
    
}
