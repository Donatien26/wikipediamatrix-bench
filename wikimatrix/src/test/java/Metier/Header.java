package Metier;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * Classe qui implemente le header d'un tableau;
 * @author Donatien
 *
 */
public class Header {

	private Ligne ligne;
	/**
	 * Constructeur du header
	 */
	public Header() 
	{
		
	}
	/**
	 * Renvoie la ligne qui compose le header 
	 * @return Ligne
	 */
	public Ligne getLigne() {
		return ligne;
	}
	/**
	 * Defini la ligne du header
	 * @param ligne
	 */
	public void setLigne(Ligne ligne) {
		this.ligne = ligne;
	}
	/**
	 * Permet d'acceder directement au cellule composant le headerr
	 * @return ArrayList<Cellule>
	 */
	public ArrayList<Cellule> recupererCelluleHeader(){
		return ligne.getCelluleLigne();
	}


}
