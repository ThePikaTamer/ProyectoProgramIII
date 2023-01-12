package niveles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import paquetePrincipal.MotorJuego;
import paquetePrincipal.clasesPrincipales.Naves.NaveBase;
import paquetePrincipal.clasesPrincipales.asteroides.AsteroideBasico;
import paquetePrincipal.clasesPrincipales.asteroides.AsteroideDorado;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoBasico;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoReforzado;
import paquetePrincipal.clasesPrincipales.enemigos.EnemigoVeloz;

public class LvlLoader {



	// CADA NIVEL
	public static void cargaNvlDeFichero(int numeroNivel, MotorJuego motor) {
		List<NaveBase> navesEnPartida = new ArrayList<>();
		NaveBase jugador1 = motor.jugador1;
		NaveBase jugador2 = motor.jugador2;

		String ficheroNivel = "nivel" + numeroNivel + ".csv";

		leerNvlDeFichero(ficheroNivel, motor);

	}

	public static void leerNvlDeFichero(String ruta, MotorJuego motor) {

		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String linea;
			String[] lineaDiv;
			while ((linea = br.readLine()) != null) {
				lineaDiv = linea.split(";");
				String nombre = lineaDiv[0];
				int valor = Integer.parseInt(lineaDiv[1]);
				System.out.println(nombre + " - "+ valor);
				
				if(valor != 0) {
				if (nombre.equals("NumEnemigoBasicos")) {
					
					for (int i = 0; i < valor ; i++) {
						motor.enemigosVivos.anyadir(new EnemigoBasico());
					}
				} else if (nombre.equals("NumEnemigoVeloz")) {
					for (int i = 0; i < valor ; i++) {
						motor.enemigosVivos.anyadir(new EnemigoVeloz());
					}
				} else if (nombre.equals("NumEnemigoReforzados")) {
					for (int i = 0; i < valor ; i++) {
						motor.enemigosVivos.anyadir(new EnemigoReforzado());
					}
				} else if (nombre.equals("FrecEnemigos")) {
					motor.frecEnemigos = valor;
				} else if (nombre.equals("NumAsteroideBasicos")) {
					for (int i = 0; i < valor ; i++) {
						motor.asteroidesEnPantalla.anyadir(new AsteroideBasico());
					}
				} else if (nombre.equals("NumAsteroideDorado")) {
					for (int i = 0; i < valor ; i++) {
						motor.asteroidesEnPantalla.anyadir(new AsteroideDorado());
					}
				} else if (nombre.equals("FrecAsteroides")) {
					motor.frecAsteroides = valor;
				} else if (nombre.equals("FrecPowerUps")) {
					motor.frecPowerUps = valor;
				}
			}}
			System.out.println("ArrayEnemigos = "+ motor.enemigosVivos.arrayEnemigos.size() );
			System.out.println("ArrayAsteroides = "+ motor.asteroidesEnPantalla.arrayAsteroide.size() );

		}


		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
