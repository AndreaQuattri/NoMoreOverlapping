package mvc;

public class Launcher
{

	public static void main(String[] args)
	{
		
				Model model = new Model();
				
				MainView view = new MainView(model);
				ViewOrario viewOrario = new ViewOrario(model);
				
				@SuppressWarnings("unused")
				Controller controller = new Controller(model, view, viewOrario);
				
				view.getFrame().setVisible(true);
			
	}

}
