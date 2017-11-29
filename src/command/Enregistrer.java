package command;

import memento.Caretaker;

public class Enregistrer implements Command {
	
	private Caretaker enregistreur;
	
	public Enregistrer(Caretaker enregistreur1) {
		enregistreur = enregistreur1;
	}
	
	@Override
	public void execute() {
		enregistreur.commencerEnregistrement();
	}

}