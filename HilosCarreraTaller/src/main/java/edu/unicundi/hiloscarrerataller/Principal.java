/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hiloscarrerataller;

/**
 *
 * @author johan
 */
public class Principal {
    public Principal(){
        inicio();
    }
    public void inicio(){
        Ventana v = new Ventana();
        v.setVisible(true); //se hace visible la ventana
    }
}
