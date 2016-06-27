package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.InsertTableView;
import mvc.MainView;

public class InsertRecordListener implements  ActionListener
{
	
	private MainView view;
	
	public InsertRecordListener(MainView view) {
		// TODO Auto-generated constructor stub
		this.view = view;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent action)
	{


		InsertTableView insert = new InsertTableView((String) view.getComboBoxTable().getSelectedItem());
		insert.setVisible(true);


	}
}
