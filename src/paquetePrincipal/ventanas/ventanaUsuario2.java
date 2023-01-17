package paquetePrincipal.ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import baseDeDatos.GestorBaseDatos;
import baseDeDatos.Usuario;

public class ventanaUsuario2 extends JFrame
{
	public ventanaUsuario2()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1333, 750);
		setTitle("Seleccion nave");
		setLocationRelativeTo(null);
		JButton boton1 = new JButton("Seleccionar naves -->");
		
		JPanel panelCentral = new JPanel();// panel para poner la seleccion de naves de los dos jugadores
		panelCentral.setLayout(new GridLayout(2, 1));


		//////////////jugador 1
		JPanel panelJugador1 = new JPanel(new BorderLayout());
		JPanel panelSeleccionJugador1 = new JPanel();
		//panelSeleccionJugador1.add(boton1);
		
		JPanel nombreJugador1 = new JPanel(new GridLayout(4, 1));	
		JPanel calendarioJugador1 = new JPanel();
		JTextField mote1=new JTextField();
		JTextField correo1=new JTextField();
		//JTextField fecha1=new JTextField();

		JPanel nickName = new JPanel(new BorderLayout());
		nickName.add(new JLabel(" NickName: "), BorderLayout.WEST);
		nickName.add(mote1, BorderLayout.CENTER);
		JPanel mail = new JPanel(new BorderLayout());
		mail.add(new JLabel("         E-mail: "), BorderLayout.WEST);
		mail.add(correo1, BorderLayout.CENTER);
		//JPanel fechaN = new JPanel(new BorderLayout());
		//fechaN.add(new JLabel("Fecha nacimiento: (formato YYYY-MM-DD)"), BorderLayout.WEST);
		//fechaN.add(fecha1, BorderLayout.CENTER);
		JCalendar fechaN= new JCalendar();

		
		nombreJugador1.add(new Label("Inserta los datos de usuario del jugador 1."));
		nombreJugador1.add(nickName);
		nombreJugador1.add(mail);
		calendarioJugador1.add(fechaN);
		panelJugador1.add(nombreJugador1, BorderLayout.NORTH);
		panelJugador1.add(calendarioJugador1, BorderLayout.CENTER);
		panelJugador1.add(panelSeleccionJugador1, BorderLayout.SOUTH);
		
		///////

		//////////////jugador 2
		JPanel panelJugador2 = new JPanel(new BorderLayout());
		JPanel panelSeleccionJugador2 = new JPanel();
		panelSeleccionJugador2.add(boton1);
		
		JPanel nombreJugador2 = new JPanel(new GridLayout(4, 1));
		JPanel calendarioJugador2 = new JPanel();
		JTextField mote2=new JTextField();
		JTextField correo2=new JTextField();
		JTextField fecha2=new JTextField();

		JPanel nickName2 = new JPanel(new BorderLayout());
		nickName2.add(new JLabel(" NickName: "), BorderLayout.WEST);
		nickName2.add(mote2, BorderLayout.CENTER);
		JPanel mail2 = new JPanel(new BorderLayout());
		mail2.add(new JLabel("         E-mail: "), BorderLayout.WEST);
		mail2.add(correo2, BorderLayout.CENTER);
//		JPanel fechaN2 = new JPanel(new BorderLayout());
//		fechaN2.add(new JLabel("Fecha nacimiento: (formato YYYY-MM-DD)"), BorderLayout.WEST);
//		fechaN2.add(fecha2, BorderLayout.CENTER);
		JCalendar fechaN2= new JCalendar();

		nombreJugador2.add(new Label("Inserta los datos de usuario del jugador 2."));
		nombreJugador2.add(nickName2);
		nombreJugador2.add(mail2);
		calendarioJugador2.add(fechaN2);
		panelJugador2.add(nombreJugador2, BorderLayout.NORTH);
		panelJugador2.add(calendarioJugador2, BorderLayout.CENTER);
		panelJugador2.add(panelSeleccionJugador2, BorderLayout.SOUTH);
		
		///////
		GestorBaseDatos gBD=new GestorBaseDatos();
		
		////
		boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mote1.getText().isEmpty()&&!correo1.getText().isEmpty()&&!mote2.getText().isEmpty()&&!correo2.getText().isEmpty())
				{//todav�a no he implementado el id del ususario, est� as� para comprobar que funciona
					Usuario us1 = new Usuario(1111, mote1.getText(), correo1.getText(), fechaN.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());//, fecha1.getText());
					Usuario us2 = new Usuario(2222, mote2.getText(), correo2.getText(), fechaN2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());//, fecha2.getText());
					new VentanaSeleccion(true, us1, us2);
					dispose();
				}
				else
				System.out.println("Put a name and mail");
			}
		});
		
		//////////////
		panelCentral.add(panelJugador1);
		panelCentral.add(panelJugador2);
		this.getContentPane().add(panelCentral, BorderLayout.CENTER);

		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));

		this.getContentPane().add(panelInferior, BorderLayout.SOUTH);

		setVisible(true);
	}
}
