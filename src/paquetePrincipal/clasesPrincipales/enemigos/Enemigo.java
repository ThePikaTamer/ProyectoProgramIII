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

	protected double anchuraEnemigo;
	protected double alturaEnemigo;

	protected double vida;
	protected double danyo;


	// CONSTRUCTORES//
	public Enemigo(double vida, double danyo, double velX, double velY, double anchuraEnemigo, double alturaEnemigo,
			String image) {
		this.vida = vida;
		this.danyo = danyo;
		this.velX = velX;
		this.velY = velY;
		this.anchuraEnemigo = anchuraEnemigo;
		this.alturaEnemigo = alturaEnemigo;
		this.image = image;

	}

	// METODOS//

	public void inicializarEnemigo(int anchuraPantalla, int alturaPantalla) {

		this.posX = Math.random() * (anchuraPantalla - this.anchuraEnemigo) + (anchuraEnemigo / 2);
		this.posY =  (Math.random() * (alturaPantalla - this.alturaEnemigo) + (alturaEnemigo / 2));

		
		System.out.println("X = " + posX);
		System.out.println("Y = " + posY);
	
		
		
		

	}

	public void movimiento() {

	}



}
