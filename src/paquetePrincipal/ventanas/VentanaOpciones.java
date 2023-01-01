package paquetePrincipal.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import paquetePrincipal.MotorJuego;

public class VentanaOpciones extends JFrame {
	public MotorJuego juego;

	public VentanaOpciones() {
		this.juego = juego;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setTitle("Options");
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton botonReturn = new JButton("Return");
		this.add(panel);
		panel.add(botonReturn);

		botonReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		setVisible(true);
	}
}
