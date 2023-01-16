package paquetePrincipal.clasesPrincipales.asteroides;

import java.awt.Point;
import java.awt.image.BufferedImage;

import graficos.Assets;
import paquetePrincipal.Puntuacion;

public class AsteroideDorado extends Asteroide {
	protected static BufferedImage IMG = Assets.asteroideBasico2;
	private final static double RADIO_EN = 30;
	private final static int VIDA =  5;
	private final static double DANYO_CHOQUE = 1;
	private final static double VEL_X = 2;
	private final static double VEL_Y = 2;
	private final static Puntuacion PUNT = new Puntuacion(2000);

	public AsteroideDorado() {
	// TODO Auto-generated constructor stub
		super( VIDA, DANYO_CHOQUE, IMG, new Point(0, 0),RADIO_EN );
			
		

}
}