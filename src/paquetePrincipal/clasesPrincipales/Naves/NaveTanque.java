package paquetePrincipal.clasesPrincipales.Naves;

import paquetePrincipal.CategoriaJugador;

public class NaveTanque  extends NaveBase 
{
	protected static String IMG = "";
	protected static CategoriaJugador tipoJugador;
	
	public NaveTanque(Object habilidad)
	{
		super(2, 2, 6, 2.0, 2.0, 2.0, IMG, tipoJugador, habilidad);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
