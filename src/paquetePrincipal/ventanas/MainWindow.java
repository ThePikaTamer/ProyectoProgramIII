package paquetePrincipal.ventanas;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import baseDeDatos.GestorBaseDatos;
import paquetePrincipal.MotorJuego;
import paquetePrincipal.ventanas.puntuacionesJTable.pruebasJtable;

public class MainWindow extends JFrame {
	protected MainWindow ventana = this;
	public MainWindow(MotorJuego motor) {
		if(motor != null) {
			motor.dispose();
			 JOptionPane option = new JOptionPane();
			 option.setVisible(true);
			 if(motor.finDeJuego == 1) {
				 option.showMessageDialog(option, "VICTORIA - PARTIDA AÑADIDA A BASE DE DATOS"); 
			 }else if(motor.finDeJuego == -1) {
				 option.showMessageDialog(option, "DERROTA - PRUEBA OTRA VEZ");
			 }
			 
			
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setTitle("Asteroids");
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(4, 3));
		JButton botonJugar = new JButton("Jugar");
		JButton botonOptions = new JButton("Opciones");
		JButton botonStop = new JButton("Salir");
		JButton botonPuntuaciones = new JButton("Puntuaciones");

		this.add(panel);

		panel.add(botonJugar);
		panel.add(botonOptions);
		panel.add(botonPuntuaciones);
		panel.add(botonStop);
		

		botonJugar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaJuego();
				dispose();

			}
		});
		botonOptions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaOpciones(motor);
				dispose();

			}
		});
		
		botonPuntuaciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new pruebasJtable(new GestorBaseDatos(), ventana);
				dispose();
			}
		});
		
		
		botonStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		setVisible(true);

	}
}
