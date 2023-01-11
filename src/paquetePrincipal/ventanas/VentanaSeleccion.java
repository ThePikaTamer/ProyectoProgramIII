package paquetePrincipal.ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import paquetePrincipal.CategoriaJugador;
import paquetePrincipal.MotorJuego;
import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;
import paquetePrincipal.clasesPrincipales.Naves.NaveDRapido;
import paquetePrincipal.clasesPrincipales.Naves.NaveVeloz;

public class VentanaSeleccion extends JFrame {
	public VentanaSeleccion(boolean pl2Selected) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setTitle("Seleccion nave");
		setLocationRelativeTo(null);

		JButton boton1 = new JButton("Nave1");
		JButton boton2 = new JButton("Nave2");
		JButton boton3 = new JButton("Nave3");
		JButton boton4 = new JButton("Nave4");

		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);

		setLayout(new GridLayout(2, 2));

		boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pl2Selected==false)
				{
					//new MotorJuego("My Game", 0, null, null).setDobleJugador(false);
					//new MotorJuego("Game", 0, new NaveBasica(null, CategoriaJugador.PLAYER1), new NaveDRapido(args, CategoriaJugador.PLAYER2));
					new MotorJuego("Asteroids", 0, new NaveBasica(null, CategoriaJugador.PLAYER1), null, false);
					dispose();
				}
				
				else
				{
					new VentanaSeleccionPl2();
					dispose();
				}

			}
		});
		boton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pl2Selected==false)
				{
					//new MotorJuego("My Game", 0, null, null).setDobleJugador(false);
					//new MotorJuego("Game", 0, new NaveBasica(null, CategoriaJugador.PLAYER1), new NaveDRapido(args, CategoriaJugador.PLAYER2));
					new MotorJuego("Asteroids", 0, new NaveDRapido(null, CategoriaJugador.PLAYER1), null, false);
					dispose();
				}
				
				else
				{
					new VentanaSeleccionPl2();
					dispose();
				}

			}
		});
		boton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pl2Selected==false)
				{
					//new MotorJuego("My Game", 0, null, null).setDobleJugador(false);
					//new MotorJuego("Game", 0, new NaveBasica(null, CategoriaJugador.PLAYER1), new NaveDRapido(args, CategoriaJugador.PLAYER2));
					new MotorJuego("Asteroids", 0, new NaveVeloz(null, CategoriaJugador.PLAYER1), null, false);
					dispose();
				}
				
				else
				{
					new VentanaSeleccionPl2();
					dispose();
				}

			}
		});

		setVisible(true);
	}
}
