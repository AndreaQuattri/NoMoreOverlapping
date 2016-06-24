package pdfPrinter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import mvc.Model;
import myComponents.Assegnamento;
import myComponents.FasciaOraria;
import myComponents.Orario;

public class PdfPrinter implements ActionListener{
	
	private static Font bigFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
	private static Font mediumFont = new Font(Font.FontFamily.HELVETICA, 11 , Font.BOLD);
	private static Font smallFont = new Font(Font.FontFamily.HELVETICA, 11 );
	private static SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	
	private static String[] titoli = { "ORA DI INIZIO" , "LUNEDI" , "MARTEDI" , "MERCOLEDI" , "GIOVEDI" , "VENERDI" , "SABATO" };
	private static final int NCOL = titoli.length;
	
	private static ArrayList<String[]> toPrint;
	
	private static Boolean cellFlag = false;
	private static PdfPCell cHead = new PdfPCell();
	private static PdfPCell cBody = new PdfPCell();
	
	private Model model;
	
	public PdfPrinter(Model model) {
		this.model = model;
	}
	
	
	private static void setupCell() {
		if ( cellFlag )
			return;
		cHead.setHorizontalAlignment(Element.ALIGN_CENTER);
		cHead.setGrayFill(0.8f);
		cBody.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellFlag = true;
	}
	

	private static Element aggiungiTitolo(final String title) throws DocumentException {
		Paragraph p = new Paragraph(title,bigFont);
		p.setAlignment(Element.ALIGN_CENTER);
		aggiungiLineaVuota(p, 1);
		return p;
		
	}

