/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hiloscarrerataller;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * Clase hilo que va a llevar todas las funciones de los hilos
 * @author Johan Zambrano, Camilo Tinoco
 */
public class Hilo extends Thread {
    /**
     * Guarda la posicion inicial de cada atleta
     */
    int posicionInicial;
    /**
     * Guarda el número del jugador
     */
    int jugador;
    /**
     * Objeto de la clase Equipo, el objeto en comun
     */
    Equipo equipo;
    /**
     * Objeto de la clase Ventana, JFrame, se encarga de pintar graficamente la carrera
     */
    final Ventana panel;
    /**
     * Constructor principal 
     * @param panel recibe el Jframe de la clase Ventana, para ir modificando
     * @param posicion posicion inicial del atleta
     * @param jugador numero del atleta
     * @param equipo número del equipo al que pertenece el atleta
     */
    public Hilo(Ventana panel, int posicion, int jugador, Equipo equipo) {
        this.posicionInicial = posicion;
        this.jugador = jugador;
        this.equipo = equipo;
        this.panel = panel;
    }

    /**
     * Sobre escribe la función principal, ejectua el hilo
     */
    @Override
    public void run() {
        if (posicionInicial == 0) {
            inicio(1);
        } else if (posicionInicial == 333) {
            inicio(2);
        } else if (posicionInicial == 666) {
            inicio(3);
        } else {
            dormirHilo();
        }

    }
    /**
     * Se encarga de enviar la coordenada a la clase Ventana para mover el atleta
     */
    private void mover() {
        if (equipo.equipo == 1) {
            if (jugador == 1) {
                this.panel.ubicacionEquipo1J1(equipo.getPosicion());
            }
            if (jugador == 2) {
                this.panel.ubicacionEquipo1J2(equipo.getPosicion());
            }
            if (jugador == 3) {
                this.panel.ubicacionEquipo1J3(equipo.getPosicion());
            }
        }
        if (equipo.equipo == 2) {
            if (jugador == 1) {
                this.panel.ubicacionEquipo2J1(equipo.getPosicion());
            }
            if (jugador == 2) {
                this.panel.ubicacionEquipo2J2(equipo.getPosicion());
            }
            if (jugador == 3) {
                this.panel.ubicacionEquipo2J3(equipo.getPosicion());
            }
        }
        if (equipo.equipo == 3) {
            if (jugador == 1) {
                this.panel.ubicacionEquipo3J1(equipo.getPosicion());
            }
            if (jugador == 2) {
                this.panel.ubicacionEquipo3J2(equipo.getPosicion());
            }
            if (jugador == 3) {
                this.panel.ubicacionEquipo3J3(equipo.getPosicion());
            }
        }
    }
    /**
     * Suma el avance del atleta, es una funcion sincronizada
     * @return la suma que debe avanzar el atleta
     */
    private synchronized int suma() {
        try {
            sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        int distancia = 0;
        int jugador = equipo.imprimirUbicacion();
        if (jugador == 1) {
            if (equipo.getPosicion() >= 0 && equipo.getPosicion() <= 333) {
                do {
                    equipo.getPosicion();
                    distancia = (int) (Math.random() * 30 + 1);
                } while ((equipo.getPosicion() + distancia) > 333);
            }
        }
        if (jugador == 2) {
            if (equipo.getPosicion() >= 333 && equipo.getPosicion() <= 666) {
                do {
                    equipo.getPosicion();
                    distancia = (int) (Math.random() * 30 + 1);
                } while ((equipo.getPosicion() + distancia) > 666);
            }
        }
        if (jugador == 3) {
            if (equipo.getPosicion() >= 666 && equipo.getPosicion() <= 1000) {
                do {
                    equipo.getPosicion();
                    distancia = (int) (Math.random() * 30 + 1);
                } while ((equipo.getPosicion() + distancia) > 999);
            }
        }
        equipo.setPosicion(equipo.getPosicion() + distancia);

        mover();
        return equipo.getPosicion();
    }
    /**
     * Se encarga de dormir el hilo que no este activo en la carrera
     */
    public void dormirHilo() {
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * Funcion que recibe el atleta y llama la funcion sumar para correr en caso de que sea su turno
     * @param jugador numero del atleta que de estar corriendo
     */
    private synchronized void inicio(int jugador) {
        while (true) {
            if (jugador == 1) {
                int suma = suma();
                if (suma >= 333) {
                    synchronized (equipo) {
                        equipo.notifyAll();
                    }
                    break;
                }
            } else {
                if (jugador == 2) {
                    int suma = suma();
                    if (suma >= 666) {
                        synchronized (equipo) {
                            equipo.notifyAll();
                        }
                        break;
                    }
                } else {
                    if (jugador == 3) {
                        int suma = suma();
                        if (suma >= 999) {

                        }
                    }
                }
            }
        }
    }
}
