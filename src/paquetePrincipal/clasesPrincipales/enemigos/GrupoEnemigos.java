package paquetePrincipal.clasesPrincipales.enemigos;

import java.util.ArrayList;

import paquetePrincipal.NaveBase;

public class GrupoEnemigos {

	protected ArrayList<Enemigo> arrayEnemigos;

	public GrupoEnemigos() {
		arrayEnemigos = new ArrayList<Enemigo>();
	}

	public void anyadir(Enemigo enemigo) {
		this.arrayEnemigos.add(enemigo);

	}
	
	
//	public boolean naveTocada(NaveBase jugador) {
//		
//		
//	}

}
