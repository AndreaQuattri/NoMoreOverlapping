package provaPermutazione;

public class Fattoriale {
	
	
	
	public static int fattoriale(int x){
		int i;
	    int f=1;

	    for(i=1; i<=x; i=i+1) {
	      f=f*i;
	    }

	    return f;
	}

}
