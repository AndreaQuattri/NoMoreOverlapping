package mvc;

import java.awt.Desktop.Action;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ViewTimeTable extends JFrame implements Observer {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private JFrame frame;
	private JButton buttonNewOrario;
	private JButton buttonNewOrario2;
	private JButton buttonLoadOrario;
	private JLabel labelTableInTable;
	private JComboBox comboBoxSemestre;
	private JComboBox comboBoxAttivitàInserite;
	private JComboBox comboBoxPiani;
	private JComboBox comboBoxDocenti;

	
	public JComboBox getComboBoxPiani() {
		return comboBoxPiani;
	}






	public void setComboBoxPiani(JComboBox comboBoxPiani) {
		this.comboBoxPiani = comboBoxPiani;
	}




	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem apri;
	private JMenuItem esci;
	private JMenu radioButtonMenu;
	private JRadioButtonMenuItem buttonSem1;
    private JRadioButtonMenuItem buttonSem2;
    private ButtonGroup group;


	public JComboBox getComboBoxAttivitàInserite() {
		return comboBoxAttivitàInserite;
	}






	public void setComboBoxAttivitàInserite(JComboBox comboBoxAttivitàInserite) {
		this.comboBoxAttivitàInserite = comboBoxAttivitàInserite;
	}




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
		
		menuBar = new JMenuBar();
        menuFile = new JMenu("Setup");
            apri = new JMenuItem("Apri");
            esci = new JMenuItem("Esci");
            radioButtonMenu = new JMenu("Seleziona semestre");
                buttonSem1 = new JRadioButtonMenuItem("1");
                buttonSem2 = new JRadioButtonMenuItem("2");
                group = new ButtonGroup();
                group.add(buttonSem1);
                group.add(buttonSem2);
            radioButtonMenu.add(buttonSem1);
            radioButtonMenu.add(buttonSem2);
        menuFile.add(apri);
        menuFile.add(radioButtonMenu);//popup pull-right
        
        menuFile.addSeparator();
        menuFile.add(esci);
        
        menuBar.add(menuFile);

        frame.setJMenuBar(menuBar);
//        panelCenter = new JPanel();
//        super.getContentPane().add(panelCenter, BorderLayout.CENTER);
        

	
	}



	
	
	
	private void initUI(){
		

		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 700);
		
		buttonNewOrario = new JButton("Nuovo Orario");
		
		buttonLoadOrario = new JButton("Carica orario");
		
		scrollPane = new JScrollPane();
		
		labelTableInTable = new JLabel("");
		

		tableRecords = new DefaultTableModel(0, 0);
		table = new JTable();
		table.setModel(tableRecords);
		table.addMouseListener(new DoubleClickListener(model));

		
		scrollPane.setViewportView(table);
		
		comboBoxSemestre = new JComboBox();
		comboBoxSemestre.addItem("1");
		comboBoxSemestre.addItem("2");
		
		comboBoxAttivitàInserite = new JComboBox();
		comboBoxAttivitàInserite.addItem("");
		
		buttonNewOrario2 = new JButton("Nuovo Orario 2");
		
		comboBoxPiani = new JComboBox();
		comboBoxPiani.addItem("");
		
		comboBoxDocenti = new JComboBox();
		comboBoxDocenti.addItem("");

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(868, Short.MAX_VALUE)
							.addComponent(comboBoxDocenti, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(114)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(buttonNewOrario, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
											.addGap(215)
											.addComponent(comboBoxSemestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(buttonLoadOrario, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(259)
									.addComponent(buttonNewOrario2)))
							.addPreferredGap(ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBoxPiani, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxAttivitàInserite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(172))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 775, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(259, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonNewOrario)
						.addComponent(comboBoxSemestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonNewOrario2)
						.addComponent(comboBoxAttivitàInserite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonLoadOrario)
						.addComponent(comboBoxPiani, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(comboBoxDocenti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
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
		

		public void pressButtonNewOrario2(ActionListener listener) {
			// TODO Auto-generated method stub
			buttonNewOrario2.addActionListener(listener);

		}
		

		public void selectedActivityToView(ActionListener listener) {
			// TODO Auto-generated method stub
			comboBoxAttivitàInserite.addActionListener(listener);
			
		}
		
		

		public void selectedPianoToView(ActionListener listener) {
			// TODO Auto-generated method stub
			comboBoxPiani.addActionListener(listener);
			
		}
		
		public void selectedDocenteToView(ActionListener listener) {
			// TODO Auto-generated method stub
			comboBoxDocenti.addActionListener(listener);

		}
		
		
		public JComboBox getComboBoxSemestre() {
			return comboBoxSemestre;
		}




		public void setComboBoxSemestre(JComboBox comboBoxSemestre) {
			this.comboBoxSemestre = comboBoxSemestre;
		}






		public JComboBox getComboBoxDocenti() {
			return comboBoxDocenti;
		}






		public void setComboBoxDocenti(JComboBox comboBoxDocenti) {
			this.comboBoxDocenti = comboBoxDocenti;
		}







}
