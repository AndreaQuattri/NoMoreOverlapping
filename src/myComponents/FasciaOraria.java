package myComponents;

import java.util.Date;

public class FasciaOraria {
	
	private Date inizio;
	private Date fine;
	private String giorno;
	private int idFascia;
	
	public FasciaOraria(Date inizio, Date fine, String giorno, int idFascia) {
		this.inizio = inizio;
		this.fine = fine;
		this.giorno = giorno;
		this.idFascia = idFascia;
	}
	
		
	
	@Override
	public String toString() {
		return idFascia+", "+giorno;
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
