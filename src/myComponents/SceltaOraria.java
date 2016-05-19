package myComponents;

public class SceltaOraria {

	private FasciaOraria scelta;
	private int priorità;
	//private String giorno;
	
	
	public SceltaOraria(FasciaOraria scelta, int priorità, String giorno) {
		this.scelta = scelta;
		this.priorità = priorità;
		//this.giorno = giorno;
	}
	
	public SceltaOraria(FasciaOraria scelta, int priorità) {
		this.scelta = scelta;
		this.priorità = priorità;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return scelta.toString() + ", " + priorità;
	}
	
	
	public FasciaOraria getScelta() {
		return scelta;
	}
	public void setScelta(FasciaOraria scelta) {
		this.scelta = scelta;
	}
	public int getpriorità() {
		return priorità;
	}
	public void setpriorità(int priorità) {
		this.priorità = priorità;
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
