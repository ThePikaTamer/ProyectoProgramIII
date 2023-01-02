package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import graficos.Assets;

public class EnemigoBasico extends Enemigo {

	protected static BufferedImage IMG = Assets.enemigoBasico;
	protected static BufferedImage IMG1 = Assets.enemigoBasico1;
	
	private final static double RADIO_NAVE = 20;
	private final static int VIDA = 2;
	private final static double VEL_DISP = 2;
	private final static double VEL_MAX = 3;
	private final static double VEL_ROT = 0.1;
	public EnemigoBasico() {
		super(2, 1, 2, 2, 16, IMG);
		this.getCicloAnimacion().add(IMG);
		this.getCicloAnimacion().add(IMG1);
	}

}
