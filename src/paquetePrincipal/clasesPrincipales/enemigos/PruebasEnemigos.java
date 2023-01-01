package paquetePrincipal.clasesPrincipales.enemigos;

import javax.swing.*;

import paquetePrincipal.ventanas.VentanaJuego;

import java.awt.*;

public class PruebasEnemigos {

	public static void main(String[] args) {
		JFrame ventanaPruebas = new JFrame();
		ventanaPruebas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaPruebas.setSize(200, 200);
		ventanaPruebas.setLocation(50, 50);
		// ventanaPruebas.setVisible(true);
		JPanel panel = new JPanel();
		ventanaPruebas.add(panel);

		new VentanaJuego();

		EnemigoBasico e1 = new EnemigoBasico();

	}

}
