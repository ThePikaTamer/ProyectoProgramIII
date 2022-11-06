package paquetePrincipal.clasesPrincipales.Naves;

import paquetePrincipal.CategoriaJugador;
import paquetePrincipal.Objeto;

abstract public class NaveBase extends Objeto
{
	protected double anchuraNave;
	protected double alturaNave;
	protected int vida;
	protected double velocidadDisparo;
	protected double velocidadMovimiento;
	protected double velocidadRotacion;
	protected String IMG;
	protected CategoriaJugador jugador;
	protected Object habilidad;
	
	public NaveBase(double anchuraNave, double alturaNave, int vida, double velocidadDisparo, double velocidadMovimiento, double velocidadRotacion, String iMG, CategoriaJugador jugador, Object habilidad)
	{
		super();
		this.anchuraNave = anchuraNave;
		this.alturaNave = alturaNave;
		this.vida = vida;
		this.velocidadDisparo = velocidadDisparo;
		this.velocidadMovimiento = velocidadMovimiento;
		this.velocidadRotacion = velocidadRotacion;
		IMG = iMG;
		this.jugador = jugador;
		this.habilidad = habilidad;
	}
	
	
	
	public double getAnchuraNave() {
		return anchuraNave;
	}
	public void setAnchuraNave(double anchuraNave) {
		this.anchuraNave = anchuraNave;
	}

	public double getAlturaNave() {
		return alturaNave;
	}
	public void setAlturaNave(double alturaNave) {
		this.alturaNave = alturaNave;
	}

	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
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

	public String getIMG() {
		return IMG;
	}
	public void setIMG(String iMG) {
		IMG = iMG;
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
		this.posX = Math.random()*(anchuraPantalla-this.anchuraNave)+ (anchuraNave/2);
		this.posY = -1*(Math.random()*(alturaPantalla-this.alturaNave) + (alturaNave/2));
		System.out.println( "X = "+posX);
		System.out.println("Y = "+posY);
		
	}
	
	// para disparar
	void disparar()//(bullet bala)
	{
		if(this.getJugador()==CategoriaJugador.PLAYER1)
		{
			//espacio
		}
		
		else if(this.getJugador()==CategoriaJugador.PLAYER2)
		{
			//-
		}
	}
	
	
	//
	void movimiento()
	{
		if(this.getJugador()==CategoriaJugador.PLAYER1)
		{
			//WASD
		}
		
		else if(this.getJugador()==CategoriaJugador.PLAYER2)
		{
			//flechas direccion
		}
	}
	

	//
	void usarPowerUp()
	{
		if(this.getJugador()==CategoriaJugador.PLAYER1)
		{
			//boton espacio
		}
		
		else if(this.getJugador()==CategoriaJugador.PLAYER2)
		{
			//boton shift derecho?
		}
	}
	
	
}
