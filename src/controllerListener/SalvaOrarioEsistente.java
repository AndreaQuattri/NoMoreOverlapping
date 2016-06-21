package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import mvc.Model;
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

<<<<<<< HEAD

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

		//XMLOrarioParserDOM.writeOrarioOnFileFull( chooser.getSelectedFile().getName() , this.model.getOrarioUfficiale() );



		
		try {
			//XMLOrarioParserDOM.writeOrarioOnFileFull( file , this.model.getOrarioUfficiale() );
			XMLOrarioParserDOM.writeOrarioOnFileFull( chooser.getSelectedFile().getName() , this.model.getOrarioUfficiale() );

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
