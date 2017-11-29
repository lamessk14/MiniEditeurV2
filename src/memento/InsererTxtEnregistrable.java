package memento;

import receiver.MoteurEditeurImplem;
import command.InsererTxt;
import invoker.MyIHM;

public class InsererTxtEnregistrable extends InsererTxt implements CommandEnregistrable {

private Caretaker enregistreur;
	
	public InsererTxtEnregistrable(MoteurEditeurImplem moteur, MyIHM ihm, Caretaker enregistreur1) {
		super(moteur, ihm);
		enregistreur = enregistreur1;
	}

	@Override
	public void execute() {
		enregistreur.enregistrer(this);
		super.execute();
	}

	@Override
	public Memento getMemento() {
		MementoInsererTxt memento = new MementoInsererTxt();
		memento.setEtat(Character.toString(ihm.getDernierCharactere()));
		return memento;
	}

	@Override
	public void setMemento(Memento memento) {
		char c = ((MementoInsererTxt) memento).getEtat().charAt(0);
		moteur.insererTxt(c);
	}
}
