/*
 * 
 */
package mvc;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Observable;
import java.util.Vector;

import myComponents.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Model.
 */
public class Model extends Observable{

	/** The list assegnamento. */
	private ArrayList<Assegnamento> listAssegnamento;
	
	/** The list aula. */
	private ArrayList<Aula> listAula;					//Fatto
	
	/** The list convegno. */
	private ArrayList<Convegno> listConvegno;			//Fatto
	
	/** The list corso di studi. */
	private ArrayList<CorsoDiStudi> listCorsoDiStudi;	//Fatto
	
	/** The list disciplina. */
	private ArrayList<Disciplina> listDisciplina;		//Fatto
	
	/** The list docente. */
	private ArrayList<Docente> listDocente;				//Fatto
	
	/** The list esame. */
	private ArrayList<Esame> listEsame;					//Da controllare un campo che ho tolto
	
	/** The list fascia oraria. */
	private ArrayList<FasciaOraria> listFasciaOraria;	//Fatto
	
	/** The list gita. */
	private ArrayList<Gita> listGita;					//Fatto
	
	/** The list piano di studi. */
	private ArrayList<PianoDiStudi> listPianoDiStudi;	//Fatto
	
	/** The list studente. */
	private ArrayList<Studente> listStudente;			//Fatto
	
	/** The list tirocinio. */
	private ArrayList<Tirocinio> listTirocinio;			//Fatto
	
	/** The tabella. */
	private Vector<Vector<String>> tabella;
	
	/** The orario ufficiale. */
	private Orario orarioUfficiale;
	
	/** The orario ufficiale. */
	private Orario orarioDaMostrare;
	
	/** The matrix. */
	private int[][] matrix;


	/**
	 * Gets the tabella.
	 *
	 * @return the tabella
	 */
	public Vector<Vector<String>> getTabella() {
		return tabella;
	}




	/**
	 * Sets the tabella.
	 *
	 * @param tabella the new tabella
	 */
	public void setTabella(Vector<Vector<String>> tabella) {
		this.tabella = tabella;
	}


	/** The list attività inserite. */
	private ArrayList<Attività> listAttivitàInserite;
	
	/** The list docenti inseriti. */
	private ArrayList<Docente> listDocentiInseriti;
	
	/** The list attività dei docenti. */
	private ArrayList<Attività> listAttivitàDeiDocenti;
	
	/** The list all attività inserite. */
	private ArrayList<Attività> listAllAttivitàInserite;
	
	/** The list corso di studio inseriti. */
	private ArrayList<CorsoDiStudi> listCorsoDiStudioInseriti;


	/** The enable modifica table. */
	private boolean enableModificaTable;
	
	/** The enable elimina table. */
	private boolean enableEliminaTable;
	
	/** The enable button acquisisci. */
	private boolean enableButtonAcquisisci;
	
	/** The enable button aggiorna. */
	private boolean enableButtonAggiorna;
	
	/** The enable button inserisci gita. */
	private boolean enableButtonInserisciGita;
	
	private boolean enableCaricaButton;
	
	private boolean enableInserisciButton;


	/** The num sovrapposizioni. */
	private int numSovrapposizioni;




	/**
	 * Instantiates a new model.
	 */
	public Model() {

		listAssegnamento = new ArrayList<Assegnamento>();
		listAula = new ArrayList<Aula>();
		listConvegno = new ArrayList<Convegno>();
		listCorsoDiStudi = new ArrayList<CorsoDiStudi>();
		listDisciplina = new ArrayList<Disciplina>();
		listDocente = new ArrayList<Docente>();
		listEsame = new ArrayList<Esame>();
		listFasciaOraria = new ArrayList<FasciaOraria>();
		listGita = new ArrayList<Gita>();
		listPianoDiStudi = new ArrayList<PianoDiStudi>();
		listStudente = new ArrayList<Studente>();
		listTirocinio = new ArrayList<Tirocinio>();
		tabella = new Vector<Vector<String>>();
		setListAttivitàInserite(new ArrayList<Attività>());
		listDocentiInseriti = new ArrayList<Docente>();
		setListAttivitàDeiDocenti(new ArrayList<Attività>());
		setListAllAttivitàInserite(new ArrayList<Attività>());
		setOrarioUfficiale(new Orario());
		setOrarioDaMostrare(new Orario());
		matrix = new int[21][6];

		enableModificaTable = false;
		enableEliminaTable = false;
		enableButtonAcquisisci = false;
		enableButtonAggiorna = false;
		enableButtonInserisciGita = false;
		enableCaricaButton = false;
		enableInserisciButton = false;

	}



