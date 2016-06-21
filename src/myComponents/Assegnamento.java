package myComponents;

public class Assegnamento {

	private Attività attività;
	private FasciaOraria fasciaOraria;
	private Aula aula;
	//private String day;
	
	public Assegnamento( ) {
		this.attività 		= new Attività();
		this.fasciaOraria 	= new FasciaOraria();
		this.aula 			= new Aula();
	}

	public Assegnamento(Attività attività, FasciaOraria fasciaOraria, Aula aula, String day) {
		this.attività 		= attività;
		this.fasciaOraria 	= fasciaOraria;
		this.aula 			= aula;
	}

	public Assegnamento(Attività attività, FasciaOraria fasciaOraria, Aula aula) {
		this.attività 		= attività;
		this.fasciaOraria 	= fasciaOraria;
		this.aula 			= aula;
	}


	@Override
	public String toString() {
		String toRet = attività.toString() + fasciaOraria.toString() + aula.toString();
		return toRet;
	}


	public Attività getAttività() {
		return attività;
	}
	public void setAttività(Attività attività) {
		this.attività = attività;
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
