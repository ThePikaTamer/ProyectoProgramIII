package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import paquetePrincipal.MotorJuego;
import paquetePrincipal.clasesPrincipales.Naves.Disparo;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;

public class GrupoEnemigos {

	public List<Enemigo> arrayEnemigos;
	public List<Enemigo> noInit;
	public List<Enemigo> dibujable;
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

//	public void colisionando(NaveBase nave) {
//		
//		for (Enemigo e : this.arrayEnemigos) {
//			e.colisionando(nave);
//			if (e.colisionando(nave)) {
//				this.eliminarPorObjeto(e);
//			}
//		}
//}
	

	public boolean contiene(Enemigo e) {
		return this.arrayEnemigos.contains(e);
	}

	public void update(List<NaveBase> lista,MotorJuego motor) {
		
		List<Enemigo> muertos = new ArrayList<>();
		List<Disparo> dEliminados = new ArrayList<>();
		for (Enemigo i : this.dibujable) {
			if (i.vivo) {
				i.update();
			}
			for (NaveBase nave : lista) {
				if (i.colisionando(nave)) {
					if(i.vivo) {
					nave.reducirVida(i.danyo);
					i.vivo = false;
					muertos.add(i);
					
					}
				
				}

			}
			
			for (Disparo disparo : MotorJuego.projectiles)
			{
				if(i.colisionando(disparo))
				{
					if(disparo.activo)
					{
						System.err.println(i.getVida());
						i.reducirVida(1);
						System.out.println(i.getVida());
						if(i.vida<=0)
						{
							i.vivo = false;
							muertos.add(i);
						}
						disparo.activo=false;
						dEliminados.add(disparo);
					}
				}
			}
		}
		sumarPuntosDeMuertos(muertos, motor);
		MotorJuego.projectiles.removeAll(dEliminados);
		this.arrayEnemigos.removeAll(muertos);
		this.dibujable.removeAll(muertos);
		if(arrayEnemigos.size() == 0 && motor.asteroidesEnPantalla.arrayAsteroide.size() == 0) {
			if(motor.jugadoresEnPartida.size() > 0) {
				motor.finDeJuego = 1;
				motor.gestorBD.actualizarPuntuaciones();
			}else {
				motor.finDeJuego = -1;
			}
		}
		}
		

	


	
	
	public void inicializarSig(MotorJuego motor){
		if(this.noInit.size() != 0) {
			int numA = (int)(Math.random()*this.noInit.size());
			 this.noInit.get(numA).inicializarEnemigo(motor.getAnchuraV(), motor.getAlturaV(), motor.jugadoresEnPartida);
			 this.dibujable.add(this.noInit.get(numA));
			this.noInit.remove(numA);
//			System.err.println(noInit.size());
		}
		
	}
	
	public void dibujar(Graphics2D g) {
		
		if(this.dibujable.size() != 0) {
			
		for (Enemigo e : this.dibujable) {
			
			e.dibujar(g);
			}
		
		}
	}
	public void sumarPuntosDeMuertos(List<Enemigo> muertos, MotorJuego motor) {
		for(Enemigo e : muertos) {
			motor.puntuacionDeJugadores.inc(e.puntuacion.get());
		}
	}
}
