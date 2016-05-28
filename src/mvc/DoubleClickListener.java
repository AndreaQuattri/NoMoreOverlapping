package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import controllerListener.InsertInTimeTable;


public class DoubleClickListener implements MouseListener {

	private Model model;
	private ViewTimeTable viewOrario;

	public DoubleClickListener(Model model, ViewTimeTable viewOrario) {
		this.setModel(model);
		this.viewOrario = viewOrario;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//se non è doppio click ritorno		



		System.out.println("Nella funzione");

		/*
		if(e.getClickCount() < 2){
			System.out.println("One click");
			return;
		}
		 */

		/*

		//Considero solo i click del pulsante sinistro;
		//se vuoi gestire l'evento anche se si fa dopppio
		//click col tasto destro commenta questo if
		if(e.getButton() != MouseEvent.BUTTON1){
			System.out.println("Tasto destro");
			return;
		}

		 */


		//Ricavo la tabella che ha prodotto l'evento
		JTable table = (JTable)e.getSource();
		//Calcolo la riga su cui si è fatto click
		int clickedRow = table.rowAtPoint(e.getPoint());
		int clickedCol = table.columnAtPoint(e.getPoint());
		//Se non è la riga che mi interessa ritorno



		UpdateTimeTable updateTimeTable = new UpdateTimeTable(model, clickedRow, clickedCol);
		updateTimeTable.setVisible(true);

		
		updateTimeTable.selectedGita(new SelectedGitaListener());
		updateTimeTable.insertGitaConvegno(new InsertInTimeTable(model, viewOrario , updateTimeTable));


	}


	private class SelectedGitaListener implements  ActionListener
	{
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
