package controllerListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import mvc.Model;
import mvc.UpdateTimeTable;
import mvc.ViewTimeTable;


public class DoubleClickListener implements MouseListener {

	private Model model;
	private ViewTimeTable viewOrario;

	public DoubleClickListener(Model model, ViewTimeTable viewOrario) {
		this.setModel(model);
		this.viewOrario = viewOrario;
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		//Ricavo la tabella che ha prodotto l'evento
		JTable table = (JTable)e.getSource();
		//Calcolo la riga su cui si è fatto click
		int clickedRow = table.rowAtPoint(e.getPoint());
		int clickedCol = table.columnAtPoint(e.getPoint());

		if (!(clickedCol == 6 && clickedRow>9)){
			UpdateTimeTable updateTimeTable = new UpdateTimeTable(model, clickedRow, clickedCol, viewOrario.getButtonSem1().isSelected()==true? 1 : 2);
			updateTimeTable.setVisible(true);
			updateTimeTable.selectedGita(new SelectedGitaListener(model));
			updateTimeTable.insertGitaConvegno(new InsertInTimeTable(model, viewOrario , updateTimeTable));
		}

	}


	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	public Model getModel() {
		return model;
	}


	public void setModel(Model model) {
		this.model = model;
	}


	public ViewTimeTable getViewOrario() {
		return viewOrario;
	}


	public void setViewOrario(ViewTimeTable viewOrario) {
		this.viewOrario = viewOrario;
	}

}
