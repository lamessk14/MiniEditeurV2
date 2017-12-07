package memento;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class Caretaker {
	
	private Queue<Memento> mementos;
	private HashMap<String, CommandEnregistrable> commandesEnregistrables;
	private boolean etat;

	/**
	 * Création d'une liste de mémento + un hashMap de commandes enregistrables
	 * associées à leurs noms
	 */
	public Caretaker() {
		mementos = new LinkedList<Memento>();
		commandesEnregistrables = new HashMap<String, CommandEnregistrable>();
		etat = false;
	}

	public void enregistrer(CommandEnregistrable command) {
		if (etat) {
			mementos.add(command.getMemento());
		}
	}

	public void rejouer() {
		if (!etat) {
			for (Memento memento : mementos) {
				CommandEnregistrable command = (CommandEnregistrable) commandesEnregistrables.get(memento.getType());
				System.out.println(commandesEnregistrables.get(memento.getType()));
				command.setMemento(memento);
			}
		}
	}

	public void commencerEnregistrement() {
		mementos.clear();
		etat = true;
	}

	public void arreterEnregistrement() {
		etat = false;
	}

	public void setCommandes(HashMap<String, CommandEnregistrable> commandes) {
		commandesEnregistrables = commandes;
	}
	
	public Queue<Memento> getMementos(){
		return mementos;
	}

	public CommandEnregistrable getCommand(String nomCommande) {
		return commandesEnregistrables.get(nomCommande);
	}

}
