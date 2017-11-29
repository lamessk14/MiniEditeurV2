package memento;

import receiver.MoteurEditeurImplem;
import command.Supprimer;

public class SupprimerEnregistrable extends Supprimer implements CommandEnregistrable {
	
private Caretaker enregistreur;
	
	public SupprimerEnregistrable(MoteurEditeurImplem moteur, Caretaker enregistreur1) {
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
		return new MementoSupprimer();
	}

	@Override
	public void setMemento(Memento memento) {
		super.execute();
	}

}
