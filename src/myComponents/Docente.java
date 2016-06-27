/*
 * 
 */
package myComponents;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Docente.
 */
public class Docente implements Comparable<Docente>{

	/** The nome. */
	private String nome;
	
	/** The cognome. */
	private String cognome;
	
	/** The associato. */
	private boolean associato;
	
	/** The matricola. */
	private String matricola;
	
	/** The email. */
	private String email;
	
	/** The qualifica. */
	private String qualifica;

	/** The elenco attività. */
	private ArrayList<Attività> elencoAttività;
	
	/** The orari preferiti. */
	private ArrayList<SceltaOraria> orariPreferiti;
	
	/** The aule preferite. */
	private ArrayList<SceltaAula> aulePreferite;

	/**
	 * Instantiates a new docente.
	 *
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param associato the associato
	 * @param matricola the matricola
	 * @param email the email
	 * @param qualifica the qualifica
	 * @param elencoAttività the elenco attività
	 * @param orariPreferiti the orari preferiti
	 * @param aulePreferite the aule preferite
	 */
	public Docente(String nome, String cognome, boolean associato, String matricola,
			String email, String qualifica, ArrayList<Attività> elencoAttività,
			ArrayList<SceltaOraria> orariPreferiti, ArrayList<SceltaAula> aulePreferite) {
		this.nome = nome;
		this.cognome = cognome;
		this.associato = associato;
		this.matricola = matricola;
		this.email = email;
		this.qualifica = qualifica;
		this.elencoAttività = elencoAttività;
		this.orariPreferiti = orariPreferiti;
		this.aulePreferite = aulePreferite;
	}
	
	/**
	 * Instantiates a new docente.
	 */
	public Docente() {
		this.nome = "";
		this.cognome = "";
		this.associato = true;
		this.matricola = "";
		this.email = "";
		this.qualifica = "";
		this.elencoAttività = new ArrayList<Attività>();
		this.orariPreferiti = new ArrayList<SceltaOraria>();
		this.aulePreferite = new ArrayList<SceltaAula>();
	}

	/**
	 * Instantiates a new docente.
	 *
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param associato the associato
	 * @param matricola the matricola
	 * @param email the email
	 * @param qualifica the qualifica
	 */
	public Docente(String nome, String cognome, boolean associato, String matricola,
			String email, String qualifica) {
		this.nome = nome;
		this.cognome = cognome;
		this.associato = associato;
		this.matricola = matricola;
		this.email = email;
		this.qualifica = qualifica;
		this.elencoAttività = new ArrayList<Attività>();
		this.orariPreferiti = new ArrayList<SceltaOraria>();
		this.aulePreferite = new ArrayList<SceltaAula>();
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String toRet = this.matricola+", "+this.nome+", "+this.cognome+", "+this.email+", "+this.qualifica+", "+this.associato+ "\n\n";
			for (int i=0; i<elencoAttività.size(); i++){
				toRet += elencoAttività.get(i).toString();
			}
			toRet += "\n";
			for (int i=0; i<orariPreferiti.size(); i++){
				toRet += orariPreferiti.get(i).toString() + "\n";
			}
			toRet += "\n";
			for (int i=0; i<aulePreferite.size(); i++){
				toRet += aulePreferite.get(i).toString() + "\n";
			}
		return toRet;
	}


	/**
	 * Aggiungi attività.
	 *
	 * @param a the a
	 */
	public void aggiungiAttività(Attività a)
	{
		elencoAttività.add(a);
	}

	/**
	 * Cancella attività.
	 *
	 * @param a the a
	 * @return the boolean
	 */
	public Boolean cancellaAttività(Attività a)
	{
		// TODO da completare.
		return false;
	}

	/**
	 * Cancella tutte attività.
	 *
	 * @param a the a
	 */
	public void cancellaTutteAttività(Attività a)
	{
		// TODO da completare.
	}

	/**
	 * Aggiungi preferenza.
	 *
	 * @param so the so
	 */
	public void aggiungiPreferenza(SceltaOraria so)
	{
		orariPreferiti.add(so);
	}

	/**
	 * Aggiungi preferenza.
	 *
	 * @param sa the sa
	 */
	public void aggiungiPreferenza(SceltaAula sa)
	{
		aulePreferite.add(sa);
	}

	/**
	 * Cancella preferenza.
	 *
	 * @param so the so
	 * @return the boolean
	 */
	public Boolean cancellaPreferenza(SceltaOraria so)
	{
		// TODO da completare.
		return false;
	}

	/**
	 * Cancella preferenza.
	 *
	 * @param sa the sa
	 * @return the boolean
	 */
	public Boolean cancellaPreferenza(SceltaAula sa)
	{
		// TODO da completare.
		return false;
	}

	/**
	 * Cancella aule preferite.
	 */
	public void cancellaAulePreferite()
	{
		// TODO da completare.
	}

	/**
	 * Cancella ore preferite.
	 */
	public void cancellaOrePreferite()
	{
		// TODO da completare.
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
	 * Checks if is associato.
	 *
	 * @return true, if is associato
	 */
	public boolean isAssociato() {
		return associato;
	}

	/**
	 * Sets the associato.
	 *
	 * @param associato the new associato
	 */
	public void setAssociato(boolean associato) {
		this.associato = associato;
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
	 * Gets the qualifica.
	 *
	 * @return the qualifica
	 */
	public String getQualifica() {
		return qualifica;
	}

	/**
	 * Sets the qualifica.
	 *
	 * @param qualifica the new qualifica
	 */
	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}

	/**
	 * Gets the elenco attività.
	 *
	 * @return the elenco attività
	 */
	public ArrayList<Attività> getElencoAttività() {
		return elencoAttività;
	}

	/**
	 * Sets the elenco attività.
	 *
	 * @param elencoAttività the new elenco attività
	 */
	public void setElencoAttività(ArrayList<Attività> elencoAttività) {
		this.elencoAttività = elencoAttività;
	}

	/**
	 * Gets the orari preferit.
	 *
	 * @return the orari preferit
	 */
	public ArrayList<SceltaOraria> getOrariPreferit() {
		return orariPreferiti;
	}

	/**
	 * Sets the orari preferit.
	 *
	 * @param orariPreferiti the new orari preferit
	 */
	public void setOrariPreferit(ArrayList<SceltaOraria> orariPreferiti) {
		this.orariPreferiti = orariPreferiti;
	}

	/**
	 * Gets the aule preferite.
	 *
	 * @return the aule preferite
	 */
	public ArrayList<SceltaAula> getAulePreferite() {
		return aulePreferite;
	}

	/**
	 * Sets the aule preferite.
	 *
	 * @param aulePreferite the new aule preferite
	 */
	public void setAulePreferite(ArrayList<SceltaAula> aulePreferite) {
		this.aulePreferite = aulePreferite;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Docente o) {
		// TODO Auto-generated method stub
		return this.matricola.compareTo(o.matricola);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Docente)) {
			return false; 
		} 

		Docente a = (Docente) obj;
		return a.getMatricola().equals(this.matricola);
	}

}
