package paquetePrincipal.clasesPrincipales.asteroides;

import static org.junit.Assert.*;

import org.junit.Test;

import paquetePrincipal.clasesPrincipales.asteroides.AsteroideBasico;
import paquetePrincipal.clasesPrincipales.asteroides.AsteroideDorado;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoBasico;

public class AsteroideTest {

	@Test
	public void testSetDibujoInicial() {
		AsteroideBasico ab = new AsteroideBasico();
		ab.cicloAnimacion.add("imagen0");
		ab.cicloAnimacion.add("imagen1");
		ab.cicloAnimacion.add("imagen2");

		AsteroideDorado ad = new AsteroideDorado();
		ad.cicloAnimacion.add("imagen0");
		ad.cicloAnimacion.add("imagen1");
		ad.cicloAnimacion.add("imagen2");
	}

}
