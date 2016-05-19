package myComponents;

import java.util.ArrayList;

public class Docente {

	private String nome;
	private String cognome;
	private boolean associato;
	private String matricola;
	private String email;
	private String qualifica;

	private ArrayList<Attivitą> elencoAttivitą;
	private ArrayList<SceltaOraria> orariPreferiti;
	private ArrayList<SceltaAula> aulePreferite;

	public Docente(String nome, String cognome, boolean associato, String matricola,
			String email, String qualifica, ArrayList<Attivitą> elencoAttivitą,
			ArrayList<SceltaOraria> orariPreferiti, ArrayList<SceltaAula> aulePreferite) {
		this.nome = nome;
		this.cognome = cognome;
		this.associato = associato;
		this.matricola = matricola;
		this.email = email;
		this.qualifica = qualifica;
		this.elencoAttivitą = elencoAttivitą;
		this.orariPreferiti = orariPreferiti;
		this.aulePreferite = aulePreferite;
	}

	public Docente(String nome, String cognome, boolean associato, String matricola,
			String email, String qualifica) {
		this.nome = nome;
		this.cognome = cognome;
		this.associato = associato;
		this.matricola = matricola;
		this.email = email;
		this.qualifica = qualifica;
		this.elencoAttivitą = new ArrayList<Attivitą>();
		this.orariPreferiti = new ArrayList<SceltaOraria>();
		this.aulePreferite = new ArrayList<SceltaAula>();
		
	}

	@Override
	public String toString() {
		
		String toRet = this.matricola+", "+this.nome+", "+this.cognome+", "+this.email+", "+this.qualifica+", "+this.associato+ "\n\n";
			for (int i=0; i<elencoAttivitą.size(); i++){
				toRet += elencoAttivitą.get(i).toString();
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


	public void aggiungiAttivitą(Attivitą a)
	{
		elencoAttivitą.add(a);
	}

	public Boolean cancellaAttivitą(Attivitą a)
	{
		// TODO da completare.
		return false;
	}

	public void cancellaTutteAttivitą(Attivitą a)
	{
		// TODO da completare.
	}

	public void aggiungiPreferenza(SceltaOraria so)
	{
		orariPreferiti.add(so);
	}

	public void aggiungiPreferenza(SceltaAula sa)
	{
		aulePreferite.add(sa);
	}

	public Boolean cancellaPreferenza(SceltaOraria so)
	{
		// TODO da completare.
		return false;
	}

	public Boolean cancellaPreferenza(SceltaAula sa)
	{
		// TODO da completare.
		return false;
	}

	public void cancellaAulePreferite()
	{
		// TODO da completare.
	}

	public void cancellaOrePreferite()
	{
		// TODO da completare.
	}




	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public boolean isAssociato() {
		return associato;
	}

	public void setAssociato(boolean associato) {
		this.associato = associato;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualifica() {
		return qualifica;
	}

	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}

	public ArrayList<Attivitą> getElencoAttivitą() {
		return elencoAttivitą;
	}

	public void setElencoAttivitą(ArrayList<Attivitą> elencoAttivitą) {
		this.elencoAttivitą = elencoAttivitą;
	}

	public ArrayList<SceltaOraria> getOrariPreferit() {
		return orariPreferiti;
	}

	public void setOrariPreferit(ArrayList<SceltaOraria> orariPreferiti) {
		this.orariPreferiti = orariPreferiti;
	}

	public ArrayList<SceltaAula> getAulePreferite() {
		return aulePreferite;
	}

	public void setAulePreferite(ArrayList<SceltaAula> aulePreferite) {
		this.aulePreferite = aulePreferite;
	}

}