	/**
	 * Gets the list aula.
	 *
	 * @return the list aula
	 */
	public ArrayList<Aula> getListAula() {
		return listAula;
	}
	
	/**
	 * Sets the list aula.
	 *
	 * @param listAula the new list aula
	 */
	public void setListAula(ArrayList<Aula> listAula) {
		this.listAula = listAula;
	}
	
	/**
	 * Gets the list convegno.
	 *
	 * @return the list convegno
	 */
	public ArrayList<Convegno> getListConvegno() {
		return listConvegno;
	}
	
	/**
	 * Sets the list convegno.
	 *
	 * @param listConvegno the new list convegno
	 */
	public void setListConvegno(ArrayList<Convegno> listConvegno) {
		this.listConvegno = listConvegno;
	}
	
	/**
	 * Gets the list corso di studi.
	 *
	 * @return the list corso di studi
	 */
	public ArrayList<CorsoDiStudi> getListCorsoDiStudi() {
		return listCorsoDiStudi;
	}
	
	/**
	 * Sets the list corso di studi.
	 *
	 * @param listCorsoDiStudi the new list corso di studi
	 */
	public void setListCorsoDiStudi(ArrayList<CorsoDiStudi> listCorsoDiStudi) {
		this.listCorsoDiStudi = listCorsoDiStudi;
	}
	
	/**
	 * Gets the list disciplina.
	 *
	 * @return the list disciplina
	 */
	public ArrayList<Disciplina> getListDisciplina() {
		return listDisciplina;
	}
	
	/**
	 * Sets the list disciplina.
	 *
	 * @param listDisciplina the new list disciplina
	 */
	public void setListDisciplina(ArrayList<Disciplina> listDisciplina) {
		this.listDisciplina = listDisciplina;
	}
	
	/**
	 * Gets the list docente.
	 *
	 * @return the list docente
	 */
	public ArrayList<Docente> getListDocente() {
		return listDocente;
	}
	
	/**
	 * Sets the list docente.
	 *
	 * @param listDocente the new list docente
	 */
	public void setListDocente(ArrayList<Docente> listDocente) {
		this.listDocente = listDocente;
	}
	
	/**
	 * Gets the list esame.
	 *
	 * @return the list esame
	 */
	public ArrayList<Esame> getListEsame() {
		return listEsame;
	}
	
	/**
	 * Sets the list esame.
	 *
	 * @param listEsame the new list esame
	 */
	public void setListEsame(ArrayList<Esame> listEsame) {
		this.listEsame = listEsame;
	}
	
	/**
	 * Gets the list fascia oraria.
	 *
	 * @return the list fascia oraria
	 */
	public ArrayList<FasciaOraria> getListFasciaOraria() {
		return listFasciaOraria;
	}
	
	/**
	 * Sets the list fascia oraria.
	 *
	 * @param listFasciaOraria the new list fascia oraria
	 */
	public void setListFasciaOraria(ArrayList<FasciaOraria> listFasciaOraria) {
		this.listFasciaOraria = listFasciaOraria;
	}
	
	/**
	 * Gets the list gita.
	 *
	 * @return the list gita
	 */
	public ArrayList<Gita> getListGita() {
		return listGita;
	}
	
	/**
	 * Sets the list gita.
	 *
	 * @param listGita the new list gita
	 */
	public void setListGita(ArrayList<Gita> listGita) {
		this.listGita = listGita;
	}

	/**
	 * Gets the list piano di studi.
	 *
	 * @return the list piano di studi
	 */
	public ArrayList<PianoDiStudi> getListPianoDiStudi() {
		return listPianoDiStudi;
	}
	
	/**
	 * Sets the list piano di studi.
	 *
	 * @param listPianoDiStudi the new list piano di studi
	 */
	public void setListPianoDiStudi(ArrayList<PianoDiStudi> listPianoDiStudi) {
		this.listPianoDiStudi = listPianoDiStudi;
	}
	
