package paquetePrincipal.ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import paquetePrincipal.MotorJuego;

public class VentanaSeleccion2 extends JFrame {

	protected boolean pl1Selected=false;
	protected boolean pl2Selected=false;
		
	public VentanaSeleccion2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setTitle("Seleccion nave");
		setLocationRelativeTo(null);
		JButton boton1 = new JButton("Nave1");
		JButton boton2 = new JButton("Nave2");
		JButton boton3 = new JButton("Nave3");
		JButton boton4 = new JButton("Nave4");

		/*JButton boton5 = new JButton("Nave1");
		JButton boton6 = new JButton("Nave2");
		JButton boton7 = new JButton("Nave3");
		JButton boton8 = new JButton("Nave4");*/
//		
		
//
//		setLayout(new GridLayout(2,2));
//		
		JPanel panelCentral = new JPanel();// panel para poner la seleccion de naves de los dos jugadores
		panelCentral.setLayout(new GridLayout(2, 1));

//JUGADOR 1 SELECCION DE NAVE
		JPanel panelJugador1 = new JPanel(new BorderLayout());
		JPanel panelSeleccionJugador1 = new JPanel(new GridLayout(1, 4));
		panelSeleccionJugador1.add(boton1);
		panelSeleccionJugador1.add(boton2);
		panelSeleccionJugador1.add(boton3);
		panelSeleccionJugador1.add(boton4);
		JPanel nombreJugador1 = new JPanel(new GridLayout(1, 2));

		JPanel nickName = new JPanel(new BorderLayout());
		nickName.add(new JLabel("NickName: "), BorderLayout.WEST);
		nickName.add(new JTextField(), BorderLayout.CENTER);

		nombreJugador1.add(new Label("JUGADOR 1"));
		nombreJugador1.add(nickName);
		panelJugador1.add(nombreJugador1, BorderLayout.NORTH);
		panelJugador1.add(panelSeleccionJugador1, BorderLayout.CENTER);

//JUGADOR 2 SELECCION DE NAVE
		/*JPanel panelJugador2 = new JPanel(new BorderLayout());
		JPanel panelSeleccionJugador2 = new JPanel(new GridLayout(1, 4));
		panelSeleccionJugador2.add(boton5);
		panelSeleccionJugador2.add(boton6);
		panelSeleccionJugador2.add(boton7);
		panelSeleccionJugador2.add(boton8);
		JPanel nombreJugador2 = new JPanel(new GridLayout(1, 2));

		JPanel nickName2 = new JPanel(new BorderLayout());
		nickName2.add(new JLabel("NickName: "), BorderLayout.WEST);
		nickName2.add(new JTextField(), BorderLayout.CENTER);

		nombreJugador2.add(new Label("JUGADOR 2"));
		nombreJugador2.add(nickName2);
		panelJugador2.add(nombreJugador2, BorderLayout.NORTH);
		panelJugador2.add(panelSeleccionJugador2, BorderLayout.CENTER);*/

//AÑADIRLOS AL PANEL CENTRAL
		panelCentral.add(panelJugador1);
		//panelCentral.add(panelJugador2);
		this.getContentPane().add(panelCentral, BorderLayout.CENTER);

		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));

//		panelInferior.add(boton1);
//		panelInferior.add(boton2);
//		panelInferior.add(boton3);
//		panelInferior.add(boton4);

		this.getContentPane().add(panelInferior, BorderLayout.SOUTH);

		///////////////Jugador 1
		boton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				pl1Selected=true;
				System.out.println("Pl1 ready");
				new MotorJuego("My Game").dobleJugador=true;
				
				dispose();
			}
		});
		

		///////////////Jugador 2
		/*boton5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				pl2Selected=true;
				System.out.println("Pl2 listo");
			}
		});
		
		if(pl1Selected==true&&pl2Selected==true)
		{
			new MotorJuego("My Game");
			dispose();
		}*/
		
		setVisible(true);

	}
}
