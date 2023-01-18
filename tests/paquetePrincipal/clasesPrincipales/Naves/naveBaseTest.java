package paquetePrincipal.clasesPrincipales.Naves;

import static org.junit.Assert.*;

import org.junit.Test;

import paquetePrincipal.CategoriaJugador;

public class naveBaseTest {

	@Test
	public void testGetterSetter() 
	{
		//fail("Not yet implemented");
		NaveBase nb= new NaveBasica(null, CategoriaJugador.PLAYER1);
		
		assertEquals(3, nb.getVida(), 0);
		nb.setVida(1);
		assertEquals(1, nb.getVida(), 0);
		//nb.setVida(1);
		
		assertEquals(35, nb.getVelocidadDisparo(), 0);
	}
	
	@Test
	public void testMovimiento() 
	{
		NaveBase nb= new NaveBasica(null, CategoriaJugador.PLAYER1);
		
		nb.movimiento();

		assertEquals(0.0, nb.getPosX(), 0);
		assertEquals(0.0, nb.getPosY(), 0);
	}
	

	@Test
	public void testReducicVida() 
	{
		NaveBase nb= new NaveBasica(null, CategoriaJugador.PLAYER1);
		nb.reducirVida(1);
		
		assertEquals(2, nb.getVida(), 0);
	}

}
