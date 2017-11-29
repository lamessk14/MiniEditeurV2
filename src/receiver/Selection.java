package receiver;

import java.util.*;

/**
 * 
 */
public class Selection {

	// Déclaration des variables debut_selection et fin selection
	private int debut_selection;
	private int fin_selection;

	/**
	 * Constructeur
	 */
	public Selection() {
		debut_selection = 0;
		fin_selection = 0;
	}

	// Getters
	public int getDebutSelection() {
		return debut_selection;
	}

	public int getFinSelection() {
		return fin_selection;
	}
	/**
	 * 
	 * @return la longueur d'une sélection
	 */
	public int getLongueurSelection(){
		return fin_selection-debut_selection ;
	}

	//Setters
	public void setDebutSelection(int debut) {
		debut_selection = debut;
	}

	public void setFinSelection(int fin) {
		fin_selection = fin;
	}

}