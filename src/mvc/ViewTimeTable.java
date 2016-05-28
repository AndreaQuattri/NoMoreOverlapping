package mvc;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class ViewTimeTable extends JFrame implements Observer {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private JFrame frame;
	private JLabel labelTableInTable;







	private JMenuBar menuBar;

	private JMenu menuFile;
	private JMenuItem salva;
	private JMenuItem carica;
	private JMenuItem esci;


	private JMenu menuNuovoOrario;
	private JMenuItem nuovoOrario;
	private JMenu radioButtonMenu;
	private JRadioButtonMenuItem buttonSem1;
	private JRadioButtonMenuItem buttonSem2;
	private ButtonGroup group;

	public ButtonGroup getGroup() {
		return group;
	}






	public void setGroup(ButtonGroup group) {
		this.group = group;
	}






	private JMenu menuVisualizzaPer;
	private JMenu visualizzaAttività;
	private JMenu visualizzaDocente;
	private JMenu visualizzaCorso;
	private JCheckBoxMenuItem buttonCheckBox;




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


		menuFile = new JMenu("File");
		salva = new JMenuItem("Salva");
		carica = new JMenuItem("Carica");
		esci = new JMenuItem("Esci");

		menuFile.add(salva);
		menuFile.add(carica);
		menuFile.addSeparator();
		menuFile.add(esci);

		menuBar.add(menuFile);


		menuNuovoOrario = new JMenu("Crea un nuovo orario");
		nuovoOrario = new JMenuItem("Nuovo Orario");
		radioButtonMenu = new JMenu("Seleziona semestre");
		buttonSem1 = new JRadioButtonMenuItem("1");
		buttonSem2 = new JRadioButtonMenuItem("2");
		buttonSem1.setSelected(true);
		group = new ButtonGroup();
		group.add(buttonSem1);
		group.add(buttonSem2);
		radioButtonMenu.add(buttonSem1);
		radioButtonMenu.add(buttonSem2);

		menuNuovoOrario.add(nuovoOrario);
		menuNuovoOrario.add(radioButtonMenu);//popup pull-right

		menuBar.add(menuNuovoOrario);


		menuVisualizzaPer = new JMenu("Visuallizza ...");
		visualizzaDocente = new JMenu("Docente");
		visualizzaAttività = new JMenu("Attività");
		visualizzaCorso = new JMenu("Corso di Studi");

		menuVisualizzaPer.add(visualizzaAttività);
		menuVisualizzaPer.add(visualizzaCorso);
		menuVisualizzaPer.add(visualizzaDocente);
		//group = new ButtonGroup();
		//buttonCombo = new JRadioButtonMenuItem("jj");
		//visualizzaDocente.add(buttonCombo);

		menuBar.add(menuVisualizzaPer);


		frame.setJMenuBar(menuBar);



	}






	private void initUI(){


		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 700);

		scrollPane = new JScrollPane();

		labelTableInTable = new JLabel("");


		tableRecords = new DefaultTableModel(0, 0);
		table = new JTable();
		table.setModel(tableRecords);
		table.addMouseListener(new DoubleClickListener(model,this));


		scrollPane.setViewportView(table);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(66)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 775, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(259, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(229)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(19))
				);
		frame.getContentPane().setLayout(groupLayout);


	}



	private void initViewLikeModel()
	{

		//buttonLoadOrario.setEnabled(model.isEnableModificaTable());
		//buttonNewOrario.setEnabled(model.isEnableModificaTable());

	}

	public void visualizzaOrario(){

		//model.setTabella(new Vector<Vector<String>>());

		if (this.getTableRecords().getRowCount()!=0){
			for (int i = 0; i<21; i++){
				this.getTableRecords().removeRow(0);
			}

		}
		else{
			if(this.getTableRecords().getColumnCount()==0){
				this.getTableRecords().addColumn("Orario");
				this.getTableRecords().addColumn("Lunedì");
				this.getTableRecords().addColumn("Martedì");
				this.getTableRecords().addColumn("Mercoledì");
				this.getTableRecords().addColumn("Giovedì");
				this.getTableRecords().addColumn("Venerdì");
				this.getTableRecords().addColumn("Sabato");
			}

		}


		for(int i=0; i<21; i++){
			this.getTableRecords().addRow(model.getTabella().get(i));
		}

		for (int i=1; i<7; i++){
			this.getTable().getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
					Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);

					if (value == null)
						return null;

					if (value.equals("0")){
						cell.setBackground( Color.gray );
						cell.setForeground(Color.gray);
					}
					else{
						if (value.equals("1")){
							cell.setBackground( Color.green );
							cell.setForeground(Color.green);
						}
						else{
							cell.setBackground( Color.red );
							cell.setForeground(Color.red);
						}

					}

					return cell;

				}});

		}
	}



	//listener methods


	// Update the view with the notify send by model
	@Override
	public void update(Observable o, Object arg)
	{

	}

	public void pressButtonNewOrario2(ActionListener listener) {
		// TODO Auto-generated method stub
		nuovoOrario.addActionListener(listener);
	}


	public void pressButtonCarica(ActionListener listener) {
		// TODO Auto-generated method stub
		carica.addActionListener(listener);
	}

	public void pressButtonSalva(ActionListener listener) {
		// TODO Auto-generated method stub
		salva.addActionListener(listener);
	}

	public void pressButtonEsci(ActionListener listener) {
		esci.addActionListener(listener);
	}













	//get and set methods



	public JLabel getLabelTableInTable() {
		return labelTableInTable;
	}

	public void setLabelTableInTable(JLabel labelTableInTable) {
		this.labelTableInTable = labelTableInTable;
	}


	public DefaultTableModel getTableRecords() {
		return tableRecords;
	}

	public void setTableRecords(DefaultTableModel tableRecords) {
		this.tableRecords = tableRecords;
	}


	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}


	public JRadioButtonMenuItem getButtonSem1() {
		return buttonSem1;
	}

	public void setButtonSem1(JRadioButtonMenuItem buttonSem1) {
		this.buttonSem1 = buttonSem1;
	}



	public JMenu getRadioButtonMenu() {
		return radioButtonMenu;
	}

	public void setRadioButtonMenu(JMenu radioButtonMenu) {
		this.radioButtonMenu = radioButtonMenu;
	}

	public JFrame getFrame(){
		return frame;
	}






	public JMenu getVisualizzaAttività() {
		return visualizzaAttività;
	}

	public void setVisualizzaAttività(JMenu visualizzaAttività) {
		this.visualizzaAttività = visualizzaAttività;
	}






	public JMenu getVisualizzaDocente() {
		return visualizzaDocente;
	}






	public void setVisualizzaDocente(JMenu visualizzaDocente) {
		this.visualizzaDocente = visualizzaDocente;
	}






	public JMenu getVisualizzaCorso() {
		return visualizzaCorso;
	}






	public void setVisualizzaCorso(JMenu visualizzaCorso) {
		this.visualizzaCorso = visualizzaCorso;
	}










	public JCheckBoxMenuItem getButtonCheckBox() {
		return buttonCheckBox;
	}






	public void setButtonCheckBox(JCheckBoxMenuItem buttonCheckBox) {
		this.buttonCheckBox = buttonCheckBox;
	}
}
