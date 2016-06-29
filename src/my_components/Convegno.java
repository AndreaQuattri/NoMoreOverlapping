/*
 * 
 */
package my_components;

import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Convegno.
 */
public class Convegno extends Attività {
	
	/** The relatore nome. */
	private String relatoreNome;
	
	/** The relatore cognome. */
	private String relatoreCognome;
	
	/** The relatore email. */
	private String relatoreEmail;
	
	/** The relatore qualifica. */
	private String relatoreQualifica;
	
	/** The id convegno. */
	private int idConvegno;

	/**
	 * Instantiates a new convegno.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param elencoResponsabili the elenco responsabili
	 * @param relatoreNome the relatore nome
	 * @param relatoreCognome the relatore cognome
	 * @param relatoreEmail the relatore email
	 * @param relatoreQualifica the relatore qualifica
	 * @param idConvegno the id convegno
	 */
	public Convegno(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, ArrayList<Docente> elencoResponsabili, String relatoreNome, String relatoreCognome, String relatoreEmail, String relatoreQualifica, int idConvegno) {
		
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.relatoreNome = relatoreNome;
		this.relatoreCognome = relatoreCognome;
		this.relatoreEmail = relatoreEmail;
		this.relatoreQualifica = relatoreQualifica;
		this.idConvegno = idConvegno;
	}
	
	/**
	 * Instantiates a new convegno.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param relatoreNome the relatore nome
	 * @param relatoreCognome the relatore cognome
	 * @param relatoreEmail the relatore email
	 * @param relatoreQualifica the relatore qualifica
	 * @param idConvegno the id convegno
	 */
	public Convegno(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, String relatoreNome, String relatoreCognome, String relatoreEmail, String relatoreQualifica, int idConvegno) {
		
		super(ore, id, descrizione, nome, inizio, fine, semestre);
		this.relatoreNome = relatoreNome;
		this.relatoreCognome = relatoreCognome;
		this.relatoreEmail = relatoreEmail;
		this.relatoreQualifica = relatoreQualifica;
		this.idConvegno = idConvegno;
	}
	
	/* (non-Javadoc)
	 * @see my_components.Attività#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	

	/**
	 * Gets the relatore nome.
	 *
	 * @return the relatore nome
	 */
	public String getRelatoreNome() {
		return relatoreNome;
	}

	/**
	 * Sets the relatore nome.
	 *
	 * @param relatoreNome the new relatore nome
	 */
	public void setRelatoreNome(String relatoreNome) {
		this.relatoreNome = relatoreNome;
	}

	/**
	 * Gets the relatore cognome.
	 *
	 * @return the relatore cognome
	 */
	public String getRelatoreCognome() {
		return relatoreCognome;
	}

	/**
	 * Sets the relatore cognome.
	 *
	 * @param relatoreCognome the new relatore cognome
	 */
	public void setRelatoreCognome(String relatoreCognome) {
		this.relatoreCognome = relatoreCognome;
	}

	/**
	 * Gets the relatore email.
	 *
	 * @return the relatore email
	 */
	public String getRelatoreEmail() {
		return relatoreEmail;
	}

	/**
	 * Sets the relatore email.
	 *
	 * @param relatoreEmail the new relatore email
	 */
	public void setRelatoreEmail(String relatoreEmail) {
		this.relatoreEmail = relatoreEmail;
	}

	/**
	 * Gets the relatore qualifica.
	 *
	 * @return the relatore qualifica
	 */
	public String getRelatoreQualifica() {
		return relatoreQualifica;
	}

	/**
	 * Sets the relatore qualifica.
	 *
	 * @param relatoreQualifica the new relatore qualifica
	 */
	public void setRelatoreQualifica(String relatoreQualifica) {
		this.relatoreQualifica = relatoreQualifica;
	}

	/**
	 * Gets the id convegno.
	 *
	 * @return the id convegno
	 */
	public int getIdConvegno() {
		return idConvegno;
	}

	/**
	 * Sets the id convegno.
	 *
	 * @param idConvegno the new id convegno
	 */
	public void setIdConvegno(int idConvegno) {
		this.idConvegno = idConvegno;
	}

	
	
}
