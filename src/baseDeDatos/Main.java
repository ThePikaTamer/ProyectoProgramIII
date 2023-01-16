package baseDeDatos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import paquetePrincipal.ventanas.puntuacionesJTable.pruebasJtable;

public class Main {

	public static void main(String[] args) {
		System.out.println(LocalDate.now().toString());
		GestorBaseDatos gb = new GestorBaseDatos();
		gb.descargarDatosDeBaseDeDatosCompleta(null);
		gb.ModosDeJuegoParaActualizar.add(new TipoJuego(654, "patata1", 1));
		gb.ModosDeJuegoParaActualizar.add(new TipoJuego(88, "patata2", 2));

		gb.usuariosDeJuegoParaActualizar.add(new Usuario(9999, "Juan", "Juan@gmail.com", "2000-10-23"));
		gb.usuariosDeJuegoParaActualizar.add(new Usuario(8888, "Maria", "Marybol@gmail.com", "2001-01-04"));

		gb.partidasDeJuegoParaActualizar.add(new Partida(993492, "2022-12-17", LocalTime.now(), 100000,
				new Usuario(9999, "Juan", "Juan@gmail.com", "2000-10-23"), null));
		gb.partidasDeJuegoParaActualizar.add(new Partida(133545, "2022-12-10", LocalTime.now(), 102234,
				new Usuario(9999, "Juan", "Juan@gmail.com", "2000-10-23"),
				new Usuario(8888, "Maria", "Marybol@gmail.com", "2001-01-04")));

		gb.actualizarPuntuaciones();
		
		new pruebasJtable();

	}
}
