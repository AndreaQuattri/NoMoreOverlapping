/*
 * 
 */
package elaborazione_dati;

import java.util.ArrayList;

import mvc.Model;
import my_components.*;

// TODO: Auto-generated Javadoc
/**
 * The Class GeneraPianiDiStudio.
 */
public class GeneraPianiDiStudio {


	/** The model. */
	private Model model;

	/**
	 * Instantiates a new genera piani di studio.
	 *
	 * @param model the model
	 */
	public GeneraPianiDiStudio(final Model model) {
		this.model = model;
	}


	/**
	 * Genera piani.
	 */
	public void generaPiani(){


		for (int k=0; k<model.getListPianoDiStudi().size(); k++){

			final PianoDiStudi piano = model.getListPianoDiStudi().get(k);

			int creditiMancanti = 0;
			for (int i=0; i<piano.getElencoAttivitàObbligatorie().size();i++){
				creditiMancanti+= ((Disciplina)piano.getElencoAttivitàObbligatorie().get(i)).getCrediti();
			}

			creditiMancanti = piano.getCorso().getTotCrediti()-creditiMancanti;


			final ArrayList<String> elencoAttivitàString = new ArrayList<String>();
			final ArrayList<String> elencoAttività = new ArrayList<String>();

			for (int i=0; i<piano.getElencoAttivitàOpzionali().size(); i++)
				elencoAttivitàString.add(piano.getElencoAttivitàOpzionali().get(i).getId());



			//elencoAttività = Comb.getCombinazioni(elencoAttivitàString, piano.getElencoAttivitàOpzionali().size());

			//GetDisciplina getDisplina = new GetDisciplina(model);
			int cred;
			ArrayList<Disciplina> listSupport = new ArrayList<Disciplina>();

			if(elencoAttività.size()==0){
				for (int j=0; j<piano.getElencoAttivitàObbligatorie().size(); j++){
					listSupport.add((Disciplina)piano.getElencoAttivitàObbligatorie().get(j));
				}
				piano.getElencoPianiPossibili().add(listSupport);

			}
			
			
			int indicePiani = 0;
			for (int i=0; i<elencoAttività.size(); i++){
				final String riga[] = elencoAttività.get(i).split(" ");
				cred = 0;
				for (int j=0; j<riga.length; j++)
					cred+=model.fromIdToDisciplina(riga[j]).getCrediti();
				if (cred == creditiMancanti){
					listSupport = new ArrayList<Disciplina>();
					for (int j=0; j<piano.getElencoAttivitàObbligatorie().size(); j++){
						listSupport.add((Disciplina)piano.getElencoAttivitàObbligatorie().get(j));
					}
					piano.getElencoPianiPossibili().add(listSupport);
					for (int j=0; j<riga.length; j++)
						piano.getElencoPianiPossibili().get(indicePiani).add(model.fromIdToDisciplina(riga[j]));
					indicePiani++;
				}

			}

		}


	}



	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(final Model model) {
		this.model = model;
	}



}
