package mvc;

import controllerListener.*;;



public class Controller2
{

	private Model model;
	private MainView view;
	private ViewTimeTable viewOrario;
	

	public Controller2(Model model, MainView view, ViewTimeTable viewOrario)
	{
		this.setModel(model);
		this.setView(view);
		this.setViewOrario(viewOrario);

		// Set all the listener of the view
		view.selectedTableToView(new SelectedTableListener(model));
		view.pressButtonAcquisisci(new InsertInTableListener(view));
		view.pressButtonModifica(new UpdateRecordListener((String)view.getComboBoxTable().getSelectedItem()));
		view.pressButtonGestisciOrario(new OpenViewGestisciOrario(model,viewOrario));
		viewOrario.pressButtonNewOrario2(new CreateNewOrario(model,viewOrario));
		viewOrario.pressButtonCarica(new CaricaOrarioDaFile());
		viewOrario.pressButtonSalva(new SalvaOrarioEsistente());
		viewOrario.pressButtonEsci(new EsciViewTimeTable(viewOrario));

		viewOrario.selectedActivityToView(new SelectedActivityListener(model, viewOrario));
		viewOrario.selectedPianoToView(new SelectedPianoListener(model, viewOrario));
		viewOrario.selectedDocenteToView(new SelectedDocenteListener(model, viewOrario));

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
