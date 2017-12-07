package observer;

import java.util.Collection;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public abstract class Subject {
	private Collection<Observer> observers;
/**
 * 
 * @param observer
 */
	public abstract void registerObserver(Observer observer);
/**
 * 
 * @param observer
 */
	public abstract void removeObserver(Observer observer);

	public abstract void notifyObservers();
/**
 * 
 * @return la liste des observers
 */
	public Collection<Observer> getObservers() {
		return observers;
	}
/**
 * 
 * @param observers
 */
	public void setObservers(Collection<Observer> observers) {
		this.observers = observers;
	}
}