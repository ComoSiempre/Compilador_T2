/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.*;
/**
 * Proyecto correspondiente a la integracion de la fase de analisis Sintactico en la implementacion del compilador
 * para el lenguaje K*, utilizando el analizador sintactico Java CUP.
 * @author:     Jonatham Vasquez - Eduardo Tapia
 * @version:    
 */
public class Compilador {
    /**
     * metodo que genera el archivo java lexer.java, que contiene la nomenclatura del analisis lexico.
     * @param path la direccion donde se encuentra el archivo .flex
     */       
    public static void generarLexer(String path){
        //se crea la variable File nesesaria para la generacion del lexer
        File file=new File(path);
        //se llama al paquete Jflex para la generacion del lexer enviando como parametro el archivo FIle.
        jflex.Main.generate(file);
    }
    public static void generarParser(String path){
        String[] asintactico = { "-parser", "parser", path };
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //variable donde obtengo la direccion del proyecto.
        final String dir =System.getProperty("user.dir");
        //variable usada para guardar la direccion del archivo .flex
        String pathFlex=dir+"/src/scanner/Lexer.flex";
        String pathParser=dir+"/src/parser/Parser.cup";
        //se llama a la funcion de generacion de lexer. 
        generarLexer(pathFlex);
        generarParser(pathParser);
            
    }
    
}
