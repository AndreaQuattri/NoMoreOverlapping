/*
 * 
 */
package myComponents;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class PianoDiStudi.
 */
public class PianoDiStudi {

	/** The corso. */
	private CorsoDiStudi corso;
	
	/** The elenco attività obbligatorie. */
	private ArrayList<Attività> elencoAttivitàObbligatorie;
	
	/** The elenco attività opzionali. */
	private ArrayList<Attività> elencoAttivitàOpzionali;
	
	
	/** The elenco piani possibili. */
	private ArrayList<ArrayList<Disciplina>> elencoPianiPossibili;


	/**
	 * Instantiates a new piano di studi.
	 *
	 * @param corso the corso
	 * @param elencoAttivitàObbligatore the elenco attività obbligatore
	 * @param elencoAttivitàOpzionali the elenco attività opzionali
	 */
	public PianoDiStudi(CorsoDiStudi corso, ArrayList<Attività> elencoAttivitàObbligatore,
			ArrayList<Attività> elencoAttivitàOpzionali) {
		this.corso = corso;
		this.elencoAttivitàObbligatorie = elencoAttivitàObbligatore;
		this.elencoAttivitàOpzionali = elencoAttivitàOpzionali;
		this.elencoPianiPossibili = new ArrayList<ArrayList<Disciplina>>();
	}

	/**
	 * Instantiates a new piano di studi.
	 *
	 * @param corso the corso
	 */
	public PianoDiStudi(CorsoDiStudi corso) {
		this.corso = corso;
		elencoAttivitàObbligatorie = new ArrayList<Attività>();
		elencoAttivitàOpzionali = new ArrayList<Attività>();
		this.elencoPianiPossibili = new ArrayList<ArrayList<Disciplina>>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
			
		int totC = 0;
		
		String toRet = corso.toString() + "\n";
		
		toRet += "Obbligatorie\n";
		for (int i=0; i<elencoAttivitàObbligatorie.size(); i++){
			toRet += elencoAttivitàObbligatorie.get(i).toString();
			totC += ((Disciplina)elencoAttivitàObbligatorie.get(i)).getCrediti();
		}
		
		
		toRet += "\nOpzionale\n";
		for (int i=0; i<elencoAttivitàOpzionali.size(); i++)
			toRet += elencoAttivitàOpzionali.get(i).toString();
		
		

		toRet += "\nPiani possibili\n";
		for (int i=0; i<elencoPianiPossibili.size(); i++){
			for (int j=0; j<elencoPianiPossibili.get(i).size(); j++)
				toRet += elencoPianiPossibili.get(i).get(j).toString();
			toRet += "\n";
		}
		
		return toRet+"\n"+totC;
	
	}


	/**
	 * Gets the corso.
	 *
	 * @return the corso
	 */
	public CorsoDiStudi getCorso() {
		return corso;
	}
	
	/**
	 * Sets the corso.
	 *
	 * @param corso the new corso
	 */
	public void setCorso(CorsoDiStudi corso) {
		this.corso = corso;
	}
	
	/**
	 * Gets the elenco attività obbligatorie.
	 *
	 * @return the elenco attività obbligatorie
	 */
	public ArrayList<Attività> getElencoAttivitàObbligatorie() {
		return elencoAttivitàObbligatorie;
	}
	
	/**
	 * Sets the elenco attività obbligatorie.
	 *
	 * @param elencoAttivitàObbligatorie the new elenco attività obbligatorie
	 */
	public void setElencoAttivitàObbligatorie(ArrayList<Attività> elencoAttivitàObbligatorie) {
		this.elencoAttivitàObbligatorie = elencoAttivitàObbligatorie;
	}
	
	/**
	 * Gets the elenco attività opzionali.
	 *
	 * @return the elenco attività opzionali
	 */
	public ArrayList<Attività> getElencoAttivitàOpzionali() {
		return elencoAttivitàOpzionali;
	}
	
	/**
	 * Sets the elenco attività opzionali.
	 *
	 * @param elencoAttivitàOpzionali the new elenco attività opzionali
	 */
	public void setElencoAttivitàOpzionali(ArrayList<Attività> elencoAttivitàOpzionali) {
		this.elencoAttivitàOpzionali = elencoAttivitàOpzionali;
	}
	
	/**
	 * Aggiungi attività obbligatoria.
	 *
	 * @param attivitàObbligatoria the attività obbligatoria
	 */
	public void aggiungiAttivitàObbligatoria(Attività attivitàObbligatoria){
		this.elencoAttivitàObbligatorie.add(attivitàObbligatoria);
	}
	
	/**
	 * Aggiungi attività opzionale.
	 *
	 * @param attivitàOpzionale the attività opzionale
	 */
	public void aggiungiAttivitàOpzionale(Attività attivitàOpzionale){
		this.elencoAttivitàOpzionali.add(attivitàOpzionale);
	}

	/**
	 * Gets the elenco piani possibili.
	 *
	 * @return the elenco piani possibili
	 */
	public ArrayList<ArrayList<Disciplina>> getElencoPianiPossibili() {
		return elencoPianiPossibili;
	}

	/**
	 * Sets the elenco piani possibili.
	 *
	 * @param elencoPianiPossibili the new elenco piani possibili
	 */
	public void setElencoPianiPossibili(ArrayList<ArrayList<Disciplina>> elencoPianiPossibili) {
		this.elencoPianiPossibili = elencoPianiPossibili;
	}



}
