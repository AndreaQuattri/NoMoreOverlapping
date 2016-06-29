/*
 * 
 */
package xmlParser;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import mvc.Model;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import myComponents.Assegnamento;
import myComponents.Attività;
import myComponents.Aula;
import myComponents.CorsoDiStudi;
import myComponents.Docente;
import myComponents.FasciaOraria;
import myComponents.Orario;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLOrarioParserDOM.
 */
public class XMLOrarioParserDOM{

	/**
	 * Gets the orario from file light.
	 *
	 * @param model the model
	 * @param file the file
	 * @return the orario from file light
	 * @throws XMLStreamException the XML stream exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public static Orario getOrarioFromFileLight(Model model, String file) throws XMLStreamException, SAXException, IOException, ParserConfigurationException {
		Orario ret = null;
		Document doc = setUpXMLDocumentIn(file);
		NodeList nList = null;
		
		// carico gli assegnamenti
		nList = doc.getElementsByTagName("Assegnamento");
		ArrayList<Assegnamento> elencoAs = loadAssegnamenti( model , nList );
		
		ret = new Orario(elencoAs);
	    return ret;
	}

	/**
	 * Write orario on file light.
	 *
	 * @param file the file
	 * @param o the o
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws TransformerException the transformer exception
	 */
	public static void writeOrarioOnFileLight(String file, Orario o) throws SAXException, IOException, ParserConfigurationException, TransformerException {
	
		//setup document builder
		Document doc = setUpXMLDocumentOut();
		Element e;
		
		// root elements
		Element rootElement = doc.createElement("Orario");
		doc.appendChild(rootElement);
		
		//initialize
		ArrayList<Assegnamento> elencoAs = new ArrayList<Assegnamento>();
		
		// no object saving
		if ( o != null ) {
			elencoAs = o.getElencoAssegnamenti();
		}
		else {
			elencoAs = new ArrayList<Assegnamento>();
		}
		
		// Attività
		e = doc.createElement("ElencoAttività");
		rootElement.appendChild(e);
		
		// Assegnamenti
		e = saveAssegnamenti(doc,elencoAs);
		rootElement.appendChild(e);
		
		// Corsi di Studi
		e = doc.createElement("ElencoCorsi");
		rootElement.appendChild(e);
				
		// write the content into xml file
		writeXMLFile(doc,file);

	}

	/**
	 * Gets the orario from file full.
	 *
	 * @param model the model
	 * @param file the file
	 * @return the orario from file full
	 * @throws XMLStreamException the XML stream exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws DOMException the DOM exception
	 * @throws ParseException the parse exception
	 */
	public static Orario getOrarioFromFileFull(Model model , String file) throws XMLStreamException, SAXException, IOException, ParserConfigurationException, DOMException, ParseException {
		Orario ret = null;
	
		Document doc = setUpXMLDocumentIn(file);
		NodeList nList = null;
		
		// carico le attività
		nList = doc.getElementsByTagName("Attività");
		ArrayList<Attività> elencoAt = loadAttività( model , nList );
		
		// carico gli assegnamenti
		nList = doc.getElementsByTagName("Assegnamento");
		ArrayList<Assegnamento> elencoAs = loadAssegnamenti( model , nList , elencoAt );
		
		// carico gli assegnamenti
		nList = doc.getElementsByTagName("CorsoDiStudi");
		ArrayList<CorsoDiStudi> elencoCorsi = loadCorsi( model , nList );
		
		// Crea orario
		ret = new Orario(elencoAs, elencoAt , elencoCorsi );
	    
		return ret;
	}

