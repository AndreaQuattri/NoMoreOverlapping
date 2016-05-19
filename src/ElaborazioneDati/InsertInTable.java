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
		
		//System.out.println(selectedItem);
		
		return null;
		
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
			numInsegna = NumberOfRows.numOfRows(inputInsegna);
			
	        
			String[][] values = new String[numInsegna+1][7];
			values[0][0] = "Matricola";
			values[0][1] = "Nome Attività";
			values[0][2] = "Descrizione";
			values[0][3] = "Ore";
			values[0][4] = "Semestre";
			values[0][5] = "Data Inizio";
			values[0][6] = "Data Fine";
			
			
			String splitRigheInsegna[] = inputInsegna.split("_");
			String splitRigheAttività[] = inputAttività.split("_");
			
			for (int i=1; i<numInsegna+1; i++){
				
				String splitColonneInsegna[] = splitRigheInsegna[i-1].split(",");
				System.out.println(i);
					int j=1;
					String splitColonneAttività[];
					do {
					
						splitColonneAttività = splitRigheAttività[j-1].split(",");
						j++;
					} while (!splitColonneInsegna[1].equals(splitColonneAttività[0]));
					
				values[i][0] = splitColonneInsegna[0];
				values[i][1] = splitColonneAttività[1];
				values[i][2] = splitColonneAttività[2];
				values[i][3] = splitColonneAttività[3];
				values[i][4] = splitColonneAttività[4];
				values[i][5] = splitColonneAttività[5];
				values[i][6] = splitColonneAttività[6];
				
		}
		
			return values;
		}
		
		private String[][] getPianoDiStudio() throws IOException, URISyntaxException {
			
			int numPiani = 0;
			String inputPiani = Connect.connectDb(GiveAll.giveAllPianoDiStudio);
			String inputAttività = Connect.connectDb(GiveAll.giveAllAttività);
			String inputCorsi = Connect.connectDb(GiveAll.giveAllCorsoDiStudi);
			numPiani = NumberOfRows.numOfRows(inputPiani);
			
	        
			String[][] values = new String[numPiani+1][14];
			values[0][0] = "ID";
			values[0][1] = "Attività";
			values[0][2] = "Opzionale";
			
			
			String splitRighePiani[] = inputPiani.split("_");
			
			for (int i=1; i<numPiani+1; i++){
				
				String splitColonnePiani[] = splitRighePiani[i-1].split(",");
				values[i][0] = splitColonnePiani[0];
				values[i][1] = splitColonnePiani[1];
				values[i][2] = splitColonnePiani[2];
				
		}
		
			return values;
		}
		
		private String[][] getPreferenzaAula() throws IOException, URISyntaxException {
			
			int numPreferenze = 0;
			String input = Connect.connectDb(GiveAll.giveAllPreferenzaAula);
			numPreferenze = NumberOfRows.numOfRows(input);
			
	        
			String[][] values = new String[numPreferenze+1][3];
			values[0][0] = "Matricola";
			values[0][1] = "Edificio";
			values[0][2] = "Numero";
			
			
			String splitRighe[] = input.split("_");
			
			for (int i=1; i<numPreferenze+1; i++){
				
				String splitColonne[] = splitRighe[i-1].split(",");
				values[i][0] = splitColonne[0];
				values[i][1] = splitColonne[1];
				values[i][2] = splitColonne[2];
		}
		
			return values;
		}
		
		private String[][] getPreferenzaFasciaOraria() throws IOException, URISyntaxException {
			
			int numPreFas = 0;
			String input = Connect.connectDb(GiveAll.giveAllPreferenzaFasciaOraria);
			numPreFas = NumberOfRows.numOfRows(input);
			
	        
			String[][] values = new String[numPreFas+1][3];
			values[0][0] = "Matricola";
			values[0][1] = "ID";
			values[0][2] = "Priorità";
			
			
			String splitRighe[] = input.split("_");
			
			for (int i=1; i<numPreFas+1; i++){
				
				String splitColonne[] = splitRighe[i-1].split(",");
				values[i][0] = splitColonne[0];
				values[i][1] = splitColonne[1];
				values[i][2] = splitColonne[2];
				
		}
		
			return values;
		}
		
		private String[][] getStudente() throws IOException, URISyntaxException {
			
			int numStudenti = 0;
			String input = Connect.connectDb(GiveAll.giveAllStudente);
			numStudenti = NumberOfRows.numOfRows(input);
			
	        
			String[][] values = new String[numStudenti+1][6];
			values[0][0] = "Matricola";
			values[0][1] = "Nome";
			values[0][2] = "Cognome";
			values[0][3] = "Email";
			values[0][4] = "Data Nascita";
			values[0][5] = "Anno Iscrizione";
			
			
			String splitRighe[] = input.split("_");
			
			for (int i=1; i<numStudenti+1; i++){
				
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
	
		private String[][] getTirocinio() throws IOException, URISyntaxException {
			
			int numTirocini = 0;
			String input = Connect.connectDb(GiveAll.giveAllTirocinio);
			numTirocini = NumberOfRows.numOfRows(input);
			
	        
			String[][] values = new String[numTirocini+1][5];
			values[0][0] = "ID";
			values[0][1] = "Attività";
			values[0][2] = "Nome Azienda";
			values[0][3] = "Descrizione Azienda";
			values[0][4] = "Email Azienda";
			
			
			String splitRighe[] = input.split("_");
			
			for (int i=1; i<numTirocini+1; i++){
				
				String splitColonne[] = splitRighe[i-1].split(",");
				values[i][0] = splitColonne[0];
				values[i][1] = splitColonne[1];
				values[i][2] = splitColonne[2];
				values[i][3] = splitColonne[3];
				values[i][4] = splitColonne[4];
				
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
