package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.image.BufferedImage;

import graficos.Assets;

public class EnemigoReforzado extends Enemigo {
	protected static BufferedImage IMG = Assets.enemigoReforzado;
	protected static BufferedImage IMG1 = Assets.enemigoReforzado1;
	public EnemigoReforzado() {
		super(4, 1, 1, 1, 20, IMG);
		this.getCicloAnimacion().add(IMG);
		this.getCicloAnimacion().add(IMG1);

	}

}
