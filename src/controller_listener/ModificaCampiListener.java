package controller_listener;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import connect_to_database.Connect;
import url_php.Modifica;

public class ModificaCampiListener{
	
	private ArrayList<String> elencoParametri;
	private String tabella;

	public ModificaCampiListener(ArrayList<String> elencoParametri, String tabella) {
		// TODO Auto-generated constructor stub
		this.elencoParametri = elencoParametri;
		this.tabella = tabella;
	}

	public void modificaCampi() {
		
		// TODO Auto-generated method stub
		
		if (tabella.equals("Attività"))
			modificaAttivita();
		
		if (tabella.equals("Aula"))
			modificaAula();
	
		if (tabella.equals("Convegno"))
			modificaConvegno();
		
		if (tabella.equals("Corso di studi"))
			modificaCorsoDiStudi();
		
		if (tabella.equals("Disciplina"))
			modificaDisciplina();
		
		if (tabella.equals("Docente"))
			modificaDocente();
		
		if (tabella.equals("Esame"))
			modificaEsame();
		
		//if (tabella.equals("Fascia oraria"))

		
		if (tabella.equals("Gita"))
			modificaGita();
		
		if (tabella.equals("Insegna"))
			modificaInsegna();
		
		if (tabella.equals("Piano di studio"))
			modificaPianoDiStudio();
		
		if (tabella.equals("Preferenza aula"))
			modificaPreferenzaAula();
		
		if (tabella.equals("Preferenza fascia oraria"))
			modificaPreferenzaFasciaOraria();
		
		if (tabella.equals("Studente"))
			modificaStudente();
		
		if (tabella.equals("Tirocinio"))
			modificaTirocinio();
		
	}

