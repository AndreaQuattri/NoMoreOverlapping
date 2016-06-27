/*
 * 
 */
package myComponents;

import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Gita.
 */
public class Gita extends Attività {
	
	/** The luogo. */
	private String luogo;
	
	/** The id gita. */
	private int idGita;

	/**
	 * Instantiates a new gita.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param elencoResponsabili the elenco responsabili
	 * @param luogo the luogo
	 * @param idGita the id gita
	 */
	public Gita(int ore, String id, String descrizione, String nome, Date inizio, Date fine, int semestre,
			ArrayList<Docente> elencoResponsabili, String luogo, int idGita) {
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.luogo = luogo;
		this.idGita = idGita;
	}
	
	/**
	 * Instantiates a new gita.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param luogo the luogo
	 * @param idGita the id gita
	 */
	public Gita(int ore, String id, String descrizione, String nome, Date inizio, Date fine, int semestre,
			String luogo, int idGita) {
		super(ore, id, descrizione, nome, inizio, fine, semestre);
		this.luogo = luogo;
		this.idGita = idGita;
	}
	
	/* (non-Javadoc)
	 * @see myComponents.Attività#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

	/**
	 * Gets the luogo.
	 *
	 * @return the luogo
	 */
	public String getLuogo() {
		return luogo;
	}

	/**
	 * Sets the luogo.
	 *
	 * @param luogo the new luogo
	 */
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	/**
	 * Gets the id gita.
	 *
	 * @return the id gita
	 */
	public int getIdGita() {
		return idGita;
	}

	/**
	 * Sets the id gita.
	 *
	 * @param idGita the new id gita
	 */
	public void setIdGita(int idGita) {
		this.idGita = idGita;
	}

}
