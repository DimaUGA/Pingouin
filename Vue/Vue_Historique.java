package Vue;

import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Vue_Historique extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7460074468154053774L;


	public static final String HISTORIQUE = "HISTORIQUE";


    JButton boutonHistorique = new JButton(HISTORIQUE);
	
	public Vue_Historique() {
		boutonHistorique.setName(HISTORIQUE);
	    afficher_bouton();
		this.setBackground(Color.DARK_GRAY);
	}
	
	public void afficher_bouton(){
		        this.add(boutonHistorique);
    }

	public void ajouterlistenerquitter(MouseListener controleur_Histo) {
			this.boutonHistorique.addMouseListener(controleur_Histo);
	}

}
	