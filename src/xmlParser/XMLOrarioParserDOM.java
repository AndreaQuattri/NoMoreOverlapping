package xmlParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import myComponents.Assegnamento;
import myComponents.Attività;
import myComponents.Aula;
import myComponents.Docente;
import myComponents.FasciaOraria;
import myComponents.Orario;

public class XMLOrarioParserDOM{

	public static Orario getOrarioFromFileLight(String file) throws XMLStreamException, FileNotFoundException {
		Orario ret = null;
		try {
			
			File fXmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = null;
			ArrayList<Attività> elencoAt;
			
			// cerco l'attività in tutte le liste
			elencoAt = new ArrayList<Attività>(list);	

			nList = doc.getElementsByTagName("Assegnamento");
			ArrayList<Assegnamento> elencoAs = new ArrayList<Assegnamento>();
			for (int j = 0; j < nList.getLength(); j++) {

				Node nNode = nList.item(j);
						
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					Assegnamento ass = new Assegnamento(null, null, null);
					
					String attID = eElement.getElementsByTagName("IdAttività").item(0).getTextContent();
					
					Iterator<Attività> iAt = elencoAt.iterator();
					Attività a = null;
					while( iAt != null && iAt.hasNext() && (a == null || !a.getId().equals(attID) ) ) {
						a = iAt.next();
					}
					
					ass.setAttività(a);
					ass.setAula( new Aula(
									eElement.getElementsByTagName("Edificio").item(0).getTextContent() ,
									Integer.parseInt( eElement.getElementsByTagName("Numero").item(0).getTextContent() ) ,
									Integer.parseInt( eElement.getElementsByTagName("FasciaOraria").item(0).getTextContent() ) ) );

					// Fascia Oraria
					int foID = Integer.parseInt( eElement.getElementsByTagName("FasciaOraria").item(0).getTextContent() );					
					Iterator<FasciaOraria> iFo = null;	//TODO elenco fo
					FasciaOraria fo = null;
					while( iFo != null && iFo.hasNext() && (fo == null || !a.getId().equals(foID) ) ) {
						fo = iFo.next();
					}
					ass.setFasciaOraria(fo);
					
					//Aggiungi assegnamento
					elencoAs.add(ass);
				}
				
				
			}
			ret = new Orario(elencoAs , elencoAt);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
		return ret;
	}

