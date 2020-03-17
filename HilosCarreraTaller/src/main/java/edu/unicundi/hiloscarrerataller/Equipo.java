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
public class Equipo {
    
    public int equipo;
    
    public int posicion;
    
    public Equipo(int equipo){
        this.equipo = equipo;
        this.posicion = 0;
    }

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
