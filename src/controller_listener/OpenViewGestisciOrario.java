/*
 * 
 */
package controller_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import elaborazione_dati.GeneraPianiDiStudio;
import memorizzazione_dati.InsertValues;
import mvc.Model;
import mvc.ViewTimeTable;
import my_components.Assegnamento;
import my_components.Attività;
import my_components.Aula;
import my_components.Convegno;
import my_components.CorsoDiStudi;
import my_components.Disciplina;
import my_components.Docente;
import my_components.Esame;
import my_components.FasciaOraria;
import my_components.Gita;
import my_components.Orario;
import my_components.PianoDiStudi;
import my_components.Studente;
import my_components.Tirocinio;

// TODO: Auto-generated Javadoc
/**
 * The Class OpenViewGestisciOrario.
 */
public class OpenViewGestisciOrario implements  ActionListener 
	{
	
	/** The model. */
	private Model model;
	
	/** The view orario. */
	private ViewTimeTable viewOrario;
	
	/**
	 * Instantiates a new open view gestisci orario.
	 *
	 * @param model the model
	 * @param viewOrario the view orario
	 */
	public OpenViewGestisciOrario(Model model, ViewTimeTable viewOrario) {
		this.model = model;
		this.viewOrario = viewOrario;
	}
	
	
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent action)
		{
			InsertValues insert = new InsertValues(model);


			model.setListAssegnamento(new ArrayList<Assegnamento>());
			model.setListAula(new ArrayList<Aula>());
			model.setListConvegno(new ArrayList<Convegno>());
			model.setListCorsoDiStudi(new ArrayList<CorsoDiStudi>());
			model.setListDisciplina(new ArrayList<Disciplina>());
			model.setListDocente(new ArrayList<Docente>());
			model.setListEsame(new ArrayList<Esame>());
			model.setListFasciaOraria(new ArrayList<FasciaOraria>());
			model.setListGita(new ArrayList<Gita>());
			model.setOrarioUfficiale(new Orario());
			model.setListPianoDiStudi(new ArrayList<PianoDiStudi>());
			model.setListStudente(new ArrayList<Studente>());
			model.setListTirocinio(new ArrayList<Tirocinio>());
			model.setTabella(new Vector<Vector<String>>());
			model.setListAttivitàInserite(new ArrayList<Attività>());
			
			
			model.setListAssegnamento(null);
			model.setListAssegnamento(new ArrayList<Assegnamento>());
			
			model.setTabella(new Vector<Vector<String>>());

			try {

				//aula inserita in arraylist<Aula> correttamente
				insert.getValueAula();

				//corsi di studi inseriti in arraylist<CorsoDiStudi>
				insert.getValueCorsoDiStudi1();

				//studenti inseriti in arrayList<Studente>
				insert.getValueStudente();

				//corsi di studi inseriti in arraylist<CorsoDiStudi>
				//mancano elencoPianiPossibili
				insert.getValueCorsoDiStudi2();

				//fascie orarie inserite in arraylist<FasciaOraria>
				insert.getValueFasciaOraria();

				//le sottoclassi di attività inserite nei rispettivi arraylist
				insert.getValueAttività1();


				insert.getValuePianoDiStudi();

				//docente inseriti in arraylist<Docente>
				insert.getValueDocente();


				insert.getValueAttività2();
		 

				GeneraPianiDiStudio generaPiani = new GeneraPianiDiStudio(model);
				generaPiani.generaPiani();
				
				
				if(viewOrario.getTableRecords().getRowCount()!=0)
					for (int i = 0; i<21; i++){
						viewOrario.getTableRecords().removeRow(0);
					}

				for (int i=0; i<viewOrario.getTableRecords().getColumnCount(); i++)
					viewOrario.getTableRecords().setColumnCount(0);
				
				viewOrario.getLabelNumIterazioni().setText("");
				viewOrario.getLabelNumSovr().setText("");
				viewOrario.getSalva().setEnabled(false);
				
				viewOrario.getVisualizzaTutto().removeAll();
				viewOrario.getVisualizzaAttività().removeAll();
				viewOrario.getVisualizzaDocente().removeAll();
				viewOrario.getVisualizzaCorso().removeAll();
				viewOrario.getPocheIterazioni().setSelected(true);


				
				viewOrario.getFrame().setVisible(true);


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



	}