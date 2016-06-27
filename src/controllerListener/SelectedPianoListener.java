/*
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving selectedPiano events.
 * The class that is interested in processing a selectedPiano
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addSelectedPianoListener<code> method. When
 * the selectedPiano event occurs, that object's appropriate
 * method is invoked.
 *
 * @see SelectedPianoEvent
 */
public class SelectedPianoListener implements  ActionListener
{

	/** The model. */
	private Model model;
	
	/** The view orario. */
	private ViewTimeTable viewOrario;
	
	/** The codice. */
	private String codice;

	/**
	 * Instantiates a new selected piano listener.
	 *
	 * @param model the model
	 * @param viewOrario the view orario
	 * @param codice the codice
	 */
	public SelectedPianoListener(Model model, ViewTimeTable viewOrario, String codice) {
		this.model = model;
		this.viewOrario = viewOrario;
		this.codice = codice;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{

		
		setAttributeToView();

		model.setTabella(new Vector<Vector<String>>());

		if(viewOrario.getTableRecords().getRowCount()!=0)
			for (int i = 0; i<21; i++){
				viewOrario.getTableRecords().removeRow(0);
			}


		model.filtraOrarioPerCorso(codice);

		model.fromOrarioDaMostrareToTable();
		
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
							cell.setBackground(Color.BLUE);
							cell.setForeground(Color.BLUE);
						}

						else{
							cell.setBackground( Color.RED );
							cell.setForeground(Color.RED);
						}


					}
					return cell;

				}});

		}



	}
	
	
	/**
	 * Sets the attribute to view.
	 */
	private void setAttributeToView(){
		String[] appoggio;
		for (int i=0; i<viewOrario.getVisualizzaCorso().getItemCount(); i++){
			appoggio = viewOrario.getVisualizzaCorso().getItem(i).getText().split("-");
			if (appoggio[0].trim().equals(codice))
				viewOrario.getVisualizzaCorso().getItem(i).setSelected(true);
			else
				viewOrario.getVisualizzaCorso().getItem(i).setSelected(false);

		}
		for (int i=0; i<viewOrario.getVisualizzaAttività().getItemCount(); i++)
			viewOrario.getVisualizzaAttività().getItem(i).setSelected(false);
		for (int i=0; i<viewOrario.getVisualizzaDocente().getItemCount(); i++)
			viewOrario.getVisualizzaDocente().getItem(i).setSelected(false);
		viewOrario.getVisualizzaTutto().getItem(0).setSelected(false);

	}
}