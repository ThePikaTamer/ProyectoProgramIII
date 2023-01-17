package paquetePrincipal.ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import baseDeDatos.Usuario;
import paquetePrincipal.MotorJuego;


public class VentanaUsuario extends JFrame
{
	public VentanaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1333, 750);
		setTitle("Seleccion nave");
		setLocationRelativeTo(null);
		JButton boton1 = new JButton("1 Jugador");

		JButton boton2 = new JButton("2 Jugadores");

		
		JPanel panelCentral = new JPanel();// panel para poner la seleccion de naves de los dos jugadores
		panelCentral.setLayout(new GridLayout(2, 1));

//JUGADOR 1 SELECCION DE NAVE
		JPanel panelJugador1 = new JPanel(new BorderLayout());
		JPanel panelSeleccionJugador1 = new JPanel(new GridLayout(1, 4));
		panelSeleccionJugador1.add(boton1);
		JPanel nombreJugador1 = new JPanel(new GridLayout(1, 2));
		JTextField mote1=new JTextField();
		JTextField correo1=new JTextField();

		JPanel nickName = new JPanel(new BorderLayout());
		nickName.add(new JLabel("NickName: "), BorderLayout.WEST);
		nickName.add(mote1, BorderLayout.CENTER);
		JPanel mail = new JPanel(new BorderLayout());
		mail.add(new JLabel(" E-mail: "), BorderLayout.WEST);
		mail.add(correo1, BorderLayout.CENTER);

		nombreJugador1.add(new Label("JUGADOR 1"));
		nombreJugador1.add(nickName);
		nombreJugador1.add(mail);
		panelJugador1.add(nombreJugador1, BorderLayout.NORTH);
		panelJugador1.add(panelSeleccionJugador1, BorderLayout.CENTER);

//JUGADOR 2 SELECCION DE NAVE
		JPanel panelJugador2 = new JPanel(new BorderLayout());
		JPanel panelSeleccionJugador2 = new JPanel(new GridLayout(1, 4));
		panelSeleccionJugador2.add(boton2);
		JPanel nombreJugador2 = new JPanel(new GridLayout(1, 2));
		JTextField mote2=new JTextField();
		JTextField correo2=new JTextField();

		JPanel nickName2 = new JPanel(new BorderLayout());
		nickName2.add(new JLabel("NickName: "), BorderLayout.WEST);
		nickName2.add(mote2, BorderLayout.CENTER);
		JPanel mail2 = new JPanel(new BorderLayout());
		mail2.add(new JLabel(" E-mail: "), BorderLayout.WEST);
		mail2.add(correo2, BorderLayout.CENTER);


		nombreJugador2.add(new Label("JUGADOR 2"));
		nombreJugador2.add(nickName2);
		nombreJugador2.add(mail2);
		panelJugador2.add(nombreJugador2, BorderLayout.NORTH);
		panelJugador2.add(panelSeleccionJugador2, BorderLayout.CENTER);

		////////////////////////////////
		boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mote1.getText().isEmpty()&&!correo1.getText().isEmpty())
				{
					Usuario us1 = new Usuario(6666, mote1.getText(), correo1.getText(), LocalDate.now());
					new VentanaSeleccion(false, us1, null);
					dispose();
				}
				else
				System.out.println("Put a name and mail");
			}
		});
		boton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mote1.getText().isEmpty()&&!correo1.getText().isEmpty()&&!mote2.getText().isEmpty()&&!correo2.getText().isEmpty())
				{
					Usuario us1 = new Usuario(9999, mote1.getText(), correo1.getText(), LocalDate.now());
					Usuario us2 = new Usuario(9999, mote2.getText(), correo2.getText(), LocalDate.now());
					new VentanaSeleccion(true, us1, us2);
					dispose();
				}
				else
				System.out.println("Put a name and mail");
			}
		});
		
		////////////////////////////////
		
//A�ADIRLOS AL PANEL CENTRAL
		panelCentral.add(panelJugador1);
		panelCentral.add(panelJugador2);
		this.getContentPane().add(panelCentral, BorderLayout.CENTER);

		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));

		this.getContentPane().add(panelInferior, BorderLayout.SOUTH);

		setVisible(true);
	}
}
