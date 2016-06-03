package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.Model;

public class SelectedGitaListener implements  ActionListener
{

	private Model model;

	public SelectedGitaListener(Model model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent action)
	{


		model.enableButtonInserisciGita(true);

		//TODO
		/*
		 * 
		 * cancellare tabella, ecc..
		 * 
		 */



	}
}