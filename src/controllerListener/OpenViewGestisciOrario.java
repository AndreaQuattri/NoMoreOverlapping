package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import memorizzazioneDati.GeneraPianiDiStudio;
import memorizzazioneDati.InsertValues;
import mvc.Model;
import mvc.ViewTimeTable;
import myComponents.Assegnamento;
import myComponents.Attività;
import myComponents.Aula;
import myComponents.Convegno;
import myComponents.CorsoDiStudi;
import myComponents.Disciplina;
import myComponents.Docente;
import myComponents.Esame;
import myComponents.FasciaOraria;
import myComponents.Gita;
import myComponents.Orario;
import myComponents.PianoDiStudi;
import myComponents.Studente;
import myComponents.Tirocinio;

public class OpenViewGestisciOrario implements  ActionListener 
	{
	
	private Model model;
	private ViewTimeTable viewOrario;
	
	public OpenViewGestisciOrario(Model model, ViewTimeTable viewOrario) {
		this.model = model;
		this.viewOrario = viewOrario;
	}
	
	
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
			model.setListOrario(new ArrayList<Orario>());
			model.setListPianoDiStudi(new ArrayList<PianoDiStudi>());
			model.setListStudente(new ArrayList<Studente>());
			model.setListTirocinio(new ArrayList<Tirocinio>());
			model.setTabella(new Vector<Vector<String>>());
			model.setListAttivitàInserite(new ArrayList<Attività>());
			
			model.setListOrario(null);
			model.setListOrario(new ArrayList<Orario>());

			model.setListAssegnamento(null);
			model.setListAssegnamento(new ArrayList<Assegnamento>());
			
			model.setTabella(new Vector<Vector<String>>());

			try {

				//aula inserita in arraylist<Aula> correttamente
				insert.getValueAula();

				//corsi di studi inseriti in arraylist<CorsoDiStudi>
				insert.getValueCorsoDiStudi_1();

				//studenti inseriti in arrayList<Studente>
				insert.getValueStudente();

				//corsi di studi inseriti in arraylist<CorsoDiStudi>
				//mancano elencoPianiPossibili
				insert.getValueCorsoDiStudi_2();

				//fascie orarie inserite in arraylist<FasciaOraria>
				insert.getValueFasciaOraria();

				//le sottoclassi di attività inserite nei rispettivi arraylist
				insert.getValueAttività_1();


				insert.getValuePianoDiStudi();

				//docente inseriti in arraylist<Docente>
				insert.getValueDocente();


				insert.getValueAttività_2();
		 

				GeneraPianiDiStudio generaPiani = new GeneraPianiDiStudio(model);
				generaPiani.generaPiani();
				
				
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