	/**
	 * Gets the list studente.
	 *
	 * @return the list studente
	 */
	public ArrayList<Studente> getListStudente() {
		return listStudente;
	}
	
	/**
	 * Sets the list studente.
	 *
	 * @param listStudente the new list studente
	 */
	public void setListStudente(ArrayList<Studente> listStudente) {
		this.listStudente = listStudente;
	}
	
	/**
	 * Gets the list tirocinio.
	 *
	 * @return the list tirocinio
	 */
	public ArrayList<Tirocinio> getListTirocinio() {
		return listTirocinio;
	}
	
	/**
	 * Sets the list tirocinio.
	 *
	 * @param listTirocinio the new list tirocinio
	 */
	public void setListTirocinio(ArrayList<Tirocinio> listTirocinio) {
		this.listTirocinio = listTirocinio;
	}

	/**
	 * Send notify.
	 *
	 * @param notifyID the notify id
	 */
	private void sendNotify(int notifyID)
	{
		MyNotify notify = new MyNotify(notifyID); 

		setChanged();

		notifyObservers(notify);
	}


	public boolean isEnableCaricaButton(){
		return enableCaricaButton;
	}
	

	public boolean isEnableInserisciButton() {
		return enableInserisciButton;
	}




	
	

	/**
	 * Checks if is enable modifica table.
	 *
	 * @return true, if is enable modifica table
	 */
	public boolean isEnableModificaTable() {
		return enableModificaTable;
	}

	/**
	 * Checks if is enable elimina table.
	 *
	 * @return true, if is enable elimina table
	 */
	public boolean isEnableEliminaTable() {
		return enableEliminaTable;
	}

	/**
	 * Checks if is enable button acquisisci.
	 *
	 * @return true, if is enable button acquisisci
	 */
	public boolean isEnableButtonAcquisisci() {
		return enableButtonAcquisisci;
	}

	/**
	 * Checks if is enable button aggiorna.
	 *
	 * @return true, if is enable button aggiorna
	 */
	public boolean isEnableButtonAggiorna() {
		return enableButtonAggiorna;
	}

	/**
	 * Checks if is enabled inserisci gita.
	 *
	 * @return true, if is enabled inserisci gita
	 */
	public boolean isEnabledInserisciGita() {
		return enableButtonInserisciGita;
	}
	
	
	public void enableCaricaButton(boolean enableCaricaButton) {
		this.enableCaricaButton = enableCaricaButton;
		sendNotify(MyNotify.ENABLE_BUTTON_CARICA);

	}

	public void enableInserisciButton(boolean enableInserisciButton) {
		this.enableInserisciButton = enableInserisciButton;
		sendNotify(MyNotify.ENABLE_BUTTON_INSERISCI);
	}
	

	/**
	 * Enable modifica table.
	 *
	 * @param enableModificaTable the enable modifica table
	 */
	public void enableModificaTable(boolean enableModificaTable) {
		this.enableModificaTable = enableModificaTable;
		sendNotify(MyNotify.ENABLE_BUTTON_MODIFICA);

	}

	/**
	 * Enable elimina table.
	 *
	 * @param enableEliminaTable the enable elimina table
	 */
	public void enableEliminaTable(boolean enableEliminaTable) {
		this.enableEliminaTable = enableEliminaTable;
		sendNotify(MyNotify.ENABLE_BUTTON_ELIMINA);

	}

	/**
	 * Enable button acquisisci.
	 *
	 * @param enableButtonAcquisisci the enable button acquisisci
	 */
	public void enableButtonAcquisisci(boolean enableButtonAcquisisci) {
		this.enableButtonAcquisisci = enableButtonAcquisisci;
		sendNotify(MyNotify.ENABLE_BUTTON_ACQUISISCI);

	}

	/**
	 * Enable button aggiorna.
	 *
	 * @param enableButtonAggiorna the enable button aggiorna
	 */
	public void enableButtonAggiorna(boolean enableButtonAggiorna) {
		this.enableButtonAggiorna = enableButtonAggiorna;
		sendNotify(MyNotify.ENABLE_BUTTON_AGGIORNA);

	}

