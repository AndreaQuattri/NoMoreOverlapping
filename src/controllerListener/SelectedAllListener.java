package controllerListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import mvc.Model;
import mvc.ViewTimeTable;

public class SelectedAllListener implements ActionListener{
	
	private Model model;
	private ViewTimeTable viewOrario;
	
	public SelectedAllListener(Model model, ViewTimeTable viewOrario) {
		this.model = model;
		this.viewOrario = viewOrario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		for (int i=0; i<viewOrario.getVisualizzaCorso().getItemCount(); i++)
			viewOrario.getVisualizzaCorso().getItem(i).setSelected(false);
		for (int i=0; i<viewOrario.getVisualizzaDocente().getItemCount(); i++)
			viewOrario.getVisualizzaDocente().getItem(i).setSelected(false);
		for (int i=0; i<viewOrario.getVisualizzaAttività().getItemCount(); i++)
			viewOrario.getVisualizzaAttività().getItem(i).setSelected(false);
		

		model.setTabella(new Vector<Vector<String>>());
		model.fromOrarioToTable();
		
		if(viewOrario.getTableRecords().getRowCount()!=0)
		for (int i = 0; i<21; i++){
			viewOrario.getTableRecords().removeRow(0);
		}


				for(int i=0; i<21; i++){
					viewOrario.getTableRecords().addRow(model.getTabella().get(i));
				}

				for (int i=1; i<7; i++){
					viewOrario.getTable().getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
						{
							Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);

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

						}});

				}
		
	}

}
