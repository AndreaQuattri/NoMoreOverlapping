package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.ManagementTableView;

public class UpdateRecordListener implements  ActionListener
{
	
	private String selectedItem;
	
	public UpdateRecordListener(String selectedItem) {
		// TODO Auto-generated constructor stub
		this.selectedItem = selectedItem;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent action)
	{


		ManagementTableView managment = new ManagementTableView(selectedItem);
		managment.setVisible(true);


	}
}
