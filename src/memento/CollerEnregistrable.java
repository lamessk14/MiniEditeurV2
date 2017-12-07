package memento;

import receiver.MoteurEditeurImplem;
import command.Coller;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */
public class CollerEnregistrable extends Coller implements CommandEnregistrable {
	
private Caretaker enregistreur;
	
/**
 * 
 * @param moteur
 * @param enregistreur1
 */
	public CollerEnregistrable(MoteurEditeurImplem moteur, Caretaker enregistreur1) {
		super(moteur);
		enregistreur = enregistreur1;
	}

	/**
	 * Permet d'ex�cuter l'enregistrement de la commande coller
	 */
	@Override
	public void execute() {
		enregistreur.enregistrer(this);
		super.execute();
	}

	/**
	 * Permet de retourner un m�mento coller
	 */
	@Override
	public Memento getMemento() {
		return new MementoColler();
	}

	/**
	 * Permet de changer le contenu  d'un m�mento coller
	 */
	@Override
	public void setMemento(Memento memento) {
		super.execute();
	}

}
