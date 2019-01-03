package test;
import static org.junit.Assert.assertEquals;

import java.io.*;

import org.junit.Test;

import Metier.Page;
import Outils.CsvFileWriter;
import Outils.Internet;
import Outils.lectureTXT;
import org.junit.Test;

/**
 * On verifie si notre ecriveur csv est performant et si on extrait bien les tableau d'internet
 * @author Donatien
 *
 */
public class CsvFileWriterTest {


	@Test
	public void TestExportLigne() throws Exception
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

				for (int j=1; j<page.getPage().size()+1;j++) {
					int count = 0;
					FileInputStream fis = new FileInputStream(destination+wikitext.getNomCSV().get(i)+ "-" + j+ ".csv");
					LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));

					while (l.readLine()!=null)
					{
						count = l.getLineNumber();

					}
					int nb=page.getPage().get(j-1).getBody().getCoeur().size()+1;
					if (nb!=count) 
					{
						System.out.println("Le tableau a "+ nb+ " lignes et le csv en a : " + count);
					}
				}

			}
		}




	}

	@Test
	public void TestExportColonne() throws Exception
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

				for (int j=1; j<page.getPage().size()+1;j++) {
					int count = 0;
					String chemin = destination+wikitext.getNomCSV().get(i)+ "-" + j+ ".csv";
					BufferedReader fichier_source = new BufferedReader(new FileReader(chemin));
					String chaine;
					chaine = fichier_source.readLine();
					String[] tabChaine = chaine.split(",");
					count=tabChaine.length;
					fichier_source.close();
					int nb=page.getPage().get(j-1).getHeader().getLigne().getCelluleLigne().size();
					if (nb!=count) 
					{
						System.out.println("Le tableau a "+ nb+ " colonne et le csv en a : " + count);
					}
				}

				
			}

		}
	}




}



