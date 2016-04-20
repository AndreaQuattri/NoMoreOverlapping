package myComponents;

import java.text.DateFormat;

public class FasciaOraria {
	
	private DateFormat inizio;
	private DateFormat fine;
	private String giorno;
	private int idFascia;
	
	public FasciaOraria(DateFormat inizio, DateFormat fine, String giorno, int idFascia) {
		this.inizio = inizio;
		this.fine = fine;
		this.giorno = giorno;
		this.idFascia = idFascia;
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
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	public int getIdFascia() {
		return idFascia;
	}
	public void setIdFascia(int idFascia) {
		this.idFascia = idFascia;
	}
	
	
	
	
	

}
