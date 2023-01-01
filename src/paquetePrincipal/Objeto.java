package paquetePrincipal;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Objeto implements Animable {
	protected BufferedImage IMG;
	protected double velX;
	protected double velY;
	protected double posX;
	protected double posY;
	protected double radio;
	protected ArrayList<BufferedImage> cicloAnimacion = new ArrayList<>();

	/*
	 * public Objeto(double velX, double velY, double posX, double posY, double
	 * radio, ArrayList<String> cicloAnimacion) { super(); this.velX = velX;
	 * this.velY = velY; this.posX = posX; this.posY = posY; this.radio = radio;
	 * this.cicloAnimacion = cicloAnimacion; }
	 */

	// Get-setters

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public BufferedImage getImage() {
		return this.IMG;
	}

	public  void setImage(BufferedImage image) {
		IMG = image;
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

	public ArrayList<BufferedImage> getCicloAnimacion() {
		return cicloAnimacion;
	}

	public void setCicloAnimacion(ArrayList<BufferedImage> cicloAnimacion) {
		this.cicloAnimacion = cicloAnimacion;
	}

	public void setDibujoInicial() {
		if (this.getCicloAnimacion().size() != 0) {
			this.setImage(this.cicloAnimacion.get(0));
		} else {
			System.err.println("El array está vacio");
		}

	}

	public void siguienteDibujo() {
		BufferedImage dibujoActual = this.IMG;
		if (this.cicloAnimacion.indexOf(dibujoActual) == (this.cicloAnimacion.size() - 1)) {
			this.setDibujoInicial();
		} else {
			this.IMG = this.cicloAnimacion.get(this.cicloAnimacion.indexOf(dibujoActual) + 1);
		}

	}

	public double calcDistancia(Objeto o1) {
		double vectY = (this.getPosY() + this.radio) - (o1.getPosY() + o1.radio);
		double vectX = (this.getPosX() + this.radio) - (o1.getPosX() + o1.radio);
		double resultado = Math.sqrt((vectX) * (vectX) + (vectY) * (vectY));
		return resultado;
	}

	public boolean colisionando(Objeto o1) {

		if (this.calcDistancia(o1) < (this.radio + o1.radio)) {
			return true;
		} else {
			return false;
		}

	}

}
