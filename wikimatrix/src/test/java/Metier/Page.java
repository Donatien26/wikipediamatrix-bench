package Metier;

import java.util.ArrayList;

import Validator.validerPage;
/**
 * Implemente le comprtement d'une page internet
 * @author Donatien
 *
 */
public class Page {
	private ArrayList<Tableau> page =new ArrayList<Tableau>();
	/**
	 * Constructeur
	 */
	public Page() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Renvoie une liste de tout les tableaux compris dans la page
	 * @return ArrayList<Tableau>
	 */
	public ArrayList<Tableau> getPage() {
		return page;
	}

	/**
	 * Definit les tableaux qui compose la page
	 * @param page
	 */
	public void setPage(ArrayList<Tableau> page) {
		this.page = page;
	}
	/**
	 * Permet de valider une page 
	 * @return boolean
	 */
	public boolean valider() {
		validerPage page1 = new validerPage();
		page1.setPage(this);
		
		return page1.valider();
	}

}
