package paquetePrincipal;

import static org.junit.Assert.*;

import org.junit.Test;

import paquetePrincipal.clasesPrincipales.enemigos.EnemigoBasico;

public class EnemigoTest {

	@Test
	public void testSetDibujoInicial() {
		EnemigoBasico e = new EnemigoBasico();
		e.cicloAnimacion.add("imagen0");
		e.cicloAnimacion.add("imagen1");
		e.cicloAnimacion.add("imagen2");
		
		
	}

}
