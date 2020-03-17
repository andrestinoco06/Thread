/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hiloscarrerataller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Johan Zambrano, Camilo Tinoco
 * 
 */
public class Ventana extends JFrame {

    private JPanel panel;

    private JLabel equipo1J1, equipo1J2, equipo1J3;
    
    private JLabel equipo2J1, equipo2J2, equipo2J3;
    
    private JLabel equipo3J1, equipo3J2, equipo3J3;

    private Thread j1, j2, j3, j4, j5, j6, j7, j8,j9;
    
    public Ventana() {
        //Se establece el tamaño de la ventana
        this.setSize(1300, 500);
        //Estable la posicion para establecer la ventana sea en el centro para todas las pantallas
        setLocationRelativeTo(null);
        //Finaliza la ejecucion del programa cuando clickeo la X
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Establece un titulo para la ventana
        setTitle("Carrera Tapitas");
        //establece el color de la ventana
        getContentPane().setBackground(Color.gray);
        //inicia componenetes
        iniciarComponentes();
    }

    public Ventana(int jugador, int x, int y){
        if(jugador==1) {
            ubicacionEquipo1J1(x);
        }
        if(jugador==2){
            ubicacionEquipo1J2(x);
        }
        if(jugador==3){
            ubicacionEquipo1J3(x);
        }
    }
    
    private void iniciarComponentes() {
        creacionPanel();
        creacionBoton();
        creacionEscenario();
    }

    private void creacionEscenario() {
        lineaMeta();
        creacionEquipo1();
        creacionEquipo2();
        creacionEquipo3();
    }

    private void creacionPanel() {
        //Se crea el panel
        panel = new JPanel();
        //Desactiva los layouts predeterminados del pnale
        panel.setLayout(null);
        //Se agrega el panel al Jframe
        panel.setBackground(Color.lightGray);
        this.getContentPane().add(panel);
        //Se crea la etiqueta
        JLabel label = new JLabel(" ¡BIENVENIDO! ");
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        label.setBounds(650, 10, 100, 10);
        //se agrega la etiqueta al panel
        panel.add(label);
    }

    private void lineaMeta() {
        //Se crea una imagen para el equipo 1
        ImageIcon imagenEquipo1J1 = new ImageIcon("meta.jpg");
        //se crea una etiqueta para la imagen
        JLabel equipo1J1 = new JLabel();
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        equipo1J1.setBounds(989, 150, 10, 500);
        //Se estable el tamaño de la imagen
        equipo1J1.setIcon(new ImageIcon(imagenEquipo1J1.getImage().getScaledInstance(equipo1J1.getWidth(), equipo1J1.getHeight(), Image.SCALE_SMOOTH)));
        //Se agrega al panel
        panel.add(equipo1J1);
    }

    public void ubicacionEquipo1J1(int x1) {
        //Se modifica la posicion del JLabel
        this.equipo1J1.setLocation(x1, 150);
    }

    public void ubicacionEquipo1J2(int x1) {
        //Se modifica la posicion del JLabel
        this.equipo1J2.setLocation(x1, 150);
    }

    public void ubicacionEquipo1J3(int x1) {
        //Se modifica la posicion del JLabel
        this.equipo1J3.setLocation(x1, 150);
    }
    
    public void ubicacionEquipo2J1(int x1) {
        //Se modifica la posicion del JLabel
        this.equipo2J1.setLocation(x1, 250);
    }

    public void ubicacionEquipo2J2(int x1) {
        //Se modifica la posicion del JLabel
        this.equipo2J2.setLocation(x1, 250);
    }

    public void ubicacionEquipo2J3(int x1) {
        //Se modifica la posicion del JLabel
        this.equipo2J3.setLocation(x1, 250);
    }
    
    public void ubicacionEquipo3J1(int x1) {
        //Se modifica la posicion del JLabel
        this.equipo3J1.setLocation(x1, 350);
    }

    public void ubicacionEquipo3J2(int x1) {
        //Se modifica la posicion del JLabel
        this.equipo3J2.setLocation(x1, 350);
    }

    public void ubicacionEquipo3J3(int x1) {
        //Se modifica la posicion del JLabel
        this.equipo3J3.setLocation(x1, 350);
    }

    private void creacionEquipo1() {
        //Jugador 1
        //Se crea una imagen para el equipo 1
        ImageIcon imagenEquipo1J1 = new ImageIcon("equipo1-1.jpg");
        //se crea una etiqueta para la imagen
        equipo1J1 = new JLabel();
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        equipo1J1.setBounds(0, 150, 50, 50);
        //Se estable el tamaño de la imagen
        equipo1J1.setIcon(new ImageIcon(imagenEquipo1J1.getImage().getScaledInstance(equipo1J1.getWidth(), equipo1J1.getHeight(), Image.SCALE_SMOOTH)));
        //Se agrega al panel
        panel.add(equipo1J1);

        //Jugador 2
        //Se crea una imagen para el equipo 1
        ImageIcon imagenEquipo1J2 = new ImageIcon("equipo1-2.jpg");
        //se crea una etiqueta para la imagen
        equipo1J2 = new JLabel();
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        equipo1J2.setBounds(333, 150, 50, 50);
        //Se estable el tamaño de la imagen
        equipo1J2.setIcon(new ImageIcon(imagenEquipo1J2.getImage().getScaledInstance(equipo1J2.getWidth(), equipo1J2.getHeight(), Image.SCALE_SMOOTH)));
        //Se agrega al panel
        panel.add(equipo1J2);

        //Jugador 3
        //Se crea una imagen para el equipo 1
        ImageIcon imagenEquipo1J3 = new ImageIcon("equipo1-3.jpg");
        //se crea una etiqueta para la imagen
        equipo1J3 = new JLabel();
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        equipo1J3.setBounds(666, 150, 50, 50);
        //Se estable el tamaño de la imagen
        equipo1J3.setIcon(new ImageIcon(imagenEquipo1J3.getImage().getScaledInstance(equipo1J3.getWidth(), equipo1J3.getHeight(), Image.SCALE_SMOOTH)));
        //Se agrega al panel
        panel.add(equipo1J3);
    }