	private static void aggiungiLineaVuota(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++)
			paragraph.add(new Paragraph(" "));
	}

	private static void aggiungiMetaDati(final Document document, final String title) {
		document.addTitle(title);
		document.addSubject("Orario ottimizzato " + new SimpleDateFormat("dd/MM/yyyy").format( new Date() ));
		document.addKeywords("Orario, Overlapping, iText");
		document.addAuthor("No More Overlapping tool");
		document.addCreator(System.getProperty("user.name"));
	}

	private static PdfPTable creaTabella(Orario o , ArrayList<FasciaOraria> listFO) throws Exception  {
		PdfPTable tabella = new PdfPTable(NCOL);
		
		//impostazioni tabella
		tabella.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.setWidthPercentage(100);
		
		setupCell();
		
		addFirstRow(tabella);
		
		setupTable(listFO);
		
		insertOrario(o);
		
		printOnTable(tabella);
		
		return tabella;
	}

	private static void insertOrario(Orario o) throws Exception {
		ArrayList<Assegnamento> listA = o.getElencoAssegnamenti();
		
		Iterator<Assegnamento> i = listA.iterator();

		while( i != null && i.hasNext() ) {
			Assegnamento a = i.next();
			FasciaOraria fo = a.getFasciaOraria();
			
			
			int startRow = findRow( format.format(fo.getInizio()) );
			int endRow = findRow( format.format(fo.getFine()) ) - 1;
			
			int dayCol = findCol( fo.getGiorno() );
			endRow = addAssegnamento( a , startRow , endRow , dayCol );
		}
	}
	
	/**
	 * aggiunge un assegnamento alla tabella nelle posizioni indicate
	 * @param a
	 * @param startRow
	 * @param endRow
	 * @param dayCol
	 */
	private static int addAssegnamento(Assegnamento a , int startRow , int endRow , int dayCol ) {
		
		// indica che sei pronto ad inserire l'assegnamento nella prima casella disponibile
		Boolean flagHour = false;
		
		
		for( int i = startRow ; i <= endRow ; i++ ) {
			
			//prendi array da toPrint
			String[] s = new String[NCOL];
			for( int j = 0 ; j < NCOL ; j ++ )
				s[j] = toPrint.get(i)[j];
				
			//inizia una nuova fascia oraria
			if( !s[0].isEmpty() ) {
				if( !flagHour )
					// se non aspettando per inserire ora aspetto
					flagHour = true;
				else {
					//se sto ancora aspettando di inserire la riga precedente aggiunga una riga per inserirla
					addRow(i,dayCol,a.getAttività().getNome() + "\n" + a.getAula());
					endRow++;
					flagHour = false;
				}
			}
			
			if( flagHour ) {
				if ( s[dayCol].isEmpty() ) {
					s[ dayCol ] = a.getAttività().getNome() + "\n" + a.getAula();
					flagHour = false;
				}
			}
			
			//reinserisci array modificato
			toPrint.set(i, s);
		}
		
		if( flagHour ) {
			//se sto ancora aspettando di inserire la riga precedente la inserisco
			endRow++;
			addRow(endRow,dayCol,a.getAttività().getNome() + "\n" + a.getAula());
		}
		return endRow;
		
	}
	

	private static void addRow(int i, int dayCol, String string) {

		String[] add = new String[NCOL];
		for(int j = 0 ; j < NCOL ; j ++ )
			add[j] = new String();
		add[dayCol] = string;
		toPrint.add(i, add);
		
	}


	/**
	 * restituisce l'indice della colonna che ha come primo elemento la stringa corrispondente al giorno dato
	 * @param giorno
	 * @return
	 * @throws Exception 
	 */
	private static int findCol(String giorno) throws Exception {
	
		for	(int i = 1 ; i < NCOL ; i ++)
			if( titoli[i].equals(giorno.toUpperCase()) )
				return i;	
		throw new Exception("col not found: " + giorno);
	}
	
	
	/**
	 * restituisce l'indice della riga che ha come primo elemento la stringa ora
	 * @param ora stringa da cercare
	 * @return indice della riga corrispondente all'ora cercata
	 * @throws Exception row not found
	 */
	private static int findRow(String ora) throws Exception {
		//inserisco le restanti fasce orarie
		int len = toPrint.size();
		for	(int i = 0 ; i < len ; i ++) {
			if( ora.equals(toPrint.get(i)[0]) )
				return i;
		}
		return len;
	}


	private static void printOnTable(PdfPTable tabella) {
		
		Iterator<String[]> i = toPrint.iterator();
		while( i != null && i.hasNext() ) {
			String[] row = i.next();
			
			// intestazione riga
			cHead.setPhrase(new Phrase((!row[0].isEmpty())?row[0]:" ",mediumFont));
			tabella.addCell(cHead);

			//colonne
			for( int j = 1 ; j < NCOL ; j ++ ) {
				cBody.setPhrase(new Phrase((!row[j].isEmpty())?row[j]:" ",smallFont));
				tabella.addCell(cBody);
			}
		}	
		
		
		
		
		
	}

	private static void setupTable( ArrayList<FasciaOraria> listFO) throws Exception {

		toPrint = new ArrayList<String[]>();
		Iterator<FasciaOraria> i = listFO.iterator();
		
		//non ci sono fasce orarie
		if (i == null)
			throw new Exception("ERROR PRINTING PDF");
			
		//la prima fascia oraria segnala la fine per evitare ripetizioni (suppone che la lisa sia ordinata e ricominci con il primo elemento)
		String[] add = new String[NCOL];
		add[0] = new String( format.format(i.next().getInizio()) );
		for(int j = 1 ; j < NCOL ; j ++ )
			add[j] = new String();
		String end = add[0];
		toPrint.add(add);
		
		//inserisco le restanti fasce orarie
		while( i != null && i.hasNext() ) {
			add = new String[NCOL];
			add[0] = new String( format.format(i.next().getInizio()) );
			if( end.equals(add[0]) )
				return;
			for(int j = 1 ; j < NCOL ; j ++ )
				add[j] = new String();
			toPrint.add(add);		
		}
	}

	private static void addFirstRow(PdfPTable tabella) {
		
		// inserimento celle
		for( int i = 0 ; i < NCOL ; i ++ ) {
			cHead.setPhrase(new Phrase(titoli[i],mediumFont));
			tabella.addCell(cHead);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String fileName = "prova.pdf";
		String title = "Orario Ingegneria";
		
		try {
			// error case
			if ( fileName == null || fileName == "" ) {
				fileName = "temp.pdf";
				System.out.println("ERROR: No PDF file name");
			}
			else if ( !fileName.endsWith(".pdf") )
				fileName = fileName + ".pdf";
			
			
			FileOutputStream file = new FileOutputStream(new File(fileName));

			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			aggiungiMetaDati(document,title);
			document.add(aggiungiTitolo(title));
			document.add(creaTabella(model.getOrarioUfficiale(), model.getListFasciaOraria()));
			
			document.close();
			file.close();
			System.out.println("pdf salvato col nome " + fileName);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}


	public Model getModel() {
		return model;
	}


	public void setModel(Model model) {
		this.model = model;
	}
}


//TODO fai il modo che riceva l'orario già filtrato quando viene chiamato

