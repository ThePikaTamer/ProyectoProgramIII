package paquetePrincipal.ventanas.puntuacionesJTable;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import baseDeDatos.Partida;

public class PuntuacionesJtableModel extends DefaultTableModel{

	private static final long serialVersionUID = 1L;
	
	private List<Partida> partidas;
	private final List<String> cabeceras = Arrays.asList(
			"ID",
			"FECHA",
			"HORA",
			"PUNTOS",
			"JUGADOR1",
			"JUGADOR2"
			
			);
	
	public PuntuacionesJtableModel(List<Partida> partidas) {
		this.partidas = partidas;
	}
	@Override
	public String getColumnName(int column) {
		return cabeceras.get(column);
	}

	@Override
	public int getRowCount() {
		if (partidas != null) {
			return partidas.size();
		} else { 
			return 0;
		}
	}
@Override
public int getColumnCount() {
	return cabeceras.size();
}
@Override
public boolean isCellEditable(int row, int column) {
	return false;
}

@Override
public void setValueAt(Object aValue, int row, int column) {
}
@Override
public Object getValueAt(int row, int column) {
	Partida partida = partidas.get(row);
	
	switch(column) {
	case 0: return partida.getIDPartida();
	case 1: return partida.getFechaPartida();
	case 2: return partida.getHoraPartida();
	case 3: return Integer.valueOf(partida.getPuntos());
	case 4: return partida.getJugador1();
	case 5: return partida.getJugador2();
	default: return null;
	
	}
}

}
