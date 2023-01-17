package paquetePrincipal.ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import paquetePrincipal.MotorJuego;

public class VentanaMenu extends JFrame {

	public VentanaMenu(MotorJuego motor) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setTitle("Menu - Pausa");
		
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(4, 3));
		JButton botonContinuar = new JButton("Continuar");
		JButton botonOptions = new JButton("Opciones");
		
		JButton botonPuntuaciones = new JButton("Puntuaciones");
		JButton botonSalir = new JButton("Salir");
		this.add(panel);

		panel.add(botonContinuar);
		panel.add(botonOptions);
		panel.add(botonPuntuaciones);
		panel.add(botonSalir);
		

		botonContinuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				motor.setpausado(false);
				
				dispose();
			}
		});
		
		setVisible(true);
		
	}
}
