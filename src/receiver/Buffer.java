package receiver;

import java.util.*;

/**
 * 
 */
public class Buffer {

	// Cr�ation d'une variable de type StringBuffer pour des questions de
	// performance et de rapidit�
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

	//Permet de s�lectionner une partie d'une cha�ne de caract�res
	public String getTexte(int debutSelection, int finSelection) {
		return buff.substring(debutSelection, finSelection);
	}
	
	//Permet de supprimer une s�lection
	public void delete(int debutSelection, int finSelection){
        buff.delete(debutSelection, finSelection);
    }

	// Permet de modifier une cha�ne de caract�res
	public void modifier(int position, String texte) {
		buff.insert(position, texte);
	}

}