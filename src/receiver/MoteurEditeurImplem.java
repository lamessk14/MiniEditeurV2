package receiver;

import java.util.ArrayList;
import observer.Observer;
import observer.Subject;

/**
 * 
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
	
	public String getTexte(){
		return buffer.getTexte(0, buffer.getLongueurTexte());
	}
	
	public String getPressePapierTexte(){
		return pp.getTexte();
	}
	
	public int getSelectionDebut(){
		return sel.getDebutSelection();
	}
	
	public int getSelectionFin(){
		return sel.getFinSelection();
	}
	
	@Override
	public void selectionner(int debutSelection, int finSelection) {
		sel.setDebutSelection(debutSelection);
		sel.setFinSelection(finSelection);
	}

	@Override
	public void copier() {
		if(sel.getLongueurSelection() > 0){
			pp.setTexte(buffer.getTexte(sel.getDebutSelection(), sel.getFinSelection()));
		}
	}

	@Override
	public void couper() {
		
		if(sel.getLongueurSelection() > 0){
			pp.setTexte(buffer.getTexte(sel.getDebutSelection(), sel.getFinSelection()));
			buffer.delete(sel.getDebutSelection(), sel.getFinSelection());
			selectionner(sel.getDebutSelection(),sel.getDebutSelection());
			
			notifyObservers();
		}
	}

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
	public void insererTxt(char t) {
		if(sel.getLongueurSelection() > 0){
			buffer.delete(sel.getDebutSelection(), sel.getFinSelection());
			selectionner(sel.getDebutSelection(),sel.getDebutSelection());
		}
		buffer.modifier(sel.getDebutSelection(), Character.toString(t));
		selectionner(sel.getDebutSelection()+1,sel.getDebutSelection()+1);

		notifyObservers();
	}
	
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
	public void notifyObservers() {
		for(Observer o : getObservers()){
			o.notifyMe();
		}
	}

	@Override
	public void registerObserver(Observer o) {
		getObservers().add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		getObservers().remove(o);
	}

}