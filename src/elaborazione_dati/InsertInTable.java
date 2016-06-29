package elaborazione_dati;

import java.io.IOException;
import java.net.URISyntaxException;

import connect_to_database.Connect;
import connect_to_database.NumberOfRows;
import url_php.GiveAll;

public class InsertInTable {
	
	private String selectedItem;
	
	public InsertInTable(Object selectedItem) {

		this.selectedItem = (String)selectedItem;
		
	}
	
	
	public String[][] getValues() throws IOException, URISyntaxException{
		
		if (selectedItem==null)
			return new String[1][1];
		
		if (selectedItem.equals("Attività")){
			return getAttività();
		}
		
		if (selectedItem.equals("Aula")){
			return getAula();
		}
		
		if (selectedItem.equals("Convegno")){
			return getConvegno();
		}
		
		if (selectedItem.equals("Corso di studi")){
			return getCorsoDiStudi();
		}
		
		if (selectedItem.equals("Disciplina")){
			return getDisciplina();
		}
		
		if (selectedItem.equals("Docente")){
			return getDocente();
		}
		
		if (selectedItem.equals("Esame")){
			return getEsame();
		}
		
		if (selectedItem.equals("Fascia oraria")){
			return getFasciaOraria();
		}
		
		if (selectedItem.equals("Gita")){
			return getGita();
		}
		
		if (selectedItem.equals("Insegna")){
			return getInsegna();
		}
		
		if (selectedItem.equals("Piano di studio")){
			return getPianoDiStudio();
		}
		
		if (selectedItem.equals("Preferenza aula")){
			return getPreferenzaAula();
		}
		
		if (selectedItem.equals("Preferenza fascia oraria")){
			return getPreferenzaFasciaOraria();
		}
		
		if (selectedItem.equals("Studente")){
			return getStudente();
		}
		
		if (selectedItem.equals("Tirocinio")){
			return getTirocinio();
		}
		
		return new String[1][1]; //coonsigliato da pmd
		
	}
	
	
	

	
	private String[][] getAttività() throws IOException, URISyntaxException {
		
		int numAttività = 0;
		String input = Connect.connectDb(GiveAll.giveAllAttività);
		numAttività = NumberOfRows.numOfRows(input);
		
        
		String[][] values = new String[numAttività+1][7];
		values[0][0] = "ID";
		values[0][1] = "Nome";
		values[0][2] = "Descrizione";
		values[0][3] = "Ore";
		values[0][4] = "Semestre";
		values[0][5] = "Inizio";
		values[0][6] = "Fine";
		
		
		String splitRighe[] = input.split("_");
		
		for (int i=1; i<numAttività+1; i++){
			
			String splitColonne[] = splitRighe[i-1].split(",");
			values[i][0] = splitColonne[0];
			values[i][1] = splitColonne[1];
			values[i][2] = splitColonne[2];
			values[i][3] = splitColonne[3];
			values[i][4] = splitColonne[4];
			values[i][5] = splitColonne[5];
			values[i][6] = splitColonne[6];
			
	}
	
		return values;
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
		
		
		private String[][] getConvegno() throws IOException, URISyntaxException {
		
		int numConvegni = 0;
		String inputAttività = Connect.connectDb(GiveAll.giveAllAttività);
		String inputConvegno = Connect.connectDb(GiveAll.giveAllConvegno);
		numConvegni = NumberOfRows.numOfRows(inputConvegno);
		
		
		
        
		String[][] values = new String[numConvegni+1][11];
		values[0][0] = "ID";
		values[0][1] = "Nome Attività";
		values[0][2] = "Descrizione";
		values[0][3] = "Ore";
		values[0][4] = "Semestre";
		values[0][5] = "Inizio";
		values[0][6] = "Fine";
		values[0][7] = "Nome Relatore";
		values[0][8] = "Cognome Relatore";
		values[0][9] = "Email Relatore";
		values[0][10] = "Qualifica Relatore";
		
		
		String splitRigheConvegno[] = inputConvegno.split("_");
		String splitRigheAttività[] = inputAttività.split("_");
		
		
		for (int i=1; i<numConvegni+1; i++){
			
			String splitColonneConvegno[] = splitRigheConvegno[i-1].split(",");
			
			
			int j=1;
			String splitColonneAttività[];
			do {
			
				splitColonneAttività = splitRigheAttività[j-1].split(",");
				j++;
			} while (!splitColonneConvegno[1].equals(splitColonneAttività[0]));
			
			values[i][0] = splitColonneConvegno[0];
			values[i][1] = splitColonneAttività[1];
			values[i][2] = splitColonneAttività[2];
			values[i][3] = splitColonneAttività[3];
			values[i][4] = splitColonneAttività[4];
			values[i][5] = splitColonneAttività[5];
			values[i][6] = splitColonneAttività[6];
			values[i][7] = splitColonneConvegno[2];
			values[i][8] = splitColonneConvegno[3];
			values[i][9] = splitColonneConvegno[4];
			values[i][10] = splitColonneConvegno[5];
			
		}	
	
		return values;
	}	
	
		private String[][] getCorsoDiStudi() throws IOException, URISyntaxException {
			
			int numCorsoDiStudi = 0;
			String input = Connect.connectDb(GiveAll.giveAllCorsoDiStudi);
			numCorsoDiStudi = NumberOfRows.numOfRows(input);
			
	        
			String[][] values = new String[numCorsoDiStudi+1][8];
			values[0][0] = "ID";
			values[0][1] = "Nome";
			values[0][2] = "Descrizione";
			values[0][3] = "Totale Crediti";
			values[0][4] = "Anno";
			values[0][5] = "Indirizzo";
			values[0][6] = "Facoltà";
			values[0][7] = "Tipo Laurea";
			
			String splitRighe[] = input.split("_");
			
			for (int i=1; i<numCorsoDiStudi+1; i++){
				
				String splitColonne[] = splitRighe[i-1].split(",");
				values[i][0] = splitColonne[0];
				values[i][1] = splitColonne[1];
				values[i][2] = splitColonne[2];
				values[i][3] = splitColonne[3];
				values[i][4] = splitColonne[4];
				values[i][5] = splitColonne[5];
				values[i][6] = splitColonne[6];
				values[i][7] = splitColonne[7];
				
		}
		
			return values;
		}
		
		private String[][] getDisciplina() throws IOException, URISyntaxException {
			
			int numDiscipline = 0;
			String inputDisciplina = Connect.connectDb(GiveAll.giveAllDisciplina);
			String inputAttività = Connect.connectDb(GiveAll.giveAllAttività);
			numDiscipline = NumberOfRows.numOfRows(inputDisciplina);
			
	        
			String[][] values = new String[numDiscipline+1][8];
			values[0][0] = "ID";
			values[0][1] = "Nome Attività";
			values[0][2] = "Descrizione";
			values[0][3] = "Ore";
			values[0][4] = "Semestre";
			values[0][5] = "Data Inizio";
			values[0][6] = "Data Fine";
			values[0][7] = "Crediti";
			
			
			String splitRigheDisciplina[] = inputDisciplina.split("_");
			String splitRigheAttività[] = inputAttività.split("_");
			
			for (int i=1; i<numDiscipline+1; i++){
				
				String splitColonneDisciplina[] = splitRigheDisciplina[i-1].split(",");
				
				int j=1;
				String splitColonneAttività[];
				do {
				
					splitColonneAttività = splitRigheAttività[j-1].split(",");
					j++;
				} while (!splitColonneDisciplina[1].equals(splitColonneAttività[0]));
				
				
				values[i][0] = splitColonneDisciplina[0];
				values[i][1] = splitColonneAttività[1];
				values[i][2] = splitColonneAttività[2];
				values[i][3] = splitColonneAttività[3];
				values[i][4] = splitColonneAttività[4];
				values[i][5] = splitColonneAttività[5];
				values[i][6] = splitColonneAttività[6];
				values[i][7] = splitColonneDisciplina[2];
				
		}
		
			return values;
		}
		
		private String[][] getDocente() throws IOException, URISyntaxException {
			
			int numDocenti = 0;
			String input = Connect.connectDb(GiveAll.giveAllDocente);
			numDocenti = NumberOfRows.numOfRows(input);
			
	        
			String[][] values = new String[numDocenti+1][6];
			values[0][0] = "Matricola";
			values[0][1] = "Nome";
			values[0][2] = "Cognome";
			values[0][3] = "Email";
			values[0][4] = "Qualifica";
			values[0][5] = "Associato";
			
			
			String splitRighe[] = input.split("_");
			
			for (int i=1; i<numDocenti+1; i++){
				
				String splitColonne[] = splitRighe[i-1].split(",");
				values[i][0] = splitColonne[0];
				values[i][1] = splitColonne[1];
				values[i][2] = splitColonne[2];
				values[i][3] = splitColonne[3];
				values[i][4] = splitColonne[4];
				values[i][5] = splitColonne[5];
				
		}
		
			return values;
		}
		
		private String[][] getEsame() throws IOException, URISyntaxException {
			
			int numEsami = 0;
			String inputEsame = Connect.connectDb(GiveAll.giveAllEsame);
			String inputAttività = Connect.connectDb(GiveAll.giveAllAttività);
			numEsami = NumberOfRows.numOfRows(inputEsame);
			
	        
			String[][] values = new String[numEsami+1][8];
			values[0][0] = "ID";
			values[0][1] = "Nome Attività";
			values[0][2] = "Descrizione";
			values[0][3] = "Ore";
			values[0][4] = "Semestre";
			values[0][5] = "Data Inizio";
			values[0][6] = "Data Fine";
			values[0][7] = "Tipologia";
			
			
			String splitRigheEsame[] = inputEsame.split("_");
			String splitRigheAttività[] = inputAttività.split("_");
			
			for (int i=1; i<numEsami+1; i++){
				
				String splitColonneEsame[] = splitRigheEsame[i-1].split(",");
				
				int j=1;
				String splitColonneAttività[];
				do {
				
					splitColonneAttività = splitRigheAttività[j-1].split(",");
					j++;
				} while (!splitColonneEsame[1].equals(splitColonneAttività[0]));
				
				values[i][0] = splitColonneEsame[0];
				values[i][1] = splitColonneAttività[1];
				values[i][2] = splitColonneAttività[2];
				values[i][3] = splitColonneAttività[3];
				values[i][4] = splitColonneAttività[4];
				values[i][5] = splitColonneAttività[5];
				values[i][6] = splitColonneAttività[6];
				values[i][7] = splitColonneEsame[2];
				
		}
		
			return values;
		}
		
		private String[][] getFasciaOraria() throws IOException, URISyntaxException {
			
			int numFasce = 0;
			String input = Connect.connectDb(GiveAll.giveAllFasciaOraria);
			numFasce = NumberOfRows.numOfRows(input);
			
	        
			String[][] values = new String[numFasce+1][4];
			values[0][0] = "ID";
			values[0][1] = "Giorno";
			values[0][2] = "Inizio";
			values[0][3] = "Fine";
			
			
			String splitRighe[] = input.split("_");
			
			for (int i=1; i<numFasce+1; i++){
				
				String splitColonne[] = splitRighe[i-1].split(",");
				values[i][0] = splitColonne[0];
				values[i][1] = splitColonne[1];
				values[i][2] = splitColonne[2];
				values[i][3] = splitColonne[3];
				
		}
		
			return values;
		}
		
		private String[][] getGita() throws IOException, URISyntaxException {
			
			int numGite = 0;
			String inputGita = Connect.connectDb(GiveAll.giveAllGita);
			String inputAttività = Connect.connectDb(GiveAll.giveAllAttività);
			numGite = NumberOfRows.numOfRows(inputGita);
			
	        
			String[][] values = new String[numGite+1][8];
			values[0][0] = "ID";
			values[0][1] = "Nome Attività";
			values[0][2] = "Descrizione";
			values[0][3] = "Ore";
			values[0][4] = "Semestre";
			values[0][5] = "Data Inizio";
			values[0][6] = "Data Fine";
			values[0][7] = "Luogo";
			
			
			String splitRigheGita[] = inputGita.split("_");
			String splitRigheAttività[] = inputAttività.split("_");
			
			for (int i=1; i<numGite+1; i++){
				
				String splitColonneGita[] = splitRigheGita[i-1].split(",");
				int j=1;
				String splitColonneAttività[];
				do {
				
					splitColonneAttività = splitRigheAttività[j-1].split(",");
					j++;
				} while (!splitColonneGita[1].equals(splitColonneAttività[0]));
				
				values[i][0] = splitColonneGita[0];
				values[i][1] = splitColonneAttività[1];
				values[i][2] = splitColonneAttività[2];
				values[i][3] = splitColonneAttività[3];
				values[i][4] = splitColonneAttività[4];
				values[i][5] = splitColonneAttività[5];
				values[i][6] = splitColonneAttività[6];
				values[i][7] = splitColonneGita[2];
		}
		
			return values;
		}
		
		private String[][] getInsegna() throws IOException, URISyntaxException {
			
			int numInsegna = 0;
			String inputInsegna = Connect.connectDb(GiveAll.giveAllInsegna);
			String inputAttività = Connect.connectDb(GiveAll.giveAllAttività);
			String inputDocente = Connect.connectDb(GiveAll.giveAllDocente);
			numInsegna = NumberOfRows.numOfRows(inputInsegna);
			
	        
			String[][] values = new String[numInsegna+1][9];
			values[0][0] = "Matricola";
			values[0][1] = "Nome Docente";
			values[0][2] = "Cognome Docente";
			values[0][3] = "Nome Attività";
			values[0][4] = "Descrizione";
			values[0][5] = "Ore";
			values[0][6] = "Semestre";
			values[0][7] = "Data Inizio";
			values[0][8] = "Data Fine";
			
			
			String splitRigheInsegna[] = inputInsegna.split("_");
			String splitRigheAttività[] = inputAttività.split("_");
			String splitRigheDocente[] = inputDocente.split("_");
			String splitColonneDocente[] = null;
			
			for (int i=1; i<numInsegna+1; i++){
				
				String splitColonneInsegna[] = splitRigheInsegna[i-1].split(",");
					int j=1;
					String splitColonneAttività[];
					do {
						splitColonneAttività = splitRigheAttività[j-1].split(",");
						j++;
					} while (!splitColonneInsegna[1].equals(splitColonneAttività[0]));
					
					for (int k=1; k<numInsegna+1; k++){
						
						String splitColInsegna[] = splitRigheInsegna[k-1].split(",");
						for (int z=0; z<splitRigheDocente.length; z++){
						String x = splitRigheDocente[z];
						splitColonneDocente = x.split(",");
						if (splitColonneDocente[0].trim().equals(splitColonneInsegna[0].trim()))
							break;
						}
						
						
							
							
					
				values[i][0] = splitColonneInsegna[0];
				values[i][1] = splitColonneDocente[1];
				values[i][2] = splitColonneDocente[2];
				values[i][3] = splitColonneAttività[1];
				values[i][4] = splitColonneAttività[2];
				values[i][5] = splitColonneAttività[3];
				values[i][6] = splitColonneAttività[4];
				values[i][7] = splitColonneAttività[5];
				values[i][8] = splitColonneAttività[6];
				
		}
			}
			return values;
		}
		
		private String[][] getPianoDiStudio() throws IOException, URISyntaxException {
			
			int numPiani = 0;
			String inputPiani = Connect.connectDb(GiveAll.giveAllPianoDiStudio);
			String inputAttività = Connect.connectDb(GiveAll.giveAllAttività);
			String inputCorsi = Connect.connectDb(GiveAll.giveAllCorsoDiStudi);
			numPiani = NumberOfRows.numOfRows(inputPiani);
			
	        
			String[][] values = new String[numPiani+1][15];
			values[0][0] = "ID Corso";
			values[0][1] = "Nome";
			values[0][2] = "Descrizione";
			values[0][3] = "Totale Crediti";
			values[0][4] = "Anno";
			values[0][5] = "Indirizzo";
			values[0][6] = "Facoltà";
			values[0][7] = "Tipo Laurea";
			values[0][8] = "Nome Attività";
			values[0][9] = "Descrizione";
			values[0][10] = "Ore";
			values[0][11] = "Semestre";
			values[0][12] = "Data Inizio";
			values[0][13] = "Data Fine";
			values[0][14] = "Opzionale";
			
			
			String splitRighePiani[] = inputPiani.split("_");
			String splitRigheAttività[] = inputAttività.split("_");
			String splitRigheCorsi[] = inputCorsi.split("_");
			
			for (int i=1; i<numPiani+1; i++){
				
				String splitColonnePiani[] = splitRighePiani[i-1].split(",");
				int j=1;
				String splitColonneAttività[];
				do {
				
					splitColonneAttività = splitRigheAttività[j-1].split(",");
					j++;
				} while (!splitColonnePiani[1].equals(splitColonneAttività[0]));
				
				int k = 1;
				String splitColonneCorsi[];
				do {
					splitColonneCorsi = splitRigheCorsi[k-1].split(",");
					k++;
				} while (!splitColonnePiani[0].equals(splitColonneCorsi[0]));
				
				values[i][0] = splitColonneCorsi[0];
				values[i][1] = splitColonneCorsi[1];
				values[i][2] = splitColonneCorsi[2];
				values[i][3] = splitColonneCorsi[3];
				values[i][4] = splitColonneCorsi[4];
				values[i][5] = splitColonneCorsi[5];
				values[i][6] = splitColonneCorsi[6];
				values[i][7] = splitColonneCorsi[7];
				values[i][8] = splitColonneAttività[1];
				values[i][9] = splitColonneAttività[2];
				values[i][10] = splitColonneAttività[3];
				values[i][11] = splitColonneAttività[4];
				values[i][12] = splitColonneAttività[5];
				values[i][13] = splitColonneAttività[6];
				values[i][14] = splitColonnePiani[2];
				
		}
		
			return values;
		}
		
		private String[][] getPreferenzaAula() throws IOException, URISyntaxException {
			
			int numPreferenze = 0;
			String inputPrefAula = Connect.connectDb(GiveAll.giveAllPreferenzaAula);
			String inputDocente = Connect.connectDb(GiveAll.giveAllDocente);
			numPreferenze = NumberOfRows.numOfRows(inputPrefAula);
			
	        
			String[][] values = new String[numPreferenze+1][5];
			values[0][0] = "Matricola";
			values[0][1] = "Nome Docente";
			values[0][2] = "Cognome Docente";
			values[0][3] = "Edificio";
			values[0][4] = "Numero";
			
			
			String splitRighePrefAula[] = inputPrefAula.split("_");
			String splitRigheDocente[] = inputDocente.split("_");
			
			for (int i=1; i<numPreferenze+1; i++){
				
				String splitColonnePrefAula[] = splitRighePrefAula[i-1].split(",");

				
				int j=1;
				String splitColonneDocente[];
				do {
				
					splitColonneDocente = splitRigheDocente[j-1].split(",");
					j++;
				} while (!splitColonnePrefAula[0].equals(splitColonneDocente[0]));
				
				values[i][0] = splitColonnePrefAula[0];
				values[i][1] = splitColonneDocente[1];
				values[i][2] = splitColonneDocente[2];
				values[i][3] = splitColonnePrefAula[1];
				values[i][4] = splitColonnePrefAula[2];
		}
		
			return values;
		}
		
		private String[][] getPreferenzaFasciaOraria() throws IOException, URISyntaxException {
			
			int numPreFas = 0;
			String inputPrefFascia = Connect.connectDb(GiveAll.giveAllPreferenzaFasciaOraria);
			String inputDocente = Connect.connectDb(GiveAll.giveAllDocente);
			String inputFascia = Connect.connectDb(GiveAll.giveAllFasciaOraria);
			numPreFas = NumberOfRows.numOfRows(inputPrefFascia);
			
	        
			String[][] values = new String[numPreFas+1][7];
			values[0][0] = "Matricola";
			values[0][1] = "Nome Docente";
			values[0][2] = "Cognome Docente";
			values[0][3] = "Giorno";
			values[0][4] = "Ora Inizio";
			values[0][5] = "Ora Fine";
			values[0][6] = "Priorità";

			
			String splitRighePrefFascia[] = inputPrefFascia.split("_");
			String splitRigheDocente[] = inputDocente.split("_");
			String splitRigheFascia[] = inputFascia.split("_");
			
			for (int i=1; i<numPreFas+1; i++){
				
				String splitColonnePrefFascia[] = splitRighePrefFascia[i-1].split(",");
				
				int j=1;
				String splitColonneDocente[];
				do {
				
					splitColonneDocente = splitRigheDocente[j-1].split(",");
					j++;
				} while (!splitColonnePrefFascia[0].equals(splitColonneDocente[0]));
				
				int k = 1;
				String splitColonneFascia[];
				do {
					splitColonneFascia = splitRigheFascia[k-1].split(",");
					k++;
				} while (!splitColonnePrefFascia[1].equals(splitColonneFascia[0]));
				
				values[i][0] = splitColonnePrefFascia[0];
				values[i][1] = splitColonneDocente[1];
				values[i][2] = splitColonneDocente[2];
				values[i][3] = splitColonneFascia[1];
				values[i][4] = splitColonneFascia[2];
				values[i][5] = splitColonneFascia[3];
				values[i][6] = splitColonnePrefFascia[2];
				
		}
		
			return values;
		}
		
		private String[][] getStudente() throws IOException, URISyntaxException {
			
			int numStudenti = 0;
			String inputStudente = Connect.connectDb(GiveAll.giveAllStudente);
			String inputCorsi = Connect.connectDb(GiveAll.giveAllCorsoDiStudi);
			numStudenti = NumberOfRows.numOfRows(inputStudente);
			
	        
			String[][] values = new String[numStudenti+1][13];
			values[0][0] = "Matricola";
			values[0][1] = "Nome";
			values[0][2] = "Cognome";
			values[0][3] = "Email";
			values[0][4] = "Data Nascita";
			values[0][5] = "Anno Iscrizione";
			values[0][6] = "Nome";
			values[0][7] = "Descrizione";
			values[0][8] = "Totale Crediti";
			values[0][9] = "Anno";
			values[0][10] = "Indirizzo";
			values[0][11] = "Facoltà";
			values[0][12] = "Tipo Laurea";
			
			
			String splitRigheStudente[] = inputStudente.split("_");
			String splitRigheCorsi[] = inputCorsi.split("_");
			
			for (int i=1; i<numStudenti+1; i++){
				
				String splitColonneStudente[] = splitRigheStudente[i-1].split(",");
				
				int j = 1;
				String splitColonneCorsi[];
				do {
					splitColonneCorsi = splitRigheCorsi[j-1].split(",");
					j++;
				} while (!splitColonneStudente[6].equals(splitColonneCorsi[0]));
				
				values[i][0] = splitColonneStudente[0];
				values[i][1] = splitColonneStudente[1];
				values[i][2] = splitColonneStudente[2];
				values[i][3] = splitColonneStudente[3];
				values[i][4] = splitColonneStudente[4];
				values[i][5] = splitColonneStudente[5];
				values[i][6] = splitColonneCorsi[1];
				values[i][7] = splitColonneCorsi[2];
				values[i][8] = splitColonneCorsi[3];
				values[i][9] = splitColonneCorsi[4];
				values[i][10] = splitColonneCorsi[5];
				values[i][11] = splitColonneCorsi[6];
				values[i][12] = splitColonneCorsi[7];
				
		}
		
			return values;
	}
	
		private String[][] getTirocinio() throws IOException, URISyntaxException {
			
			int numTirocini = 0;
			String inputTirocinio = Connect.connectDb(GiveAll.giveAllTirocinio);
			String inputAttività = Connect.connectDb(GiveAll.giveAllAttività);
			numTirocini = NumberOfRows.numOfRows(inputTirocinio);
			
	        
			String[][] values = new String[numTirocini+1][10];
			values[0][0] = "ID";
			values[0][1] = "Nome Attività";
			values[0][2] = "Descrizione Attività";
			values[0][3] = "Ore";
			values[0][4] = "Semestre";
			values[0][5] = "Data Inizio";
			values[0][6] = "Data Fine";
			values[0][7] = "Nome Azienda";
			values[0][8] = "Descrizione Azienda";
			values[0][9] = "Email Azienda";
			
			
			String splitRigheTirocinio[] = inputTirocinio.split("_");
			String splitRigheAttività[] = inputAttività.split("_");
			
			for (int i=1; i<numTirocini+1; i++){
				
				String splitColonneTirocinio[] = splitRigheTirocinio[i-1].split(",");
				
				int j=1;
				String splitColonneAttività[];
				do {
				
					splitColonneAttività = splitRigheAttività[j-1].split(",");
					j++;
				} while (!splitColonneTirocinio[1].equals(splitColonneAttività[0]));
				
				values[i][0] = splitColonneTirocinio[0];
				values[i][1] = splitColonneAttività[1];
				values[i][2] = splitColonneAttività[2];
				values[i][3] = splitColonneAttività[3];
				values[i][4] = splitColonneAttività[4];
				values[i][5] = splitColonneAttività[5];
				values[i][6] = splitColonneAttività[6];
				values[i][7] = splitColonneTirocinio[2];
				values[i][8] = splitColonneTirocinio[3];
				values[i][9] = splitColonneTirocinio[4];
				
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
