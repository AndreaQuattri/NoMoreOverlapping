package mvc;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Vector;

import myComponents.*;

public class Model extends Observable{

	private ArrayList<Assegnamento> listAssegnamento;
	private ArrayList<Aula> listAula;					//Fatto
	private ArrayList<Convegno> listConvegno;			//Fatto
	private ArrayList<CorsoDiStudi> listCorsoDiStudi;	//Fatto
	private ArrayList<Disciplina> listDisciplina;		//Fatto
	private ArrayList<Docente> listDocente;				//Fatto
	private ArrayList<Esame> listEsame;					//Da controllare un campo che ho tolto
	private ArrayList<FasciaOraria> listFasciaOraria;	//Fatto
	private ArrayList<Gita> listGita;					//Fatto
	private ArrayList<Orario> listOrario;
	private ArrayList<PianoDiStudi> listPianoDiStudi;	//Fatto
	private ArrayList<Studente> listStudente;			//Fatto
	private ArrayList<Tirocinio> listTirocinio;			//Fatto
	private Vector<Vector<String>> tabella;
	private Orario orarioUfficiale;
	private int[][] matrix;


	public Vector<Vector<String>> getTabella() {
		return tabella;
	}




	public void setTabella(Vector<Vector<String>> tabella) {
		this.tabella = tabella;
	}


	private ArrayList<Attività> listAttivitàInserite;
	private ArrayList<Docente> listDocentiInseriti;
	private ArrayList<Attività> listAttivitàDeiDocenti;
	private ArrayList<Disciplina> listAllAttivitàInserite;


	private boolean enableModificaTable;
	private boolean enableEliminaTable;
	private boolean enableButtonAcquisisci;
	private boolean enableButtonAggiorna;
	private boolean enableButtonInserisciGita;

	private int numSovrapposizioni;



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
		listOrario = new ArrayList<Orario>();
		listPianoDiStudi = new ArrayList<PianoDiStudi>();
		listStudente = new ArrayList<Studente>();
		listTirocinio = new ArrayList<Tirocinio>();
		tabella = new Vector<Vector<String>>();
		setListAttivitàInserite(new ArrayList<Attività>());
		listDocentiInseriti = new ArrayList<Docente>();
		setListAttivitàDeiDocenti(new ArrayList<Attività>());
		setListAllAttivitàInserite(new ArrayList<Disciplina>());
		setOrarioUfficiale(new Orario());
		matrix = new int[21][6];

