package myComponents;

import java.util.ArrayList;
import java.util.Date;

public class Disciplina extends Attività{
	
	private String codice;
	private float crediti;
	private int subId;
	private int subOre;

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
	
	public Disciplina(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, String codice, float crediti, int subId, int subOre) {
		super(ore, id, descrizione, nome, inizio, fine, semestre);
		this.codice = codice;
		this.crediti = crediti;
		this.subId = subId;
		this.subOre = subOre;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + subId + ", " + subOre;
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

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public int getSubOre() {
		return subOre;
	}

	public void setSubOre(int subOre) {
		this.subOre = subOre;
	}
	
	

}
