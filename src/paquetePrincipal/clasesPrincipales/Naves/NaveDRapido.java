package paquetePrincipal.clasesPrincipales.Naves;

import paquetePrincipal.CategoriaJugador;

public class NaveDRapido  extends NaveBase 
{
	protected static String IMG = "";
	protected static CategoriaJugador tipoJugador;
	
	public NaveDRapido(Object habilidad)
	{
		super(15,2, 2, 3, 5.0, 2.5, 2.5, IMG, tipoJugador, habilidad);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
