package memento;

import receiver.MoteurEditeurImplem;
import command.Coller;

public class CollerEnregistrable extends Coller implements CommandEnregistrable {
	
private Caretaker enregistreur;
	
	public CollerEnregistrable(MoteurEditeurImplem moteur, Caretaker enregistreur1) {
		super(moteur);
		enregistreur = enregistreur1;
	}

	@Override
	public void execute() {
		enregistreur.enregistrer(this);
		super.execute();
	}

	@Override
	public Memento getMemento() {
		return new MementoColler();
	}

	@Override
	public void setMemento(Memento memento) {
		super.execute();
	}

}
