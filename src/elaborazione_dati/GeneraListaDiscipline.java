package elaborazione_dati;

import java.util.ArrayList;

import my_components.Attività;
import my_components.Disciplina;

public class GeneraListaDiscipline {


	public void aggiungiSubDisciplina(final ArrayList<Disciplina> listDisciplina, final ArrayList<Attività> listAttività, 
			int posizione, int subOre, int subId){
		
		listDisciplina.add(new Disciplina(listAttività.get(posizione).getOre(),
				listAttività.get(posizione).getId(), 
				listAttività.get(posizione).getDescrizione(), 
				listAttività.get(posizione).getNome(), 
				listAttività.get(posizione).getInizio(), 
				listAttività.get(posizione).getFine(), 
				listAttività.get(posizione).getSemestre(), 
				listAttività.get(posizione).getElencoResponsabili(), 
				((Disciplina)listAttività.get(posizione)).getCodice(),
				((Disciplina)listAttività.get(posizione)).getCrediti(),
				subId, subOre));
		
	}


	public  ArrayList<Disciplina> generaLista(final ArrayList<Attività> listAttività){

		ArrayList<Disciplina> listDisciplina = new ArrayList<Disciplina>();
		int jSubId;

		for (int i=0; i<listAttività.size(); i++){

			if (listAttività.get(i)!= null && listAttività.get(i) instanceof Disciplina){

				jSubId = 0;

				switch (listAttività.get(i).getOre()){

				case 60:

					aggiungiSubDisciplina(listDisciplina, listAttività, i, 6, jSubId);
					
//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,6));

					jSubId++;

					aggiungiSubDisciplina(listDisciplina, listAttività, i, 4, jSubId);


//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,4));

					jSubId++;

					break;

				case 48:

					
					aggiungiSubDisciplina(listDisciplina, listAttività, i, 4, jSubId);

					
//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,4));
//					
					jSubId++;					
					
					
					aggiungiSubDisciplina(listDisciplina, listAttività, i, 4, jSubId);

					
//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,4));
					
					jSubId++;

					break;

				case 96:

					
					aggiungiSubDisciplina(listDisciplina, listAttività, i, 6, jSubId);

//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,6));
//					
					jSubId++;	
					
					aggiungiSubDisciplina(listDisciplina, listAttività, i, 6, jSubId);

					
//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,6));
//					
					jSubId++;					
					
					aggiungiSubDisciplina(listDisciplina, listAttività, i, 4, jSubId);

					
//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,4));
//					
					jSubId++;

					break;


				case 120:
					
					aggiungiSubDisciplina(listDisciplina, listAttività, i, 8, jSubId);

					
//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,8));
//					
					jSubId++;
					
					
					aggiungiSubDisciplina(listDisciplina, listAttività, i, 8, jSubId);

//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,8));
//					
					jSubId++;
					
					
					aggiungiSubDisciplina(listDisciplina, listAttività, i, 4, jSubId);

					
//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,4));
//					
					jSubId++;


					break;

				case 72:

					aggiungiSubDisciplina(listDisciplina, listAttività, i, 6, jSubId);

					
//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,6));
//					
					jSubId++;					
					
					aggiungiSubDisciplina(listDisciplina, listAttività, i, 6, jSubId);

					
//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,6));
//					
					jSubId++;
					
					
					break;


				default: 

					aggiungiSubDisciplina(listDisciplina, listAttività, i, 6, jSubId);

					
//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,6));
//					
					jSubId++;					
					
					aggiungiSubDisciplina(listDisciplina, listAttività, i, 6, jSubId);

//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,6));
					
					jSubId++;					
					
					
					aggiungiSubDisciplina(listDisciplina, listAttività, i, 4, jSubId);

					
//					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
//							listAttività.get(i).getId(),
//							listAttività.get(i).getDescrizione(),
//							listAttività.get(i).getNome(), 
//							listAttività.get(i).getInizio(),
//							listAttività.get(i).getFine(),
//							listAttività.get(i).getSemestre(),
//							listAttività.get(i).getElencoResponsabili(),
//							((Disciplina)listAttività.get(i)).getCodice(),
//							((Disciplina)listAttività.get(i)).getCrediti(),
//							j,4));
//					
					jSubId++;
					
					break;

				}

			}


		}


		Disciplina scambio;
		
		for (int i=0 ; i<listDisciplina.size()-1;i++){
			for (int k=i+1; k<listDisciplina.size();k++){
				if (listDisciplina.get(i).getSubOre()<listDisciplina.get(k).getSubOre()){
					scambio = listDisciplina.get(i);
					listDisciplina.set(i, listDisciplina.get(k));
					listDisciplina.set(k, scambio);

				}
			}
		}

		
		

		return listDisciplina;
	}



}
