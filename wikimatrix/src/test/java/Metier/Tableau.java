package Metier;
/**
 * Classe qui implemente les tableaux
 * @author Donatien
 *
 */
public class Tableau {
	private Header header;
	private Body body;
	/**
	 * Constructeur
	 */
	public Tableau() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Renvoie le header
	 * @return
	 */
	public Header getHeader() {
		return header;
	}
	/**
	 * Definit le header
	 * @param header
	 */
	public void setHeader(Header header) {
		this.header = header;
	}
	/**
	 * Renvoie le body
	 * @return
	 */
	public Body getBody() {
		return body;
	}
	/**
	 * Definit le body
	 * @param body
	 */
	public void setBody(Body body) {
		this.body = body;
	}
	

}
