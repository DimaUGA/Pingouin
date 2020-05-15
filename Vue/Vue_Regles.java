package Vue;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vue_Regles extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5882011070841676210L;
	public static final String REGLES = "REGLES";
	public static final String TOURJOUEUR = "TOURJOUEUR";
	public static final String NOMJOUEUR = "NOMJOUEUR";


    JButton boutonRegles = new JButton(REGLES);
    JLabel tourJoueur = new JLabel("C'est à ton tour : ");
    JLabel nomJoueur = new JLabel(" Joueur 1 ");

	
	public Vue_Regles() {
		boutonRegles.setName(REGLES);
		tourJoueur.setName(TOURJOUEUR);
		nomJoueur.setName(NOMJOUEUR);
	    afficher_item();

		this.setBackground(Color.DARK_GRAY);
	}
	
	public void afficher_item(){
		this.add(tourJoueur);
		this.add(nomJoueur);
		this.add(boutonRegles);
	
    }

	public void ajouterlistenerquitter(MouseListener controleur_regles) {
			this.boutonRegles.addMouseListener(controleur_regles);
	}

	public JLabel getLabelNom() {
		return this.nomJoueur;
	}
}
