/*
 * 
 */
package my_components;

// TODO: Auto-generated Javadoc
/**
 * The Class SceltaAula.
 */
public class SceltaAula {
	
	/** The scelta. */
	private Aula scelta;
	
	/** The priorità. */
	private int priorità;
	
	/**
	 * Instantiates a new scelta aula.
	 *
	 * @param scelta the scelta
	 * @param priorità the priorità
	 */
	public SceltaAula(Aula scelta, int priorità) {
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
	public Aula getScelta() {
		return scelta;
	}
	
	/**
	 * Sets the scelta.
	 *
	 * @param scelta the new scelta
	 */
	public void setScelta(Aula scelta) {
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
	
	

}
