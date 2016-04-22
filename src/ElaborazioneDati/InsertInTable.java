package ElaborazioneDati;

import java.io.IOException;
import java.net.URISyntaxException;
import connectToDatabase.Connect;
import connectToDatabase.NumberOfRows;
import urlPhp.GiveAll;

public class InsertInTable {
	
	private String selectedItem;
	
	public InsertInTable(Object selectedItem) {

		this.selectedItem = (String)selectedItem;
		
	}
	
	
	public String[][] getValues() throws IOException, URISyntaxException{
		
		if (selectedItem==null)
			return null;
		
		if (selectedItem.equals("Aula")){
			return getAula();
		}
		
		//System.out.println(selectedItem);
		
		return null;
		
	}
	
	
	

	
	private String[][] getAula() throws IOException, URISyntaxException {
	
		
		int numAule = 0;
		String input = Connect.connectDb(GiveAll.giveAllAula);
		numAule = NumberOfRows.numOfRows(input);
		
        
		String[][] values = new String[numAule+1][4];
		values[0][0] = "Edificio";
		values[0][1] = "Numero";
		values[0][2] = "Capienza";
		values[0][3] = "Descrizione";
		
		
		String splitRighe[] = input.split("_");
		
		for (int i=1; i<numAule+1; i++){
			
			String splitColonne[] = splitRighe[i-1].split(",");
			values[i][0] = splitColonne[0];
			values[i][1] = splitColonne[1];
			values[i][2] = splitColonne[2];
			if (splitColonne.length==4)
				values[i][3] = splitColonne[3];
			else
				values[i][3] = "";
			

			
		}

		return values;
		
		
	}
	

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}
	

}
