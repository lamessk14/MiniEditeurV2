package memento;

import receiver.MoteurEditeurImplem;
import command.InsererTxt;
import invoker.MyIHM;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class InsererTxtEnregistrable extends InsererTxt implements CommandEnregistrable {

private Caretaker enregistreur;
	
/**
 * 
 * @param moteur
 * @param ihm
 * @param enregistreur1
 */
	public InsererTxtEnregistrable(MoteurEditeurImplem moteur, MyIHM ihm, Caretaker enregistreur1) {
		super(moteur, ihm);
		enregistreur = enregistreur1;
	}

	/**
	 * Permet d'exécuter l'enregistrement de la commande insererTxt
	 */
	@Override
	public void execute() {
		enregistreur.enregistrer(this);
		super.execute();
	}

	/**
	 * Permet de retourner un mémento insererTxt
	 */
	@Override
	public Memento getMemento() {
		MementoInsererTxt memento = new MementoInsererTxt();
		memento.setEtat(Character.toString(ihm.getDernierCharactere()));
		return memento;
	}

	/**
	 * Permet de changer le contenu  d'un mémento insererTxt
	 */
	@Override
	public void setMemento(Memento memento) {
		char t = ((MementoInsererTxt) memento).getEtat().charAt(0);
		moteur.insererTxt(t);
	}
}
