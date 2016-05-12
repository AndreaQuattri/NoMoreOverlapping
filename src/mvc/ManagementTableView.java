package mvc;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ManagementTableView extends JFrame {
	
	
	private static final long serialVersionUID = 1L;


	public ManagementTableView(String tabella)
	{

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 600);
		
		
		
		if (tabella.equals("Aula"))
			initAula();
	

		
		getContentPane().setLayout(null);

		
		
	}
	
	private void initAula(){
		JLabel labelEdificio = new JLabel("Edificio");
		labelEdificio.setBounds(69, 71, 117, 29);
		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setBounds(69, 101, 117, 29);
		
		getContentPane().add(labelEdificio);
		getContentPane().add(labelNumero);

	}
}
