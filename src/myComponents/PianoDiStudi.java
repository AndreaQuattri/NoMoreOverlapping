package myComponents;

import java.util.ArrayList;

public class PianoDiStudi {

	private CorsoDiStudi corso;
	private ArrayList<Attivit‡> elencoAttivit‡Obbligatorie;
	private ArrayList<Attivit‡> elencoAttivit‡Opzionali;
	
	
	//dovr√† andare qui il campo di CorsoDiStudi
	private ArrayList<ArrayList<Disciplina>> elencoPianiPossibili;


	public PianoDiStudi(CorsoDiStudi corso, ArrayList<Attivit‡> elencoAttivit‡Obbligatore,
			ArrayList<Attivit‡> elencoAttivit‡Opzionali) {
		this.corso = corso;
		this.elencoAttivit‡Obbligatorie = elencoAttivit‡Obbligatore;
		this.elencoAttivit‡Opzionali = elencoAttivit‡Opzionali;
		this.elencoPianiPossibili = new ArrayList<ArrayList<Disciplina>>();
	}

	public PianoDiStudi(CorsoDiStudi corso) {
		this.corso = corso;
		elencoAttivit‡Obbligatorie = new ArrayList<Attivit‡>();
		elencoAttivit‡Opzionali = new ArrayList<Attivit‡>();
		this.elencoPianiPossibili = new ArrayList<ArrayList<Disciplina>>();
	}

	@Override
	public String toString() {
		
			
		int totC = 0;
		
		String toRet = corso.toString() + "\n";
		
		toRet += "Obbligatorie\n";
		for (int i=0; i<elencoAttivit‡Obbligatorie.size(); i++){
			toRet += elencoAttivit‡Obbligatorie.get(i).toString();
			totC += ((Disciplina)elencoAttivit‡Obbligatorie.get(i)).getCrediti();
		}
		
		
		toRet += "\nOpzionale\n";
		for (int i=0; i<elencoAttivit‡Opzionali.size(); i++)
			toRet += elencoAttivit‡Opzionali.get(i).toString();
		
		

		toRet += "\nPiani possibili\n";
		for (int i=0; i<elencoPianiPossibili.size(); i++){
			for (int j=0; j<elencoPianiPossibili.get(i).size(); j++)
				toRet += elencoPianiPossibili.get(i).get(j).toString();
			toRet += "\n";
		}
		
		return toRet+"\n"+totC;
	
	}


	public CorsoDiStudi getCorso() {
		return corso;
	}
	public void setCorso(CorsoDiStudi corso) {
		this.corso = corso;
	}
	public ArrayList<Attivit‡> getElencoAttivit‡Obbligatorie() {
		return elencoAttivit‡Obbligatorie;
	}
	public void setElencoAttivit‡Obbligatorie(ArrayList<Attivit‡> elencoAttivit‡Obbligatorie) {
		this.elencoAttivit‡Obbligatorie = elencoAttivit‡Obbligatorie;
	}
	public ArrayList<Attivit‡> getElencoAttivit‡Opzionali() {
		return elencoAttivit‡Opzionali;
	}
	public void setElencoAttivit‡Opzionali(ArrayList<Attivit‡> elencoAttivit‡Opzionali) {
		this.elencoAttivit‡Opzionali = elencoAttivit‡Opzionali;
	}
	
	public void aggiungiAttivit‡Obbligatoria(Attivit‡ Attivit‡Obbligatoria){
		this.elencoAttivit‡Obbligatorie.add(Attivit‡Obbligatoria);
	}
	
	public void aggiungiAttivit‡Opzionale(Attivit‡ Attivit‡Opzionale){
		this.elencoAttivit‡Opzionali.add(Attivit‡Opzionale);
	}

	public ArrayList<ArrayList<Disciplina>> getElencoPianiPossibili() {
		return elencoPianiPossibili;
	}

	public void setElencoPianiPossibili(ArrayList<ArrayList<Disciplina>> elencoPianiPossibili) {
		this.elencoPianiPossibili = elencoPianiPossibili;
	}



}
