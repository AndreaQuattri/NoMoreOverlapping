package ElaborazioneDati;

import java.util.ArrayList;

import mvc.Model;
import myComponents.Attività;
import myComponents.CorsoDiStudi;
import myComponents.Disciplina;
import myComponents.PianoDiStudi;

public class CalcolaSovrapposizioni {

	private Model model;

	public CalcolaSovrapposizioni(Model model) {
		this.model = model;
	}


	public int numSovrapposizioni (){


		ArrayList<Disciplina> listSovrapposizione = new ArrayList<Disciplina>();
		int k;

		for (int i=0; i<model.getListOrario().size(); ){
			for (int j=0; j<model.getListOrario().get(i).getElencoAssegnamenti().size(); j++){
				System.out.println(model.getListOrario().get(i).getElencoAssegnamenti().get(j).getAttività().toString() +
						model.getListOrario().get(i).getElencoAssegnamenti().get(j).getFasciaOraria().toString());
				
				
				while (!model.getListOrario().get(i).getElencoAssegnamenti().equals(model.getListOrario().get(i+1).getElencoAssegnamenti())){
					System.out.println(model.getListOrario().get(i).getElencoAssegnamenti());
					System.out.println(model.getListOrario().get(i+1).getElencoAssegnamenti());

					i++;
				}
				
			}
			System.out.println();
		}


		return 0;
	}

}
