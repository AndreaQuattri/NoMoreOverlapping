package mvc;

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
		//initViewLikeModel();

	
	}

	
	
	
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	private void initUI(){
		

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		buttonAggiorna = new JButton("Aggiorna");
		
		labelTableSelection = new JLabel("New label");
		
		buttonAcquisisci = new JButton("Acquisisci");
		
		comboBoxTable = new JComboBox();
		comboBoxTable.addItem("ciao");
		
		buttonInsertNewTable = new JButton("New button");
		
		labelDeleteTable = new JLabel("Elimina tabella");
		
		labelUpdateTable = new JLabel("Modifica tabella");
		
		buttonDeleteTable = new JButton("Elimina");
		
		buttonUpdateTable = new JButton("Modifica");
		
		comboBoxRecord = new JComboBox();
		
		lblTableShown = new JLabel("Tabella mostrata:");
		
		scrollPane = new JScrollPane();
		groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
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
							.addComponent(buttonUpdateTable, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addGap(284))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
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



}
