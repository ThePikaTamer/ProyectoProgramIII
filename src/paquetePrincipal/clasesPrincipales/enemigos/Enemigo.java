package paquetePrincipal.clasesPrincipales.enemigos;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import paquetePrincipal.Animable;
import paquetePrincipal.Objeto;
import paquetePrincipal.Puntuacion;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;

public abstract class Enemigo extends paquetePrincipal.Objeto {

	protected int vida;
	protected double danyo;
	protected NaveBase NaveDectada = null;
	protected double vectorDirectorNaveX;
	protected double vectorDirectorNaveY;
	public boolean vivo = false;
	public boolean init = false;
	public Puntuacion puntuacion;

	public int contadorAnimacion = 0;

	// CONSTRUCTORES//
	public Enemigo(int vida, double danyo, double velX, double velY, double radio, BufferedImage image,
			Puntuacion puntuacion) {
		this.vida = vida;
		this.danyo = danyo;
		this.velX = velX;
		this.velY = velY;
		this.radio = radio;
		this.IMG = image;
		this.setCicloAnimacion(new ArrayList<>());
		this.puntuacion = puntuacion;

	}

	// METODOS//
	public void reducirVida(int damage) {
		this.vida -= damage;
	}

	@Override
	public boolean colisionando(Objeto o1) {

		return super.colisionando(o1);
	}

	// metodos de obtención y modificación de la vida de los enemigos
	public double getVida() {
		return vida;
	}

	public void setVida(int vida) {
		if (vida >= 0) {
			this.vida = vida;
		} else {
			System.err.println("La vida debe contener un numero natural.");

		}
	}

	// metodos de obtención y modificación del daño de los enemigos
	public double getDanyo() {
		return danyo;
	}

	public void setDanyo(double danyo) {
		if (danyo >= 0) {
			this.danyo = danyo;
		} else {
			System.err.println("El daño debe contener un numero natural.");

		}

	}

	public NaveBase getNaveDectada() {
		return NaveDectada;
	}

	public void setNaveDectada(NaveBase naveDectada) {
		NaveDectada = naveDectada;
	}

	public double getVectorDirectorNaveX() {
		return vectorDirectorNaveX;
	}

	public void setVectorDirectorNaveX(double vectorDirectorNaveX) {
		this.vectorDirectorNaveX = vectorDirectorNaveX;
	}

	public double getVectorDirectorNaveY() {
		return vectorDirectorNaveY;
	}

	public void setVectorDirectorNaveY(double vectorDirectorNaveY) {
		this.vectorDirectorNaveY = vectorDirectorNaveY;
	}

	// metodo el cual da un valor aleatorio a la posición del enemigo la cual tiene
	// que estar dentro de la pantalla
	public void inicializarEnemigo(int anchuraPantalla, int alturaPantalla, List<NaveBase> navesVivas) {
		this.vivo = true;
		this.init = true;
		this.posX = Math.random() * anchuraPantalla;
		this.posY = Math.random() * alturaPantalla;
		if (this.posX >= anchuraPantalla - 2 * this.getRadio() || this.posY >= alturaPantalla - 2 * this.getRadio()) {
			while (this.posX >= anchuraPantalla - 2 * this.getRadio()
					|| this.posY >= alturaPantalla - 2 * this.getRadio()) {
				this.posX = Math.random() * anchuraPantalla;
				this.posY = Math.random() * alturaPantalla;
			}
		}

		
		this.elegirNaveSeguida(navesVivas);

	}

//actualiza posicion de los enemigos
	public void update() {
		this.setVectorDirectorConNave(this.NaveDectada);

		this.posX += this.velX * this.vectorDirectorNaveX;
		this.posY += this.velY * this.vectorDirectorNaveY;


	}

	public void elegirNaveSeguida(List<NaveBase> navesVivas) {
		if (navesVivas.size() == 0) {

		} else if (navesVivas.size() == 1) {
			this.NaveDectada = navesVivas.get(0);
		} else {

			double NumeroRandom = Math.random();
			if (NumeroRandom <= 0.5) {
				this.NaveDectada = navesVivas.get(0);
			} else {
				this.NaveDectada = navesVivas.get(1);
			}
		}

	}

	public void setVectorDirectorConNave(NaveBase nave) {
		double xVector = nave.getPosX() - this.getPosX();
		double yVector = nave.getPosY() - this.getPosY();
		double modulo = Math.sqrt(yVector * yVector + xVector * xVector);
		double xVectorN = xVector / modulo;
		double yVectorN = yVector / modulo;
		this.vectorDirectorNaveX = xVectorN;
		this.vectorDirectorNaveY = yVectorN;
	}

	public void dibujar(Graphics2D g) {
		contadorAnimacion++; 

		if (contadorAnimacion > 30) {
			this.siguienteDibujo();
			contadorAnimacion = 0;
		}
		g.drawImage(this.IMG, (int) posX, (int) posY, null);

	}

} 
