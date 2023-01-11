package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.image.BufferedImage;

import graficos.Assets;
import paquetePrincipal.Puntuacion;

public class EnemigoVeloz extends Enemigo {
	protected static BufferedImage IMG = Assets.enemigoVeloz;
	protected static BufferedImage IMG1 = Assets.enemigoVeloz;
	private final static double RADIO_EN = 16;
	private final static int VIDA = 1;
	private final static double DANYO = 2;
	private final static double VEL_X = 3;
	private final static double VEL_Y = 3;
	private final static Puntuacion PUNT = new Puntuacion(750);
	public EnemigoVeloz() {
		super(VIDA, DANYO, VEL_X, VEL_Y, RADIO_EN, IMG,PUNT );
		this.getCicloAnimacion().add(IMG);
		this.getCicloAnimacion().add(IMG1);
	}

}
