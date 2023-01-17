package paquetePrincipal.clasesPrincipales.Naves;

import java.awt.image.BufferedImage;

import clasesLogicas.Vector2D;
import graficos.Assets;
import paquetePrincipal.CategoriaJugador;

public class NaveVeloz extends NaveBase {
	
	private final static double RADIO_NAVE = 25;
	private final static int VIDA = 2;
	private final static double VEL_DISP = 35;
	private final static double VEL_MAX = 6;
	private final static double VEL_ROT = 0.1;
	protected static BufferedImage IMG = Assets.naveVeloz;
	protected static BufferedImage IMG2 = Assets.naveVeloz_P1;
	protected static BufferedImage IMG3 = Assets.naveVeloz_P2;

	public NaveVeloz(Object habilidad, CategoriaJugador tipoJugador) {
		super(RADIO_NAVE, VIDA, VEL_DISP, VEL_MAX, VEL_ROT, IMG, tipoJugador, habilidad, new Vector2D(0, 0));
		if (tipoJugador == CategoriaJugador.PLAYER1) {
			this.getCicloAnimacion().add(0, IMG);
			this.getCicloAnimacion().add(1, IMG2);
			this.setDibujoInicial();
		} else if (tipoJugador == CategoriaJugador.PLAYER2) {
			this.getCicloAnimacion().add(0, IMG);
			this.getCicloAnimacion().add(1, IMG3);
			this.setDibujoInicial();
		}
	}

}
