/*
 * 
 */
package controller_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JTable;

import elaborazione_dati.InsertInTable;
import elaborazione_dati.LarghezzaColonne;
import mvc.MainView;
import mvc.Model;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving insertInTable events.
 * The class that is interested in processing a insertInTable
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addInsertInTableListener<code> method. When
 * the insertInTable event occurs, that object's appropriate
 * method is invoked.
 *
 * @see InsertInTableEvent
 */
public class InsertInTableListener implements  ActionListener
{

	/** The view. */
	private MainView view;

	private Model model;

	/**
	 * Instantiates a new insert in table listener.
	 *
	 * @param view the view
	 */
	public InsertInTableListener(MainView view, Model model) {
		// TODO Auto-generated constructor stub
		this.view = view;
		this.model = model;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{

		model.enableInserisciButton(true);
		model.enableEliminaTable(true);
		model.enableModificaTable(true);



		view.getLabelTable().setText((String)view.getComboBoxTable().getSelectedItem());

		view.getComboBoxRecord().removeAllItems();

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

			LarghezzaColonne larghezzaColonne = new LarghezzaColonne(view.getComboBoxTable().getSelectedItem());

			int[] vettLarg = larghezzaColonne.getLarghezza();


			view.getTable().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			view.getTable().getColumnModel().getColumn(0).setMinWidth(0);

			for(int i=0; i<vettLarg.length; i++){
				view.getTable().getColumnModel().getColumn(i).setPreferredWidth(vettLarg[i]);
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
