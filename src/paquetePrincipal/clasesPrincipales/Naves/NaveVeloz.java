package paquetePrincipal.clasesPrincipales.Naves;

import paquetePrincipal.CategoriaJugador;

public class NaveVeloz  extends NaveBase 
{
	protected static String IMG = "";
	protected static CategoriaJugador tipoJugador;
	
	public NaveVeloz(Object habilidad)
	{
		super(2, 2, 2, 2.5, 5.0, 5.0, IMG, tipoJugador, habilidad);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
