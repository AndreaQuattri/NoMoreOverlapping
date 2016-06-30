package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.spi.TimeZoneNameProvider;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import connect_to_database.Connect;
import controller_listener.InsertCampiListener;
import controller_listener.ModificaCampiListener;
import url_php.GiveAll;

@SuppressWarnings("deprecation")

public class InsertTableView extends JFrame {


	private static final long serialVersionUID = 1L;
	private JButton inserisciButton;


	public InsertTableView(String tabella) throws IOException, URISyntaxException
	{

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 80, 700, 500);

		inserisciButton = new JButton ("Inserisci");
		inserisciButton.setBounds(280, 420, 200, 29);

		if (tabella.equals("Attività"))
			initAttività();


		if (tabella.equals("Aula"))
			initAula();

		if (tabella.equals("Convegno"))
			initConvegno();

		if (tabella.equals("Corso di studi"))
			initCorsoDiStudi();

		if (tabella.equals("Disciplina"))
			initDisciplina();

		if (tabella.equals("Docente"))
			initDocente();

		if (tabella.equals("Esame"))
			initEsame();

		if (tabella.equals("Fascia oraria"))
			initFasciaOraria();

		if (tabella.equals("Gita"))
			initGita();

		if (tabella.equals("Insegna"))
			initInsegna();

		if (tabella.equals("Piano di studio"))
			initPianoDiStudio();

		if (tabella.equals("Preferenza aula"))
			initPreferenzaAula();

		if (tabella.equals("Preferenza fascia oraria"))
			initPreferenzaFasciaOraria();

		if (tabella.equals("Studente"))
			initStudente();

		if (tabella.equals("Tirocinio"))
			initTirocinio();



