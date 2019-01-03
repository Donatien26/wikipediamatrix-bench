package Validator;

import org.jsoup.nodes.Element;
/**
 * Classe qui permet de verifier si l'objet table que l'on recupere est bien un wikitable sortable
 * @author Donatien
 *
 */
public class tableValidator extends Validator {
	
	private Element table;
	
	public tableValidator() 
	{
		
	}
	
	public boolean estValide() {

		return table.getElementsByClass("wikitable sortable").size()!=0;
		
	}

	public Element getTable() {
		return table;
	}

	public void setTable(Element table) {
		this.table = table;
	}


	
}
