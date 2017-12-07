package command;

import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class Copier implements Command {
	
	/**
	 * D�claration de variables
	 */
			private MoteurEditeurImplem moteur;

		    /**
		     * Permet de cr�er la commande copier
		     */
		    public Copier(MoteurEditeurImplem moteur1) {
		    	moteur = moteur1;
		    }

		    /**
		     *Permet d'ex�cuter la commande copier
		     */
		    @Override
		    public void execute() {
		        moteur.copier();
		    }


}
