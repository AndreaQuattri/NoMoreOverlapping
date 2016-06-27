/*
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class MainView.
 */
public class MainView extends JFrame implements Observer {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	
	
	/** The frame. */
	private JFrame frame;
	
	/** The button aggiorna. */
	private JButton buttonAggiorna;
	
	/** The button info. */
	private JButton buttonInfo;
	
	/** The label table selection. */
	private JLabel labelTableSelection;
	
	/** The button acquisisci. */
	private JButton buttonAcquisisci;
	
	/** The combo box table. */
	private JComboBox comboBoxTable;
	
	/** The button insert new table. */
	private JButton buttonInsertNewTable;
	
	/** The label delete table. */
	private JLabel labelDeleteTable;
	
	/** The label update table. */
	private JLabel labelUpdateTable;
	
	/** The button delete table. */
	private JButton buttonDeleteTable;
	
	/** The button update table. */
	private JButton buttonUpdateTable;
	
	/** The combo box record. */
	private JComboBox comboBoxRecord;
	
	/** The button gestione orario. */
	private JButton buttonGestioneOrario;
	
	/** The label table. */
	private JLabel labelTable;





	/** The label table shown. */
	private JLabel labelTableShown;


	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The table records. */
	private DefaultTableModel tableRecords;
	
	/** The table. */
	private JTable table;
	
	
	/** The model. */
	private Model model;
	
	
	/**
	 * Instantiates a new main view.
	 *
	 * @param model the model
	 */
	public MainView(Model model) {

		this.model = model;
		initUI();

		
		
		// View as observer of model
		model.addObserver(this);

		// Init view like model
		initViewLikeModel();

	
	}

	/**
	 * Selected table to view.
	 *
	 * @param listener the listener
	 */
	public void selectedTableToView(ActionListener listener)
	{
		getComboBoxTable().addActionListener(listener);
	}
	
	/**
	 * Press button acquisisci.
	 *
	 * @param listener the listener
	 */
	public void pressButtonAcquisisci(ActionListener listener) {
		// TODO Auto-generated method stub
		buttonAcquisisci.addActionListener(listener);
		
	}
	
	/**
	 * Press button gestisci orario.
	 *
	 * @param listener the listener
	 */
	public void pressButtonGestisciOrario(ActionListener listener) {
		// TODO Auto-generated method stub
		buttonGestioneOrario.addActionListener(listener);
		
	}

