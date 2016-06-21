package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

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

		/*

		// TODO Auto-generated method stub
		String file = "provaorario.xml";

		for (int i=0; i<model.getOrarioUfficiale().getElencoAssegnamenti().size(); i++)
			System.out.println(model.getOrarioUfficiale().getElencoAssegnamenti().get(i).getFasciaOraria().toString() +"\n"+
								model.getOrarioUfficiale().getElencoAssegnamenti().get(i).getAttività().toString());


		XMLOrarioParserDOM.writeOrarioOnFileFull( file , this.model.getOrarioUfficiale() );

		 */
		//JFileChooser chooser = new JFileChooser();
		//int s = chooser.showSaveDialog(new JFrame());


		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				".xml", "xml", "gif");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new java.io.File("."));

		int returnVal = chooser.showSaveDialog(new JFrame());
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " +
					chooser.getSelectedFile().getName());
			
		}

		XMLOrarioParserDOM.writeOrarioOnFileFull( chooser.getSelectedFile().getName() , this.model.getOrarioUfficiale() );



	}

}
