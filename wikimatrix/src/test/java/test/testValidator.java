package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import Metier.*;
import Outils.Internet;
import Validator.Validator;
import Validator.ValiderUrl;
import Validator.validerPage;
/**
 * On test differents validator
 * @author Donatien
 *
 */
public class testValidator {



	@Test
	public void validerUrlTest() throws MalformedURLException {
		//On test avec Un URL valide
		URL url=new URL("https://www.google.com/");
		ValiderUrl aValider=new ValiderUrl();
		aValider.setUrl(url);
		assertEquals(true, aValider.estValide());
		//Test d'une page avec erreur 404
		url=new URL("http://www.jurassicworld.com/404");
		aValider=new ValiderUrl();
		aValider.setUrl(url);
		assertEquals(false, aValider.estValide());

	}
	
	@Test
	public void validerPageTest() {
		//Si la page est vide cad que la page extraite ne contient aucun tableau
		Page page=new Page();
		validerPage validator=new validerPage();
		validator.setPage(page);
		assertEquals(false, validator.valider());
		//On crée un tableau non vide et on verifie qu'il est non vide
		Cellule cell=new Cellule();
		cell.setContient("test");
		Ligne ligne=new Ligne();
		ligne.getCelluleLigne().add(cell);
		Header header=new Header();
		header.setLigne(ligne);
		Tableau tableau=new Tableau();
		tableau.setHeader(header);
		page.getPage().add(tableau);
		assertEquals(true, validator.valider());		
	}
	
	

}