package myComponents;

public class SceltaAula {
	
	private Aula scelta;
	private int priorità;
	
	public SceltaAula(Aula scelta, int priorità) {
		this.scelta = scelta;
		this.priorità = priorità;
	}
	
	
	
	public Aula getScelta() {
		return scelta;
	}
	public void setScelta(Aula scelta) {
		this.scelta = scelta;
	}
	public int getPriorità() {
		return priorità;
	}
	public void setPriorità(int priorità) {
		this.priorità = priorità;
	}
	
	

}
