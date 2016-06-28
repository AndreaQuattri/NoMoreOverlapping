/*
 * 
 */
package mvc;

// TODO: Auto-generated Javadoc
/**
 * The Class MyNotify.
 */
public class MyNotify {
	
	/** The Constant ENABLE_BUTTON_MODIFICA. */
	public final static int ENABLE_BUTTON_MODIFICA = 0;
	
	/** The Constant ENABLE_BUTTON_ELIMINA. */
	public final static int ENABLE_BUTTON_ELIMINA = 1;
	
	/** The Constant ENABLE_BUTTON_ACQUISISCI. */
	public final static int ENABLE_BUTTON_ACQUISISCI = 2;
	
	/** The Constant ENABLE_BUTTON_AGGIORNA. */
	public final static int ENABLE_BUTTON_AGGIORNA = 3;
	
	/** The Constant ENABLE_INSERT_VALUES. */
	public final static int ENABLE_INSERT_VALUES = 4;
	
	/** The Constant ENABLE_BUTTON_GITA. */
	public final static int ENABLE_BUTTON_GITA = 5;
	
	/** The Constant GENERIC_ERROR. */
	public final static int ENABLE_BUTTON_CARICA = 6;
	
	/** The Constant FILE_ERROR. */
	public final static int ENABLE_BUTTON_INSERISCI = 7;

	/** The notify id. */
	private int notifyID;

	/**
	 * Instantiates a new my notify.
	 *
	 * @param notifyID the notify id
	 */
	public MyNotify(int notifyID)
	{
		this.notifyID = notifyID;
	}

	/**
	 * Gets the notify id.
	 *
	 * @return the notify id
	 */
	public int getNotifyID()
	{
		return notifyID;
	}
	
	
}