	/**
	 * Write orario on file full.
	 *
	 * @param file the file
	 * @param o the o
	 * @throws TransformerException the transformer exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public static void writeOrarioOnFileFull(String file, Orario o) throws TransformerException, SAXException, IOException, ParserConfigurationException {
			
		//setup document builder
		Document doc = setUpXMLDocumentOut();
		Element e;
		
		// root elements
		Element rootElement = doc.createElement("Orario");
		doc.appendChild(rootElement);
		
		//initialize
		ArrayList<Assegnamento> elencoAs = null;
		ArrayList<Attività> elencoAt = null;
		ArrayList<CorsoDiStudi> elencoCorsi = null;
		
		// no object saving
		if ( o != null ) {
			elencoAs = o.getElencoAssegnamenti();
			elencoAt = o.getElencoAttività();
			elencoCorsi = o.getElencoCorsi();
		}
		else {
			elencoAs = new ArrayList<Assegnamento>();
			elencoAt = new ArrayList<Attività>();
			elencoCorsi = new ArrayList<CorsoDiStudi>();
		}
		

		
		// Attività
		e = saveAttività(doc,elencoAt);
		rootElement.appendChild(e);
		
		// Assegnamenti
		e = saveAssegnamenti(doc,elencoAs);
		rootElement.appendChild(e);
		
		// Corsi di Studi
		e = saveCorsi(doc,elencoCorsi);
		rootElement.appendChild(e);
				
				
		// write the content into xml file
		writeXMLFile(doc,file);

		
	}
	
	// save methods
	
	/**
	 * Save attività.
	 *
	 * @param doc the doc
	 * @param elencoAt the elenco at
	 * @return the element
	 */
	private static Element saveAttività(Document doc, ArrayList<Attività> elencoAt) {

		Element e = doc.createElement("ElencoAttività");
		Iterator<Attività> i = elencoAt.iterator();
		
		while ( i != null && i.hasNext()) {

			// Attività element
			Element a = doc.createElement("Attività");
			e.appendChild(a);
			Attività att = i.next();

			// ID
			a.appendChild(createElem(doc,"Id",att.getId()));
			
			// Nome
			a.appendChild(createElem(doc,"Nome",att.getNome()));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			// Data di Inizio
			a.appendChild(createElem(doc,"Inizio",format.format(att.getInizio())));
			// Data di Fine
			a.appendChild(createElem(doc,"Fine",format.format(att.getFine())));

			// Ore
			a.appendChild(createElem(doc,"Ore",""+att.getOre()));

			// Semestre
			a.appendChild(createElem(doc,"Semestre",""+att.getSemestre()));
			
			// Descrizione
			a.appendChild(createElem(doc,"Descrizione",att.getDescrizione()));
				
			// Responsabili
			Element resp = doc.createElement("ElencoResponsabili");
			a.appendChild(resp);
			ArrayList<Docente> elresp = att.getElencoResponsabili();
			Iterator<Docente> j = elresp.iterator();
			while( j != null && j.hasNext() ) {
				Element dEl = doc.createElement("Docente");
				resp.appendChild(dEl);
				Docente d = j.next();
				
				// Nome
				dEl.appendChild(createElem(doc, "Nome", d.getNome()));

				// Cognome
				dEl.appendChild(createElem(doc, "Cognome", d.getCognome()));
				
				// Associato
				dEl.appendChild(createElem(doc, "Associato", d.isAssociato() ? "true" : "false" ));

				// Matricola
				dEl.appendChild(createElem(doc, "Matricola", d.getMatricola()));
				
				// Email
				dEl.appendChild(createElem(doc, "Email", d.getEmail()));
				
			}
			
  		}
		
		return e;
	}

	/**
	 * Save assegnamenti.
	 *
	 * @param doc the doc
	 * @param elencoAs the elenco as
	 * @return the element
	 */
	private static Element saveAssegnamenti(Document doc , ArrayList<Assegnamento> elencoAs) {
		
		Element e = doc.createElement("ElencoAssegnamento");
		Iterator<Assegnamento> i = elencoAs.iterator();
		
		while ( i != null && i.hasNext()) {

			// Assegnamento element
			Element a = doc.createElement("Assegnamento");
			e.appendChild(a);
			Assegnamento ass = i.next();
			
			// Attività
			a.appendChild(createElem(doc,"IdAttività",ass.getAttività().getId()));
			
			// Aula
			Element aula = doc.createElement("Aula");
			a.appendChild(aula);
			Aula aulaSupport = ass.getAula();
			aula.appendChild(createElem(doc,"Edificio",aulaSupport.getEdificio()));
			aula.appendChild(createElem(doc,"Numero",""+aulaSupport.getNumero()));
			aula.appendChild(createElem(doc,"Capienza",""+aulaSupport.getCapienza()));
			
			// Fascia Oraria
			a.appendChild(createElem(doc,"FasciaOraria",""+ass.getFasciaOraria().getIdFascia()));
  		}
		return e;
	}

