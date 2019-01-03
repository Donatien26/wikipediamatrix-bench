package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Metier.Page;
import Outils.CsvFileWriter;
import Outils.Internet;
import Outils.lectureTXT;
public class mvnTest {




	public static void main(String[] args) throws Exception 
	{	
		 
		File charger = new File("inputdata" + File.separator + "wikiurls.txt");
		
		lectureTXT wikitext=new lectureTXT();
		wikitext.charger(charger);
		
		String destination = "output" + File.separator + "html" + File.separator;
		for (int i=0 ; i< wikitext.getLienPage().size(); i++) 
		{
			System.out.println("extraction de la page "+wikitext.getLienPage().get(i).asString());
			if (wikitext.getLienPage().get(i).estValide()) 
			{
				Internet recherche = new Internet();
				CsvFileWriter csv=new CsvFileWriter();
				Page page;
				page=recherche.RecupererTableauUrl(wikitext.getLienPage().get(i).asString());

				if (page.valider()) 
				{
					csv.writeCsvFile(destination+wikitext.getNomCSV().get(i),page);
				}
			}
		}		 


	}


}
