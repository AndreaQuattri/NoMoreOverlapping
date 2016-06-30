package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import connect_to_database.Connect;
import controller_listener.ModificaCampiListener;
import url_php.GiveAll;

@SuppressWarnings("deprecation")
public class ManagementTableView extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JButton modificaButton;


	public ManagementTableView(String tabella, String record) throws IOException, URISyntaxException
	{

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 80, 700, 500);
		
		modificaButton = new JButton ("Modifica");
		modificaButton.setBounds(280, 420, 200, 29);
		
		
		
		if (tabella.equals("Attività"))
			initAttività(record);
		
		
		if (tabella.equals("Aula"))
			initAula(record);
	
		if (tabella.equals("Convegno"))
			initConvegno(record);
		
		if (tabella.equals("Corso di studi"))
			initCorsoDiStudi(record);
		
		if (tabella.equals("Disciplina"))
			initDisciplina(record);
		
		if (tabella.equals("Docente"))
			initDocente(record);
		
		if (tabella.equals("Esame"))
			initEsame(record);
		
		if (tabella.equals("Fascia oraria"))
			initFasciaOraria(record);
		
		if (tabella.equals("Gita"))
			initGita(record);
		
		if (tabella.equals("Insegna"))
			initInsegna(record);
		
		if (tabella.equals("Piano di studio"))
			initPianoDiStudio(record);
		
		if (tabella.equals("Preferenza aula"))
			initPreferenzaAula(record);
		
		if (tabella.equals("Preferenza fascia oraria"))
			initPreferenzaFasciaOraria(record);
		
		if (tabella.equals("Studente"))
			initStudente(record);
		
		if (tabella.equals("Tirocinio"))
			initTirocinio(record);

		
		getContentPane().setLayout(null);
		getContentPane().add(modificaButton);
		
		
	}
	
	private void initAttività(String record) throws IOException, URISyntaxException{
		JLabel labelID = new JLabel("ID Attività");
		labelID.setBounds(69, 81, 117, 29);
		final JTextField id = new JTextField();
		id.setBounds(250, 81, 400, 29);
		id.enable(false);
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(69, 121, 117, 29);
		final JTextField nome = new JTextField();
		nome.setBounds(250, 121, 400, 29);
		JLabel labelDescrizione = new JLabel ("Descrizione");
		labelDescrizione.setBounds(69, 161, 117, 29);
		final JTextField descrizione = new JTextField();
		descrizione.setBounds(250, 161, 400, 29);
		JLabel labelOre = new JLabel("Ore");
		labelOre.setBounds(69, 201, 117, 29);
		final JTextField ore = new JTextField();
		ore.setBounds(250, 201, 400, 29);
		JLabel labelSemestre = new JLabel("Semestre");
		labelSemestre.setBounds(69, 241, 117, 29);
		final JComboBox semestre = new JComboBox();
		semestre.setBounds(250, 241, 400, 29);
		semestre.addItem("1");
		semestre.addItem("2");
		JLabel labelDataInizio = new JLabel("Data Inizio");
		labelDataInizio.setBounds(69, 281, 117, 29);
		final JComboBox giornoInizio = new JComboBox();
		giornoInizio.setBounds(250, 281, 100, 29);
		final JComboBox meseInizio = new JComboBox();
		meseInizio.setBounds(400, 281, 100, 29);
		final JComboBox annoInizio = new JComboBox();
		annoInizio.setBounds(550, 281, 100, 29);
		JLabel labelDataFine = new JLabel("Data Fine");
		labelDataFine.setBounds(69, 321, 117, 29);
		final JComboBox giornoFine = new JComboBox();
		giornoFine.setBounds(250, 321, 100, 29);
		final JComboBox meseFine = new JComboBox();
		meseFine.setBounds(400, 321, 100, 29);
		final JComboBox annoFine = new JComboBox();
		annoFine.setBounds(550, 321, 100, 29);
		

		String spRecord[] = record.split(",");
		semestre.setEditable(true);
		giornoInizio.setEditable(true);
		meseInizio.setEditable(true);
		annoInizio.setEditable(true);
		giornoFine.setEditable(true);
		meseFine.setEditable(true);
		annoFine.setEditable(true);
		
		for (int i=1; i<=31;i++){
			giornoInizio.addItem(i);
			giornoFine.addItem(i);
		}
		
			meseInizio.addItem("Gennaio");
			meseInizio.addItem("Febbraio");
			meseInizio.addItem("Marzo");
			meseInizio.addItem("Aprile");
			meseInizio.addItem("Maggio");
			meseInizio.addItem("Giugno");
			meseInizio.addItem("Luglio");
			meseInizio.addItem("Agosto");
			meseInizio.addItem("Settembre");
			meseInizio.addItem("Ottobre");
			meseInizio.addItem("Novembre");
			meseInizio.addItem("Dicembre");
			meseFine.addItem("Gennaio");
			meseFine.addItem("Febbraio");
			meseFine.addItem("Marzo");
			meseFine.addItem("Aprile");
			meseFine.addItem("Maggio");
			meseFine.addItem("Giugno");
			meseFine.addItem("Luglio");
			meseFine.addItem("Agosto");
			meseFine.addItem("Settembre");
			meseFine.addItem("Ottobre");
			meseFine.addItem("Novembre");
			meseFine.addItem("Dicembre");
		
		
		for (int j=2016; j<=2100; j++){
			annoInizio.addItem(j);
			annoFine.addItem(j);
		}
		
		
			String spDataInizio[] = spRecord[5].split("-");
			//String spGiorno = spDataInizio[2];
			//String spMese = spDataInizio[1];
			//String spAnno = spDataInizio[0];
			String spDataFine[] = spRecord[6].split("-");
			//String spGio = spDataFine[2];
			//String spMe = spDataFine[1];
			//String spAn = spDataFine[0];
			
		
			id.setText(spRecord[0]);
			nome.setText(spRecord[1]);
			descrizione.setText(spRecord[2]);
			ore.setText(spRecord[3]);
			semestre.setSelectedItem(spRecord[4]);
			giornoInizio.setSelectedItem(spDataInizio[2]);
			meseInizio.setSelectedItem(convertiMese(spDataInizio[1]));
			annoInizio.setSelectedItem(spDataInizio[0]);
			giornoFine.setSelectedItem(spDataFine[2]);
			meseFine.setSelectedItem(convertiMese(spDataFine[1]));
			annoFine.setSelectedItem(spDataFine[0]);
			
		
		
		
		
		getContentPane().add(labelID);
		getContentPane().add(labelNome);
		getContentPane().add(labelDescrizione);
		getContentPane().add(labelOre);
		getContentPane().add(labelSemestre);
		getContentPane().add(labelDataInizio);
		getContentPane().add(labelDataFine);
		getContentPane().add(id);
		getContentPane().add(nome);
		getContentPane().add(descrizione);
		getContentPane().add(ore);
		getContentPane().add(semestre);
		getContentPane().add(giornoInizio);
		getContentPane().add(meseInizio);
		getContentPane().add(annoInizio);
		getContentPane().add(giornoFine);
		getContentPane().add(meseFine);
		getContentPane().add(annoFine);
		
		
		
		
		modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(id.getText().trim());
				elencoParametri.add(nome.getText().trim());
				elencoParametri.add(descrizione.getText().trim());
				elencoParametri.add(ore.getText().trim());
				elencoParametri.add(semestre.getSelectedItem().toString().trim());
				elencoParametri.add(giornoInizio.getSelectedItem().toString().trim());
				elencoParametri.add(meseInizio.getSelectedItem().toString().trim());
				elencoParametri.add(annoInizio.getSelectedItem().toString().trim());
				elencoParametri.add(giornoFine.getSelectedItem().toString().trim());
				elencoParametri.add(meseFine.getSelectedItem().toString().trim());
				elencoParametri.add(annoFine.getSelectedItem().toString().trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Attività");
				modificaCampi.modificaCampi();
			}
		});
		
	}
	
	private void initAula(String record){
		JLabel labelEdificio = new JLabel("Edificio");
		labelEdificio.setBounds(69, 71, 117, 29);
		final JTextField edificio = new JTextField();
		edificio.setBounds(250, 71, 400, 29);
		edificio.enable(false);
		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setBounds(69, 111, 117, 29);
		final JTextField numero = new JTextField();
		numero.setBounds(250, 111, 400, 29);
		numero.enable(false);
		JLabel labelCapienza = new JLabel ("Capienza");
		labelCapienza.setBounds(69, 151, 117, 29);
		final JTextField capienza = new JTextField();
		capienza.setBounds(250, 151, 400, 29);
		JLabel labelDescrizione = new JLabel("Descrizione");
		labelDescrizione.setBounds(69, 191, 117, 29);
		final JTextField descrizione = new JTextField();
		descrizione.setBounds(250, 191, 400, 29);
		
		String spRecord[] = record.split(",");
		edificio.setText(spRecord[0]);
		numero.setText(spRecord[1]);
		capienza.setText(spRecord[2]);
		descrizione.setText(spRecord[3]);
		
		
		getContentPane().add(labelEdificio);
		getContentPane().add(labelNumero);
		getContentPane().add(labelCapienza);
		getContentPane().add(labelDescrizione);
		getContentPane().add(edificio);
		getContentPane().add(numero);
		getContentPane().add(capienza);
		getContentPane().add(descrizione);
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(edificio.getText().trim());
				elencoParametri.add(numero.getText().trim());
				elencoParametri.add(capienza.getText().trim());
				elencoParametri.add(descrizione.getText().trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Aula");
				modificaCampi.modificaCampi();
			}
		});

	}
	
	private void initConvegno(String record) throws IOException, URISyntaxException{
		JLabel labelIDConvegno = new JLabel("ID Convegno");
		labelIDConvegno.setBounds(69, 71, 117, 29);
		final JTextField idConvegno = new JTextField();
		idConvegno.setBounds(250, 71, 400, 29);
		idConvegno.enable(false);
		JLabel labelIDAttività = new JLabel("ID Attività");
		labelIDAttività.setBounds(69, 111, 117, 29);
		final JComboBox idAttività = new JComboBox();
		idAttività.setBounds(250, 111, 400, 29);
		JLabel labelNomeRelatore = new JLabel ("Nome Relatore");
		labelNomeRelatore.setBounds(69, 151, 117, 29);
		final JTextField nomeRelatore = new JTextField();
		nomeRelatore.setBounds(250, 151, 400, 29);
		JLabel labelCognomeRelatore = new JLabel("Cognome Relatore");
		labelCognomeRelatore.setBounds(69, 191, 117, 29);
		final JTextField cognomeRelatore = new JTextField();
		cognomeRelatore.setBounds(250, 191, 400, 29);
		JLabel labelEmailRelatore = new JLabel("Email Relatore");
		labelEmailRelatore.setBounds(69, 231, 117, 29);
		final JTextField emailRelatore = new JTextField();
		emailRelatore.setBounds(250, 231, 400, 29);
		JLabel labelQualificaRelatore = new JLabel("Qualifica Relatore");
		labelQualificaRelatore.setBounds(69, 271, 117, 29);
		final JTextField qualificaRelatore = new JTextField();
		qualificaRelatore.setBounds(250, 271, 400, 29);
		
		String spRecord[] = record.split(",");
		String attivitàConnect = Connect.connectDb(GiveAll.giveAllAttività);
		String convegno = Connect.connectDb(GiveAll.giveAllConvegno);
		String spConvegno[] = convegno.split("_");
		String spAttività[] = attivitàConnect.split("_");
		
		int j=0;
		
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			idAttività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		} 
		
		idAttività.setEditable(true);
		idConvegno.setText(spRecord[0]);
		
		 while (j != spConvegno.length) {
			String x = spConvegno[j];
			String spConvegnoColonne[] = x.split(",");
			if (spConvegnoColonne[0].equals(spRecord[0])){
			idAttività.setSelectedItem(spConvegnoColonne[1]);
			}
			j++;
		}
		nomeRelatore.setText(spRecord[7]);
		cognomeRelatore.setText(spRecord[8]);
		emailRelatore.setText(spRecord[9]);
		qualificaRelatore.setText(spRecord[10]);
		
		getContentPane().add(labelIDConvegno);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelNomeRelatore);
		getContentPane().add(labelCognomeRelatore);
		getContentPane().add(labelEmailRelatore);
		getContentPane().add(labelQualificaRelatore);
		getContentPane().add(idConvegno);
		getContentPane().add(idAttività);
		getContentPane().add(nomeRelatore);
		getContentPane().add(cognomeRelatore);
		getContentPane().add(emailRelatore);
		getContentPane().add(qualificaRelatore);
		
		final String id[] =  ((String) idAttività.getSelectedItem()).split(",");
		
		modificaButton.addActionListener(new ActionListener() {
					
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<String> elencoParametri = new ArrayList <String>();
			elencoParametri.add(idConvegno.getText().trim());
			elencoParametri.add(id[0].trim());
			elencoParametri.add(nomeRelatore.getText().trim());
			elencoParametri.add(cognomeRelatore.getText().trim());
			elencoParametri.add(emailRelatore.getText().trim());
			elencoParametri.add(qualificaRelatore.getText().trim());
			ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Convegno");
			modificaCampi.modificaCampi();
		}
	});
		
	}
	
	private void initCorsoDiStudi(String record){
		JLabel labelID = new JLabel("ID Corso Di Studi");
		labelID.setBounds(69, 71, 117, 29);
		final JTextField id = new JTextField();
		id.setBounds(250, 71, 400, 29);
		id.enable(false);
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(69, 111, 117, 29);
		final JTextField nome = new JTextField();
		nome.setBounds(250, 111, 400, 29);
		JLabel labelDescrizione = new JLabel ("Descrizione");
		labelDescrizione.setBounds(69, 151, 117, 29);
		final JTextField descrizione = new JTextField();
		descrizione.setBounds(250, 151, 400, 29);
		JLabel labelTotaleCrediti = new JLabel("Totale Crediti");
		labelTotaleCrediti.setBounds(69, 191, 117, 29);
		final JTextField crediti = new JTextField();
		crediti.setBounds(250, 191, 400, 29);
		JLabel labelAnno = new JLabel("Anno");
		labelAnno.setBounds(69, 231, 117, 29);
		final JComboBox anno = new JComboBox();
		anno.setBounds(250, 231, 400, 29);
		JLabel labelIndirizzo = new JLabel("Indirizzo");
		labelIndirizzo.setBounds(69, 271, 117, 29);
		final JComboBox indirizzo = new JComboBox();
		indirizzo.setBounds(250, 271, 400, 29);
		JLabel labelfacoltà = new JLabel("Facolt�");
		labelfacoltà.setBounds(69, 311, 117, 29);
		final JTextField facoltà = new JTextField();
		facoltà.setBounds(250, 311, 400, 29);
		JLabel labelTipoLaurea = new JLabel ("Tipo Laurea");
		labelTipoLaurea.setBounds(69, 351, 117, 29);
		final JComboBox laurea = new JComboBox();
		laurea.setBounds(250, 351, 400, 29);
		
		String spRecord[] = record.split(",");
		anno.setEditable(true);
		indirizzo.setEditable(true);
		laurea.setEditable(true);
		id.setText(spRecord[0]);
		nome.setText(spRecord[1]);
		descrizione.setText(spRecord[2]);
		crediti.setText(spRecord[3]);
		anno.setSelectedItem(spRecord[4]);
		indirizzo.setSelectedItem(spRecord[5]);
		facoltà.setText(spRecord[6]);
		laurea.setSelectedItem(spRecord[7]);
		
		anno.addItem("1");
		anno.addItem("2");
		anno.addItem("3");

		
		indirizzo.addItem("Informatica Industriale");
		indirizzo.addItem("Informatica Meccatronica");
		indirizzo.addItem("Informatica Sistemi In Rete");
		indirizzo.addItem("Informatica");
		indirizzo.addItem("Gestionale");
		indirizzo.addItem("Tessile");
		indirizzo.addItem("Edile");
		indirizzo.addItem("Meccanica");
		indirizzo.addItem("Tecnologie Per La Salute");
		
		laurea.addItem("Triennale");
		laurea.addItem("Magistrale");
		
		getContentPane().add(labelID);
		getContentPane().add(labelNome);
		getContentPane().add(labelDescrizione);
		getContentPane().add(labelTotaleCrediti);
		getContentPane().add(labelAnno);
		getContentPane().add(labelIndirizzo);
		getContentPane().add(labelfacoltà);
		getContentPane().add(labelTipoLaurea);
		getContentPane().add(id);
		getContentPane().add(nome);
		getContentPane().add(descrizione);
		getContentPane().add(crediti);
		getContentPane().add(anno);
		getContentPane().add(indirizzo);
		getContentPane().add(facoltà);
		getContentPane().add(laurea);
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(id.getText().trim());
				elencoParametri.add(nome.getText().trim());
				elencoParametri.add(descrizione.getText().trim());
				elencoParametri.add(crediti.getText().trim());
				elencoParametri.add(((String) anno.getSelectedItem()).trim());
				elencoParametri.add(((String) indirizzo.getSelectedItem()).trim());
				elencoParametri.add((facoltà.getText()).trim());
				elencoParametri.add(((String) laurea.getSelectedItem()).trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Corso di studi");
				modificaCampi.modificaCampi();
			}
		});
	}
	
	private void initDisciplina(String record) throws IOException, URISyntaxException{
		JLabel labelIDDisciplina = new JLabel("ID Disciplina");
		labelIDDisciplina.setBounds(69, 71, 117, 29);
		final JTextField idDisciplina = new JTextField();
		idDisciplina.setBounds(250, 71, 400, 29);
		idDisciplina.enable(false);
		JLabel labelIDAttività = new JLabel("ID Attività");
		labelIDAttività.setBounds(69, 111, 117, 29);
		final JComboBox idAttività = new JComboBox();
		idAttività.setBounds(250, 111, 400, 29);
		JLabel labelCrediti = new JLabel ("Crediti");
		labelCrediti.setBounds(69, 151, 117, 29);
		final JTextField crediti = new JTextField();
		crediti.setBounds(250, 151, 400, 29);
		
		String attivitàConnect = Connect.connectDb(GiveAll.giveAllAttività);
		String disciplina = Connect.connectDb(GiveAll.giveAllDisciplina);
		String spAttività[] = attivitàConnect.split("_");
		String spDisciplina[] = disciplina.split("_");
		int j=0;
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			idAttività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}
		
		String spRecord[] = record.split(",");
		idAttività.setEditable(true);
		idDisciplina.setText(spRecord[0]);
		while (j != spDisciplina.length) {
			String x = spDisciplina[j];
			String spDisciplinaColonne[] = x.split(",");
			if (spDisciplinaColonne[0].equals(spRecord[0])){
			idAttività.setSelectedItem(spDisciplinaColonne[1]);
			}
			j++;
		}
		crediti.setText(spRecord[7]);
		
		getContentPane().add(labelIDDisciplina);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelCrediti);
		getContentPane().add(idDisciplina);
		getContentPane().add(idAttività);
		getContentPane().add(crediti);
		
		final String id[] = ((String) idAttività.getSelectedItem()).split(",");
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(idDisciplina.getText().trim());
				elencoParametri.add(id[0].trim());
				elencoParametri.add(crediti.getText().trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Disciplina");
				modificaCampi.modificaCampi();
			}
		});
	}
	
	private void initDocente(String record){
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		final JTextField matricola = new JTextField();
		matricola.setBounds(250, 71, 400, 29);
		matricola.enable(false);
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(69, 111, 117, 29);
		final JTextField nome = new JTextField();
		nome.setBounds(250, 111, 400, 29);
		JLabel labelCognome = new JLabel ("Cognome");
		labelCognome.setBounds(69, 151, 117, 29);
		final JTextField cognome = new JTextField();
		cognome.setBounds(250, 151, 400, 29);
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(69, 191, 117, 29);
		final JTextField email = new JTextField();
		email.setBounds(250, 191, 400, 29);
		JLabel labelQualifica = new JLabel("Qualifica");
		labelQualifica.setBounds(69, 231, 117, 29);
		final JTextField qualifica = new JTextField();
		qualifica.setBounds(250, 231, 400, 29);
		JLabel labelAssociato = new JLabel("Associato");
		labelAssociato.setBounds(69, 271, 117, 29);
		final JComboBox associato = new JComboBox();
		associato.setBounds(250, 271, 400, 29);
		
		String spRecord[] = record.split(",");
		associato.setEditable(true);
		matricola.setText(spRecord[0]);
		nome.setText(spRecord[1]);
		cognome.setText(spRecord[2]);
		email.setText(spRecord[3]);
		qualifica.setText(spRecord[4]);
		associato.setSelectedItem(spRecord[5]);
		
		associato.addItem("0");
		associato.addItem("1");
		
		getContentPane().add(labelMatricola);
		getContentPane().add(labelNome);
		getContentPane().add(labelCognome);
		getContentPane().add(labelEmail);
		getContentPane().add(labelQualifica);
		getContentPane().add(labelAssociato);
		getContentPane().add(matricola);
		getContentPane().add(nome);
		getContentPane().add(cognome);
		getContentPane().add(email);
		getContentPane().add(qualifica);
		getContentPane().add(associato);
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(matricola.getText().trim());
				elencoParametri.add(nome.getText().trim());
				elencoParametri.add(cognome.getText().trim());
				elencoParametri.add(email.getText().trim());
				elencoParametri.add(qualifica.getText().trim());
				elencoParametri.add(((String) associato.getSelectedItem()).trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Docente");
				modificaCampi.modificaCampi();
			}
		});
	}
	
	private void initEsame(String record) throws IOException, URISyntaxException{
		JLabel labelIDEsame = new JLabel("ID Esame");
		labelIDEsame.setBounds(69, 71, 117, 29);
		final JTextField idEsame = new JTextField();
		idEsame.setBounds(250, 71, 400, 29);
		idEsame.enable(false);
		JLabel labelIDAttività = new JLabel("IDAttività");
		labelIDAttività.setBounds(69, 111, 117, 29);
		final JComboBox idAttività = new JComboBox();
		idAttività.setBounds(250, 111, 400, 29);
		JLabel labelTipologia = new JLabel ("Tipologia");
		labelTipologia.setBounds(69, 151, 117, 29);
		final JComboBox tipologia = new JComboBox();
		tipologia.setBounds(250, 151, 400, 29);
		
		String spRecord[] = record.split(",");
		String attività = Connect.connectDb(GiveAll.giveAllAttività);
		String esame = Connect.connectDb(GiveAll.giveAllEsame);
		String spAttività[] = attività.split("_");
		String spEsame[] = esame.split("_");
		int j=0;
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			idAttività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}
		
		idAttività.setEditable(true);
		while (j != spEsame.length) {
			String x = spEsame[j];
			String spEsameColonne[] = x.split(",");
			if (spEsameColonne[0].equals(spRecord[0])){
			idAttività.setSelectedItem(spEsameColonne[1]);
			}
			j++;
		}
		

		tipologia.setEditable(true);
		idEsame.setText(spRecord[0]);
		tipologia.setSelectedItem(spRecord[7]);
		
		tipologia.addItem("Scritto");
		tipologia.addItem("Orale");
		tipologia.addItem("ScrittoOrale");
		
		getContentPane().add(labelIDEsame);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelTipologia);
		getContentPane().add(idEsame);
		getContentPane().add(idAttività);
		getContentPane().add(tipologia);
		
		final String id[] = ((String) idAttività.getSelectedItem()).split(",");
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(idEsame.getText().trim());;
				elencoParametri.add(id[0].trim());
				elencoParametri.add(((String) tipologia.getSelectedItem()).trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Esame");
				modificaCampi.modificaCampi();
			}
		});
	}
	
	private void initFasciaOraria(String record){
		JLabel labelID = new JLabel("ID Fascia Oraria");
		labelID.setBounds(69, 71, 117, 29);
		final JTextField id = new JTextField();
		id.setBounds(250, 71, 400, 29);
		id.enable(false);
		JLabel labelGiorno = new JLabel("Giorno");
		labelGiorno.setBounds(69, 111, 117, 29);
		final JComboBox giorno = new JComboBox();
		giorno.setBounds(250, 111, 400, 29);
		giorno.enable(false);
		JLabel labelOraInizio = new JLabel ("Ora Inizio");
		labelOraInizio.setBounds(69, 151, 117, 29);
		final JTextField oInizio = new JTextField();
		oInizio.setBounds(250, 151, 400, 29);
		oInizio.enable(false);
		JLabel labelOraFine = new JLabel("Ora Fine");
		labelOraFine.setBounds(69, 191, 117, 29);
		final JTextField oFine = new JTextField();
		oFine.setBounds(250, 191, 400, 29);
		oFine.enable(false);
		
		String spRecord[] = record.split(",");
		giorno.setEditable(true);
		id.setText(spRecord[0]);
		giorno.setSelectedItem(spRecord[1]);
		oInizio.setText(spRecord[2]);
		oFine.setText(spRecord[3]);
		
		giorno.addItem("Luned�");
		giorno.addItem("Marted�");
		giorno.addItem("Mercoled�");
		giorno.addItem("Gioved�");
		giorno.addItem("Venerd�");
		giorno.addItem("Sabato");
		
		getContentPane().add(labelID);
		getContentPane().add(labelGiorno);
		getContentPane().add(labelOraInizio);
		getContentPane().add(labelOraFine);
		getContentPane().add(id);
		getContentPane().add(giorno);
		getContentPane().add(oInizio);
		getContentPane().add(oFine);
	}
	
	private void initGita(String record) throws IOException, URISyntaxException{
		JLabel labelIDGita = new JLabel("ID Gita");
		labelIDGita.setBounds(69, 71, 117, 29);
		final JTextField gita = new JTextField();
		gita.setBounds(250, 71, 400, 29);
		gita.enable(false);
		JLabel labelIDAttività = new JLabel("IDAttività");
		labelIDAttività.setBounds(69, 111, 117, 29);
		final JComboBox attività = new JComboBox();
		attività.setBounds(250, 111, 400, 29);
		JLabel labelLuogo = new JLabel ("Luogo");
		labelLuogo.setBounds(69, 151, 117, 29);
		final JTextField luogo = new JTextField();
		luogo.setBounds(250, 151, 400, 29);
		
		String spRecord[] = record.split(",");
		String attivitàConnect = Connect.connectDb(GiveAll.giveAllAttività);
		String gitaConnect = Connect.connectDb(GiveAll.giveAllGita);
		String spAttività[] = attivitàConnect.split("_");
		String spGita[] = gitaConnect.split("_");
		int j=0;
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			attività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}
		
		attività.setEditable(true);
		while (j != spGita.length) {
			String x = spGita[j];
			String spGitaColonne[] = x.split(",");
			if (spGitaColonne[0].equals(spRecord[0])){
			attività.setSelectedItem(spGitaColonne[1]);
			}
			j++;
		}
		gita.setText(spRecord[0]);
		luogo.setText(spRecord[7]);
		
		getContentPane().add(labelIDGita);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelLuogo);
		getContentPane().add(gita);
		getContentPane().add(attività);
		getContentPane().add(luogo);
		
		final String id[] = ((String) attività.getSelectedItem()).split(",");
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(gita.getText().trim());
				elencoParametri.add(id[0].trim());
				elencoParametri.add(luogo.getText().trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Gita");
				modificaCampi.modificaCampi();
			}
		});
	}
	
	private void initInsegna(String record) throws IOException, URISyntaxException{
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		final JTextField matricola = new JTextField();
		matricola.setBounds(250, 71, 400, 29);
		matricola.enable(false);
		JLabel labelID = new JLabel("ID Attività");
		labelID.setBounds(69, 111, 117, 29);
		final JComboBox attività = new JComboBox();
		attività.setBounds(250, 111, 400, 29);
		
		String spRecord[] = record.split(",");
		String attivitàConnect = Connect.connectDb(GiveAll.giveAllAttività);
		String insegna = Connect.connectDb(GiveAll.giveAllInsegna);
		String spAttività[] = attivitàConnect.split("_");
		String spInsegna[] = insegna.split("_");
		String spAttivitàColonne[] = null;
		String spInsegnaColonne[] = null;
		int j=0;
		int k=0;
		
		
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			spAttivitàColonne = y.split(",");
			attività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}
		
		attività.setEditable(true);
		matricola.setText(spRecord[0]);
		
		
		getContentPane().add(labelMatricola);
		getContentPane().add(labelID);
		getContentPane().add(matricola);
		getContentPane().add(attività);
		
		while (true){
			
		while (j < spInsegna.length) {
			String x = spInsegna[j];
			spInsegnaColonne = x.split(",");
			if (spInsegnaColonne[0].equals(spRecord[0]))
					break;
			j++;
		}
			
			if (j == spInsegna.length)
				return;
			j++;
			
			for (k=0; k < spAttività.length; k++){
				String y = spAttività[k];
				spAttivitàColonne = y.split(",");
				if (spAttivitàColonne[0].equals(spInsegnaColonne[1]))
					break;
			}
			
			if (k == spAttività.length)
				return;
			k++;
			
			if (spRecord[3].trim().equals(spAttivitàColonne[1].trim())){
				attività.setSelectedItem(spInsegnaColonne[1]);
				break;
		}
		}
		
		final String id[] = ((String) attività.getSelectedItem()).split(",");
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add((matricola.getText()).trim());
				elencoParametri.add(id[0].trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Insegna");
				modificaCampi.modificaCampi();
			}
		});
	}
	
	
	private void initPianoDiStudio(String record) throws IOException, URISyntaxException{
		JLabel labelIDCorso = new JLabel("ID Corso Di Studi");
		labelIDCorso.setBounds(69, 71, 117, 29);
		final JTextField idCorso = new JTextField();
		idCorso.setBounds(250, 71, 400, 29);
		idCorso.enable(false);
		JLabel labelIDAttività = new JLabel("ID Attività");
		labelIDAttività.setBounds(69, 111, 117, 29);
		final JTextField idAttività = new JTextField();
		idAttività.setBounds(250, 111, 400, 29);
		idAttività.enable(false);
		JLabel labelOpzionale = new JLabel ("Opzionale");
		labelOpzionale.setBounds(69, 151, 117, 29);
		final JComboBox opzionale = new JComboBox();
		opzionale.setBounds(250, 151, 400, 29);
		
		String spRecord[] = record.split(",");
		String attivitàConnect = Connect.connectDb(GiveAll.giveAllAttività);
		String piano = Connect.connectDb(GiveAll.giveAllPianoDiStudio);
		String spAttività[] = attivitàConnect.split("_");
		String spPiano[] = piano.split("_");
		String spPianoColonne[] = null;
		String spAttivitàColonne[] = null;
		int j=0;
		int k=0;
		
		
		while (true){
			
			while (j < spPiano.length){
				String x = spPiano[j];
				spPianoColonne = x.split(",");
				if (spRecord[0].equals(spPianoColonne[0]))
					break;
				j++;
			}
				if (j == spPiano.length)
					return;
				j++;
			
			
			String idAttivitàPiano = spPianoColonne[1];
			for (k=0;k < spAttività.length;k++){
				String y = spAttività[k];
				spAttivitàColonne = y.split(",");
				if (idAttivitàPiano.trim().equals(spAttivitàColonne[0].trim()))
					break;
			}
				if (k == spAttività.length)
					return;
				k++;
					if (spRecord[8].trim().equals(spAttivitàColonne[1].trim())){
						idAttività.setText(spAttivitàColonne[0]);
					break;
		}
				}
		
		opzionale.setEditable(true);
		idCorso.setText(spRecord[0]);
		opzionale.setSelectedItem(spRecord[14]);
		
		
		opzionale.addItem("0");
		opzionale.addItem("1");
		
		getContentPane().add(labelIDCorso);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelOpzionale);
		getContentPane().add(idCorso);
		getContentPane().add(idAttività);
		getContentPane().add(opzionale);
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(idCorso.getText().trim());
				elencoParametri.add(idAttività.getText().trim());
				elencoParametri.add(((String) opzionale.getSelectedItem()).trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Piano di studio");
				modificaCampi.modificaCampi();
			}
		});
				
			}
	
	private void initPreferenzaAula(String record){
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		final JTextField matricola = new JTextField();
		matricola.setBounds(250, 71, 400, 29);
		matricola.enable(false);
		JLabel labelEdificio = new JLabel("Edificio");
		labelEdificio.setBounds(69, 111, 117, 29);
		final JTextField edificio = new JTextField();
		edificio.setBounds(250, 111, 400, 29);
		edificio.enable(false);
		JLabel labelNumero = new JLabel ("Numero");
		labelNumero.setBounds(69, 151, 117, 29);
		final JTextField numero = new JTextField();
		numero.setBounds(250, 151, 400, 29);
		numero.enable(false);
		
		String spRecord[] = record.split(",");
		
		matricola.setText(spRecord[0]);
		edificio.setText(spRecord[3]);
		numero.setText(spRecord[4]);
		
		getContentPane().add(labelMatricola);
		getContentPane().add(labelEdificio);
		getContentPane().add(labelNumero);
		getContentPane().add(matricola);
		getContentPane().add(edificio);
		getContentPane().add(numero);
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(matricola.getText().trim());
				elencoParametri.add(edificio.getText().trim());
				elencoParametri.add(numero.getText().trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Preferenza aula");
				modificaCampi.modificaCampi();
			}
		});
	}
	
	private void initPreferenzaFasciaOraria(String record) throws IOException, URISyntaxException{
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		final JTextField matricola = new JTextField();
		matricola.setBounds(250, 71, 400, 29);
		matricola.enable(false);
		JLabel labelID = new JLabel("ID Fascia Oraria");
		labelID.setBounds(69, 111, 117, 29);
		final JTextField id = new JTextField();
		id.setBounds(250, 111, 400, 29);
		id.enable(false);
		JLabel labelpriorità = new JLabel ("Priorit�");
		labelpriorità.setBounds(69, 151, 117, 29);
		final JComboBox priorità = new JComboBox();
		priorità.setBounds(250, 151, 400, 29);
		
		String spRecord[] = record.split(",");
		String fascia = Connect.connectDb(GiveAll.giveAllPreferenzaFasciaOraria);
		String spFascia[] = fascia.split("_");
		String oraria = Connect.connectDb(GiveAll.giveAllFasciaOraria);
		String spOraria[] = oraria.split("_");
		String spFasciaColonne[] = null;
		String spOrariaColonne[] = null;
		int j = 0;
		int k = 0;
		
		while (true) {
			
		while (j < spFascia.length) {
			String x = spFascia[j];
			spFasciaColonne = x.split(",");
			if (spRecord[0].equals(spFasciaColonne[0]))
				break;
			j++;
		}
		if (j == spFascia.length)
			return;
		j++;
		
		
		
			
		String idFasciaOrariaDocente = spFasciaColonne[1];
		while (k < spOraria.length){
			String y = spOraria[k];
			spOrariaColonne = y.split(",");
			if (idFasciaOrariaDocente.trim().equals(spOrariaColonne[0].trim()))
				break;
			k++;
		}
		
		if (k == spOraria.length)
			return;
		
		if (spRecord[3].trim().equals(spOrariaColonne[1].trim()) && spRecord[4].trim().equals(spOrariaColonne[2].trim())){
			id.setText(spOrariaColonne[0]);
			break;
		}
		}
		priorità.setEditable(true);
		matricola.setText(spRecord[0]);
		priorità.setSelectedItem(spRecord[6]);
		
		
		priorità.addItem("1");
		priorità.addItem("2");
		priorità.addItem("3");
		
		getContentPane().add(labelMatricola);
		getContentPane().add(labelID);
		getContentPane().add(labelpriorità);
		getContentPane().add(matricola);
		getContentPane().add(id);
		getContentPane().add(priorità);
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(matricola.getText().trim());
				elencoParametri.add(id.getText().trim());
				elencoParametri.add(((String) priorità.getSelectedItem()).trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Preferenza fascia oraria");
				modificaCampi.modificaCampi();
			}
		});
	}
	
	private void initStudente(String record) throws IOException, URISyntaxException{
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		final JTextField matricola = new JTextField();
		matricola.setBounds(250, 71, 400, 29);
		matricola.enable(false);
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(69, 111, 117, 29);
		final JTextField nome = new JTextField();
		nome.setBounds(250, 111, 400, 29);
		JLabel labelCognome = new JLabel ("Cognome");
		labelCognome.setBounds(69, 151, 117, 29);
		final JTextField cognome = new JTextField();
		cognome.setBounds(250, 151, 400, 29);
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(69, 191, 117, 29);
		final JTextField email = new JTextField();
		email.setBounds(250, 191, 400, 29);
		JLabel labelDataNascita = new JLabel("Data Nascita");
		labelDataNascita.setBounds(69, 231, 117, 29);
		final JComboBox giornoNascita = new JComboBox();
		giornoNascita.setBounds(250, 231, 100, 29);
		final JComboBox meseNascita = new JComboBox();
		meseNascita.setBounds(400, 231, 100, 29);
		final JComboBox annoNascita = new JComboBox();
		annoNascita.setBounds(550, 231, 100, 29);
		JLabel labelAnnoIscrizione = new JLabel("Anno Iscrizione");
		labelAnnoIscrizione.setBounds(69, 271, 117, 29);
		final JComboBox anno = new JComboBox();
		anno.setBounds(250, 271, 400, 29);
		JLabel labelID = new JLabel("ID Corso Di Studi");
		labelID.setBounds(69, 311, 117, 29);
		final JComboBox id = new JComboBox();
		id.setBounds(250, 311, 400, 29);
		
		String corso = Connect.connectDb(GiveAll.giveAllCorsoDiStudi);
		String studente = Connect.connectDb(GiveAll.giveAllStudente);
		String spCorso[] = corso.split("_");
		String spStudente[] = studente.split("_");
		int j=0;
		for (int i=0; i<spCorso.length; i++){
			String y = spCorso[i];
			String spCorsoColonne[] = y.split(",");
			id.addItem(spCorsoColonne[0]+","+spCorsoColonne[1]);
		}
		
		for (int i = 2011; i <= 2100; i++){
			anno.addItem(i);
		}
		
		for (int k=1; k<=31; k++){
			giornoNascita.addItem(k);
		}
		
		meseNascita.addItem("Gennaio");
		meseNascita.addItem("Febbraio");
		meseNascita.addItem("Marzo");
		meseNascita.addItem("Aprile");
		meseNascita.addItem("Maggio");
		meseNascita.addItem("Giugno");
		meseNascita.addItem("Luglio");
		meseNascita.addItem("Agosto");
		meseNascita.addItem("Settembre");
		meseNascita.addItem("Ottobre");
		meseNascita.addItem("Novembre");
		meseNascita.addItem("Dicembre");
		
		for (int w = 1992; w<=2100;w++){
			annoNascita.addItem(w);
		}
		
		String spRecord[] = record.split(",");
		anno.setEditable(true);
		id.setEditable(true);
		 while (j != spStudente.length) {
				String x = spStudente[j];
				String spStudenteColonne[] = x.split(",");
				if (spStudenteColonne[0].equals(spRecord[0])){
				id.setSelectedItem(spStudenteColonne[6]);
				}
				j++;
			}
		 
		giornoNascita.setEditable(true);
		meseNascita.setEditable(true);
		annoNascita.setEditable(true);
		String data[] = spRecord[4].split("-");
		matricola.setText(spRecord[0]);
		nome.setText(spRecord[1]);
		cognome.setText(spRecord[2]);
		email.setText(spRecord[3]);
		giornoNascita.setSelectedItem(data[2]);
		meseNascita.setSelectedItem(convertiMese(data[1]));
		annoNascita.setSelectedItem(data[0]);
		anno.setSelectedItem(spRecord[5]);

		getContentPane().add(labelMatricola);
		getContentPane().add(labelNome);
		getContentPane().add(labelCognome);
		getContentPane().add(labelEmail);
		getContentPane().add(labelDataNascita);
		getContentPane().add(labelAnnoIscrizione);
		getContentPane().add(labelID);
		getContentPane().add(matricola);
		getContentPane().add(nome);
		getContentPane().add(cognome);
		getContentPane().add(email);
		getContentPane().add(giornoNascita);
		getContentPane().add(meseNascita);
		getContentPane().add(annoNascita);
		getContentPane().add(anno);
		getContentPane().add(id);
		
		final String idCorso[] = ((String) id.getSelectedItem()).split(",");
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(matricola.getText().trim());
				elencoParametri.add(nome.getText().trim());
				elencoParametri.add(cognome.getText().trim());
				elencoParametri.add(email.getText().trim());
				elencoParametri.add(giornoNascita.getSelectedItem().toString().trim());
				elencoParametri.add(meseNascita.getSelectedItem().toString().trim());
				elencoParametri.add(annoNascita.getSelectedItem().toString().trim());
				elencoParametri.add(anno.getSelectedItem().toString().trim());
				elencoParametri.add(idCorso[0].trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Studente");
				modificaCampi.modificaCampi();
			}
		});
	}
	
	private void initTirocinio(String record) throws IOException, URISyntaxException{
		JLabel labelIDTirocinio = new JLabel("ID Tirocinio");
		labelIDTirocinio.setBounds(69, 71, 117, 29);
		final JTextField id = new JTextField();
		id.setBounds(250, 71, 400, 29);
		id.enable(false);
		JLabel labelIDAttività = new JLabel("ID Attività");
		labelIDAttività.setBounds(69, 111, 117, 29);
		final JComboBox attività = new JComboBox();
		attività.setBounds(250, 111, 400, 29);
		JLabel labelNomeAzienda = new JLabel ("Nome Azienda");
		labelNomeAzienda.setBounds(69, 151, 117, 29);
		final JTextField nome = new JTextField();
		nome.setBounds(250, 151, 400, 29);
		JLabel labelDescrizioneAzienda = new JLabel("Descrizione Azienda");
		labelDescrizioneAzienda.setBounds(69, 191, 117, 29);
		final JTextField descrizione = new JTextField();
		descrizione.setBounds(250, 191, 400, 29);
		JLabel labelEmailAzienda = new JLabel("Email Azienda");
		labelEmailAzienda.setBounds(69, 231, 117, 29);
		final JTextField email = new JTextField();
		email.setBounds(250, 231, 400, 29);
		
		String spRecord[] = record.split(",");
		attività.setEditable(true);
		String attivitàConnect = Connect.connectDb(GiveAll.giveAllAttività);
		String tirocinio = Connect.connectDb(GiveAll.giveAllTirocinio);
		String spAttività[] = attivitàConnect.split("_");
		String spTirocinio[] = tirocinio.split("_");
		int j=0;
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			attività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}
		
		 while (j != spTirocinio.length) {
				String x = spTirocinio[j];
				String spTirocinioColonne[] = x.split(",");
				if (spTirocinioColonne[0].equals(spRecord[0])){
				attività.setSelectedItem(spTirocinioColonne[1]);
				}
				j++;
			}
		id.setText(spRecord[0]);

		nome.setText(spRecord[7]);
		descrizione.setText(spRecord[8]);
		email.setText(spRecord[9]);
		
		getContentPane().add(labelIDTirocinio);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelNomeAzienda);
		getContentPane().add(labelDescrizioneAzienda);
		getContentPane().add(labelEmailAzienda);
		getContentPane().add(id);
		getContentPane().add(attività);
		getContentPane().add(nome);
		getContentPane().add(descrizione);
		getContentPane().add(email);
		
		final String idAtt[] = ((String) attività.getSelectedItem()).split(",");
		
modificaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(id.getText().trim());
				elencoParametri.add(idAtt[0].trim());
				elencoParametri.add(nome.getText().trim());
				elencoParametri.add(descrizione.getText().trim());
				elencoParametri.add((email.getText()).trim());
				ModificaCampiListener modificaCampi = new ModificaCampiListener(elencoParametri, "Tirocinio");
				modificaCampi.modificaCampi();
			}
		});
	}


private String convertiMese (String numero){
	
	if (numero.equals("01"))
		return "Gennaio";
	
	if (numero.equals("02"))
		return "Febbraio";
		
	if (numero.equals("03"))
		return "Marzo";
		
	if (numero.equals("04"))
		return "Aprile";
		
	if (numero.equals("05"))
		return "Maggio";
		
	if (numero.equals("06"))
		return "Giugno";
		
	if (numero.equals("07"))
		return "Luglio";
		
	if (numero.equals("08"))
		return "Agosto";
		
	if (numero.equals("09"))
		return "Settembre";
		
	if (numero.equals("10"))
		return "Ottobre";
		
	if (numero.equals("11"))
		return "Novembre";
		
	if (numero.equals("12"))
		return "Dicembre";

		return "Errore";
	
	}


public void pressButtonModificaCampi(ActionListener listener) {
	// TODO Auto-generated method stub
	modificaButton.addActionListener(listener);
	
	
}

public JButton getModificaButton() {
	return modificaButton;
}

public void setModificaButton(JButton modificaButton) {
	this.modificaButton = modificaButton;
}
}