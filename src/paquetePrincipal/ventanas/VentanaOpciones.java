//package paquetePrincipal.ventanas;
//
//import java.awt.BorderLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//import Controles.Teclado;
//import paquetePrincipal.MotorJuego;
//
//public class VentanaOpciones extends JFrame {
//	
//	
//	public VentanaOpciones(MotorJuego motor) {
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(1800, 1000);
//		setTitle("Menu - Opciones");
//		
//		setLocationRelativeTo(null);
//
//		JPanel panel = new JPanel();
//
//		panel.setLayout(new GridLayout(4, 3));
//		JButton botonBACK = new JButton("BACK");
//		JButton botonPuntuaciones = new JButton("RESOLUCION");
//		JButton botonSalir = new JButton("Salir");
//		this.add(panel);
//
//		
//		panel.add(botonOptions);
//		panel.add(botonPuntuaciones);
//		panel.add(botonSalir);
//		
//
//		botonContinuar.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				motor.setpausado(false);
//				
//
//			}
//		});
//		
//		setVisible(true);
//		
//	}
//}
