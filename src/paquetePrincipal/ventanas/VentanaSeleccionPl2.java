package paquetePrincipal.ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import baseDeDatos.Usuario;
import paquetePrincipal.CategoriaJugador;
import paquetePrincipal.MotorJuego;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;
import paquetePrincipal.clasesPrincipales.Naves.NaveDRapido;
import paquetePrincipal.clasesPrincipales.Naves.NaveTanque;
import paquetePrincipal.clasesPrincipales.Naves.NaveVeloz;

public class VentanaSeleccionPl2 extends JFrame
{
	public VentanaSeleccionPl2(NaveBase jugador1, Usuario us1, Usuario us2) {
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
				//System.out.println("Pl2 ready");
				//new MotorJuego("Asteroids", 0, jugador1, new NaveBasica(null, CategoriaJugador.PLAYER2), us1, us2, true);
				new seleccionNiveles(true, us1, us2, jugador1, new NaveBasica(null, CategoriaJugador.PLAYER2));
				
				dispose();
			}
		});
		boton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new MotorJuego("Asteroids", 0, jugador1, new NaveDRapido(null, CategoriaJugador.PLAYER2), us1, us2, true);
				new seleccionNiveles(true, us1, us2, jugador1, new NaveBasica(null, CategoriaJugador.PLAYER2));
				
				dispose();

			}
		});
		boton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new MotorJuego("Asteroids", 0, jugador1, new NaveVeloz(null, CategoriaJugador.PLAYER2), us1, us2, true);
				new seleccionNiveles(true, us1, us2, jugador1, new NaveBasica(null, CategoriaJugador.PLAYER2));
				
				dispose();

			}
		});
		boton4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new MotorJuego("Asteroids", 0, jugador1, new NaveTanque(null, CategoriaJugador.PLAYER2), us1, us2, true);
				new seleccionNiveles(true, us1, us2, jugador1, new NaveBasica(null, CategoriaJugador.PLAYER2));
				
				dispose();

			}
		});
		

		setVisible(true);
	}
}
