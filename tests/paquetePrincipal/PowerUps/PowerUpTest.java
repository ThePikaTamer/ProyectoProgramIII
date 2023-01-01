package paquetePrincipal.PowerUps;

import static org.junit.Assert.*;

import org.junit.Test;

import paquetePrincipal.clasesPrincipales.PowerUps.PowerUpEscudo;
import paquetePrincipal.clasesPrincipales.PowerUps.PowerUpHabilidad;
import paquetePrincipal.clasesPrincipales.PowerUps.PowerUpHp;
import paquetePrincipal.clasesPrincipales.PowerUps.PowerUpVD;
import paquetePrincipal.clasesPrincipales.asteroides.AsteroideBasico;

public class PowerUpTest {

	@Test
	public void testSetDibujoInicial() {
		PowerUpEscudo pue = new PowerUpEscudo();
		pue.cicloAnimacion.add("imagen0");
		pue.cicloAnimacion.add("imagen1");
		pue.cicloAnimacion.add("imagen2");

		PowerUpHabilidad puh = new PowerUpHabilidad();
		puh.cicloAnimacion.add("imagen0");
		puh.cicloAnimacion.add("imagen1");
		puh.cicloAnimacion.add("imagen2");

		PowerUpHp puhp = new PowerUpHp();
		puhp.cicloAnimacion.add("imagen0");
		puhp.cicloAnimacion.add("imagen1");
		puhp.cicloAnimacion.add("imagen2");

		PowerUpVD puv = new PowerUpVD();
		puv.cicloAnimacion.add("imagen0");
		puv.cicloAnimacion.add("imagen1");
		puv.cicloAnimacion.add("imagen2");

	}
}