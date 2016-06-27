/*
 * 
 */
package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

import mvc.Model;
import xmlParser.XMLOrarioParserDOM;

// TODO: Auto-generated Javadoc
/**
 * The Class SalvaOrarioEsistente.
 */
public class SalvaOrarioEsistente implements ActionListener{

	/** The model. */
	Model model;

	/**
	 * Instantiates a new salva orario esistente.
	 *
	 * @param model the model
	 */
	public SalvaOrarioEsistente( Model model ) {
		this.model = model;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		JFileChooser fs = new JFileChooser(new File("c:\\"));
		fs.setDialogTitle("Save a File");
		fs.showSaveDialog(fs);
		
		
		


		// TODO Auto-generated method stub
		String file = fs.getSelectedFile().getPath();
		System.out.println(file);
		

	

		
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
