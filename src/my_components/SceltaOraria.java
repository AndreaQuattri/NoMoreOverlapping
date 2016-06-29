/*
 * 
 */
package my_components;

// TODO: Auto-generated Javadoc
/**
 * The Class SceltaOraria.
 */
public class SceltaOraria {

	/** The scelta. */
	private FasciaOraria scelta;
	
	/** The priorità. */
	private int priorità;
	//private String giorno;
	
	
	/**
	 * Instantiates a new scelta oraria.
	 *
	 * @param scelta the scelta
	 * @param priorità the priorità
	 * @param giorno the giorno
	 */
	public SceltaOraria(FasciaOraria scelta, int priorità, String giorno) {
		this.scelta = scelta;
		this.priorità = priorità;
		//this.giorno = giorno;
	}
	
	/**
	 * Instantiates a new scelta oraria.
	 *
	 * @param scelta the scelta
	 * @param priorità the priorità
	 */
	public SceltaOraria(FasciaOraria scelta, int priorità) {
		this.scelta = scelta;
		this.priorità = priorità;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return scelta.toString() + ", " + priorità;
	}
	
	
	/**
	 * Gets the scelta.
	 *
	 * @return the scelta
	 */
	public FasciaOraria getScelta() {
		return scelta;
	}
	
	/**
	 * Sets the scelta.
	 *
	 * @param scelta the new scelta
	 */
	public void setScelta(FasciaOraria scelta) {
		this.scelta = scelta;
	}
	
	/**
	 * Gets the priorità.
	 *
	 * @return the priorità
	 */
	public int getPriorità() {
		return priorità;
	}
	
	/**
	 * Sets the priorità.
	 *
	 * @param priorità the new priorità
	 */
	public void setPriorità(int priorità) {
		this.priorità = priorità;
	}
	
	/*
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	*/
	
}
