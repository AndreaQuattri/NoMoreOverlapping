package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;

import ElaborazioneDati.InsertInTable;
import connectToDatabase.DisciplinaGiàInserita;
import memorizzazioneDati.GeneraPianiDiStudio;
import memorizzazioneDati.InsertValues;
import myComponents.Assegnamento;
import myComponents.CorsoDiStudi;
import myComponents.PianoDiStudi;



public class Controller
{

	private Model model;
	private MainView view;
	private ViewTimeTable viewOrario;

	public Controller(Model model, MainView view, ViewTimeTable viewOrario)
	{
		this.model = model;
		this.view = view;
		this.viewOrario = viewOrario;


		// Set all the listener of the view
		view.selectedTableToView(new SelectedTableListener());
		view.pressButtonAcquisisci(new InsertInTableListener());
		view.pressButtonGestisciOrario(new OpenViewGestisciOrario());
		viewOrario.pressButtonNewOrario(new CreateNewOrario());

		//view.addCompileListener(new MyCompileListener());
		//view.addMakeLaTeXlistener(new MyMakeLaTeXlistener());
	}


	private class SelectedTableListener implements  ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{
			//InfoView infoView = new InfoView();
			//infoView.getFrame().setVisible(true);
			model.enableModificaTable(true);
			model.enableEliminaTable(true);
			model.enableButtonAcquisisci(true);
			model.enableButtonAggiorna(true);

