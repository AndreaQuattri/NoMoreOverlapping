/*
 * 
 */
package elaborazione_dati;

import java.io.IOException;
import java.net.URISyntaxException;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertInTable.
 */
public class LarghezzaColonne {

	/** The selected item. */
	private String selectedItem;

	/**
	 * Instantiates a new insert in table.
	 *
	 * @param selectedItem the selected item
	 */
	public LarghezzaColonne(Object selectedItem) {

		this.selectedItem = (String)selectedItem;

	}


	/**
	 * Gets the values.
	 *
	 * @return the values
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	public int[] getLarghezza() throws IOException, URISyntaxException{

		if (selectedItem==null)
			return new int[1];

		if (selectedItem.equals("Attività")){
			return getAttività();
		}

		if (selectedItem.equals("Aula")){
			return getAula();
		}

		if (selectedItem.equals("Convegno")){
			return getConvegno();
		}

		if (selectedItem.equals("Corso di studi")){
			return getCorsoDiStudi();
		}

		if (selectedItem.equals("Disciplina")){
			return getDisciplina();
		}

		if (selectedItem.equals("Docente")){
			return getDocente();
		}

		if (selectedItem.equals("Esame")){
			return getEsame();
		}

		if (selectedItem.equals("Fascia oraria")){
			return getFasciaOraria();
		}

		if (selectedItem.equals("Gita")){
			return getGita();
		}

		if (selectedItem.equals("Insegna")){
			return getInsegna();
		}

		if (selectedItem.equals("Piano di studio")){
			return getPianoDiStudio();
		}

		if (selectedItem.equals("Preferenza aula")){
			return getPreferenzaAula();
		}

		if (selectedItem.equals("Preferenza fascia oraria")){
			return getPreferenzaFasciaOraria();
		}

		if (selectedItem.equals("Studente")){
			return getStudente();
		}

		if (selectedItem.equals("Tirocinio")){
			return getTirocinio();
		}


		return new int[1];

	}





	/**
	 * Gets the attività.
	 *
	 * @return the attività
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getAttività() throws IOException, URISyntaxException {


		int[] vettLarghezze = new int[7];

		vettLarghezze[0] = 40;
		vettLarghezze[1] = 400;
		vettLarghezze[2] = 550;
		vettLarghezze[3] = 50;
		vettLarghezze[4] = 70;
		vettLarghezze[5] = 100;
		vettLarghezze[6] = 100;


		return vettLarghezze;

	}

	/**
	 * Gets the aula.
	 *
	 * @return the aula
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getAula() throws IOException, URISyntaxException {

		int[] vettLarghezze = new int[4];

		vettLarghezze[0] = 60;
		vettLarghezze[1] = 60;
		vettLarghezze[2] = 60;
		vettLarghezze[3] = 610;




		return vettLarghezze;
	}


	/**
	 * Gets the convegno.
	 *
	 * @return the convegno
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getConvegno() throws IOException, URISyntaxException {

		int[] vettLarghezze = new int[11];

		vettLarghezze[0] = 30;
		vettLarghezze[1] = 250;
		vettLarghezze[2] = 550;
		vettLarghezze[3] = 30;
		vettLarghezze[4] = 30;
		vettLarghezze[5] = 100;
		vettLarghezze[6] = 100;
		vettLarghezze[7] = 60;
		vettLarghezze[8] = 100;
		vettLarghezze[9] = 180;
		vettLarghezze[10] = 60;


		return vettLarghezze;
	}	

	/**
	 * Gets the corso di studi.
	 *
	 * @return the corso di studi
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getCorsoDiStudi() throws IOException, URISyntaxException {

		int[] vettLarghezze = new int[8];

		vettLarghezze[0] = 30;
		vettLarghezze[1] = 250;
		vettLarghezze[2] = 500;
		vettLarghezze[3] = 30;
		vettLarghezze[4] = 30;
		vettLarghezze[5] = 180;
		vettLarghezze[6] = 100;
		vettLarghezze[7] = 100;


		return vettLarghezze;
	}

	/**
	 * Gets the disciplina.
	 *
	 * @return the disciplina
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getDisciplina() throws IOException, URISyntaxException {

		int[] vettLarghezze = new int[8];

		vettLarghezze[0] = 30;
		vettLarghezze[1] = 350;
		vettLarghezze[2] = 400;
		vettLarghezze[3] = 30;
		vettLarghezze[4] = 60;
		vettLarghezze[5] = 100;
		vettLarghezze[6] = 100;
		vettLarghezze[7] = 70;


		return vettLarghezze;	
	}

	/**
	 * Gets the docente.
	 *
	 * @return the docente
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getDocente() throws IOException, URISyntaxException {

		int[] vettLarghezze = new int[6];

		vettLarghezze[0] = 100;
		vettLarghezze[1] = 150;
		vettLarghezze[2] = 140;
		vettLarghezze[3] = 200;
		vettLarghezze[4] = 100;
		vettLarghezze[5] = 100;


		return vettLarghezze;	
	}

	/**
	 * Gets the esame.
	 *
	 * @return the esame
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getEsame() throws IOException, URISyntaxException {

		int[] vettLarghezze = new int[8];

		vettLarghezze[0] = 30;
		vettLarghezze[1] = 200;
		vettLarghezze[2] = 210;
		vettLarghezze[3] = 30;
		vettLarghezze[4] = 60;
		vettLarghezze[5] = 100;
		vettLarghezze[6] = 100;
		vettLarghezze[7] = 70;


		return vettLarghezze;	
	}

	/**
	 * Gets the fascia oraria.
	 *
	 * @return the fascia oraria
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getFasciaOraria() throws IOException, URISyntaxException {

		int[] vettLarghezze = new int[4];

		vettLarghezze[0] = 100;
		vettLarghezze[1] = 230;
		vettLarghezze[2] = 230;
		vettLarghezze[3] = 230;



		return vettLarghezze;
	}

	/**
	 * Gets the gita.
	 *
	 * @return the gita
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getGita() throws IOException, URISyntaxException {

		int[] vettLarghezze = new int[8];

		vettLarghezze[0] = 30;
		vettLarghezze[1] = 150;
		vettLarghezze[2] = 400;
		vettLarghezze[3] = 30;
		vettLarghezze[4] = 60;
		vettLarghezze[5] = 100;
		vettLarghezze[6] = 100;
		vettLarghezze[7] = 200;


		return vettLarghezze;
	}

	/**
	 * Gets the insegna.
	 *
	 * @return the insegna
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getInsegna() throws IOException, URISyntaxException {


		int[] vettLarghezze = new int[9];

		vettLarghezze[0] = 80;
		vettLarghezze[1] = 150;
		vettLarghezze[2] = 150;
		vettLarghezze[3] = 300;
		vettLarghezze[4] = 600;
		vettLarghezze[5] = 50;
		vettLarghezze[6] = 50;
		vettLarghezze[7] = 150;
		vettLarghezze[8] = 150;


		return vettLarghezze;	
	}

	/**
	 * Gets the piano di studio.
	 *
	 * @return the piano di studio
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getPianoDiStudio() throws IOException, URISyntaxException {


		int[] vettLarghezze = new int[15];

		vettLarghezze[0] = 70;
		vettLarghezze[1] = 200;
		vettLarghezze[2] = 450;
		vettLarghezze[3] = 100;
		vettLarghezze[4] = 70;
		vettLarghezze[5] = 150;
		vettLarghezze[6] = 100;
		vettLarghezze[7] = 100;
		vettLarghezze[8] = 400;
		vettLarghezze[9] = 400;
		vettLarghezze[10] = 50;
		vettLarghezze[11] = 70;
		vettLarghezze[12] = 100;
		vettLarghezze[13] = 100;
		vettLarghezze[14] = 80;


		return vettLarghezze;
	}

	/**
	 * Gets the preferenza aula.
	 *
	 * @return the preferenza aula
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getPreferenzaAula() throws IOException, URISyntaxException {

		int[] vettLarghezze = new int[5];

		vettLarghezze[0] = 130;
		vettLarghezze[1] = 250;
		vettLarghezze[2] = 250;
		vettLarghezze[3] = 100;
		vettLarghezze[4] = 70;
		

		return vettLarghezze;
	}

	/**
	 * Gets the preferenza fascia oraria.
	 *
	 * @return the preferenza fascia oraria
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getPreferenzaFasciaOraria() throws IOException, URISyntaxException {

		int[] vettLarghezze = new int[7];

		vettLarghezze[0] = 100;
		vettLarghezze[1] = 150;
		vettLarghezze[2] = 150;
		vettLarghezze[3] = 130;
		vettLarghezze[4] = 100;
		vettLarghezze[5] = 100;
		vettLarghezze[6] = 70;

		return vettLarghezze;
	}

	/**
	 * Gets the studente.
	 *
	 * @return the studente
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getStudente() throws IOException, URISyntaxException {


		int[] vettLarghezze = new int[13];

		vettLarghezze[0] = 100;
		vettLarghezze[1] = 100;
		vettLarghezze[2] = 100;
		vettLarghezze[3] = 200;
		vettLarghezze[4] = 100;
		vettLarghezze[5] = 100;
		vettLarghezze[6] = 250;
		vettLarghezze[7] = 500;
		vettLarghezze[8] = 100;
		vettLarghezze[9] = 50;
		vettLarghezze[10] = 200;
		vettLarghezze[11] = 130;
		vettLarghezze[12] = 100;

		return vettLarghezze;
		
		
	}

	/**
	 * Gets the tirocinio.
	 *
	 * @return the tirocinio
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	private int[] getTirocinio() throws IOException, URISyntaxException {

		int[] vettLarghezze = new int[10];

		vettLarghezze[0] = 30;
		vettLarghezze[1] = 150;
		vettLarghezze[2] = 150;
		vettLarghezze[3] = 30;
		vettLarghezze[4] = 60;
		vettLarghezze[5] = 100;
		vettLarghezze[6] = 100;
		vettLarghezze[7] = 100;
		vettLarghezze[8] = 200;
		vettLarghezze[9] = 200;

		return vettLarghezze;


	}


	/**
	 * Gets the selected item.
	 *
	 * @return the selected item
	 */
	public String getSelectedItem() {
		return selectedItem;
	}

	/**
	 * Sets the selected item.
	 *
	 * @param selectedItem the new selected item
	 */
	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}


}
