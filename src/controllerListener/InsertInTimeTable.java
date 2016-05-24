package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connectToDatabase.DisciplinaInseritaPiano;
import mvc.Model;
import mvc.UpdateTimeTable;
import myComponents.Attività;

public class InsertInTimeTable implements ActionListener{
	
	private Model model;
	private UpdateTimeTable updateTimeTable;
	
	
	public InsertInTimeTable(Model model, UpdateTimeTable updateTimeTable) {
		this.setModel(model);
		this.setUpdateTimeTable(updateTimeTable);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Button pressed");
		
		String attivitàSelected = (String)updateTimeTable.getComboGita().getSelectedItem();
		
		String[] id = attivitàSelected.split("-");
		
		DisciplinaInseritaPiano d = new DisciplinaInseritaPiano(model);
		Attività a = model.getAttivitàFromId(Integer.parseInt((id[0]).trim()));
		System.out.println(d.getGiorno(updateTimeTable.getRow()));
		
		System.out.println(d.èVuotaeCiSta(a.getOre(), updateTimeTable.getRow(),
				updateTimeTable.getCol(), model.getMatrix(), 0));
		
		
		
		
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
