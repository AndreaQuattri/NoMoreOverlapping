package connectToDatabase;

import mvc.Model;

public class DisciplinaGiàInserita {
	
	
	private Model model;
	
	public DisciplinaGiàInserita(Model model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}
	
	
	public boolean giàInserita (String id){
		for (int i=0; i<model.getListAssegnamento().size(); i++){
			if(model.getListAssegnamento().get(i).getAttività().getId().equals(id))
				return true;
		}
		return false;
		
	}

	public boolean èVuotaeCiSta(int hour, int k){
		
		while(hour>0){
			
			if (valutaOra(k))
				return false;
			
			hour--;
		}
		
		
		return true;
	}
	
	private boolean valutaOra(int k){
		
		for (int i=0; i<model.getListAssegnamento().size(); i++){
			if (model.getListAssegnamento().get(i).getFasciaOraria().equals(model.getListFasciaOraria().get(k))){
				return true;
			}
		}
		return false;
		
	}
	
	
}
