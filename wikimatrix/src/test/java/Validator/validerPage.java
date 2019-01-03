package Validator;

import Metier.Page;
/**
 * Permet de valider une page cad si la page contient ou non un tableaude type wikitable sortable
 * @author Donatien
 *
 */
public class validerPage extends Validator {
	
	private Page page;
	public validerPage() {
		// TODO Auto-generated constructor stub
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public boolean valider(){
		return page.getPage().size()!=0;
	}
	
	

}
