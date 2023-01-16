package paquetePrincipal.clasesPrincipales.enemigos;

import static org.junit.Assert.*;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import graficos.Assets;
import paquetePrincipal.CategoriaJugador;
import paquetePrincipal.CustomCanvas;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;

public class EnemigoTest {

	@Test
	public void testGetterSetter() {
		Enemigo e = new EnemigoBasico();

		assertEquals(2, e.getVida(), 0);
		e.setVida(1);
		assertEquals(1, e.getVida(), 0);
		e.setVida(-1);// para quitar cosas en rojo

		assertEquals(1, e.getDanyo(), 0);
		e.setDanyo(2);
		assertEquals(2, e.getDanyo(), 0);
		e.setDanyo(-1);// para quitar cosas en rojo

		e.setVectorDirectorNaveX(1);
		e.setVectorDirectorNaveY(0);
		assertEquals(1, e.getVectorDirectorNaveX(), 0);
		assertEquals(0, e.getVectorDirectorNaveY(), 0);

		NaveBase nave = new NaveBasica(null, CategoriaJugador.PLAYER1);
		e.setNaveDectada(nave);
		assertEquals(nave, e.getNaveDectada());
 
	}

	@Test
	public void testInicializarEnemigo() {
		Enemigo e = new EnemigoBasico();
		List<NaveBase> ls = new ArrayList<>();
		NaveBase nave = new NaveBasica(null, CategoriaJugador.PLAYER1);
		e.elegirNaveSeguida(ls);
		ls.add(nave);
		assertEquals(null, e.getNaveDectada());
		e.inicializarEnemigo(1000, 500, ls);
		assertEquals(nave, e.getNaveDectada());

	}

	@Test
	public void testUpdate() {
		Enemigo e = new EnemigoBasico();
		List<NaveBase> ls = new ArrayList<>();
		NaveBase nave = new NaveBasica(null, CategoriaJugador.PLAYER1);
		ls.add(nave);
		e.inicializarEnemigo(1000, 500, ls);
		e.setPosX(0);
		e.setPosY(0);

		nave.setPosX(5);
		nave.setPosY(0);

		e.update();
		assertEquals(1, e.getVectorDirectorNaveX(), 0);
		assertEquals(0, e.getVectorDirectorNaveY(), 0);
		assertEquals(e.getVelX(), e.getPosX(), 0);
		assertEquals(0, e.getPosY(), 0);
	}
	
//	@Test
//	public void testDibujar() {
//		CustomCanvas cc = new CustomCanvas(650, 650);
//		final BufferStrategy buffer = cc.getBufferStrategy();
//		if (buffer == null) {
//			cc.createBufferStrategy(2);
//			return; 
//		}
//		 Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
//		Enemigo e = new EnemigoBasico();
//		assertEquals(0, e.contadorAnimacion);
//		e.dibujar(g);
//		assertEquals(1, e.contadorAnimacion);
//		assertEquals(Assets.asteroideBasico,e.getImage() );
//		e.contadorAnimacion = 31;
//		e.dibujar(g);
//		assertEquals(Assets.asteroideBasico1,e.getImage() );
//		
//		
//	}
	
}