    private void creacionEquipo2() {
        //Se crea una imagen para el equipo 1
        ImageIcon imagenEquipo2 = new ImageIcon("equipo2-1.jpg");
        //se crea una etiqueta para la imagen
        equipo2J1 = new JLabel();
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        equipo2J1.setBounds(0, 250, 50, 50);
        //Se estable el tamaño de la imagen
        equipo2J1.setIcon(new ImageIcon(imagenEquipo2.getImage().getScaledInstance(equipo2J1.getWidth(), equipo2J1.getHeight(), Image.SCALE_SMOOTH)));
        //Se agrega al panel
        panel.add(equipo2J1);

        //Jugador 2
        //Se crea una imagen para el equipo 2
        ImageIcon imagenEquipo2J2 = new ImageIcon("equipo2-2.jpg");
        //se crea una etiqueta para la imagen
        equipo2J2 = new JLabel();
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        equipo2J2.setBounds(333, 250, 50, 50);
        //Se estable el tamaño de la imagen
        equipo2J2.setIcon(new ImageIcon(imagenEquipo2J2.getImage().getScaledInstance(equipo2J2.getWidth(), equipo2J2.getHeight(), Image.SCALE_SMOOTH)));
        //Se agrega al panel
        panel.add(equipo2J2);

        //Jugador 3
        //Se crea una imagen para el equipo 2
        ImageIcon imagenEquipo2J3 = new ImageIcon("equipo2-3.jpg");
        //se crea una etiqueta para la imagen
        equipo2J3 = new JLabel();
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        equipo2J3.setBounds(666, 250, 50, 50);
        //Se estable el tamaño de la imagen
        equipo2J3.setIcon(new ImageIcon(imagenEquipo2J3.getImage().getScaledInstance(equipo2J3.getWidth(), equipo2J3.getHeight(), Image.SCALE_SMOOTH)));
        //Se agrega al panel
        panel.add(equipo2J3);

    }

    private void creacionEquipo3() {
        //Se crea una imagen para el equipo 3
        ImageIcon imagenEquipo3 = new ImageIcon("equipo3-1.jpg");
        //se crea una etiqueta para la imagen
        equipo3J1 = new JLabel();
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        equipo3J1.setBounds(0, 350, 50, 50);
        //Se estable el tamaño de la imagen
        equipo3J1.setIcon(new ImageIcon(imagenEquipo3.getImage().getScaledInstance(equipo3J1.getWidth(), equipo3J1.getHeight(), Image.SCALE_SMOOTH)));
        //Se agrega al panel
        panel.add(equipo3J1);

        //Jugador 2
        //Se crea una imagen para el equipo 3
        ImageIcon imagenEquipo3J2 = new ImageIcon("equipo3-2.jpg");
        //se crea una etiqueta para la imagen
        equipo3J2 = new JLabel();
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        equipo3J2.setBounds(333, 350, 50, 50);
        //Se estable el tamaño de la imagen
        equipo3J2.setIcon(new ImageIcon(imagenEquipo3J2.getImage().getScaledInstance(equipo3J2.getWidth(), equipo3J2.getHeight(), Image.SCALE_SMOOTH)));
        //Se agrega al panel
        panel.add(equipo3J2);

        //Jugador 3
        //Se crea una imagen para el equipo 3
        ImageIcon imagenEquipo3J3 = new ImageIcon("equipo3-3.jpg");
        //se crea una etiqueta para la imagen
        equipo3J3 = new JLabel();
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        equipo3J3.setBounds(666, 350, 50, 50);
        //Se estable el tamaño de la imagen
        equipo3J3.setIcon(new ImageIcon(imagenEquipo3J3.getImage().getScaledInstance(equipo3J3.getWidth(), equipo3J3.getHeight(), Image.SCALE_SMOOTH)));
        //Se agrega al panel
        panel.add(equipo3J3);
    }

    private void creacionBoton() {
        //Se crea el boton 
        JButton boton = new JButton("Iniciar Carrera");
        //Se establece la posicion en el eje X y Y, se estable el tamaño del ancho y alto
        boton.setBounds(30, 40, 150, 30);
        //Se agrega al panel
        panel.add(boton);

        ActionListener accion = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                Equipo equipo1 = new Equipo(1);
                Equipo equipo2 = new Equipo(2);
                Equipo equipo3 = new Equipo(3);
                
                j1 = new Hilo(Ventana.this ,0,1,equipo1);
                j2 = new Hilo(Ventana.this,333,2,equipo1);
                j3 = new Hilo(Ventana.this,666,3,equipo1);
                j4 = new Hilo(Ventana.this ,0,1,equipo2);
                j5 = new Hilo(Ventana.this,333,2,equipo2);
                j6 = new Hilo(Ventana.this,666,3,equipo2);
                j7 = new Hilo(Ventana.this ,0,1,equipo3);
                j8 = new Hilo(Ventana.this,333,2,equipo3);
                j9 = new Hilo(Ventana.this,666,3,equipo3);
                j1.start();        
                j2.start();
                j3.start();
                j4.start();        
                j5.start();
                j6.start();
                j7.start();        
                j8.start();
                j9.start();
            }
        };

        boton.addActionListener(accion);
    }
}