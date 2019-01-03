package Metier;

import java.util.ArrayList;
/**
 * Implemente la ligne d'un tableau
 * @author Donatien
 *
 */
public class Ligne{
	private ArrayList<Cellule> celluleLigne=new ArrayList<Cellule>();
	/**
	 * Constructeur d'une ligne
	 */
	public Ligne() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Renvoie une liste de cellule qui compose la ligne
	 * @return ArrayList<Cellule> 
	 */
	public ArrayList<Cellule> getCelluleLigne() {
		return celluleLigne;
	}
	
	/**
	 * Permet de definir les cellules d'une ligne
	 * @param celluleLigne
	 */
	public void setCelluleLigne(ArrayList<Cellule> celluleLigne) {
		this.celluleLigne = celluleLigne;
	}
	
	 

}
