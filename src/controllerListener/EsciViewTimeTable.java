/*
 * 
 */
package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.ViewTimeTable;

// TODO: Auto-generated Javadoc
/**
 * The Class EsciViewTimeTable.
 */
public class EsciViewTimeTable implements ActionListener{

	
	/** The view orario. */
	private ViewTimeTable viewOrario;
	
	/**
	 * Instantiates a new esci view time table.
	 *
	 * @param viewOrario the view orario
	 */
	public EsciViewTimeTable(ViewTimeTable viewOrario) {
		this.viewOrario = viewOrario;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		viewOrario.getFrame().setVisible(false);

	}

}
