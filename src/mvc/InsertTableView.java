package mvc;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InsertTableView extends JFrame {
	
	
	private static final long serialVersionUID = 1L;


	public InsertTableView(String tabella)
	{

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 80, 500, 500);
		
		
		
		initStudente();
		
		getContentPane().setLayout(null);

		
		
	}
	
	private void initAttività(){
		JLabel labelID = new JLabel("ID Attività");
		labelID.setBounds(69, 81, 117, 29);
		JTextField id = new JTextField();
		id.setBounds(250, 81, 200, 29);
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(69, 121, 117, 29);
		JTextField nome = new JTextField();
		nome.setBounds(250, 121, 200, 29);
		JLabel labelDescrizione = new JLabel ("Descrizione");
		labelDescrizione.setBounds(69, 161, 117, 29);
		JTextField descrizione = new JTextField();
		descrizione.setBounds(250, 161, 200, 29);
		JLabel labelOre = new JLabel("Ore");
		labelOre.setBounds(69, 201, 117, 29);
		JTextField ore = new JTextField();
		ore.setBounds(250, 201, 200, 29);
		JLabel labelSemestre = new JLabel("Semestre");
		labelSemestre.setBounds(69, 241, 117, 29);
		JComboBox semestre = new JComboBox();
		semestre.setBounds(250, 241, 200, 29);
		JLabel labelDataInizio = new JLabel("Data Inizio");
		labelDataInizio.setBounds(69, 281, 117, 29);
		//JDatePicker dataInizio = new JDatePicker();
		//dataInizio.setBounds(250, 281, 200, 29);
		JLabel labelDataFine = new JLabel("Data Fine");
		labelDataFine.setBounds(69, 321, 117, 29);
		//JDatePicker dataFine = new JDatePicker();
		//dataFine.setBounds(250, 321, 200, 29);
		
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
		
	}
	
	private void initAula(){
		JLabel labelEdificio = new JLabel("Edificio");
		labelEdificio.setBounds(69, 71, 117, 29);
		JTextField edificio = new JTextField();
		edificio.setBounds(250, 71, 200, 29);
		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setBounds(69, 111, 117, 29);
		JTextField numero = new JTextField();
		numero.setBounds(250, 111, 200, 29);
		JLabel labelCapienza = new JLabel ("Capienza");
		labelCapienza.setBounds(69, 151, 117, 29);
		JTextField capienza = new JTextField();
		capienza.setBounds(250, 151, 200, 29);
		JLabel labelDescrizione = new JLabel("Descrizione");
		labelDescrizione.setBounds(69, 191, 117, 29);
		JTextField descrizione = new JTextField();
		descrizione.setBounds(250, 191, 200, 29);
		
		getContentPane().add(labelEdificio);
		getContentPane().add(labelNumero);
		getContentPane().add(labelCapienza);
		getContentPane().add(labelDescrizione);
		getContentPane().add(edificio);
		getContentPane().add(numero);
		getContentPane().add(capienza);
		getContentPane().add(descrizione);

	}
	
	private void initConvegno(){
		JLabel labelIDConvegno = new JLabel("ID Convegno");
		labelIDConvegno.setBounds(69, 71, 117, 29);
		JLabel labelIDAttività = new JLabel("ID Attività");
		labelIDAttività.setBounds(69, 101, 117, 29);
		JLabel labelNomeRelatore = new JLabel ("Nome Relatore");
		labelNomeRelatore.setBounds(69, 131, 117, 29);
		JLabel labelCognomeRelatore = new JLabel("Cognome Relatore");
		labelCognomeRelatore.setBounds(69, 161, 117, 29);
		JLabel labelEmailRelatore = new JLabel("Email Relatore");
		labelEmailRelatore.setBounds(69, 191, 117, 29);
		JLabel labelQualificaRelatore = new JLabel("Qualifica Relatore");
		labelQualificaRelatore.setBounds(69, 221, 117, 29);
		
		getContentPane().add(labelIDConvegno);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelNomeRelatore);
		getContentPane().add(labelCognomeRelatore);
		getContentPane().add(labelEmailRelatore);
		getContentPane().add(labelQualificaRelatore);

	}
	
	private void initCorsoDiStudi(){
		JLabel labelID = new JLabel("ID Corso Di Studi");
		labelID.setBounds(69, 71, 117, 29);
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(69, 101, 117, 29);
		JLabel labelDescrizione = new JLabel ("Descrizione");
		labelDescrizione.setBounds(69, 131, 117, 29);
		JLabel labelTotaleCrediti = new JLabel("Totale Crediti");
		labelTotaleCrediti.setBounds(69, 161, 117, 29);
		JLabel labelAnno = new JLabel("Anno");
		labelAnno.setBounds(69, 191, 117, 29);
		JLabel labelIndirizzo = new JLabel("Indirizzo");
		labelIndirizzo.setBounds(69, 221, 117, 29);
		JLabel labelFacoltà = new JLabel("Facoltà");
		labelFacoltà.setBounds(69, 251, 117, 29);
		JLabel labelTipoLaurea = new JLabel ("Tipo Laurea");
		labelTipoLaurea.setBounds(69, 281, 117, 29);
		
		getContentPane().add(labelID);
		getContentPane().add(labelNome);
		getContentPane().add(labelDescrizione);
		getContentPane().add(labelTotaleCrediti);
		getContentPane().add(labelAnno);
		getContentPane().add(labelIndirizzo);
		getContentPane().add(labelFacoltà);
		getContentPane().add(labelTipoLaurea);
	}
	
	private void initDisciplina(){
		JLabel labelIDDisciplina = new JLabel("ID Disciplina");
		labelIDDisciplina.setBounds(69, 71, 117, 29);
		JLabel labelIDAttività = new JLabel("ID Attività");
		labelIDAttività.setBounds(69, 101, 117, 29);
		JLabel labelCrediti = new JLabel ("Crediti");
		labelCrediti.setBounds(69, 131, 117, 29);
		
		
		getContentPane().add(labelIDDisciplina);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelCrediti);
	}
	
	private void initDocente(){
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(69, 101, 117, 29);
		JLabel labelCognome = new JLabel ("Cognome");
		labelCognome.setBounds(69, 131, 117, 29);
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(69, 161, 117, 29);
		JLabel labelQualifica = new JLabel("Qualifica");
		labelQualifica.setBounds(69, 191, 117, 29);
		JLabel labelAssociato = new JLabel("Associato");
		labelAssociato.setBounds(69, 221, 117, 29);
		
		getContentPane().add(labelMatricola);
		getContentPane().add(labelNome);
		getContentPane().add(labelCognome);
		getContentPane().add(labelEmail);
		getContentPane().add(labelQualifica);
		getContentPane().add(labelAssociato);
	}
	
	private void initEsame(){
		JLabel labelIDEsame = new JLabel("ID Esame");
		labelIDEsame.setBounds(69, 71, 117, 29);
		JLabel labelIDAttività = new JLabel("IDAttività");
		labelIDAttività.setBounds(69, 101, 117, 29);
		JLabel labelTipologia = new JLabel ("Tipologia");
		labelTipologia.setBounds(69, 131, 117, 29);
		
		
		getContentPane().add(labelIDEsame);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelTipologia);
	}
	
	private void initFasciaOraria(){
		JLabel labelID = new JLabel("ID Fascia Oraria");
		labelID.setBounds(69, 71, 117, 29);
		JLabel labelGiorno = new JLabel("Giorno");
		labelGiorno.setBounds(69, 101, 117, 29);
		JLabel labelOraInizio = new JLabel ("Ora Inizio");
		labelOraInizio.setBounds(69, 131, 117, 29);
		JLabel labelOraFine = new JLabel("Ora Fine");
		labelOraFine.setBounds(69, 161, 117, 29);
		
		
		getContentPane().add(labelID);
		getContentPane().add(labelGiorno);
		getContentPane().add(labelOraInizio);
		getContentPane().add(labelOraFine);
	}
	
	private void initGita(){
		JLabel labelIDGita = new JLabel("ID Gita");
		labelIDGita.setBounds(69, 71, 117, 29);
		JLabel labelIDAttività = new JLabel("IDAttività");
		labelIDAttività.setBounds(69, 101, 117, 29);
		JLabel labelLuogo = new JLabel ("Luogo");
		labelLuogo.setBounds(69, 131, 117, 29);
		
		getContentPane().add(labelIDGita);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelLuogo);
	}
	
	private void initInsegna(){
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		JLabel labelID = new JLabel("ID Attività");
		labelID.setBounds(69, 101, 117, 29);
		
		
		getContentPane().add(labelMatricola);
		getContentPane().add(labelID);
	}
	
	private void initPianoDiStudio(){
		JLabel labelIDCorso = new JLabel("ID Corso Di Studi");
		labelIDCorso.setBounds(69, 71, 117, 29);
		JLabel labelIDAttività = new JLabel("ID Attività");
		labelIDAttività.setBounds(69, 101, 117, 29);
		JLabel labelOpzionale = new JLabel ("Opzionale");
		labelOpzionale.setBounds(69, 131, 117, 29);
		
		getContentPane().add(labelIDCorso);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelOpzionale);
	}
	
	private void initPreferenzaAula(){
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		JLabel labelEdificio = new JLabel("Edificio");
		labelEdificio.setBounds(69, 101, 117, 29);
		JLabel labelNumero = new JLabel ("Numero");
		labelNumero.setBounds(69, 131, 117, 29);
		
		getContentPane().add(labelMatricola);
		getContentPane().add(labelEdificio);
		getContentPane().add(labelNumero);
	}
	
	private void initPreferenzaFasciaOraria(){
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		JLabel labelID = new JLabel("ID Fascia Oraria");
		labelID.setBounds(69, 101, 117, 29);
		JLabel labelPriorità = new JLabel ("Priorità");
		labelPriorità.setBounds(69, 131, 117, 29);
		
		getContentPane().add(labelMatricola);
		getContentPane().add(labelID);
		getContentPane().add(labelPriorità);
	}
	
	private void initStudente(){
		JLabel labelMatricola = new JLabel("Matricola");
		labelMatricola.setBounds(69, 71, 117, 29);
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(69, 101, 117, 29);
		JLabel labelCognome = new JLabel ("Cognome");
		labelCognome.setBounds(69, 131, 117, 29);
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(69, 161, 117, 29);
		JLabel labelDataNascita = new JLabel("Data Nascita");
		labelDataNascita.setBounds(69, 191, 117, 29);
		JLabel labelAnnoIscrizione = new JLabel("Anno Iscrizione");
		labelAnnoIscrizione.setBounds(69, 221, 117, 29);
		JLabel labelID = new JLabel("ID Corso Di Studi");
		labelID.setBounds(69, 251, 117, 29);
		
		getContentPane().add(labelMatricola);
		getContentPane().add(labelNome);
		getContentPane().add(labelCognome);
		getContentPane().add(labelEmail);
		getContentPane().add(labelDataNascita);
		getContentPane().add(labelAnnoIscrizione);
		getContentPane().add(labelID);
	}
	
	private void initTirocinio(){
		JLabel labelIDTirocinio = new JLabel("ID Tirocinio");
		labelIDTirocinio.setBounds(69, 71, 117, 29);
		JLabel labelIDAttività = new JLabel("ID Attività");
		labelIDAttività.setBounds(69, 101, 117, 29);
		JLabel labelNomeAzienda = new JLabel ("Nome Azienda");
		labelNomeAzienda.setBounds(69, 131, 117, 29);
		JLabel labelDescrizioneAzienda = new JLabel("Descrizione Azienda");
		labelDescrizioneAzienda.setBounds(69, 161, 117, 29);
		JLabel labelEmailAzienda = new JLabel("Email Azienda");
		labelEmailAzienda.setBounds(69, 191, 117, 29);
		
		getContentPane().add(labelIDTirocinio);
		getContentPane().add(labelIDAttività);
		getContentPane().add(labelNomeAzienda);
		getContentPane().add(labelDescrizioneAzienda);
		getContentPane().add(labelEmailAzienda);
	}
}
