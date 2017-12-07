package invoker;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import command.Command;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
@SuppressWarnings("serial")
public class TextArea extends JTextArea {

	/**
	 * Déclaration des variables
	 */
	private int debutSelection;
	private int finSelection;
	private char dernierChar;
	private Command selectionner;
	private Command inserer;
	private Command supprimer;

	/**
	 * Initialisation des différentes commandes + mise à jour des positions de 
	 * début et de fin de sélection en cas de sélection, d'insertion ou de suppression
	 * @param commandes
	 */
	public TextArea(HashMap<String, Command> commandes) {

		debutSelection = 0;
		finSelection = 0;
		selectionner = commandes.get("selectionner");
		inserer = commandes.get("insererTxt");
		supprimer = commandes.get("supprimer");

		setRows(20);
		setColumns(40);

		addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				int debut = Math.min(e.getDot(), e.getMark());
				int fin = Math.max(e.getDot(), e.getMark());
				if (debut != debutSelection || fin != finSelection) {
					setSelection(debut, fin);
					selectionner.execute();
				}
			}

		});

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				e.consume();
				char keyChar = e.getKeyChar();
				if (keyChar != '\b') {
					dernierChar = keyChar;
					inserer.execute();
				}
			}
	
			public void keyPressed(KeyEvent e) {
				if (!e.isActionKey()) {
					e.consume();
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						supprimer.execute();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	/**
	 * Modification d'une sélection
	 * 
	 * @param debutSelection1
	 * @param finSelection1
	 */
	public void setSelection(int debutSelection1, int finSelection1) {
		debutSelection = debutSelection1;
		finSelection = finSelection1;
	}

	/**
	 * Retourne les commandes associées aux noms donnés en paramètre
	 * 
	 * @param nom
	 * @return
	 */
	public Command getCommand(String nom) {
		if (nom == "selectionner") {
			return selectionner;
		} else if (nom == "inserer") {
			return inserer;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @return le dernier caractère
	 */
	public char getDernierCharactere() {
		return dernierChar;
	}
	
	/**
	 * Permet de changer le dernier caractère
	 * @param t
	 */
	
	public void setDernierCharactere(char t) {
		dernierChar = t;
	}

	/**
	 * 
	 * @param texte
	 * @param debutSelection1
	 * @param finSelection1
	 */
	public void MAJ(String texte, int debutSelection1, int finSelection1) {
		setText(texte);
		setSelectionStart(debutSelection1);
		setSelectionEnd(finSelection1);
		setSelection(debutSelection1, finSelection1);
		requestFocusInWindow();
	}

}