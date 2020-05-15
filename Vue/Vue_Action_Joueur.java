package Vue;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controleur.Controleur_Action_Joueur;

public class Vue_Action_Joueur extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -988378922948738738L;

	public static final String VALIDER = "VALIDER";
	public static final String SAUVEGARDER = "SAUVEGARDER";
	public static final String AIDE = "AIDE";
	public static final String QUITTER = "QUITTER";


    JButton boutonValider = new JButton(VALIDER);
    JButton boutonAide = new JButton(AIDE);
    JButton boutonSauvegarder = new JButton(SAUVEGARDER);
    JButton boutonQuitter = new JButton(QUITTER);
	
	public Vue_Action_Joueur() {
		boutonValider.setName(VALIDER);
		boutonSauvegarder.setName(SAUVEGARDER);
		boutonQuitter.setName(QUITTER);
		boutonAide.setName(AIDE);
		this.setBackground(Color.DARK_GRAY);
	    afficher_bouton();
	    
	}
	
	public void afficher_bouton(){
		        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		        this.add(boutonAide);
		        this.add(boutonValider);
		        this.add(boutonSauvegarder);
		        this.add(boutonQuitter);
	
    }

	public void ajouterlistenerquitter(MouseListener controleur_action_joueur) {
			this.boutonQuitter.addMouseListener(controleur_action_joueur);
			this.boutonSauvegarder.addMouseListener(controleur_action_joueur);
			this.boutonValider.addMouseListener(controleur_action_joueur);
			this.boutonAide.addMouseListener(controleur_action_joueur);
	}
}
	