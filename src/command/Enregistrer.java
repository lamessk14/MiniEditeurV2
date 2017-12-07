package command;

import memento.Caretaker;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class Enregistrer implements Command {
	
	private Caretaker enregistreur;
	
	/**
	 * Cr�ation de la commande qui permet de commencer un enregistrement
	 * @param enregistreur1
	 */
	public Enregistrer(Caretaker enregistreur1) {
		enregistreur = enregistreur1;
	}
	
	/**
	 * Ex�cution de la commande qui permet de commencer un enregistrement
	 */
	@Override
	public void execute() {
		enregistreur.commencerEnregistrement();
	}

}