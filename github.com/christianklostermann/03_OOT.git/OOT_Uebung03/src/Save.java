
import java.io.*;
import java.util.Date;
import java.beans.*;

/**
 * to save and load the map-object
 * the whole object will be stored
 * @author 
 *
 */

public class Save {
	String filename = null;

	public void saveMap(String filename,String[][] map) {

		this.filename = filename;

		XMLEncoder enc = null;

		try {
			enc = new XMLEncoder(new FileOutputStream(filename));
			enc.writeObject(map);		
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (enc != null)
				enc.close();
		}
	}

	public String[][] loadMap() {

		if (filename != null) {

			// Deserialisieren

			XMLDecoder dec = null;

			try {
				dec = new XMLDecoder(new FileInputStream(filename));

			
				String[][] map = (String[][]) dec.readObject();
				
			
				
				return map;
			

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (dec != null)
					dec.close();
			}
		}
		
		return null;

	}

}