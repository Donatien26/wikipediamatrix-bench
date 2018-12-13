package Outils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import Metier.Cellule;
import Metier.Ligne;
import Metier.Page;


public class CsvFileWriter {

	//Delimiter used in CSV file
	private static final String NEW_LINE_SEPARATOR = "\n";


	public CsvFileWriter() {

	}

	public void writeCsvFile(String fileName, Page page) {



		FileWriter fileWriter = null;

		CSVPrinter csvFilePrinter = null;

		//Create the CSVFormat object with "\n" as a record delimiter
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
		for (int i=0; i<page.getPage().size();i++) {
			try {

				//initialize FileWriter object

				int doc=0;
				if (page.getPage().get(i).getBody().getCoeur().size()>1 && page.getPage().get(i).getHeader().getLigne().getCelluleLigne().size()>1) 
				{
					doc=i+1;
					fileWriter = new FileWriter(fileName+ "-" + doc+ ".csv");

					//initialize CSVPrinter object 
					csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
					ArrayList<String> Header =new ArrayList<String>();
					for(Cellule cell:page.getPage().get(i).getHeader().recupererCelluleHeader()) 
					{
						Header.add(cell.getContient());

					}
					//Create CSV file header
					csvFilePrinter.printRecord(Header);

					//Write a new student object list to the CSV file



					for(Ligne ligne:page.getPage().get(i).getBody().getCoeur()) 
					{	
						ArrayList<String> ecrire =new ArrayList<String>();
						for (Cellule cell:ligne.getCelluleLigne()) 
						{
							ecrire.add(cell.getContient());

						}
						csvFilePrinter.printRecord(ecrire);


					}
					System.out.println("CSV crée :"+ fileName+"-"+doc);
				}
			}

			catch (Exception e) {
				System.out.println("Error in CsvFileWriter !!!");
				e.printStackTrace();
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();
					csvFilePrinter.close();
				} catch (IOException e) {
					System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
					e.printStackTrace();
				}
			}
		}
	}
}
