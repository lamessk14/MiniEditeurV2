package client;

import java.util.*;
import java.util.HashMap;

import memento.*;
import observer.ObserverImplem;
import receiver.*;
import command.*;

/**
 * 
 */
public class MonAppli {
	
	private MoteurEditeurImplem moteur;
	private ObserverImplem myIHM;
	private HashMap<String,Command> commandesIHM;
	private HashMap<String,CommandEnregistrable> commandesEnregistrables;
	private Caretaker enregistreur;

    /**
     * Default constructor
     */
    public MonAppli() {
    	moteur = new MoteurEditeurImplem();
    	myIHM = new ObserverImplem(moteur);
		enregistreur = new Caretaker();
		commandesIHM = new HashMap<String,Command>();
		commandesEnregistrables = new HashMap<String,CommandEnregistrable>();
		
		CopierEnregistrable copier = new CopierEnregistrable(moteur, enregistreur);
		commandesIHM.put("copier", copier);
		commandesEnregistrables.put("copier", copier);
		
		CollerEnregistrable coller = new CollerEnregistrable(moteur, enregistreur);
		commandesIHM.put("coller", coller);
		commandesEnregistrables.put("coller", coller);
		
		CouperEnregistrable couper = new CouperEnregistrable(moteur, enregistreur);
		commandesIHM.put("couper", couper);
		commandesEnregistrables.put("couper", couper);
		
		InsererTxtEnregistrable insererTxt = new InsererTxtEnregistrable(moteur, myIHM, enregistreur);
		commandesIHM.put("insererTxt", insererTxt);
		commandesEnregistrables.put("insererTxt", insererTxt);
		
		SupprimerEnregistrable supprimer = new SupprimerEnregistrable(moteur, enregistreur);
		commandesIHM.put("supprimer", supprimer);
		commandesEnregistrables.put("supprimer", supprimer);
		
		commandesIHM.put("selectionner", new Selectionner(moteur, myIHM));
		commandesIHM.put("enregistrer", new Enregistrer(enregistreur));
		commandesIHM.put("arreter", new Arreter(enregistreur));
		commandesIHM.put("rejouer", new Rejouer(enregistreur));
    }

    public void start(){
    	myIHM.initComposants(commandesIHM);
		moteur.registerObserver(myIHM);
		myIHM.afficher();
		enregistreur.setCommandes(commandesEnregistrables);
	}

	public static void main(String args[]) {
		MonAppli monAppli = new MonAppli();
		monAppli.start();
	}

	public MoteurEditeurImplem getMoteur(){
		return moteur;
	}
	
	public ObserverImplem getIHM(){
		return myIHM;
	}
	
	public HashMap<String,Command> getCommandes(){
		return commandesIHM;
	}
	
	public HashMap<String, CommandEnregistrable> getCommandesEnregistreur() {
		return commandesEnregistrables;
	}
	
	public Caretaker getEnregistreur(){
		return enregistreur;
	}

}