package Outils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

import Validator.ValiderUrl;
/**
 * Permet de lire les fichiers txt
 * @author Donatien
 *
 */
public class lectureTXT {
	private ArrayList<ValiderUrl> lienPage =new ArrayList<ValiderUrl>();
	private ArrayList<String>nomCSV= new ArrayList<String>();

	public lectureTXT() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Charge les urls present dans le fichier wikitext
	 * @param file
	 * @throws Exception
	 */
	public void charger(File file) throws Exception {


		BufferedReader br = new BufferedReader(new FileReader(file));
		String url;
		String BASE_WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/";

		while ((url = br.readLine()) != null) {
		    URL wurl = new URL(BASE_WIKIPEDIA_URL + url); 
			ValiderUrl url1 =new ValiderUrl();
			url1.setUrl(wurl);
			String nom = mkCSVFileName(url);
			lienPage.add(url1);
			nomCSV.add(nom);
       
		}


	}
	
	private String mkCSVFileName(String url) {
		return url.trim() ;
	}

	public ArrayList<ValiderUrl> getLienPage() {
		return lienPage;
	}

	public void setLienPage(ArrayList<ValiderUrl> lienPage) {
		this.lienPage = lienPage;
	}

	public ArrayList<String> getNomCSV() {
		return nomCSV;
	}

	public void setNomCSV(ArrayList<String> nomCSV) {
		this.nomCSV = nomCSV;
	}

	@Override
	public String toString() {
		return "lectureTXT [lienPage=" + lienPage + ", nomCSV=" + nomCSV + "]";
	}


}
