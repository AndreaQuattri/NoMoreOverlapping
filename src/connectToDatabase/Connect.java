package connectToDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class Connect {
	
	
	public static String connectDb(String tabella) throws IOException, URISyntaxException{
		
		URL yahoo = new URL(tabella);
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine, toReturn = "";


        while ((inputLine = in.readLine()) != null) 
        {
        	toReturn = inputLine;
        }
        
        in.close();
                
        return toReturn;
		
		
	}

}
