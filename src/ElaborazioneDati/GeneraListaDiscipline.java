package ElaborazioneDati;

import java.util.ArrayList;

import myComponents.Attività;
import myComponents.Disciplina;

public class GeneraListaDiscipline {




	public static ArrayList<Disciplina> generaLista(ArrayList<Attività> listAttività){

		ArrayList<Disciplina> listDisciplina = new ArrayList<Disciplina>();
		int j;

		for (int i=0; i<listAttività.size(); i++){

			if (listAttività.get(i)!= null && listAttività.get(i) instanceof Disciplina){

				j = 0;

				switch (listAttività.get(i).getOre()){

				case 60:

					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,6));

					j++;


					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,4));

					j++;

					break;

				case 48:

					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,4));
					
					j++;					
					
					
					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,4));
					
					j++;

					break;

				case 96:

					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,4));
					
					j++;

					break;


				case 120:
					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,8));
					
					j++;
					
					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,8));
					
					j++;
					
					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,4));
					
					j++;


					break;

				case 72:

					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,6));
					
					j++;
					
					
					break;


				default: 

					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttività.get(i).getOre(),
							listAttività.get(i).getId(),
							listAttività.get(i).getDescrizione(),
							listAttività.get(i).getNome(), 
							listAttività.get(i).getInizio(),
							listAttività.get(i).getFine(),
							listAttività.get(i).getSemestre(),
							listAttività.get(i).getElencoResponsabili(),
							((Disciplina)listAttività.get(i)).getCodice(),
							((Disciplina)listAttività.get(i)).getCrediti(),
							j,4));
					
					j++;
					
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
