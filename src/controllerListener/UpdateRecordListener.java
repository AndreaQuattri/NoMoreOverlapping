package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.MainView;
import mvc.ManagementTableView;
import mvc.ViewTimeTable;

public class UpdateRecordListener implements  ActionListener
{
	
	private MainView view;
	
	public UpdateRecordListener(MainView view) {
		// TODO Auto-generated constructor stub
		this.view = view;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent action)
	{


		ManagementTableView managment = new ManagementTableView((String) view.getComboBoxTable().getSelectedItem());
		managment.setVisible(true);


	}
}
