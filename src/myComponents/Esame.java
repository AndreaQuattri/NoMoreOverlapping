package myComponents;

import java.text.DateFormat;
import java.util.ArrayList;

public class Esame extends Attività {
	
	private String tipologia;
	private Disciplina materia;
	private int idEsame;

	public Esame(int ore, String id, String descrizione, String nome, DateFormat inizio, DateFormat fine, int semestre,
			ArrayList<Docente> elencoResponsabili, String tipologia, Disciplina materia, int idEsame) {
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.tipologia = tipologia;
		this.materia = materia;
		this.idEsame = idEsame;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Disciplina getMateria() {
		return materia;
	}

	public void setMateria(Disciplina materia) {
		this.materia = materia;
	}

	public int getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(int idEsame) {
		this.idEsame = idEsame;
	}

}
