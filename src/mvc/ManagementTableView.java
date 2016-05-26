package mvc;

import javax.swing.JFrame;
import javax.swing.JButton;

public class ManagementTableView extends JFrame {


	private static final long serialVersionUID = 1L;



	public ManagementTableView()
	{
		getContentPane().setLayout(null);
		
		JButton btnProva = new JButton("Prova");
		btnProva.setBounds(42, 38, 117, 29);
		getContentPane().add(btnProva);
		

		
	}
}
