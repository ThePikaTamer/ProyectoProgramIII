package paquetePrincipal.clasesPrincipales.enemigos;

import paquetePrincipal.Objeto;

public abstract class Enemigo extends paquetePrincipal.Objeto {
	

	
	protected double anchuraEnemigo;
	protected double alturaEnemigo;
	
	protected double vida;
	protected double danyo;

//	protected String imagen; //Ruta de la imagen de la entidad
	
	//CONSTRUCTORES//
	public Enemigo(double vida, double danyo, double velX, double velY, double anchuraEnemigo,double alturaEnemigo, String image){
		this.vida = vida;
		this.danyo = danyo;
		this.velX = velX;
		this.velY = velY;
		this.anchuraEnemigo = anchuraEnemigo;
		this.alturaEnemigo = alturaEnemigo;
		this.image = image;
		
		
	}
	
	
	
	//METODOS//
	
	public void inicializarEnemigo(int anchuraPantalla, int alturaPantalla) {
		
		
		this.posX = Math.random()*(anchuraPantalla-this.anchuraEnemigo)+ (anchuraEnemigo/2);
		this.posY = -1*(Math.random()*(alturaPantalla-this.alturaEnemigo) + (alturaEnemigo/2));
		System.out.println( "X = "+posX);
		System.out.println("Y = "+posY);
		
	}
	
	
	
	public void movimiento() {
		
	}
	
	
	
	
	
	
	
}
