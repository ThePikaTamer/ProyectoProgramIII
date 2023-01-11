package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import graficos.Assets;
import paquetePrincipal.Puntuacion;

public class EnemigoBasico extends Enemigo {

	protected static BufferedImage IMG = Assets.enemigoBasico;
	protected static BufferedImage IMG1 = Assets.enemigoBasico1;
	
	private final static double RADIO_EN = 16;
	private final static int VIDA = 2;
	private final static double DANYO = 1;
	private final static double VEL_X = 2;
	private final static double VEL_Y = 2;
	private final static Puntuacion PUNT = new Puntuacion(500);
	public EnemigoBasico() {
		super(VIDA, DANYO, VEL_X, VEL_Y, RADIO_EN, IMG,PUNT );
		this.getCicloAnimacion().add(IMG);
		this.getCicloAnimacion().add(IMG1);
	}

}
