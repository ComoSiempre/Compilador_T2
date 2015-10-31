/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import ast.*;
import Tables.*;
import java.io.FileReader;
import java.io.IOException;
import java_cup.runtime.Symbol;
import parser.*;
import scanner.*;
import syntaxVisitor.GrapherVisitor;


/**
 * Proyecto correspondiente a la integracion de la fase de analisis Sintactico en la implementacion del compilador
 * para el lenguaje K*, utilizando el analizador sintactico Java CUP.
 * @author:     Jonatham Vasquez - Eduardo Tapia
 * @version:    31/10/2015/3.2.1.
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
        String[] asintactico = { "-parser", "Parser", path };
        try {
            
            java_cup.Main.main(asintactico);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * metodo usado para trasladar los archivos generados en el analisis lexico al paquete "scanner" 
     * @param nombreLexer el nombre Lexer.java
     * @return false si el traslado no se contreto, true el caso contrario.
     */
    public static boolean moverLex(String nombreLexer){
        boolean efectuado = false;
        //creacion variable File para traslado.
        File arch = new File(nombreLexer);
        //condicionante usado para confirmar la existencia del archivo Lexer.
        if (arch.exists()) {
            System.out.println("\n*** Moviendo " + arch + " \n***");
            Path currentRelativePath = Paths.get("");
            //guardo la direccion de destino.
            String nuevoDir = currentRelativePath.toAbsolutePath().toString()
                    + File.separator + "src" + File.separator + "scanner"
                    + File.separator + arch.getName();
            //creo el archivo en la nueva direccion.
            File archViejo = new File(nuevoDir);
            //elimino el archivo viejo.
            archViejo.delete();
            //genero el archivo en el paquete.
            if (arch.renameTo(new File(nuevoDir))) {
                System.out.println("\n*** Generado " + nombreLexer + "***\n");
                efectuado = true;
            } else {
                System.out.println("\n*** No movido " + nombreLexer + " ***\n");
            }

        } else {
            System.out.println("\n*** Codigo lexer no existente ***\n");
        }
        return efectuado;
    }
    /**
     * metodo usado para trasladar los archivos generados en el analisis sintactico al paquete "parser"  
     * @param nombreParser el nombre "Parser.java"
     * @return falso si no se concreto el traslado, true en caso contrario.
     */
    public static boolean moverParser(String nombreParser){
        boolean efectuado = false;
        File arch = new File(nombreParser);
        if (arch.exists()) {
            System.out.println("\n*** Moviendo " + arch + " \n***");
            Path currentRelativePath = Paths.get("");
            String nuevoDir = currentRelativePath.toAbsolutePath().toString()
                    + File.separator + "src" + File.separator + "parser"
                    + File.separator + arch.getName();
            File archViejo = new File(nuevoDir);
            archViejo.delete();
            if (arch.renameTo(new File(nuevoDir))) {
                System.out.println("\n*** Generado " + nombreParser + "***\n");
                efectuado = true;
            } else {
                System.out.println("\n*** No movido " + nombreParser + " ***\n");
            }

        } else {
            System.out.println("\n*** Codigo parser no existente ***\n");
        }
        return efectuado;
    }
    
    /**
     * metodo usado para mover los archivos a sus respectivos paquetes.
     */
    public static void move(){
        boolean mvLexer = moverLex("Lexer.java");
        boolean mvParser = moverParser("Parser.java");
        boolean mvSym = moverParser("sym.java");
        //condicionante usado para confirmar el traslado de archivos, segun su existencia despue de la compilacion.
        if (mvLexer && mvParser && mvSym) {
            System.exit(0);
        }
	
    }
    /**
     * metodo de separa el path de los ejercicion y obtiene solo el nombre del ejercicio.
     * @param pathEj direccion del ejercicio.
     * @return el nombre del ejercicio. ej: c:/...../ejercicio_1.txt  --->  ejercicio_1.txt
     */
    private static String getNombreEjercicio(String pathEj){
        String [] delimitador=pathEj.split("/");
        return delimitador[delimitador.length-1];
    }
    /**
     * metodo encargado de recorrer, detectar y guardar los literales a la tabla de literales.
     * @param lex Clase lexer donde esta el conjunto de simbolos segun el ejercicio.
     * @param pathEj direccion path de los ejercicios.
     * @param numEj numero del ejercicio, nesesario para la creacion de las keys de los literales.
     */
    private static void llenarLiterales(Lexer lex,String pathEj,int numEj){
        try {
            //ciclo usado para recorrer cada token del ejercicio.
            while (true) {
                //creo la variable de simbolo.
                Symbol text;
                //obtengo el token .
                text = lex.next_token();
                //condicionante usado si el token llego a EOF (Final de archivo).
                switch(text.sym){
                    case 0:
                        System.out.println("llego al final de archivo");
                    //reseteo el lexer, de esta forma es posible volver a analizar pero en el parser.
                    lex.yyreset(new FileReader(pathEj));
                    //retorno a la compilacion..
                    return;
                    
                    case 31: //NUM.
                        //guardo el literal a la tabla de literales.
                        TablaLiterales.getInstancia().ingresarLiteral((String) text.value, numEj);
                        break;
                }//fin switch
                
            }//fin while.

        } catch (IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//fin funcion 'llenarLiterales'
    /**
     * Metodo utilizado para el proceso de compilacion de los ejercicios utilizando
     * las fases de analisis lexico y sintactico.
     * @param pathEjercicio la direccion del ejercicio a compilar
     * @param pathBase la direccion base del proyecto.
     * @param numEjercicio el numero actual del ejercicio a compilar.
     */
    public static void compilar(String pathEjercicio, String pathBase, int numEjercicio){
        System.out.println("Comienzo compilacion");
        File arch = new File(pathEjercicio);
        
        try{
            //generacion analisis lexico del ejercicio.
            Lexer lexer = new Lexer(new FileReader(arch));
            //ingreso los literales usados a la tabla de literales.
            llenarLiterales(lexer,pathEjercicio,numEjercicio);
            //generacion de parser para el analisis sintactico.
            Parser parser = new Parser(lexer);
            //generacion del arbol sintactico abstracto.
            Program programa = (Program) parser.parse().value;
            //creacion de objeto GrapherVisitor para la generacion de imagen del AST.
            GrapherVisitor grapher = new GrapherVisitor(pathBase,numEjercicio);
            //se inicia el recorrido del AST para la generacion de la imagen del arbol utilizando el patron visitor.
            grapher.visitar(programa);
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }//fin try.
    }//fin funcion compilar.
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //variable donde obtengo la direccion del proyecto.
        final String dir =System.getProperty("user.dir");
        //variable usada para guardar la direccion del archivo .flex
        String pathFlex=dir+"\\src\\scanner\\Lexer.flex";
        String pathParser=dir+"\\src\\parser\\Parser.cup";
        
        //se llama a la funcion de generacion de lexer. 
        generarLexer(pathFlex);
        //se llama a la funcion de generacion de parser.
        generarParser(pathParser);
        //se mueven los archivos a los paquetes correspondientes.
        move();
        //comienza compilacion de ejercicios.
        for(int i=0; i<2; i++)
            compilar(dir+"/ejemplo_"+(i+1)+".txt",dir,(i+1));
        
    }
    
}
