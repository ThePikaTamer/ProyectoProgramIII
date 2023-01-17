package paquetePrincipal.clasesPrincipales.asteroides;

import java.awt.Point;
import java.awt.image.BufferedImage;

import graficos.Assets;
import paquetePrincipal.Puntuacion;

public class AsteroideBasico extends Asteroide {
	protected static BufferedImage IMG = Assets.asteroideBasico;
	private final static double RADIO_EN = 25;
	private final static int VIDA = 1;
	private final static double DANYO_CHOQUE = 1;
	private final static double VEL_X = 2;
	private final static double VEL_Y = 2;
	private final static Puntuacion PUNT = new Puntuacion(500);
	public AsteroideBasico() {
		super( VIDA, DANYO_CHOQUE, IMG, new Point(0, 0),RADIO_EN, PUNT );
		
	}

}