package myComponents;

public class SceltaAula {
	
	private Aula scelta;
	private int priorità;
	
	public SceltaAula(Aula scelta, int priorità) {
		this.scelta = scelta;
		this.priorità = priorità;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return scelta.toString() + ", " + priorità;
	}
	
	
	
	public Aula getScelta() {
		return scelta;
	}
	public void setScelta(Aula scelta) {
		this.scelta = scelta;
	}
	public int getpriorità() {
		return priorità;
	}
	public void setpriorità(int priorità) {
		this.priorità = priorità;
	}
	
	

}
