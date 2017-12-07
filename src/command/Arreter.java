package command;

import memento.Caretaker;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class Arreter implements Command {

	private Caretaker enregistreur;

	/**
	 * Permet de créer la commande arrêter
	 * @param enregistreur1
	 */
	public Arreter(Caretaker enregistreur1) {
		enregistreur = enregistreur1;
	}
	
	/**
	 * Permet d'exécuter la commande arrêter
	 */
	@Override
	public void execute() {
		enregistreur.arreterEnregistrement();
	}
}
