package command;

import receiver.MoteurEditeurImplem;

public class Copier implements Command {
	
	//Déclaration de variables
			private MoteurEditeurImplem moteur;

		    /**
		     * Constructeur
		     */
		    public Copier(MoteurEditeurImplem moteur1) {
		    	moteur = moteur1;
		    }

		    /**
		     * 
		     */
		    @Override
		    public void execute() {
		        moteur.copier();
		    }


}
