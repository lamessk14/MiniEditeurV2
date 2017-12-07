package command;

import memento.Caretaker;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class Rejouer implements Command {
	
	private Caretaker enregistreur;
	
	/**
	 * Permet de créer la commande Rejouer
	 * @param enregistreur1
	 */
	public Rejouer(Caretaker enregistreur1) {
		enregistreur = enregistreur1;
	}
	
	/**
	 * Permet d'exécuter la commande Rejouer
	 */
	@Override
	public void execute() {
		enregistreur.rejouer();
	}
}