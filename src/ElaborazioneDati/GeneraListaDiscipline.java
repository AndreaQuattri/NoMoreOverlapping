package ElaborazioneDati;

import java.util.ArrayList;

import myComponents.Attivitą;
import myComponents.Disciplina;

public class GeneraListaDiscipline {




	public static ArrayList<Disciplina> generaLista(ArrayList<Attivitą> listAttivitą){

		ArrayList<Disciplina> listDisciplina = new ArrayList<Disciplina>();
		int j;

		for (int i=0; i<listAttivitą.size(); i++){

			if (listAttivitą.get(i)!= null && listAttivitą.get(i) instanceof Disciplina){

				j = 0;

				switch (listAttivitą.get(i).getOre()){

				case 60:

					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,6));

					j++;


					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,4));

					j++;

					break;

				case 48:

					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,4));
					
					j++;					
					
					
					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,4));
					
					j++;

					break;

				case 96:

					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,4));
					
					j++;

					break;


				case 120:
					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,8));
					
					j++;
					
					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,8));
					
					j++;
					
					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,4));
					
					j++;


					break;

				case 72:

					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,6));
					
					j++;
					
					
					break;


				default: 

					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
							j,6));
					
					j++;					
					
					listDisciplina.add(new Disciplina(listAttivitą.get(i).getOre(),
							listAttivitą.get(i).getId(),
							listAttivitą.get(i).getDescrizione(),
							listAttivitą.get(i).getNome(), 
							listAttivitą.get(i).getInizio(),
							listAttivitą.get(i).getFine(),
							listAttivitą.get(i).getSemestre(),
							((Disciplina)listAttivitą.get(i)).getCodice(),
							((Disciplina)listAttivitą.get(i)).getCrediti(),
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
