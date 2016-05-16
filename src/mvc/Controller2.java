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
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableCellRenderer;

import ElaborazioneDati.GeneraListaDiscipline;
import ElaborazioneDati.InsertInTable;
import connectToDatabase.CreateTimeTable;
import connectToDatabase.DisciplinaGiàInserita;
import connectToDatabase.DisciplinaInseritaPiano;
import memorizzazioneDati.GeneraPianiDiStudio;
import memorizzazioneDati.InsertValues;


import myComponents.*;

import ControllerListener.*;;



public class Controller2
{

	private Model model;
	private MainView view;
	private ViewTimeTable viewOrario;

	int prova;

	public Controller2(Model model, MainView view, ViewTimeTable viewOrario)
	{
		this.model = model;
		this.view = view;
		this.viewOrario = viewOrario;
		prova = 0;

		// Set all the listener of the view
		view.selectedTableToView(new SelectedTableListener());
		view.pressButtonAcquisisci(new InsertInTableListener());
		view.pressButtonModifica(new UpdateRecordListener());
		view.pressButtonGestisciOrario(new OpenViewGestisciOrario());
		viewOrario.pressButtonNewOrario(new CreateNewOrario());
		viewOrario.pressButtonNewOrario2(new CreateNewOrario2());

		viewOrario.selectedActivityToView(new SelectedActivityListener(model, viewOrario));
		viewOrario.selectedPianoToView(new SelectedPianoListener());

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


						model.setListAssegnamento(new ArrayList<ArrayList<Assegnamento>>());
						model.setListAula(new ArrayList<Aula>());
						model.setListConvegno(new ArrayList<Convegno>());
						model.setListCorsoDiStudi(new ArrayList<CorsoDiStudi>());
						model.setListDisciplina(new ArrayList<Disciplina>());
						model.setListDocente(new ArrayList<Docente>());
						model.setListEsame(new ArrayList<Esame>());
						model.setListFasciaOraria(new ArrayList<FasciaOraria>());
						model.setListGita(new ArrayList<Gita>());
						model.setListOrario(new ArrayList<Orario>());
						model.setListPianoDiStudi(new ArrayList<PianoDiStudi>());
						model.setListStudente(new ArrayList<Studente>());
						model.setListTirocinio(new ArrayList<Tirocinio>());
						model.setTabella(new Vector<Vector<String>>());
						model.setListAttivitàInserite(new ArrayList<Attività>());

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
				
				
				for (int i=0; i<model.getListDisciplina().size(); i++){
					System.out.println(model.getListDisciplina().get(i).toString());
				}

//				
//				CorsoDiStudi c = model.getListCorsoDiStudi().get(4);
//				model.getListCorsoDiStudi().set(4, model.getListCorsoDiStudi().get(6));
//				model.getListCorsoDiStudi().set(6, c);
//				 

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
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent action)
		{


			for (int i = 0; i<viewOrario.getTableRecords().getRowCount(); i++){
				viewOrario.getTableRecords().removeRow(0);
			}


			model.setListOrario(null);
			model.setListOrario(new ArrayList<Orario>());

			model.setListAssegnamento(null);
			model.setListAssegnamento(new ArrayList<ArrayList<Assegnamento>>());




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
			int semestre = Integer.parseInt((String)viewOrario.getComboBoxSemestre().getSelectedItem());

			DisciplinaGiàInserita disciplinaInserita = new DisciplinaGiàInserita(model);

			ArrayList<Attività> listAttività = null;
			ArrayList<Disciplina> listDisciplina = null;

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



				listAttività = new ArrayList<Attività>();

				listAttività.addAll(piano1.getElencoAttivitàObbligatorie());
				listAttività.addAll(piano1.getElencoAttivitàOpzionali());


				listDisciplina = GeneraListaDiscipline.generaLista(listAttività);

				for (int iDisciplina = 0; iDisciplina < listDisciplina.size(); iDisciplina++){

					if(listDisciplina.get(iDisciplina).getSemestre()==semestre && !disciplinaInserita.giàInserita2(listDisciplina.get(iDisciplina).getId(), listDisciplina.get(iDisciplina).getSubId())){
						hour = listDisciplina.get(iDisciplina).getSubOre();

						if (!disciplinaInserita.giàInserita(listDisciplina.get(iDisciplina).getId()))
							model.getListAttivitàInserite().add(listDisciplina.get(iDisciplina));

						//numero di arrayList<Assegnamento>
						for (numAss = 0; numAss < model.getListAssegnamento().size(); numAss++){

							n = disciplinaInserita.fasciaOrariaDisponibile(hour, numAss);

							if (n!=-1){
								while (hour>0){
									model.getListAssegnamento().get(numAss).add(new Assegnamento(listDisciplina.get(iDisciplina), model.getListFasciaOraria().get(n), model.getListAula().get((int) (Math.random()*model.getListAula().size()))));
									n = ((n + 1)%model.getListFasciaOraria().size());
									hour--;
								}

								break;
							}
							else{
								if (numAss == model.getListAssegnamento().size()-1)
									model.getListAssegnamento().add(new ArrayList<Assegnamento>());

							}
						}

					}

				}

			}

