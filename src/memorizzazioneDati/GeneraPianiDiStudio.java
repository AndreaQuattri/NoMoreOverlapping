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

			for (int i=0; i<elencoAttività.size(); i++){
				String riga[] = elencoAttività.get(i).split(" ");
				cred = 0;
				for (int j=0; j<riga.length; j++)
					cred+=getDisplina.fromIdToDisciplina(riga[j]).getCrediti();
				if (cred == creditiMancanti)
					for (int j=0; j<riga.length; j++)
						piano.getElencoPianiPossibili().add(getDisplina.fromIdToDisciplina(riga[j]));

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
