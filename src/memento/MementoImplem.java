package memento;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */
public abstract class MementoImplem implements Memento {
	
	private String etat;
	protected String type;

	/**
	 * Retourne le nom de la commande associ�e � un m�mento
	 */
	public String getType(){
		return type;
	}
		
	/**
	 * 
	 * @return l'�tat d'un m�mento
	 */
	public String getEtat() {
		System.out.println(this.toString() + ":getEtat: " + etat);
		return etat;
	}

	/**
	 * Permet de changer l'�tat d'un m�mento
	 * @param etat1
	 */
	public void setEtat(String etat1) {
		System.out.println(this.toString() + ":setEtat: " + etat);
		etat = etat1;
	}

}
