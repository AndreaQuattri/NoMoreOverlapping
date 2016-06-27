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

public class MainView extends JFrame implements Observer {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private JFrame frame;
	private JButton buttonAggiorna;
	private JButton buttonInfo;
	private JLabel labelTableSelection;
	private JButton buttonAcquisisci;
	private JComboBox comboBoxTable;
	private JButton buttonInsertNewTable;
	private JLabel labelDeleteTable;
	private JLabel labelUpdateTable;
	private JButton buttonDeleteTable;
	private JButton buttonUpdateTable;
	private JComboBox comboBoxRecord;
	private JButton buttonGestioneOrario;
	private JLabel labelTable;





	private JLabel labelTableShown;


	private JScrollPane scrollPane;
	private DefaultTableModel tableRecords;
	private JTable table;
	
	
	private Model model;
	
	
	public MainView(Model model) {

		this.model = model;
		initUI();

		
		
		// View as observer of model
		model.addObserver(this);

		// Init view like model
		initViewLikeModel();

	
	}

	public void selectedTableToView(ActionListener listener)
	{
		getComboBoxTable().addActionListener(listener);
	}
	
	public void pressButtonAcquisisci(ActionListener listener) {
		// TODO Auto-generated method stub
		buttonAcquisisci.addActionListener(listener);
		
	}
	
	public void pressButtonGestisciOrario(ActionListener listener) {
		// TODO Auto-generated method stub
		buttonGestioneOrario.addActionListener(listener);
		
	}

	public void pressButtonModifica(ActionListener listener) {
		// TODO Auto-generated method stub
		buttonUpdateTable.addActionListener(listener);
		
	}
	
	public void pressButtonInserisci(ActionListener listener) {
		// TODO Auto-generated method stub
		buttonInsertNewTable.addActionListener(listener);
	}
	
	
	
	private void initUI(){
		

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		buttonAggiorna = new JButton("Aggiorna");
		
		labelTableSelection = new JLabel("Selezione tabella");
		
		buttonAcquisisci = new JButton("Acquisisci");
		
		initComboTable();
		
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

	public JFrame getFrame(){
		return frame;
	}
	
	private void initViewLikeModel()
	{
		
		buttonUpdateTable.setEnabled(model.isEnableModificaTable());
		buttonDeleteTable.setEnabled(model.isEnableModificaTable());
		buttonAcquisisci.setEnabled(model.isEnableButtonAcquisisci());
		buttonAggiorna.setEnabled(model.isEnableButtonAggiorna());

	}
	
	private void enableUpdateTable()
	{
		buttonUpdateTable.setEnabled(model.isEnableModificaTable());
	}

	private void enableDeleteTable()
	{
		buttonDeleteTable.setEnabled(model.isEnableEliminaTable());

	}
	
	private void enableButtonAcquisisci()
	{
		buttonAcquisisci.setEnabled(model.isEnableButtonAcquisisci());

	}
	
	private void enableButtonAggiorna()
	{
		buttonAggiorna.setEnabled(model.isEnableButtonAggiorna());

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
			case MyNotify.ENABLE_BUTTON_ACQUISISCI:
				enableButtonAcquisisci();
			break;
			case MyNotify.ENABLE_BUTTON_AGGIORNA:
				enableButtonAggiorna();
			break;

				
				
			}

		}

		public JComboBox getComboBoxTable() {
			return comboBoxTable;
		}

		public void setComboBoxTable(JComboBox comboBoxTable) {
			this.comboBoxTable = comboBoxTable;
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
		
		public JComboBox getComboBoxRecord() {
			return comboBoxRecord;
		}

		public void setComboBoxRecord(JComboBox comboBoxRecord) {
			this.comboBoxRecord = comboBoxRecord;
		}

		public JLabel getLabelTable() {
			return labelTable;
		}

		public void setLabelTable(JLabel labelTable) {
			this.labelTable = labelTable;
		}

		
}
