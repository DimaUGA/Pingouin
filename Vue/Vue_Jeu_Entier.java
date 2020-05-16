package Vue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controleur.Controleur_Jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Map;
import java.awt.FlowLayout;

public class Vue_Jeu_Entier {

	private JFrame frame;
	Vue_Plateau vj;

	JPanel panel_2 = new JPanel();
	JPanel panel_3 = new JPanel();
	JPanel panel_4 = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel panel = new JPanel();
	static DefaultTableModel model = new DefaultTableModel(new Object[] { "Key", "Value" }, 0);

	public Vue_Jeu_Entier() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(0, 0, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][][][][grow][][grow]", "[grow][][][grow][grow]"));

	}

	public void ajouter_plateau(Vue_Plateau vue_Plateau) {
		panel.add(vue_Plateau, "cell 3 2 5 3,grow");
	}

	public void ajouter_score(Map<String, Integer> score) {
		/*
		 * JPanel j = new JPanel(); j.add(new JLabel()); j.add(new JLabel());
		 * panel.add(, "cell 0 1 1 1,grow");
		 */
	}

	public void ajouter_action_joueur(Vue_Action_Joueur vaj) {
		panel.add(vaj, "cell 0 2 2 4,grow");
	}

	public void ajouter_historique(Vue_Historique vh) {
		panel.add(vh, "cell 0 0 3 1,grow");
	}

	public void ajouter_regle(Vue_Regles vr) {
		panel.add(vr, "cell 0 0 3 1,grow");
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void addlistener(Controleur_Jeu controleur_Jeu) {
		this.frame.getContentPane().addMouseMotionListener(controleur_Jeu);
		this.panel.addMouseMotionListener(controleur_Jeu);
		this.panel_1.addMouseMotionListener(controleur_Jeu);
		this.panel_2.addMouseMotionListener(controleur_Jeu);
		this.panel_3.addMouseMotionListener(controleur_Jeu);
		this.panel_4.addMouseMotionListener(controleur_Jeu);

	}

	public void updateScore(Map<String, Integer> scoreJoueur) {
		panel.remove(4);
		scoreJoueur.forEach((key, value) -> System.out.println("Key : " + key + " Value : " + value));
	}
}
