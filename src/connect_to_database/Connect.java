/*
 * 
 */
package connect_to_database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

// TODO: Auto-generated Javadoc
/**
 * The Class Connect.
 */
public class Connect {
	
	
	/**
	 * Connect db.
	 *
	 * @param tabella the tabella
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws URISyntaxException the URI syntax exception
	 */
	public static String connectDb(final String tabella) throws IOException, URISyntaxException{
		
		final URL yahoo = new URL(tabella);
        final URLConnection yconn = yahoo.openConnection();
        final BufferedReader inRead = new BufferedReader(
                                new InputStreamReader(
                                yconn.getInputStream()));
        String inputLine;
        String toReturn = "";


        while ((inputLine = inRead.readLine()) != null) 
        {
        	toReturn = inputLine;
        }
        
        inRead.close();
                
        return toReturn;
		
		
	}

}
