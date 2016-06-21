package pdfPrinter;

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

import myComponents.Assegnamento;
import myComponents.FasciaOraria;
import myComponents.Orario;

public class PdfPrinter {
	private static Font bigFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
	private static Font mediumFont = new Font(Font.FontFamily.HELVETICA, 11 , Font.BOLD);
	private static Font smallFont = new Font(Font.FontFamily.HELVETICA, 11 );
	private static SimpleDateFormat format = new SimpleDateFormat("hh:mm");
	
	private static String[] titoli = { "ORA DI INIZIO" , "LUNEDI" , "MARTEDI" , "MERCOLEDI" , "GIOVEDI" , "VENERDI" , "SABATO" };
	private static final int NCOL = titoli.length;
	
	private static ArrayList<String[]> toPrint;
	
	private static Boolean cellFlag = false;
	private static PdfPCell cHead = new PdfPCell();
	private static PdfPCell cBody = new PdfPCell();
	
	private static void setupCell() {
		if ( cellFlag )
			return;
		cHead.setHorizontalAlignment(Element.ALIGN_CENTER);
		cHead.setGrayFill(0.8f);
		cBody.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellFlag = true;
	}
	
	
	public static void printReport(String fileName, final String title , Orario o , ArrayList<FasciaOraria> listFO ) {
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
			document.add(creaTabella(o, listFO));
//			document.add(creaTabellaStandard());
			
			
			document.close();
			file.close();
			System.out.println("pdf salvato col nome " + fileName);

		} catch (Exception e) {
			e.printStackTrace();
		}

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

//	private static PdfPTable creaTabellaStandard() {
//		
//		PdfPTable tabella = new PdfPTable(NCOL);
//		//impostazioni tabella
//		tabella.setHorizontalAlignment(Element.ALIGN_CENTER);
//		tabella.setWidthPercentage(100);
//
//		setupCell();
//		
//		// INTESTAZIONE COLONNE
//		
//		// prima vuota
//		cHead.setPhrase(new Phrase("",mediumFont));
//		tabella.addCell(cHead);
//		
	// giorni della settimana
//		cHead.setPhrase(new Phrase("LUNEDì",mediumFont));
//		tabella.addCell(cHead);
//		cHead.setPhrase(new Phrase("MARTEDì",mediumFont));
//		tabella.addCell(cHead);
//		cHead.setPhrase(new Phrase("MERCOLEDì",mediumFont));
//		tabella.addCell(cHead);
//		cHead.setPhrase(new Phrase("GIOVEDì",mediumFont));
//		tabella.addCell(cHead);
//		cHead.setPhrase(new Phrase("VENERDì",mediumFont));
//		tabella.addCell(cHead);
//		cHead.setPhrase(new Phrase("SABATO",mediumFont));
//		tabella.addCell(cHead);
//		
//		//INTESTAZIONE RIGA
//		cHead.setPhrase(new Phrase("RIGA "+1,mediumFont));
//		tabella.addCell(cHead);
//
//		cBody.setPhrase(new Phrase("1",smallFont));
//		tabella.addCell(cBody);
//		cBody.setPhrase(new Phrase("2",smallFont));
//		tabella.addCell(cBody);
//		cBody.setPhrase(new Phrase("3",smallFont));
//		tabella.addCell(cBody);
//		cBody.setPhrase(new Phrase("4",smallFont));
//		tabella.addCell(cBody);
//		cBody.setPhrase(new Phrase("5",smallFont));
//		tabella.addCell(cBody);
//		cBody.setPhrase(new Phrase("6",smallFont));
//		tabella.addCell(cBody);
//		
//		
//
//		//INTESTAZIONE RIGA
//		cHead.setPhrase(new Phrase("RIGA "+2,mediumFont));
//		tabella.addCell(cHead);
//
//		cBody.setPhrase(new Phrase("1",smallFont));
//		tabella.addCell(cBody);
//		cBody.setPhrase(new Phrase("2",smallFont));
//		tabella.addCell(cBody);
//		cBody.setPhrase(new Phrase("3",smallFont));
//		tabella.addCell(cBody);
//		cBody.setPhrase(new Phrase("4",smallFont));
//		tabella.addCell(cBody);
//		cBody.setPhrase(new Phrase("5",smallFont));
//		tabella.addCell(cBody);
//		cBody.setPhrase(new Phrase("6",smallFont));
//		tabella.addCell(cBody);
//
//		return tabella;
//
//	}
	
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
		System.out.println(format.format(fo.getInizio()) +" "+ startRow);
		int endRow = findRow( format.format(fo.getFine()) ) - 1;		//TODO -1!?!?! giusto? o inizio
		System.out.println(format.format(fo.getFine()) + " "+ endRow);
		int dayCol = findCol( fo.getGiorno() );
		System.out.println(fo.getGiorno() + " " + dayCol);
		maybeAddRow( startRow , endRow , dayCol );
		addAssegnamento( a , startRow , endRow , dayCol );
	}
}

/**
 * aggiunge un assegnamento alla tabella nelle posizioni indicate
 * @param a
 * @param startRow
 * @param endRow
 * @param dayCol
 */
private static void addAssegnamento(Assegnamento a , int startRow , int endRow , int dayCol ) {
		// TODO Auto-generated method stub
		
	}


/**controlla tutte le righe in prossimità del giorno indicato,
 * se non c'è modo di inserire l'assegnamento allora aggiunge
 * una riga vuota
 * @param startRow riga di inizio
 * @param endRow riga di fine
 * @param dayCol colonna da controllare
 */
private static void maybeAddRow(int startRow, int endRow, int dayCol) {
		// TODO Auto-generated method stub
		
	}


/**
 * restituisce l'indice della colonna che ha come primo elemento la stringa corrispondente al giorno dato
 * @param giorno
 * @return
 * @throws Exception 
 */
private static int findCol(String giorno) throws Exception {

	//inserisco le restanti fasce orarie
	for	(int i = 0 ; i < NCOL ; i ++)
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
		for	(int i = 0 ; i < len ; i ++)
			if( ora.compareTo(toPrint.get(i)[0])==0)
				return i;	
		return len;
	}


	private static void printOnTable(PdfPTable tabella) {
		
		Iterator<String[]> i = toPrint.iterator();
		while( i != null && i.hasNext() ) {
			String[] row = i.next();
			
			// intestazione riga
			cHead.setPhrase(new Phrase(row[0],mediumFont));
			tabella.addCell(cHead);

			//colonne
			for( int j = 1 ; j < NCOL ; j ++ ) {
				cBody.setPhrase(new Phrase(row[j],smallFont));
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
		add[0] = format.format(i.next().getInizio());
		String end = add[0];
		toPrint.add(add);
		
		//inserisco le restanti fasce orarie
		while( i != null && i.hasNext() ) {
			FasciaOraria fo = i.next();
			add = new String[NCOL];
			add[0] = format.format(fo.getInizio());
			if( end.compareTo(add[0])==0)
				return;
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
}


