package controller_listener;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import connect_to_database.Connect;
import url_php.Insert;

public class InsertCampiListener{
	
	private ArrayList<String> elencoParametri;
	private String tabella;

	public InsertCampiListener(ArrayList<String> elencoParametri, String tabella) {
		// TODO Auto-generated constructor stub
		this.elencoParametri = elencoParametri;
		this.tabella = tabella;
	}

	public void inserisciCampi() {
		// TODO Auto-generated method stub
		
				
		
		if (tabella.equals("Attività"))
			inserisciAttivita();
		
		if (tabella.equals("Aula"))
			inserisciAula();
	
		if (tabella.equals("Convegno"))
			inserisciConvegno();
		
		if (tabella.equals("Corso di studi"))
			inserisciCorsoDiStudi();
		
		if (tabella.equals("Disciplina"))
			inserisciDisciplina();
		
		if (tabella.equals("Docente"))
			inserisciDocente();
		
		if (tabella.equals("Esame"))
			inserisciEsame();
				
		if (tabella.equals("Gita"))
			inserisciGita();
		
		if (tabella.equals("Insegna"))
			inserisciInsegna();
		
		if (tabella.equals("Piano di studio"))
			inserisciPianoDiStudio();
		
		if (tabella.equals("Preferenza aula"))
			inserisciPreferenzaAula();
		
		if (tabella.equals("Preferenza fascia oraria"))
			inserisciPreferenzaFasciaOraria();
		
		if (tabella.equals("Studente"))
			inserisciStudente();
		
		if (tabella.equals("Tirocinio"))
			inserisciTirocinio();
	}

