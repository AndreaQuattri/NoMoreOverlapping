package connectToDatabase;

import mvc.Model;
import myComponents.Assegnamento;
import myComponents.Disciplina;

public class DisciplinaInseritaPiano {


	private Model model;


	public DisciplinaInseritaPiano(Model model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}


	public boolean giàInsert(String id, int subId){
		for (int numAss=0; numAss<model.getListAssegnamento().size(); numAss++){
			for (int i=0; i<model.getListAssegnamento().get(numAss).size(); i++){
				if(model.getListAssegnamento().get(numAss).get(i).getAttività().getId().equals(id) &&
						((Disciplina)model.getListAssegnamento().get(numAss).get(i).getAttività()).getSubId() == subId )
					return true;
			}
		}
		return false;
	}

	public boolean giàInsert(String id){

		for (int numAss=0; numAss<model.getListAssegnamento().size(); numAss++){
			for (int i=0; i<model.getListAssegnamento().get(numAss).size(); i++){
				if(model.getListAssegnamento().get(numAss).get(i).getAttività().getId().equals(id))
					return true;
			}
		}
		return false;	
	}
	
	public boolean giàInsertDocente (String matricola, String id, int subId){
		
		for (int numAss=0; numAss<model.getListAssegnamento().size(); numAss++){
			for (int i=0; i<model.getListAssegnamento().get(numAss).size(); i++){
					for (int iDocente = 0; iDocente<model.getListAssegnamento().get(numAss).get(i).getAttività().getElencoResponsabili().size(); iDocente++){
						if (model.getListAssegnamento().get(numAss).get(i).getAttività().getElencoResponsabili().get(iDocente).equals(matricola) &&
							model.getListAssegnamento().get(numAss).get(i).getAttività().getId().equals(id) &&
							((Disciplina)model.getListAssegnamento().get(numAss).get(i).getAttività()).getSubId()==subId)
							return true;
					}
										
			}
				
		}
		
		return false;
	}


	public void fasciaOrariaDisponibile(int hour, int[][] matrix, int[][] matrixSupporto, Disciplina d) {


		int iFascia = 0, iMatrice = 0;
		boolean flag = true;

		while (flag){

			for (int j=0; j<6 && flag; j++){
				for (int k=0; k<21 && flag; k++){

					if (matrix[k][j]==iMatrice && 
							model.getListFasciaOraria().get(iFascia).getGiorno().equals(model.getListFasciaOraria().get((iFascia+hour-1)%model.getListFasciaOraria().size()).getGiorno())){

						if (èVuotaeCiSta(hour, k, j, matrix, iMatrice) && 
								!giàOccupataDaStessaAtt(d.getId(), hour, k, j) &&
								!giàOccupataDaStessoProf(d, k, j)){
							for (int i=0; i<hour; i++){
								model.getListAssegnamento().get(0).add(new Assegnamento(d, model.getListFasciaOraria().get(iFascia), model.getListAula().get(0)));
								matrix[k+i][j]++;
								matrixSupporto[k+i][j]++;
								iFascia++;
							}
							flag = false;
						}
					}
					iFascia = (iFascia+1)%model.getListFasciaOraria().size();
					if (iFascia==0){
						iMatrice++;
						j=6;
						break;
					}

				}
			}
		}


	}


	private boolean giàOccupataDaStessoProf(Disciplina d, int riga, int colonna) {

		String day = getGiorno(colonna);
		String time = getTime(riga);

		for (int i=0; i<model.getListAssegnamento().get(0).size(); i++){
			if (model.getListAssegnamento().get(0).get(i).getFasciaOraria().getGiorno().equals(day) &&
					model.getListAssegnamento().get(0).get(i).getFasciaOraria().getInizio().toString().substring(11, 19).equals(time)){


					for (int j=0; j<model.getListAssegnamento().get(0).get(i).getAttività().getElencoResponsabili().size(); j++){
						for (int k=0; k<d.getElencoResponsabili().size(); k++){
							if (model.getListAssegnamento().get(0).get(i).getAttività().getElencoResponsabili().get(j).getMatricola().equals(
									d.getElencoResponsabili().get(k).getMatricola()))
								return true;
						}

					}
			}
		}

		return false;
	}


	private boolean èVuotaeCiSta(int hour, int k, int j, int[][] matrix, int iMatrice) {
		// TODO Auto-generated method stub
		while(hour>0){

			if (matrix[k][j]>iMatrice || k==10)
				return false;
			k++;
			hour--;
		}


		return true;	
	}


