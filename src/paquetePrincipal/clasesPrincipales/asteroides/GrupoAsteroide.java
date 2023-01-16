package paquetePrincipal.clasesPrincipales.asteroides;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import paquetePrincipal.MotorJuego;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.enemigos.Enemigo;

public class GrupoAsteroide {

	public ArrayList<Asteroide> arrayAsteroide;
	public List<Asteroide> noInit;
	public List<Asteroide> dibujable;
	public GrupoAsteroide() {
		arrayAsteroide = new ArrayList<Asteroide>();
		noInit = new ArrayList<>();
		dibujable = new ArrayList<>();
	}

	public void anyadir(Asteroide asteroide) {
		this.arrayAsteroide.add(asteroide);
		this.noInit.add(asteroide);

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
		public void inicializar(MotorJuego motor) {

			for(Asteroide a : this.arrayAsteroide) {
				a.inicializarAsteroide(MotorJuego.getAnchuraV(), MotorJuego.getAlturaV());
			}
			System.err.println(noInit.size());
			System.err.println("dibu = "+ this.dibujable.size());
		}
		public void inicializarSig(MotorJuego motor){
			System.err.println(noInit.size());
			if(this.noInit.size() != 0) {
				int numA = (int)(Math.random()*this.noInit.size());
				 this.noInit.get(numA).inicializarAsteroide(motor.getAnchuraV(), motor.getAlturaV());
				 this.dibujable.add(this.noInit.get(numA));
				this.noInit.remove(numA);
//				System.err.println(noInit.size());
			}
			
		}

	
	public boolean contiene(Asteroide asteroide) {
		return this.arrayAsteroide.contains(asteroide);
	}

	
	public void update(List<NaveBase> lista,MotorJuego motor) {
		List<Asteroide> destruidos = new ArrayList<>();
		for (Asteroide i : this.dibujable) {
			if (i.activo) {
				i.update();
			}
			for (NaveBase nave : lista) {
				if (i.colisionando(nave)) {
					if(i.activo) {
					nave.reducirVida(i.danyoChoque);
					i.activo = false;
					destruidos.add(i);
					
					}
				
				}

			}
		}
		
		this.sumarPuntosDestruidos(destruidos, motor);
		this.arrayAsteroide.removeAll(destruidos);
		this.dibujable.removeAll(destruidos);
		
	}
	public void sumarPuntosDestruidos(List<Asteroide> destruidos, MotorJuego motor) {
//		for(Asteroide a : destruidos) {
//			motor.puntuacionDeJugadores.inc(a.puntuacion.get());
//		}
	}
	
	public void dibujar(Graphics2D g) {
		
		if(this.dibujable.size() != 0) {
			
		for (Asteroide a : this.dibujable) {
			
			a.dibujar(g);
			}
		
		}
	}
	
	public int size() {
		return this.arrayAsteroide.size();
	}
	
	
}
