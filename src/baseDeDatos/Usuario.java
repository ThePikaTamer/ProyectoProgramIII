package baseDeDatos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Usuario {

	protected int idUsuario;
	protected String nickUsuario;
	protected String correo;
	protected LocalDate fechanacimiento;

	public Usuario(int idUsuario, String nickUsuario, String correo, LocalDate fechanacimiento) {
		super();
		this.idUsuario = idUsuario;
		this.nickUsuario = nickUsuario;
		this.correo = correo;
		this.fechanacimiento = fechanacimiento;
	}

	public Usuario(int idUsuario, String nickUsuario, String correo, String fechanacimiento) {
		super();
		this.idUsuario = idUsuario;
		this.nickUsuario = nickUsuario;
		this.correo = correo;
		this.setFechanacimiento(null, fechanacimiento);
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNickUsuario() {
		return nickUsuario;
	}

	public void setNickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalDate getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(LocalDate fechanacimiento, String fechaFormateada) {
		if (fechaFormateada != null) {
			try {
				java.util.Date fechaN = new SimpleDateFormat("yyyy-mm-dd").parse(fechaFormateada);
				java.sql.Date fechaNacSQL = new java.sql.Date(fechaN.getTime());
				this.fechanacimiento = fechaNacSQL.toLocalDate();
			} catch (ParseException e) {
				System.err.println("parseo incorrecto");
			}
		}
		if (fechanacimiento != null) {
			this.fechanacimiento = fechanacimiento;
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getIdUsuario() + " - " + this.getNickUsuario() + " - " + this.correo + " - "
				+ this.fechanacimiento.toString();
	}

}
