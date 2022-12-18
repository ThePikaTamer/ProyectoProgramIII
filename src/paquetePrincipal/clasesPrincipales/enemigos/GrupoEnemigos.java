package paquetePrincipal.clasesPrincipales.enemigos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import paquetePrincipal.clasesPrincipales.Naves.NaveBase;



public class GrupoEnemigos {

	protected ArrayList<Enemigo> arrayEnemigos;

	public GrupoEnemigos() {
		arrayEnemigos = new ArrayList<Enemigo>();
	}

	public void anyadir(Enemigo enemigo) {
		this.arrayEnemigos.add(enemigo);

	}
	public void eliminarPorObjeto(Enemigo e) {
		this.arrayEnemigos.remove(e);
		
	}
	
	
	public void colisionando(NaveBase nave) {
		
			for (Enemigo e : this.arrayEnemigos) {
				e.colisionando(nave);
				if(e.colisionando(nave)) {
					this.eliminarPorObjeto(e);
				}
			}
		
	}
	public boolean contiene(Enemigo e){
		return this.arrayEnemigos.contains(e);
	}

	
	public void update(List<NaveBase> lista) {
		List<Enemigo> muertos = new ArrayList<>();
		for(Enemigo i: this.arrayEnemigos) {
			i.update();
		for (NaveBase nave: lista) {
			if(i.colisionando(nave)) {
				muertos.add(i);
			}
			
		}
		}
		this.arrayEnemigos.removeAll(muertos);
		
	}

	
}
