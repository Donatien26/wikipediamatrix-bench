package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import Metier.Cellule;
import Metier.Page;
import Metier.Tableau;
import Outils.Internet;
import Outils.lectureTXT;

public class TestStat {

	public TestStat() {

	}

	public static void main(String[] args) throws Exception 
	{	
		String NEW_LINE_SEPARATOR = "\n";
		lectureTXT wikitext=new lectureTXT();
		wikitext.charger();
		ArrayList<Integer> colonneByTable=new ArrayList<Integer>();
		ArrayList<Integer> ligneByTable=new ArrayList<Integer>();
		TestStat stat1=new TestStat();
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		//Create the CSVFormat object with "\n" as a record delimiter
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

		//initialize FileWriter object

		fileWriter = new FileWriter( "Stat.csv");

		//initialize CSVPrinter object 
		csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
		ArrayList<String> Header =new ArrayList<String>();
		Header.add("Description");
		//Create CSV file header
		csvFilePrinter.printRecord(Header);

		for (int i=0 ; i< wikitext.getLienPage().size(); i++) 
		{
			if (wikitext.getLienPage().get(i).estValide()) 
			{	
				int nbColonne=0;
				int nbLigne=0;
				Internet recherche = new Internet();
				Page page;
				page=recherche.RecupererTableauUrl(wikitext.getLienPage().get(i).asString());




				if (page.valider()) 
				{	
					for (Tableau table:page.getPage()) 
					{	
						for (Cellule cell:table.getHeader().getLigne().getCelluleLigne()) 
						{
							ArrayList<String> stat11 =new ArrayList<String>();
							stat11.add(cell.getContient());
							csvFilePrinter.printRecord(stat11);
						}
						nbColonne=table.getHeader().getLigne().getCelluleLigne().size();
						nbLigne=table.getBody().getCoeur().size();
						colonneByTable.add(nbColonne);
						ligneByTable.add(nbLigne);


					}




				}
			}
		}
		fileWriter.flush();
		fileWriter.close();
		csvFilePrinter.close();
		System.out.println("Statistique ligne");
		stat1.summary(ligneByTable);

		System.out.println("Statistique Colonne");
		stat1.summary(colonneByTable);
		System.out.println(stat1.somme(colonneByTable));




	}


	public int moyenne(ArrayList<Integer> list) 
	{	
		int somme=0;
		for (Integer n:list) 
		{
			somme=somme+n;
		}
		return somme/list.size();

	}

	public int somme(ArrayList<Integer> list) 
	{	
		int somme=0;
		for (Integer n:list) 
		{
			somme=somme+n;
		}
		return somme;

	}

	public int min(ArrayList<Integer> list) 
	{	
		int min=list.get(0);
		for (Integer n:list) 
		{
			if (min>n) {min=n;}
		} 
		return min;

	}

	public int max(ArrayList<Integer> list) 
	{	
		int max=list.get(0);
		for (Integer n:list) 
		{
			if (max<n) {max=n;}
		} 
		return max;

	}

	public int variance(ArrayList<Integer> list) 
	{	
		int somme=0;
		TestStat testStat=new TestStat();
		int moyenne= testStat.moyenne(list);
		for (Integer n:list) 
		{
			somme=somme+(n-moyenne)*(n-moyenne);
		}
		return somme/list.size();

	}

	public void summary(ArrayList<Integer> list) {
		TestStat testStat=new TestStat();
		System.out.println("minimun ");
		System.out.println(testStat.min(list));
		System.out.println("moyenne ");
		System.out.println(testStat.moyenne(list));
		System.out.println("variance ");
		System.out.println(testStat.variance(list));
		System.out.println("maximun ");
		System.out.println(testStat.max(list));


	}



}
