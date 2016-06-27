/*
 * 
 */
package myComponents;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FasciaOraria.
 */
public class FasciaOraria{

	/** The inizio. */
	private Date inizio;
	
	/** The fine. */
	private Date fine;
	
	/** The giorno. */
	private String giorno;
	
	/** The id fascia. */
	private int idFascia;

	/**
	 * Instantiates a new fascia oraria.
	 */
	public FasciaOraria() {
		this.inizio 	= new Date();
		this.fine 		= new Date();
		this.giorno 	= "";
		this.idFascia 	= -1;
	}
	
	/**
	 * Instantiates a new fascia oraria.
	 *
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param giorno the giorno
	 * @param idFascia the id fascia
	 */
	public FasciaOraria(Date inizio, Date fine, String giorno, int idFascia) {
		this.inizio 	= inizio;
		this.fine 		= fine;
		this.giorno 	= giorno;
		this.idFascia 	= idFascia;
	}
	



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		Format formatter = new SimpleDateFormat("HH:mm:ss");
		String dateInizio = formatter.format(inizio);
		String dateFine = formatter.format(fine);

		return idFascia+", "+giorno +", " + dateInizio + ", " + dateFine;
	}



	/**
	 * Gets the inizio.
	 *
	 * @return the inizio
	 */
	public Date getInizio() {
		return inizio;
	}
	
	/**
	 * Sets the inizio.
	 *
	 * @param inizio the new inizio
	 */
	public void setInizio(Date inizio) {
		this.inizio = inizio;
	}
	
	/**
	 * Gets the fine.
	 *
	 * @return the fine
	 */
	public Date getFine() {
		return fine;
	}
	
	/**
	 * Sets the fine.
	 *
	 * @param fine the new fine
	 */
	public void setFine(Date fine) {
		this.fine = fine;
	}
	
	/**
	 * Gets the giorno.
	 *
	 * @return the giorno
	 */
	public String getGiorno() {
		return giorno;
	}
	
	/**
	 * Sets the giorno.
	 *
	 * @param giorno the new giorno
	 */
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	
	/**
	 * Gets the id fascia.
	 *
	 * @return the id fascia
	 */
	public int getIdFascia() {
		return idFascia;
	}
	
	/**
	 * Sets the id fascia.
	 *
	 * @param idFascia the new id fascia
	 */
	public void setIdFascia(int idFascia) {
		this.idFascia = idFascia;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object f) {
		// TODO Auto-generated method stub
		if (this.idFascia == ((FasciaOraria)f).getIdFascia())
			return true;
		return false;
	}





}