			CreateTimeTable create = new CreateTimeTable(model);
			create.fromAssegnamentoToOrarioPerGiorno();

			//CalcolaSovrapposizioni calcola = new CalcolaSovrapposizioni(model);
			//calcola.numSovrapposizioni();

			for (int i=0; i<model.getListAttivitàInserite().size(); i++)
				viewOrario.getComboBoxAttivitàInserite().addItem(model.getListAttivitàInserite().get(i).getNome());



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
				model.getTabella().addElement(new Vector<String>());
				for (int j=0; j<model.getListOrario().get(i).getElencoAssegnamenti().size(); j++){
					countDay++;
				}
				if (iColonne == 0){
					model.getTabella().get(iRighe).add(String.valueOf(oraInizio + " - " + oraFine));
					inizioMinuto+=30;
					fineMinuto+=30;

					inizio = new Date(1111, 1, 1, inizioOra, inizioMinuto);
					fine = new Date(1111, 1, 1, fineOra, fineMinuto);
					oraInizio = formatter.format(inizio);
					oraFine = formatter.format(fine);
				}

				model.getTabella().get(iRighe).add(String.valueOf(countDay));

				iColonne = iColonne + iRighe/20;
				iRighe = (iRighe + 1)%21;

			}





			for(int i=0; i<21; i++){
				viewOrario.getTableRecords().addRow(model.getTabella().get(i));
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

	private class CreateNewOrario2 implements  ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{


			for (int i = 0; i<viewOrario.getTableRecords().getRowCount(); i++){
				viewOrario.getTableRecords().removeRow(0);
			}


			model.setListOrario(null);
			model.setListOrario(new ArrayList<Orario>());

			model.setListAssegnamento(null);
			model.setListAssegnamento(new ArrayList<ArrayList<Assegnamento>>());




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
			int hour;
			int indice;
			int semestre = Integer.parseInt((String)viewOrario.getComboBoxSemestre().getSelectedItem());

			int[][] matrix = new int[21][6];

			DisciplinaInseritaPiano disciplinaInserita = new DisciplinaInseritaPiano(model);

			ArrayList<Attività> listAttività = null;
			ArrayList<Disciplina> listDisciplina = null;

			//corsi di studio da valutare
			for (indice = 0; indice < model.getListCorsoDiStudi().size() ; indice++){


				corso1 = model.getListCorsoDiStudi().get(indice);
				piano1 = null;


				//individuo l'indice del corso di studio
				piano1 = model.cercaPianoDatoCorso(corso1.getCodice());

				if (piano1 != null)
				{

					hour = 0;

					viewOrario.getComboBoxPiani().addItem(
							model.getListCorsoDiStudi().get(indice).getCodice() + " - " +
									model.getListCorsoDiStudi().get(indice).getNomePrincipale() + " - " +
									model.getListCorsoDiStudi().get(indice).getAnno()
							);



					listAttività = new ArrayList<Attività>();

					listAttività.addAll(piano1.getElencoAttivitàObbligatorie());
					listAttività.addAll(piano1.getElencoAttivitàOpzionali());


					listDisciplina = GeneraListaDiscipline.generaLista(listAttività);

					matrix = new int[21][6];

					for (int iDisciplina = 0; iDisciplina < listDisciplina.size(); iDisciplina++){
						if(listDisciplina.get(iDisciplina).getSemestre()==semestre &&
								disciplinaInserita.giàInsert(listDisciplina.get(iDisciplina).getId(), listDisciplina.get(iDisciplina).getSubId())){
							disciplinaInserita.FromAssToMatrix(listDisciplina.get(iDisciplina).getId(), listDisciplina.get(iDisciplina).getSubId() , matrix);

						}

					}


					for (int iDisciplina = 0; iDisciplina < listDisciplina.size(); iDisciplina++){

						if(listDisciplina.get(iDisciplina).getSemestre()==semestre){

							if(!disciplinaInserita.giàInsert(listDisciplina.get(iDisciplina).getId(), listDisciplina.get(iDisciplina).getSubId())){

								hour = listDisciplina.get(iDisciplina).getSubOre();

								if (!disciplinaInserita.giàInsert(listDisciplina.get(iDisciplina).getId()))
									model.getListAttivitàInserite().add(listDisciplina.get(iDisciplina));


								disciplinaInserita.fasciaOrariaDisponibile(hour, matrix, listDisciplina.get(iDisciplina));


								
								
							}


						}

					}
					


				}
				
				
			}
			
			



			for (int i=0; i<model.getListAttivitàInserite().size(); i++)
				viewOrario.getComboBoxAttivitàInserite().addItem(model.getListAttivitàInserite().get(i).getNome());



			ArrayList<String> listGiorni = new ArrayList<String>();
			listGiorni.add("Lunedi");
			listGiorni.add("Martedi");
			listGiorni.add("Mercoledi");
			listGiorni.add("Giovedi");
			listGiorni.add("Venerdi");
			listGiorni.add("Sabato");




			CreateTimeTable create = new CreateTimeTable(model);
			create.fromAssegnamentoToOrarioPerGiorno();


			model.fromOrarioToTable();






			for(int i=0; i<21; i++){
				viewOrario.getTableRecords().addRow(model.getTabella().get(i));
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


	

	private class SelectedPianoListener implements  ActionListener
	{
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent action)
		{

			
			//viewOrario.getComboBoxAttivitàInserite().setSelectedItem("");


			model.setTabella(new Vector<Vector<String>>());

			for (int i = 0; i<21; i++){
				viewOrario.getTableRecords().removeRow(0);
			}


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


			System.out.println("ciao");

			String[] app;

			for (int i=0; i<model.getListOrario().size(); i++){
				countDay = 0;
				model.getTabella().addElement(new Vector<String>());
				for (int j=0; j<model.getListOrario().get(i).getElencoAssegnamenti().size(); j++){
					app = viewOrario.getComboBoxPiani().getSelectedItem().toString().split("-");

					if (model.AttivitàInCorso(model.getListOrario().get(i).getElencoAssegnamenti().get(j).getAttività().getId(), app[0].trim()))
						countDay++;
				}
				if (iColonne == 0){
					model.getTabella().get(iRighe).add(String.valueOf(oraInizio + " - " + oraFine));
					inizioMinuto+=30;
					fineMinuto+=30;

					inizio = new Date(1111, 1, 1, inizioOra, inizioMinuto);
					fine = new Date(1111, 1, 1, fineOra, fineMinuto);
					oraInizio = formatter.format(inizio);
					oraFine = formatter.format(fine);
				}

				model.getTabella().get(iRighe).add(String.valueOf(countDay));

				iColonne = iColonne + iRighe/20;
				iRighe = (iRighe + 1)%21;

			}

			for(int i=0; i<21; i++){
				viewOrario.getTableRecords().addRow(model.getTabella().get(i));
			}


			prova = 0;

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
								cell.setBackground( Color.BLUE );
								cell.setForeground(Color.BLUE);
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









}
