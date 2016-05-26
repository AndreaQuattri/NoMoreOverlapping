package mvc;

public class Launcher
{

	public static void main(String[] args)
	{
		
				Model model = new Model();

				MainView view = new MainView(model);
				ViewTimeTable viewOrario = new ViewTimeTable(model);

				@SuppressWarnings("unused")
				Controller2 controller = new Controller2(model, view, viewOrario);

				view.getFrame().setVisible(true);

	}

}
