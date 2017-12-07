package receiver;
import java.util.*;

import observer.Observer;

/**
 * @author Fanta COULIBALY et Louise-Agnès MACKONGO
 */
public interface MoteurEditeur {

	/**
	 * Permet de sélectionner une chaîne de caractères
	 * @param debutSelection
	 * @param finSelection
	 */
    public void selectionner(int debutSelection, int finSelection);

    /**
     * 
     */
    public void copier();

    /**
     * 
     */
    public void coller();

    /**
     * 
     */
    public void couper();

    /**
     * Permet d'insérer du texte caractère par caractère
     * @param t
     */
    public void insererTxt(char t);
    
    public void supprimer();
}