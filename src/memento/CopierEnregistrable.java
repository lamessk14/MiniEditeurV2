package memento;

import receiver.MoteurEditeurImplem;
import command.Copier;

public class CopierEnregistrable extends Copier implements CommandEnregistrable {

private Caretaker enregistreur;
	
	public CopierEnregistrable(MoteurEditeurImplem moteur, Caretaker enregistreur1) {
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
		return new MementoCopier();
	}

	@Override
	public void setMemento(Memento memento) {
		super.execute();
	}
}
