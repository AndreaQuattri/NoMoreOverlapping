/*
 * 
 */
package my_components;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class CorsoDiStudi.
 */
public class CorsoDiStudi {

	/** The anno. */
	private int anno;
	
	/** The nome principale. */
	private String nomePrincipale;
	
	/** The indirizzo. */
	private String indirizzo;
	
	/** The tipo laurea. */
	private String tipoLaurea;
	
	/** The facoltà. */
	private String facoltà;
	
	/** The codice. */
	private String codice;
	
	/** The descrizione. */
	private String descrizione;
	
	/** The tot crediti. */
	private int totCrediti;
	
	/** The elenco studenti. */
	private ArrayList<Studente> elencoStudenti;


	//da rivedere questo campo
	//private ArrayList<PianoDiStudi> elencoPianiPossibili;
	
	/**
	 * Instantiates a new corso di studi.
	 */
	public CorsoDiStudi() {
		this.anno 			= -1;
		this.nomePrincipale = "";
		this.indirizzo 		= "";
		this.tipoLaurea 	= "";
		this.facoltà 		= "";
		this.codice 		= "";
		this.descrizione 	= "";
		this.totCrediti 	= -1;
		//this.elencoPianiPossibili = elencoPianiPossibili;
		this.elencoStudenti = new ArrayList<Studente>();
	}

	/**
	 * Instantiates a new corso di studi.
	 *
	 * @param anno the anno
	 * @param nomePrincipale the nome principale
	 * @param indirizzo the indirizzo
	 * @param tipoLaurea the tipo laurea
	 * @param facoltà the facoltà
	 * @param codice the codice
	 * @param descrizione the descrizione
	 * @param totCrediti the tot crediti
	 * @param elencoPianiPossibili the elenco piani possibili
	 * @param elencoStudenti the elenco studenti
	 */
	public CorsoDiStudi(int anno, String nomePrincipale, String indirizzo, String tipoLaurea, 
			String facoltà, String codice, String descrizione, int totCrediti, 
			ArrayList<PianoDiStudi> elencoPianiPossibili, ArrayList<Studente> elencoStudenti) {
		this.anno 			= anno;
		this.nomePrincipale = nomePrincipale;
		this.indirizzo 		= indirizzo;
		this.tipoLaurea 	= tipoLaurea;
		this.facoltà 		= facoltà;
		this.codice 		= codice;
		this.descrizione 	= descrizione;
		this.totCrediti	 	= totCrediti;
		//this.elencoPianiPossibili = elencoPianiPossibili;
		this.elencoStudenti = elencoStudenti;
	}

	/**
	 * Instantiates a new corso di studi.
	 *
	 * @param anno the anno
	 * @param nomePrincipale the nome principale
	 * @param indirizzo the indirizzo
	 * @param tipoLaurea the tipo laurea
	 * @param facoltà the facoltà
	 * @param codice the codice
	 * @param descrizione the descrizione
	 * @param totCrediti the tot crediti
	 */
	public CorsoDiStudi(int anno, String nomePrincipale, String indirizzo, String tipoLaurea, 
			String facoltà, String codice, String descrizione, int totCrediti) {
		this.anno = anno;
		this.nomePrincipale = nomePrincipale;
		this.indirizzo 		= indirizzo;
		this.tipoLaurea 	= tipoLaurea;
		this.facoltà 		= facoltà;
		this.codice 		= codice;
		this.descrizione 	= descrizione;
		this.totCrediti 	= totCrediti;
		//this.elencoPianiPossibili = new ArrayList<PianoDiStudi>();
		this.elencoStudenti = new ArrayList<Studente>();
	}



	/**
	 * Iscrivi studente.
	 *
	 * @param s the s
	 */
	public void iscriviStudente(Studente s)
	{
		this.getElencoStudenti().add(s);
	}

	/**
	 * Cancella studente.
	 *
	 * @param s the s
	 * @return the boolean
	 */
	public Boolean cancellaStudente(Studente s)
	{
		// TODO da completare.
		return false;
	}

	/**
	 * Trova studente.
	 *
	 * @param matricola the matricola
	 * @return the studente
	 */
	public Studente trovaStudente(String matricola)
	{
		// TODO da completare.
		return null;
	}

