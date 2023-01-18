package paquetePrincipal.clasesPrincipales.Naves;

import java.awt.image.BufferedImage;

import clasesLogicas.Vector2D;
import graficos.Assets;
import paquetePrincipal.CategoriaJugador;

public class NaveBasica extends NaveBase {

	protected static CategoriaJugador tipoJugador;
	private final static double RADIO_NAVE = 20;
	private final static int VIDA = 3;
	private final static double VEL_DISP = 35;
	private final static double VEL_MAX = 3;
	private final static double VEL_ROT = 0.08;
	protected static BufferedImage IMG = Assets.naveBasica;
	protected static BufferedImage IMG2 = Assets.naveBasica_P1;
	protected static BufferedImage IMG3 = Assets.naveBasica_P2;

	public NaveBasica(Object habilidad, CategoriaJugador tipoJugador) {
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
