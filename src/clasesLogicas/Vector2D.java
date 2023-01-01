package clasesLogicas;

public class Vector2D {
	private double x;

	private double y;

	public Vector2D(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	//CALCULOS VECTOR
	public double getMagnitud() {
		
		return Math.sqrt((x*x) + (y*y));
	}
	
	public Vector2D setDirrección (double angulo) {
		return new Vector2D(Math.cos(angulo)* this.getMagnitud(),Math.sin(angulo)*this.getMagnitud());
	}
	
	public Vector2D sumar(Vector2D v) {
		return new Vector2D(x + v.getX(), y + v.getY());
	}
	public Vector2D multEscalar(double escalar) {
		 return new Vector2D(escalar*x, escalar*y);
	}
	public Vector2D limitar(double limite) {
		if(getMagnitud() > limite) {
			return this.normalizar().multEscalar(limite);
		}
		return this;
	}
	
	public Vector2D normalizar() {
		return new Vector2D(x/this.getMagnitud(), y/this.getMagnitud());
	}
	//
	
	
	
	
	
	
	
	
	

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	
}
