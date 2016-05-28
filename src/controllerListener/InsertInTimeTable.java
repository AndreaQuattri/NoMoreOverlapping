package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

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
		
		System.out.println("Button pressed");
		
		String attivitàSelected = (String)updateTimeTable.getComboGita().getSelectedItem();
		
		String[] id = attivitàSelected.split("-");
		
		DisciplinaInseritaPiano d = new DisciplinaInseritaPiano(model);
		Attività a = model.getAttivitàFromId(Integer.parseInt((id[0]).trim()));
		System.out.println(d.getGiorno(updateTimeTable.getCol()-1));
		System.out.println(d.getTime(updateTimeTable.getRow()));
		int i;
		
		if(d.èVuotaeCiSta(a.getOre(), updateTimeTable.getRow(),
				updateTimeTable.getCol(), model.getMatrix(), 100)){
			
			for (i=0; i<model.getListFasciaOraria().size(); i++)
				if (model.getListFasciaOraria().get(i).getGiorno().equals(d.getGiorno(updateTimeTable.getCol()-1)) &&
						model.getListFasciaOraria().get(i).getInizio().toString().substring(11, 19).equals(d.getTime(updateTimeTable.getRow()))){
					break;
				}
			
			
			int hour=0;
			while(hour<a.getOre()){
				model.getListAssegnamento().add(new Assegnamento(a, model.getListFasciaOraria().get(i), model.getListAula().get(0)));
				hour++;
				i++;
				
			}
		}
		
		CreateTimeTable c = new CreateTimeTable(model);
		
		model.setListOrario(new ArrayList<Orario>());
		c.fromAssegnamentoToOrarioPerGiorno();
		
		model.setTabella(new Vector<Vector<String>>());
		model.fromOrarioToTable();
		viewOrario.visualizzaOrario();
		
		
		
		
		
		
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
