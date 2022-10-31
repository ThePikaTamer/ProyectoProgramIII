package paquetePrincipal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame
{
	public MainWindow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setTitle("Asteroids");
		setLocationRelativeTo(null);
		
		JPanel panel=new JPanel();
		
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton botonJugar=new JButton("Jugar");
		JButton botonOptions=new JButton("Opciones");
		JButton botonStop=new JButton("Salir");
		this.add(panel);
		panel.add(botonJugar);
		panel.add(botonOptions);
		panel.add(botonStop);

		botonJugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new VentanaSeleccion();
				dispose();
				
			}
		});
		botonOptions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new VentanaOpciones();
				dispose();
				
			}
		});
		
		setVisible(true);
		
	}
}
