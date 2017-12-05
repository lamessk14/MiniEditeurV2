package invoker;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import command.Command;

public class MyIHM extends JFrame {

	// Déclaration des variables
	private JFrame frame;
	//private JPanel contentPaneMiniEditeur;
	protected TextArea zoneDeSaisie;
	protected BoutonsCommand couper;
	protected BoutonsCommand copier;
	protected BoutonsCommand coller;
	protected BoutonsCommand startEnregistrement;
	protected BoutonsCommand stopEnregistrement;
	protected BoutonsCommand playEnregistrement;

	/**
	 * Create the frame.
	 */
	public MyIHM() {
		frame = new JFrame("Mini-EditeurV2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 400);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
	}
	
	public void initComposants(HashMap<String,Command> commandes){
		zoneDeSaisie = new TextArea(commandes);
		couper = Bouton("Couper", commandes.get("couper"));
		copier = Bouton("Copier", commandes.get("copier"));
		coller = Bouton("Coller", commandes.get("coller"));
		startEnregistrement = Bouton("Enregistrer", commandes.get("enregistrer"));
		stopEnregistrement = Bouton("Arreter", commandes.get("arreter"));
		playEnregistrement = Bouton("Rejouer", commandes.get("rejouer"));
		
		GroupLayout glContentPane = new GroupLayout(frame.getContentPane());
		glContentPane.setHorizontalGroup(
				glContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, glContentPane.createSequentialGroup()
					.addGroup(glContentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(zoneDeSaisie, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addGroup(glContentPane.createSequentialGroup()
							.addComponent(couper, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(copier, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(coller, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(glContentPane.createSequentialGroup()
								.addComponent(startEnregistrement, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addGap(4)
								.addComponent(stopEnregistrement, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addGap(4)
								.addComponent(playEnregistrement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(0))
		);
		glContentPane.setVerticalGroup(
				glContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(glContentPane.createSequentialGroup()
					.addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(couper)
						.addComponent(copier)
						.addComponent(coller))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(startEnregistrement)
							.addComponent(stopEnregistrement)
							.addComponent(playEnregistrement))
						.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(zoneDeSaisie, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(glContentPane);
	}
	
	public void afficher(){
		frame.pack();
		frame.setLocationRelativeTo(null);
		zoneDeSaisie.requestFocusInWindow();
		frame.setVisible(true);
	}

	private BoutonsCommand Bouton(String nomCommande, Command commande) {
		BoutonsCommand boutonsCommand = new BoutonsCommand(nomCommande, commande);
		boutonsCommand.setMaximumSize(new Dimension(Short.MAX_VALUE, boutonsCommand.getPreferredSize().height));
		boutonsCommand.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		boutonsCommand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zoneDeSaisie.requestFocusInWindow();
			}
		});
		return boutonsCommand;
	}
	
	public Command getCommand(String nomCommande) {
		if(nomCommande == "couper"){
			return couper.getCommand();
		} else if (nomCommande == "copier"){
			return copier.getCommand();
		} else if (nomCommande == "coller"){
			return coller.getCommand();
		}else if (nomCommande == "enregistrer"){
			return startEnregistrement.getCommand();
		}else if (nomCommande == "arreter"){
			return stopEnregistrement.getCommand();
		}else if (nomCommande == "rejouer"){
			return playEnregistrement.getCommand();
		}else {
			return null;
		}
	}
	
	public void TextArea(HashMap<String,Command> commandes) {
		zoneDeSaisie = new TextArea(commandes);
	}
	
	public TextArea getTextArea() {
		return zoneDeSaisie;
	}

	
	public char getDernierCharactere() {
		return zoneDeSaisie.getDernierCharactere();
	}

	public int getDebutSelection() {
		return zoneDeSaisie.getSelectionStart();
	}
	
	public int getFinSelection(){
		return zoneDeSaisie.getSelectionEnd();
	}

}
