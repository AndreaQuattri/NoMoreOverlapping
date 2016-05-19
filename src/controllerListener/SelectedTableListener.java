package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.Model;

public class SelectedTableListener implements  ActionListener
{
	private Model model;
	
	public SelectedTableListener(Model model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent action)
	{

		model.enableModificaTable(true);
		model.enableEliminaTable(true);
		model.enableButtonAcquisisci(true);
		model.enableButtonAggiorna(true);

		//TODO
		/*
		 * 
		 * cancellare tabella, ecc..
		 * 
		 */



	}
}