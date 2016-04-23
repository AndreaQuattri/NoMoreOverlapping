package myComponents;

import java.util.ArrayList;

public class CorsoDiStudi {

	private short anno;
	private String nomePrincipale;
	private String indirizzo;
	private String tipoLaurea;
	private String facoltà;
	private String codice;
	private String descrizione;
	private int totCrediti;

	private ArrayList<PianoDiStudi> elencoPianiPossibili;
	private ArrayList<Studente> elencoStudenti;

	public CorsoDiStudi(short anno, String nomePrincipale, String indirizzo, String tipoLaurea, 
			String facoltà, String codice, String descrizione, int totCrediti, 
			ArrayList<PianoDiStudi> elencoPianiPossibili, ArrayList<Studente> elencoStudenti) {
		this.anno = anno;
		this.nomePrincipale = nomePrincipale;
		this.indirizzo = indirizzo;
		this.tipoLaurea = tipoLaurea;
		this.facoltà = facoltà;
		this.codice = codice;
		this.descrizione = descrizione;
		this.totCrediti = totCrediti;
		this.elencoPianiPossibili = elencoPianiPossibili;
		this.elencoStudenti = elencoStudenti;
	}

	public CorsoDiStudi(short anno, String nomePrincipale, String indirizzo, String tipoLaurea, 
			String facoltà, String codice, String descrizione, int totCrediti) {
		this.anno = anno;
		this.nomePrincipale = nomePrincipale;
		this.indirizzo = indirizzo;
		this.tipoLaurea = tipoLaurea;
		this.facoltà = facoltà;
		this.codice = codice;
		this.descrizione = descrizione;
		this.totCrediti = totCrediti;
	}



	public Boolean iscriviStudente(Studente s)
	{
		// TODO da completare.
		return false;
	}

	public Boolean cancellaStudente(Studente s)
	{
		// TODO da completare.
		return false;
	}

	public Studente trovaStudente(String matricola)
	{
		// TODO da completare.
		return null;
	}

	public ArrayList<Studente> trovaStudente(String nome, String cognome)
	{
		// TODO da completSare.
		return null;
	}

	public Studente trovaStudentePerEmail(String email)
	{
		// TODO da completare.
		return null;
	}

	public int getNumIscritti()
	{
		// TODO da completare.
		return -1;
	}

	public Boolean aggiungiPianoDiStudi(PianoDiStudi m)
	{
		// TODO da completare.
		return false;
	}

	public Boolean eliminaPianoDiStudi(PianoDiStudi m)
	{
		// TODO da completare.
		return false;
	}

	public Boolean verificaPiani() { 
		//TODO crediti corretti
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	public short getAnno() {
		return anno;
	}
	public void setAnno(short anno) {
		this.anno = anno;
	}
	public String getNomePrincipale() {
		return nomePrincipale;
	}
	public void setNomePrincipale(String nomePrincipale) {
		this.nomePrincipale = nomePrincipale;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTipoLaurea() {
		return tipoLaurea;
	}
	public void setTipoLaurea(String tipoLaurea) {
		this.tipoLaurea = tipoLaurea;
	}
	public String getFacoltà() {
		return facoltà;
	}
	public void setFacoltà(String facoltà) {
		this.facoltà = facoltà;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getTotCrediti() {
		return totCrediti;
	}
	public void setTotCrediti(int totCrediti) {
		this.totCrediti = totCrediti;
	}
	public ArrayList<PianoDiStudi> getElencoPianiPossibili() {
		return elencoPianiPossibili;
	}
	public void setElencoPianiPossibili(ArrayList<PianoDiStudi> elencoPianiPossibili) {
		this.elencoPianiPossibili = elencoPianiPossibili;
	}
	public ArrayList<Studente> getElencoStudenti() {
		return elencoStudenti;
	}
	public void setElencoStudenti(ArrayList<Studente> elencoStudenti) {
		this.elencoStudenti = elencoStudenti;
	}



}
