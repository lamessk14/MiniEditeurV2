package observer;

import java.util.Collection;

public abstract class Subject {
	private Collection<Observer> observers;

	public abstract void registerObserver(Observer observer);

	public abstract void removeObserver(Observer observer);

	public abstract void notifyObservers();

	public Collection<Observer> getObservers() {
		return observers;
	}

	public void setObservers(Collection<Observer> observers) {
		this.observers = observers;
	}
}