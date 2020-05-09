package Controleur;

import Modele.Modele_Jeu;
import Modele.Modele_plateau;
import Vue.Vue_Jeu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controleur_Jeu {
	private Modele_Jeu mod_jeu;
	private Modele_plateau mod_plateau;
	private Vue_Jeu vue_jeu;
	private Controleur_Souris souris;

	public Controleur_Jeu(Modele_Jeu mj, Vue_Jeu vj) {
		this.mod_jeu = mj;
		this.vue_jeu = vj;
		this.mod_plateau = mj.getPlateau();
		temp();
		souris = new Controleur_Souris(vj,mod_plateau);
		vue_jeu.ajouterListener(new temp2());
	}

	public class temp2 implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent mouseEvent) {}

		@Override
		public void mousePressed(MouseEvent mouseEvent) {
			souris.sourisCliquee(mouseEvent);
		}

		@Override
		public void mouseReleased(MouseEvent mouseEvent) {}

		@Override
		public void mouseEntered(MouseEvent mouseEvent) {}

		@Override
		public void mouseExited(MouseEvent mouseEvent) {}
	}

	public void temp() {
		mod_jeu.getPlateau().ajouterJoueur("albert", 01);
		mod_jeu.getPlateau().ajouterJoueur("Francis", 02);
	}

}