	/**
	 * Press button modifica.
	 *
	 * @param listener the listener
	 */
	public void pressButtonModifica(ActionListener listener) {
		// TODO Auto-generated method stub
		buttonUpdateTable.addActionListener(listener);
		
	}
	
	
	/**
	 * Inits the ui.
	 */
	private void initUI(){
		

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		buttonAggiorna = new JButton("Aggiorna");
		
		labelTableSelection = new JLabel("Selezione tabella");
		
		buttonAcquisisci = new JButton("Acquisisci");
		
		setComboBoxTable(new JComboBox());
		getComboBoxTable().addItem("");
		getComboBoxTable().addItem("Attività");
		getComboBoxTable().addItem("Aula");
		getComboBoxTable().addItem("Convegno");
		getComboBoxTable().addItem("Corso di studi");
		getComboBoxTable().addItem("Disciplina");
		getComboBoxTable().addItem("Docente");
		getComboBoxTable().addItem("Esame");
		getComboBoxTable().addItem("Fascia oraria");
		getComboBoxTable().addItem("Gita");
		getComboBoxTable().addItem("Insegna");
		getComboBoxTable().addItem("Piano di studio");
		getComboBoxTable().addItem("Preferenza aula");
		getComboBoxTable().addItem("Preferenza fascia oraria");
		getComboBoxTable().addItem("Studente");
		getComboBoxTable().addItem("Tirocinio");
		
		buttonInsertNewTable = new JButton("Inserisci nuova tabella");
		
		labelDeleteTable = new JLabel("Elimina tabella");
		
		labelUpdateTable = new JLabel("Modifica tabella");
		
		buttonDeleteTable = new JButton("Elimina");
		
		buttonUpdateTable = new JButton("Modifica");
		
		comboBoxRecord = new JComboBox();
		
		labelTableShown = new JLabel("Tabella mostrata:");
		
		scrollPane = new JScrollPane();
		
		buttonInfo = new JButton("I");
		
		buttonGestioneOrario = new JButton("Gestione orario");
		
		

		tableRecords = new DefaultTableModel(0, 0);
		table = new JTable();
		table.setModel(tableRecords);


		
		scrollPane.setViewportView(table);
		
		labelTable = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(buttonInfo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(labelTableSelection)
							.addGap(85)
							.addComponent(comboBoxTable, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addGap(87)
							.addComponent(buttonAcquisisci, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(75)
							.addComponent(buttonAggiorna, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(buttonInsertNewTable, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
							.addGap(131)
							.addComponent(comboBoxRecord, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(labelDeleteTable, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(buttonDeleteTable, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(labelUpdateTable, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(buttonUpdateTable, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(294)
							.addComponent(labelTableShown, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addComponent(labelTable))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 775, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(326)
							.addComponent(buttonGestioneOrario, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(buttonInfo)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(labelTableSelection))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(comboBoxTable, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(buttonAcquisisci)
						.addComponent(buttonAggiorna))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonInsertNewTable)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBoxRecord, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(labelDeleteTable))
						.addComponent(buttonDeleteTable))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(labelUpdateTable))
						.addComponent(buttonUpdateTable))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelTableShown)
						.addComponent(labelTable))
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(buttonGestioneOrario))
		);
		frame.getContentPane().setLayout(groupLayout);
		

	}
	
	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public JFrame getFrame(){
		return frame;
	}
	
	/**
	 * Inits the view like model.
	 */
	private void initViewLikeModel()
	{
		
		buttonUpdateTable.setEnabled(model.isEnableModificaTable());
		buttonDeleteTable.setEnabled(model.isEnableModificaTable());
		buttonAcquisisci.setEnabled(model.isEnableButtonAcquisisci());
		buttonAggiorna.setEnabled(model.isEnableButtonAggiorna());

	}
	
	/**
	 * Enable update table.
	 */
	private void enableUpdateTable()
	{
		buttonUpdateTable.setEnabled(model.isEnableModificaTable());
	}

	/**
	 * Enable delete table.
	 */
	private void enableDeleteTable()
	{
		buttonDeleteTable.setEnabled(model.isEnableEliminaTable());

	}
	
	/**
	 * Enable button acquisisci.
	 */
	private void enableButtonAcquisisci()
	{
		buttonAcquisisci.setEnabled(model.isEnableButtonAcquisisci());

	}
	
	/**
	 * Enable button aggiorna.
	 */
	private void enableButtonAggiorna()
	{
		buttonAggiorna.setEnabled(model.isEnableButtonAggiorna());

	}
	
	
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
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
			case MyNotify.ENABLE_BUTTON_ACQUISISCI:
				enableButtonAcquisisci();
			break;
			case MyNotify.ENABLE_BUTTON_AGGIORNA:
				enableButtonAggiorna();
			break;

				
				
			}

		}

		/**
		 * Gets the combo box table.
		 *
		 * @return the combo box table
		 */
		public JComboBox getComboBoxTable() {
			return comboBoxTable;
		}

		/**
		 * Sets the combo box table.
		 *
		 * @param comboBoxTable the new combo box table
		 */
		public void setComboBoxTable(JComboBox comboBoxTable) {
			this.comboBoxTable = comboBoxTable;
		}

		/**
		 * Gets the table.
		 *
		 * @return the table
		 */
		public JTable getTable() {
			return table;
		}

		/**
		 * Sets the table.
		 *
		 * @param table the new table
		 */
		public void setTable(JTable table) {
			this.table = table;
		}

		/**
		 * Gets the table records.
		 *
		 * @return the table records
		 */
		public DefaultTableModel getTableRecords() {
			return tableRecords;
		}

		/**
		 * Sets the table records.
		 *
		 * @param tableRecords the new table records
		 */
		public void setTableRecords(DefaultTableModel tableRecords) {
			this.tableRecords = tableRecords;
		}
		
		/**
		 * Gets the combo box record.
		 *
		 * @return the combo box record
		 */
		public JComboBox getComboBoxRecord() {
			return comboBoxRecord;
		}

		/**
		 * Sets the combo box record.
		 *
		 * @param comboBoxRecord the new combo box record
		 */
		public void setComboBoxRecord(JComboBox comboBoxRecord) {
			this.comboBoxRecord = comboBoxRecord;
		}

		/**
		 * Gets the label table.
		 *
		 * @return the label table
		 */
		public JLabel getLabelTable() {
			return labelTable;
		}

		/**
		 * Sets the label table.
		 *
		 * @param labelTable the new label table
		 */
		public void setLabelTable(JLabel labelTable) {
			this.labelTable = labelTable;
		}
		
}
