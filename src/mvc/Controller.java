package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;



import ElaborazioneDati.InsertInTable;
import memorizzazioneDati.GeneraPianiDiStudio;
import memorizzazioneDati.InsertValues;



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
				

/*
				for (int i=1; i<toView.length; i++){
					viewOrario.getTableRecords().addRow(toView[i]);
					
				}
*/

			

			


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
