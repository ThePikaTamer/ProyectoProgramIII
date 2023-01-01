package paquetePrincipal.clasesPrincipales.asteroides;

import java.util.ArrayList;
import java.util.List;

import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.enemigos.Enemigo;

public class GrupoAsteroide {

	protected ArrayList<Asteroide> arrayAsteroide;
	
	public GrupoAsteroide() {
		arrayAsteroide = new ArrayList<Asteroide>();
	}

	public void anyadir(Asteroide asteroide) {
		this.arrayAsteroide.add(asteroide);

	}
	
	public void eliminarPorObjeto(Asteroide asteroide) {
		this.arrayAsteroide.remove(asteroide);

	}
	
	public void colisionando(NaveBase nave) {

		for (Asteroide asteroide : this.arrayAsteroide) {
			asteroide.colisionando(nave);
			if (asteroide.colisionando(nave)) {
				this.eliminarPorObjeto(asteroide);
			}
		}
		

	}
	public boolean contiene(Asteroide asteroide) {
		return this.arrayAsteroide.contains(asteroide);
	}

	
}
