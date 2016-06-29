/*
 * 
 */
package controller_listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import mvc.Model;
import mvc.UpdateTimeTable;
import mvc.ViewTimeTable;


// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving doubleClick events.
 * The class that is interested in processing a doubleClick
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addDoubleClickListener<code> method. When
 * the doubleClick event occurs, that object's appropriate
 * method is invoked.
 *
 * @see DoubleClickEvent
 */
public class DoubleClickListener implements MouseListener {

	/** The model. */
	private Model model;
	
	/** The view orario. */
	private ViewTimeTable viewOrario;

	/**
	 * Instantiates a new double click listener.
	 *
	 * @param model the model
	 * @param viewOrario the view orario
	 */
	public DoubleClickListener(Model model, ViewTimeTable viewOrario) {
		this.model = model;
		this.viewOrario = viewOrario;
	}


	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

		//Ricavo la tabella che ha prodotto l'evento
		JTable table = (JTable)e.getSource();
		//Calcolo la riga su cui si è fatto click
		int clickedRow = table.rowAtPoint(e.getPoint());
		int clickedCol = table.columnAtPoint(e.getPoint());

		if (!(clickedCol == 6 && clickedRow>9) && clickedCol!=0){
			UpdateTimeTable updateTimeTable = new UpdateTimeTable(model, clickedRow, clickedCol, viewOrario.getButtonSem1().isSelected()==true? 1 : 2);
			updateTimeTable.setVisible(true);
			updateTimeTable.selectedGita(new SelectedGitaListener(model));
			updateTimeTable.insertGitaConvegno(new InsertInTimeTable(model, viewOrario , updateTimeTable));
		}

	}


	

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}


	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(Model model) {
		this.model = model;
	}


	/**
	 * Gets the view orario.
	 *
	 * @return the view orario
	 */
	public ViewTimeTable getViewOrario() {
		return viewOrario;
	}


	/**
	 * Sets the view orario.
	 *
	 * @param viewOrario the new view orario
	 */
	public void setViewOrario(ViewTimeTable viewOrario) {
		this.viewOrario = viewOrario;
	}

}
