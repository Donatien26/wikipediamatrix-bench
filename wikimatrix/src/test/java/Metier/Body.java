package Metier;

import java.util.ArrayList;
/**
 * Classe implementant le body d'un tableau
 * @author Donatien
 *
 */
public class Body extends Tableau {
	private ArrayList<Ligne> coeur=new ArrayList<Ligne>();
	/**
	 * Constructeur du body
	 */
	public Body() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Renvoie le coeur du tableau
	 * @return ArrayList<Ligne>
	 */
	public ArrayList<Ligne> getCoeur() {
		return coeur;
	}
	
	/**
	 * Permet de modifier un ensemble de ligne au tableau
	 * @param coeur
	 */
	public void setCoeur(ArrayList<Ligne> coeur) {
		this.coeur = coeur;
	}
	/**
	 * Permet d'ajouter une ligne au body
	 * @param ligne
	 */
	public void ajouterLigne(Ligne ligne) 
	{
		coeur.add(ligne);
	}

}