	/**
	 * Enable button inserisci gita.
	 *
	 * @param enableButtonInserisciGita the enable button inserisci gita
	 */
	public void enableButtonInserisciGita(boolean enableButtonInserisciGita) {
		this.enableButtonInserisciGita = enableButtonInserisciGita;
		sendNotify(MyNotify.ENABLE_BUTTON_GITA);

	}




	/**
	 * Gets the list assegnamento.
	 *
	 * @return the list assegnamento
	 */
	public ArrayList<Assegnamento> getListAssegnamento() {
		return listAssegnamento;
	}




	/**
	 * Sets the list assegnamento.
	 *
	 * @param listAssegnamento the new list assegnamento
	 */
	public void setListAssegnamento(ArrayList<Assegnamento> listAssegnamento) {
		this.listAssegnamento = listAssegnamento;
	}




	/**
	 * Gets the num sovrapposizioni.
	 *
	 * @return the num sovrapposizioni
	 */
	public int getNumSovrapposizioni() {
		return numSovrapposizioni;
	}




	/**
	 * Sets the num sovrapposizioni.
	 *
	 * @param numSovrapposizioni the new num sovrapposizioni
	 */
	public void setNumSovrapposizioni(int numSovrapposizioni) {
		this.numSovrapposizioni = numSovrapposizioni;
	}




	/**
	 * Gets the list attività inserite.
	 *
	 * @return the list attività inserite
	 */
	public ArrayList<Attività> getListAttivitàInserite() {
		return listAttivitàInserite;
	}




	/**
	 * Sets the list attività inserite.
	 *
	 * @param listAttivitàInserite the new list attività inserite
	 */
	public void setListAttivitàInserite(ArrayList<Attività> listAttivitàInserite) {
		this.listAttivitàInserite = listAttivitàInserite;
	}


	/**
	 * Attività in corso.
	 *
	 * @param idAtt the id att
	 * @param codice the codice
	 * @return true, if successful
	 */
	public boolean AttivitàInCorso(String idAtt, String codice){

		for (int i=0; i<this.getListPianoDiStudi().size(); i++){
			if (getListPianoDiStudi().get(i).getCorso().getCodice().equals(codice)){
				for (int j=0; j<getListPianoDiStudi().get(i).getElencoAttivitàObbligatorie().size(); j++){
					if (getListPianoDiStudi().get(i).getElencoAttivitàObbligatorie().get(j).getId().equals(idAtt))
						return true;
				}
				for (int j=0; j<getListPianoDiStudi().get(i).getElencoAttivitàOpzionali().size(); j++){
					if (getListPianoDiStudi().get(i).getElencoAttivitàOpzionali().get(j).getId().equals(idAtt))
						return true;
				}
			}
		}


		return false;
	}


	/**
	 * Cerca piano dato corso.
	 *
	 * @param id the id
	 * @return the piano di studi
	 */
	public PianoDiStudi cercaPianoDatoCorso (String id){

		for (int i=0; i<getListPianoDiStudi().size(); i++){
			if (getListPianoDiStudi().get(i).getCorso().getCodice().equals(id)){
				return getListPianoDiStudi().get(i);
			}
		}
		return null;

	}


	

	/**
	 * From orario to table.
	 */
	public void fromOrarioUfficialeToTable(){
		this.orarioDaMostrare = this.orarioUfficiale;
		fromOrarioDaMostrareToTable();
	}
	
