package Outils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.junit.Test;

import Metier.Body;
import Metier.Cellule;
import Metier.Header;
import Metier.Ligne;
import Metier.Page;
import Metier.Tableau;
import Validator.tableValidator;

public class Internet {

	public Internet() {
		// TODO Auto-generated constructor stub
	}



	@Test
	public Page RecupererTableauUrl(String chemin) throws IOException {
		//on charge la page wikipédia et retourne un document HTML
		Document doc = Jsoup.connect(chemin).get();
		Tableau tableau = new Tableau();
		Page page=new Page();
		Header header=new Header();
		Body body=new Body();
		int i=0;

		//on recupere l'interieur du tableau 


		for (Element table:doc.select("table")) 
		{
			tableau=new Tableau();
			header=new Header();
			body=new Body();
			
			tableValidator tableau_A_Valider= new tableValidator();
			tableau_A_Valider.setTable(table);
			
			if(tableau_A_Valider.estValide()) {
				header=entete(table);
				body=recupererBody(table);
				tableau.setHeader(header);
				tableau.setBody(body);
				page.getPage().add(tableau);

			}
			i++;
		}
		return page;



	}

	public Body recupererBody(Element table) {
		Elements rows=table.select("tr");
		Ligne ligne= new Ligne();
		Body body=new Body();
		int i=0;
		for (Element ligneI:rows) { 
			
			Elements cols = ligneI.select("td");
			ligne=lectureLigne(cols);
			cols=ligneI.select("th");
			if (!cols.isEmpty()& i>0) {
				Cellule cellule=new Cellule();
				cellule.setContient(cols.get(0).text());
				ligne.getCelluleLigne().add(0,cellule);
				
			}
			body.ajouterLigne(ligne);
			i++;
		}
		return body;

	}

	public Ligne lectureLigne(Elements cols) {
		Ligne ligne= new Ligne();
		Cellule cellule=new Cellule();
		for (Element col:cols) { 
			//first row is the col names so skip it.
			cellule=new Cellule();
			cellule.setContient(col.text());
			ligne.getCelluleLigne().add(cellule);
		}
		return ligne;

	}

	public Header entete(Element table) {
		//je selectionne les entete
		Elements ColEntete=table.select("tr").first().select("th");
		Header head=new Header();
		Ligne ligne= new Ligne();
		Cellule cellule=new Cellule();
		for (Element col:ColEntete) 
		{	
			cellule=new Cellule();
			cellule.setContient(col.text());
			ligne.getCelluleLigne().add(cellule);

		}
		head.setLigne(ligne);
		return head;

	}


}



