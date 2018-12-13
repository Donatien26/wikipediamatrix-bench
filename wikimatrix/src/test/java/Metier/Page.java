package Metier;

import java.util.ArrayList;

import Validator.validerPage;

public class Page {
	private ArrayList<Tableau> page =new ArrayList<Tableau>();
	
	public Page() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Tableau> getPage() {
		return page;
	}

	public void setPage(ArrayList<Tableau> page) {
		this.page = page;
	}
	
	public boolean valider() {
		validerPage page1 = new validerPage();
		page1.setPage(this);
		
		return page1.valider();
	}

}
