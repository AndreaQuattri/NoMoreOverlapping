package myComponents;

public class Assegnamento {

	private Attivit� Attivit�;
	private FasciaOraria fasciaOraria;
	private Aula aula;
	//private String day;


	public Assegnamento(Attivit� Attivit�, FasciaOraria fasciaOraria, Aula aula, String day) {
		this.Attivit� = Attivit�;
		this.fasciaOraria = fasciaOraria;
		this.aula = aula;
		//this.day = day;
	}

	public Assegnamento(Attivit� Attivit�, FasciaOraria fasciaOraria, Aula aula) {
		this.Attivit� = Attivit�;
		this.fasciaOraria = fasciaOraria;
		this.aula = aula;
	}


	@Override
	public String toString() {

		String toRet = Attivit�.toString() + fasciaOraria.toString() + aula.toString();


		return toRet;


	}


	public Attivit� getAttivit�() {
		return Attivit�;
	}
	public void setAttivit�(Attivit� Attivit�) {
		this.Attivit� = Attivit�;
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
