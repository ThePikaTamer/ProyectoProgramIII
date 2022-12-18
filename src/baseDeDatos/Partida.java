package baseDeDatos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Partida {

	protected int IDPartida;
	protected LocalDate fechaPartida;
	protected LocalTime horaPartida;
	protected int puntos;
	protected Usuario jugador1;
	protected Usuario jugador2;
	
	
	
	
	

	
	
	
	
	public Partida(int iDPartida, LocalDate fechaPartida, LocalTime horaPartida, int puntos, Usuario jugador1,
			Usuario jugador2) {
		super();
		IDPartida = iDPartida;
		this.fechaPartida = fechaPartida;
		this.horaPartida = horaPartida;
		this.puntos = puntos;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	public Partida(int iDPartida, String fechaPartida, LocalTime horaPartida, int puntos, Usuario jugador1,
			Usuario jugador2) {
		super();
		IDPartida = iDPartida;
		this.setFechaPartida(null, fechaPartida);
		this.horaPartida = horaPartida;
		this.puntos = puntos;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}

	
	
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Usuario getJugador1() {
		return jugador1;
	}
	public void setJugador1(Usuario jugador1) {
		this.jugador1 = jugador1;
	}
	public Usuario getJugador2() {
		return jugador2;
	}
	public void setJugador2(Usuario jugador2) {
		this.jugador2 = jugador2;
	}
	public void setFechaPartida(LocalDate fechaPartida) {
		this.fechaPartida = fechaPartida;
	}
	public int getIDPartida() {
		return IDPartida;
	}
	public void setIDPartida(int iDPartida) {
		IDPartida = iDPartida;
	}
	public LocalDate getFechaPartida() {
		return fechaPartida;
	}
	public void setFechaPartida(LocalDate fechaPartida, String fechaFormateada) {
		if (fechaFormateada != null) {
			try {
				java.util.Date fechaP = new SimpleDateFormat("yyyy-mm-dd").parse(fechaFormateada);
				java.sql.Date fechaPSQL = new java.sql.Date(fechaP.getTime());
				this.fechaPartida = fechaPSQL.toLocalDate();
			} catch (ParseException e) {
				System.err.println("parseo incorrecto");
			}
		}
		if (fechaPartida != null) {
			this.fechaPartida = fechaPartida;
		}

	}
	public LocalTime getHoraPartida() {
		return horaPartida;
	}
	public void setHoraPartida(LocalTime horaPartida) {
		this.horaPartida = horaPartida;
	}
	
	
	@Override
	public String toString() {
		
		return this.IDPartida + " - " + this.puntos+ " - "+this.fechaPartida+" - "+this.horaPartida+ " - ["+ this.jugador1+ "] - ["+ this.jugador2+"]";
	}
	
	
	
	
	
}
