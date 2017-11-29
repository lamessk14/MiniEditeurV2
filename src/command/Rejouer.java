package command;

import memento.Caretaker;

public class Rejouer implements Command {
	
	private Caretaker enregistreur;
	
	public Rejouer(Caretaker enregistreur1) {
		enregistreur = enregistreur1;
	}
	
	@Override
	public void execute() {
		enregistreur.rejouer();
	}
}