		enableModificaTable = false;
		enableEliminaTable = false;
		enableButtonAcquisisci = false;
		enableButtonAggiorna = false;
		enableButtonInserisciGita = false;

	}




	public ArrayList<Aula> getListAula() {
		return listAula;
	}
	public void setListAula(ArrayList<Aula> listAula) {
		this.listAula = listAula;
	}
	public ArrayList<Convegno> getListConvegno() {
		return listConvegno;
	}
	public void setListConvegno(ArrayList<Convegno> listConvegno) {
		this.listConvegno = listConvegno;
	}
	public ArrayList<CorsoDiStudi> getListCorsoDiStudi() {
		return listCorsoDiStudi;
	}
	public void setListCorsoDiStudi(ArrayList<CorsoDiStudi> listCorsoDiStudi) {
		this.listCorsoDiStudi = listCorsoDiStudi;
	}
	public ArrayList<Disciplina> getListDisciplina() {
		return listDisciplina;
	}
	public void setListDisciplina(ArrayList<Disciplina> listDisciplina) {
		this.listDisciplina = listDisciplina;
	}
	public ArrayList<Docente> getListDocente() {
		return listDocente;
	}
	public void setListDocente(ArrayList<Docente> listDocente) {
		this.listDocente = listDocente;
	}
	public ArrayList<Esame> getListEsame() {
		return listEsame;
	}
	public void setListEsame(ArrayList<Esame> listEsame) {
		this.listEsame = listEsame;
	}
	public ArrayList<FasciaOraria> getListFasciaOraria() {
		return listFasciaOraria;
	}
	public void setListFasciaOraria(ArrayList<FasciaOraria> listFasciaOraria) {
		this.listFasciaOraria = listFasciaOraria;
	}
	public ArrayList<Gita> getListGita() {
		return listGita;
	}
	public void setListGita(ArrayList<Gita> listGita) {
		this.listGita = listGita;
	}
	public ArrayList<Orario> getListOrario() {
		return listOrario;
	}
	public void setListOrario(ArrayList<Orario> listOrario) {
		this.listOrario = listOrario;
	}
	public ArrayList<PianoDiStudi> getListPianoDiStudi() {
		return listPianoDiStudi;
	}
	public void setListPianoDiStudi(ArrayList<PianoDiStudi> listPianoDiStudi) {
		this.listPianoDiStudi = listPianoDiStudi;
	}
	public ArrayList<Studente> getListStudente() {
		return listStudente;
	}
	public void setListStudente(ArrayList<Studente> listStudente) {
		this.listStudente = listStudente;
	}
	public ArrayList<Tirocinio> getListTirocinio() {
		return listTirocinio;
	}
	public void setListTirocinio(ArrayList<Tirocinio> listTirocinio) {
		this.listTirocinio = listTirocinio;
	}

	private void sendNotify(int notifyID)
	{
		MyNotify notify = new MyNotify(notifyID); 

		setChanged();

		notifyObservers(notify);
	}




	public boolean isEnableModificaTable() {
		return enableModificaTable;
	}

	public boolean isEnableEliminaTable() {
		return enableEliminaTable;
	}

	public boolean isEnableButtonAcquisisci() {
		return enableButtonAcquisisci;
	}

	public boolean isEnableButtonAggiorna() {
		return enableButtonAggiorna;
	}

	public boolean isEnabledInserisciGita() {
		return enableButtonInserisciGita;
	}





	public void enableModificaTable(boolean enableModificaTable) {
		this.enableModificaTable = enableModificaTable;
		sendNotify(MyNotify.ENABLE_BUTTON_MODIFICA);

	}

	public void enableEliminaTable(boolean enableEliminaTable) {
		this.enableEliminaTable = enableEliminaTable;
		sendNotify(MyNotify.ENABLE_BUTTON_ELIMINA);

	}

	public void enableButtonAcquisisci(boolean enableButtonAcquisisci) {
		this.enableButtonAcquisisci = enableButtonAcquisisci;
		sendNotify(MyNotify.ENABLE_BUTTON_ACQUISISCI);

	}

	public void enableButtonAggiorna(boolean enableButtonAggiorna) {
		this.enableButtonAggiorna = enableButtonAggiorna;
		sendNotify(MyNotify.ENABLE_BUTTON_AGGIORNA);

	}

	public void enableButtonInserisciGita(boolean enableButtonInserisciGita) {
		this.enableButtonInserisciGita = enableButtonInserisciGita;
		sendNotify(MyNotify.ENABLE_BUTTON_GITA);

	}




	public ArrayList<Assegnamento> getListAssegnamento() {
		return listAssegnamento;
	}




	public void setListAssegnamento(ArrayList<Assegnamento> listAssegnamento) {
		this.listAssegnamento = listAssegnamento;
	}




	public int getNumSovrapposizioni() {
		return numSovrapposizioni;
	}




	public void setNumSovrapposizioni(int numSovrapposizioni) {
		this.numSovrapposizioni = numSovrapposizioni;
	}




	public ArrayList<Attività> getListAttivitàInserite() {
		return listAttivitàInserite;
	}




	public void setListAttivitàInserite(ArrayList<Attività> listAttivitàInserite) {
		this.listAttivitàInserite = listAttivitàInserite;
	}


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


	public PianoDiStudi cercaPianoDatoCorso (String id){

		for (int i=0; i<getListPianoDiStudi().size(); i++){
			if (getListPianoDiStudi().get(i).getCorso().getCodice().equals(id)){
				return getListPianoDiStudi().get(i);
			}
		}
		return null;

	}


	@SuppressWarnings("deprecation")
	public void fromOrarioToTable(){
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

		for (int i=0; i<getListOrario().size(); i++){
			countDay = 0;
			tabella.addElement(new Vector<String>());
			for (int j=0; j<getListOrario().get(i).getElencoAssegnamenti().size(); j++){
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


	public Attività getAttivitàFromId (int id){

		int i;
		
		for (i=0; i<listGita.size(); i++){
			
			if (listGita.get(i).getIdGita() == id){
				break;
			}

		}
		
		if (i == listGita.size())
			return null;
		
		Gita g = listGita.get(i);
				

		return g;

	}


	public ArrayList<Docente> getListDocentiInseriti() {
		return listDocentiInseriti;
	}




	public void setListDocentiInseriti(ArrayList<Docente> listDocentiInseriti) {
		this.listDocentiInseriti = listDocentiInseriti;
	}




	public ArrayList<Attività> getListAttivitàDeiDocenti() {
		return listAttivitàDeiDocenti;
	}




	public void setListAttivitàDeiDocenti(ArrayList<Attività> listAttivitàDeiDocenti) {
		this.listAttivitàDeiDocenti = listAttivitàDeiDocenti;
	}




	public ArrayList<Disciplina> getListAllAttivitàInserite() {
		return listAllAttivitàInserite;
	}




	public void setListAllAttivitàInserite(ArrayList<Disciplina> listAllAttivitàInserite) {
		this.listAllAttivitàInserite = listAllAttivitàInserite;
	}




	public Orario getOrarioUfficiale() {
		return orarioUfficiale;
	}




	public void setOrarioUfficiale(Orario orarioUfficiale) {
		this.orarioUfficiale = orarioUfficiale;
	}




	public int[][] getMatrix() {
		return matrix;
	}




	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}



}
