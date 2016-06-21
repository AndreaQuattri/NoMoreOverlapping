package controllerListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.xml.stream.XMLStreamException;

import connectToDatabase.MyFileFilter;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import mvc.Model;
import xmlParser.XMLOrarioParserDOM;

public class CaricaOrarioDaFile extends JPanel implements ActionListener{


	Model model;

	public CaricaOrarioDaFile( Model model ) {
		this.model = model;
	}


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

			String file = inputFile.getName();
			System.out.println(file);




			/*
			try {
				model.setOrarioUfficiale( XMLOrarioParserDOM.getOrarioFromFileFull(file) );


				for (int i=0; i<model.getOrarioUfficiale().getElencoAssegnamenti().size(); i++)
					System.out.println(model.getOrarioUfficiale().getElencoAssegnamenti().get(i).getAttività().toString());

				model.fromOrarioToTable();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (XMLStreamException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		String file = "provaorario.xml";
		System.out.println("Pressed button carica");

			 */
			try {
				model.setOrarioUfficiale( XMLOrarioParserDOM.getOrarioFromFileFull(model,file) );


				for (int i=0; i<model.getOrarioUfficiale().getElencoAssegnamenti().size(); i++)
					System.out.println(model.getOrarioUfficiale().getElencoAssegnamenti().get(i).getAttività().toString());

				model.fromOrarioToTable();

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
