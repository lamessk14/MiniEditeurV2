package command;
import java.util.*;

import invoker.MyIHM;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class InsererTxt implements Command {

	/**
	 * Déclaration des variables
	 */
	protected MoteurEditeurImplem moteur;
	protected MyIHM ihm;
	
	/**
	 * Création d'une commande insererTxt
	 * 
	 * @param moteur1
	 * @param ihm1
	 */
	public InsererTxt(MoteurEditeurImplem moteur1, MyIHM ihm1) {
		moteur = moteur1;
		ihm = ihm1;
	}

	/**
	 * Permet d'exécuter l'insertion d'un caractère ou d'une chaîne de caractères
	 */
	@Override
	public void execute() {
		moteur.insererTxt(ihm.getDernierCharactere());
	}

}