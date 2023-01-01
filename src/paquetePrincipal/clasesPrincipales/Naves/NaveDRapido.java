package paquetePrincipal.clasesPrincipales.Naves;

import java.awt.image.BufferedImage;

import clasesLogicas.Vector2D;
import paquetePrincipal.CategoriaJugador;

public class NaveDRapido extends NaveBase {
	protected static BufferedImage IMG ;
	protected static CategoriaJugador tipoJugador;

	public NaveDRapido(Object habilidad) {
		super(15, 2, 2, 3, 5.0, IMG, tipoJugador, habilidad,new Vector2D(0, 0));
		// TODO Auto-generated constructor stub
	}

}
