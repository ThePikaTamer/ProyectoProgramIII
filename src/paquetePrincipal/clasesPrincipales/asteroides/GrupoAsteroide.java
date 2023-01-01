package paquetePrincipal.clasesPrincipales.asteroides;

import java.util.ArrayList;

import paquetePrincipal.clasesPrincipales.enemigos.Enemigo;

public class GrupoAsteroide {

	protected ArrayList<Asteroide> arrayAsteroide;
	
	public GrupoAsteroide() {
		arrayAsteroide = new ArrayList<Asteroide>();
	}

	public void anyadir(Asteroide asteroide) {
		this.arrayAsteroide.add(asteroide);

	}

}
