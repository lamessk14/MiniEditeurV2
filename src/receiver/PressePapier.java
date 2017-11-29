package receiver;
import java.util.*;

/**
 * 
 */
public class PressePapier {

	//Déclaration de la variable texte qui contiendra un contenu copié ou coupé
	
	private String texte;
    /**
     * Constructeur
     */
    public PressePapier() {
    	texte ="";
    }
    
    //Getter
    public String getTexte(){
    	return texte;
    }
    
    //Retourne la longueur du texte dans le presse-papier
    public int getLongueurSelection(){
    	return texte.length();
    }
    
    //Setter
    public void setTexte(String txt){
    	texte = txt;
    }


}