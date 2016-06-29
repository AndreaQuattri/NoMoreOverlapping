/*
 * 
 */
package controller_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import mvc.MainView;
import mvc.ManagementTableView;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving updateRecord events.
 * The class that is interested in processing a updateRecord
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addUpdateRecordListener<code> method. When
 * the updateRecord event occurs, that object's appropriate
 * method is invoked.
 *
 * @see UpdateRecordEvent
 */
public class UpdateRecordListener implements  ActionListener
{
	
	/** The view. */
	private MainView view;
	
	/**
	 * Instantiates a new update record listener.
	 *
	 * @param view the view
	 */
	public UpdateRecordListener(MainView view) {
		// TODO Auto-generated constructor stub
		this.view = view;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{


		ManagementTableView managment;
		try {
			managment = new ManagementTableView((String) view.getComboBoxTable().getSelectedItem(),
																	(String) view.getComboBoxRecord().getSelectedItem());
			managment.setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
