package connectToDatabase;

public class NumberOfRows {
	
	
	public static int numOfRows (String input){
		
		int toReturn = 0;
		
		for (int i=0; i<input.length(); i++){
			if (input.charAt(i)=='_')
				toReturn++;
		}
		
		return toReturn;
	}

}
