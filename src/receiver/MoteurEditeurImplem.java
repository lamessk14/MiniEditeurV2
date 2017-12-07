package receiver;

import java.util.ArrayList;
import observer.Observer;
import observer.Subject;

/**
 * @author Fanta COULIBALY et Louise-Agnès MACKONGO
 */
public class MoteurEditeurImplem extends Subject implements MoteurEditeur {
	
	private Buffer buffer;
	private Selection sel;
	private PressePapier pp;

	/**
	 * Default constructor
	 */
	public MoteurEditeurImplem() {
		buffer = new Buffer();
		sel = new Selection();
		pp = new PressePapier();
		setObservers(new ArrayList<Observer>());
	}
	/**
	 * 
	 * @return la longueur de la chaîne de caractères contenue dans le buffer
	 */
	public String getTexte(){
		return buffer.getTexte(0, buffer.getLongueurTexte());
	}
	
	/**
	 * 
	 * @return le contenu du presse-papiers
	 */
	public String getPressePapierTexte(){
		return pp.getTexte();
	}
	
	/**
	 * 
	 * @return la position du début d'une sélection
	 */
	public int getSelectionDebut(){
		return sel.getDebutSelection();
	}
	
	/**
	 * 
	 * @return la position de la fin d'une sélection
	 */
	public int getSelectionFin(){
		return sel.getFinSelection();
	}
	
	/**
	 * Permet de sélectionner une chaîne de caractères 
	 */
	@Override
	public void selectionner(int debutSelection, int finSelection) {
		sel.setDebutSelection(debutSelection);
		sel.setFinSelection(finSelection);
	}

	/**
	 * Permet de copier une sélection 
	 */
	@Override
	public void copier() {
		if(sel.getLongueurSelection() > 0){
			pp.setTexte(buffer.getTexte(sel.getDebutSelection(), sel.getFinSelection()));
		}
	}

	/**
	 * Permet de couper une sélection non vide. Le contenu du buffer est ainsi supprimé.
	 */
	@Override
	public void couper() {
		
		if(sel.getLongueurSelection() > 0){
			pp.setTexte(buffer.getTexte(sel.getDebutSelection(), sel.getFinSelection()));
			buffer.delete(sel.getDebutSelection(), sel.getFinSelection());
			selectionner(sel.getDebutSelection(),sel.getDebutSelection());
			
			notifyObservers();
		}
	}
	
	/**
	 * Permet de coller une sélection non vide. Le contenu du buffer est ainsi modifié.
	 */
	@Override
	public void coller() {
		if(sel.getLongueurSelection() > 0){
			buffer.delete(sel.getDebutSelection(), sel.getFinSelection());
			selectionner(sel.getDebutSelection(), sel.getDebutSelection());
		}
		buffer.modifier(sel.getDebutSelection(), pp.getTexte());
		int select = sel.getDebutSelection() + pp.getLongueurSelection();
		selectionner(select, select);
		
		notifyObservers();
	}

	@Override
	/**
	 * @param : char t
	 * permet d'insérer un texte dans l'éditeur caractère par caractère
	 */
	public void insererTxt(char t) {
		if(sel.getLongueurSelection() > 0){
			buffer.delete(sel.getDebutSelection(), sel.getFinSelection());
			selectionner(sel.getDebutSelection(),sel.getDebutSelection());
		}
		buffer.modifier(sel.getDebutSelection(), Character.toString(t));
		selectionner(sel.getDebutSelection()+1,sel.getDebutSelection()+1);

		notifyObservers();
	}

/**
 * Suppression d'une sélection
 */
	public void supprimer() {
		if(sel.getLongueurSelection() > 0){
			buffer.delete(sel.getDebutSelection(), sel.getFinSelection());
			selectionner(sel.getDebutSelection(), sel.getDebutSelection());
		} else if(sel.getDebutSelection() > 0){
			buffer.delete(sel.getDebutSelection()-1, sel.getDebutSelection());
			selectionner(sel.getDebutSelection()-1,sel.getDebutSelection()-1);
		}
		notifyObservers();
	}
	
	@Override
	/**
	 * Notification des observers
	 */
	public void notifyObservers() {
		for(Observer o : getObservers()){
			o.notifyMe();
		}
	}

	@Override
	/**
	 * Ajout d'un observer
	 */
	public void registerObserver(Observer o) {
		getObservers().add(o);
	}

	@Override
	/**
	 * Suppression d'un observer
	 */
	public void removeObserver(Observer o) {
		getObservers().remove(o);
	}

}