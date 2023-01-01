package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.image.BufferedImage;

import graficos.Assets;

public class EnemigoReforzado extends Enemigo {
	protected static BufferedImage IMG = Assets.enemigoReforzado;

	public EnemigoReforzado() {
		super(4, 1, 1, 1, 20, IMG);

	}

}
