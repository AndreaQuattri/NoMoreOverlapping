package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;


public class DoubleClickListener implements MouseListener {

	private Model model;
	private ViewTimeTable viewOrario;

	public DoubleClickListener(Model model) {
		this.setModel(model);
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

		/*
		int countDay = 0;
		int j=0;

		for (; countDay<clickedCol; j++){
			if(model.getListOrario().get(j).getElencoAssegnamenti().size()!=0 
					&& model.getListOrario().get(j).getElencoAssegnamenti().get(0).getFasciaOraria().getInizio().toString().equals("Thu Jan 01 08:30:00 CET 1970")){
				countDay++;
			}

		}

		int numDiscipline = model.getListOrario().get(clickedRow + j - 1).getElencoAssegnamenti().size();
		int indice = clickedRow + j - 1;
		int bound = 100;


		if (numDiscipline!=0){
		updateOrario.setLabelDisciplina( new JLabel(model.getListOrario().get(indice).getElencoAssegnamenti().get(0).getFasciaOraria().getInizio().toString().substring(11, 19) + " - " + 
				model.getListOrario().get(indice).getElencoAssegnamenti().get(0).getFasciaOraria().getFine().toString().substring(11, 19) ) );
		updateTimeTable.getLabelDisciplina().setBounds(100, 70, 500, 29);
		updateTimeTable.getContentPane().add(updateTimeTable.getLabelDisciplina());
		}

		for (int i=0; i<numDiscipline; i++){
			updateOrario.setLabelDisciplina( new JLabel(model.getListOrario().get(indice).getElencoAssegnamenti().get(i).getAttività().getNome().toString() + " - " + model.getListOrario().get(indice).getElencoAssegnamenti().get(i).getAula().toString()) );
			updateTimeTable.getLabelDisciplina().setBounds(69, bound, 500, 29);
			updateTimeTable.getContentPane().add(updateTimeTable.getLabelDisciplina());
			bound+=30;

		}

		updateTimeTable.setComboGita( new JComboBox() );

		updateTimeTable.getComboGita().addItem("");
		for (int i=0; i<model.getListGita().size();i++)
			updateTimeTable.getComboGita().addItem(model.getListGita().get(i).getNome() + " - " 
					+ model.getListGita().get(i).getOre());


		for (int i=0; i<model.getListConvegno().size();i++)
			updateTimeTable.getComboGita().addItem(model.getListConvegno().get(i).getNome() + " - " 
					+ model.getListConvegno().get(i).getOre());

		updateTimeTable.getComboGita().setBounds(69, bound+50, 500, 29);
		updateTimeTable.getContentPane().add(updateTimeTable.getComboGita());

		updateTimeTable.setButtonInserisci( new JButton("Inserisci gita/convegno") );
		updateTimeTable.getButtonInserisci().setBounds(100, bound + 100, 100, 29);
		updateTimeTable.getContentPane().add(updateTimeTable.getButtonInserisci());


		updateTimeTable.getContentPane().setLayout(null);

		 */
		updateTimeTable.selectedGita(new SelectedGitaListener());



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
