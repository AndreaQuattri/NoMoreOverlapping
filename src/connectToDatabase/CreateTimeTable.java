package connectToDatabase;

import java.util.ArrayList;

import mvc.Model;
import myComponents.Assegnamento;
import myComponents.Attività;
import myComponents.Orario;

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


				for (int iNumAssegnamento = 0; iNumAssegnamento<model.getListAssegnamento().size(); iNumAssegnamento++){

					for (int iAssegnamento = 0; iAssegnamento<model.getListAssegnamento().get(iNumAssegnamento).size(); iAssegnamento++){
						
						if (model.getListFasciaOraria().get(iFascia).equals(model.getListAssegnamento().get(iNumAssegnamento).get(iAssegnamento).getFasciaOraria())){

							if(model.getListAssegnamento().get(iNumAssegnamento).get(iAssegnamento).getFasciaOraria().getGiorno().equals(listGiorni.get(iGiorni))){
								listAssegnamento.add(model.getListAssegnamento().get(iNumAssegnamento).get(iAssegnamento));
								listAttività.add(model.getListAssegnamento().get(iNumAssegnamento).get(iAssegnamento).getAttività());
							}

						}
					}
				}

			}

			model.getListOrario().add(new Orario(listAssegnamento,listAttività));

		}



	}


	public void fromAssegnamentoToOrarioPerFasciaOraria (){


		ArrayList<Assegnamento> listAssegnamento;
		ArrayList<Attività> listAttività;


		for (int iFascia = 0; iFascia<model.getListFasciaOraria().size(); iFascia++){

			listAssegnamento = new ArrayList<Assegnamento>();
			listAttività = new ArrayList<Attività>();

			for (int iNumAssegnamento = 0; iNumAssegnamento<model.getListAssegnamento().size(); iNumAssegnamento++){

				for (int iAssegnamento = 0; iAssegnamento<model.getListAssegnamento().get(iNumAssegnamento).size(); iAssegnamento++){

					if (model.getListFasciaOraria().get(iFascia).equals(model.getListAssegnamento().get(iNumAssegnamento).get(iAssegnamento).getFasciaOraria())){
						listAssegnamento.add(model.getListAssegnamento().get(iNumAssegnamento).get(iAssegnamento));
						listAttività.add(model.getListAssegnamento().get(iNumAssegnamento).get(iAssegnamento).getAttività());
					}

				}

			}

			model.getListOrario().add(new Orario(listAssegnamento,listAttività));

		}



	}




	public Model getModel() {
		return model;
	}




	public void setModel(Model model) {
		this.model = model;
	}

}
