/*
 * 
 */
package my_components;

import java.text.DateFormat;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Orario.
 */
public class Orario {

	/** The sovrapposizioni. */
	private int sovrapposizioni;
	
	/** The integr sovrap. */
	private boolean integrSovrap;

	/** The elenco assegnamenti. */
	private ArrayList<Assegnamento> elencoAssegnamenti;
	
	/** The elenco attività. */
	private ArrayList<Attività> elencoAttività;
	
	/** The elenco corsi. */
	private ArrayList<CorsoDiStudi> elencoCorsi;

	/**
	 * Instantiates a new orario.
	 */
	public Orario() {
		elencoAssegnamenti	= new ArrayList<Assegnamento>();
		elencoAttività 		= new ArrayList<Attività>();
		elencoCorsi 		= new ArrayList<CorsoDiStudi>();
		sovrapposizioni 	= -1;
		integrSovrap 		= false;
	}
	
	
	/**
	 * Instantiates a new orario.
	 *
	 * @param elencoAssegnamenti the elenco assegnamenti
	 * @param elencoAttività the elenco attività
	 * @param elencoCorsi the elenco corsi
	 */
	public Orario(ArrayList<Assegnamento> elencoAssegnamenti, ArrayList<Attività> elencoAttività, ArrayList<CorsoDiStudi> elencoCorsi) {
		this.elencoAssegnamenti	= elencoAssegnamenti;
		this.elencoAttività 	= elencoAttività;
		this.elencoCorsi 		= elencoCorsi;
		sovrapposizioni 		= -1;
		integrSovrap 			= false;
	}

	/**
	 * Instantiates a new orario.
	 *
	 * @param elencoAssegnamenti the elenco assegnamenti
	 */
	public Orario(ArrayList<Assegnamento> elencoAssegnamenti) {
		this.elencoAssegnamenti = elencoAssegnamenti;
		elencoAttività 			= new ArrayList<Attività>();
		elencoCorsi 			= new ArrayList<CorsoDiStudi>();
		sovrapposizioni 		= -1;
		integrSovrap 			= false;
	}

	
	/**
	 * Trova sovrapposizioni.
	 *
	 * @return the int
	 */
	public int trovaSovrapposizioni()
	{
		// TODO da completare.
		return 0;
	}

	/**
	 * Aggiungi attività.
	 *
	 * @param a the a
	 * @return the boolean
	 */
	public Boolean aggiungiAttività(Attività a)
	{
		// TODO da completare.
		return false;
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
	 */
	public void cancellaTutteAttività()
	{
		// TODO da completare.
	}

	/**
	 * Aggiungi assegnamento.
	 *
	 * @param a the a
	 * @return the boolean
	 */
	public Boolean aggiungiAssegnamento(Assegnamento a)
	{
		// TODO da completare.
		this.elencoAssegnamenti.add(a);
		return false;
	}

	/**
	 * Aggiungi assegnamento.
	 *
	 * @param att the att
	 * @param o the o
	 * @param au the au
	 * @param d the d
	 * @return the boolean
	 */
	public Boolean aggiungiAssegnamento(Attività att, float o, Aula au, DateFormat d)
	{
		// TODO da completare.
		return false;
	}

	/**
	 * Aggiungi assegnamento.
	 *
	 * @param att the att
	 * @param o the o
	 * @param au the au
	 * @param inizio the inizio
	 * @param fine the fine
	 * @param d the d
	 * @return the boolean
	 */
	public Boolean aggiungiAssegnamento(Attività att, float o, Aula au, DateFormat inizio, DateFormat fine, String d)
	{
		// TODO da completare.
		return false;
	}

	/**
	 * Cancella assegnamento.
	 *
	 * @param a the a
	 * @return the boolean
	 */
	public Boolean cancellaAssegnamento(Assegnamento a)
	{
		// TODO da completare.
		return false;
	}

	/**
	 * Cancella tutti assegnamenti.
	 */
	public void cancellaTuttiAssegnamenti()
	{
		// TODO da completare.
	}

	/**
	 * Checks if is completo.
	 *
	 * @return the boolean
	 */
	public Boolean isCompleto()
	{
		// TODO da completare.
		return false;
	}

	/**
	 * Ottieni non assegnati.
	 *
	 * @return the array list
	 */
	public ArrayList<Attività> ottieniNonAssegnati()
	{
		// TODO da completare.
		return null;
	}

	/**
	 * Ottieni programma.
	 *
	 * @param day the day
	 * @return the array list
	 */
	public ArrayList<Assegnamento> ottieniProgramma(String day)
	{
		// TODO da completare.
		return null;
	}







	/**
	 * Gets the sovrapposizioni.
	 *
	 * @return the sovrapposizioni
	 */
	public int getSovrapposizioni() {
		return sovrapposizioni;
	}
	
	/**
	 * Sets the sovrapposizioni.
	 *
	 * @param sovrapposizioni the new sovrapposizioni
	 */
	public void setSovrapposizioni(int sovrapposizioni) {
		this.sovrapposizioni = sovrapposizioni;
	}
	
	/**
	 * Checks if is integr sovrap.
	 *
	 * @return true, if is integr sovrap
	 */
	public boolean isIntegrSovrap() {
		return integrSovrap;
	}
	
	/**
	 * Sets the integr sovrap.
	 *
	 * @param integrSovrap the new integr sovrap
	 */
	public void setIntegrSovrap(boolean integrSovrap) {
		this.integrSovrap = integrSovrap;
	}
	
	/**
	 * Gets the elenco assegnamenti.
	 *
	 * @return the elenco assegnamenti
	 */
	public ArrayList<Assegnamento> getElencoAssegnamenti() {
		return elencoAssegnamenti;
	}
	
	/**
	 * Sets the elenco assegnamenti.
	 *
	 * @param elencoAssegnamenti the new elenco assegnamenti
	 */
	public void setElencoAssegnamenti(ArrayList<Assegnamento> elencoAssegnamenti) {
		this.elencoAssegnamenti = elencoAssegnamenti;
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
	 * Gets the elenco corsi.
	 *
	 * @return the elenco corsi
	 */
	public ArrayList<CorsoDiStudi> getElencoCorsi() {
		return elencoCorsi;
	}
	
	/**
	 * Sets the elenco corsi.
	 *
	 * @param elencoCorsi the new elenco corsi
	 */
	public void setElencoCorsi(ArrayList<CorsoDiStudi> elencoCorsi) {
		this.elencoCorsi = elencoCorsi;
	}

}
