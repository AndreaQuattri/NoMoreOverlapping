/*
 * 
 */
package my_components;

import java.util.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * 
 * La classe Attivita' gestisce i dati di una generica attivita'.
 * Contiene i metodi set e get e metodi costruttori
 * 
 * @author andreaquattri
 * 
 *
 */

public class Attività implements Comparable<Attività>{

	/** The ore. */
	private int ore;
	
	/** The id. */
	private String id;
	
	/** The descrizione. */
	private String descrizione;
	
	/** The nome. */
	private String nome;
	
	/** The inizio. */
	private Date inizio;
	
	/** The fine. */
	private Date fine;
	
	/** The semestre. */
	private int semestre;

	/** The elenco responsabili. */
	private ArrayList<Docente> elencoResponsabili;

	/**
	 * Instantiates a new attività.
	 */
	public Attività( ) {
		this.ore				= -1;
		this.id					= "";
		this.descrizione	 	= "";
		this.nome 				= "";
		this.inizio 			= new Date();
		this.fine 				= new Date();
		this.semestre 			= -1;
		this.elencoResponsabili = new ArrayList<Docente>();
	}
	
	/**
	 * Instantiates a new attività.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 * @param elencoResponsabili the elenco responsabili
	 */
	public Attività(int ore, String id, String descrizione, String nome, Date inizio, Date fine, int semestre, ArrayList<Docente> elencoResponsabili) {
		this.ore 				= ore;
		this.id 				= id;
		this.descrizione		= descrizione;
		this.nome 				= nome;
		this.inizio 			= inizio;
		this.fine 				= fine;
		this.semestre 			= semestre;
		this.elencoResponsabili = elencoResponsabili;
	}

	/**
	 * Instantiates a new attività.
	 *
	 * @param ore the ore
	 * @param id the id
	 * @param descrizione the descrizione
	 * @param nome the nome
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param semestre the semestre
	 */
	public Attività(int ore, String id, String descrizione, String nome, Date inizio, Date fine, int semestre) {
		this.ore 				= ore;
		this.id 				= id;
		this.descrizione		= descrizione;
		this.nome 				= nome;
		this.inizio 			= inizio;
		this.fine 				= fine;
		this.semestre 			= semestre;
		this.elencoResponsabili = new ArrayList<Docente>();
	}

	/**
	 * Instantiates a new attività.
	 *
	 * @param idAtt the id att
	 * @param descrizione the descrizione
	 * @param nome the nome
	 */
	public Attività(String idAtt, String descrizione, String nome) {
		this.ore				= -1;
		this.id					= idAtt;
		this.descrizione	 	= descrizione;
		this.nome 				= nome;
		this.inizio 			= new Date();
		this.fine 				= new Date();
		this.semestre 			= -1;
		this.elencoResponsabili = new ArrayList<Docente>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		Format formatter = new SimpleDateFormat("yyyy-mm-dd");
		String dateInizio = formatter.format(inizio);
		String dateFine = formatter.format(fine);

		String toReturn = id + "," + nome + "," + descrizione + "," + ore + "," + semestre + "," + dateInizio + "," + dateFine;
		for (int i = 0; i < elencoResponsabili.size(); i++)
			toReturn += elencoResponsabili.get(i).getCognome().toString() + " ; ";
		return toReturn;
	}


	/**
	 * Questo metodo restituisce il numero di ore di questa Attivita'.
	 *
	 * @return Numero ore Attivita'
	 */
	public int getOre() {
		return ore;
	}
	
	/**
	 * Sets the ore.
	 *
	 * @param ore the new ore
	 */
	public void setOre(int ore) {
		this.ore = ore;
	}
	
	/**
	 * Questo metodo restituisce l'id che identifica univocamente l'oggetto Attivita'.
	 *
	 * @return id di Attivita'
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Questo metodo restituisce la descrizione della Attivita'.
	 *
	 * @return La descrizione della Attivita'
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Sets the descrizione.
	 *
	 * @param descrizione the new descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * Questo metodo restituisce il nome della Attivita'.
	 *
	 * @return Il nome della Attivita'
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
	 * Questo metodo restituisce la data di inizio della Attivita'.
	 *
	 * @return La dataInizio della Attivita'
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
	 * Questo metodo restituisce la data di fine della Attivita'.
	 *
	 * @return La dataFine della Attivita'
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
	 * Questo metodo restituisce il semestre in cui è presente questa Attivita'.
	 *
	 * @return Il semestre della Attivita'
	 */
	public int getSemestre() {
		return semestre;
	}
	
	/**
	 * Sets the semestre.
	 *
	 * @param semestre the new semestre
	 */
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	/**
	 * Sets the inizio by string.
	 *
	 * @param i the new inizio by string
	 * @throws ParseException the parse exception
	 */
	public void setInizioByString(String i) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.inizio = format.parse(i);
	}
	
	/**
	 * Sets the fine by string.
	 *
	 * @param f the new fine by string
	 * @throws ParseException the parse exception
	 */
	public void setFineByString(String f) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.inizio = format.parse(f);
	}
	


	/**
	 * Gets the elenco responsabili.
	 *
	 * @return the elenco responsabili
	 */
	public ArrayList<Docente> getElencoResponsabili() {
		return elencoResponsabili;
	}




	/**
	 * Sets the elenco responsabili.
	 *
	 * @param elencoResponsabili the new elenco responsabili
	 */
	public void setElencoResponsabili(ArrayList<Docente> elencoResponsabili) {
		this.elencoResponsabili = elencoResponsabili;
	}

	/**
	 * Aggiungi responsabile.
	 *
	 * @param d the d
	 */
	public void aggiungiResponsabile (Docente d){
		this.elencoResponsabili.add(d);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Attività o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.id);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Attività)) {
			return false; 
		} 

		Attività a = (Attività) obj;
		return a.id.equals(this.id);
	}

	public boolean equalsAtt(Attività a) {
		
		return a.id.equals(this.id);
	}

}
