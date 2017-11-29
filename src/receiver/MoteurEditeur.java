package receiver;
import java.util.*;

import observer.Observer;

/**
 * 
 */
public interface MoteurEditeur {

    /**
     * 
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
     * 
     */
    public void insererTxt(char t);
    
    public void supprimer();
}