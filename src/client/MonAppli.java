package client;

import java.util.*;
import java.util.HashMap;

import memento.*;
import observer.ObserverImplem;
import receiver.*;
import command.*;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class MonAppli {
	
	/**
	 * Déclaration des variables
	 */
	private MoteurEditeurImplem moteur;
	private ObserverImplem myIHM;
	private HashMap<String,Command> commandesIHM;
	private HashMap<String,CommandEnregistrable> commandesEnregistrables;
	private Caretaker enregistreur;

    /**
     * Création de tous les objets qui permettront le fonctionnement de l'application
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
/**
 * Initialisation des différentes fonctions (copier, coller, couper...) du pattern Command
 * Il n'y a qu'une seule classe Observer. Il s'agit du moteurEditeur
 * Affichage de l'interface graphique
 */
    public void start(){
    	myIHM.initComposants(commandesIHM);
		moteur.registerObserver(myIHM);
		myIHM.afficher();
		enregistreur.setCommandes(commandesEnregistrables);
	}
/**
 * Exécution du main
 * 
 * @param args
 */
	public static void main(String args[]) {
		MonAppli monAppli = new MonAppli();
		monAppli.start();
	}

	/**
	 * 
	 * @return le moteur éditeur
	 */
	public MoteurEditeurImplem getMoteur(){
		return moteur;
	}
	
	/**
	 * 
	 * @return l'IHM
	 */
	public ObserverImplem getIHM(){
		return myIHM;
	}
	
	/**
	 * 
	 * @return les commandes non enregistrables
	 */
	public HashMap<String,Command> getCommandes(){
		return commandesIHM;
	}
	
	/**
	 * 
	 * @return les commandes enregistrables
	 */
	public HashMap<String, CommandEnregistrable> getCommandesEnregistreur() {
		return commandesEnregistrables;
	}
	
	/**
	 * 
	 * @return l'enregistreur
	 */
	public Caretaker getEnregistreur(){
		return enregistreur;
	}

}