package Validator;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
/**
 * Classe permettant de verifier la validité des Urls donner
 * @author Donatien
 *
 */
public class ValiderUrl extends Validator{
	URL url;

	public ValiderUrl() {
		// TODO Auto-generated constructor stub
	}


	public Boolean estValide() {
		URL uneURL=null;
		int ch;
		boolean bool = false;
		try {
			uneURL = new URL(url.toString());
			HttpURLConnection connexion = (HttpURLConnection)uneURL.openConnection();
			if (connexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
				bool=true;
			}
			connexion.disconnect();
		} 
		catch(Exception e) {
		}
		return bool;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
	public String asString() {
		return url.toString();
	}

}
