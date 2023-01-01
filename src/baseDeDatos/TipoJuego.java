package baseDeDatos;

public class TipoJuego {
	protected int idTipoJuego;
	protected String nomTJuego;
	protected int NumJugadores;

	public TipoJuego(int idTipoJuego, String nomTJuego, int numJugadores) {
		super();
		this.idTipoJuego = idTipoJuego;
		this.nomTJuego = nomTJuego;
		NumJugadores = numJugadores;
	}

	public int getIdTipoJuego() {
		return idTipoJuego;
	}

	public void setIdTipoJuego(int idTipoJuego) {
		this.idTipoJuego = idTipoJuego;
	}

	public String getNomTJuego() {
		return nomTJuego;
	}

	public void setNomTJuego(String nomTJuego) {
		this.nomTJuego = nomTJuego;
	}

	public int getNumJugadores() {
		return NumJugadores;
	}

	public void setNumJugadores(int numJugadores) {
		NumJugadores = numJugadores;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.idTipoJuego + " - " + this.nomTJuego + " - " + this.NumJugadores;
	}

}
