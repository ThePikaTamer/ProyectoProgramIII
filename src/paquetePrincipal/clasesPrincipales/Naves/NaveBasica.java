package paquetePrincipal.clasesPrincipales.Naves;

import paquetePrincipal.CategoriaJugador;

public class NaveBasica extends NaveBase 
{
	protected static String IMG = "img/nave.png";
	protected static CategoriaJugador tipoJugador;
	
	public NaveBasica(Object habilidad, CategoriaJugador tipoJugador)
	{
		super(2, 2, 3, 2.5, 3.0, 3.0, IMG, tipoJugador, habilidad);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
