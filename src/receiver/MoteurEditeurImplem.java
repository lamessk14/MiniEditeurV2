package receiver;

import java.util.ArrayList;
import observer.Observer;
import observer.Subject;

/**
 * @author Fanta COULIBALY et Louise-Agn�s MACKONGO
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
	 * @return la longueur de la cha�ne de caract�res contenue dans le buffer
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
	 * @return la position du d�but d'une s�lection
	 */
	public int getSelectionDebut(){
		return sel.getDebutSelection();
	}
	
	/**
	 * 
	 * @return la position de la fin d'une s�lection
	 */
	public int getSelectionFin(){
		return sel.getFinSelection();
	}
	
	/**
	 * Permet de s�lectionner une cha�ne de caract�res 
	 */
	@Override
	public void selectionner(int debutSelection, int finSelection) {
		sel.setDebutSelection(debutSelection);
		sel.setFinSelection(finSelection);
	}

	/**
	 * Permet de copier une s�lection 
	 */
	@Override
	public void copier() {
		if(sel.getLongueurSelection() > 0){
			pp.setTexte(buffer.getTexte(sel.getDebutSelection(), sel.getFinSelection()));
		}
	}

	/**
	 * Permet de couper une s�lection non vide. Le contenu du buffer est ainsi supprim�.
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
	 * Permet de coller une s�lection non vide. Le contenu du buffer est ainsi modifi�.
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
	 * permet d'ins�rer un texte dans l'�diteur caract�re par caract�re
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
 * Suppression d'une s�lection
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