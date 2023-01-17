package paquetePrincipal.clasesPrincipales.Naves;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import clasesLogicas.Vector2D;
import graficos.Assets;
import paquetePrincipal.MotorJuego;
import paquetePrincipal.Objeto;

public class Disparo extends Objeto//extends MotorJuego
{

	/*public Disparo(String titulo) {
		super(titulo);
		// TODO Auto-generated constructor stub
	}*/

	/*@Override
	public void update()
	{
		// TODO Auto-generated method stub
		posicion=posicion.add(velocidad);
		if(posicion.getX()<0||posicion.getX()>MainWindow.WIDTH||posicion.getY()<0||posicion.getY()>MainWindow.HEIGHT)
		{
			gameState.getMovingObject().remove(this);
		}
		
	}*/
	
	/*@Override
	public void dibujar() 
	{
		// TODO Auto-generated method stub
		Graphics2D g2d=(Graphics2D)g;
		at=AffineTransform.getTranslateInstance(posicion.getX()-width/2, posicion.getY());
		at.rotate(angle,width/2,0);
		g2d.drawImage(textura, at, null);
		
	}*/
	
	
	protected double vel = 1.0f;
	protected Vector2D orientacion;
	protected static BufferedImage IMG = Assets.disparo;
	public NaveBase nave;
	private final static double RADIO_EN = 20;
	protected AffineTransform at;
	protected double anguloOrientacion;
	public boolean activo=false;
	
	
	public Disparo(double vel, double radio, NaveBase nave, MotorJuego motor)
	{
		super();
		this.posX = nave.getPosX();
		this.posY = nave.getPosY();
		this.vel = vel;
		this.radio=radio;
		this.orientacion = nave.orientacion;
		this.nave = nave;
		MotorJuego.projectiles.add(this);
		anguloOrientacion=nave.anguloOrientacion;
		at= AffineTransform.getTranslateInstance(this.posX+5, this.posY);
		activo=true;
	}
	
	public void update()
	{
		this.posX+=orientacion.getX()*this.vel;
		this.posY+=orientacion.getY()*this.vel;
		
		
	}
	
	public void dibujar(Graphics2D g) 
	{

		at= AffineTransform.getTranslateInstance(this.posX+5, this.posY);
		at.rotate(anguloOrientacion, this.IMG.getWidth()/2,this.IMG.getHeight()/2);
		g.drawImage(this.IMG,at, null);

	}
	
}
