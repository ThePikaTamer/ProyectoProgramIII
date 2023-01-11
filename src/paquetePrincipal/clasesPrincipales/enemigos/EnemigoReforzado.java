package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.image.BufferedImage;

import graficos.Assets;
import paquetePrincipal.Puntuacion;

public class EnemigoReforzado extends Enemigo {
	protected static BufferedImage IMG = Assets.enemigoReforzado;
	protected static BufferedImage IMG1 = Assets.enemigoReforzado1;
	
	private final static double RADIO_EN = 20;
	private final static int VIDA = 4;
	private final static double DANYO = 1;
	private final static double VEL_X = 1;
	private final static double VEL_Y = 1;
	private final static Puntuacion PUNT = new Puntuacion(750);
	public EnemigoReforzado() {
		super(VIDA, DANYO, VEL_X, VEL_Y, RADIO_EN, IMG,PUNT );
		this.getCicloAnimacion().add(IMG);
		this.getCicloAnimacion().add(IMG1);

	}

}
