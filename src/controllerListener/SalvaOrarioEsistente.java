package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.Model;
import myComponents.Orario;
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

		
		XMLOrarioParserDOM.writeOrarioOnFile( file , this.model.getOrarioUfficiale() );
	}

}
