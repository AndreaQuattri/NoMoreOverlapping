package mvc;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonModel;
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
	private JLabel lblTableShown;
	private JScrollPane scrollPane;
	private GroupLayout groupLayout;
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

	public void selectTableToView(ActionListener listener)
	{
		comboBoxTable.addActionListener(listener);
	}
	
	
	
	private void initUI(){
		

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		buttonAggiorna = new JButton("Aggiorna");
		
		labelTableSelection = new JLabel("Selezione tabella");
		
		buttonAcquisisci = new JButton("Acquisisci");
		
		comboBoxTable = new JComboBox();
		comboBoxTable.addItem("");
		comboBoxTable.addItem("Attività");
		comboBoxTable.addItem("Aula");
		comboBoxTable.addItem("Convegno");
		comboBoxTable.addItem("Corso di studi");
		comboBoxTable.addItem("Disciplina");
		comboBoxTable.addItem("Docente");
		comboBoxTable.addItem("Esame");
		comboBoxTable.addItem("Fascia oraria");
		comboBoxTable.addItem("Gita");
		comboBoxTable.addItem("Insegna");
		comboBoxTable.addItem("Piano di studio");
		comboBoxTable.addItem("Preferenza aula");
		comboBoxTable.addItem("Preferenza fascia oraria");
		comboBoxTable.addItem("Studente");
		comboBoxTable.addItem("Tirocinio");
		
		buttonInsertNewTable = new JButton("Inserisci nuova tabella");
		
		labelDeleteTable = new JLabel("Elimina tabella");
		
		labelUpdateTable = new JLabel("Modifica tabella");
		
		buttonDeleteTable = new JButton("Elimina");
		
		buttonUpdateTable = new JButton("Modifica");
		
		comboBoxRecord = new JComboBox();
		
		lblTableShown = new JLabel("Tabella mostrata:");
		
		scrollPane = new JScrollPane();
		
		buttonInfo = new JButton("I");
		groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(buttonInsertNewTable, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
							.addGap(87)
							.addComponent(comboBoxRecord, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(labelDeleteTable, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(buttonDeleteTable, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(294)
							.addComponent(lblTableShown, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(labelUpdateTable, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addGap(39)
									.addComponent(buttonUpdateTable, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))))
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
							.addContainerGap()
							.addComponent(buttonInfo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(buttonInfo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
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
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonInsertNewTable)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBoxRecord, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(40)
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
					.addComponent(lblTableShown)
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		
		DefaultTableModel tableRecords = new DefaultTableModel();
		JTable table = new JTable(tableRecords); 
		
		table.setModel(new DefaultTableModel(
				new String[][]{
					
				},
				new String[]{
						//"Edificio","Numero"
				}
				
		));
		
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
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
			case MyNotify.TABLE_SELECTED:
				
				enableUpdateTable();
				enableDeleteTable();
				enableButtonAcquisisci();
				enableButtonAggiorna();
				
			}

		}
	
}
