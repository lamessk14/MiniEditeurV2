package command;

import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class Supprimer implements Command {
	private MoteurEditeurImplem moteur;

	/**
	 * Permet de créer la commande supprimer
	 * @param moteur1
	 */
	public Supprimer(MoteurEditeurImplem moteur1) {
		this.moteur = moteur1;
	}

	/**
	 * Permet d'exécuter la commande supprimer
	 */
	@Override
	public void execute() {
		moteur.supprimer();
	}

}
