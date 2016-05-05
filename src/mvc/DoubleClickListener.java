package mvc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

public class DoubleClickListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//se non è doppio click ritorno		


		System.out.println("Nella funzione");

		/*
		if(e.getClickCount() < 2){
			System.out.println("One click");
			return;
		}
		 */

		//Considero solo i click del pulsante sinistro;
		//se vuoi gestire l'evento anche se si fa dopppio
		//click col tasto destro commenta questo if
		if(e.getButton() != MouseEvent.BUTTON1){
			System.out.println("Tasto destro");
			return;
		}
		//Ricavo la tabella che ha prodotto l'evento
		JTable table = (JTable)e.getSource();
		//Calcolo la riga su cui si è fatto click
		int clickedRow = table.rowAtPoint(e.getPoint());
		//Se non è la riga che mi interessa ritorno
		if(clickedRow != 1){
			System.out.println("Riga diversa da 1");
			return;
		}
		//Altrimenti costruisco la nuova finestra
		//.....
		//......
		//.....


		ManagementTableView m = new ManagementTableView();
		m.setVisible(true);


	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
