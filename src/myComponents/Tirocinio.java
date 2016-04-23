package myComponents;

import java.util.ArrayList;
import java.util.Date;

public class Tirocinio extends Attività {

	private String azienda;
	private String emailAzienda;
	private String descrizioneAzienda;
	private int idTirocinio;
	
	public Tirocinio(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, ArrayList<Docente> elencoResponsabili, String azienda, String emailAzienda, String descrizioneAzienda, int idTirocinio) {
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.azienda = azienda;
		this.emailAzienda = emailAzienda;
		this.descrizioneAzienda = descrizioneAzienda;
		this.idTirocinio = idTirocinio;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}

	public String getEmailAzienda() {
		return emailAzienda;
	}

	public void setEmailAzienda(String emailAzienda) {
		this.emailAzienda = emailAzienda;
	}

	public String getDescrizioneAzienda() {
		return descrizioneAzienda;
	}

	public void setDescrizioneAzienda(String descrizioneAzienda) {
		this.descrizioneAzienda = descrizioneAzienda;
	}

	public int getIdTirocinio() {
		return idTirocinio;
	}

	public void setIdTirocinio(int idTirocinio) {
		this.idTirocinio = idTirocinio;
	}

}
