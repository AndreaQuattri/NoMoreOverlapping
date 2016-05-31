package controllerListener;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import ElaborazioneDati.GeneraListaDiscipline;
import ElaborazioneDati.GeneraSequenzaCasuale;
import connectToDatabase.CreateTimeTable;
import connectToDatabase.DisciplinaInseritaPiano;
import mvc.Model;
import mvc.ViewTimeTable;
import myComponents.Assegnamento;
import myComponents.Attività;
import myComponents.CorsoDiStudi;
import myComponents.Disciplina;
import myComponents.Docente;
import myComponents.Orario;
import myComponents.PianoDiStudi;

public class CreateNewOrario implements  ActionListener
{

	private ViewTimeTable viewOrario;
	private Model model;

	public CreateNewOrario(Model model, ViewTimeTable viewOrario) {
		this.model = model;
		this.viewOrario = viewOrario;
	}

	@Override
	public void actionPerformed(ActionEvent action)
	{


		model.setTabella(new Vector<Vector<String>>());
		viewOrario.getSalva().setEnabled(true);


		if (viewOrario.getTableRecords().getRowCount()!=0){
			for (int i = 0; i<21; i++){
				viewOrario.getTableRecords().removeRow(0);
			}

		}
		else{

			viewOrario.getTableRecords().addColumn("Orario");
			viewOrario.getTableRecords().addColumn("Lunedì");
			viewOrario.getTableRecords().addColumn("Martedì");
			viewOrario.getTableRecords().addColumn("Mercoledì");
			viewOrario.getTableRecords().addColumn("Giovedì");
			viewOrario.getTableRecords().addColumn("Venerdì");
			viewOrario.getTableRecords().addColumn("Sabato");

		}


		model.setListOrario(null);
		model.setListOrario(new ArrayList<Orario>());
		model.setListAssegnamento(null);
		model.setListAssegnamento(new ArrayList<Assegnamento>());
		model.setTabella(new Vector<Vector<String>>());


		

		CorsoDiStudi corso1;
		PianoDiStudi piano1;
		int hour;
		int indice;
		int indiceVettore = 0;
		int numSov = 100;
		int semestre;
		if (viewOrario.getButtonSem1().isSelected())
			semestre = 1;
		else
			semestre = 2;


		int[][] matrix = new int[21][6];
		int[][] matrixSupporto = new int[21][6];

		DisciplinaInseritaPiano disciplinaInserita = new DisciplinaInseritaPiano(model);

		ArrayList<Attività> listAttività;
		ArrayList<Disciplina> listDisciplina;
		ArrayList<Disciplina> listDisciplinaInseritaPerOra;
		ArrayList<Disciplina> listDisciplinaSupporto;
		ArrayList<Docente> listDocenteSupport;
		model.setListDocentiInseriti(new ArrayList<Docente>());
		model.setListAttivitàDeiDocenti(new ArrayList<Attività>());
		model.setListAttivitàInserite(new ArrayList<Attività>());
		
		viewOrario.getVisualizzaTutto().removeAll();
		viewOrario.setButtonCheckBox(new JCheckBoxMenuItem("Tutto"));
		viewOrario.getVisualizzaTutto().add(viewOrario.getButtonCheckBox());
		viewOrario.getButtonCheckBox().addActionListener(new SelectedAllListener(model, viewOrario));

		viewOrario.getVisualizzaAttività().removeAll();
		viewOrario.getVisualizzaDocente().removeAll();

		GeneraSequenzaCasuale g = new GeneraSequenzaCasuale(model.getListCorsoDiStudi().size());

		int numIt=0, numMaxIt;
		if (viewOrario.getPocheIterazioni().isSelected())
			numIt = 1;
		else if (viewOrario.getMedieIterazioni().isSelected())
			numIt = 100;
		else
			numIt = 10000;
		numMaxIt = numIt;
		
		while(numIt>0 && numSov!=0){		

			numSov = 0;
			
			listAttività = new ArrayList<Attività>();
			listDisciplina = new ArrayList<Disciplina>();
			listDisciplinaInseritaPerOra = new ArrayList<Disciplina>();
			listDisciplinaSupporto = new ArrayList<Disciplina>();
			listDocenteSupport = new ArrayList<Docente>();
			model.setListDocentiInseriti(new ArrayList<Docente>());
			model.setListAttivitàDeiDocenti(new ArrayList<Attività>());
			model.setListAttivitàInserite(new ArrayList<Attività>());
			model.setListAssegnamento(new ArrayList<Assegnamento>());
			
			
					
			viewOrario.getVisualizzaCorso().removeAll();
			int[] v = g.generaSequenza();
	

//			for (int i=0; i<v.length; i++)
//				System.out.print(v[i]+", ");
//			
//			System.out.println();



			//corsi di studio da valutare
			for (indiceVettore = 0; indiceVettore < model.getListCorsoDiStudi().size() ; indiceVettore++){

				indice = v[indiceVettore];


				corso1 = model.getListCorsoDiStudi().get(indice);
				piano1 = null;



				//individuo l'indice del corso di studio
				piano1 = model.cercaPianoDatoCorso(corso1.getCodice());

				if (piano1 != null)
				{

					hour = 0;

					int iInizio = (int)(Math.random()*6);
	
					
					viewOrario.setButtonCheckBox(new JCheckBoxMenuItem(model.getListCorsoDiStudi().get(indice).getCodice() + " - " +
							model.getListCorsoDiStudi().get(indice).getNomePrincipale() + " - " +
							model.getListCorsoDiStudi().get(indice).getAnno()));
					viewOrario.getVisualizzaCorso().add(viewOrario.getButtonCheckBox());
					viewOrario.getButtonCheckBox().addActionListener(new SelectedPianoListener(model, viewOrario,
							model.getListCorsoDiStudi().get(indice).getCodice()));

					
				


					listAttività = new ArrayList<Attività>();

					listAttività.addAll(piano1.getElencoAttivitàObbligatorie());
					listAttività.addAll(piano1.getElencoAttivitàOpzionali());


					listDisciplina = GeneraListaDiscipline.generaLista(listAttività);

					matrix = new int[21][6];
					matrixSupporto = new int[21][6];

					listDocenteSupport = new ArrayList<Docente>();


					for (int iDisciplina = 0; iDisciplina < listDisciplina.size(); iDisciplina++){

						if (listDisciplina.get(iDisciplina).getSemestre()==semestre){
							for (int iDocente=0; iDocente < listDisciplina.get(iDisciplina).getElencoResponsabili().size(); iDocente++){
								if (!listDocenteSupport.contains(listDisciplina.get(iDisciplina).getElencoResponsabili().get(iDocente))){
									listDocenteSupport.add(listDisciplina.get(iDisciplina).getElencoResponsabili().get(iDocente));
								}
								if (!model.getListDocentiInseriti().contains(listDisciplina.get(iDisciplina).getElencoResponsabili().get(iDocente))){
									model.getListDocentiInseriti().add(listDisciplina.get(iDisciplina).getElencoResponsabili().get(iDocente));

								}
							}
						}

					}


					listDisciplinaSupporto = new ArrayList<Disciplina>();

					for (int iDocente = 0; iDocente<listDocenteSupport.size(); iDocente++){
						for (int iDisciplina = 0; iDisciplina<listDisciplinaInseritaPerOra.size(); iDisciplina++){
							for (int iDocDis = 0; iDocDis<listDisciplinaInseritaPerOra.get(iDisciplina).getElencoResponsabili().size(); iDocDis++){
								if (listDisciplinaInseritaPerOra.get(iDisciplina).getSemestre()==semestre &&
										listDisciplinaInseritaPerOra.get(iDisciplina).getElencoResponsabili().get(iDocDis).equals(listDocenteSupport.get(iDocente)) &&
										!listDisciplinaSupporto.contains((Disciplina)listDisciplinaInseritaPerOra.get(iDisciplina))){
									listDisciplinaSupporto.add(listDisciplinaInseritaPerOra.get(iDisciplina));
								}
							}

						}
					}

					for (int iDisciplina = 0; iDisciplina<listDisciplina.size(); iDisciplina++){
						if (disciplinaInserita.giàInsert(listDisciplina.get(iDisciplina).getId(), ((Disciplina)listDisciplina.get(iDisciplina)).getSubId())){
							disciplinaInserita.FromAssToMatrix(listDisciplina.get(iDisciplina).getId(), ((Disciplina)listDisciplina.get(iDisciplina)).getSubId(), matrixSupporto);
						}
					}


					for (int iDisciplina = 0; iDisciplina<listDisciplinaSupporto.size(); iDisciplina++){
						disciplinaInserita.FromAssToMatrix(listDisciplinaSupporto.get(iDisciplina).getId(), listDisciplinaSupporto.get(iDisciplina).getSubId() , matrix);
					}


					for (int iDisciplina = 0; iDisciplina < listDisciplina.size(); iDisciplina++){

						if(listDisciplina.get(iDisciplina).getSemestre()==semestre){

							if(!disciplinaInserita.giàInsert(listDisciplina.get(iDisciplina).getId(), listDisciplina.get(iDisciplina).getSubId())){

								hour = listDisciplina.get(iDisciplina).getSubOre();


								if (!disciplinaInserita.giàInsert(listDisciplina.get(iDisciplina).getId()))
									model.getListAttivitàInserite().add(listDisciplina.get(iDisciplina));

								disciplinaInserita.fasciaOrariaDisponibile(hour, matrix, matrixSupporto, listDisciplina.get(iDisciplina), iInizio);

							}


						}

					}

					for(int j=0; j<6; j++)
						for (int k=0; k<21; k++)
							model.getMatrix()[k][j] = 0;

					for (int j=0; j<6; j++)
						for (int k=0; k<21; k++){
							model.getMatrix()[k][j] += matrixSupporto[k][j];
							if (matrixSupporto[k][j]>1)
								numSov++;
						}


				}


				for (int i=0; i<listAttività.size(); i++){
					if (listAttività.get(i).getSemestre()==semestre &&
							!model.getListAllAttivitàInserite().contains(listAttività.get(i))){
						model.getListAllAttivitàInserite().add((Disciplina)listAttività.get(i));
					}
				}




				for (int i=0; i<listDisciplina.size(); i++){
					listDisciplinaInseritaPerOra.add(listDisciplina.get(i));
				}
			}
			

			//System.out.println(numIt + " - " + numSov);
			numIt--;

			
		}





		for (int i=0; i<model.getListAttivitàInserite().size(); i++){
			viewOrario.setButtonCheckBox(new JCheckBoxMenuItem(model.getListAttivitàInserite().get(i).getNome()));
			viewOrario.getVisualizzaAttività().add(viewOrario.getButtonCheckBox());
			viewOrario.getButtonCheckBox().addActionListener(new SelectedActivityListener(model, viewOrario,
					model.getListAttivitàInserite().get(i).getNome()));

		}

		for (int i=0; i<model.getListDocentiInseriti().size(); i++){
	
			viewOrario.setButtonCheckBox(new JCheckBoxMenuItem(model.getListDocentiInseriti().get(i).getMatricola() + " - " +
					model.getListDocentiInseriti().get(i).getCognome()));
			viewOrario.getVisualizzaDocente().add(viewOrario.getButtonCheckBox());
			viewOrario.getButtonCheckBox().addActionListener(new SelectedDocenteListener(model, viewOrario,
					model.getListDocentiInseriti().get(i).getMatricola()));

		}

		viewOrario.getLabelNumIterazioni().setText("Iterazioni effettuate: "+(numMaxIt-numIt));
		viewOrario.getLabelNumSovr().setText("L'orario contiene "+numSov/2+ " ore di sovrapposizione");

		ArrayList<String> listGiorni = new ArrayList<String>();
		listGiorni.add("Lunedi");
		listGiorni.add("Martedi");
		listGiorni.add("Mercoledi");
		listGiorni.add("Giovedi");
		listGiorni.add("Venerdi");
		listGiorni.add("Sabato");


		if (viewOrario.getTableRecords().getRowCount()!=0){
			for (int i = 0; i<21; i++){
				viewOrario.getTableRecords().removeRow(0);
			}

		}
		else{
			if(viewOrario.getTableRecords().getColumnCount()==0){
				viewOrario.getTableRecords().addColumn("Orario");
				viewOrario.getTableRecords().addColumn("Lunedì");
				viewOrario.getTableRecords().addColumn("Martedì");
				viewOrario.getTableRecords().addColumn("Mercoledì");
				viewOrario.getTableRecords().addColumn("Giovedì");
				viewOrario.getTableRecords().addColumn("Venerdì");
				viewOrario.getTableRecords().addColumn("Sabato");
			}

		}


		CreateTimeTable create = new CreateTimeTable(model);
		create.fromAssegnamentoToOrarioPerGiorno();

		
		model.setTabella(new Vector<Vector<String>>());
		model.fromOrarioToTable();
		
		viewOrario.getVisualizzaTutto().getItem(0).setSelected(true);
		
		if(viewOrario.getTableRecords().getRowCount()!=0)
		for (int i = 0; i<21; i++){
			viewOrario.getTableRecords().removeRow(0);
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
		





		

		for (int i=0; i<model.getListOrario().size(); i++)
			for (int j=0; j<model.getListOrario().get(i).getElencoAssegnamenti().size(); j++){
				model.getOrarioUfficiale().aggiungiAssegnamento(model.getListOrario().get(i).getElencoAssegnamenti().get(j));
				model.getOrarioUfficiale().getElencoAttività().addAll(model.getListOrario().get(i).getElencoAttività());	
			}




	}
}
