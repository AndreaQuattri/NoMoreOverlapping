package mvc;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


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

import controllerListener.DoubleClickListener;


public class ViewTimeTable extends JFrame implements Observer {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private JFrame frame;
	private JLabel labelTableInTable;
	private JLabel labelNumSovr;


	private JMenuBar menuBar;

	private JMenu menuFile;
	private JMenuItem salva;
	private JMenuItem carica;
	private JMenuItem esportaPdf;
	private JMenuItem esci;


	private JMenu menuNuovoOrario;
	private JMenuItem nuovoOrario;
	private JMenu radioButtonMenu;
	private JRadioButtonMenuItem buttonSem1;
	private JRadioButtonMenuItem buttonSem2;
	private ButtonGroup group;

	
	private JMenu menuVisualizzaPer;
	private JMenu visualizzaAttività;
	private JMenu visualizzaDocente;
	private JMenu visualizzaCorso;
	private JMenu visualizzaTutto;
	private JCheckBoxMenuItem buttonCheckBox;
	
	private JMenu parametri;
	private JMenu numeroIterazioni;
	private JRadioButtonMenuItem pocheIterazioni;
	private JRadioButtonMenuItem medieIterazioni;
	private JRadioButtonMenuItem tanteIterazioni;




	private JScrollPane scrollPane;
	private DefaultTableModel tableRecords;
	private JTable table;


	private Model model;
	private JLabel labelNumIterazioni;



	public ViewTimeTable(Model model) {

		this.model = model;
		initUI();

		// View as observer of model
		model.addObserver(this);


		menuBar = new JMenuBar();


		menuFile = new JMenu("File");
		salva = new JMenuItem("Salva");
		carica = new JMenuItem("Carica");
		esportaPdf = new JMenuItem("Esporta in pdf");
		esci = new JMenuItem("Esci");

		menuFile.add(salva);
		menuFile.add(carica);
		menuFile.add(esportaPdf);
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
		visualizzaTutto = new JMenu("Generale");

		menuVisualizzaPer.add(visualizzaTutto);
		menuVisualizzaPer.add(visualizzaAttività);
		menuVisualizzaPer.add(visualizzaCorso);
		menuVisualizzaPer.add(visualizzaDocente);
		
		menuBar.add(menuVisualizzaPer);

		
		parametri = new JMenu("Elenco parametri");
		numeroIterazioni = new JMenu("Numero iterazioni");
		parametri.add(numeroIterazioni);
		pocheIterazioni = new JRadioButtonMenuItem("1");
		medieIterazioni = new JRadioButtonMenuItem("100");
		tanteIterazioni = new JRadioButtonMenuItem("10000");
		pocheIterazioni.setSelected(true);
		group = new ButtonGroup();
		group.add(pocheIterazioni);
		group.add(medieIterazioni);
		group.add(tanteIterazioni);
		numeroIterazioni.add(pocheIterazioni);
		numeroIterazioni.add(medieIterazioni);
		numeroIterazioni.add(tanteIterazioni);
		
		menuBar.add(parametri);


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
		
		labelNumSovr = new JLabel("");
		
		labelNumIterazioni = new JLabel("");
		/*
			btnSalvaPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pdfPrinter.PdfPrinter.printReport("prova.pdf", "titolo prova", model.getOrarioUfficiale(), model.getListFasciaOraria());
			}
		});
*/
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 997, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(465)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(labelNumIterazioni)
								.addComponent(labelNumSovr))))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addComponent(labelNumSovr)
					.addGap(28)
					.addComponent(labelNumIterazioni)
					.addGap(47)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		


	}



	public void visualizzaOrario(){
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
		nuovoOrario.addActionListener(listener);
	}


	public void pressButtonCarica(ActionListener listener) {
		carica.addActionListener(listener);
	}

	public void pressButtonSalva(ActionListener listener) {
		salva.addActionListener(listener);
	}
	
	public void pressEsportaPdf(ActionListener listener) {
		esportaPdf.addActionListener(listener);
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


	public JMenu getVisualizzaTutto() {
		return visualizzaTutto;
	}
	
	public void setVisualizzaTutto(JMenu visualizzaTutto) {
		this.visualizzaTutto = visualizzaTutto;
	}
	

	public JCheckBoxMenuItem getButtonCheckBox() {
		return buttonCheckBox;
	}

	public void setButtonCheckBox(JCheckBoxMenuItem buttonCheckBox) {
		this.buttonCheckBox = buttonCheckBox;
	}


	public JMenu getParametri() {
		return parametri;
	}

	public void setParametri(JMenu parametri) {
		this.parametri = parametri;
	}

	
	public JMenu getNumeroIterazioni() {
		return numeroIterazioni;
	}

	public void setNumeroIterazioni(JMenu numeroIterazioni) {
		this.numeroIterazioni = numeroIterazioni;
	}
	
	
	public JRadioButtonMenuItem getPocheIterazioni() {
		return pocheIterazioni;
	}

	public void setPocheIterazioni(JRadioButtonMenuItem pocheIterazioni) {
		this.pocheIterazioni = pocheIterazioni;
	}
	

	public JLabel getLabelNumIterazioni() {
		return labelNumIterazioni;
	}

	public void setLabelNumIterazioni(JLabel labelNumIterazioni) {
		this.labelNumIterazioni = labelNumIterazioni;
	}
	
	
	public JLabel getLabelNumSovr() {
		return labelNumSovr;
	}

	public void setLabelNumSovr(JLabel labelNumSovr) {
		this.labelNumSovr = labelNumSovr;
	}
	
	
	public JMenuItem getSalva() {
		return salva;
	}

	public void setSalva(JMenuItem salva) {
		this.salva = salva;
	}
	
	
	public JRadioButtonMenuItem getMedieIterazioni() {
		return medieIterazioni;
	}

	public void setMedieIterazioni(JRadioButtonMenuItem medieIterazioni) {
		this.medieIterazioni = medieIterazioni;
	}
	
	
	public JRadioButtonMenuItem getTanteIterazioni() {
		return tanteIterazioni;
	}

	public void setTanteIterazioni(JRadioButtonMenuItem tanteIterazioni) {
		this.tanteIterazioni = tanteIterazioni;
	}


	public JMenuItem getEsportaPdf() {
		return esportaPdf;
	}

	public void setEsportaPdf(JMenuItem esportaPdf) {
		this.esportaPdf = esportaPdf;
	}





}