	public static Boolean writeOrarioOnFileLight(String file, Orario o) {
		
		// error case
		if ( file == null || file == "" )
			file = "temp.xml";
		else if ( !file.endsWith(".xml") )
				file = file + ".xml";
		
		try {

			//setup document builder
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element e;
			
			// root elements
			Element rootElement = doc.createElement("orario");
			doc.appendChild(rootElement);
			
			//initialize
			ArrayList<Assegnamento> elencoAs = null;
			ArrayList<Attività> elencoAt = null;
			Iterator<Assegnamento> i = null;
			Iterator<Attività> j = null;
			
			// no object saving
			if ( o != null ) {
				elencoAs = o.getElencoAssegnamenti();
				elencoAt = o.getElencoAttività();
				i = elencoAs.iterator();
				j = elencoAt.iterator();
			}
			
			// ELENCO ATTIVITà SAVING
			
//			e = doc.createElement("ElencoAttività");
//			rootElement.appendChild(e);
//			while (j != null && j.hasNext()) {
//				
//				// attività element
//				Element a = doc.createElement("Attività");
//				e.appendChild(a);
//				Attività att = j.next();
//				
//				// saving attributes
//				a.appendChild(createElem(doc,"Id",att.getId()));
//				a.appendChild(createElem(doc,"Nome",att.getNome()));	
//				Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//				String dateInizio = formatter.format(att.getInizio());
//				String dateFine = formatter.format(att.getFine());
//				a.appendChild(createElem(doc,"Inizio",dateInizio));
//				a.appendChild(createElem(doc,"Fine",dateFine));
//				a.appendChild(createElem(doc,"Ore",""+att.getOre()));
//				a.appendChild(createElem(doc,"Semestre",""+att.getSemestre()));
//				a.appendChild(createElem(doc,"Descrizione",att.getDescrizione()));
//				
//				// saving professor list
//				Element rs = doc.createElement("Responsabili");
//				a.appendChild(rs);
//				ArrayList<Docente> elencoResponsabili = att.getElencoResponsabili();
//				Iterator<Docente> k = elencoResponsabili.iterator();
//				
//				while( k != null && k.hasNext() ) {
//					
//					Element resp = doc.createElement("Docente");
//					rs.appendChild(resp);
//					Docente d = k.next();
//					
//					resp.appendChild(createElem(doc,"Nome",d.getNome()));
//					resp.appendChild(createElem(doc,"Cognome",d.getCognome()));
//					resp.appendChild(createElem(doc,"Associato",""+d.isAssociato()));
//					resp.appendChild(createElem(doc,"Matricola",""+d.getMatricola()));
//					resp.appendChild(createElem(doc,"Email",""+d.getEmail()));
//					
//				}
//				
//	  		}
			
			// ELENCO ASSEGNAMENTO SAVING
			
			e = doc.createElement("ElencoAssegnamento");
			rootElement.appendChild(e);
			while ( i != null && i.hasNext()) {

				// assegnamento element
				Element a = doc.createElement("Assegnamento");
				e.appendChild(a);
				Assegnamento ass = i.next();
				
				a.appendChild(createElem(doc,"IdAttività",ass.getAttività().getId()));
				
				Element aula = doc.createElement("Aula");
				a.appendChild(aula);
				Aula aula_ = ass.getAula();
				aula.appendChild(createElem(doc,"Edificio",aula_.getEdificio()));
				aula.appendChild(createElem(doc,"Numero",""+aula_.getNumero()));
				aula.appendChild(createElem(doc,"Capienza",""+aula_.getCapienza()));
				
				a.appendChild(createElem(doc,"FasciaOraria",""+ass.getFasciaOraria().getIdFascia()));
	  		}
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(file));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved! Name: " + file );

		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }

