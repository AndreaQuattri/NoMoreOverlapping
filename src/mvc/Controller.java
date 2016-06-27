package mvc;

import controllerListener.*;
import pdfPrinter.PdfPrinter;;



public class Controller
{

	private Model model;
	private MainView view;
	private ViewTimeTable viewOrario;
	

	public Controller(Model model, MainView view, ViewTimeTable viewOrario)
	{
		this.setModel(model);
		this.setView(view);
		this.setViewOrario(viewOrario);

		// Set all the listener of the view
		view.selectedTableToView(new SelectedTableListener(model));
		view.pressButtonAcquisisci(new InsertInTableListener(view));
		view.pressButtonModifica(new UpdateRecordListener(view));
		view.pressButtonInserisci(new InsertRecordListener(view));
		view.pressButtonGestisciOrario(new OpenViewGestisciOrario(model,viewOrario));
		
		viewOrario.pressButtonNewOrario2(new CreateNewOrario(model,viewOrario));
		viewOrario.pressButtonCarica(new CaricaOrarioDaFile(model, viewOrario));
		viewOrario.pressButtonSalva(new SalvaOrarioEsistente(model));
		viewOrario.pressButtonEsci(new EsciViewTimeTable(viewOrario));
		viewOrario.pressEsportaPdf(new PdfPrinter(model));
		//viewOrario.selectedActivityToView(new SelectedActivityListener(model, viewOrario));
		//viewOrario.selectedPianoToView(new SelectedPianoListener(model, viewOrario));
		//viewOrario.selectedDocenteToView(new SelectedDocenteListener(model, viewOrario));
		

		//view.addCompileListener(new MyCompileListener());
		//view.addMakeLaTeXlistener(new MyMakeLaTeXlistener());
	}


	public Model getModel() {
		return model;
	}


	public void setModel(Model model) {
		this.model = model;
	}


	public MainView getView() {
		return view;
	}


	public void setView(MainView view) {
		this.view = view;
	}


	public ViewTimeTable getViewOrario() {
		return viewOrario;
	}


	public void setViewOrario(ViewTimeTable viewOrario) {
		this.viewOrario = viewOrario;
	}

}
