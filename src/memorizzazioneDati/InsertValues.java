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
import myComponents.Convegno;
import myComponents.CorsoDiStudi;
import myComponents.Disciplina;
import myComponents.Docente;
import myComponents.Esame;
import myComponents.FasciaOraria;
import myComponents.Gita;
import myComponents.Studente;
import myComponents.Tirocinio;
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

	public void getValueFasciaOraria() throws IOException, URISyntaxException, ParseException{

		String input = Connect.connectDb(GiveAll.giveAllFasciaOraria);
		int numFasciaOraria = NumberOfRows.numOfRows(input);

		String splitRighe[] = input.split("_");


		for (int i=0; i<numFasciaOraria; i++){

			String splitColonne[] = splitRighe[i].split(",");


			DateFormat format = new SimpleDateFormat("hh:mm:ss");
			Date dateInizio = format.parse(splitColonne[2]);
			Date dateFine = format.parse(splitColonne[3]);

			model.getListFasciaOraria().add(new FasciaOraria(dateInizio, dateFine, splitColonne[1], Integer.parseInt(splitColonne[0])));
		}

	}

	public void getValueAttività() throws IOException, URISyntaxException, ParseException{

		String inputAttività = Connect.connectDb(GiveAll.giveAllAttività);
		int numAttività = NumberOfRows.numOfRows(inputAttività);

		String inputTirocinio = Connect.connectDb(GiveAll.giveAllTirocinio);
		int numTirocini = NumberOfRows.numOfRows(inputTirocinio);

		String inputConvegno = Connect.connectDb(GiveAll.giveAllConvegno);
		int numConvegni = NumberOfRows.numOfRows(inputConvegno);

		String inputDisciplina = Connect.connectDb(GiveAll.giveAllDisciplina);
		int numDiscipline = NumberOfRows.numOfRows(inputDisciplina);

		String inputGita = Connect.connectDb(GiveAll.giveAllGita);
		int numGite = NumberOfRows.numOfRows(inputGita);

		String inputEsame = Connect.connectDb(GiveAll.giveAllEsame);
		int numEsami = NumberOfRows.numOfRows(inputEsame);


		String splitRighe[] = inputAttività.split("_");
		String splitConvegni[] = inputConvegno.split("_");
		String splitEsami[] = inputEsame.split("_");
		String splitDiscipline[] = inputDisciplina.split("_");
		String splitGite[] = inputGita.split("_");
		String splitTirocini[] = inputTirocinio.split("_");





		for (int i=0; i<numAttività; i++){

			String splitColonne[] = splitRighe[i].split(",");

			DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date dateInizio = format.parse(splitColonne[5]);
			Date dateFine = format.parse(splitColonne[6]);

			
			
			//aggiungere il controllo che, fatto un for, salta i successivi

			for(int j=0; j<numConvegni; j++){
				String splitColConvegni[] = splitConvegni[j].split(",");

				if (splitColConvegni[1].equals(splitColonne[0]))
				{
					model.getListConvegno().add(new Convegno(Integer.parseInt(splitColonne[3]),splitColonne[0],splitColonne[2],
							splitColonne[1],dateInizio, dateFine, Integer.parseInt(splitColonne[4]),
							splitColConvegni[2], splitColConvegni[3], splitColConvegni[4], splitColConvegni[5], Integer.parseInt(splitColConvegni[0])));
					break;
				}
			}
			
			for(int j=0; j<numDiscipline; j++){
				String splitColDiscipline[] = splitDiscipline[j].split(",");

				if (splitColDiscipline[1].equals(splitColonne[0]))
				{
					model.getListDisciplina().add(new Disciplina(Integer.parseInt(splitColonne[3]),splitColonne[0],splitColonne[2],
							splitColonne[1],dateInizio, dateFine, Integer.parseInt(splitColonne[4]),
							splitColDiscipline[0], Float.parseFloat(splitColDiscipline[2])));
					break;
				}
			}

			
			for(int j=0; j<numEsami; j++){
				String splitColEsami[] = splitEsami[j].split(",");

				if (splitColEsami[1].equals(splitColonne[0]))
				{
					model.getListEsame().add(new Esame(Integer.parseInt(splitColonne[3]),splitColonne[0],splitColonne[2],
							splitColonne[1],dateInizio, dateFine, Integer.parseInt(splitColonne[4]),
							splitColEsami[2], Integer.parseInt(splitColEsami[0])));
					break;
				}
			}
			
			for(int j=0; j<numGite; j++){
				String splitColGite[] = splitGite[j].split(",");

				if (splitColGite[1].equals(splitColonne[0]))
				{
					model.getListGita().add(new Gita(Integer.parseInt(splitColonne[3]),splitColonne[0],splitColonne[2],
							splitColonne[1],dateInizio, dateFine, Integer.parseInt(splitColonne[4]),
							splitColGite[2], Integer.parseInt(splitColGite[0]) ));
					break;
				}
			}
			
			for(int j=0; j<numTirocini; j++){
				String splitColTirocini[] = splitTirocini[j].split(",");

				if (splitColTirocini[1].equals(splitColonne[0]))
				{
					model.getListTirocinio().add(new Tirocinio(Integer.parseInt(splitColonne[3]),splitColonne[0],splitColonne[2],
							splitColonne[1],dateInizio, dateFine, Integer.parseInt(splitColonne[4]),
							splitColTirocini[2], splitColTirocini[4], splitColTirocini[3], Integer.parseInt(splitColTirocini[0])));
					break;
				}
			}


		}

	}


}