	private void inserisciTirocinio() {
		try {
			Connect.connectDb(Insert.INSERT_TIROCINIO+"?IDAttivita=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&NomeAzienda=" + (elencoParametri.get(1)).replaceAll(" ", "%20") + "&DescrizioneAzienda=" + (elencoParametri.get(2)).replaceAll(" ", "%20") + "&EmailAzienda=" + (elencoParametri.get(3)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	private void inserisciStudente() {
		String data = elencoParametri.get(6)+"-"+meseNumero(elencoParametri.get(5))+"-"+elencoParametri.get(4);
		try {
			Connect.connectDb(Insert.INSERT_STUDENTE+"?Matricola=" + (elencoParametri.get(0).replaceAll(" ", "%20")) + "&Nome=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&Cognome=" + (elencoParametri.get(2).replaceAll(" ", "%20")) + "&Email=" + (elencoParametri.get(3).replaceAll(" ", "%20")) + "&DataNascita=" + (data.replaceAll(" ", "%20")) + "&AnnoIscrizione=" + (elencoParametri.get(7).replaceAll(" ", "%20"))+ "&IDCorsoDiStudi="+ (elencoParametri.get(8).replaceAll(" ", "%20")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
				
	}

	private void inserisciPreferenzaFasciaOraria() {
		try {
			Connect.connectDb(Insert.INSERT_PREFERENZAFASCIAORARIA+"?Matricola=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&IDFasciaOraria=" + (elencoParametri.get(1)).replaceAll(" ", "%20") + "&priorita=" + (elencoParametri.get(2)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	private void inserisciPreferenzaAula() {
		try {
			Connect.connectDb(Insert.INSERT_PREFERENZAAULA+"?Matricola=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&edificio=" + (elencoParametri.get(1)).replaceAll(" ", "%20") + "&numero=" + (elencoParametri.get(2)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	private void inserisciPianoDiStudio() {
		try {
			Connect.connectDb(Insert.INSERT_PIANODISTUDIO+"?IDCorsoDiStudi=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&IDAttivita=" + (elencoParametri.get(1)).replaceAll(" ", "%20") + "&Opzionale=" + (elencoParametri.get(2)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void inserisciInsegna() {
		try {
			Connect.connectDb(Insert.INSERT_INSEGNA+"?Matricola=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&IDAttivita=" + (elencoParametri.get(1)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	private void inserisciGita() {
		//System.out.println("Gita");
		
		try {
			Connect.connectDb(Insert.INSERT_GITA+"?IDAttivita=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&Luogo=" + (elencoParametri.get(1)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	private void inserisciEsame() {
		try {
			Connect.connectDb(Insert.INSERT_ESAME+"?IDAttivita=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&Tipologia=" + (elencoParametri.get(1)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	private void inserisciDocente() {
		try {
			Connect.connectDb(Insert.INSERT_DOCENTE+"?Matricola=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&Nome=" + (elencoParametri.get(1)).replaceAll(" ", "%20") + "&Cognome=" + (elencoParametri.get(2)).replaceAll(" ", "%20") + "&Email=" + (elencoParametri.get(3)).replaceAll(" ", "%20") + "&Qualifica=" + (elencoParametri.get(4)).replaceAll(" ", "%20") + "&Associato=" + (elencoParametri.get(5)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	private void inserisciDisciplina() {
		try {
			Connect.connectDb(Insert.INSERT_DISCIPLINA+"?IDAttivita=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&Crediti=" + (elencoParametri.get(1)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	private void inserisciCorsoDiStudi() {
		
		try {
			Connect.connectDb(Insert.INSERT_CORSODISTUDI+"?Nome=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&Descrizione=" + (elencoParametri.get(1)).replaceAll(" ", "%20") + "&TotaleCrediti=" + (elencoParametri.get(2)).replaceAll(" ", "%20") + "&Anno=" + (elencoParametri.get(3)).replaceAll(" ", "%20") + "&Indirizzo=" + (elencoParametri.get(4)).replaceAll(" ", "%20") + "&Facolta=" + (elencoParametri.get(5)).replaceAll(" ", "%20") + "&TipoLaurea=" + (elencoParametri.get(6)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
	}

	private void inserisciConvegno() {

		try {
			Connect.connectDb(Insert.INSERT_CONVEGNO+"?IDAttivita=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&NomeRelatore=" + (elencoParametri.get(1)).replaceAll(" ", "%20") + "&CognomeRelatore=" + (elencoParametri.get(2)).replaceAll(" ", "%20") + "&EmailRelatore=" + (elencoParametri.get(3)).replaceAll(" ", "%20") + "&QualificaRelatore=" + (elencoParametri.get(4)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private void inserisciAula() {
		
		try {
			Connect.connectDb(Insert.INSERT_AULA+"?edificio=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&numero=" + (elencoParametri.get(1)).replaceAll(" ", "%20") + "&capienza=" + elencoParametri.get(2) + "&descrizione=" + (elencoParametri.get(3)).replaceAll(" ", "%20"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}

	private void inserisciAttivita() {

		
		String url =  elencoParametri.get(6)+"-"+meseNumero(elencoParametri.get(5))+"-"+elencoParametri.get(4);
		String url2 = elencoParametri.get(9)+"-"+meseNumero(elencoParametri.get(8))+"-"+elencoParametri.get(7);
		try {
			Connect.connectDb(Insert.INSERT_ATTIVITA+"?nome=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&descrizione=" + (elencoParametri.get(1)).replaceAll(" ", "%20") + "&ore=" + elencoParametri.get(2) + "&semestre=" + elencoParametri.get(3) + "&DataInizio=" + url + "&DataFine=" + url2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private String meseNumero (String mese) {
		if (mese.equals("Gennaio"))
			return "01";
		
		if (mese.equals("Febbraio"))
			return "02";
		
		if (mese.equals("Marzo"))
			return "03";
		
		if (mese.equals("Aprile"))
			return "04";
		
		if (mese.equals("Maggio"))
			return "05";
		
		if (mese.equals("Giugno"))
			return "06";
		
		if (mese.equals("Luglio"))
			return "07";
		
		if (mese.equals("Agosto"))
			return "08";
		
		if (mese.equals("Settembre"))
			return "09";
		
		if (mese.equals("Ottobre"))
			return "10";
		
		if (mese.equals("Novembre"))
			return "11";
		
		if (mese.equals("Dicembre"))
			return "12";
		
		return "00";
	}

}
