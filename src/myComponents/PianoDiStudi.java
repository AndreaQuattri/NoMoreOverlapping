package myComponents;

import java.util.ArrayList;

public class PianoDiStudi {

	private CorsoDiStudi corso;
	private ArrayList<Attività> elencoAttivitàObbligatorie;
	private ArrayList<Attività> elencoAttivitàOpzionali;

	public PianoDiStudi(CorsoDiStudi corso, ArrayList<Attività> elencoAttivitàObbligatore,
			ArrayList<Attività> elencoAttivitàOpzionali) {
		this.corso = corso;
		this.elencoAttivitàObbligatorie = elencoAttivitàObbligatore;
		this.elencoAttivitàOpzionali = elencoAttivitàOpzionali;
	}

	public PianoDiStudi(CorsoDiStudi corso) {
		this.corso = corso;
		elencoAttivitàObbligatorie = new ArrayList<Attività>();
		elencoAttivitàOpzionali = new ArrayList<Attività>();
	}

	@Override
	public String toString() {
		return corso.toString();
	}


	public CorsoDiStudi getCorso() {
		return corso;
	}
	public void setCorso(CorsoDiStudi corso) {
		this.corso = corso;
	}
	public ArrayList<Attività> getElencoAttivitàObbligatorie() {
		return elencoAttivitàObbligatorie;
	}
	public void setElencoAttivitàObbligatorie(ArrayList<Attività> elencoAttivitàObbligatorie) {
		this.elencoAttivitàObbligatorie = elencoAttivitàObbligatorie;
	}
	public ArrayList<Attività> getElencoAttivitàOpzionali() {
		return elencoAttivitàOpzionali;
	}
	public void setElencoAttivitàOpzionali(ArrayList<Attività> elencoAttivitàOpzionali) {
		this.elencoAttivitàOpzionali = elencoAttivitàOpzionali;
	}
	
	public void aggiungiAttivitàObbligatoria(Attività attivitàObbligatoria){
		this.elencoAttivitàObbligatorie.add(attivitàObbligatoria);
	}
	
	public void aggiungiAttivitàOpzionale(Attività attivitàOpzionale){
		this.elencoAttivitàOpzionali.add(attivitàOpzionale);
	}



}
