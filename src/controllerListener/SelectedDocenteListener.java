package controllerListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import mvc.Model;
import mvc.ViewTimeTable;

public class SelectedDocenteListener implements  ActionListener
{

	private Model model;
	private ViewTimeTable viewOrario;
	private String matricola;

	public SelectedDocenteListener(Model model, ViewTimeTable viewOrario, String matricola) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.viewOrario = viewOrario;
		this.matricola = matricola;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		setAttributeToView();
		model.setTabella(new Vector<Vector<String>>());

		if(viewOrario.getTableRecords().getRowCount()!=0)
			for (int i = 0; i<21; i++){
				viewOrario.getTableRecords().removeRow(0);
			}


		ArrayList<String> listGiorni = new ArrayList<String>();
		listGiorni.add("Lunedi");
		listGiorni.add("Martedi");
		listGiorni.add("Mercoledi");
		listGiorni.add("Giovedi");
		listGiorni.add("Venerdi");
		listGiorni.add("Sabato");


		int countDay=0;
		int iRighe=0;
		int iColonne=0;

		int inizioOra = 8;
		int inizioMinuto = 30;

		int fineOra = 9;
		int fineMinuto = 00;


		Date inizio = new Date(1111, 1, 1, inizioOra, inizioMinuto);
		Date fine = new Date(1111, 1, 1, fineOra, fineMinuto);

		Format formatter = new SimpleDateFormat("HH:mm");
		String oraInizio = formatter.format(inizio);
		String oraFine = formatter.format(fine);


		for (int i=0; i<model.getListFasciaOraria().size(); i++){

			countDay = 0;
			model.getTabella().addElement(new Vector<String>());
			for (int j=0; j<model.getOrarioUfficiale().getElencoAssegnamenti().size(); j++){
				if (model.getOrarioUfficiale().getElencoAssegnamenti().get(j).getFasciaOraria().equals(model.getListFasciaOraria().get(i))){
					for (int iDoc = 0; iDoc < model.getOrarioUfficiale().getElencoAssegnamenti().get(j).getAttività().getElencoResponsabili().size(); iDoc++){
						if (model.getOrarioUfficiale().getElencoAssegnamenti().get(j).getAttività().getElencoResponsabili().get(iDoc).getMatricola().equals(matricola))
							countDay++;
					}
				}
			}
			if (iColonne == 0){
				model.getTabella().get(iRighe).add(String.valueOf(oraInizio + " - " + oraFine));
				inizioMinuto+=30;
				fineMinuto+=30;

				inizio = new Date(1111, 1, 1, inizioOra, inizioMinuto);
				fine = new Date(1111, 1, 1, fineOra, fineMinuto);
				oraInizio = formatter.format(inizio);
				oraFine = formatter.format(fine);
			}

			model.getTabella().get(iRighe).add(String.valueOf(countDay));

			iColonne = iColonne + iRighe/20;
			iRighe = (iRighe + 1)%21;

		}

		for(int i=0; i<21; i++){
			viewOrario.getTableRecords().addRow(model.getTabella().get(i));
		}

		for (int i=1; i<7; i++){
			viewOrario.getTable().getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {

				private static final long serialVersionUID = 1L;

				public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
				{
					Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);

					if (value == null)
						return null;

					if (value.equals("0")){
						cell.setBackground( Color.gray );
						cell.setForeground(Color.gray);
					}
					else{
						if (value.equals("1")){
							cell.setBackground( Color.BLUE );
							cell.setForeground(Color.BLUE);
						}
						else{
							cell.setBackground( Color.red );
							cell.setForeground(Color.red);
						}

					}
					return cell;

				}});

		}

	}
	

	private void setAttributeToView(){
		String[] appoggio;
		for (int i=0; i<viewOrario.getVisualizzaDocente().getItemCount(); i++){
			appoggio = viewOrario.getVisualizzaDocente().getItem(i).getText().split("-");
			if (appoggio[0].trim().equals(matricola))
				viewOrario.getVisualizzaDocente().getItem(i).setSelected(true);
			else
				viewOrario.getVisualizzaDocente().getItem(i).setSelected(false);
		}
		for (int i=0; i<viewOrario.getVisualizzaAttività().getItemCount(); i++)
			viewOrario.getVisualizzaAttività().getItem(i).setSelected(false);
		for (int i=0; i<viewOrario.getVisualizzaCorso().getItemCount(); i++)
			viewOrario.getVisualizzaCorso().getItem(i).setSelected(false);
		viewOrario.getVisualizzaTutto().getItem(0).setSelected(false);

	}

}