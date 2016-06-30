package controller_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;


import connect_to_database.Connect;
import mvc.MainView;
import url_php.Elimina;
import url_php.GiveAll;

public class DeleteRecordListener implements ActionListener{

	private MainView view;

	public DeleteRecordListener(MainView view) {
		// TODO Auto-generated constructor stub
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String nomeTabella = (String) view.getComboBoxTable().getSelectedItem();

		if (nomeTabella.equals("Attività"))
			deleteRecordAttivita();
		else if (nomeTabella.equals("Aula"))
			deleteRecordAula();
		else if (nomeTabella.equals("Convegno"))
			deleteRecordConvegno();
		else if (nomeTabella.equals("Corso di studi"))
			deleteRecordCorsoDiStudi();
		else if (nomeTabella.equals("Disciplina"))
			deleteRecordDisciplina();
		else if (nomeTabella.equals("Docente"))
			deleteRecordDocente();
		else if (nomeTabella.equals("Esame"))
			deleteRecordEsame();
		//FasciaOraria non può essere eliminata
		else if (nomeTabella.equals("Gita"))
			deleteRecordGita();
		else if (nomeTabella.equals("Insegna"))
			deleteRecordInsegna();
		else if (nomeTabella.equals("Piano di studio"))
			deleteRecordPianoDiStudi();
		else if (nomeTabella.equals("Preferenza aula"))
			deleteRecordPreferenzaAula();
		else if (nomeTabella.equals("Preferenza fascia oraria"))
			deleteRecordPreferenzaFasciaOraria();
		else if (nomeTabella.equals("Studente"))
			deleteRecordStudente();
		else if (nomeTabella.equals("Tirocinio"))
			deleteRecordTirocinio();
		

	}

	private void deleteRecordPreferenzaFasciaOraria() {
		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		String giorno = chiave[3].trim();
		String dataInizio = chiave[4].trim();
		String dataFine = chiave[5].trim();
		String idFasciaOraria = "";		

		try {
			String listaAttività = Connect.connectDb(GiveAll.giveAllFasciaOraria);
			String[] dividiPerRighe = listaAttività.split("_");
			int i;
			for(i=0; i<dividiPerRighe.length; i++){
				String[] dividiPerColonne = dividiPerRighe[i].split(",");
				if(dividiPerColonne[1].equals(giorno) &&
					dividiPerColonne[2].equals(dataInizio) &&
					dividiPerColonne[3].equals(dataFine)){
					idFasciaOraria = dividiPerColonne[0];
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		
		try {
			Connect.connectDb(Elimina.ELIMINA_PREFERENZAFASCIAORARIA+"?matricola="+chiave[0].trim()+"&IDFasciaOraria="+idFasciaOraria);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private void deleteRecordPianoDiStudi() {

		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		String nomeAttività = chiave[8].trim();
		String idAttività = "";		

		try {
			String listaAttività = Connect.connectDb(GiveAll.giveAllAttività);
			String[] dividiPerRighe = listaAttività.split("_");
			int i;
			for(i=0; i<dividiPerRighe.length; i++){
				String[] dividiPerColonne = dividiPerRighe[i].split(",");
				if(dividiPerColonne[1].equals(nomeAttività)){
					idAttività = dividiPerColonne[0];
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		try {
			Connect.connectDb(Elimina.ELIMINA_PIANODISTUDIO+"?IDCorsoDiStudi="+chiave[0].trim()+"&IDAttivita="+idAttività);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	private void deleteRecordInsegna() {
		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		String nomeAttività = chiave[3].trim();
		String idAttività = "";		

		try {
			String listaAttività = Connect.connectDb(GiveAll.giveAllAttività);
			String[] dividiPerRighe = listaAttività.split("_");
			int i;
			for(i=0; i<dividiPerRighe.length; i++){
				String[] dividiPerColonne = dividiPerRighe[i].split(",");
				if(dividiPerColonne[1].equals(nomeAttività)){
					idAttività = dividiPerColonne[0];
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		try {
			Connect.connectDb(Elimina.ELIMINA_INSEGNA+"?Matricola="+chiave[0].trim()+"&IDAttivita="+idAttività);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteRecordTirocinio() {
		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		try {
			Connect.connectDb(Elimina.ELIMINA_TIROCINIO+"?IDTirocinio="+chiave[0].trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void deleteRecordStudente() {
		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		try {
			Connect.connectDb(Elimina.ELIMINA_STUDENTE+"?Matricola="+chiave[0].trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void deleteRecordPreferenzaAula() {

		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		try {
			Connect.connectDb(Elimina.ELIMINA_PREFERENZAAULA+"?Matricola="+chiave[0].trim()+"&Edificio="+chiave[3].trim()+"&Numero="+chiave[4].trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void deleteRecordGita() {

		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		try {
			Connect.connectDb(Elimina.ELIMINA_GITA+"?IDGita="+chiave[0].trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteRecordEsame() {
		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		try {
			Connect.connectDb(Elimina.ELIMINA_ESAME+"?IDEsame="+chiave[0].trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void deleteRecordDisciplina() {
		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		try {
			Connect.connectDb(Elimina.ELIMINA_DISCIPLINA+"?IDDisciplina="+chiave[0].trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	private void deleteRecordDocente() {
		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		try {
			Connect.connectDb(Elimina.ELIMINA_DOCENTE+"?Matricola="+chiave[0].trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void deleteRecordCorsoDiStudi() {

		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		try {
			Connect.connectDb(Elimina.ELIMINA_CORSODISTUDI+"?IDCorsoDiStudi="+chiave[0].trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteRecordConvegno() {

		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		try {
			Connect.connectDb(Elimina.ELIMINA_CONVEGNO+"?IDConvegno="+chiave[0].trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteRecordAula() {

		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] chiave = recordDaEliminare.split(",");

		try {
			Connect.connectDb(Elimina.ELIMINA_AULA+"?Edificio="+chiave[0].trim()+"&Numero="+chiave[1].trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteRecordAttivita(){

		String recordDaEliminare = (String) view.getComboBoxRecord().getSelectedItem();
		String[] id = recordDaEliminare.split(",");

		try {
			Connect.connectDb(Elimina.ELIMINA_ATTIVITA+"?IDAttivita="+id[0].trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
