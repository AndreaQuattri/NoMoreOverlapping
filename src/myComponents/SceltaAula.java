package myComponents;

public class SceltaAula {
	
	private Aula scelta;
	private int priorit�;
	
	public SceltaAula(Aula scelta, int priorit�) {
		this.scelta = scelta;
		this.priorit� = priorit�;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return scelta.toString() + ", " + priorit�;
	}
	
	
	
	public Aula getScelta() {
		return scelta;
	}
	public void setScelta(Aula scelta) {
		this.scelta = scelta;
	}
	public int getpriorit�() {
		return priorit�;
	}
	public void setpriorit�(int priorit�) {
		this.priorit� = priorit�;
	}
	
	

}
