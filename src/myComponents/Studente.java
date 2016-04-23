package myComponents;

import java.util.Date;

public class Studente {
	
	private String nome;
	private String cognome;
	private String matricola;
	private String email;
	private Date nascita;
	private int annoIscrizione;
	
	
	private CorsoDiStudi corso;
	
	public Studente(String nome, String cognome, String matricola, String email, 
			Date nascita, int annoIscrizione, CorsoDiStudi corso) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.email = email;
		this.nascita = nascita;
		this.annoIscrizione = annoIscrizione;
		this.corso = corso;
	}
	
	public Studente(String nome, String cognome, String matricola, String email, 
			Date date, int annoIscrizione) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.email = email;
		this.nascita = date;
		this.annoIscrizione = annoIscrizione;
		this.corso = null;
	}
	
	
	public String toString() {
        return matricola+", "+nome+", "+cognome+", "+email+", "+nascita+", "+annoIscrizione;
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
	public Date getNascita() {
		return nascita;
	}
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
	public int getAnnoIscrizione() {
		return annoIscrizione;
	}
	public void setAnnoIscrizione(int annoIscrizione) {
		this.annoIscrizione = annoIscrizione;
	}


	public CorsoDiStudi getCorso() {
		return corso;
	}


	public void setCorso(CorsoDiStudi corso) {
		this.corso = corso;
	}
	
	

}
