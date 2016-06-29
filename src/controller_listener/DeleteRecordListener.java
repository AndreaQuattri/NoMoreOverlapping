package controller_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import connect_to_database.Connect;
import mvc.MainView;
import url_php.Elimina;

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
