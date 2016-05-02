package mvc;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

public class ViewTimeTable extends JFrame implements Observer {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private JFrame frame;
	private JButton buttonInsertNewTable;
	private JButton buttonNewOrario;
	private JButton buttonLoadOrario;
	private JButton buttonGestioneOrario;
	private JLabel labelTableInTable;


	private JScrollPane scrollPane;
	private DefaultTableModel tableRecords;
	private JTable table;
	
	
	private Model model;
	
	
	public ViewTimeTable(Model model) {

		this.model = model;
		initUI();
		
		// View as observer of model
		model.addObserver(this);

		// Init view like model
		initViewLikeModel();

	
	}

	

	
	public void pressButtonGestisciOrario(ActionListener listener) {
		// TODO Auto-generated method stub
		buttonGestioneOrario.addActionListener(listener);
		
	}

	
	
	
	private void initUI(){
		

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		
		buttonInsertNewTable = new JButton("Modifica esistente");
		
		buttonNewOrario = new JButton("Nuovo Orario");
		
		buttonLoadOrario = new JButton("Carica orario");
		
		scrollPane = new JScrollPane();
		
		buttonGestioneOrario = new JButton("Gestione orario");
		
		labelTableInTable = new JLabel("");
		

		tableRecords = new DefaultTableModel(0, 0);
		table = new JTable();
		table.setModel(tableRecords);


		
		scrollPane.setViewportView(table);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(326)
							.addComponent(buttonGestioneOrario, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(114)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(buttonLoadOrario, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonNewOrario, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 775, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(193)
									.addComponent(buttonInsertNewTable, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(buttonNewOrario)
					.addGap(22)
					.addComponent(buttonLoadOrario)
					.addGap(124)
					.addComponent(buttonInsertNewTable)
					.addGap(51)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(buttonGestioneOrario))
		);
		frame.getContentPane().setLayout(groupLayout);
		

	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	private void initViewLikeModel()
	{
		
		//buttonLoadOrario.setEnabled(model.isEnableModificaTable());
		//buttonNewOrario.setEnabled(model.isEnableModificaTable());

	}
	
	private void enableUpdateTable()
	{
		buttonLoadOrario.setEnabled(model.isEnableModificaTable());
	}

	private void enableDeleteTable()
	{
		buttonNewOrario.setEnabled(model.isEnableEliminaTable());

	}
	

	
	// Update the view with the notify send by model
		@Override
		public void update(Observable o, Object arg)
		{
			MyNotify notify = (MyNotify) arg;

			switch (notify.getNotifyID())
			{
			case MyNotify.ENABLE_BUTTON_MODIFICA:
				enableUpdateTable();
			break;
			case MyNotify.ENABLE_BUTTON_ELIMINA:
				enableDeleteTable();
			break;


				
				
			}

		}

		

		public void setComboBoxTable(JComboBox comboBoxTable) {
		}

		public JTable getTable() {
			return table;
		}

		public void setTable(JTable table) {
			this.table = table;
		}

		public DefaultTableModel getTableRecords() {
			return tableRecords;
		}

		public void setTableRecords(DefaultTableModel tableRecords) {
			this.tableRecords = tableRecords;
		}

		
		public JLabel getLabelTableInTable() {
			return labelTableInTable;
		}

		public void setLabelTableInTable(JLabel labelTableInTable) {
			this.labelTableInTable = labelTableInTable;
		}




		public void pressButtonNewOrario(ActionListener listener) {
			// TODO Auto-generated method stub
			buttonNewOrario.addActionListener(listener);
		}
}
