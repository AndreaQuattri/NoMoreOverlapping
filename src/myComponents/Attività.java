package myComponents;

import java.text.DateFormat;
import java.util.ArrayList;

public class Attività {
	
	private int ore;
	private String id;
	private String descrizione;
	private String nome;
	private DateFormat inizio;
	private DateFormat fine;
	private int semestre;
	
	private ArrayList<Docente> elencoResponsabili;
	
	public Attività(int ore, String id, String descrizione, String nome, DateFormat inizio, DateFormat fine, int semestre, ArrayList<Docente> elencoResponsabili) {
		this.ore = ore;
		this.id = id;
		this.descrizione=descrizione;
		this.nome = nome;
		this.inizio = inizio;
		this.fine = fine;
		this.semestre = semestre;
		this.elencoResponsabili = elencoResponsabili;
	}
	
  public String toString()
  {
      String toReturn = id + "," + nome + "," + descrizione + "," + ore + "," + semestre + "," + inizio + "," + fine+"\n";
      for (int i = 0; i < elencoResponsabili.size(); i++)
          toReturn += elencoResponsabili.get(i).ToString() + " ; ";
      return toReturn;
  }
	
	
	public int getOre() {
		return ore;
	}
	public void setOre(int ore) {
		this.ore = ore;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public DateFormat getInizio() {
		return inizio;
	}
	public void setInizio(DateFormat inizio) {
		this.inizio = inizio;
	}
	public DateFormat getFine() {
		return fine;
	}
	public void setFine(DateFormat fine) {
		this.fine = fine;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}




	public ArrayList<Docente> getElencoResponsabili() {
		return elencoResponsabili;
	}




	public void setElencoResponsabili(ArrayList<Docente> elencoResponsabili) {
		this.elencoResponsabili = elencoResponsabili;
	}
	

}
