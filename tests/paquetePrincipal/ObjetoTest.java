package paquetePrincipal;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


import paquetePrincipal.clasesPrincipales.enemigos.Enemigo;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoBasico;

public class ObjetoTest {

	@Test
	public void testCalcDistancia() {
		Enemigo e1 = new EnemigoBasico();
		e1.setPosX(5);
		e1.setPosY(0);
		Enemigo e2 = new EnemigoBasico();
		e2.setPosX(0);
		e2.setPosY(0);
		assertEquals(5, e1.calcDistancia(e2), 0);
	}

	@Test
	public void testColisionando() {
		Enemigo e1 = new EnemigoBasico();
		e1.setPosX(50);
		e1.setPosY(0);
		Enemigo e2 = new EnemigoBasico();
		e2.setPosX(0);
		e2.setPosY(0);
		assertTrue(e1.colisionando(e2));
		System.out.println(e1.colisionando(e2));
		e1.setPosX(150);
		e1.setPosY(0);
		e2.setPosX(0);
		e2.setPosY(0);
		assertFalse(e1.colisionando(e2));

	}

	@Test
	public void testSetDibujoInicial() {
		Enemigo e1 = new EnemigoBasico();
	//Rama1
		e1.setImage("prueba");
		assertTrue(e1.getImage() == "prueba");
		e1.setDibujoInicial();
		assertTrue(e1.getImage() == "img\\Enemy_1.png");


	}

	@Test
	public void testSiguienteDibujo() {
		Enemigo e1 = new EnemigoBasico();	
		
		e1.siguienteDibujo();
		assertTrue("img\\Enemy_1_1.png" == e1.getImage());
		e1.siguienteDibujo();
		assertTrue("img\\Enemy_1.png" == e1.getImage());
		
	}
}
