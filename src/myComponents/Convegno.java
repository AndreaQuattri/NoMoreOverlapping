package myComponents;

import java.util.ArrayList;
import java.util.Date;

public class Convegno extends Attività {
	
	private String relatoreNome;
	private String relatoreCognome;
	private String relatoreEmail;
	private String relatoreQualifica;
	private int idConvegno;

	public Convegno(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, ArrayList<Docente> elencoResponsabili, String relatoreNome, String relatoreCognome, String relatoreEmail, String relatoreQualifica, int idConvegno) {
		
		super(ore, id, descrizione, nome, inizio, fine, semestre, elencoResponsabili);
		this.relatoreNome = relatoreNome;
		this.relatoreCognome = relatoreCognome;
		this.relatoreEmail = relatoreEmail;
		this.relatoreQualifica = relatoreQualifica;
		this.idConvegno = idConvegno;
	}
	
	public Convegno(int ore, String id, String descrizione, String nome, Date inizio, Date fine,
			int semestre, String relatoreNome, String relatoreCognome, String relatoreEmail, String relatoreQualifica, int idConvegno) {
		
		super(ore, id, descrizione, nome, inizio, fine, semestre);
		this.relatoreNome = relatoreNome;
		this.relatoreCognome = relatoreCognome;
		this.relatoreEmail = relatoreEmail;
		this.relatoreQualifica = relatoreQualifica;
		this.idConvegno = idConvegno;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	

	public String getRelatoreNome() {
		return relatoreNome;
	}

	public void setRelatoreNome(String relatoreNome) {
		this.relatoreNome = relatoreNome;
	}

	public String getRelatoreCognome() {
		return relatoreCognome;
	}

	public void setRelatoreCognome(String relatoreCognome) {
		this.relatoreCognome = relatoreCognome;
	}

	public String getRelatoreEmail() {
		return relatoreEmail;
	}

	public void setRelatoreEmail(String relatoreEmail) {
		this.relatoreEmail = relatoreEmail;
	}

	public String getRelatoreQualifica() {
		return relatoreQualifica;
	}

	public void setRelatoreQualifica(String relatoreQualifica) {
		this.relatoreQualifica = relatoreQualifica;
	}

	public int getIdConvegno() {
		return idConvegno;
	}

	public void setIdConvegno(int idConvegno) {
		this.idConvegno = idConvegno;
	}

	
	
}
