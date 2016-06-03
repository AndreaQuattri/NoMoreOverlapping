package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBoxMenuItem;

import connectToDatabase.CreateTimeTable;
import connectToDatabase.DisciplinaInseritaPiano;
import mvc.Model;
import mvc.UpdateTimeTable;
import mvc.ViewTimeTable;
import myComponents.Assegnamento;
import myComponents.Attività;
import myComponents.Orario;

public class InsertInTimeTable implements ActionListener{

	private Model model;
	private UpdateTimeTable updateTimeTable;
	private ViewTimeTable viewOrario;


	public InsertInTimeTable(Model model, ViewTimeTable viewOrario, UpdateTimeTable updateTimeTable) {
		this.setModel(model);
		this.setUpdateTimeTable(updateTimeTable);
		this.viewOrario = viewOrario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		String attivitàSelected = (String)updateTimeTable.getComboGita().getSelectedItem();

		String[] id = attivitàSelected.split("-");

		DisciplinaInseritaPiano d = new DisciplinaInseritaPiano(model);
		Attività a;
		a = model.getAttivitàFromId((id[0]).trim());
		int i;

		if(d.èVuotaeCiSta(a.getOre()*2, updateTimeTable.getRow(),
				updateTimeTable.getCol(), model.getMatrix(), 100, false) &&
				!d.giàOccupataDaStessoProf(a, updateTimeTable.getRow(), updateTimeTable.getCol()-1)){

			for (i=0; i<model.getListFasciaOraria().size(); i++)
				if (model.getListFasciaOraria().get(i).getGiorno().equals(d.getGiorno(updateTimeTable.getCol()-1)) &&
						model.getListFasciaOraria().get(i).getInizio().toString().substring(11, 19).equals(d.getTime(updateTimeTable.getRow()))){
					break;
				}


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
			model.fromOrarioToTable();
			viewOrario.visualizzaOrario();



		}


	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public UpdateTimeTable getUpdateTimeTable() {
		return updateTimeTable;
	}

	public void setUpdateTimeTable(UpdateTimeTable updateTimeTable) {
		this.updateTimeTable = updateTimeTable;
	}

}
