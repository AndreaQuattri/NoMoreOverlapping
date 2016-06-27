/*
 * 
 */
package controllerListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import mvc.Model;
import mvc.ViewTimeTable;
import myComponents.Attività;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving selectedActivity events.
 * The class that is interested in processing a selectedActivity
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addSelectedActivityListener<code> method. When
 * the selectedActivity event occurs, that object's appropriate
 * method is invoked.
 *
 * @see SelectedActivityEvent
 */
public class SelectedActivityListener implements  ActionListener
{

	/** The model. */
	private Model model;
	
	/** The view orario. */
	private ViewTimeTable viewOrario;
	
	/** The nome attività. */
	private String nomeAttività;

	/**
	 * Instantiates a new selected activity listener.
	 *
	 * @param model the model
	 * @param viewOrario the view orario
	 * @param nomeAttività the nome attività
	 */
	public SelectedActivityListener(Model model, ViewTimeTable viewOrario, String nomeAttività) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.viewOrario = viewOrario;
		this.nomeAttività = nomeAttività;
	}


	@Override
	public void actionPerformed(ActionEvent action)
	{

		// gestione selezioni
		setAttributeToView();
		
		// inizializzare la tabella nel model
		model.setTabella(new Vector<Vector<String>>());

		// inizializza la tabella mostrata
		if(viewOrario.getTableRecords().getRowCount()!=0)
			for (int i = 0; i<21; i++){
				viewOrario.getTableRecords().removeRow(0);
			}
		
		
		// trovo l'attività per il nome
		Iterator<Attività> iAtt = model.getListAllAttivitàInserite().iterator();
		Attività attivitàSelezionata = null;
		while( iAtt != null && iAtt.hasNext() ) {
			attivitàSelezionata = iAtt.next();
			if(nomeAttività.equals(attivitàSelezionata.getNome()))
				iAtt = null;
		}
		model.filtraOrario(attivitàSelezionata);

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
							cell.setBackground( Color.BLUE );
							cell.setForeground(Color.BLUE);
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
	
	/**
	 * Sets the attribute to view.
	 */
	private void setAttributeToView(){
		String appoggio;
		for (int i=0; i<viewOrario.getVisualizzaAttività().getItemCount(); i++){
			appoggio = viewOrario.getVisualizzaAttività().getItem(i).getText();
			if (appoggio.equals(nomeAttività))
				viewOrario.getVisualizzaAttività().getItem(i).setSelected(true);
			else
				viewOrario.getVisualizzaAttività().getItem(i).setSelected(false);
		}
		for (int i=0; i<viewOrario.getVisualizzaCorso().getItemCount(); i++)
			viewOrario.getVisualizzaCorso().getItem(i).setSelected(false);
		for (int i=0; i<viewOrario.getVisualizzaDocente().getItemCount(); i++)
			viewOrario.getVisualizzaDocente().getItem(i).setSelected(false);
		viewOrario.getVisualizzaTutto().getItem(0).setSelected(false);


	}
	
}