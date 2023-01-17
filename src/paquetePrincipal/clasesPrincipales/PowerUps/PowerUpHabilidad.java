package paquetePrincipal.clasesPrincipales.PowerUps;

import java.awt.Point;
import java.awt.image.BufferedImage;

import graficos.Assets;

public class PowerUpHabilidad extends PowerUp {

	protected static BufferedImage IMG = Assets.PowerUpHabilidad;
	private final static double anchuraPowerUp = 2;
	private final static double alturaPowerUp = 2;
	private final static int x = 2;
	private final static int y= 2;
	private final static int velocidad = 1;
	private final static double RADIO_EN = 15;
	private int duration = 10;

	public PowerUpHabilidad(int duration) {
		super( IMG, x, y, new Point(0, 0), velocidad);
		this.duration = 10;
		
	}
	
	public void AumentarDano() {
		
	}
}
