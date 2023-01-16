package paquetePrincipal.ventanas.puntuacionesJTable;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import baseDeDatos.GestorBaseDatos;
import baseDeDatos.Partida;


public class pruebasJtable extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	protected GestorBaseDatos gestor = new GestorBaseDatos();
	
	protected List<Partida> partidas = new ArrayList<>();
	protected JTable tablaPuntuaciones = new JTable();
	
	
public pruebasJtable() {
	
	tablaPuntuaciones.setRowHeight(30);
	tablaPuntuaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
	((DefaultTableCellRenderer) tablaPuntuaciones.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
	
	
	this.add(new JScrollPane(tablaPuntuaciones), BorderLayout.CENTER);
	this.updateTablaPuntuaciones();
	setSize(1920, 1080);
	setVisible(true);
}
public void updateTablaPuntuaciones() {
	this.gestor.descargarDatosDeBaseDeDatosCompleta("BDPuntuaciones.db");
	this.partidas = gestor.getPartidasDeJuego();
	tablaPuntuaciones.setModel(new PuntuacionesJtableModel(partidas));	
	
	//Se define el render para todas las columnas de la tabla
	PuntuacionesRenderer tablaRenderer = new PuntuacionesRenderer();
	
	for (int i=0; i<tablaPuntuaciones.getColumnModel().getColumnCount(); i++) {
		tablaPuntuaciones.getColumnModel().getColumn(i).setCellRenderer(tablaRenderer);
	}
		
}
	


}
