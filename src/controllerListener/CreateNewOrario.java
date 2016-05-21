package controllerListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
		int indiceVettore = 0;
		int numSov = 100;
		int semestre = Integer.parseInt((String)viewOrario.getComboBoxSemestre().getSelectedItem());

		int[][] matrix = new int[21][6];

		DisciplinaInseritaPiano disciplinaInserita = new DisciplinaInseritaPiano(model);

		ArrayList<Attività> listAttività = null;
		ArrayList<Disciplina> listDisciplina = null;
		ArrayList<Disciplina> listDisciplinaSupporto = new ArrayList<Disciplina>();
		ArrayList<Disciplina> listDisciplinaSupportoDelSupporto = new ArrayList<Disciplina>();
		ArrayList<Docente> listDocenteSupport = new ArrayList<Docente>();

		GeneraSequenzaCasuale g = new GeneraSequenzaCasuale(model.getListCorsoDiStudi().size());
		int[] v = g.generaSequenza();

		//corsi di studio da valutare
		for (; indiceVettore < model.getListCorsoDiStudi().size() ; indiceVettore++){

			indice = v[indiceVettore];

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


				listDisciplinaSupportoDelSupporto = listDisciplinaSupporto;
				boolean trovate = false;


				for (int iDocente =0; iDocente<listDocenteSupport.size(); iDocente++){
					for (int iDisciplina = 0; iDisciplina<listDisciplinaSupportoDelSupporto.size(); iDisciplina++){
						trovate = false;
						for (int iDocDis = 0; iDocDis<listDisciplinaSupportoDelSupporto.get(iDisciplina).getElencoResponsabili().size(); iDocDis++){
							if (listDisciplinaSupportoDelSupporto.get(iDisciplina).getElencoResponsabili().get(iDocDis).equals(listDocenteSupport.get(iDocente))){
								disciplinaInserita.FromAssToMatrix(listDisciplinaSupportoDelSupporto.get(iDisciplina).getId(), listDisciplinaSupportoDelSupporto.get(iDisciplina).getSubId() , matrix);
								trovate = true;
							}
						}
						if (trovate)
							listDisciplinaSupportoDelSupporto.remove(listDisciplinaSupportoDelSupporto.get(iDisciplina));
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

				for (int j=0; j<6; j++)
					for (int k=0; k<21; k++)
						if (matrix[k][j]>1)
							numSov++;



			}




			for (int i=0; i<listAttività.size(); i++){
				if (listAttività.get(i).getSemestre()==semestre &&
						!model.getListAllAttivitàInserite().contains(listAttività.get(i))){
					model.getListAllAttivitàInserite().add((Disciplina)listAttività.get(i));
				}
			}

			listDisciplinaSupporto.addAll(listDisciplina);

			


	}


	for (int i=0; i<model.getListAttivitàInserite().size(); i++)
		viewOrario.getComboBoxAttivitàInserite().addItem(model.getListAttivitàInserite().get(i).getNome());

	for (int i=0; i<model.getListDocentiInseriti().size(); i++)
		viewOrario.getComboBoxDocenti().addItem(model.getListDocentiInseriti().get(i).getMatricola() + " - " +
				model.getListDocentiInseriti().get(i).getCognome());


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

	for (int i=0; i<model.getListOrario().size(); i++)
		for (int j=0; j<model.getListOrario().get(i).getElencoAssegnamenti().size(); j++)
			model.getOrarioUfficiale().aggiungiAssegnamento(model.getListOrario().get(i).getElencoAssegnamenti().get(j));




}
}
