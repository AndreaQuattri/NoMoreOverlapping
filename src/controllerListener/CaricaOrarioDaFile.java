package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLStreamException;
import mvc.Model;
import xmlParser.XMLOrarioParserDOM;

public class CaricaOrarioDaFile implements ActionListener{


	Model model;
	
	public CaricaOrarioDaFile( Model model ) {
		this.model = model;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String file = "provaorario.xml";
		System.out.println("Pressed button carica");
		try {
			model.setOrarioUfficiale( XMLOrarioParserDOM.getOrarioFromFile(file) );
			//model.fromOrarioToTable();
			
			for (int i=0; i<model.getOrarioUfficiale().getElencoAssegnamenti().size(); i++)
				System.out.println(model.getOrarioUfficiale().getElencoAssegnamenti().get(i).getFasciaOraria().toString() +"\n"+
									model.getOrarioUfficiale().getElencoAssegnamenti().get(i).getAttività().toString());

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (XMLStreamException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
