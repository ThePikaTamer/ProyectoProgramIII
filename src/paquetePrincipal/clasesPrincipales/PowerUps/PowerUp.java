package paquetePrincipal.clasesPrincipales.PowerUps;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import paquetePrincipal.MotorJuego;
import paquetePrincipal.Objeto;

public abstract class PowerUp extends paquetePrincipal.Objeto {

	
	protected Point2D orientacion;
	protected final int velocidad;
	protected int x;
	protected int y;
	protected BufferedImage imagen;
	public boolean activo = false;
	public boolean init = false;
	

	
	//CONSTRUCTORES//
	public PowerUp( BufferedImage IMG, int x, int y, Point2D orientacion, int velocidad) {
		this.velocidad = 1;
		this.IMG = IMG;
		this.orientacion = orientacion;
		this.y = y;
		this.x = x;
		
		
		
	}
	
	//METODOS//
	
	
	public void inicializarAsteroide(int anchuraPantalla, int alturaPantalla) {
		this.activo = true;
		this.init = true;
		this.posX = Math.random() * anchuraPantalla;
		this.posY = Math.random() * alturaPantalla;
		double oX = Math.random();
		System.out.println(oX);
		
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
		public Point2D getOrientacion() {
			return orientacion;
		}

		public void setOrientacion(Point2D orientacion) {
			this.orientacion = orientacion;
		}

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

		public int getVelocidad() {
			return velocidad;
		}
		
		
		public void mover() {
			posX += velX * 2;
			posY += velY * 2;
		
			
			if(posX > MotorJuego.getAnchuraV() ) {
				this.setPosX(0);
				}
			if(posY > MotorJuego.getAlturaV() ) {
				this.setY(0);;
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


