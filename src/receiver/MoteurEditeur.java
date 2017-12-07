package receiver;
import java.util.*;

import observer.Observer;

/**
 * @author Fanta COULIBALY et Louise-Agn�s MACKONGO
 */
public interface MoteurEditeur {

	/**
	 * Permet de s�lectionner une cha�ne de caract�res
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
     * Permet d'ins�rer du texte caract�re par caract�re
     * @param t
     */
    public void insererTxt(char t);
    
    public void supprimer();
}