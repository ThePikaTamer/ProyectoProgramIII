package paquetePrincipal.clasesPrincipales.asteroides;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import paquetePrincipal.CategoriaJugador;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;
import paquetePrincipal.clasesPrincipales.enemigos.Enemigo;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoBasico;



public class AsteroideTest {

	@Test
	public void testGetterSetter() {
		Asteroide ab = new AsteroideBasico();
		
		assertEquals(2,ab.getVida(), 0);
		ab.setVida(1);
		assertEquals(1,ab.getVida(), 0);
		ab.setVida(-1);
		
		assertEquals(1,ab.getDanyoChoque(), 0);
		ab.setDanyoChoque(2);
		assertEquals(2,ab.getDanyoChoque(), 0);
		ab.setDanyoChoque(-1);
	
		
	}
	

		
		
		
		
	}
	
