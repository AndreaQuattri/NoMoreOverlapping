package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import mvc.Model;
import myComponents.Orario;
import xmlParser.XMLOrarioParserDOM;

public class CaricaOrarioDaFile implements ActionListener{


	Model m;
	
	public CaricaOrarioDaFile( Model m ) {
		this.m = m;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String file = "provaorario.xml";
		System.out.println("Pressed button carica");
		try {
			m.setOrarioUfficiale( XMLOrarioParserDOM.getOrarioFromFile(file) );
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (XMLStreamException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
