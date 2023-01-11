package paquetePrincipal;

import javax.imageio.ImageIO;

import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;
import paquetePrincipal.clasesPrincipales.Naves.NaveDRapido;
import paquetePrincipal.ventanas.MainWindow;
import graficos.Assets;

public class Main {
	public static void main(String[] args) {
		int altura = 1080;
		int anchura = 1920;
		
		Assets.init();
		//new MotorJuego("My Game");
//		System.out.println(HojaSprites.class.getResource("C:\\Users\\ander\\git\\Prog\\ProyectoProgramIII\\recursos\\texturas"));
//HojaSprites hoja = new HojaSprites("/imagenes/primero.png", anchura, altura);

//		
		new MotorJuego("Game", 0, new NaveBasica(null, CategoriaJugador.PLAYER1), new NaveDRapido(args, CategoriaJugador.PLAYER2));
//		System.out.println("This is a test.");
	}
}

//ProyectoProgramIII