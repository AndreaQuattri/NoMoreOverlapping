/*
 * 
 */
package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.xml.stream.XMLStreamException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import mvc.Model;
import mvc.ViewTimeTable;
import xmlParser.XMLOrarioParserDOM;

// TODO: Auto-generated Javadoc
/**
 * The Class CaricaOrarioDaFile.
 */
public class CaricaOrarioDaFile extends JPanel implements ActionListener{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The model. */
	Model model;
	
	/** The view orario. */
	ViewTimeTable viewOrario;

	/**
	 * Instantiates a new carica orario da file.
	 *
	 * @param model the model
	 * @param viewOrario the view orario
	 */
	public CaricaOrarioDaFile( Model model, ViewTimeTable viewOrario ) {
		this.model = model;
		this.viewOrario = viewOrario;
	}


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select a Time Table");
		fileChooser.setApproveButtonText("Open");
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setFileFilter(new MyFileFilter());


		int n = fileChooser.showOpenDialog(CaricaOrarioDaFile.this);

		if (n == JFileChooser.APPROVE_OPTION)
		{

			File inputFile = fileChooser.getSelectedFile();

			String file = inputFile.getPath();
			System.out.println(file);




			try {
				model.setOrarioUfficiale( XMLOrarioParserDOM.getOrarioFromFileFull(model,file) );


				for (int i=0; i<model.getOrarioUfficiale().getElencoAssegnamenti().size(); i++)
					System.out.println(model.getOrarioUfficiale().getElencoAssegnamenti().get(i).getAttività().toString());

				model.setTabella(new Vector<Vector<String>>());
				model.fromOrarioUfficialeToTable();
				viewOrario.visualizzaOrario();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (XMLStreamException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DOMException e1) {
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
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}
