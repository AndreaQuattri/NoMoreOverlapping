package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import mvc.Model;
import xmlParser.XMLOrarioParserDOM;

public class SalvaOrarioEsistente implements ActionListener{

	Model model;
	
	public SalvaOrarioEsistente( Model model ) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String file = "provaorario.xml";
		
		for (int i=0; i<model.getOrarioUfficiale().getElencoAssegnamenti().size(); i++)
			System.out.println(model.getOrarioUfficiale().getElencoAssegnamenti().get(i).getFasciaOraria().toString() +"\n"+
								model.getOrarioUfficiale().getElencoAssegnamenti().get(i).getAttività().toString());

		
		try {
			XMLOrarioParserDOM.writeOrarioOnFileFull( file , this.model.getOrarioUfficiale() );
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
