package connectToDatabase;

import mvc.Model;
import myComponents.*;

public class GetDisciplina {
	
	
	private Model model;
	
	public GetDisciplina(Model model) {
		this.model = model;
	}
	
	public Disciplina fromIdToDisciplina(String id){
		
		for (int i=0;i<model.getListDisciplina().size() ;i++){
			if(id.equals(model.getListDisciplina().get(i).getId())){
				return model.getListDisciplina().get(i);
			}
		}
			
			
			return null;
		
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	

}