	/**
	 * Save corsi.
	 *
	 * @param doc the doc
	 * @param elencoCorsi the elenco corsi
	 * @return the element
	 */
	private static Element saveCorsi(Document doc, ArrayList<CorsoDiStudi> elencoCorsi) {
		Element e = doc.createElement("ElencoCorsi");
		Iterator<CorsoDiStudi> i = elencoCorsi.iterator();
		
		while ( i != null && i.hasNext()) {

			// Attività element
			Element c = doc.createElement("CorsoDiStudi");
			e.appendChild(c);
			CorsoDiStudi cds = i.next();

			// Anno
			c.appendChild(createElem(doc,"Anno",""+cds.getAnno()));
			
			// Nome Principale
			c.appendChild(createElem(doc,"NomePrincipale",cds.getNomePrincipale()));
			
			// Indirizzo
			c.appendChild(createElem(doc,"Indirizzo",cds.getIndirizzo()));
			
			// Tipo di Laurea
			c.appendChild(createElem(doc,"TipoLaurea",cds.getTipoLaurea()));
			
			// Facoltà
			c.appendChild(createElem(doc,"Facoltà",cds.getFacoltà()));
			
			// Codice
			c.appendChild(createElem(doc,"Codice",cds.getCodice()));
			
			// Descrizione
			c.appendChild(createElem(doc,"Descrizione",cds.getDescrizione()));
				
			// Totale Crediti
			c.appendChild(createElem(doc,"TotCrediti",""+cds.getTotCrediti()));
						
			
		}	
		return e;
		
	}
	
	// load methods

