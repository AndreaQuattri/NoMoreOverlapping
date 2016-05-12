package mvc;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UpdateTimeTable extends JFrame implements Observer{


	private static final long serialVersionUID = 1L;
	private JButton buttonInserisci;
	
	public JButton getButtonInserisci() {
		return buttonInserisci;
	}

	public void setButtonInserisci(JButton buttonInserisci) {
		this.buttonInserisci = buttonInserisci;
	}

	private Model model;
	private JComboBox comboGita;
	
	
	public JComboBox getComboGita() {
		return comboGita;
	}

	public void setComboGita(JComboBox comboGita) {
		this.comboGita = comboGita;
	}

	private JLabel labelDisciplina;



	public JLabel getLabelDisciplina() {
		return labelDisciplina;
	}

	public void setLabelDisciplina(JLabel labelDisciplina) {
		this.labelDisciplina = labelDisciplina;
	}

	public UpdateTimeTable(Model model, int row, int col)
	{

		this.model = model;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 600);
		
		initUI(row, col);
		
		model.addObserver(this);
		
		initViewLikeModel();

		

	}
	
	private void initViewLikeModel() {
		// TODO Auto-generated method stub
		buttonInserisci.setEnabled(model.isEnabledInserisciGita());
		
	}

	private void initUI (int row, int col){
		int countDay = 0;
		int j=0;
				
		for (; countDay<col; j++){
			if(model.getListOrario().get(j).getElencoAssegnamenti().size()!=0 
					&& model.getListOrario().get(j).getElencoAssegnamenti().get(0).getFasciaOraria().getInizio().toString().equals("Thu Jan 01 08:30:00 CET 1970")){
				countDay++;
			}

		}
		
		int numDiscipline = model.getListOrario().get(row + j - 1).getElencoAssegnamenti().size();
		int indice = row+j-1;
		int bound = 100;
		
		
		if (numDiscipline!=0){
		labelDisciplina = new JLabel(model.getListOrario().get(indice).getElencoAssegnamenti().get(0).getFasciaOraria().getInizio().toString().substring(11, 19) + " - " + 
				model.getListOrario().get(indice).getElencoAssegnamenti().get(0).getFasciaOraria().getFine().toString().substring(11, 19) );
		labelDisciplina.setBounds(100, 70, 500, 29);
		getContentPane().add(labelDisciplina);
		}
		
		for (int i=0; i<numDiscipline; i++){
			labelDisciplina = new JLabel(model.getListOrario().get(indice).getElencoAssegnamenti().get(i).getAttività().getNome().toString() + " - " + model.getListOrario().get(indice).getElencoAssegnamenti().get(i).getAula().toString());
			labelDisciplina.setBounds(69, bound, 500, 29);
			getContentPane().add(labelDisciplina);
			bound+=30;
			
		}
		
		comboGita = new JComboBox();
		
		comboGita.addItem("");
		for (int i=0; i<model.getListGita().size();i++)
			comboGita.addItem(model.getListGita().get(i).getNome() + " - " 
					+ model.getListGita().get(i).getOre());
		

		for (int i=0; i<model.getListConvegno().size();i++)
			comboGita.addItem(model.getListConvegno().get(i).getNome() + " - " 
					+ model.getListConvegno().get(i).getOre());
		
		comboGita.setBounds(69, bound+50, 500, 29);
		getContentPane().add(comboGita);
		
		buttonInserisci = new JButton("Inserisci gita/convegno");
		buttonInserisci.setBounds(100, bound + 100, 100, 29);
		getContentPane().add(buttonInserisci);

				
		getContentPane().setLayout(null);
	}

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

	private void enableButtonGita()
	{
		buttonInserisci.setEnabled(model.isEnabledInserisciGita());

	}
	
	public void selectedGita(ActionListener listener) {
		comboGita.addActionListener(listener);
		
	}


}
