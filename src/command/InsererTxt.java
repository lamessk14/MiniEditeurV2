package command;
import java.util.*;

import invoker.MyIHM;
import receiver.MoteurEditeurImplem;

/**
 * 
 */
public class InsererTxt implements Command {

	//Déclaration des variables
	protected MoteurEditeurImplem moteur;
	protected MyIHM ihm;
	
	//Constructeur
	public InsererTxt(MoteurEditeurImplem moteur1, MyIHM ihm1) {
		moteur = moteur1;
		ihm = ihm1;
	}

	@Override
	public void execute() {
		moteur.insererTxt(ihm.getDernierCharactere());
	}

}