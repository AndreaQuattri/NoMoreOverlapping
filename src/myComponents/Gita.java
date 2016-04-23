package myComponents;

import java.util.ArrayList;
import java.util.Date;

public class Gita extends Attività {
	
	private String luogo;
	private int idGita;

	public Gita(int ore, String id, String descrizione, String nome, Date inizio, Date fine, int semestre,
			ArrayList<Docente> elencoResponsabili, String luogo, int idGita) {
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.luogo = luogo;
		this.idGita = idGita;
	}
	
	public Gita(int ore, String id, String descrizione, String nome, Date inizio, Date fine, int semestre,
			String luogo, int idGita) {
		super(ore, id, descrizione, nome, inizio, fine, semestre);
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
