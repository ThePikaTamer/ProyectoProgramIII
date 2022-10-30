package clasesPrincipales.enemigos;

public abstract class Enemigo{
	
	protected double posX;
	protected double posY;
	
	protected double anchuraEnemigo;
	protected double alturaEnemigo;
	
	protected double vida;
	protected double danyo;
	protected double velMovimiento;
//	protected String imagen; //Ruta de la imagen de la entidad
	
	//CONSTRUCTORES//
	public Enemigo(double vida, double danyo, double velMovimiento, double anchuraEnemigo,double alturaEnemigo){
		this.vida = vida;
		this.danyo = danyo;
		this.velMovimiento = velMovimiento;
		this.anchuraEnemigo = anchuraEnemigo;
		this.alturaEnemigo = alturaEnemigo;
//		this.imagen = imagen;
		
		
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
