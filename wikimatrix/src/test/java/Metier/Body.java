package Metier;

import java.util.ArrayList;

public class Body extends Tableau {
	private ArrayList<Ligne> coeur=new ArrayList<Ligne>();
	public Body() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Ligne> getCoeur() {
		return coeur;
	}
	
	public void setCoeur(ArrayList<Ligne> coeur) {
		this.coeur = coeur;
	}
	
	public void ajouterLigne(Ligne ligne) 
	{
		coeur.add(ligne);
	}

}
