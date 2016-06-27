/*
 * 
 */
package mvc;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


// TODO: Auto-generated Javadoc
/**
 * The Class UpdateTimeTable.
 */
public class UpdateTimeTable extends JFrame implements Observer{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The button inserisci. */
	private JButton buttonInserisci;



	/** The model. */
	private Model model;
	
	/** The combo gita convegno. */
	private JComboBox comboGitaConvegno;
	
	/** The row. */
	private int row;
	
	/** The col. */
	private int col;
	
	/** The semestre. */
	private int semestre;




	/** The label disciplina. */
	private JLabel labelDisciplina;





	/**
	 * Instantiates a new update time table.
	 *
	 * @param model the model
	 * @param row the row
	 * @param col the col
	 * @param semestre the semestre
	 */
	public UpdateTimeTable(Model model, int row, int col, int semestre)
	{

		this.model = model;
		this.row = row;
		this.col = col;
		this.semestre = semestre;


		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 600);

		initUI(row, col);

		model.addObserver(this);

		initViewLikeModel();



	}

	/**
	 * Inits the view like model.
	 */
	private void initViewLikeModel() {
		// TODO Auto-generated method stub
		buttonInserisci.setEnabled(model.isEnabledInserisciGita());

	}

	/**
	 * Inits the ui.
	 *
	 * @param row the row
	 * @param col the col
	 */
	private void initUI (int row, int col){
		int j=0;
		String ora, giorno;

		ora = switchRiga(row);

		

		switch (col){
		case 1:
			giorno = "Lunedi";
			break;

		case 2:
			giorno = "Martedi";
			break;

		case 3:
			giorno = "Mercoledi";
			break;

		case 4:
			giorno = "Giovedi";
			break;

		case 5:
			giorno = "Venerdi";
			break;

		case 6:
			giorno = "Sabato";
			break;

		default:
			giorno = "";
		}


		int i;

		for (i=0; i<model.getOrarioUfficiale().getElencoAssegnamenti().size();i++){
			if (model.getOrarioUfficiale().getElencoAssegnamenti().get(i).getFasciaOraria().getGiorno().equals(giorno) &&
					model.getOrarioUfficiale().getElencoAssegnamenti().get(i).getFasciaOraria().getInizio().toString().substring(11, 19).equals(ora)){
				break;
			}
		}

		int indice = i;
		int bound = 100;


		if (indice!=model.getOrarioUfficiale().getElencoAssegnamenti().size()){
			labelDisciplina = new JLabel(model.getOrarioUfficiale().getElencoAssegnamenti().get(indice).getFasciaOraria().getGiorno().toString() + " \t " +
					model.getOrarioUfficiale().getElencoAssegnamenti().get(indice).getFasciaOraria().getInizio().toString().substring(11, 19) + " - " + 
					model.getOrarioUfficiale().getElencoAssegnamenti().get(indice).getFasciaOraria().getFine().toString().substring(11, 19) );
			labelDisciplina.setBounds(100, 70, 500, 29);
			getContentPane().add(labelDisciplina);
		}

		for (j=indice; j<model.getOrarioUfficiale().getElencoAssegnamenti().size(); j++){
			if (model.getOrarioUfficiale().getElencoAssegnamenti().get(j).getFasciaOraria().getGiorno().equals(giorno) &&
					model.getOrarioUfficiale().getElencoAssegnamenti().get(j).getFasciaOraria().getInizio().toString().substring(11, 19).equals(ora)){

				labelDisciplina = new JLabel(model.getOrarioUfficiale().getElencoAssegnamenti().get(j).getAttività().getNome().toString() + " - " + model.getOrarioUfficiale().getElencoAssegnamenti().get(j).getAula().toString());
				labelDisciplina.setBounds(69, bound, 500, 29);
				getContentPane().add(labelDisciplina);
				bound+=30;
			}

		}

		comboGitaConvegno = new JComboBox();

		comboGitaConvegno.addItem("");
		for (i=0; i<model.getListGita().size();i++){
			if(model.getListGita().get(i).getSemestre()==semestre){
				comboGitaConvegno.addItem(model.getListGita().get(i).getId() 
						+ " - " + model.getListGita().get(i).getNome() + " - " 
						+ model.getListGita().get(i).getOre());
			}
		}


		for (i=0; i<model.getListConvegno().size();i++){
			if(model.getListConvegno().get(i).getSemestre()==semestre){
				comboGitaConvegno.addItem(model.getListConvegno().get(i).getId() 
						+ " - " + model.getListConvegno().get(i).getNome() + " - " 
						+ model.getListConvegno().get(i).getOre());
			}
		}

		comboGitaConvegno.setBounds(69, bound+50, 500, 29);
		getContentPane().add(comboGitaConvegno);

		buttonInserisci = new JButton("Inserisci gita/convegno");
		buttonInserisci.setBounds(100, bound + 100, 100, 29);
		getContentPane().add(buttonInserisci);


		getContentPane().setLayout(null);
	}



	private String switchRiga(int row2) {
		// TODO Auto-generated method stub
		
		String ora;
		
		switch (row){
		case 0:
			ora = "08:30:00";
			break;
		case 1:
			ora = "09:00:00";
			break;

		case 2:
			ora = "09:30:00";
			break;

		case 3:
			ora = "10:00:00";
			break;

		case 4:
			ora = "10:30:00";
			break;

		case 5:
			ora = "11:00:00";
			break;

		case 6:
			ora = "11:30:00";
			break;

		case 7:
			ora = "00:00:00";
			break;

		case 8:
			ora = "00:30:00";
			break;

		case 9:
			ora = "13:00:00";
			break;

		case 10:
			ora = "13:30:00";
			break;

		case 11:
			ora = "14:00:00";
			break;

		case 12:
			ora = "14:30:00";
			break;

		case 13:
			ora = "15:00:00";
			break;

		case 14:
			ora = "15:30:00";
			break;

		case 15:
			ora = "16:00:00";
			break;

		case 16:
			ora = "16:30:00";
			break;

		case 17:
			ora = "17:00:00";
			break;

		case 18:
			ora = "17:30:00";
			break;

		case 19:
			ora = "18:00:00";
			break;

		case 20:
			ora = "18:30:00";
			break;

		default:
			ora = "20:00:00";
		}

		return ora;
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		MyNotify notify = (MyNotify) arg;

		switch (notify.getNotifyID())
		{
		case MyNotify.ENABLE_BUTTON_GITA:
			enableButtonGita();



		}

	}

	/**
	 * Enable button gita.
	 */
	private void enableButtonGita()
	{
		buttonInserisci.setEnabled(model.isEnabledInserisciGita());

	}

	/**
	 * Selected gita.
	 *
	 * @param listener the listener
	 */
	public void selectedGita(ActionListener listener) {
		comboGitaConvegno.addActionListener(listener);

	}

	/**
	 * Insert gita convegno.
	 *
	 * @param listener the listener
	 */
	public void insertGitaConvegno(ActionListener listener) {
		// TODO Auto-generated method stub
		buttonInserisci.addActionListener(listener);

	}

	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Sets the row.
	 *
	 * @param row the new row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Gets the col.
	 *
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Sets the col.
	 *
	 * @param col the new col
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * Gets the button inserisci.
	 *
	 * @return the button inserisci
	 */
	public JButton getButtonInserisci() {
		return buttonInserisci;
	}

	/**
	 * Sets the button inserisci.
	 *
	 * @param buttonInserisci the new button inserisci
	 */
	public void setButtonInserisci(JButton buttonInserisci) {
		this.buttonInserisci = buttonInserisci;
	}

	/**
	 * Gets the combo gita.
	 *
	 * @return the combo gita
	 */
	public JComboBox getComboGita() {
		return comboGitaConvegno;
	}

	/**
	 * Sets the combo gita.
	 *
	 * @param comboGitaConvegno the new combo gita
	 */
	public void setComboGita(JComboBox comboGitaConvegno) {
		this.comboGitaConvegno = comboGitaConvegno;
	}

	/**
	 * Gets the label disciplina.
	 *
	 * @return the label disciplina
	 */
	public JLabel getLabelDisciplina() {
		return labelDisciplina;
	}

	/**
	 * Sets the label disciplina.
	 *
	 * @param labelDisciplina the new label disciplina
	 */
	public void setLabelDisciplina(JLabel labelDisciplina) {
		this.labelDisciplina = labelDisciplina;
	}


}
