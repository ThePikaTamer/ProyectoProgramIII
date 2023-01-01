package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.image.BufferedImage;

public class EnemigoVeloz extends Enemigo {
	protected static BufferedImage IMG;

	public EnemigoVeloz() {
		super(1, 1, 3, 3, 50, IMG);

	}

}
