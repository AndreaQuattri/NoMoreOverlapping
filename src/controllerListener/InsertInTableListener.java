package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import elaborazioneDati.InsertInTable;
import mvc.MainView;

public class InsertInTableListener implements  ActionListener
{

	private MainView view;

	public InsertInTableListener(MainView view) {
		// TODO Auto-generated constructor stub
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent action)
	{

		view.getLabelTableInTable().setText((String)view.getComboBoxTable().getSelectedItem());

		InsertInTable insertInTable = new InsertInTable(view.getComboBoxTable().getSelectedItem());


		int rowAttuali = view.getTableRecords().getRowCount();
		for (int i=0; i< rowAttuali; i++)
			view.getTableRecords().removeRow(0);

		view.getTableRecords().setColumnCount(0);

		
		try {
			String toView[][] = insertInTable.getValues();

			String toInsertComboBox = "";
			for (int i=0; i<toView[0].length; i++){
				view.getTableRecords().addColumn(toView[0][i]);
			}


			for (int i=1; i<toView.length; i++){
				view.getTableRecords().addRow(toView[i]);
				for(int j=0; j<toView[i].length-1; j++)
					toInsertComboBox+=toView[i][j]+", ";
				toInsertComboBox+=toView[i][toView[i].length-1];
				view.getComboBoxRecord().addItem(toInsertComboBox);
				toInsertComboBox = "";
			}

			view.getTable().getColumnModel().getColumn(0).setMinWidth(5);
			view.getTable().getColumnModel().getColumn(0).setPreferredWidth(10);
			view.getTable().getColumnModel().getColumn(1).setPreferredWidth(10);
			view.getTable().getColumnModel().getColumn(2).setPreferredWidth(20);
			view.getTable().getColumnModel().getColumn(3).setPreferredWidth(360);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