	/**
	 * From orario to table.
	 */
	@SuppressWarnings("deprecation")
	public void fromOrarioDaMostrareToTable(){
		int countDay=0;
		int iRighe=0;
		int iColonne=0;

		int inizioOra = 8;
		int inizioMinuto = 30;

		int fineOra = 9;
		int fineMinuto = 00;


		Date inizio = new Date(1111, 1, 1, inizioOra, inizioMinuto);
		Date fine = new Date(1111, 1, 1, fineOra, fineMinuto);

		Format formatter = new SimpleDateFormat("HH:mm");
		String oraInizio = formatter.format(inizio);
		String oraFine = formatter.format(fine);

		
		for (int i=0; i<getListFasciaOraria().size(); i++){
						
			countDay = 0;
			tabella.addElement(new Vector<String>());
			for (int j=0; j<getOrarioDaMostrare().getElencoAssegnamenti().size(); j++){
				if (getOrarioDaMostrare().getElencoAssegnamenti().get(j).getFasciaOraria().equals(getListFasciaOraria().get(i)))
					countDay++;
			}
			
			
			
			if (iColonne == 0){
				tabella.get(iRighe).add(String.valueOf(oraInizio + " - " + oraFine));
				inizioMinuto+=30;
				fineMinuto+=30;

				inizio = new Date(1111, 1, 1, inizioOra, inizioMinuto);
				fine = new Date(1111, 1, 1, fineOra, fineMinuto);
				oraInizio = formatter.format(inizio);
				oraFine = formatter.format(fine);
			}

			tabella.get(iRighe).add(String.valueOf(countDay));

			iColonne = iColonne + iRighe/20;
			iRighe = (iRighe + 1)%21;

		}

	}

	
	
	/**
	 * Gets the attività from id.
	 *
	 * @param id the id
	 * @return the attività from id
	 */
	public Attività getAttivitàFromId (String id){

		int i;

		for (i=0; i<listGita.size(); i++){
			if (listGita.get(i).getId().equals(id)){
				break;
			}
		}
		if (i<listGita.size())
			return listGita.get(i);



		for (i=0; i<listConvegno.size(); i++){
			if (listConvegno.get(i).getId().equals(id)){
				break;
			}
		}

		if (i<listConvegno.size())
			return listConvegno.get(i);



		return null;

	}


	/**
	 * Gets the list docenti inseriti.
	 *
	 * @return the list docenti inseriti
	 */
	public ArrayList<Docente> getListDocentiInseriti() {
		return listDocentiInseriti;
	}




	/**
	 * Sets the list docenti inseriti.
	 *
	 * @param listDocentiInseriti the new list docenti inseriti
	 */
	public void setListDocentiInseriti(ArrayList<Docente> listDocentiInseriti) {
		this.listDocentiInseriti = listDocentiInseriti;
	}




	/**
	 * Gets the list attività dei docenti.
	 *
	 * @return the list attività dei docenti
	 */
	public ArrayList<Attività> getListAttivitàDeiDocenti() {
		return listAttivitàDeiDocenti;
	}




	/**
	 * Sets the list attività dei docenti.
	 *
	 * @param listAttivitàDeiDocenti the new list attività dei docenti
	 */
	public void setListAttivitàDeiDocenti(ArrayList<Attività> listAttivitàDeiDocenti) {
		this.listAttivitàDeiDocenti = listAttivitàDeiDocenti;
	}




	/**
	 * Gets the list all attività inserite.
	 *
	 * @return the list all attività inserite
	 */
	public ArrayList<Attività> getListAllAttivitàInserite() {
		return listAllAttivitàInserite;
	}




	/**
	 * Sets the list all attività inserite.
	 *
	 * @param listAllAttivitàInserite the new list all attività inserite
	 */
	public void setListAllAttivitàInserite(ArrayList<Attività> listAllAttivitàInserite) {
		this.listAllAttivitàInserite = listAllAttivitàInserite;
	}




	/**
	 * Gets the orario ufficiale.
	 *
	 * @return the orario ufficiale
	 */
	public Orario getOrarioUfficiale() {
		return orarioUfficiale;
	}

	/**
	 * Gets the orario da Mostrare.
	 *
	 * @return the orario da mostrare
	 */
	public Orario getOrarioDaMostrare() {
		return orarioDaMostrare;
	}


	/**
	 * Sets the orario ufficiale.
	 *
	 * @param orarioUfficiale the new orario ufficiale
	 */
	public void setOrarioUfficiale(Orario orarioUfficiale) {
		this.orarioUfficiale = orarioUfficiale;
		this.orarioDaMostrare = orarioUfficiale;
	}


	/**
	 * Sets the orario da mostrare.
	 *
	 * @param orarioUfficiale the new orario da mostrare
	 */
	public void setOrarioDaMostrare(Orario orario) {
		this.orarioDaMostrare = orario;
	}

