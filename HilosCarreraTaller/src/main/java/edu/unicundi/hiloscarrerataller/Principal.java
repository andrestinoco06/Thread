/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hiloscarrerataller;

/**
 * Clase que pone en funcionamiento el programa una vez haya sido invocado
 * @author Johan Zambrano, Camilo Tinoco
 */
public class Principal {
    /**
     * Constructor principal
     */
    public Principal(){
        inicio();
    }
    /**
     * Invoca la clase Ventana para empezar a pintar
     */
    public void inicio(){
        Ventana v = new Ventana();
        v.setVisible(true); //se hace visible la ventana
    }
}
