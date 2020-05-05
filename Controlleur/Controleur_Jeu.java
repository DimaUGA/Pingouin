package Controleur;

import Modele.Modele_Jeu;
import Vue.Vue_Jeu;

public class Controleur_Jeu {
	private Modele_Jeu mod_jeu;
	private Vue_Jeu vue_jeu;

	public Controleur_Jeu(Modele_Jeu mj, Vue_Jeu vj) {
		this.mod_jeu = mj;
		this.vue_jeu = vj;
	}
	
	public void start() {
		
		this.vue_jeu.Affiche_tableau(this.mod_jeu.getPlateau());
	}
	
	
	
	
}
