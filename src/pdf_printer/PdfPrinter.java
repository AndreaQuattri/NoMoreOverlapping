/*
 * 
 */
package pdf_printer;

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

import mvc.Model;
import my_components.Assegnamento;
import my_components.FasciaOraria;
import my_components.Orario;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfPrinter.
 */
public class PdfPrinter{
	
	/** The big font. */
	private static Font bigFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
	
	/** The medium font. */
	private static Font mediumFont = new Font(Font.FontFamily.HELVETICA, 11 , Font.BOLD);
	
	/** The small font. */
	private static Font smallFont = new Font(Font.FontFamily.HELVETICA, 11 );
	
	/** The format. */
	private static SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	
	/** The titoli. */
	private static String[] titoli = { "ORA DI INIZIO" , "LUNEDI" , "MARTEDI" , "MERCOLEDI" , "GIOVEDI" , "VENERDI" , "SABATO" };
	
	/** The Constant NCOL. */
	private static final int NCOL = titoli.length;
	
	/** The to print. */
	private static ArrayList<String[]> toPrint;
	
	/** The cell flag. */
	private static Boolean cellFlag = false;
	
	/** The c head. */
	private static PdfPCell cHead = new PdfPCell();
	
	/** The c body. */
	private static PdfPCell cBody = new PdfPCell();
	
	/** The model. */
	private Model model;
	
	/**
	 * Instantiates a new pdf printer.
	 *
	 * @param model the model
	 */
	public PdfPrinter(Model model) {
		this.model = model;
	}
	
	
	/**
	 * Setup cell.
	 */
	private static void setupCell() {
		if ( cellFlag )
			return;
		cHead.setHorizontalAlignment(Element.ALIGN_CENTER);
		cHead.setGrayFill(0.8f);
		cBody.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellFlag = true;
	}
	

	/**
	 * Aggiungi titolo.
	 *
	 * @param title the title
	 * @return the element
	 * @throws DocumentException the document exception
	 */
	public static Element aggiungiTitolo(final String title) throws DocumentException {
		Paragraph p = new Paragraph(title,bigFont);
		p.setAlignment(Element.ALIGN_CENTER);
		aggiungiLineaVuota(p, 1);
		return p;
		
	}

	/**
	 * Aggiungi linea vuota.
	 *
	 * @param paragraph the paragraph
	 * @param number the number
	 */
	private static void aggiungiLineaVuota(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++)
			paragraph.add(new Paragraph(" "));
	}

	/**
	 * Aggiungi meta dati.
	 *
	 * @param document the document
	 * @param title the title
	 */
	public static void aggiungiMetaDati(final Document document, final String title) {
		document.addTitle(title);
		document.addSubject("Orario ottimizzato " + new SimpleDateFormat("dd/MM/yyyy").format( new Date() ));
		document.addKeywords("Orario, Overlapping, iText");
		document.addAuthor("No More Overlapping tool");
		document.addCreator(System.getProperty("user.name"));
	}

	/**
	 * Crea tabella.
	 *
	 * @param o the o
	 * @param listFO the list fo
	 * @return the pdf p table
	 * @throws Exception the exception
	 */
	public static PdfPTable creaTabella(Orario o , ArrayList<FasciaOraria> listFO) throws Exception  {
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

	/**
	 * Insert orario.
	 *
	 * @param o the o
	 * @throws Exception the exception
	 */
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
	 * aggiunge un assegnamento alla tabella nelle posizioni indicate.
	 *
	 * @param a the a
	 * @param startRow the start row
	 * @param endRow the end row
	 * @param dayCol the day col
	 * @return the int
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
	

	/**
	 * Adds the row.
	 *
	 * @param i the i
	 * @param dayCol the day col
	 * @param string the string
	 */
	private static void addRow(int i, int dayCol, String string) {

		String[] add = new String[NCOL];
		for(int j = 0 ; j < NCOL ; j ++ )
			add[j] = new String();
		add[dayCol] = string;
		toPrint.add(i, add);
		
	}


	/**
	 * restituisce l'indice della colonna che ha come primo elemento la stringa corrispondente al giorno dato.
	 *
	 * @param giorno the giorno
	 * @return the int
	 * @throws Exception the exception
	 */
	private static int findCol(String giorno) throws Exception {
	
		for	(int i = 1 ; i < NCOL ; i ++)
			if( titoli[i].equals(giorno.toUpperCase()) )
				return i;	
		throw new Exception("col not found: " + giorno);
	}
	
	
	/**
	 * restituisce l'indice della riga che ha come primo elemento la stringa ora.
	 *
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


	/**
	 * Prints the on table.
	 *
	 * @param tabella the tabella
	 */
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

	/**
	 * Sets the up table.
	 *
	 * @param listFO the new up table
	 * @throws Exception the exception
	 */
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

	/**
	 * Adds the first row.
	 *
	 * @param tabella the tabella
	 */
	private static void addFirstRow(PdfPTable tabella) {
		
		// inserimento celle
		for( int i = 0 ; i < NCOL ; i ++ ) {
			cHead.setPhrase(new Phrase(titoli[i],mediumFont));
			tabella.addCell(cHead);
		}
		
	}



	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}


	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(Model model) {
		this.model = model;
	}
}


//TODO fai il modo che riceva l'orario già filtrato quando viene chiamato

