package paquetePrincipal.clasesPrincipales.enemigos;

import javax.swing.*;
import java.awt.*;

public class PruebasEnemigos {

	public static void main(String[] args) {
			JFrame ventanaPruebas = new JFrame();
		ventanaPruebas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaPruebas.setSize(200, 200);
		ventanaPruebas.setLocation(50, 50);
		//ventanaPruebas.setVisible(true);
		JPanel panel = new JPanel();
		ventanaPruebas.add(panel);
		
		
		EnemigoBasico e1 = new EnemigoBasico();
		e1.inicializarEnemigo(ventanaPruebas.getWidth(), ventanaPruebas.getHeight());
		
		
	
		
		
		
	}
	
}
