package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import myComponents.Orario;
import xmlParser.XMLOrarioParserDOM;

public class SalvaOrarioEsistente implements ActionListener{

	Orario o;
	
	public SalvaOrarioEsistente( Orario o ) {
		this.o = o;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String file = "provaorario.xml";
		XMLOrarioParserDOM.writeOrarioOnFile( file , this.o );
	}

}
