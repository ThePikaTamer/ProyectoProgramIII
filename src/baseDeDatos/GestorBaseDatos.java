package baseDeDatos;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteException;

public class GestorBaseDatos {
	protected List<TipoJuego> ModosDeJuego;
	protected List<Usuario> usuariosDeJuego;
	protected List<Partida> partidasDeJuego;
	protected final String baseDeDatos = "BDPuntuaciones.db";

	protected List<TipoJuego> ModosDeJuegoParaActualizar;
	protected List<Usuario> usuariosDeJuegoParaActualizar;
	protected List<Partida> partidasDeJuegoParaActualizar;

	public GestorBaseDatos() {
		this.ModosDeJuego = new ArrayList<>();
		this.usuariosDeJuego = new ArrayList<>();
		this.partidasDeJuego = new ArrayList<>();
		this.ModosDeJuegoParaActualizar = new ArrayList<>();
		this.usuariosDeJuegoParaActualizar = new ArrayList<>();
		this.partidasDeJuegoParaActualizar = new ArrayList<>();
		this.inicializarConexion();

	};

	public GestorBaseDatos(List<TipoJuego> modosDeJuego, List<Usuario> usuariosDeJuego, List<Partida> partidasDeJuego) {
		super();
		ModosDeJuego = modosDeJuego;
		this.usuariosDeJuego = usuariosDeJuego;
		this.partidasDeJuego = partidasDeJuego;
		this.inicializarConexion();
	}

	public List<TipoJuego> getModosDeJuegoParaActualizar() {
		return ModosDeJuegoParaActualizar;
	}

	public void setModosDeJuegoParaActualizar(List<TipoJuego> modosDeJuegoParaActualizar) {
		ModosDeJuegoParaActualizar = modosDeJuegoParaActualizar;
	}

	public List<Usuario> getUsuariosDeJuegoParaActualizar() {
		return usuariosDeJuegoParaActualizar;
	}

	public void setUsuariosDeJuegoParaActualizar(List<Usuario> usuariosDeJuegoParaActualizar) {
		this.usuariosDeJuegoParaActualizar = usuariosDeJuegoParaActualizar;
	}

	public List<Partida> getPartidasDeJuegoParaActualizar() {
		return partidasDeJuegoParaActualizar;
	}

	public void setPartidasDeJuegoParaActualizar(List<Partida> partidasDeJuegoParaActualizar) {
		this.partidasDeJuegoParaActualizar = partidasDeJuegoParaActualizar;
	}

	public List<TipoJuego> getModosDeJuego() {
		return ModosDeJuego;
	}

	public void setModosDeJuego(List<TipoJuego> modosDeJuego) {
		ModosDeJuego = modosDeJuego;
	}

	public List<Usuario> getUsuariosDeJuego() {
		return usuariosDeJuego;
	}

	public void setUsuariosDeJuego(List<Usuario> usuariosDeJuego) {
		this.usuariosDeJuego = usuariosDeJuego;
	}

	public List<Partida> getPartidasDeJuego() {
		return partidasDeJuego;
	}

	public void setPartidasDeJuego(List<Partida> partidasDeJuego) {
		this.partidasDeJuego = partidasDeJuego;
	}

	// METODOS

