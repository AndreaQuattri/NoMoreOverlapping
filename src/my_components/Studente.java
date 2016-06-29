/*
 * 
 */
package my_components;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Studente.
 */
public class Studente {
	
	/** The nome. */
	private String nome;
	
	/** The cognome. */
	private String cognome;
	
	/** The matricola. */
	private String matricola;
	
	/** The email. */
	private String email;
	
	/** The nascita. */
	private Date nascita;
	
	/** The anno iscrizione. */
	private int annoIscrizione;
	
	
	/** The corso. */
	private CorsoDiStudi corso;
	
	/**
	 * Instantiates a new studente.
	 *
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param matricola the matricola
	 * @param email the email
	 * @param nascita the nascita
	 * @param annoIscrizione the anno iscrizione
	 * @param corso the corso
	 */
	public Studente(String nome, String cognome, String matricola, String email, 
			Date nascita, int annoIscrizione, CorsoDiStudi corso) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.email = email;
		this.nascita = nascita;
		this.annoIscrizione = annoIscrizione;
		this.corso = corso;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
        return matricola+", "+nome+", "+cognome+", "+email+", "+nascita+", "+annoIscrizione + corso.getNomePrincipale();
	}
	
	
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the cognome.
	 *
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Sets the cognome.
	 *
	 * @param cognome the new cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * Gets the matricola.
	 *
	 * @return the matricola
	 */
	public String getMatricola() {
		return matricola;
	}
	
	/**
	 * Sets the matricola.
	 *
	 * @param matricola the new matricola
	 */
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the nascita.
	 *
	 * @return the nascita
	 */
	public Date getNascita() {
		return nascita;
	}
	
	/**
	 * Sets the nascita.
	 *
	 * @param nascita the new nascita
	 */
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
	
	/**
	 * Gets the anno iscrizione.
	 *
	 * @return the anno iscrizione
	 */
	public int getAnnoIscrizione() {
		return annoIscrizione;
	}
	
	/**
	 * Sets the anno iscrizione.
	 *
	 * @param annoIscrizione the new anno iscrizione
	 */
	public void setAnnoIscrizione(int annoIscrizione) {
		this.annoIscrizione = annoIscrizione;
	}


	/**
	 * Gets the corso.
	 *
	 * @return the corso
	 */
	public CorsoDiStudi getCorso() {
		return corso;
	}


	/**
	 * Sets the corso.
	 *
	 * @param corso the new corso
	 */
	public void setCorso(CorsoDiStudi corso) {
		this.corso = corso;
	}
	
	

}
