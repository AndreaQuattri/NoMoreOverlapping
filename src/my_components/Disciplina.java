/*
 * 
 */
package my_components;

import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Disciplina.
 */
public class Disciplina extends Attività{

	/** The codice. */
	private String codice;
	
	/** The crediti. */
	private float crediti;
	
	/** The sub id. */
	private int subId;
	
	/** The sub ore. */
	private int subOre;

	/**
	 * Instantiates a new disciplina.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param elencoResponsabili the elenco responsabili
	 * @param codice the codice
	 * @param crediti the crediti
	 */
	public Disciplina(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, ArrayList<Docente> elencoResponsabili, String codice, float crediti) {
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.codice = codice;
		this.crediti = crediti;
	}

	/**
	 * Instantiates a new disciplina.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param codice the codice
	 * @param crediti the crediti
	 */
	public Disciplina(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, String codice, float crediti) {
		super(ore, id, descrizione, nome, inizio, fine, semestre);
		this.codice = codice;
		this.crediti = crediti;
	}

	/**
	 * Instantiates a new disciplina.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param codice the codice
	 * @param crediti the crediti
	 * @param subId the sub id
	 * @param subOre the sub ore
	 */
	public Disciplina(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, String codice, float crediti, int subId, int subOre) {
		super(ore, id, descrizione, nome, inizio, fine, semestre);
		this.codice = codice;
		this.crediti = crediti;
		this.subId = subId;
		this.subOre = subOre;
	}

	/**
	 * Instantiates a new disciplina.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param elencoResponsabili the elenco responsabili
	 * @param codice the codice
	 * @param crediti the crediti
	 * @param subId the sub id
	 * @param subOre the sub ore
	 */
	public Disciplina(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, ArrayList<Docente> elencoResponsabili, String codice, float crediti, int subId, int subOre) {
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.codice = codice;
		this.crediti = crediti;
		this.subId = subId;
		this.subOre = subOre;
	}

	/* (non-Javadoc)
	 * @see my_components.Attività#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + subId + ", " + subOre + "\n";
	}

	/**
	 * Gets the codice.
	 *
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * Sets the codice.
	 *
	 * @param codice the new codice
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * Gets the crediti.
	 *
	 * @return the crediti
	 */
	public float getCrediti() {
		return crediti;
	}

	/**
	 * Sets the crediti.
	 *
	 * @param crediti the new crediti
	 */
	public void setCrediti(float crediti) {
		this.crediti = crediti;
	}

	/**
	 * Gets the sub id.
	 *
	 * @return the sub id
	 */
	public int getSubId() {
		return subId;
	}

	/**
	 * Sets the sub id.
	 *
	 * @param subId the new sub id
	 */
	public void setSubId(int subId) {
		this.subId = subId;
	}

	/**
	 * Gets the sub ore.
	 *
	 * @return the sub ore
	 */
	public int getSubOre() {
		return subOre;
	}

	/**
	 * Sets the sub ore.
	 *
	 * @param subOre the new sub ore
	 */
	public void setSubOre(int subOre) {
		this.subOre = subOre;
	}

	/* (non-Javadoc)
	 * @see my_components.Attività#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Disciplina)) {
			return false; 
		} 

		Disciplina d = (Disciplina) obj;
		return (d.getId().equals(this.getId()) &&
				d.getSubId() == this.getSubId());

	}


}
