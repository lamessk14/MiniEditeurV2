package receiver;
import java.util.*;

/**
 * @author Fanta COULIBALY et Louise-Agnès MACKONGO
 */
public class PressePapier {

	/**
	 * Déclaration de la variable texte qui contiendra un contenu copié ou coupé
	 */
	
	private String texte;
    /**
     * Constructeur
     */
    public PressePapier() {
    	texte ="";
    }
    
    /**
     * Getter
     * @return une chaîne de caractères
     */
    public String getTexte(){
    	return texte;
    }
    
    /** 
     * @return la longueur du texte dans le presse-papier
     */
    public int getLongueurSelection(){
    	return texte.length();
    }
    
    /**
     * Setter
     * @param txt
     */
    public void setTexte(String txt){
    	texte = txt;
    }


}