package memento;

import receiver.MoteurEditeurImplem;
import command.Copier;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class CopierEnregistrable extends Copier implements CommandEnregistrable {

private Caretaker enregistreur;
	
/**
 * 
 * @param moteur
 * @param enregistreur1
 */
	public CopierEnregistrable(MoteurEditeurImplem moteur, Caretaker enregistreur1) {
		super(moteur);
		enregistreur = enregistreur1;
	}

	/**
	 * Permet d'exécuter l'enregistrement de la commande copier
	 */
	@Override
	public void execute() {
		enregistreur.enregistrer(this);
		super.execute();
	}

	/**
	 * Permet de retourner un mémento copier
	 */
	@Override
	public Memento getMemento() {
		return new MementoCopier();
	}

	/**
	 * Permet de changer le contenu  d'un mémento copier
	 */
	@Override
	public void setMemento(Memento memento) {
		super.execute();
	}
}
