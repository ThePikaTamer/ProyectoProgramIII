package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;


import paquetePrincipal.Animable;
import paquetePrincipal.Objeto;


public abstract class Enemigo extends paquetePrincipal.Objeto  {

	
	

	protected double vida;
	protected double danyo;


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
	public void inicializarEnemigo(int anchuraPantalla, int alturaPantalla) {

		this.posX = Math.random() * (anchuraPantalla - this.radio) + (this.radio);
		this.posY =  (Math.random() * (alturaPantalla - this.radio) + (this.radio));

		//Prueba para ver si funciona
		System.out.println("X = " + posX);
		System.out.println("Y = " + posY);
	


	}



	public void movimiento() {

	}



}
