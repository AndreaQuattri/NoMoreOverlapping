/*
 * 
 */
package controller_listener;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import mvc.Model;
import mvc.ViewTimeTable;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving selectedAll events.
 * The class that is interested in processing a selectedAll
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addSelectedAllListener<code> method. When
 * the selectedAll event occurs, that object's appropriate
 * method is invoked.
 *
 * @see SelectedAllEvent
 */
public class SelectedAllListener implements ActionListener{
	
	/** The model. */
	private Model model;
	
	/** The view orario. */
	private ViewTimeTable viewOrario;
	
	/**
	 * Instantiates a new selected all listener.
	 *
	 * @param model the model
	 * @param viewOrario the view orario
	 */
	public SelectedAllListener(Model model, ViewTimeTable viewOrario) {
		this.model = model;
		this.viewOrario = viewOrario;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		setAttributeToView();
		model.setTabella(new Vector<Vector<String>>());
		
		if(viewOrario.getTableRecords().getRowCount()!=0)
			for (int i = 0; i<21; i++){
				viewOrario.getTableRecords().removeRow(0);
			}

		model.fromOrarioUfficialeToTable();
		
		
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

				}
				}
			);

		}
		
	}
	
	/**
	 * Sets the attribute to view.
	 */
	private void setAttributeToView(){
		for (int i=0; i<viewOrario.getVisualizzaCorso().getItemCount(); i++)
			viewOrario.getVisualizzaCorso().getItem(i).setSelected(false);
		for (int i=0; i<viewOrario.getVisualizzaDocente().getItemCount(); i++)
			viewOrario.getVisualizzaDocente().getItem(i).setSelected(false);
		for (int i=0; i<viewOrario.getVisualizzaAttività().getItemCount(); i++)
			viewOrario.getVisualizzaAttività().getItem(i).setSelected(false);
	}

}
