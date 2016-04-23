package myComponents;

import java.util.ArrayList;
import java.util.Date;

public class Disciplina extends Attività{
	
	private String codice;
	private float crediti;

	public Disciplina(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, ArrayList<Docente> elencoResponsabili, String codice, float crediti) {
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.codice = codice;
		this.crediti = crediti;
	}
	
	public Disciplina(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, String codice, float crediti) {
		super(ore, id, descrizione, nome, inizio, fine, semestre);
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

	public float getCrediti() {
		return crediti;
	}

	public void setCrediti(float crediti) {
		this.crediti = crediti;
	}
	
	

}
