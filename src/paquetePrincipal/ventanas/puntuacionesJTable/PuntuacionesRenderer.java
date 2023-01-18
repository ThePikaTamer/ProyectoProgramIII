package paquetePrincipal.ventanas.puntuacionesJTable;

import java.awt.Component;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import baseDeDatos.Usuario;

public class PuntuacionesRenderer implements TableCellRenderer {

	protected boolean borrable = false;
	
	
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JLabel label = new JLabel();
		label.setBackground(table.getBackground());
		label.setHorizontalAlignment(JLabel.CENTER);
		
		if(column == 1) {
			label.setText(((LocalDate)value).toString());
		}
		if(column == 2) {
			label.setText(((LocalTime)value).toString().substring(0,8));
		}
		
		if(column == 0 || column == 3) {
			label.setText(value.toString());
		}
		if(column == 4 || column == 5) {
			if(value != null) {
			
			label.setText(((Usuario)value).getNickUsuario());
			}else {
				label.setText("----");
			}
		}
		if (isSelected) {
			label.setBackground(table.getSelectionBackground());
			label.setForeground(table.getSelectionForeground());
			this.borrable = true;
		}
		
		label.setOpaque(true);
		
		return label;
	}
	

}