		return null;
	}


	public static Orario getOrarioFromFileFull(String file) throws XMLStreamException, FileNotFoundException {
		Orario ret = null;
		try {
			
			File fXmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = null;
			ArrayList<Attività> elencoAt;
			
			elencoAt = null;	//TODO

			// NO ATTIVITA' SAVING
			
//			nList = doc.getElementsByTagName("Attività");
//			elencoAt = new ArrayList<Attività>();
//			for (int i = 0; i < nList.getLength(); i++) {
//
//				Node nNode = nList.item(i);
//				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//
//					Element eElement = (Element) nNode;
//					
//					Attività att = new Attività(0, "", "", "", new Date() , new Date() , 1);
//					
//					att.setId( eElement.getElementsByTagName("Id").item(0).getTextContent() );
//					att.setNome( eElement.getElementsByTagName("Nome").item(0).getTextContent() );
//					att.setInizioByString( eElement.getElementsByTagName("Inizio").item(0).getTextContent() );
//					att.setFineByString( eElement.getElementsByTagName("Fine").item(0).getTextContent() );
//					att.setOre( Integer.parseInt(eElement.getElementsByTagName("Ore").item(0).getTextContent() ) );
//					att.setSemestre( Integer.parseInt( eElement.getElementsByTagName("Semestre").item(0).getTextContent() ) );
//					att.setDescrizione( eElement.getElementsByTagName("Descrizione").item(0).getTextContent() );
//					
//					ArrayList<Docente> elresp = new ArrayList<Docente>();
//					NodeList resp = eElement.getElementsByTagName("Docente");
//					for (int j = 0; resp != null && j < resp.getLength(); j++) {
//
//						Node docenteNod = resp.item(j);
//						if (docenteNod.getNodeType() == Node.ELEMENT_NODE) {
//							Element docenteEl = (Element) docenteNod ;
//							Docente d = new Docente();
//							
//							d.setNome( docenteEl.getElementsByTagName("Nome").item(0).getTextContent() );
//							d.setCognome( docenteEl.getElementsByTagName("Cognome").item(0).getTextContent());
//							d.setAssociato( docenteEl.getElementsByTagName("Associato").item(0).getTextContent().equals("true") );
//							d.setMatricola( docenteEl.getElementsByTagName("Matricola").item(0).getTextContent());
//							d.setEmail( docenteEl.getElementsByTagName("Email").item(0).getTextContent());
//							
//							elresp.add(d);
//						}
//					}
//					att.setElencoResponsabili(elresp);
//					elencoAt.add(att);
//				}
//			}
			
			
			nList = doc.getElementsByTagName("Assegnamento");
			ArrayList<Assegnamento> elencoAs = new ArrayList<Assegnamento>();
			for (int j = 0; j < nList.getLength(); j++) {

				Node nNode = nList.item(j);
						
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					Assegnamento ass = new Assegnamento(null, null, null);
					
					//TODO
					String attID = eElement.getElementsByTagName("IdAttività").item(0).getTextContent();
					
					Iterator<Attività> iAt = elencoAt.iterator();
					Attività a = null;
					while( iAt != null && iAt.hasNext() && (a == null || !a.getId().equals(attID) ) ) {
						a = iAt.next();
					}
					
					ass.setAttività(a);
					ass.setAula( new Aula(
									eElement.getElementsByTagName("Edificio").item(0).getTextContent() ,
									Integer.parseInt( eElement.getElementsByTagName("Numero").item(0).getTextContent() ) ,
									Integer.parseInt( eElement.getElementsByTagName("FasciaOraria").item(0).getTextContent() ) ) );

					// Fascia Oraria
					//TODO
					int foID = Integer.parseInt( eElement.getElementsByTagName("FasciaOraria").item(0).getTextContent() );					
					Iterator<FasciaOraria> iFo = null;	//TODO elenco fo
					FasciaOraria fo = null;
					while( iFo != null && iFo.hasNext() && (fo == null || !a.getId().equals(foID) ) ) {
						fo = iFo.next();
					}
					ass.setFasciaOraria(fo);
					
					//Aggiungi assegnamento
					elencoAs.add(ass);
				}
				
				
			}
			ret = new Orario(elencoAs , elencoAt);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
		return ret;
	}

	public static Boolean writeOrarioOnFileFull(String file, Orario o) {
		
		// error case
		if ( file == null || file == "" )
			file = "temp.xml";
		else if ( !file.endsWith(".xml") )
				file = file + ".xml";
		
		try {

			//setup document builder
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element e;
			
			// root elements
			Element rootElement = doc.createElement("orario");
			doc.appendChild(rootElement);
			
			//initialize
			ArrayList<Assegnamento> elencoAs = null;
			ArrayList<Attività> elencoAt = null;
			Iterator<Assegnamento> i = null;
			Iterator<Attività> j = null;
			
			// no object saving
			if ( o != null ) {
				elencoAs = o.getElencoAssegnamenti();
				elencoAt = o.getElencoAttività();
				i = elencoAs.iterator();
				j = elencoAt.iterator();
			}
			
			// ELENCO ATTIVITà SAVING
			
//			e = doc.createElement("ElencoAttività");
//			rootElement.appendChild(e);
//			while (j != null && j.hasNext()) {
//				
//				// attività element
//				Element a = doc.createElement("Attività");
//				e.appendChild(a);
//				Attività att = j.next();
//				
//				// saving attributes
//				a.appendChild(createElem(doc,"Id",att.getId()));
//				a.appendChild(createElem(doc,"Nome",att.getNome()));	
//				Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//				String dateInizio = formatter.format(att.getInizio());
//				String dateFine = formatter.format(att.getFine());
//				a.appendChild(createElem(doc,"Inizio",dateInizio));
//				a.appendChild(createElem(doc,"Fine",dateFine));
//				a.appendChild(createElem(doc,"Ore",""+att.getOre()));
//				a.appendChild(createElem(doc,"Semestre",""+att.getSemestre()));
//				a.appendChild(createElem(doc,"Descrizione",att.getDescrizione()));
//				
//				// saving professor list
//				Element rs = doc.createElement("Responsabili");
//				a.appendChild(rs);
//				ArrayList<Docente> elencoResponsabili = att.getElencoResponsabili();
//				Iterator<Docente> k = elencoResponsabili.iterator();
//				
//				while( k != null && k.hasNext() ) {
//					
//					Element resp = doc.createElement("Docente");
//					rs.appendChild(resp);
//					Docente d = k.next();
//					
//					resp.appendChild(createElem(doc,"Nome",d.getNome()));
//					resp.appendChild(createElem(doc,"Cognome",d.getCognome()));
//					resp.appendChild(createElem(doc,"Associato",""+d.isAssociato()));
//					resp.appendChild(createElem(doc,"Matricola",""+d.getMatricola()));
//					resp.appendChild(createElem(doc,"Email",""+d.getEmail()));
//					
//				}
//				
//	  		}
			
			// ELENCO ASSEGNAMENTO SAVING
			
			e = doc.createElement("ElencoAssegnamento");
			rootElement.appendChild(e);
			while ( i != null && i.hasNext()) {

				// assegnamento element
				Element a = doc.createElement("Assegnamento");
				e.appendChild(a);
				Assegnamento ass = i.next();
				
				a.appendChild(createElem(doc,"IdAttività",ass.getAttività().getId()));
				
				Element aula = doc.createElement("Aula");
				a.appendChild(aula);
				Aula aula_ = ass.getAula();
				aula.appendChild(createElem(doc,"Edificio",aula_.getEdificio()));
				aula.appendChild(createElem(doc,"Numero",""+aula_.getNumero()));
				aula.appendChild(createElem(doc,"Capienza",""+aula_.getCapienza()));
				
				a.appendChild(createElem(doc,"FasciaOraria",""+ass.getFasciaOraria().getIdFascia()));
	  		}
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(file));

			transformer.transform(source, result);

			System.out.println("File saved! Name: " + file );

		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }

		return null;
	}
	
	private static Element createElem( Document doc , String nome , String value ) {
		Element id = doc.createElement(nome);
		id.appendChild(doc.createTextNode(value));
		return id;
	}
	
	
	public Attività findAttività(String id) {

		int i,n;
		Attività a = null;
		Attività temp = new Attività();
		
		//Convegno
		listConvegno.lastIndexOf()
		
		
		if ( a != null )
			return a;
		
		//Disciplina
		i = 0;
		n = listDisciplina.size();
		while( i < n && a == null ) {
			Attività temp = listDisciplina.get(i);
			if ( id.equals(temp.getId()))
				a = temp;
			else
				i ++;
		}
		if ( a != null )
			return a;
		
		//Esame
		i = 0;
		n = listEsame.size();
		while( i < n && a == null ) {
			Attività temp = listEsame.get(i);
			if ( id.equals(temp.getId()))
				a = temp;
			else
				i ++;
		}
		if ( a != null )
			return a;
		
		//Gita
		i = 0;
		n = listConvegno.size();
		while( i < n && a == null ) {
			Attività temp = listConvegno.get(i);
			if ( id.equals(temp.getId()))
				a = temp;
			else
				i ++;
		}
		if ( a != null )
			return a;
		
		//Tirocinio
		i = 0;
		n = listConvegno.size();
		while( i < n && a == null ) {
			Attività temp = listConvegno.get(i);
			if ( id.equals(temp.getId()))
				a = temp;
			else
				i ++;
		}
		if ( a != null )
			return a;
		
	}

}
