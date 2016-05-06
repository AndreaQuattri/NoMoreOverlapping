package mvc;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import ElaborazioneDati.InsertInTable;
import connectToDatabase.CreateTimeTable;
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
		view.pressButtonModifica(new UpdateRecordListener());
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
	
	private class UpdateRecordListener implements  ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{

					
			ManagementTableView managment = new ManagementTableView((String)view.getComboBoxTable().getSelectedItem());
			managment.setVisible(true);


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
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent action)
		{

			viewOrario.getTableRecords().addColumn("Orario");
			viewOrario.getTableRecords().addColumn("Lunedì");
			viewOrario.getTableRecords().addColumn("Martedì");
			viewOrario.getTableRecords().addColumn("Mercoledì");
			viewOrario.getTableRecords().addColumn("Giovedì");
			viewOrario.getTableRecords().addColumn("Venerdì");
			viewOrario.getTableRecords().addColumn("Sabato");


			model.getListAssegnamento().add(new ArrayList<Assegnamento>());

			CorsoDiStudi corso1;
			PianoDiStudi piano1;
			int hour, n, numAss = 0;
			int indice;

			DisciplinaGiàInserita disciplinaInserita = new DisciplinaGiàInserita(model);
			
			//ArrayList<Attività> listAttività;


			//corsi di studio da valutare
			for (indice = 0; indice < model.getListCorsoDiStudi().size(); indice++){


				corso1 = model.getListCorsoDiStudi().get(indice);
				piano1 = null;


				//individuo l'indice del corso di studio
				for (int i=0; i<model.getListPianoDiStudi().size(); i++){
					if (model.getListPianoDiStudi().get(i).getCorso().equals(corso1)){
						piano1 = model.getListPianoDiStudi().get(i);
						break;
					}
				}

				if (piano1 == null)
					break;

				hour = 0;

				
				/*
				listAttività = new ArrayList<Attività>();
				
				listAttività.addAll(piano1.getElencoAttivitàObbligatorie());
				listAttività.addAll(piano1.getElencoAttivitàOpzionali());
				*/
				
				
				//piani di studio relativi al corso di studio selezionato
				for (int i=0; i<piano1.getElencoPianiPossibili().size();i++){

					//corsi del piano di studio i-esimo
					for (int j=0; j<piano1.getElencoPianiPossibili().get(i).size(); j++){

						//numero di arrayList<Assegnamento>
						for (numAss = 0; numAss < model.getListAssegnamento().size(); numAss++){

							if(piano1.getElencoPianiPossibili().get(i).get(j).getSemestre()==1 && !disciplinaInserita.giàInserita(piano1.getElencoPianiPossibili().get(i).get(j).getId())){
								hour = piano1.getElencoPianiPossibili().get(i).get(j).getOre()/6;


								n = disciplinaInserita.fasciaOrariaDisponibile(hour, numAss);
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
						if (numAss == model.getListAssegnamento().size() &&
								piano1.getElencoPianiPossibili().get(i).get(j).getSemestre()==1 &&
								!disciplinaInserita.giàInserita(piano1.getElencoPianiPossibili().get(i).get(j).getId())){

							model.getListAssegnamento().add(new ArrayList<Assegnamento>());
							n = 0;
							while (hour>0){
								model.getListAssegnamento().get(numAss).add(new Assegnamento(piano1.getElencoPianiPossibili().get(i).get(j), model.getListFasciaOraria().get(n), model.getListAula().get(0)));
								n = ((n + 1)%model.getListFasciaOraria().size());
								hour--;
							}

						}
					}
				}
			}

			CreateTimeTable create = new CreateTimeTable(model);
			create.fromAssegnamentoToOrarioPerGiorno();




			ArrayList<String> listGiorni = new ArrayList<String>();
			listGiorni.add("Lunedi");
			listGiorni.add("Martedi");
			listGiorni.add("Mercoledi");
			listGiorni.add("Giovedi");
			listGiorni.add("Venerdi");
			listGiorni.add("Sabato");


			int countDay=0;
			int iRighe=0;
			int iColonne=0;

			int inizioOra = 8;
			int inizioMinuto = 30;

			int fineOra = 9;
			int fineMinuto = 00;


			Date inizio = new Date(1111, 1, 1, inizioOra, inizioMinuto);
			Date fine = new Date(1111, 1, 1, fineOra, fineMinuto);

			Format formatter = new SimpleDateFormat("HH:mm");
			String oraInizio = formatter.format(inizio);
			String oraFine = formatter.format(fine);





			for (int i=0; i<model.getListOrario().size(); i++){
				countDay = 0;
				model.tabella.addElement(new Vector<String>());
				for (int j=0; j<model.getListOrario().get(i).getElencoAssegnamenti().size(); j++){
					countDay++;
				}
				if (iColonne == 0){
					model.tabella.get(iRighe).add(String.valueOf(oraInizio + " - " + oraFine));
					inizioMinuto+=30;
					fineMinuto+=30;

					inizio = new Date(1111, 1, 1, inizioOra, inizioMinuto);
					fine = new Date(1111, 1, 1, fineOra, fineMinuto);
					oraInizio = formatter.format(inizio);
					oraFine = formatter.format(fine);
				}

				model.tabella.get(iRighe).add(String.valueOf(countDay));

				iColonne = iColonne + iRighe/20;
				iRighe = (iRighe + 1)%21;

			}





			for(int i=0; i<21; i++){
				viewOrario.getTableRecords().addRow(model.tabella.get(i));
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
								cell.setBackground( Color.green );
								cell.setForeground(Color.green);
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
