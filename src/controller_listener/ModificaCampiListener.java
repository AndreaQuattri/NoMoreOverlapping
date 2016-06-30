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
		
		int daCancellare = 1;
		
		if (tabella.equals("Attività"))
			modificaAttivita();
		
		if (tabella.equals("Aula"))
			modificaAula();
	
		if (tabella.equals("Convegno"))
		
		if (tabella.equals("Corso di studi"))
		
		if (tabella.equals("Disciplina"))
		
		if (tabella.equals("Docente"))
		
		if (tabella.equals("Esame"))
		
		if (tabella.equals("Fascia oraria"))
		
		if (tabella.equals("Gita"))
		
		if (tabella.equals("Insegna"))
		
		if (tabella.equals("Piano di studio"))
		
		if (tabella.equals("Preferenza aula"))
		
		if (tabella.equals("Preferenza fascia oraria"))
		
		if (tabella.equals("Studente"))
		
		if (tabella.equals("Tirocinio"))
			daCancellare = 1;
			
	}

	private void modificaAula() {
		// TODO Auto-generated method stub
		
	}

	private void modificaAttivita() {
		// TODO Auto-generated method stub
		String url =  elencoParametri.get(7)+"-"+elencoParametri.get(6)+"-"+elencoParametri.get(5);
		String url2 = elencoParametri.get(10)+"-"+elencoParametri.get(9)+"-"+elencoParametri.get(8);
		try {
			Connect.connectDb(Modifica.MODIFICA_ATTIVITA+"?IDAttivita=" + elencoParametri.get(0) + "&Nome=" + (elencoParametri.get(1)).replaceAll(" ", "%20") + "&Descrizione=" + (elencoParametri.get(2)).replaceAll(" ", "%20") + "&Ore=" + elencoParametri.get(3) + "&Semestre=" + elencoParametri.get(4) + "&DataInizio=" + url + "&DataFine=" + url2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
