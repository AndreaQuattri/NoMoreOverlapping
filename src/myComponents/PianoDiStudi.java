package myComponents;

import java.util.ArrayList;

public class PianoDiStudi {

	private CorsoDiStudi corso;
	private ArrayList<Attività> elencoAttivitàObbligatorie;
	private ArrayList<Attività> elencoAttivitàOpzionali;
	
	
	//dovrà andare qui il campo di CorsoDiStudi
	private ArrayList<Disciplina> elencoPianiPossibili;


	public PianoDiStudi(CorsoDiStudi corso, ArrayList<Attività> elencoAttivitàObbligatore,
			ArrayList<Attività> elencoAttivitàOpzionali) {
		this.corso = corso;
		this.elencoAttivitàObbligatorie = elencoAttivitàObbligatore;
		this.elencoAttivitàOpzionali = elencoAttivitàOpzionali;
		this.elencoPianiPossibili = new ArrayList<Disciplina>();
	}

	public PianoDiStudi(CorsoDiStudi corso) {
		this.corso = corso;
		elencoAttivitàObbligatorie = new ArrayList<Attività>();
		elencoAttivitàOpzionali = new ArrayList<Attività>();
		this.elencoPianiPossibili = new ArrayList<Disciplina>();
	}

	@Override
	public String toString() {
		
		//if (corso.getTipoLaurea().equals("Magistale")){
			
		int totC = 0;
		
		String toRet = corso.toString() + "\n";
		
		toRet += "Obbligatorie\n";
		for (int i=0; i<elencoAttivitàObbligatorie.size(); i++){
			toRet += elencoAttivitàObbligatorie.get(i).toString() + "\n";
			totC += ((Disciplina)elencoAttivitàObbligatorie.get(i)).getCrediti();
		}
		
		
		toRet += "\nOpzionale\n";
		for (int i=0; i<elencoAttivitàOpzionali.size(); i++)
			toRet += elencoAttivitàOpzionali.get(i).toString() + "\n";
		
		

		toRet += "\nPiani possibili\n";
		for (int i=0; i<elencoPianiPossibili.size(); i++)
			toRet += elencoPianiPossibili.get(i).toString() + "\n";
		
		return toRet+"\n"+totC;
		//}
		//return "";
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

	public ArrayList<Disciplina> getElencoPianiPossibili() {
		return elencoPianiPossibili;
	}

	public void setElencoPianiPossibili(ArrayList<Disciplina> elencoPianiPossibili) {
		this.elencoPianiPossibili = elencoPianiPossibili;
	}



}
