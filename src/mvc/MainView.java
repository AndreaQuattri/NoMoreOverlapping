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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;

public class MainView extends JFrame implements Observer {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	
	
	/** The frame. */
	private JFrame frmNoMoreOverlapping;
	
	/** The button aggiorna. */
	private JButton buttonAggiorna;
	
	/** The label table selection. */
	private JLabel labelTableSelection;
	
	/** The button acquisisci. */
	private JButton buttonAcquisisci;
	
	/** The combo box table. */
	private JComboBox comboBoxTable;
	
	/** The button insert new table. */
	private JButton buttonInsertNewTable;
	
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
	
	public void pressButtonInserisci(ActionListener listener) {
		// TODO Auto-generated method stub
		buttonInsertNewTable.addActionListener(listener);
	}
	
	
	
	/**
	 * Inits the ui.
	 */
	private void initUI(){
		

		frmNoMoreOverlapping = new JFrame();
		frmNoMoreOverlapping.setTitle("No More Overlapping");
		frmNoMoreOverlapping.setBounds(100, 100, 900, 700);
		frmNoMoreOverlapping.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		buttonAggiorna = new JButton("Aggiorna");
		buttonAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		labelTableSelection = new JLabel("Selezione tabella");
		
		buttonAcquisisci = new JButton("Acquisisci");
		
		initComboTable();
		
		buttonInsertNewTable = new JButton("Inserisci Record");
		buttonInsertNewTable.setEnabled(false);
		
		buttonDeleteTable = new JButton("Elimina Record");
		buttonDeleteTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		buttonUpdateTable = new JButton("Modifica Record");
		
		comboBoxRecord = new JComboBox();
		
		labelTableShown = new JLabel("Tabella mostrata:");
		
		scrollPane = new JScrollPane();
		
		buttonGestioneOrario = new JButton("Gestione orario");
		
		

		tableRecords = new DefaultTableModel(0, 0);
		table = new JTable();
		table.setModel(tableRecords);


		
		scrollPane.setViewportView(table);
		
		labelTable = new JLabel("");
		
		JLabel lblSelezionaRecord = new JLabel("Seleziona record");
		GroupLayout groupLayout = new GroupLayout(frmNoMoreOverlapping.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblSelezionaRecord, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(comboBoxRecord, 0, 365, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(labelTableSelection)
											.addGap(18)
											.addComponent(comboBoxTable, 0, 365, Short.MAX_VALUE))
										.addComponent(labelTableShown, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(buttonAcquisisci, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
												.addComponent(buttonDeleteTable, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(buttonAggiorna, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(buttonUpdateTable, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
										.addComponent(buttonInsertNewTable, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 813, GroupLayout.PREFERRED_SIZE))
							.addGap(50)
							.addComponent(labelTable))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(335)
							.addComponent(buttonGestioneOrario, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelTableSelection)
						.addComponent(comboBoxTable, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonAggiorna)
						.addComponent(buttonAcquisisci))
					.addGap(4)
					.addComponent(buttonInsertNewTable)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSelezionaRecord)
								.addComponent(comboBoxRecord, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addComponent(labelTableShown))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(buttonUpdateTable, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttonDeleteTable)))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(184)
							.addComponent(labelTable))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonGestioneOrario)
					.addGap(29))
		);
		frmNoMoreOverlapping.getContentPane().setLayout(groupLayout);
		

	}
	
	private void initComboTable() {
		// TODO Auto-generated method stub
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
		
		
	}

	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public JFrame getFrame(){
		return frmNoMoreOverlapping;
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
