package receiver;

import java.util.*;

/**
 * @author Fanta COULIBALY et Louise-Agn�s MACKONGO
 */
public class Buffer {

	/**
	 * Cr�ation d'une variable de type StringBuffer pour des questions de
	 * performance et de rapidit�
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
	 * @return la longueur de la cha�ne de caract�res contenue dans le buffer
	 */
	public int getLongueurTexte() {
		return buff.length();
	}


	/**
	 * Permet de s�lectionner une partie d'une cha�ne de caract�res
	 * @param debutSelection
	 * @param finSelection
	 * @return la s�lection contenue dans le buffer
	 */
	public String getTexte(int debutSelection, int finSelection) {
		return buff.substring(debutSelection, finSelection);
	}
	
	/**
	 * Permet de supprimer une s�lection
	 * @param debutSelection
	 * @param finSelection
	 */
	public void delete(int debutSelection, int finSelection){
        buff.delete(debutSelection, finSelection);
    }

	/**
	 * Permet de modifier une cha�ne de caract�res
	 * @param position
	 * @param texte
	 */
	public void modifier(int position, String texte) {
		buff.insert(position, texte);
	}

}