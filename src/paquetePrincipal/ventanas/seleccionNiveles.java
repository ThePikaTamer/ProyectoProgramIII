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

public class seleccionNiveles extends JFrame {
	public seleccionNiveles(boolean pl2Selected, Usuario us1, Usuario us2, NaveBase nPl1, NaveBase nPl2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1333, 750);
		setTitle("Seleccion nivel");
		setLocationRelativeTo(null);
		JButton boton0 = new JButton("Nivel 0");
		JButton boton1 = new JButton("Nivel 1");
		JButton boton2 = new JButton("Nivel 2");
		JButton boton3 = new JButton("Nivel 3");
		add(boton0);
		add(boton1);
		add(boton2);
		add(boton3);

		setLayout(new GridLayout(1, 3));

		boton0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MotorJuego("Asteroids", 3, nPl1, nPl2, us1, us2, pl2Selected);
					dispose();

			}
		});
		
		boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MotorJuego("Asteroids", 0, nPl1, nPl2, us1, us2, pl2Selected);
					dispose();

			}
		});
		boton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MotorJuego("Asteroids", 1, nPl1, nPl2, us1, us2, pl2Selected);
					dispose();

			}
		});
		boton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MotorJuego("Asteroids", 2, nPl1, nPl2, us1, us2, pl2Selected);
					dispose();

			}
		});

		setVisible(true);
	}
}