			//TODO
			/*
			 * 
			 * cancellare tabella, ecc..
			 * 
			 */


		}
	}

	private class InsertInTableListener implements  ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{

			view.getLabelTableInTable().setText((String)view.getComboBoxTable().getSelectedItem());

			InsertInTable insertInTable = new InsertInTable(view.getComboBoxTable().getSelectedItem());

			try {
				String toView[][] = insertInTable.getValues();
				String toInsertComboBox = "";
				for (int i=0; i<toView[0].length; i++){
					view.getTableRecords().addColumn(toView[0][i]);
				}


				for (int i=1; i<toView.length; i++){
					view.getTableRecords().addRow(toView[i]);
					for(int j=0; j<toView[i].length-1; j++)
						toInsertComboBox+=toView[i][j]+", ";
					toInsertComboBox+=toView[i][toView[i].length-1];
					view.getComboBoxRecord().addItem(toInsertComboBox);
					toInsertComboBox = "";
				}


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private class OpenViewGestisciOrario implements  ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{
			InsertValues insert = new InsertValues(model);



			try {

				//aula inserita in arraylist<Aula> correttamente
				insert.getValueAula();

				//corsi di studi inseriti in arraylist<CorsoDiStudi>
				insert.getValueCorsoDiStudi_1();

				//studenti inseriti in arrayList<Studente>
				insert.getValueStudente();

				//corsi di studi inseriti in arraylist<CorsoDiStudi>
				//mancano elencoPianiPossibili
				insert.getValueCorsoDiStudi_2();

				//fascie orarie inserite in arraylist<FasciaOraria>
				insert.getValueFasciaOraria();

				//le sottoclassi di attività inserite nei rispettivi arraylist
				insert.getValueAttività();


				insert.getValuePianoDiStudi();

				//docente inseriti in arraylist<Docente>
				insert.getValueDocente();


				GeneraPianiDiStudio generaPiani = new GeneraPianiDiStudio(model);
				generaPiani.generaPiani();



				//for (int i=0; i<6; i++)
				//System.out.println(model.getListCorsoDiStudi().get(i).toString());



				viewOrario.getFrame().setVisible(true);




			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



	}

	private class CreateNewOrario implements  ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{

			viewOrario.getTableRecords().addColumn("Lunedì");
			viewOrario.getTableRecords().addColumn("Martedì");
			viewOrario.getTableRecords().addColumn("Mercoledì");
			viewOrario.getTableRecords().addColumn("Giovedì");
			viewOrario.getTableRecords().addColumn("Venerdì");

			model.getListAssegnamento().add(new ArrayList<Assegnamento>());
			model.getListAssegnamento().add(new ArrayList<Assegnamento>());
			model.getListAssegnamento().add(new ArrayList<Assegnamento>());


			for (int indice = 0, k = 0 ; indice < 3; indice++){

				CorsoDiStudi corso1 = model.getListCorsoDiStudi().get(indice);
				PianoDiStudi piano1 = null;

				for (int i=0; i<model.getListPianoDiStudi().size(); i++){
					if (model.getListPianoDiStudi().get(i).getCorso().equals(corso1)){
						piano1 = model.getListPianoDiStudi().get(i);
						break;
					}
				}

				int hour = 0;

				DisciplinaGiàInserita disciplinaInserita = new DisciplinaGiàInserita(model);


				for (int i=0; i<piano1.getElencoPianiPossibili().size();i++){

					for (int j=0; j<piano1.getElencoPianiPossibili().get(i).size(); j++){

						for (int numAss = 0; numAss < model.getListAssegnamento().size(); numAss++){

							if(piano1.getElencoPianiPossibili().get(i).get(j).getSemestre()==1 && !disciplinaInserita.giàInserita(piano1.getElencoPianiPossibili().get(i).get(j).getId())){
								hour = piano1.getElencoPianiPossibili().get(i).get(j).getOre()/6;

								/*if(!model.getListFasciaOraria().get(k).getGiorno().equals(model.getListFasciaOraria().get((k+hour)%model.getListFasciaOraria().size()).getGiorno())){
									while(model.getListFasciaOraria().get( ((k + model.getListFasciaOraria().size() - 1)%model.getListFasciaOraria().size()) ).getGiorno().equals(model.getListFasciaOraria().get(k).getGiorno())){
										k = ((k + 1)%model.getListFasciaOraria().size());
									}
								}

								if (disciplinaInserita.èVuotaeCiSta(hour, k , numAss)){

									while (hour>0){
										model.getListAssegnamento().get(numAss).add(new Assegnamento(piano1.getElencoPianiPossibili().get(i).get(j), model.getListFasciaOraria().get(k), model.getListAula().get(0)));
										k = ((k + 1)%model.getListFasciaOraria().size());
										hour--;
									}
									break;
								}

								else{
								 */


								int n = disciplinaInserita.fasciaOrariaDisponibile(hour, numAss);
								if (n!=-1){
									while (hour>0){
										model.getListAssegnamento().get(numAss).add(new Assegnamento(piano1.getElencoPianiPossibili().get(i).get(j), model.getListFasciaOraria().get(n), model.getListAula().get(0)));
										n = ((n + 1)%model.getListFasciaOraria().size());
										hour--;
									}
									break;
								}
							}

						}
					}
					//}
				}
			}

			for (int j=0; j<model.getListAssegnamento().size(); j++){
				for (int i=0; i<model.getListAssegnamento().get(j).size(); i++){
					System.out.println(model.getListAssegnamento().get(j).get(i).toString()+"\n");
				}
				System.out.println("\n");
			}






		}
	}


	/*
	private class MyLoadFromFileListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{
			// Load from file with JFileChooser
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Select a Petri Net");
			fileChooser.setApproveButtonText("Open");
			fileChooser.setCurrentDirectory(new java.io.File("."));

			//fileChooser.setFileFilter(new MyFileFilter());
			//da rivedere questa istruzione
			fileChooser.setFileFilter(new FileNameExtensionFilter(".txt" , ".txt"));


			int n = fileChooser.showOpenDialog(viewOrario);

			if (n == JFileChooser.APPROVE_OPTION)
			{

				//serve per cancellare textbox prima di usarla
				viewOrario.clearUserInput();

				File inputFile = fileChooser.getSelectedFile();
				try
				{
					BufferedReader brd = new BufferedReader(new FileReader(inputFile));

					String line ;
					while ((line = brd.readLine()) != null)
					{
						viewOrario.appendUserInput(line + "\n");
					}
					brd.close();
				}
				catch (IOException e)
				{
					// Show an error dialog
					JOptionPane.showMessageDialog(view, "ERROR: can't open the selected file");
				}
			}

		}

		/*
		// Private classe for filter only *.txt files
		private class MyFileFilter extends FileFilter
		{

			public boolean accept(File file)
			{
				if (file.isDirectory())
					return true;

				String fname = file.getName().toLowerCase();
				return fname.endsWith("txt");
			}

			public String getDescription()
			{
				return "*.txt";
			}
		}


	}
	 */






}
