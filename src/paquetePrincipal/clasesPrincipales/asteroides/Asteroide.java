package paquetePrincipal.clasesPrincipales.asteroides;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;

import paquetePrincipal.Objeto;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;

public abstract class Asteroide extends paquetePrincipal.Objeto {

	protected int x;
	protected int y;
	protected double anchuraAsteroide;
	protected double alturaAsteroide;
	protected double danyoChoque;
	protected double vida;
	protected String imagen;
	protected Point2D orientacion;
	protected final int velocidad; 
	
	protected int cotadorAnimacion = 0;
	

	
	//CONSTRUCTORES//
	
	public Asteroide(double vida, double danyoChoque, double velX, double velY, double anchuraAsteroide,double alturaAsteroide, String iMG, Point2D orientacion, int x,  int y) {
		this.velocidad = 2;
		this.vida = vida;
		this.danyoChoque = danyoChoque;
		this.velX = velX;
		this.velY = velY;
		this.anchuraAsteroide = anchuraAsteroide;
		this.alturaAsteroide = alturaAsteroide;
		imagen=iMG;
		this.orientacion = orientacion;
		this.y = y;
		this.x = x;
		
		
		
	
	}
	
	
	
	//METODOS//
	
	
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



	public double getAnchuraAsteroide() {
		return anchuraAsteroide;
	}



	public Point2D getOrientacion() {
		return orientacion;
	}



	public void setOrientacion(Point2D orientacion) {
		this.orientacion = orientacion;
	}



	public void setAnchuraAsteroide(double anchuraAsteroide) {
		this.anchuraAsteroide = anchuraAsteroide;
	}



	public double getAlturaAsteroide() {
		return alturaAsteroide;
	}



	public void setAlturaAsteroide(double alturaAsteroide) {
		this.alturaAsteroide = alturaAsteroide;
	}



	public double getDanyoChoque() {
		return danyoChoque;
	}



	public void setDanyoChoque(double danyoChoque) {
		if(danyoChoque >= 0) {
			this.danyoChoque = danyoChoque;
			}else {
				System.err.println("El daño debe contener un numero natural.");

			}
	}



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



	public String getImagen() {
		return imagen;
	}



	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public void reducirVida(int damage) {
		this.vida -= damage;
	}



	public void inicializarAsteroide(int anchuraPantalla, int alturaPantalla) {
		
		this.posX = Math.random() * anchuraPantalla;
		this.posY =  Math.random() * alturaPantalla;
		if(this.posX >= anchuraPantalla-2*this.getRadio() || this.posY >= alturaPantalla-2*this.getRadio()) {
			while(this.posX >= anchuraPantalla-2*this.getRadio() || this.posY >= alturaPantalla-2*this.getRadio()) {
				this.posX = Math.random() * anchuraPantalla;
				this.posY =  Math.random() * alturaPantalla;
			
		}
		}
	}
	@Override
	public boolean colisionando(Objeto o1) {
//		if(o1 instanceof NaveBase) {
//			((NaveBase) o1).reducirVida((int)this.getDanyo());
		return super.colisionando(o1);
//		}else return false;
	}
	
	public void mover() {
		
		if (orientacion.equals(new Point(0, 1))) {
			y += velocidad;
			}
		else if (orientacion.equals(new Point(1, 1))) {
			y += velocidad;
			x += velocidad;
		}
		else if (orientacion.equals(new Point(1, 0))){
			x += velocidad;
		}
		else if (orientacion.equals(new Point(1, -1))) {
			y -= velocidad;
			x += velocidad;
		}
		else if (orientacion.equals(new Point(0, -1))) {
			y -= velocidad;
			
		}
		else if (orientacion.equals(new Point(-1, -1))) {
			y -= velocidad;
			x -= velocidad;
			
		}
		else if (orientacion.equals(new Point(-1, 0))) {
			x -= velocidad;
		}
		else if (orientacion.equals(new Point(-1, 1))) {
			x -= velocidad;
			y += velocidad;
			}	
	}
	
	public void rebotar(int LimX, int LimY) {
		if (y<= 0) {
			int nr = (int) (Math.random()*3)+1;
			//System.out.println(nr);
			orientacion = nr == 1 ?  new Point(-1, 1) : nr == 2? new Point(0, 1): new Point(1, 1);
			}
		else if(x<=0) {
			int nr = (int) (Math.random()*3)+1;
			//System.out.println(nr);
			orientacion = nr == 1 ?  new Point(1, -1) : nr == 2? new Point(1,0): new Point(1, 1);
			
		}
		
		else if(y>=LimY - anchuraAsteroide) {
			int nr = (int) (Math.random()*3)+1;
			//System.out.println(nr);
			orientacion = nr == 1 ?  new Point(-1, -1) : nr == 2? new Point(0,1): new Point(1, -1);
			
		}
		
		else if(x>=LimX - anchuraAsteroide) {
			int nr = (int) (Math.random()*3)+1;
			//System.out.println(nr);
			orientacion = nr == 1 ?  new Point(-1, 1) : nr == 2? new Point(-1,0): new Point(-1, -1);
			
		}
		
		
	}
	
	
	public void update() {
		 mover();
		 rebotar(x, y);
	}
	public void dibujar(Graphics2D g) {
		contadorAnimacion++;
		
		if(contadorAnimacion > 30) {
			this.siguienteDibujo();
			contadorAnimacion = 0;
		}
		g.drawImage(this.IMG, (int)posX, (int)posY, null);
	
		
	}
}