	/**
	 * Trova studente.
	 *
	 * @param nome the nome
	 * @param cognome the cognome
	 * @return the array list
	 */
	public ArrayList<Studente> trovaStudente(String nome, String cognome)
	{
		// TODO da completSare.
		return null;
	}

	/**
	 * Trova studente per email.
	 *
	 * @param email the email
	 * @return the studente
	 */
	public Studente trovaStudentePerEmail(String email)
	{
		// TODO da completare.
		return null;
	}

	/**
	 * Gets the num iscritti.
	 *
	 * @return the num iscritti
	 */
	public int getNumIscritti()
	{
		// TODO da completare.
		return -1;
	}

	/**
	 * Aggiungi piano di studi.
	 *
	 * @param m the m
	 * @return the boolean
	 */
	public Boolean aggiungiPianoDiStudi(PianoDiStudi m)
	{
		// TODO da completare.
		return false;
	}

	/**
	 * Elimina piano di studi.
	 *
	 * @param m the m
	 * @return the boolean
	 */
	public Boolean eliminaPianoDiStudi(PianoDiStudi m)
	{
		// TODO da completare.
		return false;
	}

	/**
	 * Verifica piani.
	 *
	 * @return the boolean
	 */
	public Boolean verificaPiani() { 
		//TODO crediti corretti
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String toRet = codice + ", " + nomePrincipale + ", " + anno + ", " + totCrediti + "\n";
		for (int i=0; i<this.getElencoStudenti().size(); i++){
			toRet += this.getElencoStudenti().get(i).toString();
			toRet += "\n";
		}
		
		
		return toRet;
	}


	/**
	 * Gets the anno.
	 *
	 * @return the anno
	 */
	public int getAnno() {
		return anno;
	}
	
	/**
	 * Sets the anno.
	 *
	 * @param anno the new anno
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	/**
	 * Gets the nome principale.
	 *
	 * @return the nome principale
	 */
	public String getNomePrincipale() {
		return nomePrincipale;
	}
	
	/**
	 * Sets the nome principale.
	 *
	 * @param nomePrincipale the new nome principale
	 */
	public void setNomePrincipale(String nomePrincipale) {
		this.nomePrincipale = nomePrincipale;
	}
	
	/**
	 * Gets the indirizzo.
	 *
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	
	/**
	 * Sets the indirizzo.
	 *
	 * @param indirizzo the new indirizzo
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	/**
	 * Gets the tipo laurea.
	 *
	 * @return the tipo laurea
	 */
	public String getTipoLaurea() {
		return tipoLaurea;
	}
	
	/**
	 * Sets the tipo laurea.
	 *
	 * @param tipoLaurea the new tipo laurea
	 */
	public void setTipoLaurea(String tipoLaurea) {
		this.tipoLaurea = tipoLaurea;
	}
	
	/**
	 * Gets the facoltà.
	 *
	 * @return the facoltà
	 */
	public String getFacoltà() {
		return facoltà;
	}
	
	/**
	 * Sets the facoltà.
	 *
	 * @param facoltà the new facoltà
	 */
	public void setFacoltà(String facoltà) {
		this.facoltà = facoltà;
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
	 * Gets the descrizione.
	 *
	 * @return the descrizione
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
	 * Gets the tot crediti.
	 *
	 * @return the tot crediti
	 */
	public int getTotCrediti() {
		return totCrediti;
	}
	
	/**
	 * Sets the tot crediti.
	 *
	 * @param totCrediti the new tot crediti
	 */
	public void setTotCrediti(int totCrediti) {
		this.totCrediti = totCrediti;
	}
	
	/**
	 * Gets the elenco studenti.
	 *
	 * @return the elenco studenti
	 */
	/*
	public ArrayList<PianoDiStudi> getElencoPianiPossibili() {
		return elencoPianiPossibili;
	}
	public void setElencoPianiPossibili(ArrayList<PianoDiStudi> elencoPianiPossibili) {
		this.elencoPianiPossibili = elencoPianiPossibili;
	}
	*/
	public ArrayList<Studente> getElencoStudenti() {
		return elencoStudenti;
	}
	
	/**
	 * Sets the elenco studenti.
	 *
	 * @param elencoStudenti the new elenco studenti
	 */
	public void setElencoStudenti(ArrayList<Studente> elencoStudenti) {
		this.elencoStudenti = elencoStudenti;
	}



}
