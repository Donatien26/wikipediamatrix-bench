package Metier;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Header {

	private Ligne ligne;
	public Header() 
	{
		
	}
	public Ligne getLigne() {
		return ligne;
	}
	public void setLigne(Ligne ligne) {
		this.ligne = ligne;
	}
	public ArrayList<Cellule> recupererCelluleHeader(){
		return ligne.getCelluleLigne();
	}


}
