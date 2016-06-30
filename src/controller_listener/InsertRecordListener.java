package controller_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

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


		InsertTableView insert;
		try {
			insert = new InsertTableView((String) view.getComboBoxTable().getSelectedItem());
			insert.setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
