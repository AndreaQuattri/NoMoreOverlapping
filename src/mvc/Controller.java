/*
 * 
 */
package mvc;

import controller_listener.*;
import pdfPrinter.PdfPrinter;;



// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller
{

	/** The model. */
	private Model model;
	
	/** The view. */
	private MainView view;
	
	/** The view orario. */
	private ViewTimeTable viewOrario;
	

	/**
	 * Instantiates a new controller.
	 *
	 * @param model the model
	 * @param view the view
	 * @param viewOrario the view orario
	 */
	public Controller(Model model, MainView view, ViewTimeTable viewOrario)
	{
		this.model = model;
		this.view = view;
		this.viewOrario = viewOrario;

		// Set all the listener of the view
		view.selectedTableToView(new SelectedTableListener(model));
		view.pressButtonAcquisisci(new InsertInTableListener(view, model));
		view.pressButtonModifica(new UpdateRecordListener(view));
		view.pressButtonInserisci(new InsertRecordListener(view));
		view.pressButtonGestisciOrario(new OpenViewGestisciOrario(model,viewOrario));
		view.pressButtonElimina(new DeleteRecordListener(view));
		
		viewOrario.pressButtonNewOrario2(new CreateNewOrario(model,viewOrario));
		viewOrario.pressButtonCarica(new CaricaOrarioDaFile(model, viewOrario));
		viewOrario.pressButtonSalva(new SalvaOrarioEsistente(model));
		viewOrario.pressButtonEsci(new EsciViewTimeTable(viewOrario));
		viewOrario.pressEsportaPdf(new SalvaPdfOrario(model));

	}


	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}


	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(Model model) {
		this.model = model;
	}


	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public MainView getView() {
		return view;
	}


	/**
	 * Sets the view.
	 *
	 * @param view the new view
	 */
	public void setView(MainView view) {
		this.view = view;
	}


	/**
	 * Gets the view orario.
	 *
	 * @return the view orario
	 */
	public ViewTimeTable getViewOrario() {
		return viewOrario;
	}


	/**
	 * Sets the view orario.
	 *
	 * @param viewOrario the new view orario
	 */
	public void setViewOrario(ViewTimeTable viewOrario) {
		this.viewOrario = viewOrario;
	}

}