	public void inicializarConexion() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha podido cargar el driver de la base de datos");
		}

	}

	public void descargarDatosDeBaseDeDatosCompleta(String DireccionBD) {
		List<TipoJuego> resultadoTipoJuegos = new ArrayList<>();
		List<Usuario> resultadoUsuarios = new ArrayList<>();
		List<Partida> resultadoPartidas = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + this.baseDeDatos)) {

			try (Statement selectCarga = conn.createStatement()) {

				// CONSULTA DE TIPOS DE JUEGO
				ResultSet rs = selectCarga.executeQuery("SELECT * FROM TIPOJUEGO");
				while (rs.next()) {
					TipoJuego tj = new TipoJuego(rs.getInt("ID_TJ"), rs.getString("NOM_TJ"), rs.getInt("NUM_JUG"));
					resultadoTipoJuegos.add(tj);
					System.out.println(tj);// PRUEBAS

				}
				System.out.println("-- FIN TIPOJUEGOS"); // PRUEBAS
				this.ModosDeJuego = resultadoTipoJuegos;
				rs.close();

				// CONSULTA DE USUARIOS
				ResultSet rs2 = selectCarga.executeQuery("SELECT * FROM USUARIO");

				while (rs2.next()) {
					try {
						java.util.Date fechaJ = new SimpleDateFormat("yyyy-mm-dd").parse(rs2.getString("FECHA_NAC"));
						java.sql.Date fechaSQL = new java.sql.Date(fechaJ.getTime());

						Usuario u = new Usuario(rs2.getInt("ID_US"), rs2.getString("NICKNAME"), rs2.getString("CORREO"),
								fechaSQL.toLocalDate());
						resultadoUsuarios.add(u);
						System.out.println(u);// PRUEBAS

					} catch (ParseException e) {
						System.err.println("Truncado fallido");
					}

				}
				System.out.println("-- FIN USUARIOS"); // PRUEBAS
				this.usuariosDeJuego = resultadoUsuarios;
				rs2.close();

				// CONSULTA DE PARTIDAS
				ResultSet rs3 = selectCarga.executeQuery("SELECT * FROM PARTIDA");

				while (rs3.next()) {

					try {

						java.util.Date fechaP = new SimpleDateFormat("yyyy-mm-dd").parse(rs3.getString("FECHA_PAR"));
						java.sql.Date fechaPartidaSQL = new java.sql.Date(fechaP.getTime());

						LocalTime horaP = LocalTime.parse(rs3.getString("HORA_PAR"));
						// PASAR DE ID A USUARIO
						Usuario jugador1 = null;
						Usuario jugador2 = null;
						for (Usuario us : this.usuariosDeJuego) {
							if (us.getIdUsuario() == rs3.getInt("JUGADOR1")) {
								jugador1 = us;
							} else if (us.getIdUsuario() == rs3.getInt("JUGADOR2")) {
								jugador2 = us;
							}
						}

						Partida partida = new Partida(rs3.getInt("ID_PAR"), fechaPartidaSQL.toLocalDate(), horaP,
								rs3.getInt("PUNTOS"), jugador1, jugador2);
						resultadoPartidas.add(partida);
						System.out.println(partida);// PRUEBAS
					} catch (ParseException e) {
						// TODO: handle exception
					}

				}

				System.out.println("-- FIN PARTIDAS"); // PRUEBAS
				this.partidasDeJuego = resultadoPartidas;
				rs3.close();

			} catch (SQLException e) {
				System.err.println("stmt");
			}

		} catch (SQLException e) {
			System.err.println("conn");
		}

	}

	public void actualizarPuntuaciones() {
		// CARGA DE TIPOSDEJUEGO
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + this.baseDeDatos)) {

			if (this.getModosDeJuegoParaActualizar() != null) {
				try (PreparedStatement insertTJ = conn
						.prepareStatement("INSERT INTO TIPOJUEGO (ID_TJ, NOM_TJ, NUM_JUG) VALUES(?,?,?)")) {

					for (TipoJuego cadaTJ : this.ModosDeJuegoParaActualizar) {
						if (!this.ListaClavesTipoJuego().contains(cadaTJ.getIdTipoJuego())) {
							insertTJ.setInt(1, cadaTJ.getIdTipoJuego());
							insertTJ.setString(2, cadaTJ.getNomTJuego());
							insertTJ.setInt(3, cadaTJ.getNumJugadores());
							System.out.println(insertTJ.toString());
							insertTJ.executeUpdate();
						}
					}
					this.descargarDatosDeBaseDeDatosCompleta(baseDeDatos);
					this.ModosDeJuegoParaActualizar = new ArrayList<>();
				}
			}
		//CARGA DE USUARIOS
			if (this.getUsuariosDeJuegoParaActualizar() != null) {
				try (PreparedStatement insertUs = conn
						.prepareStatement("INSERT INTO USUARIO (ID_US, NICKNAME, CORREO, FECHA_NAC) VALUES(?,?,?,?)")) {

					for(Usuario cadaUs : this.usuariosDeJuegoParaActualizar) {
						if(!this.ListaClavesUsuarios().contains(cadaUs.getIdUsuario())) {
							insertUs.setInt(1, cadaUs.getIdUsuario());
							insertUs.setString(2, cadaUs.getNickUsuario());
							insertUs.setString(3, cadaUs.getCorreo());
							insertUs.setString(4, cadaUs.getFechanacimiento().toString());
							System.out.println(insertUs.toString());
							insertUs.executeUpdate();
						}
					}
					this.descargarDatosDeBaseDeDatosCompleta(baseDeDatos);
					this.usuariosDeJuegoParaActualizar = new ArrayList<>();
				}

			}
		//CARGA DE USUARIO
			if(this.getPartidasDeJuego() != null) {
				try(PreparedStatement insertP = conn.prepareStatement("INSERT INTO PARTIDA (ID_PAR,FECHA_PAR, HORA_PAR, PUNTOS, JUGADOR1, JUGADOR2) VALUES (?,?,?,?,?,?)")){
					for(Partida cadaP : this.partidasDeJuegoParaActualizar) {
						if(!this.ListaClavesPartidas().contains(cadaP.getIDPartida())) {
							insertP.setInt(1, cadaP.getIDPartida());
							insertP.setString(2, cadaP.getFechaPartida().toString());
							insertP.setString(3, cadaP.getHoraPartida().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
							insertP.setInt(4, cadaP.getPuntos());
							if(cadaP.getJugador1()!= null) 	insertP.setInt(5, cadaP.getJugador1().getIdUsuario());
							if(cadaP.getJugador2()!= null)insertP.setInt(6, cadaP.getJugador2().getIdUsuario());

							System.out.println(insertP.toString());//PRUEBA
							insertP.executeUpdate();
						}
						this.descargarDatosDeBaseDeDatosCompleta(baseDeDatos);
						this.partidasDeJuegoParaActualizar = new ArrayList<>();
						
					}
					
					
					
					
				}
				
				
			}
			
			// EXCEPCIONES DE TODOS LOS STATEMENTS
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Integer> ListaClavesTipoJuego() {
		List<Integer> result = new ArrayList<>();
		for (TipoJuego tipoJ : this.getModosDeJuego()) {
			result.add(tipoJ.getIdTipoJuego());
		}
		return result;

	}

	public List<Integer> ListaClavesUsuarios() {
		List<Integer> result = new ArrayList<>();
		for (Usuario us : this.getUsuariosDeJuego()) {
			result.add(us.getIdUsuario());
		}
		return result;

	}

	public List<Integer> ListaClavesPartidas() {
		List<Integer> result = new ArrayList<>();
		for (Partida p : this.getPartidasDeJuego()) {
			result.add(p.getIDPartida());
		}
		return result;

	}

}
