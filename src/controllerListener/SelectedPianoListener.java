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

public class SelectedPianoListener implements  ActionListener
{

	private Model model;
	private ViewTimeTable viewOrario;

	public SelectedPianoListener(Model model, ViewTimeTable viewOrario) {
		this.model = model;
		this.viewOrario = viewOrario;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent action)
	{


		//viewOrario.getComboBoxAttivitàInserite().setSelectedItem("");


		model.setTabella(new Vector<Vector<String>>());

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


		System.out.println("ciao");

		String[] app;

		for (int i=0; i<model.getListOrario().size(); i++){
			countDay = 0;
			model.getTabella().addElement(new Vector<String>());
			for (int j=0; j<model.getListOrario().get(i).getElencoAssegnamenti().size(); j++){
				app = viewOrario.getComboBoxPiani().getSelectedItem().toString().split("-");

				if (model.AttivitàInCorso(model.getListOrario().get(i).getElencoAssegnamenti().get(j).getAttività().getId(), app[0].trim()))
					countDay++;
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
				/**
				 * 
				 */
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
							cell.setBackground( Color.YELLOW );
							cell.setForeground(Color.YELLOW);
						}
						else{
							if (value.equals("2")){
								cell.setBackground( Color.ORANGE );
								cell.setForeground(Color.ORANGE);
							}
							else{
								cell.setBackground( Color.RED );
								cell.setForeground(Color.RED);
							}
						}

					}
					return cell;

				}});

		}



	}
}