		getContentPane().setLayout(null);
		getContentPane().add(inserisciButton);



	}

	private void initAttività(){
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

		inserisciButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(nome.getText().trim());
				elencoParametri.add(descrizione.getText().trim());
				elencoParametri.add(ore.getText().trim());
				elencoParametri.add(((String) semestre.getSelectedItem()).trim());
				elencoParametri.add(giornoInizio.getSelectedItem().toString().trim());
				elencoParametri.add(meseInizio.getSelectedItem().toString().trim());
				elencoParametri.add(annoInizio.getSelectedItem().toString().trim());
				elencoParametri.add(giornoFine.getSelectedItem().toString().trim());
				elencoParametri.add(meseFine.getSelectedItem().toString().trim());
				elencoParametri.add(annoFine.getSelectedItem().toString().trim());
				InsertCampiListener inserisciCampi = new InsertCampiListener(elencoParametri, "Attività");
				inserisciCampi.inserisciCampi();
			}
		});


	}

	private void initAula(){
		JLabel labelEdificio = new JLabel("Edificio");
		labelEdificio.setBounds(69, 71, 117, 29);
		final JTextField edificio = new JTextField();
		edificio.setBounds(250, 71, 400, 29);
		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setBounds(69, 111, 117, 29);
		final JTextField numero = new JTextField();
		numero.setBounds(250, 111, 400, 29);
		JLabel labelCapienza = new JLabel ("Capienza");
		labelCapienza.setBounds(69, 151, 117, 29);
		final JTextField capienza = new JTextField();
		capienza.setBounds(250, 151, 400, 29);
		JLabel labelDescrizione = new JLabel("Descrizione");
		labelDescrizione.setBounds(69, 191, 117, 29);
		final JTextField descrizione = new JTextField();
		descrizione.setBounds(250, 191, 400, 29);

		getContentPane().add(labelEdificio);
		getContentPane().add(labelNumero);
		getContentPane().add(labelCapienza);
		getContentPane().add(labelDescrizione);
		getContentPane().add(edificio);
		getContentPane().add(numero);
		getContentPane().add(capienza);
		getContentPane().add(descrizione);

		inserisciButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				elencoParametri.add(edificio.getText().trim());
				elencoParametri.add(numero.getText().trim());
				elencoParametri.add(capienza.getText().trim());
				elencoParametri.add(descrizione.getText().trim());
				InsertCampiListener inserisciCampi = new InsertCampiListener(elencoParametri, "Aula");
				inserisciCampi.inserisciCampi();
			}
		});

	}

	private void initConvegno() throws IOException, URISyntaxException{
		JLabel labelIDConvegno = new JLabel("ID Convegno");
		labelIDConvegno.setBounds(69, 71, 117, 29);
		JTextField idConvegno = new JTextField();
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

		String attivitàConnect = Connect.connectDb(GiveAll.giveAllAttività);
		String spAttività[] = attivitàConnect.split("_");
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			idAttività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}

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

		inserisciButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				String[] idAtt = idAttività.getSelectedItem().toString().split(",");

				elencoParametri.add(idAtt[0].trim());
				elencoParametri.add(nomeRelatore.getText().trim());
				elencoParametri.add(cognomeRelatore.getText().trim());
				elencoParametri.add(emailRelatore.getText().trim());
				elencoParametri.add(qualificaRelatore.getText().trim());
				InsertCampiListener inserisciCampi = new InsertCampiListener(elencoParametri, "Convegno");
				inserisciCampi.inserisciCampi();
			}
		});


	}

	private void initCorsoDiStudi(){
		JLabel labelID = new JLabel("ID Corso Di Studi");
		labelID.setBounds(69, 71, 117, 29);
		JTextField id = new JTextField();
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
		JLabel labelfacoltà = new JLabel("Facoltà");
		labelfacoltà.setBounds(69, 311, 117, 29);
		final JTextField facoltà = new JTextField();
		facoltà.setBounds(250, 311, 400, 29);
		JLabel labelTipoLaurea = new JLabel ("Tipo Laurea");
		labelTipoLaurea.setBounds(69, 351, 117, 29);
		final JComboBox laurea = new JComboBox();
		laurea.setBounds(250, 351, 400, 29);

		anno.setEditable(true);
		indirizzo.setEditable(true);
		laurea.setEditable(true);

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


		inserisciButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();

				String annoAct = (String) anno.getSelectedItem();
				String indirizzoAct = (String) indirizzo.getSelectedItem();
				String laureaAct = (String) laurea.getSelectedItem();

				elencoParametri.add(nome.getText().trim());
				elencoParametri.add(descrizione.getText().trim());
				elencoParametri.add(crediti.getText().trim());
				elencoParametri.add(annoAct.trim());
				elencoParametri.add(indirizzoAct.trim());
				elencoParametri.add(facoltà.getText().trim());
				elencoParametri.add(laureaAct.trim());

				InsertCampiListener inserisciCampi = new InsertCampiListener(elencoParametri, "Corso di studi");
				inserisciCampi.inserisciCampi();
			}
		});


	}

	private void initDisciplina() throws IOException, URISyntaxException{
		JLabel labelIDDisciplina = new JLabel("ID Disciplina");
		labelIDDisciplina.setBounds(69, 71, 117, 29);
		JTextField idDisciplina = new JTextField();
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
		String spAttività[] = attivitàConnect.split("_");
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			idAttività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}

		idAttività.setEditable(true);


		getContentPane().add(labelIDDisciplina);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelCrediti);
		getContentPane().add(idDisciplina);
		getContentPane().add(idAttività);
		getContentPane().add(crediti);


		inserisciButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();

				String[] idAtt = idAttività.getSelectedItem().toString().split(",");

				elencoParametri.add(idAtt[0].trim());
				elencoParametri.add(crediti.getText().trim());
				

				InsertCampiListener inserisciCampi = new InsertCampiListener(elencoParametri, "Disciplina");
				inserisciCampi.inserisciCampi();
			}
		});
	}

	private void initDocente(){
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		final JTextField matricola = new JTextField();
		matricola.setBounds(250, 71, 400, 29);
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

		associato.setEditable(true);

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
		
		
		inserisciButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				
				String associatoAct = (String)associato.getSelectedItem();


				elencoParametri.add(matricola.getText().trim());
				elencoParametri.add(nome.getText().trim());
				elencoParametri.add(cognome.getText().trim());
				elencoParametri.add(email.getText().trim());
				elencoParametri.add(qualifica.getText().trim());
				elencoParametri.add(associatoAct.trim());
				

				InsertCampiListener inserisciCampi = new InsertCampiListener(elencoParametri, "Docente");
				inserisciCampi.inserisciCampi();
			}
		});
	}

	private void initEsame() throws IOException, URISyntaxException{
		JLabel labelIDEsame = new JLabel("ID Esame");
		labelIDEsame.setBounds(69, 71, 117, 29);
		JTextField idEsame = new JTextField();
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
		idAttività.setEditable(true);
		tipologia.setEditable(true);

		String attività = Connect.connectDb(GiveAll.giveAllAttività);
		String spAttività[] = attività.split("_");
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			idAttività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}

		tipologia.addItem("Scritto");
		tipologia.addItem("Orale");
		tipologia.addItem("ScrittoOrale");


		getContentPane().add(labelIDEsame);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelTipologia);
		getContentPane().add(idEsame);
		getContentPane().add(idAttività);
		getContentPane().add(tipologia);
		
		inserisciButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				
				String[] idAtt = idAttività.getSelectedItem().toString().split(",");
				String tipologiaAct = (String)tipologia.getSelectedItem();

				elencoParametri.add(idAtt[0].trim());
				elencoParametri.add(tipologiaAct.trim());
				InsertCampiListener inserisciCampi = new InsertCampiListener(elencoParametri, "Esame");
				inserisciCampi.inserisciCampi();
			}
		});
	}

	private void initFasciaOraria(){
		JLabel labelID = new JLabel("ID Fascia Oraria");
		labelID.setBounds(69, 71, 117, 29);
		JTextField id = new JTextField();
		id.setBounds(250, 71, 400, 29);
		id.enable(false);
		JLabel labelGiorno = new JLabel("Giorno");
		labelGiorno.setBounds(69, 111, 117, 29);
		JComboBox giorno = new JComboBox();
		giorno.setBounds(250, 111, 400, 29);
		JLabel labelOraInizio = new JLabel ("Ora Inizio");
		labelOraInizio.setBounds(69, 151, 117, 29);
		JTextField oInizio = new JTextField();
		oInizio.setBounds(250, 151, 400, 29);
		JLabel labelOraFine = new JLabel("Ora Fine");
		labelOraFine.setBounds(69, 191, 117, 29);
		JTextField oFine = new JTextField();
		oFine.setBounds(250, 191, 400, 29);
		giorno.setEditable(true);

		giorno.addItem("Lunedi");
		giorno.addItem("Martedi");
		giorno.addItem("Mercoledi");
		giorno.addItem("Giovedi");
		giorno.addItem("Venerdi");
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

	private void initGita() throws IOException, URISyntaxException{
		JLabel labelIDGita = new JLabel("ID Gita");
		labelIDGita.setBounds(69, 71, 117, 29);
		JTextField gita = new JTextField();
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

		String attivitàConnect = Connect.connectDb(GiveAll.giveAllAttività);
		String spAttività[] = attivitàConnect.split("_");
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			attività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}

		attività.setEditable(true);

		getContentPane().add(labelIDGita);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelLuogo);
		getContentPane().add(gita);
		getContentPane().add(attività);
		getContentPane().add(luogo);
		
		inserisciButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				
				String[] idAtt = attività.getSelectedItem().toString().split(",");

				elencoParametri.add(idAtt[0].trim());
				elencoParametri.add(luogo.getText().trim());
				InsertCampiListener inserisciCampi = new InsertCampiListener(elencoParametri, "Gita");
				inserisciCampi.inserisciCampi();
			}
		});

	}

	private void initInsegna() throws IOException, URISyntaxException{
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		final JTextField matricola = new JTextField();
		matricola.setBounds(250, 71, 400, 29);
		JLabel labelID = new JLabel("ID Attività");
		labelID.setBounds(69, 111, 117, 29);
		final JComboBox attività = new JComboBox();
		attività.setBounds(250, 111, 400, 29);
		attività.setEditable(true);
		String attivitàConnect = Connect.connectDb(GiveAll.giveAllAttività);
		String spAttività[] = attivitàConnect.split("_");
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			attività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}


		getContentPane().add(labelMatricola);
		getContentPane().add(labelID);
		getContentPane().add(matricola);
		getContentPane().add(attività);
		
		inserisciButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				
				String[] idAtt = attività.getSelectedItem().toString().split(",");

				elencoParametri.add(matricola.getText().trim());
				elencoParametri.add(idAtt[0].trim());
				InsertCampiListener inserisciCampi = new InsertCampiListener(elencoParametri, "Insegna");
				inserisciCampi.inserisciCampi();
			}
		});
		
	}

	private void initPianoDiStudio() throws IOException, URISyntaxException{
		JLabel labelIDCorso = new JLabel("ID Corso Di Studi");
		labelIDCorso.setBounds(69, 71, 117, 29);
		final JTextField idCorso = new JTextField();
		idCorso.setBounds(250, 71, 400, 29);
		idCorso.enable(false);
		JLabel labelIDAttività = new JLabel("ID Attività");
		labelIDAttività.setBounds(69, 111, 117, 29);
		final JComboBox idAttività = new JComboBox();
		idAttività.setBounds(250, 111, 400, 29);
		JLabel labelOpzionale = new JLabel ("Opzionale");
		labelOpzionale.setBounds(69, 151, 117, 29);
		final JComboBox opzionale = new JComboBox();
		opzionale.setBounds(250, 151, 400, 29);
		opzionale.setEditable(true);
		idAttività.setEditable(true);
		String attivitàConnect = Connect.connectDb(GiveAll.giveAllAttività);
		String spAttività[] = attivitàConnect.split("_");
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			idAttività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}		

		opzionale.addItem("0");
		opzionale.addItem("1");

		getContentPane().add(labelIDCorso);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelOpzionale);
		getContentPane().add(idCorso);
		getContentPane().add(idAttività);
		getContentPane().add(opzionale);
		
		
		inserisciButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> elencoParametri = new ArrayList <String>();
				
				String[] idAtt = idAttività.getSelectedItem().toString().split(",");
				String opzionaleAct = (String) opzionale.getSelectedItem();

				elencoParametri.add(idCorso.getText().trim());
				elencoParametri.add(idAtt[0].trim());
				elencoParametri.add(opzionaleAct.trim());
				InsertCampiListener inserisciCampi = new InsertCampiListener(elencoParametri, "Piano di studio");
				inserisciCampi.inserisciCampi();
			}
		});
	}

	private void initPreferenzaAula(){
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		JTextField matricola = new JTextField();
		matricola.setBounds(250, 71, 400, 29);
		JLabel labelEdificio = new JLabel("Edificio");
		labelEdificio.setBounds(69, 111, 117, 29);
		JComboBox edificio = new JComboBox();
		edificio.setBounds(250, 111, 400, 29);
		JLabel labelNumero = new JLabel ("Numero");
		labelNumero.setBounds(69, 151, 117, 29);
		JComboBox numero = new JComboBox();
		numero.setBounds(250, 151, 400, 29);

		edificio.setEditable(true);
		numero.setEditable(true);

		for (int i=1; i<=27;i++){
			numero.addItem(i);
		}
		numero.addItem("Magna");
		edificio.addItem("A");
		edificio.addItem("B");
		edificio.addItem("C");
		edificio.addItem("Ex Enel");

		getContentPane().add(labelMatricola);
		getContentPane().add(labelEdificio);
		getContentPane().add(labelNumero);
		getContentPane().add(matricola);
		getContentPane().add(edificio);
		getContentPane().add(numero);
	}

	private void initPreferenzaFasciaOraria() throws IOException, URISyntaxException{
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		JComboBox matricola = new JComboBox();
		matricola.setBounds(250, 71, 400, 29);
		JLabel labelID = new JLabel("ID Fascia Oraria");
		labelID.setBounds(69, 111, 117, 29);
		JComboBox id = new JComboBox();
		id.setBounds(250, 111, 400, 29);
		JLabel labelpriorità = new JLabel ("Priorit�");
		labelpriorità.setBounds(69, 151, 117, 29);
		JComboBox priorità = new JComboBox();
		priorità.setBounds(250, 151, 400, 29);

		String fasciaConnect = Connect.connectDb(GiveAll.giveAllFasciaOraria);
		String spFascia[] = fasciaConnect.split("_");
		String docenteConnect = Connect.connectDb(GiveAll.giveAllDocente);
		String spDocente[] = docenteConnect.split("_");

		for (int j=0; j<spDocente.length;j++){
			String y = spDocente[j];
			String spDocenteColonne[] = y.split(",");
			matricola.addItem(spDocenteColonne[0]+","+spDocenteColonne[1]+" "+spDocenteColonne[2]);
		}

		for (int i=0; i<spFascia.length;i++){
			String x = spFascia[i];
			String spFasciaColonne[] = x.split(",");
			id.addItem(spFasciaColonne[0]+","+spFasciaColonne[1]+","+spFasciaColonne[2]+","+spFasciaColonne[3]);
		}

		matricola.setEditable(true);
		id.setEditable(true);
		priorità.setEditable(true);
		priorità.addItem("1");
		priorità.addItem("2");
		priorità.addItem("3");

		getContentPane().add(labelMatricola);
		getContentPane().add(labelID);
		getContentPane().add(labelpriorità);
		getContentPane().add(matricola);
		getContentPane().add(id);
		getContentPane().add(priorità);
	}

	private void initStudente() throws IOException, URISyntaxException{
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		JTextField matricola = new JTextField();
		matricola.setBounds(250, 71, 400, 29);
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(69, 111, 117, 29);
		JTextField nome = new JTextField();
		nome.setBounds(250, 111, 400, 29);
		JLabel labelCognome = new JLabel ("Cognome");
		labelCognome.setBounds(69, 151, 117, 29);
		JTextField cognome = new JTextField();
		cognome.setBounds(250, 151, 400, 29);
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(69, 191, 117, 29);
		JTextField email = new JTextField();
		email.setBounds(250, 191, 400, 29);
		JLabel labelDataNascita = new JLabel("Data Nascita");
		labelDataNascita.setBounds(69, 231, 117, 29);
		JComboBox giornoNascita = new JComboBox();
		giornoNascita.setBounds(250, 231, 100, 29);
		JComboBox meseNascita = new JComboBox();
		meseNascita.setBounds(400, 231, 100, 29);
		JComboBox annoNascita = new JComboBox();
		annoNascita.setBounds(550, 231, 100, 29);
		JLabel labelAnnoIscrizione = new JLabel("Anno Iscrizione");
		labelAnnoIscrizione.setBounds(69, 271, 117, 29);
		JComboBox anno = new JComboBox();
		anno.setBounds(250, 271, 400, 29);
		JLabel labelID = new JLabel("ID Corso Di Studi");
		labelID.setBounds(69, 311, 117, 29);
		JComboBox id = new JComboBox();
		id.setBounds(250, 311, 400, 29);
		anno.setEditable(true);
		id.setEditable(true);
		giornoNascita.setEditable(true);
		meseNascita.setEditable(true);
		annoNascita.setEditable(true);

		String corso = Connect.connectDb(GiveAll.giveAllCorsoDiStudi);
		String spCorso[] = corso.split("_");
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
	}

	private void initTirocinio() throws IOException, URISyntaxException{
		JLabel labelIDTirocinio = new JLabel("ID Tirocinio");
		labelIDTirocinio.setBounds(69, 71, 117, 29);
		JTextField id = new JTextField();
		id.setBounds(250, 71, 400, 29);
		id.enable(false);
		JLabel labelIDAttività = new JLabel("ID Attività");
		labelIDAttività.setBounds(69, 111, 117, 29);
		JComboBox attività = new JComboBox();
		attività.setBounds(250, 111, 400, 29);
		JLabel labelNomeAzienda = new JLabel ("Nome Azienda");
		labelNomeAzienda.setBounds(69, 151, 117, 29);
		JTextField nome = new JTextField();
		nome.setBounds(250, 151, 400, 29);
		JLabel labelDescrizioneAzienda = new JLabel("Descrizione Azienda");
		labelDescrizioneAzienda.setBounds(69, 191, 117, 29);
		JTextField descrizione = new JTextField();
		descrizione.setBounds(250, 191, 400, 29);
		JLabel labelEmailAzienda = new JLabel("Email Azienda");
		labelEmailAzienda.setBounds(69, 231, 117, 29);
		JTextField email = new JTextField();
		email.setBounds(250, 231, 400, 29);
		attività.setEditable(true);

		String attivitàConnect = Connect.connectDb(GiveAll.giveAllAttività);
		String spAttività[] = attivitàConnect.split("_");
		for (int i=0; i<spAttività.length; i++){
			String y = spAttività[i];
			String spAttivitàColonne[] = y.split(",");
			attività.addItem(spAttivitàColonne[0]+","+spAttivitàColonne[1]);
		}

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
	}
}
