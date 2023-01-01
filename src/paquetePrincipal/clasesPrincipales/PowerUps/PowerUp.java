package paquetePrincipal.clasesPrincipales.PowerUps;

import java.awt.Point;
import java.awt.geom.Point2D;

public abstract class PowerUp extends paquetePrincipal.Objeto {

	protected double anchuraPowerUp;
	protected double alturaPowerUp; 
	protected Point2D orientacion;
	protected final int velocidad;
	protected int x;
	protected int y;
	public boolean vivo = false;
	
//	protected String imagen; //Ruta de la imagen de la entidad
	
	//CONSTRUCTORES//
	public PowerUp(double anchuraPowerUp, double alturaPowerUp, String iMG, int x, int y, Point2D orientacion, int velocidad) {
		this.velocidad = 0;
		this.alturaPowerUp = alturaPowerUp;
		this.anchuraPowerUp = anchuraPowerUp;
		String imagen = iMG;
		this.orientacion = orientacion;
		this.y = y;
		this.x = x;
		
		
	}
	
	//METODOS//
	
	
	public void inicializarPoweUp(int anchuraPantalla, int alturaPantalla) {
		this.vivo = true;
		this.posX = Math.random() * anchuraPantalla;
		this.posY =  Math.random() * alturaPantalla;
		if(this.posX >= anchuraPantalla-2*this.getRadio() || this.posY >= alturaPantalla-2*this.getRadio()) {
			while(this.posX >= anchuraPantalla-2*this.getRadio() || this.posY >= alturaPantalla-2*this.getRadio()) {
				this.posX = Math.random() * anchuraPantalla;
				this.posY =  Math.random() * alturaPantalla;
			
		}
		}
	}

		public double getAnchuraPowerUp() {
			return anchuraPowerUp;
		}

		public void setAnchuraPowerUp(double anchuraPowerUp) {
			this.anchuraPowerUp = anchuraPowerUp;
		}

		public double getAlturaPowerUp() {
			return alturaPowerUp;
		}

		public void setAlturaPowerUp(double alturaPowerUp) {
			this.alturaPowerUp = alturaPowerUp;
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
			
			else if(y>=LimY - anchuraPowerUp) {
				int nr = (int) (Math.random()*3)+1;
				//System.out.println(nr);
				orientacion = nr == 1 ?  new Point(-1, -1) : nr == 2? new Point(0,1): new Point(1, -1);
				
			}
			
			else if(x>=LimX - anchuraPowerUp) {
				int nr = (int) (Math.random()*3)+1;
				//System.out.println(nr);
				orientacion = nr == 1 ?  new Point(-1, 1) : nr == 2? new Point(-1,0): new Point(-1, -1);
				
			}
			
			
		}
		
		
		
		public void update() {
			 mover();
			 rebotar(x, y);
		}
		
		

}


