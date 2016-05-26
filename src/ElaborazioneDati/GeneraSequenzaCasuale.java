package ElaborazioneDati;



public class GeneraSequenzaCasuale {

	int dimensione;

	public GeneraSequenzaCasuale(int dimensione) {
		this.dimensione = dimensione;
	}


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