	/**
	 * Load attività.
	 *
	 * @param model the model
	 * @param nList the n list
	 * @return the array list
	 * @throws DOMException the DOM exception
	 * @throws ParseException the parse exception
	 */
	private static ArrayList<Attività> loadAttività(Model model, NodeList nList) throws DOMException, ParseException {

		ArrayList<Attività> elencoAt = new ArrayList<Attività>();
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				
				Attività att = new Attività( );
				
				// ID
				att.setId( eElement.getElementsByTagName("Id").item(0).getTextContent() );
				
				// Nome
				att.setNome( eElement.getElementsByTagName("Nome").item(0).getTextContent() );
				
				// Data di inizio
				att.setInizioByString( eElement.getElementsByTagName("Inizio").item(0).getTextContent() );
				
				// Data di inizio
				att.setFineByString( eElement.getElementsByTagName("Fine").item(0).getTextContent() );
				
				// Ore
				att.setOre( Integer.parseInt(eElement.getElementsByTagName("Ore").item(0).getTextContent() ) );
				
				// Semestre
				att.setSemestre( Integer.parseInt( eElement.getElementsByTagName("Semestre").item(0).getTextContent() ) );
				
				// Descrizione
				att.setDescrizione( eElement.getElementsByTagName("Descrizione").item(0).getTextContent() );
				
				// Respirabili
				ArrayList<Docente> elresp = new ArrayList<Docente>();
				NodeList resp = eElement.getElementsByTagName("Docente");
				for (int j = 0; resp != null && j < resp.getLength(); j++) {

					Node docenteNod = resp.item(j);
					if (docenteNod.getNodeType() == Node.ELEMENT_NODE) {
						Element docenteEl = (Element) docenteNod ;
						Docente d = new Docente();
						
						// Nome
						d.setNome( docenteEl.getElementsByTagName("Nome").item(0).getTextContent() );
						
						// Cognome
						d.setCognome( docenteEl.getElementsByTagName("Cognome").item(0).getTextContent());
						
						// Associato
						d.setAssociato( docenteEl.getElementsByTagName("Associato").item(0).getTextContent().equals("true") );
						
						// Matricola
						d.setMatricola( docenteEl.getElementsByTagName("Matricola").item(0).getTextContent());
						
						// Email
						d.setEmail( docenteEl.getElementsByTagName("Email").item(0).getTextContent());
						
						// aggiungi il docente
						elresp.add(d);
					}
				}
				// aggiungi l'elenco dei responsabili
				att.setElencoResponsabili(elresp);
				
				// aggiungi attività
				elencoAt.add(att);
			}
		}
		return elencoAt;
	}
	
	/**
	 * Load assegnamenti.
	 *
	 * @param model the model
	 * @param nList the n list
	 * @return the array list
	 */
	private static ArrayList<Assegnamento> loadAssegnamenti(Model model , NodeList nList ) {
		return loadAssegnamenti(model, nList, null);
	}
	
	/**
	 * Load assegnamenti.
	 *
	 * @param model the model
	 * @param nList the n list
	 * @param elencoAt the elenco at
	 * @return the array list
	 */
	private static ArrayList<Assegnamento> loadAssegnamenti(Model model , NodeList nList , ArrayList<Attività> elencoAt ) {

		ArrayList<Assegnamento> elencoAs = new ArrayList<Assegnamento>();
		int unknownAtt = 1;
		
		for (int j = 0; j < nList.getLength(); j++) {

			Node nNode = nList.item(j);
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				Assegnamento ass = new Assegnamento( );
				
				//Attività
				String idAtt = eElement.getElementsByTagName("IdAttività").item(0).getTextContent() ;
				Attività att = null;
				if( elencoAt == null )
					att = model.findAttività( idAtt );
				else {
					att = new Attività();
					att.setId(idAtt);
					att = elencoAt.get( elencoAt.indexOf( att ) );
				}
				if ( att == null )
					att = new Attività(idAtt, "Attività Sconosciuta", "Attività Sconosciuta "+(unknownAtt++));
				ass.setAttività( att );
				
				//Aula
				ass.setAula( new Aula(
								eElement.getElementsByTagName("Edificio").item(0).getTextContent() ,
								Integer.parseInt( eElement.getElementsByTagName("Numero").item(0).getTextContent() ) ,
								Integer.parseInt( eElement.getElementsByTagName("FasciaOraria").item(0).getTextContent() ) ) );

				// Fascia Oraria				
				int idFo = Integer.parseInt( eElement.getElementsByTagName("FasciaOraria").item(0).getTextContent() ) ;
				FasciaOraria fo = model.findFasciaOraria( idFo );
				if ( fo == null ) {
					fo = new FasciaOraria();
					fo.setIdFascia(idFo);
				}
				ass.setFasciaOraria( fo );
				
				//Aggiungi assegnamento
				elencoAs.add(ass);
			}
		}
		return elencoAs;
	}

	/**
	 * Load corsi.
	 *
	 * @param model the model
	 * @param nList the n list
	 * @return the array list
	 */
	private static ArrayList<CorsoDiStudi> loadCorsi(Model model, NodeList nList) {
		ArrayList<CorsoDiStudi> elencoCorsi = new ArrayList<CorsoDiStudi>();
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				
				CorsoDiStudi cds = new CorsoDiStudi( );
				
				// Anno
				cds.setAnno( Short.parseShort( eElement.getElementsByTagName("Anno").item(0).getTextContent() ) );
				
				// Nome Principale
				cds.setNomePrincipale( eElement.getElementsByTagName("NomePrincipale").item(0).getTextContent() );
				
				// Indirizzo
				cds.setIndirizzo( eElement.getElementsByTagName("Indirizzo").item(0).getTextContent() );
				
				// Tipo di Laurea
				cds.setTipoLaurea( eElement.getElementsByTagName("TipoLaurea").item(0).getTextContent() );
				
				// Facoltà
				cds.setFacoltà( eElement.getElementsByTagName("Facoltà").item(0).getTextContent() );
				
				// Codice
				cds.setCodice( eElement.getElementsByTagName("Codice").item(0).getTextContent() );
				
				// Descrizione
				cds.setDescrizione( eElement.getElementsByTagName("Descrizione").item(0).getTextContent() );
				
				// Totale Crediti
				cds.setTotCrediti( Integer.parseInt( eElement.getElementsByTagName("TotCrediti").item(0).getTextContent() ) );
				
				elencoCorsi.add(cds);
			}
		}
		return elencoCorsi;
	}
	
	// support XML methods
	
	/**
	 * Sets the up xml document in.
	 *
	 * @param file the file
	 * @return the document
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	private static Document setUpXMLDocumentIn(String file) throws SAXException, IOException, ParserConfigurationException {
		// error case
		if ( file == null || file == "" ) {
			file = "temp.xml";
		}
		else if ( !file.endsWith(".xml") )
			file = file + ".xml";
		
		File fXmlFile = new File(file);
		fXmlFile.createNewFile();

	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		
		return doc;
	}
	
	/**
	 * Sets the up xml document out.
	 *
	 * @return the document
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	private static Document setUpXMLDocumentOut() throws SAXException, IOException, ParserConfigurationException {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		return doc;
	}
	
	/**
	 * Creates the elem.
	 *
	 * @param doc the doc
	 * @param nome the nome
	 * @param value the value
	 * @return the element
	 */
	private static Element createElem( Document doc , String nome , String value ) {
		Element id = doc.createElement(nome);
		id.appendChild(doc.createTextNode(value));
		return id;
	}

	/**
	 * Write xml file.
	 *
	 * @param doc the doc
	 * @param file the file
	 * @throws TransformerException the transformer exception
	 */
	private static void writeXMLFile(Document doc, String file) throws TransformerException {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(file));
		transformer.transform(source, result);

		
	}
	
}
