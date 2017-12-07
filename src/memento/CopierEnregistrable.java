package memento;

import receiver.MoteurEditeurImplem;
import command.Copier;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
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
	 * Permet d'ex�cuter l'enregistrement de la commande copier
	 */
	@Override
	public void execute() {
		enregistreur.enregistrer(this);
		super.execute();
	}

	/**
	 * Permet de retourner un m�mento copier
	 */
	@Override
	public Memento getMemento() {
		return new MementoCopier();
	}

	/**
	 * Permet de changer le contenu  d'un m�mento copier
	 */
	@Override
	public void setMemento(Memento memento) {
		super.execute();
	}
}
