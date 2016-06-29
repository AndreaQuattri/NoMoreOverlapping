/*
 * 
 */
package elaborazione_dati;



// TODO: Auto-generated Javadoc
/**
 * The Class GeneraSequenzaCasuale.
 */
public class GeneraSequenzaCasuale {

	/** The dimensione. */
	int dimensione;

	/**
	 * Instantiates a new genera sequenza casuale.
	 *
	 * @param dimensione the dimensione
	 */
	public GeneraSequenzaCasuale(int dimensione) {
		this.dimensione = dimensione;
	}


	/**
	 * Genera sequenza.
	 *
	 * @return the int[]
	 */
	public int[] generaSequenza (){


		int[] vect = new int[dimensione];
		int indice = 0, posInsert = 0;

		for (; indice<vect.length; indice++)
			vect[indice] = -1;

		int numRandom;


		for (; posInsert<dimensione; posInsert++){
			
			do{
			numRandom = (int) (Math.random()*dimensione);
			indice = 0;

			while(indice!=dimensione &&vect[indice]!= numRandom ){
				indice++;
			}
			
			}while(indice!=dimensione);
				vect[posInsert] = numRandom;

		}

		return vect;

	}




}
