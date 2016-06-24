package memorizzazioneDati;

import java.util.ArrayList;

import mvc.Model;
import myComponents.Assegnamento;
import myComponents.Attività;

public class CreateTimeTable {

	private Model model;

	public CreateTimeTable(Model model) {
		this.setModel(model);
	}


	public void fromAssegnamentoToOrarioPerGiorno (){


		ArrayList<Assegnamento> listAssegnamento;
		ArrayList<Attività> listAttività;
		ArrayList<String> listGiorni = new ArrayList<String>();
		listGiorni.add("Lunedi");
		listGiorni.add("Martedi");
		listGiorni.add("Mercoledi");
		listGiorni.add("Giovedi");
		listGiorni.add("Venerdi");
		listGiorni.add("Sabato");


		for (int iFascia = 0; iFascia<model.getListFasciaOraria().size(); iFascia++){

			listAssegnamento = new ArrayList<Assegnamento>();
			listAttività = new ArrayList<Attività>();

			for (int iGiorni = 0; iGiorni<listGiorni.size(); iGiorni++){



					for (int iAssegnamento = 0; iAssegnamento<model.getListAssegnamento().size(); iAssegnamento++){
						
						if (model.getListFasciaOraria().get(iFascia).equals(model.getListAssegnamento().get(iAssegnamento).getFasciaOraria())){

							if(model.getListAssegnamento().get(iAssegnamento).getFasciaOraria().getGiorno().equals(listGiorni.get(iGiorni))){
								listAssegnamento.add(model.getListAssegnamento().get(iAssegnamento));
								listAttività.add(model.getListAssegnamento().get(iAssegnamento).getAttività());
							}

						}
					}

			}

			model.getOrarioUfficiale().getElencoAssegnamenti().addAll(listAssegnamento);

		}
		model.getOrarioUfficiale().setElencoAttività(model.getListAttivitàInserite());
		model.getOrarioUfficiale().setElencoCorsi(model.getListCorsoDiStudioInseriti());

	}






	public Model getModel() {
		return model;
	}




	public void setModel(Model model) {
		this.model = model;
	}

}
