package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import paquetePrincipal.MotorJuego;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;

public class GrupoEnemigos {

	protected List<Enemigo> arrayEnemigos;
	protected List<Enemigo> noInit;
	protected List<Enemigo> dibujable;
	public GrupoEnemigos() {
		arrayEnemigos = new ArrayList<Enemigo>();
		noInit = new ArrayList<Enemigo>();
		dibujable = new ArrayList<Enemigo>();
	}

	public void anyadir(Enemigo enemigo) {
		this.arrayEnemigos.add(enemigo);
		this.noInit.add(enemigo);

	}

	public void eliminarPorObjeto(Enemigo e) {
		this.arrayEnemigos.remove(e);

	}

	public void colisionando(NaveBase nave) {

		for (Enemigo e : this.arrayEnemigos) {
			e.colisionando(nave);
			if (e.colisionando(nave)) {
				this.eliminarPorObjeto(e);
			}
		}

	}

	public boolean contiene(Enemigo e) {
		return this.arrayEnemigos.contains(e);
	}

	public void update(List<NaveBase> lista,MotorJuego motor) {
		List<Enemigo> muertos = new ArrayList<>();
		for (Enemigo i : this.dibujable) {
			if (i.vivo) {
				i.update();
			}
			for (NaveBase nave : lista) {
				if (i.colisionando(nave)) {
					//nave.reducirVida(i.danyo);
					i.vivo = false;
					muertos.add(i);
				
				
				}

			}
		}
		sumarPuntosDeMuertos(muertos, motor);
		this.arrayEnemigos.removeAll(muertos);
		this.dibujable.removeAll(muertos);
		if(arrayEnemigos.size() == 0) {
			if(motor.jugadoresEnPartida.size() != 0) {
				motor.finDeJuego = 1;
				motor.gestorBD.actualizarPuntuaciones();
			}else {
				motor.finDeJuego = -1;
			}
		}
		

	}


	
	public void incializar(MotorJuego motor) {
		for (Enemigo e : arrayEnemigos) {
			e.inicializarEnemigo(motor.getAnchuraV(), motor.getAlturaV(),motor.jugadoresEnPartida );
		}
	}
	public void inicializarSig(MotorJuego motor){
		
		if(this.noInit.size() != 0) {
			int numA = (int)(Math.random()*this.noInit.size());
			 this.noInit.get(numA).inicializarEnemigo(motor.getAnchuraV(), motor.getAlturaV(), motor.jugadoresEnPartida);
			 this.dibujable.add(this.noInit.get(numA));
			this.noInit.remove(numA);
			
		}
		
	}
	
	public void dibujar(Graphics2D g) {
		
		if(this.dibujable.size() != 0) {
			
		for (Enemigo e : this.dibujable) {
			if(e.vivo) {
			e.dibujar(g);}
		}
		}
	}
	public void sumarPuntosDeMuertos(List<Enemigo> muertos, MotorJuego motor) {
		for(Enemigo e : muertos) {
			motor.puntuacionDeJugadores.inc(e.puntuacion.get());
		}
	}
}
