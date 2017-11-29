package memento;

import java.util.Arrays;
import java.util.List;

import receiver.MoteurEditeurImplem;
import command.Couper;

public class CouperEnregistrable extends Couper implements CommandEnregistrable {
	
private Caretaker enregistreur;
	
	public CouperEnregistrable(MoteurEditeurImplem moteur, Caretaker enregistreur1) {
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
		MementoCouper memento = new MementoCouper();
		memento.setEtat(Integer.toString(moteur.getSelectionDebut())+","+Integer.toString(moteur.getSelectionFin()));
		return memento;
	}

	@Override
	public void setMemento(Memento memento) {
		String selection = ((MementoCouper) memento).getEtat();
		List<String> items = Arrays.asList(selection.split(","));
		moteur.selectionner( Integer.parseInt(items.get(0)),Integer.parseInt(items.get(1)));
		super.execute();
	}

}
