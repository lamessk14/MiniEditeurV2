package command;
import java.util.*;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class Coller implements Command {
	
	/**
	 * Déclaration de variables
	 */
	private MoteurEditeurImplem moteur;

    /**
     * Permet de créer la commande coller
     */
    public Coller(MoteurEditeurImplem moteur1) {
    	moteur = moteur1;
    }

    /**
     * Permet d'exécuter la commande coller
     */
    @Override
    public void execute() {
        moteur.coller();
    }

}