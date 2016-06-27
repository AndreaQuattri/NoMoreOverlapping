/*
 * 
 */
package myComponents;

// TODO: Auto-generated Javadoc
/**
 * The Class Assegnamento.
 */
public class Assegnamento {

	/** The attività. */
	private Attività attività;
	
	/** The fascia oraria. */
	private FasciaOraria fasciaOraria;
	
	/** The aula. */
	private Aula aula;
	//private String day;
	
	/**
	 * Instantiates a new assegnamento.
	 */
	public Assegnamento( ) {
		this.attività 		= new Attività();
		this.fasciaOraria 	= new FasciaOraria();
		this.aula 			= new Aula();
	}

	/**
	 * Instantiates a new assegnamento.
	 *
	 * @param attività the attività
	 * @param fasciaOraria the fascia oraria
	 * @param aula the aula
	 */
	public Assegnamento(Attività attività, FasciaOraria fasciaOraria, Aula aula) {
		this.attività 		= attività;
		this.fasciaOraria 	= fasciaOraria;
		this.aula 			= aula;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String toRet = attività.toString() + fasciaOraria.toString() + aula.toString();
		return toRet;
	}


	/**
	 * Gets the attività.
	 *
	 * @return the attività
	 */
	public Attività getAttività() {
		return attività;
	}
	
	/**
	 * Sets the attività.
	 *
	 * @param attività the new attività
	 */
	public void setAttività(Attività attività) {
		this.attività = attività;
	}
	
	/**
	 * Gets the fascia oraria.
	 *
	 * @return the fascia oraria
	 */
	public FasciaOraria getFasciaOraria() {
		return fasciaOraria;
	}
	
	/**
	 * Sets the fascia oraria.
	 *
	 * @param fasciaOraria the new fascia oraria
	 */
	public void setFasciaOraria(FasciaOraria fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}
	
	/**
	 * Gets the aula.
	 *
	 * @return the aula
	 */
	public Aula getAula() {
		return aula;
	}
	
	/**
	 * Sets the aula.
	 *
	 * @param aula the new aula
	 */
	public void setAula(Aula aula) {
		this.aula = aula;
	}

	/*
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	 */

}
