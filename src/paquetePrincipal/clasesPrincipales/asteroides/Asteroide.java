package paquetePrincipal.clasesPrincipales.asteroides;


public abstract class Asteroide extends paquetePrincipal.Objeto {

	protected double anchuraAsteroide;
	protected double alturaAsteroide;
	protected double danyoChoque;
	protected double vida;

	//	protected String imagen; //Ruta de la imagen de la entidad
	
	//CONSTRUCTORES//
	
	public Asteroide(double vida, double danyoChoque, double velX, double velY, double anchuraAsteroide,double alturaAsteroide, String image) {
		this.vida = vida;
		this.danyoChoque = danyoChoque;
		this.velX = velX;
		this.velY = velY;
		this.anchuraAsteroide = anchuraAsteroide;
		this.alturaAsteroide = alturaAsteroide;
		this.image = image;
	
	
	}
	
	
	//METODOS//
	
	public void inicializarAsteroide(int anchuraPantalla, int alturaPantalla) {
		
		
		this.posX = Math.random()*(anchuraPantalla-this.anchuraAsteroide)+ (anchuraAsteroide/2);
		this.posY = -1*(Math.random()*(alturaPantalla-this.alturaAsteroide) + (alturaAsteroide/2));
		System.out.println( "X = "+posX);
		System.out.println("Y = "+posY);
		
	}
	
	
	
	public void movimiento() {
		
	}

}
