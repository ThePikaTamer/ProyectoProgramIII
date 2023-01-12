package paquetePrincipal.clasesPrincipales.asteroides;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.List;

import paquetePrincipal.MotorJuego;
import paquetePrincipal.Objeto;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;

public abstract class Asteroide extends paquetePrincipal.Objeto {

	protected int x;
	protected int y;
	protected double danyoChoque;
	protected double vida;
	protected BufferedImage imagen;
	protected Point2D orientacion;
	protected final int velocidad;
	public boolean activo = false;
	public boolean init = false;

	// CONSTRUCTORES//

	public Asteroide(double vida, double danyoChoque, double velX, double velY, BufferedImage IMG, Point2D orientacion,
			double radio) {
		this.velocidad = 2;
		this.vida = vida;
		this.danyoChoque = danyoChoque;
		this.velX = velX;
		this.velY = velY;
		this.radio = radio;
		this.IMG = IMG;
		this.orientacion = orientacion;

	}

	// METODOS//

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point2D getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(Point2D orientacion) {
		this.orientacion = orientacion;
	}

	public double getDanyoChoque() {
		return danyoChoque;
	}

	public void setDanyoChoque(double danyoChoque) {
		if (danyoChoque >= 0) {
			this.danyoChoque = danyoChoque;
		} else {
			System.err.println("El daño debe contener un numero natural.");

		}
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		if (vida >= 0) {
			this.vida = vida;
		} else {
			System.err.println("La vida debe contener un numero natural.");

		}
	}

	public BufferedImage getImagen() {
		return imagen;
	}

	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}

	public void reducirVida(int damage) {
		this.vida -= damage;
	}

	public void inicializarAsteroide(int anchuraPantalla, int alturaPantalla) {
		this.activo = true;
		this.init = true;
		this.posX = Math.random() * anchuraPantalla;
		this.posY = Math.random() * alturaPantalla;
		double oX = Math.random();
		double oY = Math.random();
		if (this.posX >= anchuraPantalla - 2 * this.getRadio() || this.posY >= alturaPantalla - 2 * this.getRadio()) {
			while (this.posX >= anchuraPantalla - 2 * this.getRadio()
					|| this.posY >= alturaPantalla - 2 * this.getRadio()) {
				this.posX = Math.random() * anchuraPantalla;
				this.posY = Math.random() * alturaPantalla;

			}
		}
		
	}

	@Override
	public boolean colisionando(Objeto o1) {
		return super.colisionando(o1);

	}

	public void mover() {

		if (orientacion.equals(new Point(0, 1))) {
			y += velocidad;
		} else if (orientacion.equals(new Point(1, 1))) {
			y += velocidad;
			x += velocidad;
		} else if (orientacion.equals(new Point(1, 0))) {
			x += velocidad;
		} else if (orientacion.equals(new Point(1, -1))) {
			y -= velocidad;
			x += velocidad;
		} else if (orientacion.equals(new Point(0, -1))) {
			y -= velocidad;

		} else if (orientacion.equals(new Point(-1, -1))) {
			y -= velocidad;
			x -= velocidad;

		} else if (orientacion.equals(new Point(-1, 0))) {
			x -= velocidad;
		} else if (orientacion.equals(new Point(-1, 1))) {
			x -= velocidad;
			y += velocidad;
		}
	}

	public void rebotar() {
		if (y < 0) {
			posY = MotorJuego.getAlturaV();
		} else if (x < 0) {
			posX = MotorJuego.getAnchuraV();

		}

		else if (y > MotorJuego.getAlturaV()) {
			posY = 0;

		}

		else if (x > MotorJuego.getAnchuraV()) {

			posX = 0;

		}

	}

	public void update() {
		mover();
		rebotar();
	}

	public void dibujar(Graphics2D g) {
		g.drawImage(this.IMG, (int) posX, (int) posY, null);

	}
}
