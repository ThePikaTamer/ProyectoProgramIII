package paquetePrincipal.clasesPrincipales.PowerUps;

import java.awt.Point;
import java.awt.image.BufferedImage;

import graficos.Assets;

public class PowerUpHp extends PowerUp {

	protected static BufferedImage IMG = Assets.asteroideBasico2;
	private final static double anchuraPowerUp = 2;
	private final static double alturaPowerUp = 2;
	private final static int x = 2;
	private final static int y= 2;
	private final static int velocidad = 3;

	public PowerUpHp() {
		super( anchuraPowerUp, alturaPowerUp, IMG, x, y, new Point(0, 0), velocidad);
		
	}

}
