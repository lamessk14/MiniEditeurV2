package command;

import memento.Caretaker;

public class Arreter implements Command {

	private Caretaker enregistreur;

	public Arreter(Caretaker enregistreur1) {
		enregistreur = enregistreur1;
	}
	
	@Override
	public void execute() {
		enregistreur.arreterEnregistrement();
	}
}
