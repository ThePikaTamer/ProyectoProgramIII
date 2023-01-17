package paquetePrincipal.clasesPrincipales.PowerUps;

import java.awt.Point;
import java.awt.image.BufferedImage;

import graficos.Assets;

public class PowerUpHp extends PowerUp {

	protected static BufferedImage IMG = Assets.PowerUpHp;
	private final static double anchuraPowerUp = 2;
	private final static double alturaPowerUp = 2;
	private final static int x = 2;
	private final static int y= 2;
	private final static int velocidad = 1;
	private final static double RADIO_EN = 15;
	private static int cura  = 1;

	public PowerUpHp(int cura) {
		super( IMG, x, y, new Point(0, 0), velocidad);
		this.cura = 1;
		
	}
	
	public void Curar() {
		
	}

}
