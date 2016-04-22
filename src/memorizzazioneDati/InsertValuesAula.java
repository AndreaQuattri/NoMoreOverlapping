package memorizzazioneDati;

import java.io.IOException;
import java.net.URISyntaxException;

import connectToDatabase.Connect;
import connectToDatabase.NumberOfRows;
import mvc.Model;
import myComponents.Aula;
import urlPhp.GiveAll;

public class InsertValuesAula {

	
	private Model model;
	
	public InsertValuesAula(Model model) {
		this.model = model;
	}
	
	
	public void getValue() throws IOException, URISyntaxException{
		
		String input = Connect.connectDb(GiveAll.giveAllAula);
		int numAule = NumberOfRows.numOfRows(input);
		
		String splitRighe[] = input.split("_");

		
		for (int i=0; i<numAule; i++){
			
			String splitColonne[] = splitRighe[i].split(",");
			if(splitColonne.length==4)
				model.getListAula().add(new Aula(splitColonne[0], Integer.parseInt(splitColonne[1]), Integer.parseInt(splitColonne[2]), splitColonne[3]));
			else
				model.getListAula().add(new Aula(splitColonne[0], Integer.parseInt(splitColonne[1]), Integer.parseInt(splitColonne[2])));

		}
		
		

	}
	
	
}
