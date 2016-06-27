/*
 * 
 */
package connectToDatabase;

// TODO: Auto-generated Javadoc
/**
 * The Class NumberOfRows.
 */
public class NumberOfRows {
	
	
	/**
	 * Num of rows.
	 *
	 * @param input the input
	 * @return the int
	 */
	public static int numOfRows (String input){
		
		int toReturn = 0;
		
		for (int i=0; i<input.length(); i++){
			if (input.charAt(i)=='_')
				toReturn++;
		}
		
		return toReturn;
	}

}
