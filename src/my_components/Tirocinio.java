/*
 * 
 */
package my_components;

import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Tirocinio.
 */
public class Tirocinio extends Attività {

	/** The azienda. */
	private String azienda;
	
	/** The email azienda. */
	private String emailAzienda;
	
	/** The descrizione azienda. */
	private String descrizioneAzienda;
	
	/** The id tirocinio. */
	private int idTirocinio;
	
	/**
	 * Instantiates a new tirocinio.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param elencoResponsabili the elenco responsabili
	 * @param azienda the azienda
	 * @param emailAzienda the email azienda
	 * @param descrizioneAzienda the descrizione azienda
	 * @param idTirocinio the id tirocinio
	 */
	public Tirocinio(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, ArrayList<Docente> elencoResponsabili, String azienda, String emailAzienda, String descrizioneAzienda, int idTirocinio) {
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.azienda = azienda;
		this.emailAzienda = emailAzienda;
		this.descrizioneAzienda = descrizioneAzienda;
		this.idTirocinio = idTirocinio;
	}
	
	/**
	 * Instantiates a new tirocinio.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param azienda the azienda
	 * @param emailAzienda the email azienda
	 * @param descrizioneAzienda the descrizione azienda
	 * @param idTirocinio the id tirocinio
	 */
	public Tirocinio(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, String azienda, String emailAzienda, String descrizioneAzienda, int idTirocinio) {
		super(ore, id, descrizione, nome, inizio, fine, semestre);
		this.azienda = azienda;
		this.emailAzienda = emailAzienda;
		this.descrizioneAzienda = descrizioneAzienda;
		this.idTirocinio = idTirocinio;
	}
	
	/* (non-Javadoc)
	 * @see my_components.Attività#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	/**
	 * Gets the azienda.
	 *
	 * @return the azienda
	 */
	public String getAzienda() {
		return azienda;
	}

	/**
	 * Sets the azienda.
	 *
	 * @param azienda the new azienda
	 */
	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}

	/**
	 * Gets the email azienda.
	 *
	 * @return the email azienda
	 */
	public String getEmailAzienda() {
		return emailAzienda;
	}

	/**
	 * Sets the email azienda.
	 *
	 * @param emailAzienda the new email azienda
	 */
	public void setEmailAzienda(String emailAzienda) {
		this.emailAzienda = emailAzienda;
	}

	/**
	 * Gets the descrizione azienda.
	 *
	 * @return the descrizione azienda
	 */
	public String getDescrizioneAzienda() {
		return descrizioneAzienda;
	}

	/**
	 * Sets the descrizione azienda.
	 *
	 * @param descrizioneAzienda the new descrizione azienda
	 */
	public void setDescrizioneAzienda(String descrizioneAzienda) {
		this.descrizioneAzienda = descrizioneAzienda;
	}

	/**
	 * Gets the id tirocinio.
	 *
	 * @return the id tirocinio
	 */
	public int getIdTirocinio() {
		return idTirocinio;
	}

	/**
	 * Sets the id tirocinio.
	 *
	 * @param idTirocinio the new id tirocinio
	 */
	public void setIdTirocinio(int idTirocinio) {
		this.idTirocinio = idTirocinio;
	}

}
