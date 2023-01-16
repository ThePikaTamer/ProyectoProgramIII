package paquetePrincipal.ventanas.puntuacionesJTable;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import baseDeDatos.GestorBaseDatos;
import baseDeDatos.Partida;
import paquetePrincipal.ventanas.MainWindow;


public class pruebasJtable extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	protected GestorBaseDatos gestor = new GestorBaseDatos();
	
	protected List<Partida> partidas = new ArrayList<>();
	protected JTable tablaPuntuaciones = new JTable();
	protected JPanel panelSuperior = new JPanel();
	protected JButton bBack = new JButton("BACK");
	protected JButton bBorrar = new JButton("Borrar");
	protected JLabel lPartidas = new JLabel("PARTIDAS");
	
	
	protected ActionListener listenerBORRAR = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(tablaPuntuaciones.getSelectedRow() != -1) {
			gestor.borrarPartidaBD(partidas.get(tablaPuntuaciones.getSelectedRow()));
			updateTablaPuntuaciones();
			}else {
				bBorrar.setEnabled(false);
			}
		}
	};
	protected ActionListener listenerBACK = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new MainWindow(null);
			dispose();
			
		}
	};
	
public pruebasJtable(GestorBaseDatos gestor, JFrame ventanaAnterior) {
	this.gestor = gestor;
	setTitle("TablaPartidas");
	setLocation(ventanaAnterior.getLocation());
	
	tablaPuntuaciones.setRowHeight(30);
	tablaPuntuaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
	((DefaultTableCellRenderer) tablaPuntuaciones.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
	
	
	
	bBack.addActionListener(listenerBACK);
	bBorrar.addActionListener(listenerBORRAR);
	bBorrar.setEnabled(false);
	
	lPartidas.setFont(new Font("Impulso", Font.BOLD, 40));
	lPartidas.setHorizontalAlignment(JLabel.CENTER);
	
	bBorrar.setFont(new Font("Impulso2", Font.ITALIC, 20));
	bBack.setFont(new Font("Impulso3", Font.ITALIC, 20));
	
	
	panelSuperior.setLayout(new BorderLayout());
	panelSuperior.add(bBack, BorderLayout.WEST);
	panelSuperior.add(lPartidas, BorderLayout.CENTER);
	panelSuperior.add(bBorrar, BorderLayout.EAST);
	this.add(panelSuperior, BorderLayout.NORTH);
	
	
	
	
	
	
	this.add(new JScrollPane(tablaPuntuaciones), BorderLayout.CENTER);
	this.updateTablaPuntuaciones();

	setSize(1800, 1000);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setVisible(true);
	
	tablaPuntuaciones.addFocusListener(new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			
			
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			bBorrar.setEnabled(true);
			
		}
	});
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
