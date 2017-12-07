package command;

import memento.Caretaker;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */
public class Rejouer implements Command {
	
	private Caretaker enregistreur;
	
	/**
	 * Permet de cr�er la commande Rejouer
	 * @param enregistreur1
	 */
	public Rejouer(Caretaker enregistreur1) {
		enregistreur = enregistreur1;
	}
	
	/**
	 * Permet d'ex�cuter la commande Rejouer
	 */
	@Override
	public void execute() {
		enregistreur.rejouer();
	}
}