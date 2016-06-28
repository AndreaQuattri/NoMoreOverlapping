/*
 * 
 */
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
import javax.swing.LayoutStyle.ComponentPlacement;


// TODO: Auto-generated Javadoc
/**
 * The Class ViewTimeTable.
 */
public class ViewTimeTable extends JFrame implements Observer {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;



	/** The frame. */
	private JFrame frmGestioneOrario;
	
	/** The label table in table. */
	private JLabel labelTableInTable;
	
	/** The label num sovr. */
	private JLabel labelNumSovr;


	/** The menu bar. */
	private JMenuBar menuBar;

	/** The menu file. */
	private JMenu menuFile;
	
	/** The salva. */
	private JMenuItem salva;
	
	/** The carica. */
	private JMenuItem carica;
	
	/** The esporta pdf. */
	private JMenuItem esportaPdf;
	
	/** The esci. */
	private JMenuItem esci;


	/** The menu nuovo orario. */
	private JMenu menuNuovoOrario;
	
	/** The nuovo orario. */
	private JMenuItem nuovoOrario;
	
	/** The radio button menu. */
	private JMenu radioButtonMenu;
	
	/** The button sem1. */
	private JRadioButtonMenuItem buttonSem1;
	
	/** The button sem2. */
	private JRadioButtonMenuItem buttonSem2;
	
	/** The group. */
	private ButtonGroup group;

	
	/** The menu visualizza per. */
	private JMenu menuVisualizzaPer;
	
	/** The visualizza attività. */
	private JMenu visualizzaAttività;
	
	/** The visualizza docente. */
	private JMenu visualizzaDocente;
	
	/** The visualizza corso. */
	private JMenu visualizzaCorso;
	
	/** The visualizza tutto. */
	private JMenu visualizzaTutto;
	
	/** The button check box. */
	private JCheckBoxMenuItem buttonCheckBox;
	
	/** The parametri. */
	private JMenu parametri;
	
	/** The numero iterazioni. */
	private JMenu numeroIterazioni;
	
	/** The poche iterazioni. */
	private JRadioButtonMenuItem pocheIterazioni;
	
	/** The medie iterazioni. */
	private JRadioButtonMenuItem medieIterazioni;
	
	/** The tante iterazioni. */
	private JRadioButtonMenuItem tanteIterazioni;




	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The table records. */
	private DefaultTableModel tableRecords;
	
	/** The table. */
	private JTable table;


	/** The model. */
	private Model model;
	
	/** The label num iterazioni. */
	private JLabel labelNumIterazioni;



	/**
	 * Instantiates a new view time table.
	 *
	 * @param model the model
	 */
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


