package receiver;

import java.util.*;

/**
 * @author Fanta COULIBALY et Louise-Agnès MACKONGO
 */
public class Buffer {

	/**
	 * Création d'une variable de type StringBuffer pour des questions de
	 * performance et de rapidité
	 */
	private StringBuffer buff;

	/**
	 * Constructeur
	 */
	public Buffer() {
		buff = new StringBuffer();
	}

	/**
	 * 
	 * @return la longueur de la chaîne de caractères contenue dans le buffer
	 */
	public int getLongueurTexte() {
		return buff.length();
	}


	/**
	 * Permet de sélectionner une partie d'une chaîne de caractères
	 * @param debutSelection
	 * @param finSelection
	 * @return la sélection contenue dans le buffer
	 */
	public String getTexte(int debutSelection, int finSelection) {
		return buff.substring(debutSelection, finSelection);
	}
	
	/**
	 * Permet de supprimer une sélection
	 * @param debutSelection
	 * @param finSelection
	 */
	public void delete(int debutSelection, int finSelection){
        buff.delete(debutSelection, finSelection);
    }

	/**
	 * Permet de modifier une chaîne de caractères
	 * @param position
	 * @param texte
	 */
	public void modifier(int position, String texte) {
		buff.insert(position, texte);
	}

}