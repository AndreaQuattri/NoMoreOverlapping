package myComponents;

public class SceltaOraria {

	private FasciaOraria scelta;
	private int priorità;
	private String giorno;
	
	
	public SceltaOraria(FasciaOraria scelta, int priorità, String giorno) {
		this.scelta = scelta;
		this.priorità = priorità;
		this.giorno = giorno;
	}
	
	
	
	
	public FasciaOraria getScelta() {
		return scelta;
	}
	public void setScelta(FasciaOraria scelta) {
		this.scelta = scelta;
	}
	public int getPriorità() {
		return priorità;
	}
	public void setPriorità(int priorità) {
		this.priorità = priorità;
	}
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	
	
}
