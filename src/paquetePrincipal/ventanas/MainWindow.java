package paquetePrincipal.ventanas;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setTitle("Asteroids");
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(3, 3));
		JButton botonJugar = new JButton("Jugar");
		JButton botonOptions = new JButton("Opciones");
		JButton botonStop = new JButton("Salir");
		this.add(panel);

		panel.add(botonJugar);
		panel.add(botonOptions);
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
				new VentanaOpciones();
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
