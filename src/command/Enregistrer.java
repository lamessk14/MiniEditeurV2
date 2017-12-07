package command;

import memento.Caretaker;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class Enregistrer implements Command {
	
	private Caretaker enregistreur;
	
	/**
	 * Création de la commande qui permet de commencer un enregistrement
	 * @param enregistreur1
	 */
	public Enregistrer(Caretaker enregistreur1) {
		enregistreur = enregistreur1;
	}
	
	/**
	 * Exécution de la commande qui permet de commencer un enregistrement
	 */
	@Override
	public void execute() {
		enregistreur.commencerEnregistrement();
	}

}