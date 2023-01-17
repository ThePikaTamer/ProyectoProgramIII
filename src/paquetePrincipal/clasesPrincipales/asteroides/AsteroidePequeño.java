package paquetePrincipal.clasesPrincipales.asteroides;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import graficos.Assets;
import paquetePrincipal.Puntuacion;

public class AsteroidePequeño extends Asteroide {
	public Asteroide asteroideAnterior;

	protected static BufferedImage IMG = Assets.asteroideBasico2;
	private final static double RADIO_EN = 8;
	private final static int VIDA = 1;
	private final static double DANYO_CHOQUE = 1;
	private final static double VEL_X = 2;
	private final static double VEL_Y = 2;
	private final static Puntuacion PUNT = new Puntuacion(75);
	
	public AsteroidePequeño(Asteroide asteroide) {
		super(VIDA, DANYO_CHOQUE, IMG, asteroide.orientacion, RADIO_EN, PUNT);
		this.asteroideAnterior = asteroideAnterior;
		this.posX = asteroide.getPosX();
		this.posY = asteroide.getPosY();
		this.velocidad = 1;
		EscogerDireccion();
		
	}
	
	public void EscogerDireccion() {
		this.activo = true;
		this.init = true;
		double oX = Math.random();
		
		if(oX >= 0 && oX<= 0.25) {
			if(Math.random()<= 0.5) {
				velX = 0;
				velY= 1;
				
			}else {
				velX = 1;
				velY= 1;
			}
			
		}
		
		else if(oX >= 0.26 && oX<= 0.5) {
			if(Math.random()<= 0.5) {
				velX = 1;
				velY= 0;
				
			}else {
				velX = 0;
				velY= -1;
			}
			
		}

		else if(oX >= 0.51 && oX<= 0.75) {
			if(Math.random()<= 0.5) {
				velX = -1;
				velY= 0;
				
			}else {
				velX = -1;
				velY= -1;
			}
			
		}

		else if(oX >= 0.76 && oX<= 1) {
			if(Math.random()<= 0.5) {
				velX = -1;
				velY= 1;
				
			}else {
				velX = 1;
				velY= -1;
			}
			
		}
	
		
		}
}