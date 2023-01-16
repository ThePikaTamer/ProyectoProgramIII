package paquetePrincipal;

import java.time.LocalDate;

import javax.imageio.ImageIO;

import baseDeDatos.Usuario;
import paquetePrincipal.clasesPrincipales.Naves.NaveBasica;
import paquetePrincipal.clasesPrincipales.Naves.NaveDRapido;
import paquetePrincipal.ventanas.MainWindow;
import graficos.Assets;

public class Main {
	public static void main(String[] args) {
		int altura = 1080;
		int anchura = 1920;
		
		Assets.init();
		
		Usuario us1 = new Usuario(9876, "pruebaUsuario1", "pruebaGmail.com", LocalDate.now());
		Usuario us2 = new Usuario(6789, "pruebaUsuario2", "prueba2Gmail.com", LocalDate.now());
//		

//		new MotorJuego("Game", 0, new NaveBasica(null, CategoriaJugador.PLAYER1), new NaveDRapido(args, CategoriaJugador.PLAYER2), us1, us2, false);

		new MainWindow(null);
		//new MotorJuego("Game", 0, new NaveBasica(null, CategoriaJugador.PLAYER1), new NaveDRapido(args, CategoriaJugador.PLAYER2));

//		System.out.println("This is a test.");
	}
}

//ProyectoProgramIII