package memorizzazioneDati;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import connectToDatabase.Connect;
import connectToDatabase.NumberOfRows;
import mvc.Model;
import myComponents.Aula;
import myComponents.CorsoDiStudi;
import myComponents.Docente;
import myComponents.Studente;
import urlPhp.GiveAll;

public class InsertValues {


	private Model model;

	public InsertValues(Model model) {
		this.model = model;
	}


	public void getValueAula() throws IOException, URISyntaxException{

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

	public void getValueDocente() throws IOException, URISyntaxException{

		String input = Connect.connectDb(GiveAll.giveAllDocente);
		int numDocenti = NumberOfRows.numOfRows(input);

		String splitRighe[] = input.split("_");


		for (int i=0; i<numDocenti; i++){

			String splitColonne[] = splitRighe[i].split(",");
			model.getListDocente().add(new Docente(splitColonne[1], splitColonne[2], Boolean.parseBoolean(splitColonne[5]), splitColonne[0], splitColonne[3], splitColonne[4]));

		}

	}

	public void getValueCorsoDiStudi() throws IOException, URISyntaxException{

		String input = Connect.connectDb(GiveAll.giveAllCorsoDiStudi);
		int numCorsoDiStudi = NumberOfRows.numOfRows(input);

		String splitRighe[] = input.split("_");


		for (int i=0; i<numCorsoDiStudi; i++){

			String splitColonne[] = splitRighe[i].split(",");

			model.getListCorsoDiStudi().add(new CorsoDiStudi(Short.parseShort(splitColonne[4]), splitColonne[1], splitColonne[5], splitColonne[7], splitColonne[6], splitColonne[0], splitColonne[2], Integer.parseInt(splitColonne[3])));			

		}

	}
	
	public void getValueStudente() throws IOException, URISyntaxException, ParseException{

		String input = Connect.connectDb(GiveAll.giveAllStudente);
		int numStudenti = NumberOfRows.numOfRows(input);

		String splitRighe[] = input.split("_");


		for (int i=0; i<numStudenti; i++){

			String splitColonne[] = splitRighe[i].split(",");
			
			
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date date = format.parse(splitColonne[4]);
			
			model.getListStudente().add(new Studente(splitColonne[1], splitColonne[2], splitColonne[0], splitColonne[3], date, Integer.parseInt(splitColonne[5])));

		}

	}


}
