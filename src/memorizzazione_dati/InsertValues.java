/*
 * 
 */
package memorizzazione_dati;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import connect_to_database.Connect;
import connect_to_database.NumberOfRows;
import mvc.Model;
import my_components.Aula;
import my_components.Convegno;
import my_components.CorsoDiStudi;
import my_components.Disciplina;
import my_components.Docente;
import my_components.Esame;
import my_components.FasciaOraria;
import my_components.Gita;
import my_components.PianoDiStudi;
import my_components.SceltaAula;
import my_components.SceltaOraria;
import my_components.Studente;
import my_components.Tirocinio;
import url_php.GiveAll;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertValues.
 */
public class InsertValues {


	/** The model. */
	private Model model;

	/**
	 * Instantiates a new insert values.
	 *
	 * @param model the model
	 */
	public InsertValues(Model model) {
		this.model = model;
	}


	/**
	 * Gets the value aula.
	 *
	 * @return the value aula
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
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

	/**
	 * Gets the value docente.
	 *
	 * @return the value docente
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	public void getValueDocente() throws IOException, URISyntaxException{

		String inputDocenti = Connect.connectDb(GiveAll.giveAllDocente);
		String inputInsegna = Connect.connectDb(GiveAll.giveAllInsegna);
		String inputPreferenzaFascia = Connect.connectDb(GiveAll.giveAllPreferenzaFasciaOraria);
		String inputPreferenzaAula = Connect.connectDb(GiveAll.giveAllPreferenzaAula);
		
		int numDocenti = NumberOfRows.numOfRows(inputDocenti);
		int numInsegna = NumberOfRows.numOfRows(inputInsegna);
		int numPreferenzeFasce = NumberOfRows.numOfRows(inputPreferenzaFascia);
		int numPreferenzeAule = NumberOfRows.numOfRows(inputPreferenzaAula);

		String splitRighe[] = inputDocenti.split("_");
		String splitInsegna[] = inputInsegna.split("_");
		String splitFasciaOraria[] = inputPreferenzaFascia.split("_");
		String splitPreferenzaAula[] = inputPreferenzaAula.split("_");


		for (int i=0; i<numDocenti; i++){

			String splitColonne[] = splitRighe[i].split(",");
			
			model.getListDocente().add(new Docente(splitColonne[1], splitColonne[2], Boolean.parseBoolean(splitColonne[5]), splitColonne[0], splitColonne[3], splitColonne[4]));

			
			//attività
			for (int j=0; j<numInsegna; j++){
				String splitColInsegna[] = splitInsegna[j].split(",");
				if (model.getListDocente().get(i).getMatricola().equals(splitColInsegna[0])){
					
					for (int k=0; k<model.getListDisciplina().size(); k++){
						if(model.getListDisciplina().get(k).getId().equals(splitColInsegna[1])){
							model.getListDocente().get(i).aggiungiAttività(model.getListDisciplina().get(k));
							break;
						}
					}
					
					for (int k=0; k<model.getListGita().size(); k++){
						if(model.getListGita().get(k).getId().equals(splitColInsegna[1])){
							model.getListDocente().get(i).aggiungiAttività(model.getListGita().get(k));
							break;
						}
					}
					
					for (int k=0; k<model.getListConvegno().size(); k++){
						if(model.getListConvegno().get(k).getId().equals(splitColInsegna[1])){
							model.getListDocente().get(i).aggiungiAttività(model.getListConvegno().get(k));
							break;
						}
					}

					
					
				}
			}
			
			//preferenza orari
			for (int j=0; j<numPreferenzeFasce; j++){
				String splitColFasciaOraria[] = splitFasciaOraria[j].split(",");
				if (model.getListDocente().get(i).getMatricola().equals(splitColFasciaOraria[0])){
					
					for (int k=0; k<model.getListFasciaOraria().size(); k++){
						if (model.getListFasciaOraria().get(k).getIdFascia() == Integer.parseInt(splitColFasciaOraria[1])){
							model.getListDocente().get(i).aggiungiPreferenza(new SceltaOraria(model.getListFasciaOraria().get(k),Integer.parseInt(splitColFasciaOraria[2])));
							break;
						}
					}
					
					
				}
			}
			
			
			//preferenza aule
			for (int j=0; j<numPreferenzeAule; j++){
				String splitColPreferenzaAula[] = splitPreferenzaAula[j].split(",");
				if (model.getListDocente().get(i).getMatricola().equals(splitColPreferenzaAula[0])){
					
					for (int k=0; k<model.getListAula().size(); k++){
						if (model.getListAula().get(k).getEdificio().equals(splitColPreferenzaAula[1]) && 
							model.getListAula().get(k).getNumero() == Integer.parseInt(splitColPreferenzaAula[2])){
							
							model.getListDocente().get(i).aggiungiPreferenza(new SceltaAula(model.getListAula().get(k),Integer.parseInt(splitColPreferenzaAula[2])));
							break;
						}
					}
					
					
				}
			}
			
			
			

		}

	}

	/**
	 * Gets the value corso di studi_1.
	 *
	 * @return the value corso di studi_1
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	public void getValueCorsoDiStudi1() throws IOException, URISyntaxException{

		String input = Connect.connectDb(GiveAll.giveAllCorsoDiStudi);
		int numCorsoDiStudi = NumberOfRows.numOfRows(input);

		String splitRighe[] = input.split("_");


		for (int i=0; i<numCorsoDiStudi; i++){

			String splitColonne[] = splitRighe[i].split(",");

			model.getListCorsoDiStudi().add(new CorsoDiStudi(Short.parseShort(splitColonne[4]), splitColonne[1], splitColonne[5], splitColonne[7], splitColonne[6], splitColonne[0], splitColonne[2], Integer.parseInt(splitColonne[3])));			

		}

	}

	/**
	 * Gets the value corso di studi_2.
	 *
	 * @return the value corso di studi_2
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	public void getValueCorsoDiStudi2() throws IOException, URISyntaxException{




		for (int i=0; i<model.getListCorsoDiStudi().size(); i++){

			for (int j=0; j<model.getListStudente().size(); j++){
				if (model.getListCorsoDiStudi().get(i).getCodice().equals(model.getListStudente().get(j).getCorso().getCodice())){
					model.getListCorsoDiStudi().get(i).iscriviStudente(model.getListStudente().get(j));
				}

			}
		}

	}

	/**
	 * Gets the value studente.
	 *
	 * @return the value studente
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 * @throws ParseException the parse exception
	 */
	public void getValueStudente() throws IOException, URISyntaxException, ParseException{

		String input = Connect.connectDb(GiveAll.giveAllStudente);
		int numStudenti = NumberOfRows.numOfRows(input);

		String splitRighe[] = input.split("_");


		for (int i=0; i<numStudenti; i++){

			String splitColonne[] = splitRighe[i].split(",");


			DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date date = format.parse(splitColonne[4]);

			for (int j=0; j<model.getListCorsoDiStudi().size(); j++){
				if(model.getListCorsoDiStudi().get(j).getCodice().equals(splitColonne[6])){
					model.getListStudente().add(new Studente(splitColonne[1], splitColonne[2], splitColonne[0], splitColonne[3], date, Integer.parseInt(splitColonne[5]), model.getListCorsoDiStudi().get(j)));
					break;
				}
			}

		}

	}