	public void FromAssToMatrix(String id, int subId, int[][] matrix) {

		int riga, colonna;

		for (int i=0; i<model.getListAssegnamento().get(0).size(); i++){

			if (model.getListAssegnamento().get(0).get(i).getAttività().getId().equals(id) &&
					((Disciplina)model.getListAssegnamento().get(0).get(i).getAttività()).getSubId() == subId){
				colonna = getColonna(model.getListAssegnamento().get(0).get(i).getFasciaOraria().getGiorno());
				riga = getRiga(model.getListAssegnamento().get(0).get(i).getFasciaOraria().getInizio().toString().substring(11, 19));
				matrix[riga][colonna]++;
			}

		}


	}

	private int getColonna (String day){

		if (day.equals("Lunedi"))
			return 0;
		if (day.equals("Martedi"))
			return 1;
		if (day.equals("Mercoledi"))
			return 2;
		if (day.equals("Giovedi"))
			return 3;
		if (day.equals("Venerdi"))
			return 4;
		if (day.equals("Sabato"))
			return 5;
		return -1;

	}

	private int getRiga (String d){

		if (d.equals("08:30:00"))
			return 0;
		if (d.equals("09:00:00"))
			return 1;
		if (d.equals("09:30:00"))
			return 2;
		if (d.equals("10:00:00"))
			return 3;
		if (d.equals("10:30:00"))
			return 4;
		if (d.equals("11:00:00"))
			return 5;
		if (d.equals("11:30:00"))
			return 6;
		if (d.equals("00:00:00"))
			return 7;
		if (d.equals("00:30:00"))
			return 8;
		if (d.equals("13:00:00"))
			return 9;
		if (d.equals("13:30:00"))
			return 10;
		if (d.equals("14:00:00"))
			return 11;
		if (d.equals("14:30:00"))
			return 12;
		if (d.equals("15:00:00"))
			return 13;
		if (d.equals("15:30:00"))
			return 14;
		if (d.equals("16:00:00"))
			return 15;
		if (d.equals("16:30:00"))
			return 16;
		if (d.equals("17:00:00"))
			return 17;
		if (d.equals("17:30:00"))
			return 18;
		if (d.equals("18:00:00"))
			return 19;
		if (d.equals("18:30:00"))
			return 20;

		return 0;
	}


	public boolean giàOccupataDaStessaAtt(String id, int hour, int riga, int colonna){

		String day = getGiorno(colonna);
		String time = getTime(riga);

		for (int i=0; i<model.getListAssegnamento().get(0).size(); i++){
			if (model.getListAssegnamento().get(0).get(i).getFasciaOraria().getGiorno().equals(day) &&
					model.getListAssegnamento().get(0).get(i).getFasciaOraria().getInizio().toString().substring(11, 19).equals(time)){
				if (model.getListAssegnamento().get(0).get(i).getAttività().getId().equals(id)){
					return true;
				}
			}
		}

		return false;

	}


	private String getTime(int riga) {

		switch (riga){

		case 0:
			return "08:30:00";
		case 1:
			return "09:00:00";
		case 2:
			return "09:30:00";
		case 3:
			return "10:00:00";
		case 4:
			return "10:30:00";
		case 5:
			return "11:00:00";
		case 6:
			return "11:30:00";
		case 7:
			return "00:00:00";
		case 8:
			return "00:30:00";
		case 9:
			return "13:00:00";
		case 10:
			return "13:30:00";
		case 11:
			return "14:00:00";
		case 12:
			return "14:30:00";
		case 13:
			return "15:00:00";
		case 14:
			return "15:30:00";
		case 15:
			return "16:00:00";
		case 16:
			return "16:30:00";
		case 17:
			return "17:00:00";
		case 18:
			return "17:30:00";
		case 19:
			return "18:00:00";
		case 20:
			return "18:30:00";
		default:
			return "20:00:00";

		}

	}


	private String getGiorno(int colonna) {

		switch (colonna){

		case 0:
			return "Lunedi";
		case 1:
			return "Martedi";
		case 2:
			return "Mercoledi";
		case 3:
			return "Giovedi";
		case 4:
			return "Venerdi";
		case 5:
			return "Sabato";
		default:
			return "";

		}


	}

}
