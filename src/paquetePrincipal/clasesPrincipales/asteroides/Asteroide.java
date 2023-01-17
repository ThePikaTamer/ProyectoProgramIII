package paquetePrincipal.clasesPrincipales.asteroides;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.List;

import paquetePrincipal.MotorJuego;
import paquetePrincipal.Objeto;
import paquetePrincipal.Puntuacion;
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
	public Puntuacion puntuacion;

	// CONSTRUCTORES//

	public Asteroide(double vida, double danyoChoque, BufferedImage IMG, Point2D orientacion,
			double radio, Puntuacion puntuacion) {
		this.velocidad = 2;
		this.vida = vida;
		this.danyoChoque = danyoChoque;
		this.radio = radio;
		this.IMG = IMG;
		this.orientacion = orientacion;
		velX = 1;
		velY = 1;
		this.puntuacion = puntuacion;
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
			System.err.println("El daÃ±o debe contener un numero natural.");

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
			posX += velX * 2;
			posY += velY * 2;
		
			
			if(posX > MotorJuego.getAnchuraV() ) {
				this.setPosX(0);
				}
			if(posY > MotorJuego.getAlturaV() ) {
				this.setPosY(0);;
				}
			
			if(posX < 0 ) {
				this.setPosX(MotorJuego.getAnchuraV());
				}
			if(posY < 0 ) {
				this.setPosY(MotorJuego.getAlturaV());
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
	}

	public void dibujar(Graphics2D g) {
		g.drawImage(this.IMG, (int) posX, (int) posY, null);

	}
}