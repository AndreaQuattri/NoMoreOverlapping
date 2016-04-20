package myComponents;

import java.text.DateFormat;
import java.util.ArrayList;

public class Gita extends Attività {
	
	private String luogo;
	private int idGita;

	public Gita(int ore, String id, String descrizione, String nome, DateFormat inizio, DateFormat fine, int semestre,
			ArrayList<Docente> elencoResponsabili, String luogo, int idGita) {
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.luogo = luogo;
		this.idGita = idGita;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public int getIdGita() {
		return idGita;
	}

	public void setIdGita(int idGita) {
		this.idGita = idGita;
	}

}
