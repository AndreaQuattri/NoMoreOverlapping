package ElaborazioneDati;

import java.util.ArrayList;

import myComponents.Attivit�;
import myComponents.Disciplina;

public class GeneraListaDiscipline {




	public static ArrayList<Disciplina> generaLista(ArrayList<Attivit�> listAttivit�){

		ArrayList<Disciplina> listDisciplina = new ArrayList<Disciplina>();
		int j;

		for (int i=0; i<listAttivit�.size(); i++){

			if (listAttivit�.get(i)!= null && listAttivit�.get(i) instanceof Disciplina){

				j = 0;

				switch (listAttivit�.get(i).getOre()){

				case 60:

					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,6));

					j++;


					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,4));

					j++;

					break;

				case 48:

					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,4));
					
					j++;					
					
					
					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,4));
					
					j++;

					break;

				case 96:

					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,4));
					
					j++;

					break;


				case 120:
					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,8));
					
					j++;
					
					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,8));
					
					j++;
					
					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,4));
					
					j++;


					break;

				case 72:

					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,6));
					
					j++;
					
					
					break;


				default: 

					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttivit�.get(i).getOre(),
							listAttivit�.get(i).getId(),
							listAttivit�.get(i).getDescrizione(),
							listAttivit�.get(i).getNome(), 
							listAttivit�.get(i).getInizio(),
							listAttivit�.get(i).getFine(),
							listAttivit�.get(i).getSemestre(),
							((Disciplina)listAttivit�.get(i)).getCodice(),
							((Disciplina)listAttivit�.get(i)).getCrediti(),
							j,4));
					
					j++;
					
					break;

				}

			}


		}


		Disciplina scambio;
		
		for (int i=0 ; i<listDisciplina.size()-1;i++){
			for (int k=i+1; k<listDisciplina.size();k++){
				if (listDisciplina.get(i).getSubOre()>listDisciplina.get(k).getSubOre()){
					scambio = listDisciplina.get(i);
					listDisciplina.set(i, listDisciplina.get(k));
					listDisciplina.set(k, scambio);

				}
			}
		}

		
		

		return listDisciplina;
	}



}
