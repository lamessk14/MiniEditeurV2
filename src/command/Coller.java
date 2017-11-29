package command;
import java.util.*;
import receiver.MoteurEditeurImplem;


public class Coller implements Command {
	
	//Déclaration de variables
	private MoteurEditeurImplem moteur;

    /**
     * Constructeur
     */
    public Coller(MoteurEditeurImplem moteur1) {
    	moteur = moteur1;
    }

    /**
     * 
     */
    @Override
    public void execute() {
        moteur.coller();
    }

}