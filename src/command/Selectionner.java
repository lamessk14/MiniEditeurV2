package command;

import java.util.*;
import invoker.MyIHM;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class Selectionner implements Command {

	/**
	 * Déclaration des variables
	 */
	private MoteurEditeurImplem moteur;
	private MyIHM ihm;

	/**
	 * Création de la commande sélectionner
	 * 
	 * @param moteur1
	 * @param ihm1
	 */
	public Selectionner(MoteurEditeurImplem moteur1, MyIHM ihm1) {
		this.moteur = moteur1;
		this.ihm = ihm1;
	}

	/**
	 * Permet d'éxécuter la commande sélectionner
	 */
	@Override
	public void execute() {
		moteur.selectionner(ihm.getDebutSelection(), ihm.getFinSelection());
	}

}