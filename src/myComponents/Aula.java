package myComponents;

public class Aula {
	
	private String edificio;
	private int numero;
	private int capienza;
	private String descrizione;
	
	public Aula( ) {
		this.edificio 		= "";
		this.numero 		= -1;
		this.capienza 		= -1;
		this.descrizione 	= "";
	}
	
	public Aula(String edificio, int numero, int capienza, String descrizione) {
		this.edificio 		= edificio;
		this.numero 		= numero;
		this.capienza 		= capienza;
		this.descrizione 	= descrizione;
	}
	
	public Aula(String edificio, int numero, int capienza) {
		this.edificio 		= edificio;
		this.numero 		= numero;
		this.capienza 		= capienza;
		this.descrizione 	= "";
	}
	
	@Override
	public String toString() {

		return this.edificio+this.numero;
		
	}
	
	
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getCapienza() {
		return capienza;
	}
	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
	
	
}
