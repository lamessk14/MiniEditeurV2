package command;

import receiver.MoteurEditeurImplem;

public class Supprimer implements Command {
	private MoteurEditeurImplem moteur;

	public Supprimer(MoteurEditeurImplem moteur1) {
		this.moteur = moteur1;
	}

	@Override
	public void execute() {
		moteur.supprimer();
	}

}
