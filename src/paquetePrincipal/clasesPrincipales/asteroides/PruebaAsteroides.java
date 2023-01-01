package paquetePrincipal.clasesPrincipales.asteroides;

import javax.swing.JFrame;
import javax.swing.JPanel;

import paquetePrincipal.ventanas.VentanaJuego;

public class PruebaAsteroides {

	public static void main(String[] args) {
		JFrame ventanaPruebas = new JFrame();
	ventanaPruebas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	ventanaPruebas.setSize(200, 200);
	ventanaPruebas.setLocation(50, 50);
	//ventanaPruebas.setVisible(true);
	JPanel panel = new JPanel();
	ventanaPruebas.add(panel);
	
	new VentanaJuego();
	
	AsteroideBasico ab1 = new AsteroideBasico();
	

}
}

