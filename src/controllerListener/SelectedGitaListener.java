/*
 * 
 */
package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.Model;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving selectedGita events.
 * The class that is interested in processing a selectedGita
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addSelectedGitaListener<code> method. When
 * the selectedGita event occurs, that object's appropriate
 * method is invoked.
 *
 * @see SelectedGitaEvent
 */
public class SelectedGitaListener implements  ActionListener
{

	/** The model. */
	private Model model;

	/**
	 * Instantiates a new selected gita listener.
	 *
	 * @param model the model
	 */
	public SelectedGitaListener(Model model) {
		this.model = model;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{


		model.enableButtonInserisciGita(true);

		//TODO
		/*
		 * 
		 * cancellare tabella, ecc..
		 * 
		 */



	}
}