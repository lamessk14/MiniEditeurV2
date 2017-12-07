package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import command.Command;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

@SuppressWarnings("serial")
public class BoutonsCommand extends JButton {

	private String nom;
	private Command commande;
/**
 * 
 * @param nomCommande
 * @param commande1
 */
	public BoutonsCommand(String nomCommande, final Command commande1) {
			super(nomCommande);
			nom = nomCommande;
			commande = commande1;
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					commande.execute();
				}
			});
		}
/**
 * 
 * @return le nom d'une commande
 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @return une commande(copier, coller, couper)
	 */
	public Command getCommand() {
		return commande;
	}

}