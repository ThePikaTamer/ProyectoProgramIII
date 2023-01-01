package paquetePrincipal.clasesPrincipales.Naves;

import java.awt.image.BufferedImage;

import clasesLogicas.Vector2D;
import graficos.Assets;
import paquetePrincipal.CategoriaJugador;

public class NaveBasica extends NaveBase {
	protected static BufferedImage IMG = Assets.naveBasica;
	protected static CategoriaJugador tipoJugador;

	public NaveBasica(Object habilidad, CategoriaJugador tipoJugador) {
		super(15, 2, 2, 5, 0.1, IMG, tipoJugador, habilidad, new Vector2D(0, 0));
		// TODO Auto-generated constructor stub
	}

}
