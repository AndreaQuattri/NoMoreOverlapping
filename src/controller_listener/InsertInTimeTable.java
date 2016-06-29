/*
 * 
 */
package controller_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBoxMenuItem;

import memorizzazione_dati.CreateTimeTable;
import memorizzazione_dati.DisciplinaInseritaPiano;
import mvc.Model;
import mvc.UpdateTimeTable;
import mvc.ViewTimeTable;
import my_components.Assegnamento;
import my_components.Attività;
import my_components.Orario;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertInTimeTable.
 */
public class InsertInTimeTable implements ActionListener{

	/** The model. */
	private Model model;
	
	/** The update time table. */
	private UpdateTimeTable updateTimeTable;
	
	/** The view orario. */
	private ViewTimeTable viewOrario;


	/**
	 * Instantiates a new insert in time table.
	 *
	 * @param model the model
	 * @param viewOrario the view orario
	 * @param updateTimeTable the update time table
	 */
	public InsertInTimeTable(Model model, ViewTimeTable viewOrario, UpdateTimeTable updateTimeTable) {
		this.model = model;
		this.updateTimeTable = updateTimeTable;
		this.viewOrario = viewOrario;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {


		String attivitàSelected = (String)updateTimeTable.getComboGita().getSelectedItem();

		String[] id = attivitàSelected.split("-");

		DisciplinaInseritaPiano d = new DisciplinaInseritaPiano(model);
		Attività a;
		a = model.getAttivitàFromId((id[0]).trim());
		int i;
		
		for (i=0; i<model.getListFasciaOraria().size(); i++)
			if (model.getListFasciaOraria().get(i).getGiorno().equals(d.getGiorno(updateTimeTable.getCol()-1)) &&
					model.getListFasciaOraria().get(i).getInizio().toString().substring(11, 19).equals(d.getTime(updateTimeTable.getRow()))){
				break;
			}

		if(i!=model.getListFasciaOraria().size() &&
				model.getListFasciaOraria().get(i).getGiorno().equals(model.getListFasciaOraria().get((i+(a.getOre()*2)-1)%model.getListFasciaOraria().size()).getGiorno()) &&
				d.èVuotaeCiSta(a.getOre()*2, updateTimeTable.getRow(),
				updateTimeTable.getCol(), model.getMatrix(), 100, false) &&
				!d.giàOccupataDaStessoProf(a, updateTimeTable.getRow(), updateTimeTable.getCol()-1)){


			int hour=0;
			while(hour<(a.getOre()*2)){
				model.getListAssegnamento().add(new Assegnamento(a, model.getListFasciaOraria().get(i), model.getListAula().get(0)));
				hour++;
				i++;

			}


			if(!model.getListAttivitàInserite().contains(a)){
				model.getListAttivitàInserite().add(a);
				viewOrario.setButtonCheckBox(new JCheckBoxMenuItem(a.getNome()));
				viewOrario.getVisualizzaAttività().add(viewOrario.getButtonCheckBox());
				viewOrario.getButtonCheckBox().addActionListener(new SelectedActivityListener(model, viewOrario,
						a.getNome()));
			}

			for (i=0; i<a.getElencoResponsabili().size(); i++){
				if(!model.getListDocentiInseriti().contains(a.getElencoResponsabili().get(i))){
					model.getListDocentiInseriti().add(a.getElencoResponsabili().get(i));
					viewOrario.setButtonCheckBox(new JCheckBoxMenuItem(a.getElencoResponsabili().get(i).getMatricola() + " - " + 
							a.getElencoResponsabili().get(i).getCognome()));
					viewOrario.getVisualizzaDocente().add(viewOrario.getButtonCheckBox());
					viewOrario.getButtonCheckBox().addActionListener(new SelectedDocenteListener(model, viewOrario, 
							a.getElencoResponsabili().get(i).getMatricola()));
				}
			}

			
			CreateTimeTable c = new CreateTimeTable(model);

			model.setOrarioUfficiale(new Orario());
			c.fromAssegnamentoToOrarioPerGiorno();

			model.setTabella(new Vector<Vector<String>>());
			model.fromOrarioUfficialeToTable();
			viewOrario.visualizzaOrario();
			
			



		}


	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * Gets the update time table.
	 *
	 * @return the update time table
	 */
	public UpdateTimeTable getUpdateTimeTable() {
		return updateTimeTable;
	}

	/**
	 * Sets the update time table.
	 *
	 * @param updateTimeTable the new update time table
	 */
	public void setUpdateTimeTable(UpdateTimeTable updateTimeTable) {
		this.updateTimeTable = updateTimeTable;
	}

}
