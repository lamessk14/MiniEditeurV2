package receiver;

import java.util.*;

/**
 * 
 */
public class Buffer {

	// Création d'une variable de type StringBuffer pour des questions de
	// performance et de rapidité
	private StringBuffer buff;

	/**
	 * Constructeur
	 */
	public Buffer() {
		buff = new StringBuffer();
	}

	// Getters
	public int getLongueurTexte() {
		return buff.length();
	}

	//Permet de sélectionner une partie d'une chaîne de caractères
	public String getTexte(int debutSelection, int finSelection) {
		return buff.substring(debutSelection, finSelection);
	}
	
	//Permet de supprimer une sélection
	public void delete(int debutSelection, int finSelection){
        buff.delete(debutSelection, finSelection);
    }

	// Permet de modifier une chaîne de caractères
	public void modifier(int position, String texte) {
		buff.insert(position, texte);
	}

}