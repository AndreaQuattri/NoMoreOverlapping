package connectToDatabase;

import mvc.Model;
import myComponents.Disciplina;

public class DisciplinaGi‡Inserita {


	private Model model;

	public DisciplinaGi‡Inserita(Model model) {
		this.model = model;
	}


	public boolean Gi‡Inserita (String id){
		for (int numAss=0; numAss<model.getListAssegnamento().size(); numAss++){
			for (int i=0; i<model.getListAssegnamento().get(numAss).size(); i++){
				if(model.getListAssegnamento().get(numAss).get(i).getAttivit‡().getId().equals(id))
					return true;
			}
		}
		return false;

	}
	
	public boolean Gi‡Inserita2 (String id, int subId){
		for (int numAss=0; numAss<model.getListAssegnamento().size(); numAss++){
			for (int i=0; i<model.getListAssegnamento().get(numAss).size(); i++){
				if(model.getListAssegnamento().get(numAss).get(i).getAttivit‡().getId().equals(id) &&
						((Disciplina)model.getListAssegnamento().get(numAss).get(i).getAttivit‡()).getSubId() == subId )
					return true;
			}
		}
		return false;

	}

	public boolean ËVuotaeCiSta(int hour, int k, int numAss){

		while(hour>0){

			if (valutaOra(k, numAss))
				return false;
			k++;
			hour--;
		}


		return true;
	}

	private boolean valutaOra(int k, int numAss){

		for (int i=0; i<model.getListAssegnamento().get(numAss).size(); i++){
			if (model.getListAssegnamento().get(numAss).get(i).getFasciaOraria().equals(model.getListFasciaOraria().get(k))
				

			||
			model.getListFasciaOraria().get(k).getInizio().toString().equals("Thu Jan 01 13:30:00 CET 1970") )
				
				return true;
				
		}

		return false;

	}

	public int fasciaOrariaDisponibile(int hour, int numAss){

		int i=0;
		int iFascia = 0;
		boolean flag = true;

		do{

			if (flag==false)
				iFascia = (iFascia + 1)%model.getListFasciaOraria().size();

			while ( (valutaOra(iFascia, numAss) ||
					!model.getListFasciaOraria().get(iFascia).getGiorno().equals(model.getListFasciaOraria().get((iFascia+hour-1)%model.getListFasciaOraria().size()).getGiorno()) ) &&
					i==0){
				iFascia = (iFascia + 1)%model.getListFasciaOraria().size();
				if(iFascia==0)
					i=1;
			}

			flag = ËVuotaeCiSta(hour, iFascia, numAss);



		}
		while (!flag && i==0);

		if (flag)
			return iFascia;
		else
			return -1;



	}


}
