/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import syntaxVisitor.GrapherVisitor;
/**
 *
 * @author jona
 */
public interface visitaNodo {
    public void aceptar(GrapherVisitor v);//cambiar visitor por clase Grapherviz
}
