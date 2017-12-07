package client.test;

import static org.junit.Assert.*;

import java.util.HashMap;

import memento.Caretaker;
import memento.CommandEnregistrable;
import observer.ObserverImplem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import receiver.MoteurEditeurImplem;
import command.Command;
import client.MonAppli;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class ClientTest {
	
	private MonAppli myEditeurDeTexte;
	private MoteurEditeurImplem moteur;
	private ObserverImplem ihm;
	private HashMap<String,Command> commandesIHM;
	private HashMap<String,CommandEnregistrable> commandesEnregistrables;
	private Caretaker enregistreur;

	/**
	 * Actions effectuées avant les tests
	 * 
	 * Création des différents objets qui permettront d'effectuer les tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		myEditeurDeTexte = new MonAppli();
		moteur = myEditeurDeTexte.getMoteur();
		ihm = myEditeurDeTexte.getIHM();
		enregistreur = myEditeurDeTexte.getEnregistreur();
		commandesIHM = myEditeurDeTexte.getCommandes();
		commandesEnregistrables = myEditeurDeTexte.getCommandesEnregistreur();
		
		ihm.initComposants(commandesIHM);
		enregistreur.setCommandes(commandesEnregistrables);
		moteur.registerObserver(ihm);
	}

	/**
	 * Actions effectuées après les tests
	 * 
	 * Libération des objets
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		myEditeurDeTexte = null;
		moteur = null;
		ihm = null;
		commandesIHM = null;
		commandesEnregistrables = null;
		enregistreur = null;
	}

	/**
	 * Vérification de la correspondance entre les commandes et les noms de commande
	 */
	@Test
	public void testCommandes() {
		 assertEquals(commandesIHM.get("couper"), ihm.getCommand("couper") );
		 assertEquals(commandesIHM.get("copier"), ihm.getCommand("copier")); 
		 assertEquals(commandesIHM.get("coller"), ihm.getCommand("coller"));
		 assertEquals(commandesIHM.get("enregistrer"), ihm.getCommand("enregistrer")); 
		 assertEquals(commandesIHM.get("arreter"), ihm.getCommand("arreter")); 
		 assertEquals(commandesIHM.get("jouer"), ihm.getCommand("jouer"));
		 assertEquals(commandesIHM.get("selectionner"), ihm.getTextArea().getCommand("selectionner")); 
		 assertEquals(commandesIHM.get("inserer"), ihm.getTextArea().getCommand("insererTxt")); 
		 assertEquals(commandesIHM.get("delete"), ihm.getTextArea().getCommand("supprimer"));
		 
		 assertEquals(commandesEnregistrables.get("couper"), enregistreur.getCommand("couper"));
		 assertEquals(commandesEnregistrables.get("copier"), enregistreur.getCommand("copier")); 
		 assertEquals(commandesEnregistrables.get("coller"), enregistreur.getCommand("coller"));
		 assertEquals(commandesEnregistrables.get("insererTxt"), enregistreur.getCommand("insererTxt")); 
		 assertEquals(commandesEnregistrables.get("supprimer"), enregistreur.getCommand("supprimer"));
		 
	}
	/**
	 * Vérification de l'existence d'observers
	 */
	@Test
	public void testObservers() {
		 assertTrue(moteur.getObservers().contains(ihm)); 
	}
	
	/**
	 * Insertion d'une chaîne de caractères(date), dernier caractère coupé puis collé
	 * au même emplacement de départ
	 * Sélection de la chaîne de caractère, copie puis coller
	 * Enregistrement des commandes réalisées puis repaly de ces commandes
	 */
	@Test
	public void testMoteur(){
			
		enregistreur.commencerEnregistrement();
		
		ihm.getTextArea().setDernierCharactere('d');
		commandesEnregistrables.get("insererTxt").execute();
		ihm.getTextArea().setDernierCharactere('a');
		commandesEnregistrables.get("insererTxt").execute();
		ihm.getTextArea().setDernierCharactere('t');
		commandesEnregistrables.get("insererTxt").execute();
		ihm.getTextArea().setDernierCharactere('e');
		commandesEnregistrables.get("insererTxt").execute();
		assertEquals("date", ihm.getTextArea().getText());
		
		moteur.selectionner(0, 4);
		commandesEnregistrables.get("couper").execute();
		assertEquals("",ihm.getTextArea().getText());
		assertEquals("date",moteur.getPressePapierTexte());
		
		commandesEnregistrables.get("coller").execute();
		assertEquals("date",ihm.getTextArea().getText());
		
		moteur.selectionner(0, 4);
		commandesEnregistrables.get("copier").execute();
		moteur.selectionner(4, 4);
		commandesEnregistrables.get("coller").execute();
		
		enregistreur.arreterEnregistrement();
		
		moteur.selectionner(0,moteur.getTexte().length());
		commandesEnregistrables.get("supprimer").execute();
		
		enregistreur.rejouer();
		assertEquals("datedate",ihm.getTextArea().getText());
	}

}
