package observer;

import receiver.MoteurEditeurImplem;
import invoker.MyIHM;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class ObserverImplem extends MyIHM implements Observer {
	
Subject subject;
	
/**
 * 
 * @param sujet
 */
	public ObserverImplem(Subject sujet) {
		subject = sujet;
	}

	@Override
	public void notifyMe() {
		MoteurEditeurImplem moteur = (MoteurEditeurImplem) subject;
		zoneDeSaisie.MAJ(moteur.getTexte(),	moteur.getSelectionDebut(),	moteur.getSelectionFin());
	}

}