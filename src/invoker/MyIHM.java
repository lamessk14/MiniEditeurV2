package invoker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import command.Command;

import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class MyIHM extends JFrame {

	private JFrame frame;
	private JPanel contentPaneMiniEditeur;
	protected TextArea zoneDeSaisie;
	protected BoutonsCommand couper;
	protected BoutonsCommand copier;
	protected BoutonsCommand coller;

	/**
	 * Create the frame.
	 */
	public MyIHM() {
		frame = new JFrame("Mini-EditeurV1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 400);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		/*  JMenuBar menuBarMiniEdit = new JMenuBar();
		menuBarMiniEdit.setToolTipText("");
		setJMenuBar(menuBarMiniEdit);
		
		JButton btnCopier = new JButton("Copier");
		menuBarMiniEdit.add(btnCopier);
		
		JButton btnColler = new JButton("Coller");
		menuBarMiniEdit.add(btnColler);
		
		JButton btnCouper = new JButton("Couper");
		btnCouper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuBarMiniEdit.add(btnCouper);
		contentPaneMiniEditeur = new JPanel();
		contentPaneMiniEditeur.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneMiniEditeur.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPaneMiniEditeur);
		
		JTextArea textAreazoneDeSaisie = new JTextArea();
		textAreazoneDeSaisie.setTabSize(5);
		textAreazoneDeSaisie.setRows(5);
		textAreazoneDeSaisie.setText("");
		contentPaneMiniEditeur.add(textAreazoneDeSaisie, BorderLayout.CENTER);*/
	}
	
	public void initComposants(HashMap<String,Command> commandes){
		zoneDeSaisie = new TextArea(commandes);
		couper = Bouton("Couper", commandes.get("couper"));
		copier = Bouton("Copier", commandes.get("copier"));
		coller = Bouton("Coller", commandes.get("coller"));
		
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
							.addComponent(coller, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

	private BoutonsCommand Bouton(String nom, Command commande) {
		BoutonsCommand boutonsCommand = new BoutonsCommand(nom, commande);
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
	
	public Command getCommand(String nom) {
		if(nom == "couper"){
			return couper.getCommand();
		} else if (nom == "copier"){
			return copier.getCommand();
		} else if (nom == "coller"){
			return coller.getCommand();
		} else {
			return null;
		}
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