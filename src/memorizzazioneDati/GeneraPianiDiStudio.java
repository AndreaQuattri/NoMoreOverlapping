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
			for (int i=0; i<piano.getElencoAttivitàObbligatorie().size();i++){
				creditiMancanti+= ((Disciplina)piano.getElencoAttivitàObbligatorie().get(i)).getCrediti();
			}

			creditiMancanti = piano.getCorso().getTotCrediti()-creditiMancanti;


			ArrayList<String> elencoAttivitàString = new ArrayList<String>();
			ArrayList<String> elencoAttività = new ArrayList<String>();

			for (int i=0; i<piano.getElencoAttivitàOpzionali().size(); i++)
				elencoAttivitàString.add(piano.getElencoAttivitàOpzionali().get(i).getId());



			elencoAttività = Comb.getCombinazioni(elencoAttivitàString, piano.getElencoAttivitàOpzionali().size());

			GetDisciplina getDisplina = new GetDisciplina(model);
			int cred;
			ArrayList<Disciplina> listSupport = new ArrayList<Disciplina>();

			if(elencoAttività.size()==0){
				for (int j=0; j<piano.getElencoAttivitàObbligatorie().size(); j++){
					listSupport.add((Disciplina)piano.getElencoAttivitàObbligatorie().get(j));
				}
				piano.getElencoPianiPossibili().add(listSupport);

			}
			
			for (int i=0, indicePiani = 0; i<elencoAttività.size(); i++){
				String riga[] = elencoAttività.get(i).split(" ");
				cred = 0;
				for (int j=0; j<riga.length; j++)
					cred+=getDisplina.fromIdToDisciplina(riga[j]).getCrediti();
				if (cred == creditiMancanti){
					listSupport = new ArrayList<Disciplina>();
					for (int j=0; j<piano.getElencoAttivitàObbligatorie().size(); j++){
						listSupport.add((Disciplina)piano.getElencoAttivitàObbligatorie().get(j));
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
