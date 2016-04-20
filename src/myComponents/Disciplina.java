package myComponents;

import java.text.DateFormat;
import java.util.ArrayList;

public class Disciplina extends Attività{
	
	private String codice;
	private int crediti;

	public Disciplina(int ore, String id, String descrizione, String nome, DateFormat inizio, DateFormat fine,
			int semestre, ArrayList<Docente> elencoResponsabili, String codice, int crediti) {
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.codice = codice;
		this.crediti = crediti;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	
	

}
