package controller_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import mvc.Model;
import pdfPrinter.PdfPrinter;

public class SalvaPdfOrario implements ActionListener{

	private Model model;
	
	public SalvaPdfOrario(Model model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
String title = "Orario Ingegneria";
		
		
		JFileChooser fs = new JFileChooser(new File("c:\\"));
		fs.setDialogTitle("Save a File");
		fs.showSaveDialog(fs);
		
		
		


		// TODO Auto-generated method stub
		String fileName = fs.getSelectedFile().getPath();
		
		
		try {
			// error case
			if ( fileName == null || fileName == "" ) {
				fileName = "temp.pdf";
			}
			else if ( !fileName.endsWith(".pdf") )
				fileName = fileName + ".pdf";
			
			
			FileOutputStream file = new FileOutputStream(new File(fileName));

			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			PdfPrinter.aggiungiMetaDati(document,title);
			document.add(PdfPrinter.aggiungiTitolo(title));
			document.add(PdfPrinter.creaTabella(model.getOrarioDaMostrare(), model.getListFasciaOraria()));
			
			document.close();
			file.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	

}
