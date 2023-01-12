package paquetePrincipal;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import graficos.Assets;
import paquetePrincipal.clasesPrincipales.enemigos.Enemigo;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoBasico;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoReforzado;

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
		
		// Rama1
		e1.setDibujoInicial();
		assertEquals(Assets.enemigoBasico, e1.getImage());

	}

	@Test
	public void testSiguienteDibujo() {
		Enemigo e1 = new EnemigoBasico();
		assertTrue(Assets.enemigoBasico);
		e1.siguienteDibujo();
		assertTrue();
		e1.siguienteDibujo();
		assertTrue("img\\Enemy_1.png" == e1.getImage());

	}

	@Test
	public void testGetterSetter() {
		Objeto o = new EnemigoReforzado();
		o.setCicloAnimacion(new ArrayList<>());
		o.setDibujoInicial();// saca por pantalla que el array está vacio

		o.setRadio(50);
		assertEquals(50, o.getRadio(), 0);

		o.setVelX(13);
		assertEquals(13, o.getVelX(), 0);
		o.setVelY(13);
		assertEquals(13, o.getVelY(), 0);
	}
}