	private void modificaAttivita() {
		// TODO Auto-generated method stub
		String url =  elencoParametri.get(7)+"-"+meseNumero(elencoParametri.get(6))+"-"+elencoParametri.get(5);
		String url2 = elencoParametri.get(10)+"-"+meseNumero(elencoParametri.get(9))+"-"+elencoParametri.get(8);
		try {
			Connect.connectDb(Modifica.MODIFICA_ATTIVITA+"?IDAttivita="+ elencoParametri.get(0)+ "&Nome="+ (elencoParametri.get(1).replaceAll(" ", "%20"))+ "&Descrizione="+ (elencoParametri.get(2).replaceAll(" ", "%20"))+ "&Ore="+ elencoParametri.get(3)+ "&Semestre=" +elencoParametri.get(4)+ "&DataInizio=" + url + "&DataFine=" + url2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private void modificaAula(){
		try {
			Connect.connectDb(Modifica.MODIFICA_AULA+"?Edificio=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&Numero=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&Capienza=" + (elencoParametri.get(2).replaceAll(" ", "%20")) + "&Descrizione=" + (elencoParametri.get(3).replaceAll(" ", "%20")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void modificaConvegno(){
		try {
			Connect.connectDb(Modifica.MODIFICA_CONVEGNO+"?IDConvegno=" + (elencoParametri.get(0)).replaceAll(" ", "%20") + "&IDAttivita=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&NomeRelatore=" + (elencoParametri.get(2).replaceAll(" ", "%20"))+ "&CognomeRelatore=" + (elencoParametri.get(3).replaceAll(" ", "%20")) + "&EmailRelatore=" + (elencoParametri.get(4).replaceAll(" ", "%20")) + "&QualificaRelatore=" + (elencoParametri.get(5).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void modificaCorsoDiStudi(){
		try {
			Connect.connectDb(Modifica.MODIFICA_CORSODISTUDI+"?IDCorsoDiStudi="+ (elencoParametri.get(0)).replaceAll(" ", "%20") + "&Nome=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&Descrizione=" + (elencoParametri.get(2).replaceAll(" ", "%20"))+ "&TotaleCrediti=" + (elencoParametri.get(3).replaceAll(" ", "%20")) + "&Anno=" + (elencoParametri.get(4).replaceAll(" ", "%20")) + "&Facolta=" + (elencoParametri.get(6).replaceAll(" ", "%20")) + "&Indirizzo=" + (elencoParametri.get(5).replaceAll(" ", "%20")) + "&TipoLaurea=" + (elencoParametri.get(7).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void modificaDisciplina() {
		try {
			Connect.connectDb(Modifica.MODIFICA_DISCIPLINA+"?IDDisciplina=" + (elencoParametri.get(0).replaceAll(" ", "%20")) + "&IDAttivita=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&Crediti=" + (elencoParametri.get(2).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void modificaDocente(){
		try {
			Connect.connectDb(Modifica.MODIFICA_DOCENTE+"?Matricola="+ (elencoParametri.get(0)).replaceAll(" ", "%20") + "&Nome=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&Cognome=" + (elencoParametri.get(2).replaceAll(" ", "%20"))+ "&Email=" + (elencoParametri.get(3).replaceAll(" ", "%20")) + "&Qualifica=" + (elencoParametri.get(4).replaceAll(" ", "%20")) + "&Associato=" + (elencoParametri.get(5).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void modificaEsame(){
		try {
			Connect.connectDb(Modifica.MODIFICA_ESAME+"?IDEsame="+ (elencoParametri.get(0)).replaceAll(" ", "%20") + "&IDAttivita=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&Tipologia=" + (elencoParametri.get(2).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void modificaGita(){
		//System.out.println("Sono Arrivato");
		try {
			Connect.connectDb(Modifica.MODIFICA_GITA+"?IDGita="+ (elencoParametri.get(0)).replaceAll(" ", "%20") + "&IDAttivita=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&Luogo=" + (elencoParametri.get(2).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void modificaInsegna(){
		try {
			Connect.connectDb(Modifica.MODIFICA_INSEGNA+"?Matricola="+ (elencoParametri.get(0)).replaceAll(" ", "%20") + "IDAttivita=" + (elencoParametri.get(1).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void modificaPianoDiStudio(){
		try {
			Connect.connectDb(Modifica.MODIFICA_PIANODISTUDIO+"?IDCorsoDiStudi="+ (elencoParametri.get(0)).replaceAll(" ", "%20") + "&IDAttivita=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&Opzionale=" + (elencoParametri.get(2).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void modificaPreferenzaAula(){
		try {
			Connect.connectDb(Modifica.MODIFICA_PREFERENZAAULA+"?Matricola="+ (elencoParametri.get(0)).replaceAll(" ", "%20") + "&Edificio=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&Numero=" + (elencoParametri.get(2).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void modificaPreferenzaFasciaOraria(){
		try {
			Connect.connectDb(Modifica.MODIFICA_PREFERENZAFASCIAORARIA+"?Matricola="+ (elencoParametri.get(0)).replaceAll(" ", "%20") + "&IDFasciaOraria=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&Priorita=" + (elencoParametri.get(2).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void modificaStudente(){
		
		
		
		String data = elencoParametri.get(6)+"-"+meseNumero(elencoParametri.get(5))+"-"+elencoParametri.get(4);
		try {
			Connect.connectDb(Modifica.MODIFICA_STUDENTE+"?Matricola="+ (elencoParametri.get(0)).replaceAll(" ", "%20") + "&Nome=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&Cognome=" + (elencoParametri.get(2).replaceAll(" ", "%20"))+ "&DataNascita=" + (data.replaceAll(" ", "%20")) + "&AnnoIscrizione=" + (elencoParametri.get(7).replaceAll(" ", "%20")) + "&Email=" + (elencoParametri.get(3).replaceAll(" ", "%20")) + "&IDCorsoDiStudi=" + (elencoParametri.get(8).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void modificaTirocinio(){
		try {
			Connect.connectDb(Modifica.MODIFICA_TIROCINIO+"?IDTirocinio="+ (elencoParametri.get(0)).replaceAll(" ", "%20") + "&IDAttivita=" + (elencoParametri.get(1).replaceAll(" ", "%20")) + "&NomeAzienda=" + (elencoParametri.get(2).replaceAll(" ", "%20"))+ "&DescrizioneAzienda=" + (elencoParametri.get(3).replaceAll(" ", "%20")) + "&EmailAzienda=" + (elencoParametri.get(4).replaceAll(" ", "%20")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
