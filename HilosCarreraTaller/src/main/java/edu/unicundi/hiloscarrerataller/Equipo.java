/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hiloscarrerataller;

/**
 * Clase comun para los hilos, tienen el número del equipo y la posicion en la que va el equipo en el momento de la carrera
 * @author Johan Zambrano, Camilo Tinoco
 */
public class Equipo {
    /**
     * Guarda el número del equipo
     */
    public int equipo;
    /**
     * Guarda la posición del equipo en el momento de la carrera
     */
    public int posicion;
    
    /**
     * Constructor principal
     * @param equipo Guarda el número del equipo
     */
    public Equipo(int equipo){
        this.equipo = equipo;
        this.posicion = 0;
    }

    /**
     * Evento sincronizado, retorna el atleta que debe estar corriendo en la carrera de acuerdo a la posicion del equipo
     * @return atleta que debe estar corriendo
     */
    public synchronized int imprimirUbicacion(){        
        int jugador=0;
        if(getPosicion()<=333){
            jugador = 1;
        }
        if(getPosicion()>=333 && getPosicion()<=666){
            jugador = 2;
        }
        if(getPosicion()>=666 && getPosicion()<=1000){
            jugador = 3;
        }
        return jugador;
    }
    
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
}
