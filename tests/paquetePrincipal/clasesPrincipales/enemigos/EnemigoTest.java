package paquetePrincipal.clasesPrincipales.enemigos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import paquetePrincipal.CategoriaJugador;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;

public class EnemigoTest {
	
	
	@Test
	public void testGetterSetter() {
		Enemigo e = new EnemigoBasico();
		
		assertEquals(2,e.getVida(), 0);
		e.setVida(1);
		assertEquals(1,e.getVida(), 0);
		e.setVida(-1);//para quitar cosas en rojo
		 
		
		assertEquals(1,e.getDanyo(), 0);
		e.setDanyo(2);
		assertEquals(2,e.getDanyo(), 0);
		e.setDanyo(-1);//para quitar cosas en rojo
		
		e.setVectorDirectorNaveX(1);
		e.setVectorDirectorNaveY(0);
		assertEquals(1, e.getVectorDirectorNaveX(),0);
		assertEquals(0, e.getVectorDirectorNaveY(),0);
		
		
		NaveBase nave = new NaveBasica(null, CategoriaJugador.PLAYER1);
		e.setNaveDectada(nave);
		assertEquals(nave, e.getNaveDectada());
		
		
	}
	@Test
	public void testInicializarEnemigo() {
		Enemigo e = new EnemigoBasico();
		List<NaveBase> ls = new ArrayList<>();
		NaveBase nave = new NaveBasica(null, CategoriaJugador.PLAYER1);
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
		assertEquals(1, e.getVectorDirectorNaveX(),0);
		assertEquals(0, e.getVectorDirectorNaveY(),0);
		assertEquals(e.getVelX(), e.getPosX(),0);
		assertEquals(0, e.getPosY(), 0);
	}

}
