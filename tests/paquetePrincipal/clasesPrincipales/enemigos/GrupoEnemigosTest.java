package paquetePrincipal.clasesPrincipales.enemigos;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import baseDeDatos.Usuario;
import paquetePrincipal.CategoriaJugador;
import paquetePrincipal.MotorJuego;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;
import paquetePrincipal.clasesPrincipales.Naves.NaveDRapido;

public class GrupoEnemigosTest {
	
	
	
	@Test
	public void testAnyadirEliminar() {
		GrupoEnemigos ge = new GrupoEnemigos();
		EnemigoReforzado e = new EnemigoReforzado();
		assertEquals(true, ge.arrayEnemigos.size() == 0 && ge.noInit.size() == 0);
		ge.anyadir(e);
		assertEquals(true, ge.arrayEnemigos.size() == 1 && ge.noInit.size() == 1);
	
		ge.eliminarPorObjeto(e);
		assertEquals(true, ge.arrayEnemigos.size() == 0);
	
	}
//	@Test
//	public void testColisionando() {
//		GrupoEnemigos ge = new GrupoEnemigos();
//		
//		EnemigoReforzado e = new EnemigoReforzado();
//		EnemigoVeloz e1 = new EnemigoVeloz();
//		NaveDRapido n = new NaveDRapido(null, CategoriaJugador.PLAYER1);
//		ge.colisionando(n);
//		
//		ge.anyadir(e);
//		ge.anyadir(e1);
//	
//		e.setPosX(150);
//		e.setPosY(150);
//		e1.setPosX(10);
//		e1.setPosY(10);
//		n.setPosX(0);
//		n.setPosY(0);
//		assertEquals(2, ge.arrayEnemigos.size());
//		
//			ge.colisionando(n);
//		
//		assertTrue(!e.colisionando(n));
//		assertTrue(e1.colisionando(n));
//		
//		assertEquals(1,ge.arrayEnemigos.size());
//		
//		
//		assertTrue(false);
//	}

	@Test
	public void testContiene() {
		GrupoEnemigos ge = new GrupoEnemigos();
		Enemigo e = new EnemigoBasico();
		
		assertTrue(!ge.contiene(e));
		ge.anyadir(e);
		assertTrue(ge.contiene(e));
	}
	
	@Test
	public void testUpdate() {
		GrupoEnemigos ge = new GrupoEnemigos();
		ArrayList<NaveBase> naves = new ArrayList<>();
		Usuario us1 = new Usuario(9876, "pruebaUsuario1", "pruebaGmail.com", LocalDate.now());
		Usuario us2 = new Usuario(6789, "pruebaUsuario2", "prueba2Gmail.com", LocalDate.now());
		MotorJuego motor = new MotorJuego("Game", 0, new NaveBasica(null, CategoriaJugador.PLAYER1), new NaveDRapido(null, CategoriaJugador.PLAYER2), us1, us2, false);
		NaveBase n;
		
		naves.add( n = new NaveDRapido(null, CategoriaJugador.PLAYER1));
		motor.jugadoresEnPartida = new ArrayList<>();
		
		ge.update(naves, motor);
		motor.jugadoresEnPartida.add(n);
		ge.update(naves, motor);
		Enemigo e = new EnemigoBasico();
		Enemigo e1 = new EnemigoBasico();
		ge.anyadir(e);
		ge.anyadir(e1);	
		ge.inicializarSig(motor);
		ge.inicializarSig(motor);
		e.setPosX(150);
		e.setPosY(150);
		e1.setPosX(10);
		e1.setPosY(10);
		n.setPosX(0);
		n.setPosY(0);

		ge.update(naves, motor);
	
		e.vivo = false;
		e1.vivo = false;
		
		ge.update(naves, motor);


	}
	
}
