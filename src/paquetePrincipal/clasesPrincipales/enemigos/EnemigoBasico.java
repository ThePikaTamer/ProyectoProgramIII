package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import graficos.Assets;

public class EnemigoBasico extends Enemigo {

	protected static BufferedImage IMG = Assets.enemigoBasico;

	public EnemigoBasico() {
		super(2, 1, 2, 2, 16, IMG);
		this.setCicloAnimacion(new ArrayList<>());
		this.getCicloAnimacion().add(IMG);
		
	}

}
