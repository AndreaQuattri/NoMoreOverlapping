package myComponents;

public class Assegnamento {

	private Attività Attività;
	private FasciaOraria fasciaOraria;
	private Aula aula;
	//private String day;


	public Assegnamento(Attività Attività, FasciaOraria fasciaOraria, Aula aula, String day) {
		this.Attività = Attività;
		this.fasciaOraria = fasciaOraria;
		this.aula = aula;
		//this.day = day;
	}

	public Assegnamento(Attività Attività, FasciaOraria fasciaOraria, Aula aula) {
		this.Attività = Attività;
		this.fasciaOraria = fasciaOraria;
		this.aula = aula;
	}


	@Override
	public String toString() {

		String toRet = Attività.toString() + fasciaOraria.toString() + aula.toString();


		return toRet;


	}


	public Attività getAttività() {
		return Attività;
	}
	public void setAttività(Attività Attività) {
		this.Attività = Attività;
	}
	public FasciaOraria getFasciaOraria() {
		return fasciaOraria;
	}
	public void setFasciaOraria(FasciaOraria fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}
	public Aula getAula() {
		return aula;
	}
	public void setAula(Aula aula) {
		this.aula = aula;
	}

	/*
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	 */

}
