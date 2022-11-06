package paquetePrincipal;

import java.util.ArrayList;

public abstract class Objeto implements Animable
{
	protected static String image;
	protected double velX;
	protected double velY;
	protected double posX;
	protected double posY;
	protected ArrayList<String> cicloAnimacion= new ArrayList<>();
	
	
	
	
	
	//Get-setters

	
	public static String getImage() {
		return image;
	}
	public static void setImage(String image) {
		Objeto.image = image;
	}

	

	public double getVelX() {
		return velX;
	}
	public void setVelX(double velX) {
		this.velX = velX;
	}


	
	public double getVelY() {
		return velY;
	}
	public void setVelY(double velY) {
		this.velY = velY;
	}


	
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}


	
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}


	
	public ArrayList<String> getCicloAnimacion() {
		return cicloAnimacion;
	}
	public void setCicloAnimacion(ArrayList<String> cicloAnimacion) {
		this.cicloAnimacion = cicloAnimacion;
	}


	
	
	
	public void setDibujoInicial() {
		if (this.cicloAnimacion.size() != 0) {
			this.image = this.cicloAnimacion.get(0);
		}else {
			System.err.println("El array está vacio");
		}

	}

	
	public void siguienteDibujo() {
		String dibujoActual = this.image;
		if (this.cicloAnimacion.indexOf(dibujoActual) == (this.cicloAnimacion.size() - 1)) {
			this.setDibujoInicial();
		}else {
			this.image = this.cicloAnimacion.get(this.cicloAnimacion.indexOf(dibujoActual)+1);
		}
		
	}
}
