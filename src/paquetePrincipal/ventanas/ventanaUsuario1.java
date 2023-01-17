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

import baseDeDatos.GestorBaseDatos;
import baseDeDatos.Usuario;

public class ventanaUsuario1 extends JFrame
{
	public ventanaUsuario1()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(1800, 1000);
		setSize(1800, 500);
		setTitle("Seleccion nave");
		setLocationRelativeTo(null);
		JButton boton1 = new JButton("Seleccionar nave -->");
		
		JPanel panelCentral = new JPanel();// panel para poner la seleccion de naves de los dos jugadores
		panelCentral.setLayout(new GridLayout(2, 1));


		JPanel panelJugador1 = new JPanel(new BorderLayout());
		JPanel panelSeleccionJugador1 = new JPanel();
		panelSeleccionJugador1.add(boton1);
		//////////////
		
		JPanel nombreJugador1 = new JPanel(new GridLayout(4, 1));
		JTextField mote1=new JTextField();
		JTextField correo1=new JTextField();
		JTextField fecha1=new JTextField();

		JPanel nickName = new JPanel(new BorderLayout());
		nickName.add(new JLabel("NickName: "), BorderLayout.WEST);
		nickName.add(mote1, BorderLayout.CENTER);
		JPanel mail = new JPanel(new BorderLayout());
		mail.add(new JLabel("E-mail: "), BorderLayout.WEST);
		mail.add(correo1, BorderLayout.CENTER);
		JPanel fechaN = new JPanel(new BorderLayout());
		fechaN.add(new JLabel("Fecha nacimiento: (formato YYYY-MM-DD)"), BorderLayout.WEST);
		fechaN.add(fecha1, BorderLayout.CENTER);

		nombreJugador1.add(new Label("Inserta tus datos de usuario."));
		nombreJugador1.add(nickName);
		nombreJugador1.add(mail);
		nombreJugador1.add(fechaN);
		panelJugador1.add(nombreJugador1, BorderLayout.NORTH);
		panelJugador1.add(panelSeleccionJugador1, BorderLayout.SOUTH);
		
		///////
		GestorBaseDatos gBD=new GestorBaseDatos();
		
		////
		boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mote1.getText().isEmpty()&&!correo1.getText().isEmpty()&&!fecha1.getText().isEmpty())
				{
					Usuario us1 = new Usuario(0000, mote1.getText(), correo1.getText(), LocalDate.now());//, fecha1.getText());
					new VentanaSeleccion(false, us1, null);
					dispose();
				}
				else
				System.out.println("Put a name and mail");
			}
		});
		
		//////////////
		panelCentral.add(panelJugador1);
		this.getContentPane().add(panelCentral, BorderLayout.CENTER);

		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));

		this.getContentPane().add(panelInferior, BorderLayout.SOUTH);

		setVisible(true);
	}
}
