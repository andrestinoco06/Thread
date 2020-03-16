/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hiloscarrerataller;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johan
 */
public class Hilo extends Thread {

    int numero;
    int equipo, jugador;
    
    public Hilo(int n, String nombre) {
        super(nombre);
        numero = n;
    }

    public Hilo(ObjetoComun oc){
        this.equipo = oc.equipo;
        this.jugador = oc.jugador; 
    }
    @Override
    public void run() {
        //inicio();
        byte paso = hola();
        
    }

    private void inicio() {
        if(equipo==1){
            if(jugador==1){
                for(int i=0;i<3;i++){
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try{
                        
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
        
        
        /*try {
            long a = (long) (Math.random() * 10000 + 1000);
            System.out.println(" ----- " + a + " -----");
            Hilo.sleep(a);
        } catch (InterruptedException e) {
            System.out.println(" Se totio " + getName());
        }*/
    }

    private byte hola() {
        byte a = 0;
        for (int i = 0; i < 10; i++) {
            try {
                a = (byte) (Math.random() * 3 + 1);                
                System.out.println(" -->  "+a);
                Hilo.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(" Se totio " + getName());
            }
        }
        return a;
    }

}
