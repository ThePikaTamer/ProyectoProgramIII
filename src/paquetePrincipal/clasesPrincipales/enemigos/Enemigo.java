package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


import paquetePrincipal.Animable;
import paquetePrincipal.Objeto;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;


public abstract class Enemigo extends paquetePrincipal.Objeto  {

	
	

	protected double vida;
	protected double danyo;
	protected NaveBase NaveDectada = null;
	protected double vectorDirectorNaveX;
	protected double vectorDirectorNaveY;


	// CONSTRUCTORES//
	public Enemigo(double vida, double danyo, double velX, double velY, double radio,
			String image) {
		this.vida = vida;
		this.danyo = danyo;
		this.velX = velX;
		this.velY = velY;
		this.radio = radio;
		this.image = image;

	}

	
	// METODOS//

	

	


	//metodos de obtención y modificación de la vida de los enemigos
	public double getVida() {
		return vida;
	}
	public void setVida(double vida) {
		if(vida >= 0) {
			this.vida = vida;
		}else {
			System.err.println("La vida debe contener un numero natural.");

		}
		}


	//metodos de obtención y modificación del daño de los enemigos
	public double getDanyo() {
		return danyo;
	}
	public void setDanyo(double danyo) {
		if(danyo >= 0) {
		this.danyo = danyo;
		}else {
			System.err.println("El daño debe contener un numero natural.");

		}
		
	}
	
	
	//metodo el cual da un valor aleatorio a la posición del enemigo la cual tiene que estar dentro de la pantalla
	public void inicializarEnemigo(int anchuraPantalla, int alturaPantalla,List<NaveBase> navesVivas) {

		this.posX = Math.random() * anchuraPantalla;
		this.posY =  Math.random() * alturaPantalla;
		if(this.posX >= anchuraPantalla-2*this.getRadio() || this.posY >= alturaPantalla-2*this.getRadio()) {
			while(this.posX >= anchuraPantalla-2*this.getRadio() || this.posY >= alturaPantalla-2*this.getRadio()) {
				this.posX = Math.random() * anchuraPantalla;
				this.posY =  Math.random() * alturaPantalla;
			}
		}
		

		//Prueba para ver si funciona
		System.out.println("X = " + posX);
		System.out.println("Y = " + posY);
		this.elegirNaveSeguida(navesVivas);


	}


//actualiza posicion de los enemigos
	public void update() {
		this.setVectorDirectorConNave(this.NaveDectada);
		System.out.println(this.vectorDirectorNaveX + " - "+ this.vectorDirectorNaveY);
		this.posX += this.velX* this.vectorDirectorNaveX;
		this.posY += this.velY *this.vectorDirectorNaveY;
	}

	
	
	
	
	public void elegirNaveSeguida(List<NaveBase> navesVivas) {
		if (navesVivas.size() <=1) {
			this.NaveDectada = navesVivas.get(0);
		}else {
			
			double NumeroRandom = Math.random();
			if(NumeroRandom <=0.5) {
				this.NaveDectada = navesVivas.get(0);
			}else {
				this.NaveDectada = navesVivas.get(1);
			}
		}
		
		
	}

	public void setVectorDirectorConNave(NaveBase nave) {
		double xVector = nave.getPosX()-this.getPosX();
		double yVector = nave.getPosY()-this.getPosY();
		double modulo = Math.sqrt(yVector*yVector+xVector*xVector);
		double xVectorN = xVector/modulo;
		double yVectorN = yVector/modulo;
		this.vectorDirectorNaveX = xVectorN;
		this.vectorDirectorNaveY = yVectorN;
	}
	
	

}
