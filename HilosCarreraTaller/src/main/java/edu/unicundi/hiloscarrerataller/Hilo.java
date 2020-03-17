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
 *
 * @author johan
 */
public class Hilo extends Thread {

    int posicionInicial, jugador;
    Equipo equipo;
    final Ventana panel;

    public Hilo(Ventana panel, int posicion, int jugador, Equipo equipo) {
        this.posicionInicial = posicion;
        this.jugador = jugador;
        this.equipo = equipo;
        this.panel = panel;
    }

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

    public void dormirHilo() {
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

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
    /*try {
     long a = (long) (Math.random() * 10000 + 1000);
     System.out.println(" ----- " + a + " -----");
     Hilo.sleep(a);
     } catch (InterruptedException e) {
     System.out.println(" Se totio " + getName());
     }*/
}
