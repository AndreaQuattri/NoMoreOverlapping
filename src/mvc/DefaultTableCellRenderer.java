package mvc;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;


public class DefaultTableCellRenderer {




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