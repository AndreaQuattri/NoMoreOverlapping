/*
 * 
 */
package my_components;

// TODO: Auto-generated Javadoc
/**
 * The Class Aula.
 */
public class Aula {
	
	/** The edificio. */
	private String edificio;
	
	/** The numero. */
	private int numero;
	
	/** The capienza. */
	private int capienza;
	
	/** The descrizione. */
	private String descrizione;
	
	/**
	 * Instantiates a new aula.
	 */
	public Aula( ) {
		this.edificio 		= "";
		this.numero 		= -1;
		this.capienza 		= -1;
		this.descrizione 	= "";
	}
	
	/**
	 * Instantiates a new aula.
	 *
	 * @param edificio the edificio
	 * @param numero the numero
	 * @param capienza the capienza
	 * @param descrizione the descrizione
	 */
	public Aula(String edificio, int numero, int capienza, String descrizione) {
		this.edificio 		= edificio;
		this.numero 		= numero;
		this.capienza 		= capienza;
		this.descrizione 	= descrizione;
	}
	
	/**
	 * Instantiates a new aula.
	 *
	 * @param edificio the edificio
	 * @param numero the numero
	 * @param capienza the capienza
	 */
	public Aula(String edificio, int numero, int capienza) {
		this.edificio 		= edificio;
		this.numero 		= numero;
		this.capienza 		= capienza;
		this.descrizione 	= "";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return this.edificio+this.numero;
		
	}
	
	
	/**
	 * Gets the edificio.
	 *
	 * @return the edificio
	 */
	public String getEdificio() {
		return edificio;
	}
	
	/**
	 * Sets the edificio.
	 *
	 * @param edificio the new edificio
	 */
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	
	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	
	/**
	 * Sets the numero.
	 *
	 * @param numero the new numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/**
	 * Gets the capienza.
	 *
	 * @return the capienza
	 */
	public int getCapienza() {
		return capienza;
	}
	
	/**
	 * Sets the capienza.
	 *
	 * @param capienza the new capienza
	 */
	public void setCapienza(int capienza) {
		this.capienza = capienza;
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

	
	
	
}
