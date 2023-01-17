package paquetePrincipal.clasesPrincipales.Naves;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import Controles.Teclado;
import clasesLogicas.Vector2D;
import paquetePrincipal.CategoriaJugador;
import paquetePrincipal.MotorJuego;
import paquetePrincipal.Objeto;

abstract public class NaveBase extends Objeto {

	protected double vida;
	protected double velocidadDisparo;
	protected double velocidadMovimiento;
	protected double velocidadRotacion;
	protected CategoriaJugador jugador;
	protected Object habilidad;
	
	protected int contadorAnimacion = 0;
	
	//VECTORES DE MOVIMIENTO
	protected Vector2D vectorVel;
	protected AffineTransform at;
	protected double anguloOrientacion;
	protected Vector2D orientacion;
	protected Vector2D vectorAcc;
	
	protected  final double ACCEL = 0.2;
	
	//

	private long time, lastTime;
	protected int fireRate=300;


	public NaveBase(double radio, double vida, double velocidadDisparo,
			double velocidadMovimiento, double velocidadRotacion, BufferedImage IMG, CategoriaJugador jugador,
			Object habilidad, Vector2D vectorVel) {
		super();
		this.radio = radio;
		this.vida = vida;
		this.velocidadDisparo = velocidadDisparo;
		this.velocidadMovimiento = velocidadMovimiento;
		this.velocidadRotacion = velocidadRotacion;
		this.IMG = IMG;
		this.jugador = jugador;
		this.habilidad = habilidad;
		
		this.vectorVel = vectorVel;
		this.anguloOrientacion = 0;
		this.orientacion =  new Vector2D(0, 1);
		this.vectorAcc = new Vector2D(0, 0);
		
	}



	public double getVida() {
		return vida;
	}

	public void setVida(double d) {
		this.vida = d;
	}

	public double getVelocidadDisparo() {
		return velocidadDisparo;
	}

	public void setVelocidadDisparo(double velocidadDisparo) {
		this.velocidadDisparo = velocidadDisparo;
	}

	public double getVelocidadMovimiento() {
		return velocidadMovimiento;
	}

	public void setVelocidadMovimiento(double velocidadMovimiento) {
		this.velocidadMovimiento = velocidadMovimiento;
	}

	public double getVelocidadRotacion() {
		return velocidadRotacion;
	}

	public void setVelocidadRotacion(double velocidadRotacion) {
		this.velocidadRotacion = velocidadRotacion;
	}

	public BufferedImage getIMG() {
		return IMG;
	}

	public void setIMG(BufferedImage IMG) {
		IMG = IMG;
	}

	public CategoriaJugador getJugador() {
		return jugador;
	}

	public void setJugador(CategoriaJugador jugador) {
		this.jugador = jugador;
	}

	public Object getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(Object habilidad) {
		this.habilidad = habilidad;
	}

	//
	public void inicializarNave(int anchuraPantalla, int alturaPantalla) {
		this.posX = Math.random() * (anchuraPantalla - this.radio) + (this.radio / 2);
		this.posY = -1 * (Math.random() * (alturaPantalla - this.radio) + (this.radio / 2));
		System.out.println("X = " + posX);
		System.out.println("Y = " + posY);

	}

	/*
	// para disparar
	void disparar()// (bullet bala)
	{
		if (this.getJugador() == CategoriaJugador.PLAYER1) 
		{
			// espacio
			if(Teclado.espacio)//&&counter>this.fireRate)
			{
				System.out.println("1");
			}
		}

		else if (this.getJugador() == CategoriaJugador.PLAYER2) 
		{
			// .
			if(Teclado.punto)
			{
				System.out.println("2");
			}
		}
	}*/

	//
	public void movimiento() {
		int counter=0;
		
		if(this.jugador == CategoriaJugador.PLAYER1) 
		{
		
			if (Teclado.W) {
				vectorAcc = orientacion.multEscalar(ACCEL);
			}else {
				if(vectorVel.getMagnitud() != 0) {
					vectorAcc = (vectorVel.multEscalar(-1).normalizar()).multEscalar(ACCEL);
				}
			}
			
			if (Teclado.A) {
				anguloOrientacion -= this.velocidadRotacion;
			}
			if (Teclado.D) {
				anguloOrientacion += this.velocidadRotacion;
			}
			if (Teclado.S) 
			{
				vectorAcc = orientacion.multEscalar(-ACCEL);
			}/*
			if(Teclado.espacio)//disparo
			{
				System.out.println("shoot1");
				
			}*/
		}
		else if(this.jugador == CategoriaJugador.PLAYER2) 
		{
			if (Teclado.arriba) {
				vectorAcc = orientacion.multEscalar(ACCEL);
			}else {
				if(vectorVel.getMagnitud() != 0) {
					vectorAcc = (vectorVel.multEscalar(-1).normalizar()).multEscalar(ACCEL);
				}
			}
			if (Teclado.izquierda) {
				anguloOrientacion -= this.velocidadRotacion;
			}
			if (Teclado.derecha) {
				anguloOrientacion += this.velocidadRotacion;
			}
			if (Teclado.abajo) 
			{
				vectorAcc = orientacion.multEscalar(-ACCEL);
			}/*
			if(Teclado.punto)//disparo
			{
				System.out.println("shoot2");
			}	*/
		}
		
		
		vectorVel = vectorVel.sumar(vectorAcc);
		  vectorVel = vectorVel.limitar(this.velocidadMovimiento);
		orientacion = orientacion.setDirreccion(anguloOrientacion- Math.PI/2);
		
		posX += vectorVel.getX();
		posY += + vectorVel.getY();
		//LIMITAR MOVIMIENTO
		if(posX > MotorJuego.getAnchuraV()) {
			posX = 0;
		}if(posY > MotorJuego.getAlturaV()) {
			posY = 0;
		}
		if(posX  < 0) {
			posX = MotorJuego.getAnchuraV() ;
		}
		
		if(posY  < 0) {
			posY  = MotorJuego.getAlturaV() ;
		}
	}

	//
	void usarPowerUp() {
		if (this.getJugador() == CategoriaJugador.PLAYER1) {
			// boton espacio
		}

		else if (this.getJugador() == CategoriaJugador.PLAYER2) {
			// boton shift derecho?
		}
	}

	public void reducirVida(double danyo) {
		this.setVida(this.getVida() - danyo);
	};

	
	public void dibujar(Graphics2D g) {
		contadorAnimacion++;
		if(contadorAnimacion > 30) {
			this.siguienteDibujo();
			contadorAnimacion = 0;
		}
		
		at = AffineTransform.getTranslateInstance(posX, posY);
		at.rotate(anguloOrientacion, this.IMG.getWidth()/2,this.IMG.getHeight()/2);
		g.drawImage(this.IMG,at, null);
	
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.IMG + "";
	}
}
