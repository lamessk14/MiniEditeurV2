package observer;

import receiver.MoteurEditeurImplem;
import invoker.MyIHM;

public class ObserverImplem extends MyIHM implements Observer {
	
Subject subject;
	
	public ObserverImplem(Subject sujet) {
		subject = sujet;
	}

	@Override
	public void notifyMe() {
		MoteurEditeurImplem moteur = (MoteurEditeurImplem) subject;
		zoneDeSaisie.MAJ(moteur.getTexte(),	moteur.getSelectionDebut(),	moteur.getSelectionFin());
	}

}