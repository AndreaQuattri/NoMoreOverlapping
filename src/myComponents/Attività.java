package myComponents;

import java.util.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


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

	private int ore;
	private String id;
	private String descrizione;
	private String nome;
	private Date inizio;
	private Date fine;
	private int semestre;

	private ArrayList<Docente> elencoResponsabili;

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
	 * Questo metodo restituisce il numero di ore di questa Attivita'
	 * @return Numero ore Attivita'
	 * 
	 */
	public int getOre() {
		return ore;
	}
	
	/**
	 * 
	 * @param ore
	 */
	public void setOre(int ore) {
		this.ore = ore;
	}
	
	/**
	 * Questo metodo restituisce l'id che identifica univocamente l'oggetto Attivita'
	 * @return id di Attivita'
	 * 
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Questo metodo restituisce la descrizione della Attivita'
	 * @return La descrizione della Attivita'
	 * 
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * Questo metodo restituisce il nome della Attivita'
	 * @return Il nome della Attivita'
	 * 
	 */	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Questo metodo restituisce la data di inizio della Attivita'
	 * @return La dataInizio della Attivita'
	 * 
	 */
	public Date getInizio() {
		return inizio;
	}
	public void setInizio(Date inizio) {
		this.inizio = inizio;
	}
	
	/**
	 * Questo metodo restituisce la data di fine della Attivita'
	 * @return La dataFine della Attivita'
	 * 
	 */
	public Date getFine() {
		return fine;
	}
	public void setFine(Date fine) {
		this.fine = fine;
	}
	
	/**
	 * Questo metodo restituisce il semestre in cui è presente questa Attivita'
	 * @return Il semestre della Attivita'
	 * 
	 */
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public void setInizioByString(String i) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.inizio = format.parse(i);
	}
	
	public void setFineByString(String f) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.inizio = format.parse(f);
	}
	


	public ArrayList<Docente> getElencoResponsabili() {
		return elencoResponsabili;
	}




	public void setElencoResponsabili(ArrayList<Docente> elencoResponsabili) {
		this.elencoResponsabili = elencoResponsabili;
	}

	public void aggiungiResponsabile (Docente d){
		this.elencoResponsabili.add(d);
	}

	@Override
	public int compareTo(Attività o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.id);
	}


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


}
