package command;

import java.util.*;
import invoker.MyIHM;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class Selectionner implements Command {

	/**
	 * D�claration des variables
	 */
	private MoteurEditeurImplem moteur;
	private MyIHM ihm;

	/**
	 * Cr�ation de la commande s�lectionner
	 * 
	 * @param moteur1
	 * @param ihm1
	 */
	public Selectionner(MoteurEditeurImplem moteur1, MyIHM ihm1) {
		this.moteur = moteur1;
		this.ihm = ihm1;
	}

	/**
	 * Permet d'�x�cuter la commande s�lectionner
	 */
	@Override
	public void execute() {
		moteur.selectionner(ihm.getDebutSelection(), ihm.getFinSelection());
	}

}