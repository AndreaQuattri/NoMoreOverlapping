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

}
