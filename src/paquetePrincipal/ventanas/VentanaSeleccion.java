package paquetePrincipal.ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaSeleccion extends JFrame
{
	public VentanaSeleccion()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setTitle("Seleccion nave");
		setLocationRelativeTo(null);

		JButton boton1=new JButton("Nave1");
		JButton boton2=new JButton("Nave2");
		JButton boton3=new JButton("Nave3");
		JButton boton4=new JButton("Nave4");
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);

		setLayout(new GridLayout(2,2));
		
		
		boton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new MainWindow();
				dispose();
			}
		});

		setVisible(true);
	}
}
