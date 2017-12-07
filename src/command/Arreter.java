package command;

import memento.Caretaker;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class Arreter implements Command {

	private Caretaker enregistreur;

	/**
	 * Permet de cr�er la commande arr�ter
	 * @param enregistreur1
	 */
	public Arreter(Caretaker enregistreur1) {
		enregistreur = enregistreur1;
	}
	
	/**
	 * Permet d'ex�cuter la commande arr�ter
	 */
	@Override
	public void execute() {
		enregistreur.arreterEnregistrement();
	}
}
