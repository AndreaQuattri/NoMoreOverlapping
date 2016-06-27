/*
 * 
 */
package memorizzazioneDati;

import mvc.Model;
import myComponents.Assegnamento;
import myComponents.Attività;
import myComponents.Disciplina;

// TODO: Auto-generated Javadoc
/**
 * The Class DisciplinaInseritaPiano.
 */
public class DisciplinaInseritaPiano {


	/** The model. */
	private Model model;


	/**
	 * Instantiates a new disciplina inserita piano.
	 *
	 * @param model the model
	 */
	public DisciplinaInseritaPiano(Model model) {
		this.model = model;
	}


	/**
	 * Già insert.
	 *
	 * @param id the id
	 * @param subId the sub id
	 * @return true, if successful
	 */
	public boolean giàInsert(String id, int subId){
			for (int i=0; i<model.getListAssegnamento().size(); i++){
				if(model.getListAssegnamento().get(i).getAttività().getId().equals(id) &&
						((Disciplina)model.getListAssegnamento().get(i).getAttività()).getSubId() == subId )
					return true;
			}
		return false;
	}

	
	/**
	 * Già insert.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean giàInsert(String id){

			for (int i=0; i<model.getListAssegnamento().size(); i++){
				if(model.getListAssegnamento().get(i).getAttività().getId().equals(id))
					return true;
			}
		return false;	
	}

	
	/**
	 * Già insert docente.
	 *
	 * @param matricola the matricola
	 * @param id the id
	 * @param subId the sub id
	 * @return true, if successful
	 */
	public boolean giàInsertDocente (String matricola, String id, int subId){

			for (int i=0; i<model.getListAssegnamento().size(); i++){
				for (int iDocente = 0; iDocente<model.getListAssegnamento().get(i).getAttività().getElencoResponsabili().size(); iDocente++){
					if (model.getListAssegnamento().get(i).getAttività().getElencoResponsabili().get(iDocente).equals(matricola) &&
							model.getListAssegnamento().get(i).getAttività().getId().equals(id) &&
							((Disciplina)model.getListAssegnamento().get(i).getAttività()).getSubId()==subId)
						return true;
				}
			}
		return false;
	}


	/**
	 * Fascia oraria disponibile.
	 *
	 * @param hour the hour
	 * @param matrix the matrix
	 * @param matrixSupporto the matrix supporto
	 * @param d the d
	 * @param iInizio the i inizio
	 */
	public void fasciaOrariaDisponibile(int hour, int[][] matrix, int[][] matrixSupporto, Disciplina d, int iInizio) {

		int iInizioRandom = iInizio;
		switch (iInizio){
		case 0:
			iInizio = 0;
			break;
		case 1:
			iInizio = 21;
			break;
		case 2:
			iInizio = 42;
			break;
		case 3:
			iInizio = 63;
			break;
		case 4:
			iInizio = 84;
			break;
		case 5:
			iInizio = 105;
			break;
		}

		int iFascia = iInizio, iMatrice = 0;
		boolean flag = true;

		while (flag){
			int j = iInizioRandom;
			for (int iScelta=0; iScelta<6 && flag; iScelta++, j = (j+1)%6){
				for (int k=0; k<21 && flag ; k++){

					if (matrix[k][j]==iMatrice && 
							model.getListFasciaOraria().get(iFascia).getGiorno().equals(model.getListFasciaOraria().get((iFascia+hour-1)%model.getListFasciaOraria().size()).getGiorno())){

						if (èVuotaeCiSta(hour, k, j, matrix, iMatrice, true) && 
								!giàOccupataDaStessaAtt(d, hour, k, j) &&
								!giàOccupataDaStessoProf(d, k, j)){
							for (int i=0; i<hour; i++){
								model.getListAssegnamento().add(new Assegnamento(d, model.getListFasciaOraria().get(iFascia), model.getListAula().get(0)));
								matrix[k+i][j]++;
								matrixSupporto[k+i][j]++;
								iFascia++;
							}
							flag = false;
						}
					}
					iFascia = (iFascia+1)%model.getListFasciaOraria().size();
					if (iFascia == 0)
						k=22;
					if (iFascia==iInizio){
						iMatrice++;
						break;
					}
				}
			}
		}

	}


