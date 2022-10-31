package paquetePrincipal.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame {
	public VentanaJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setTitle("Asteroids");
		setLocationRelativeTo(null);
		
		JButton boton1Jugador = new JButton("1 Jugador");
		JButton boton2Jugadores = new JButton("2 Jugadores");
		JButton botonReturn = new JButton("Opciones");
		JPanel panelJugadores = new JPanel();
		panelJugadores.setLayout(new GridLayout(1,2));
		
		boton1Jugador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				new Ventana1Jugador();
				dispose();
				
				
			}
		});
	boton1Jugador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				new Ventana2Jugadores();
				dispose();
				
				
			}
		});
	boton1Jugador.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
//			new MainWindow();
			dispose();
			
			
		}
	});
		
		
		
		
		this.getContentPane().add(panelJugadores);
		panelJugadores.add(boton1Jugador, BorderLayout.WEST);
		panelJugadores.add(boton2Jugadores, BorderLayout.EAST);
		this.getContentPane().add(botonReturn, BorderLayout.SOUTH);
		
		
		
		this.setVisible(true);
		
		
	}

}
