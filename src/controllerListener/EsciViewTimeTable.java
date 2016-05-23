package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.ViewTimeTable;

public class EsciViewTimeTable implements ActionListener{

	
	private ViewTimeTable viewOrario;
	
	public EsciViewTimeTable(ViewTimeTable viewOrario) {
		this.viewOrario = viewOrario;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		viewOrario.getFrame().setVisible(false);

	}

}