	/**
	 * Già occupata da stesso prof.
	 *
	 * @param d the d
	 * @param riga the riga
	 * @param colonna the colonna
	 * @return true, if successful
	 */
	public boolean giàOccupataDaStessoProf(Attività d, int riga, int colonna) {

		String day = getGiorno(colonna);
		int oreDaValutare;
		if (d instanceof Disciplina)
		oreDaValutare = d.getOre();
		else
			oreDaValutare = d.getOre()*2;


		for (int iHour=0; iHour < oreDaValutare; iHour++, riga++){
			String time = getTime(riga);

			for (int i=0; i<model.getListAssegnamento().size(); i++){
				if (model.getListAssegnamento().get(i).getFasciaOraria().getGiorno().equals(day) &&
						model.getListAssegnamento().get(i).getFasciaOraria().getInizio().toString().substring(11, 19).equals(time)){


					for (int j=0; j<model.getListAssegnamento().get(i).getAttività().getElencoResponsabili().size(); j++){
						for (int k=0; k<d.getElencoResponsabili().size(); k++){
							if (model.getListAssegnamento().get(i).getAttività().getElencoResponsabili().get(j).getMatricola().equals(
									d.getElencoResponsabili().get(k).getMatricola()))
								return true;
						}

					}
				}
			}
		}
		return false;
		
	}


	/**
	 * È vuotae ci sta.
	 *
	 * @param hour the hour
	 * @param k the k
	 * @param j the j
	 * @param matrix the matrix
	 * @param iMatrice the i matrice
	 * @param pausaPranzo the pausa pranzo
	 * @return true, if successful
	 */
	public boolean èVuotaeCiSta(int hour, int k, int j, int[][] matrix, int iMatrice, boolean pausaPranzo) {

		while(hour>0){

			if (matrix[k][j]>iMatrice || (k==10 && pausaPranzo))
				return false;
			k++;
			hour--;
		}
		return true;
		
	}


	/**
	 * From ass to matrix.
	 *
	 * @param id the id
	 * @param subId the sub id
	 * @param matrix the matrix
	 */
	public void FromAssToMatrix(String id, int subId, int[][] matrix) {

		int riga, colonna;

		for (int i=0; i<model.getListAssegnamento().size(); i++){

			if (model.getListAssegnamento().get(i).getAttività().getId().equals(id) &&
					((Disciplina)model.getListAssegnamento().get(i).getAttività()).getSubId() == subId){
				colonna = getColonna(model.getListAssegnamento().get(i).getFasciaOraria().getGiorno());
				riga = getRiga(model.getListAssegnamento().get(i).getFasciaOraria().getInizio().toString().substring(11, 19));
				matrix[riga][colonna]++;
			}

		}

	}

	
	/**
	 * Gets the colonna.
	 *
	 * @param day the day
	 * @return the colonna
	 */
	public int getColonna (String day){

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

	/**
	 * Gets the riga.
	 *
	 * @param d the d
	 * @return the riga
	 */
	public int getRiga (String d){

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


	/**
	 * Già occupata da stessa att.
	 *
	 * @param d the d
	 * @param hour the hour
	 * @param riga the riga
	 * @param colonna the colonna
	 * @return true, if successful
	 */
	public boolean giàOccupataDaStessaAtt(Disciplina d, int hour, int riga, int colonna){

		String day = getGiorno(colonna);


		for (int iHour=0; iHour < d.getSubOre(); iHour++, riga++){

			String time = getTime(riga);

			for (int i=0; i<model.getListAssegnamento().size(); i++){
				if (model.getListAssegnamento().get(i).getFasciaOraria().getGiorno().equals(day) &&
						model.getListAssegnamento().get(i).getFasciaOraria().getInizio().toString().substring(11, 19).equals(time)){
					if (model.getListAssegnamento().get(i).getAttività().equals(d)){
						return true;
					}
				}
			}
		}
		return false;

	}


	/**
	 * Gets the time.
	 *
	 * @param riga the riga
	 * @return the time
	 */
	public String getTime(int riga) {

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


	/**
	 * Gets the giorno.
	 *
	 * @param colonna the colonna
	 * @return the giorno
	 */
	public String getGiorno(int colonna) {

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
