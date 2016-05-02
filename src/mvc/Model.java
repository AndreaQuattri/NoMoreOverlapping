package mvc;

import java.util.ArrayList;
import java.util.Observable;

import myComponents.*;

public class Model extends Observable{
	
	private ArrayList<ArrayList<Assegnamento>> listAssegnamento;
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
	
	private boolean enableModificaTable;
	private boolean enableEliminaTable;
	private boolean enableButtonAcquisisci;
	private boolean enableButtonAggiorna;

	
	
	public Model() {

		listAssegnamento = new ArrayList<ArrayList<Assegnamento>>();
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
		

		enableModificaTable = false;
		enableEliminaTable = false;
		enableButtonAcquisisci = false;
		enableButtonAggiorna = false;
		
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




	public ArrayList<ArrayList<Assegnamento>> getListAssegnamento() {
		return listAssegnamento;
	}




	public void setListAssegnamento(ArrayList<ArrayList<Assegnamento>> listAssegnamento) {
		this.listAssegnamento = listAssegnamento;
	}


	
	

}
