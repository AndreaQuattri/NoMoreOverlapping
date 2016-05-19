package myComponents;

import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Attività {
	
	private int ore;
	private String id;
	private String descrizione;
	private String nome;
	private Date inizio;
	private Date fine;
	private int semestre;
	
	private ArrayList<Docente> elencoResponsabili;
	
	public Attività(int ore, String id, String descrizione, String nome, Date inizio, Date fine, int semestre, ArrayList<Docente> elencoResponsabili) {
		this.ore = ore;
		this.id = id;
		this.descrizione=descrizione;
		this.nome = nome;
		this.inizio = inizio;
		this.fine = fine;
		this.semestre = semestre;
		this.elencoResponsabili = elencoResponsabili;
	}
	
	public Attività(int ore, String id, String descrizione, String nome, Date inizio, Date fine, int semestre) {
		this.ore = ore;
		this.id = id;
		this.descrizione=descrizione;
		this.nome = nome;
		this.inizio = inizio;
		this.fine = fine;
		this.semestre = semestre;
		this.elencoResponsabili = new ArrayList<Docente>();
	}
	
  public String toString()
  {
	  Format formatter = new SimpleDateFormat("yyyy-mm-dd");
		String dateInizio = formatter.format(inizio);
		String dateFine = formatter.format(fine);
	  
      String toReturn = id + "," + nome + "," + descrizione + "," + ore + "," + semestre + "," + dateInizio + "," + dateFine;
      for (int i = 0; i < elencoResponsabili.size(); i++)
          toReturn += elencoResponsabili.get(i).getCognome().toString() + " ; ";
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
	public Date getInizio() {
		return inizio;
	}
	public void setInizio(Date inizio) {
		this.inizio = inizio;
	}
	public Date getFine() {
		return fine;
	}
	public void setFine(Date fine) {
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
	
	public void aggiungiResponsabile (Docente d){
		this.elencoResponsabili.add(d);
	}
	

	

}
