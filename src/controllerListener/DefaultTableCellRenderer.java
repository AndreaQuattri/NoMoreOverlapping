/*
 * 
 */
package controllerListener;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;


// TODO: Auto-generated Javadoc
/**
 * The Class DefaultTableCellRenderer.
 */
public class DefaultTableCellRenderer {




		/**
		 * Gets the table cell renderer component.
		 *
		 * @param table the table
		 * @param value the value
		 * @param isSelected the is selected
		 * @param hasFocus the has focus
		 * @param row the row
		 * @param column the column
		 * @return the table cell renderer component
		 */
		public  static Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
		{
			Component cell = getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);

			if (value == null)
				return null;

			if (value.equals("0")){
				cell.setBackground( Color.gray );
				cell.setForeground(Color.gray);
			}
			else{
				if (value.equals("1")){
					cell.setBackground( Color.green );
					cell.setForeground(Color.green);
				}
				else{
					cell.setBackground( Color.red );
					cell.setForeground(Color.red);
				}

			}

			return cell;

	}
}