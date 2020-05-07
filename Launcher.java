import Controleur.*;
import Modele.Modele_Jeu;
import Vue.Vue_Jeu;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.lang.Object.*;
import java.awt.event.MouseListener;

public class Launcher implements Runnable{

	public void run(){
		JFrame fenetre = new JFrame("Ma fenetre a moi");
		Modele_Jeu jeu = new Modele_Jeu();
		jeu.getPlateau().ajouterJoueur("albert", 01);
		jeu.getPlateau().ajouterJoueur("Francis", 02);
		jeu.getPlateau().getJoueursIndice(0).ajouterPingouin(2,02);
		jeu.getPlateau().getJoueursIndice(1).ajouterPingouin(2,03);
		Vue_Jeu aire = new Vue_Jeu(jeu);
		fenetre.add(aire);
		fenetre.addMouseListener(new Controleur_Souris(aire));
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// On fixe la taille et on demarre
		fenetre.setSize(500, 500);
		fenetre.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Launcher());
	}
}
