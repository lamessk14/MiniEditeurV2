package command;

import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class Copier implements Command {
	
	/**
	 * Déclaration de variables
	 */
			private MoteurEditeurImplem moteur;

		    /**
		     * Permet de créer la commande copier
		     */
		    public Copier(MoteurEditeurImplem moteur1) {
		    	moteur = moteur1;
		    }

		    /**
		     *Permet d'exécuter la commande copier
		     */
		    @Override
		    public void execute() {
		        moteur.copier();
		    }


}
