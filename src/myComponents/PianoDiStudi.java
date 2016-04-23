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
		elencoAttivitàObbligatorie = null;
		elencoAttivitàOpzionali = null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
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



}
