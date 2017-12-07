package receiver;
import java.util.*;

/**
 * @author Fanta COULIBALY et Louise-Agn�s MACKONGO
 */
public class PressePapier {

	/**
	 * D�claration de la variable texte qui contiendra un contenu copi� ou coup�
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
     * @return une cha�ne de caract�res
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