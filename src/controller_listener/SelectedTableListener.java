/*
 * 
 */
package controller_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.MainView;
import mvc.Model;
import mvc.ViewTimeTable;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving selectedTable events.
 * The class that is interested in processing a selectedTable
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addSelectedTableListener<code> method. When
 * the selectedTable event occurs, that object's appropriate
 * method is invoked.
 *
 * @see SelectedTableEvent
 */
public class SelectedTableListener implements  ActionListener
{

	/** The model. */
	private Model model;

	/**
	 * Instantiates a new selected table listener.
	 *
	 * @param model the model
	 */

	public SelectedTableListener(Model model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{

		model.enableButtonAcquisisci(true);
		model.enableButtonAggiorna(true);

		model.enableInserisciButton(false);
		model.enableEliminaTable(false);
		model.enableModificaTable(false);

		//TODO
		/*
		 * 
		 * cancellare tabella, ecc..
		 * 
		 */



	}
}