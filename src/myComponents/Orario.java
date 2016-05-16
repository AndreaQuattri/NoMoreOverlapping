package myComponents;

import java.text.DateFormat;
import java.util.ArrayList;

public class Orario {

	private int sovrapposizioni;
	private boolean integrSovrap;

	private ArrayList<Assegnamento> elencoAssegnamenti;
	private ArrayList<Attività> elencoAttività;

	public Orario(int sovrapposizioni, boolean integrSovrap, ArrayList<Assegnamento> elencoAssegnamenti,
			ArrayList<Attività> elencoAttività) {
		this.sovrapposizioni = sovrapposizioni;
		this.integrSovrap = integrSovrap;
		this.elencoAssegnamenti = elencoAssegnamenti;
		this.elencoAttività = elencoAttività;
	}

	public Orario(ArrayList<Assegnamento> elencoAssegnamenti) {
		this.elencoAssegnamenti = elencoAssegnamenti;
	}



	public Orario(ArrayList<Assegnamento> elencoAssegnamenti, ArrayList<Attività> elencoAttività) {
		this.elencoAssegnamenti = elencoAssegnamenti;
		this.elencoAttività = elencoAttività;
	}

	
	public int trovaSovrapposizioni()
	{
		// TODO da completare.
		return 0;
	}

	public Boolean aggiungiAttività(Attività a)
	{
		// TODO da completare.
		return false;
	}

	public Boolean cancellaAttività(Attività a)
	{
		// TODO da completare.
		return false;
	}

	public void cancellaTutteAttività()
	{
		// TODO da completare.
	}

	public Boolean aggiungiAssegnamento(Assegnamento a)
	{
		// TODO da completare.
		this.elencoAssegnamenti.add(a);
		return false;
	}

	public Boolean aggiungiAssegnamento(Attività att, float o, Aula au, DateFormat d)
	{
		// TODO da completare.
		return false;
	}

	public Boolean aggiungiAssegnamento(Attività att, float o, Aula au, DateFormat inizio, DateFormat fine, String d)
	{
		// TODO da completare.
		return false;
	}

	public Boolean cancellaAssegnamento(Assegnamento a)
	{
		// TODO da completare.
		return false;
	}

	public void cancellaTuttiAssegnamenti()
	{
		// TODO da completare.
	}

	public Boolean isCompleto()
	{
		// TODO da completare.
		return false;
	}

	public ArrayList<Attività> ottieniNonAssegnati()
	{
		// TODO da completare.
		return null;
	}

	public ArrayList<Assegnamento> ottieniProgramma(String day)
	{
		// TODO da completare.
		return null;
	}







	public int getSovrapposizioni() {
		return sovrapposizioni;
	}
	public void setSovrapposizioni(int sovrapposizioni) {
		this.sovrapposizioni = sovrapposizioni;
	}
	public boolean isIntegrSovrap() {
		return integrSovrap;
	}
	public void setIntegrSovrap(boolean integrSovrap) {
		this.integrSovrap = integrSovrap;
	}
	public ArrayList<Assegnamento> getElencoAssegnamenti() {
		return elencoAssegnamenti;
	}
	public void setElencoAssegnamenti(ArrayList<Assegnamento> elencoAssegnamenti) {
		this.elencoAssegnamenti = elencoAssegnamenti;
	}
	public ArrayList<Attività> getElencoAttività() {
		return elencoAttività;
	}
	public void setElencoAttività(ArrayList<Attività> elencoAttività) {
		this.elencoAttività = elencoAttività;
	}



}
