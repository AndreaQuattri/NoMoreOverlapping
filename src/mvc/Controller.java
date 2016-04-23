package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import ElaborazioneDati.InsertInTable;
import memorizzazioneDati.InsertValues;



public class Controller
{

	private Model model;
	private MainView view;

	public Controller(Model model, MainView view)
	{
		this.model = model;
		this.view = view;

		// Set all the listener of the view
		view.selectedTableToView(new SelectedTableListener());
		view.pressButtonAcquisisci(new InsertInTableListener());
		view.pressButtonGestisciOrario(new OpenViewGestisciOrario());
		//view.addLoadFromFileListener(new MyLoadFromFileListener());
		//view.addDocumentListener(new MyDocumentListener());
		//view.addCompileListener(new MyCompileListener());
		//view.addMakeLaTeXlistener(new MyMakeLaTeXlistener());
	}
	
	
	private class SelectedTableListener implements  ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{
			//InfoView infoView = new InfoView();
			//infoView.getFrame().setVisible(true);
			model.enableModificaTable(true);
			model.enableEliminaTable(true);
			model.enableButtonAcquisisci(true);
			model.enableButtonAggiorna(true);
			
			//TODO
			/*
			 * 
			 * cancellare tabella, ecc..
			 * 
			 */
			

		}
	}
	
	private class InsertInTableListener implements  ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{
			
			view.getLabelTableInTable().setText((String)view.getComboBoxTable().getSelectedItem());
			
			InsertInTable insertInTable = new InsertInTable(view.getComboBoxTable().getSelectedItem());
			try {
				String toView[][] = insertInTable.getValues();
				String toInsertComboBox = "";
				for (int i=0; i<toView[0].length; i++){
					view.getTableRecords().addColumn(toView[0][i]);
				}
				
								
				for (int i=1; i<toView.length; i++){
						view.getTableRecords().addRow(toView[i]);
						for(int j=0; j<toView[i].length-1; j++)
							toInsertComboBox+=toView[i][j]+", ";
						toInsertComboBox+=toView[i][toView[i].length-1];
						view.getComboBoxRecord().addItem(toInsertComboBox);
						toInsertComboBox = "";
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	
	private class OpenViewGestisciOrario implements  ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{
			InsertValues insert = new InsertValues(model);
			

			
			try {
				insert.getValueAula();
				insert.getValueDocente();
				insert.getValueCorsoDiStudi();
				insert.getValueStudente();
				
				
				
				for (int i=0; i<model.getListAula().size(); i++)
					System.out.println(model.getListAula().get(i).toString());
				
				System.out.println();
				
				for (int i=0; i<model.getListStudente().size(); i++)
					System.out.println(model.getListStudente().get(i).toString());
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	private class MyLoadFromFileListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{
			// Load from file with JFileChooser
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Select a Petri Net");
			fileChooser.setApproveButtonText("Open");
			fileChooser.setCurrentDirectory(new java.io.File("."));
			fileChooser.setFileFilter(new MyFileFilter());

			int n = fileChooser.showOpenDialog(view);

			if (n == JFileChooser.APPROVE_OPTION)
			{
				view.clearUserInput();

				File inputFile = fileChooser.getSelectedFile();
				try
				{
					BufferedReader brd = new BufferedReader(new FileReader(inputFile));

					String line ;
					while ((line = brd.readLine()) != null)
					{
						view.appendUserInput(line + "\n");
					}
					brd.close();
				}
				catch (IOException e)
				{
					// Show an error dialog
					JOptionPane.showMessageDialog(view, "ERROR: can't open the selected file");
				}
			}

			model.enableCompile(true);
			model.enableMakePDF(false);
		}

		// Private classe for filter only *.txt files
		private class MyFileFilter extends FileFilter
		{

			public boolean accept(File file)
			{
				if (file.isDirectory())
					return true;

				String fname = file.getName().toLowerCase();
				return fname.endsWith("txt");
			}

			public String getDescription()
			{
				return "*.txt";
			}
		}

	}

	private class MyDocumentListener implements DocumentListener
	{

		@Override
		public void changedUpdate(DocumentEvent e)
		{

		}

		@Override
		public void insertUpdate(DocumentEvent e)
		{
			// Enable only Compile
			model.enableCompile(true);
			model.enableMakePDF(false);
		}

		@Override
		public void removeUpdate(DocumentEvent e)
		{
			// Enable only Compile
			model.enableCompile(true);
			model.enableMakePDF(false);
		}

	}

	private class MyCompileListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{
			// Update the model like the view (user input) 
			model.setUserInput(view.getUserInput());
			model.enableCompile(false);
			model.enableMakePDF(false);

			// Run the compiler thread
			CompilerThread compiler = new CompilerThread(model);
			new Thread(compiler).start();
		}
	}

	private class MyMakeLaTeXlistener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent action)
		{
			LaTeXConverter converter = new LaTeXConverter(model);

			// Get Latex code from Petri Net
			String outputString = converter.makeLatexCode();
			String compilerOutput = "";

			try
			{
				// Write Latex code to file "PetriNet.tex"
				BufferedWriter bwr = new BufferedWriter(new FileWriter(".\\PetriNet.tex"));
				bwr.write(outputString);
				bwr.flush();
				bwr.close();

				// Test if "PetriNet.tex" exist
				File texFile = new File(".\\PetriNet.tex");
				if (texFile.exists())
				{
					compilerOutput = "Petri Net Diagram Generator 1.0 - "
							+ new SimpleDateFormat("MM-dd-yyy HH:mm:ss").format(Calendar.getInstance().getTime()) + ".\n"
							+ "GENERATE LaTeX SUCCESSFULL > 'PetriNet.tex'";

					model.setCompilerOutput(MyNotify.LATEX_SUCCESFULL, compilerOutput);

					// Open "PetriNet.tex" to start LaTeX compiler
					Desktop desktop = Desktop.getDesktop();
					desktop.open(texFile);
				}
				else
				{
					compilerOutput = "Petri Net Diagram Generator 1.0 - "
							+ new SimpleDateFormat("MM-dd-yyy HH:mm:ss").format(Calendar.getInstance().getTime()) + ".\n"
							+ "CAN'T GENERATE THE LaTeX FILE > 'PetriNet.tex'";

					model.setCompilerOutput(MyNotify.FILE_ERROR, compilerOutput);
				}

			}
			catch (RuntimeException e1)
			{
				e1.printStackTrace();

				// Converts StackTrace to String
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e1.printStackTrace(pw);

				// Update the model
				model.setCompilerOutput(MyNotify.FILE_ERROR, sw.toString());
			}

			catch (IOException e2)
			{
				e2.printStackTrace();

				// Converts StackTrace to String
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e2.printStackTrace(pw);

				// Update the model
				model.setCompilerOutput(MyNotify.GENERIC_ERROR, sw.toString());
			}
		}
	}
	*/

}
