package command;
import java.util.*;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class Couper implements Command {

	/**
	 * Déclaration de variables
	 */
		protected MoteurEditeurImplem moteur;

	    /**
	     * Création de la commande couper
	     */
	    public Couper(MoteurEditeurImplem moteur1) {
	    	moteur = moteur1;
	    }

	    /**
	     * Exécution de la commande couper
	     */
	    @Override
	    public void execute() {
	        moteur.couper();
	    }

}