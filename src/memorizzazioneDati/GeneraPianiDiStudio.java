package memorizzazioneDati;

import java.util.ArrayList;

import connectToDatabase.Comb;
import connectToDatabase.GetDisciplina;
import mvc.Model;
import myComponents.*;

public class GeneraPianiDiStudio {


	private Model model;

	public GeneraPianiDiStudio(Model model) {
		this.model = model;
	}


	public void generaPiani(){


		for (int k=0; k<model.getListPianoDiStudi().size(); k++){

			PianoDiStudi piano = model.getListPianoDiStudi().get(k);

			int creditiMancanti = 0;
			for (int i=0; i<piano.getElencoAttivit‡Obbligatorie().size();i++){
				creditiMancanti+= ((Disciplina)piano.getElencoAttivit‡Obbligatorie().get(i)).getCrediti();
			}

			creditiMancanti = piano.getCorso().getTotCrediti()-creditiMancanti;


			ArrayList<String> elencoAttivit‡String = new ArrayList<String>();
			ArrayList<String> elencoAttivit‡ = new ArrayList<String>();

			for (int i=0; i<piano.getElencoAttivit‡Opzionali().size(); i++)
				elencoAttivit‡String.add(piano.getElencoAttivit‡Opzionali().get(i).getId());



			elencoAttivit‡ = Comb.getCombinazioni(elencoAttivit‡String, piano.getElencoAttivit‡Opzionali().size());

			GetDisciplina getDisplina = new GetDisciplina(model);
			int cred;
			ArrayList<Disciplina> listSupport = new ArrayList<Disciplina>();

			if(elencoAttivit‡.size()==0){
				for (int j=0; j<piano.getElencoAttivit‡Obbligatorie().size(); j++){
					listSupport.add((Disciplina)piano.getElencoAttivit‡Obbligatorie().get(j));
				}
				piano.getElencoPianiPossibili().add(listSupport);

			}
			
			for (int i=0, indicePiani = 0; i<elencoAttivit‡.size(); i++){
				String riga[] = elencoAttivit‡.get(i).split(" ");
				cred = 0;
				for (int j=0; j<riga.length; j++)
					cred+=getDisplina.fromIdToDisciplina(riga[j]).getCrediti();
				if (cred == creditiMancanti){
					listSupport = new ArrayList<Disciplina>();
					for (int j=0; j<piano.getElencoAttivit‡Obbligatorie().size(); j++){
						listSupport.add((Disciplina)piano.getElencoAttivit‡Obbligatorie().get(j));
					}
					piano.getElencoPianiPossibili().add(listSupport);
					for (int j=0; j<riga.length; j++)
						piano.getElencoPianiPossibili().get(indicePiani).add(getDisplina.fromIdToDisciplina(riga[j]));
					indicePiani++;
				}

			}

		}


	}



	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}



}
