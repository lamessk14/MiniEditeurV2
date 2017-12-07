package command;
import java.util.*;

import invoker.MyIHM;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */
public class InsererTxt implements Command {

	/**
	 * D�claration des variables
	 */
	protected MoteurEditeurImplem moteur;
	protected MyIHM ihm;
	
	/**
	 * Cr�ation d'une commande insererTxt
	 * 
	 * @param moteur1
	 * @param ihm1
	 */
	public InsererTxt(MoteurEditeurImplem moteur1, MyIHM ihm1) {
		moteur = moteur1;
		ihm = ihm1;
	}

	/**
	 * Permet d'ex�cuter l'insertion d'un caract�re ou d'une cha�ne de caract�res
	 */
	@Override
	public void execute() {
		moteur.insererTxt(ihm.getDernierCharactere());
	}

}