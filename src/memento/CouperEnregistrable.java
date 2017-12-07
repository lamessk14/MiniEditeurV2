package memento;

import java.util.Arrays;
import java.util.List;

import receiver.MoteurEditeurImplem;
import command.Couper;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class CouperEnregistrable extends Couper implements CommandEnregistrable {
	
private Caretaker enregistreur;
	/**
	 * 
	 * @param moteur
	 * @param enregistreur1
	 */
	public CouperEnregistrable(MoteurEditeurImplem moteur, Caretaker enregistreur1) {
		super(moteur);
		enregistreur = enregistreur1;
	}

	/**
	 * Permet d'exécuter l'enregistrement de la commande couper
	 */
	@Override
	public void execute() {
		enregistreur.enregistrer(this);
		super.execute();
	}

	/**
	 * Permet de retourner un mémento couper
	 */
	@Override
	public Memento getMemento() {
		MementoCouper memento = new MementoCouper();
		memento.setEtat(Integer.toString(moteur.getSelectionDebut())+","+Integer.toString(moteur.getSelectionFin()));
		return memento;
	}

	/**
	 * Permet de changer le contenu  d'un mémento coller
	 */
	@Override
	public void setMemento(Memento memento) {
		String selection = ((MementoCouper) memento).getEtat();
		List<String> items = Arrays.asList(selection.split(","));
		moteur.selectionner( Integer.parseInt(items.get(0)),Integer.parseInt(items.get(1)));
		super.execute();
	}

}