	/**
	 * Gets the matrix.
	 *
	 * @return the matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}




	/**
	 * Sets the matrix.
	 *
	 * @param matrix the new matrix
	 */
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}




	/**
	 * Gets the list corso di studio inseriti.
	 *
	 * @return the list corso di studio inseriti
	 */
	public ArrayList<CorsoDiStudi> getListCorsoDiStudioInseriti() {
		return listCorsoDiStudioInseriti;
	}




	/**
	 * Sets the list corso di studio inseriti.
	 *
	 * @param listCorsoDiStudioInseriti the new list corso di studio inseriti
	 */
	public void setListCorsoDiStudioInseriti(ArrayList<CorsoDiStudi> listCorsoDiStudioInseriti) {
		this.listCorsoDiStudioInseriti = listCorsoDiStudioInseriti;
	}


	/**
	 * Find attività.
	 *
	 * @param id the id
	 * @return the attività
	 */
	public Attività findAttività(String id) {

		int i;
		Attività temp = new Attività();
		temp.setId(id);
		
		// cerca in Convegni
		i = listConvegno.lastIndexOf(temp);
		if ( i != -1 )
			return listConvegno.get(i);
		
		// cerca in Discipline
		i = listDisciplina.lastIndexOf(temp);
		if ( i != -1 )
			return listDisciplina.get(i);
		
		// cerca in Esami
		i = listEsame.lastIndexOf(temp);
		if ( i != -1 )
			return listEsame.get(i);
		
		// cerca in Gite
		i = listGita.lastIndexOf(temp);
		if ( i != -1 )
			return listGita.get(i);
		
		// cerca in Tirocini
		i = listTirocinio.lastIndexOf(temp);
		if ( i != -1 )
			return listTirocinio.get(i);
		
		// attività non trovata
		return null;
		
	}
	
	/**
	 * Find fascia oraria.
	 *
	 * @param id the id
	 * @return the fascia oraria
	 */
	public FasciaOraria findFasciaOraria(int id) {

		int i;
		FasciaOraria temp = new FasciaOraria();
		temp.setIdFascia(id);
		
		// cerca
		i = listFasciaOraria.lastIndexOf(temp);
		if ( i != -1 )
			return listFasciaOraria.get(i);
		
		// Fascia Oraria non trovata
		return null;
		
	}
	
	/**
	 * From id to disciplina.
	 *
	 * @param id the id
	 * @return the disciplina
	 */
	public Disciplina fromIdToDisciplina(String id){

		for (int i=0;i<getListDisciplina().size() ;i++){
			if(id.equals(getListDisciplina().get(i).getId())){
				return getListDisciplina().get(i);
			}
		}

		return null;

	}

	public void filtraOrario( Attività a ) {
		Iterator<Assegnamento> i = orarioUfficiale.getElencoAssegnamenti().iterator();
		orarioDaMostrare = new Orario();
		while( i != null && i.hasNext() ) {
			Assegnamento ax = i.next();
			if( a.equalsAtt(ax.getAttività()) ) {
				// aggiungere attività?
				orarioDaMostrare.aggiungiAssegnamento(ax);
			}
		}
	}
	
	public void filtraOrario( Docente d ) {
		Iterator<Assegnamento> i = orarioUfficiale.getElencoAssegnamenti().iterator();
		orarioDaMostrare = new Orario();
		while( i != null && i.hasNext() ) {
			Assegnamento ax = i.next();
			if( ax.getAttività().getElencoResponsabili().contains(d) ) {
				// aggiungere attività?
				orarioDaMostrare.aggiungiAssegnamento(ax);
			}
		}
	}	
	
	public void filtraOrario( CorsoDiStudi cds ) {
		filtraOrarioPerCorso(cds.getCodice());
	}
	
	public void filtraOrarioPerCorso( String codice ) {		
		Iterator<Assegnamento> i = orarioUfficiale.getElencoAssegnamenti().iterator();
		orarioDaMostrare = new Orario();
		while( i != null && i.hasNext() ) {
			Assegnamento ax = i.next();
			if( AttivitàInCorso(ax.getAttività().getId(), codice ) ) {
				// aggiungere attività?
				orarioDaMostrare.aggiungiAssegnamento(ax);
			}
		}
	}




	
	
}
