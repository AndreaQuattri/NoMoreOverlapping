/*
 * 
 */
package my_components;

import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Esame.
 */
public class Esame extends Attività {
	
	/** The tipologia. */
	private String tipologia;
	
	/** The id esame. */
	//private Disciplina materia;
	private int idEsame;

	/**
	 * Instantiates a new esame.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param elencoResponsabili the elenco responsabili
	 * @param tipologia the tipologia
	 * @param materia the materia
	 * @param idEsame the id esame
	 */
	public Esame(int ore, String id, String descrizione, String nome, Date inizio, Date fine, int semestre,
			ArrayList<Docente> elencoResponsabili, String tipologia, Disciplina materia, int idEsame) {
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.tipologia = tipologia;
		//this.materia = materia;
		this.idEsame = idEsame;
	}
	
	/**
	 * Instantiates a new esame.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param tipologia the tipologia
	 * @param materia the materia
	 * @param idEsame the id esame
	 */
	public Esame(int ore, String id, String descrizione, String nome, Date inizio, Date fine, int semestre,
			String tipologia, Disciplina materia, int idEsame) {
		super(ore, id, descrizione, nome, inizio, fine, semestre);
		this.tipologia = tipologia;
		//this.materia = materia;
		this.idEsame = idEsame;
	}
	
	/**
	 * Instantiates a new esame.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param tipologia the tipologia
	 * @param idEsame the id esame
	 */
	public Esame(int ore, String id, String descrizione, String nome, Date inizio, Date fine, int semestre,
			String tipologia, int idEsame) {
		super(ore, id, descrizione, nome, inizio, fine, semestre);
		this.tipologia = tipologia;
		this.idEsame = idEsame;
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
	 * Gets the tipologia.
	 *
	 * @return the tipologia
	 */
	public String getTipologia() {
		return tipologia;
	}

	/**
	 * Sets the tipologia.
	 *
	 * @param tipologia the new tipologia
	 */
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	//public Disciplina getMateria() {
		//return materia;
	//}

	//public void setMateria(Disciplina materia) {
		//this.materia = materia;
	//}

	/**
	 * Gets the id esame.
	 *
	 * @return the id esame
	 */
	public int getIdEsame() {
		return idEsame;
	}

	/**
	 * Sets the id esame.
	 *
	 * @param idEsame the new id esame
	 */
	public void setIdEsame(int idEsame) {
		this.idEsame = idEsame;
	}

}
