package paquetePrincipal.clasesPrincipales.PowerUps;

import java.awt.image.BufferedImage;

public abstract class PowerUp extends paquetePrincipal.Objeto {

	protected double anchuraPowerUp;
	protected double alturaPowerUp;

//	protected String imagen; //Ruta de la imagen de la entidad

	// CONSTRUCTORES//
	public PowerUp(double anchuraPowerUp, double alturaPowerUp, BufferedImage image) {
		this.alturaPowerUp = alturaPowerUp;
		this.anchuraPowerUp = anchuraPowerUp;
		this.IMG = image;

	}

	// METODOS//

	public void inicializarPowerUp(int anchuraPantalla, int alturaPantalla) {

		this.posX = Math.random() * (anchuraPantalla - this.anchuraPowerUp) + (anchuraPowerUp / 2);
		this.posY = -1 * (Math.random() * (alturaPantalla - this.alturaPowerUp) + (alturaPowerUp / 2));
		System.out.println("X = " + posX);
		System.out.println("Y = " + posY);

	}

}
