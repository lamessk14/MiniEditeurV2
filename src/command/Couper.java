package command;
import java.util.*;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class Couper implements Command {

	/**
	 * D�claration de variables
	 */
		protected MoteurEditeurImplem moteur;

	    /**
	     * Cr�ation de la commande couper
	     */
	    public Couper(MoteurEditeurImplem moteur1) {
	    	moteur = moteur1;
	    }

	    /**
	     * Ex�cution de la commande couper
	     */
	    @Override
	    public void execute() {
	        moteur.couper();
	    }

}