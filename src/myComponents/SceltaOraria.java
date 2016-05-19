package myComponents;

public class SceltaOraria {

	private FasciaOraria scelta;
	private int priorit�;
	//private String giorno;
	
	
	public SceltaOraria(FasciaOraria scelta, int priorit�, String giorno) {
		this.scelta = scelta;
		this.priorit� = priorit�;
		//this.giorno = giorno;
	}
	
	public SceltaOraria(FasciaOraria scelta, int priorit�) {
		this.scelta = scelta;
		this.priorit� = priorit�;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return scelta.toString() + ", " + priorit�;
	}
	
	
	public FasciaOraria getScelta() {
		return scelta;
	}
	public void setScelta(FasciaOraria scelta) {
		this.scelta = scelta;
	}
	public int getpriorit�() {
		return priorit�;
	}
	public void setpriorit�(int priorit�) {
		this.priorit� = priorit�;
	}
	
	/*
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	*/
	
}