		frmGestioneOrario.setJMenuBar(menuBar);

	}




	/**
	 * Inits the ui.
	 */
	private void initUI(){


		frmGestioneOrario = new JFrame();
		frmGestioneOrario.setTitle("Gestione orario");
		frmGestioneOrario.setBounds(100, 100, 1075, 475);

		scrollPane = new JScrollPane();

		labelTableInTable = new JLabel("");


		tableRecords = new DefaultTableModel(0, 0);
		table = new JTable();
		table.setModel(tableRecords);
		table.addMouseListener(new DoubleClickListener(model,this));


		scrollPane.setViewportView(table);
		
		labelNumSovr = new JLabel("sovr");
		
		labelNumIterazioni = new JLabel("");

		labelNumIterazioni = new JLabel("iter");
	
		
		GroupLayout groupLayout = new GroupLayout(frmGestioneOrario.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(204)
							.addComponent(labelNumIterazioni)
							.addGap(294)
							.addComponent(labelNumSovr))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 997, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelNumIterazioni)
						.addComponent(labelNumSovr))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
		);
		frmGestioneOrario.getContentPane().setLayout(groupLayout);
		


	}



	/**
	 * Visualizza orario.
	 */
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
		case MyNotify.ENABLE_BUTTON_CARICA:
			enableSalvaButton();
		

			
			
		}
	}
	
	
	private void enableSalvaButton()
	{
		salva.setEnabled(model.isEnableCaricaButton());
		System.out.println("sssssss");
	}


	/**
	 * Press button new orario2.
	 *
	 * @param listener the listener
	 */
	public void pressButtonNewOrario2(ActionListener listener) {
		nuovoOrario.addActionListener(listener);
	}


	/**
	 * Press button carica.
	 *
	 * @param listener the listener
	 */
	public void pressButtonCarica(ActionListener listener) {
		carica.addActionListener(listener);
	}

	/**
	 * Press button salva.
	 *
	 * @param listener the listener
	 */
	public void pressButtonSalva(ActionListener listener) {
		salva.addActionListener(listener);
	}
	
	/**
	 * Press esporta pdf.
	 *
	 * @param listener the listener
	 */
	public void pressEsportaPdf(ActionListener listener) {
		esportaPdf.addActionListener(listener);
	}

	/**
	 * Press button esci.
	 *
	 * @param listener the listener
	 */
	public void pressButtonEsci(ActionListener listener) {
		esci.addActionListener(listener);
	}











	//get and set methods



	/**
	 * Gets the label table in table.
	 *
	 * @return the label table in table
	 */
	public JLabel getLabelTableInTable() {
		return labelTableInTable;
	}

	/**
	 * Sets the label table in table.
	 *
	 * @param labelTableInTable the new label table in table
	 */
	public void setLabelTableInTable(JLabel labelTableInTable) {
		this.labelTableInTable = labelTableInTable;
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
	 * Gets the button sem1.
	 *
	 * @return the button sem1
	 */
	public JRadioButtonMenuItem getButtonSem1() {
		return buttonSem1;
	}

	/**
	 * Sets the button sem1.
	 *
	 * @param buttonSem1 the new button sem1
	 */
	public void setButtonSem1(JRadioButtonMenuItem buttonSem1) {
		this.buttonSem1 = buttonSem1;
	}


	/**
	 * Gets the radio button menu.
	 *
	 * @return the radio button menu
	 */
	public JMenu getRadioButtonMenu() {
		return radioButtonMenu;
	}

	/**
	 * Sets the radio button menu.
	 *
	 * @param radioButtonMenu the new radio button menu
	 */
	public void setRadioButtonMenu(JMenu radioButtonMenu) {
		this.radioButtonMenu = radioButtonMenu;
	}

	
	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public JFrame getFrame(){
		return frmGestioneOrario;
	}


	/**
	 * Gets the visualizza attività.
	 *
	 * @return the visualizza attività
	 */
	public JMenu getVisualizzaAttività() {
		return visualizzaAttività;
	}

	/**
	 * Sets the visualizza attività.
	 *
	 * @param visualizzaAttività the new visualizza attività
	 */
	public void setVisualizzaAttività(JMenu visualizzaAttività) {
		this.visualizzaAttività = visualizzaAttività;
	}


	/**
	 * Gets the visualizza docente.
	 *
	 * @return the visualizza docente
	 */
	public JMenu getVisualizzaDocente() {
		return visualizzaDocente;
	}

	/**
	 * Sets the visualizza docente.
	 *
	 * @param visualizzaDocente the new visualizza docente
	 */
	public void setVisualizzaDocente(JMenu visualizzaDocente) {
		this.visualizzaDocente = visualizzaDocente;
	}


	/**
	 * Gets the visualizza corso.
	 *
	 * @return the visualizza corso
	 */
	public JMenu getVisualizzaCorso() {
		return visualizzaCorso;
	}

	/**
	 * Sets the visualizza corso.
	 *
	 * @param visualizzaCorso the new visualizza corso
	 */
	public void setVisualizzaCorso(JMenu visualizzaCorso) {
		this.visualizzaCorso = visualizzaCorso;
	}


	/**
	 * Gets the visualizza tutto.
	 *
	 * @return the visualizza tutto
	 */
	public JMenu getVisualizzaTutto() {
		return visualizzaTutto;
	}
	
	/**
	 * Sets the visualizza tutto.
	 *
	 * @param visualizzaTutto the new visualizza tutto
	 */
	public void setVisualizzaTutto(JMenu visualizzaTutto) {
		this.visualizzaTutto = visualizzaTutto;
	}
	

	/**
	 * Gets the button check box.
	 *
	 * @return the button check box
	 */
	public JCheckBoxMenuItem getButtonCheckBox() {
		return buttonCheckBox;
	}

	/**
	 * Sets the button check box.
	 *
	 * @param buttonCheckBox the new button check box
	 */
	public void setButtonCheckBox(JCheckBoxMenuItem buttonCheckBox) {
		this.buttonCheckBox = buttonCheckBox;
	}


	/**
	 * Gets the parametri.
	 *
	 * @return the parametri
	 */
	public JMenu getParametri() {
		return parametri;
	}

	/**
	 * Sets the parametri.
	 *
	 * @param parametri the new parametri
	 */
	public void setParametri(JMenu parametri) {
		this.parametri = parametri;
	}

	
	/**
	 * Gets the numero iterazioni.
	 *
	 * @return the numero iterazioni
	 */
	public JMenu getNumeroIterazioni() {
		return numeroIterazioni;
	}

	/**
	 * Sets the numero iterazioni.
	 *
	 * @param numeroIterazioni the new numero iterazioni
	 */
	public void setNumeroIterazioni(JMenu numeroIterazioni) {
		this.numeroIterazioni = numeroIterazioni;
	}
	
	
	/**
	 * Gets the poche iterazioni.
	 *
	 * @return the poche iterazioni
	 */
	public JRadioButtonMenuItem getPocheIterazioni() {
		return pocheIterazioni;
	}

	/**
	 * Sets the poche iterazioni.
	 *
	 * @param pocheIterazioni the new poche iterazioni
	 */
	public void setPocheIterazioni(JRadioButtonMenuItem pocheIterazioni) {
		this.pocheIterazioni = pocheIterazioni;
	}
	

	/**
	 * Gets the label num iterazioni.
	 *
	 * @return the label num iterazioni
	 */
	public JLabel getLabelNumIterazioni() {
		return labelNumIterazioni;
	}

	/**
	 * Sets the label num iterazioni.
	 *
	 * @param labelNumIterazioni the new label num iterazioni
	 */
	public void setLabelNumIterazioni(JLabel labelNumIterazioni) {
		this.labelNumIterazioni = labelNumIterazioni;
	}
	
	
	/**
	 * Gets the label num sovr.
	 *
	 * @return the label num sovr
	 */
	public JLabel getLabelNumSovr() {
		return labelNumSovr;
	}

	/**
	 * Sets the label num sovr.
	 *
	 * @param labelNumSovr the new label num sovr
	 */
	public void setLabelNumSovr(JLabel labelNumSovr) {
		this.labelNumSovr = labelNumSovr;
	}
	
	
	/**
	 * Gets the salva.
	 *
	 * @return the salva
	 */
	public JMenuItem getSalva() {
		return salva;
	}

	/**
	 * Sets the salva.
	 *
	 * @param salva the new salva
	 */
	public void setSalva(JMenuItem salva) {
		this.salva = salva;
	}
	
	
	/**
	 * Gets the medie iterazioni.
	 *
	 * @return the medie iterazioni
	 */
	public JRadioButtonMenuItem getMedieIterazioni() {
		return medieIterazioni;
	}

	/**
	 * Sets the medie iterazioni.
	 *
	 * @param medieIterazioni the new medie iterazioni
	 */
	public void setMedieIterazioni(JRadioButtonMenuItem medieIterazioni) {
		this.medieIterazioni = medieIterazioni;
	}
	
	
	/**
	 * Gets the tante iterazioni.
	 *
	 * @return the tante iterazioni
	 */
	public JRadioButtonMenuItem getTanteIterazioni() {
		return tanteIterazioni;
	}

	/**
	 * Sets the tante iterazioni.
	 *
	 * @param tanteIterazioni the new tante iterazioni
	 */
	public void setTanteIterazioni(JRadioButtonMenuItem tanteIterazioni) {
		this.tanteIterazioni = tanteIterazioni;
	}


	/**
	 * Gets the esporta pdf.
	 *
	 * @return the esporta pdf
	 */
	public JMenuItem getEsportaPdf() {
		return esportaPdf;
	}

	/**
	 * Sets the esporta pdf.
	 *
	 * @param esportaPdf the new esporta pdf
	 */
	public void setEsportaPdf(JMenuItem esportaPdf) {
		this.esportaPdf = esportaPdf;
	}





}
