package memento;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public abstract class MementoImplem implements Memento {
	
	private String etat;
	protected String type;

	/**
	 * Retourne le nom de la commande associée à un mémento
	 */
	public String getType(){
		return type;
	}
		
	/**
	 * 
	 * @return l'état d'un mémento
	 */
	public String getEtat() {
		System.out.println(this.toString() + ":getEtat: " + etat);
		return etat;
	}

	/**
	 * Permet de changer l'état d'un mémento
	 * @param etat1
	 */
	public void setEtat(String etat1) {
		System.out.println(this.toString() + ":setEtat: " + etat);
		etat = etat1;
	}

}
