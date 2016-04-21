package mvc;

public class MyNotify {
	
	public final static int ENABLE_BUTTON_MODIFICA = 0;
	public final static int ENABLE_BUTTON_ELIMINA    = 1;
	public final static int ENABLE_BUTTON_ACQUISISCI = 2;
	public final static int ENABLE_BUTTON_AGGIORNA   = 3;
	public final static int ENABLE_INSERT_VALUES 	   = 4;
	public final static int SEMANTIC_ERRORS    = 5;
	public final static int GENERIC_ERROR 	   = 6;
	public final static int FILE_ERROR 	   	   = 7;

	private int notifyID;

	public MyNotify(int notifyID)
	{
		this.notifyID = notifyID;
	}

	public int getNotifyID()
	{
		return notifyID;
	}
	
	
}
