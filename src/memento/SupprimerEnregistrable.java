package memento;

import receiver.MoteurEditeurImplem;
import command.Supprimer;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */
public class SupprimerEnregistrable extends Supprimer implements CommandEnregistrable {
	
private Caretaker enregistreur;
	/**
	 * 
	 * @param moteur
	 * @param enregistreur1
	 */
	public SupprimerEnregistrable(MoteurEditeurImplem moteur, Caretaker enregistreur1) {
		super(moteur);
		enregistreur = enregistreur1;
	}

	/**
	 * Permet d'ex�cuter l'enregistrement de la commande supprimer
	 */
	@Override
	public void execute() {
		enregistreur.enregistrer(this);
		super.execute();
	}

	/**
	 * Permet de retourner un m�mento supprimer
	 */
	@Override
	public Memento getMemento() {
		return new MementoSupprimer();
	}

	/**
	 * Permet de changer le contenu  d'un m�mento supprimer
	 */
	@Override
	public void setMemento(Memento memento) {
		super.execute();
	}

}