	/**
	 * Gets the value fascia oraria.
	 *
	 * @return the value fascia oraria
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 * @throws ParseException the parse exception
	 */
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

	/**
	 * Gets the value attività_1.
	 *
	 * @return the value attività_1
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 * @throws ParseException the parse exception
	 */
	public void getValueAttività1() throws IOException, URISyntaxException, ParseException{

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


	/**
	 * Gets the value piano di studi.
	 *
	 * @return the value piano di studi
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 * @throws ParseException the parse exception
	 */
	public void getValuePianoDiStudi() throws IOException, URISyntaxException, ParseException{

		String input = Connect.connectDb(GiveAll.giveAllPianoDiStudio);
		int numPianiDiStudio = NumberOfRows.numOfRows(input);

		String splitRighe[] = input.split("_");


		for (int i=0, k=0; i<numPianiDiStudio; i++){

			String splitColonne[] = splitRighe[i].split(",");

			if (model.getListPianoDiStudi().size() == 0 || !model.getListPianoDiStudi().get(k-1).getCorso().getCodice().equals(splitColonne[0])){

				for(int j=0; j<model.getListCorsoDiStudi().size(); j++){
					if(splitColonne[0].equals(model.getListCorsoDiStudi().get(j).getCodice())){
						model.getListPianoDiStudi().add(new PianoDiStudi(model.getListCorsoDiStudi().get(j)));
						k++;
						break;
					}
				}
			}


			//per ora controllo solo le discipline
			for(int j=0; j<model.getListDisciplina().size(); j++){
				if(model.getListDisciplina().get(j).getId().equals(splitColonne[1])){
					if(Integer.parseInt(splitColonne[2]) == 1){
						//aggiungo nelle attività opzionali
						model.getListPianoDiStudi().get(k-1).aggiungiAttivitàOpzionale(model.getListDisciplina().get(j));
					}
					else{
						//aggiungo nelle attività obbligatorie
						model.getListPianoDiStudi().get(k-1).aggiungiAttivitàObbligatoria(model.getListDisciplina().get(j));

					}
					break;
				}
			}



		}

	}
	
	/**
	 * Gets the value attività_2.
	 *
	 * @return the value attività_2
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 * @throws ParseException the parse exception
	 */
	public void getValueAttività2() throws IOException, URISyntaxException, ParseException{
		
		
		for (int i=0; i<model.getListDisciplina().size(); i++){
			
			for (int j=0; j<model.getListDocente().size(); j++){
				
				for (int k=0; k<model.getListDocente().get(j).getElencoAttività().size();k++){
					
					if (model.getListDisciplina().get(i).getId().equals(
							model.getListDocente().get(j).getElencoAttività().get(k).getId())){
						model.getListDisciplina().get(i).aggiungiResponsabile(model.getListDocente().get(j));
					}
					
				}
				
			}
			
		}
		
		for (int i=0; i<model.getListGita().size(); i++){	
			for (int j=0; j<model.getListDocente().size(); j++){
				for (int k=0; k<model.getListDocente().get(j).getElencoAttività().size();k++){
					if (model.getListGita().get(i).getId().equals(
							model.getListDocente().get(j).getElencoAttività().get(k).getId())){
						model.getListGita().get(i).aggiungiResponsabile(model.getListDocente().get(j));
					}
				}
			}
		}
		
		for (int i=0; i<model.getListConvegno().size(); i++){	
			for (int j=0; j<model.getListDocente().size(); j++){
				for (int k=0; k<model.getListDocente().get(j).getElencoAttività().size();k++){
					if (model.getListConvegno().get(i).getId().equals(
							model.getListDocente().get(j).getElencoAttività().get(k).getId())){
						model.getListConvegno().get(i).aggiungiResponsabile(model.getListDocente().get(j));
					}
				}
			}
		}
		
			
	}


}
