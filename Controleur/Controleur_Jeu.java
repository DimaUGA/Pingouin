package Controleur;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import Modele.Modele_Jeu;
import Modele.Modele_plateau;
import Vue.Vue_Action_Joueur;
import Vue.Vue_Historique;
import Vue.Vue_Jeu_Entier;
import Vue.Vue_Plateau;
import Vue.Vue_Regles;

public class Controleur_Jeu implements MouseInputListener {
	
	private Modele_Jeu mod_jeu;
	private Modele_plateau mod_plateau;
	private Vue_Jeu_Entier vue_jeu;
	private Vue_Plateau vue_plateau;
	private Controleur_Plateau controleur_plateau;
	private Vue_Action_Joueur vue_action_joueur;
	private Controleur_Action_Joueur controleur_action_joueur;
	private Vue_Historique vue_historique;
	private Controleur_Historique controleur_historique;
	private Vue_Regles vue_regles;
	private Controleur_Regles controleur_regles;
	private Controleur_IA IA;
	
	public Controleur_Jeu(Modele_Jeu mj, Vue_Jeu_Entier vj) {
		this.mod_jeu = mj;
		this.vue_jeu = vj;
		
		this.mod_plateau = mod_jeu.getPlateau();
		this.vue_plateau = new Vue_Plateau();
		mod_jeu.getPlateau().ajouterJoueur("albert", 01, true);
		mod_jeu.getPlateau().ajouterJoueur("Francis", 02, false);
		IA = new Controleur_IA(1);
		this.controleur_plateau = new Controleur_Plateau(vue_plateau,mod_plateau,IA);
		vue_plateau.ajouterListener(controleur_plateau);
		
		this.vue_action_joueur = new Vue_Action_Joueur();
		this.controleur_action_joueur = new Controleur_Action_Joueur(vue_action_joueur);
		vue_action_joueur.ajouterlistenerquitter(controleur_action_joueur);
		
		this.vue_historique = new Vue_Historique();
		this.controleur_historique = new Controleur_Historique(vue_historique);
		vue_historique.ajouterlistenerquitter(controleur_historique);
		
		this.vue_regles = new Vue_Regles();
		this.controleur_regles = new Controleur_Regles(vue_regles);
		vue_regles.ajouterlistenerquitter(controleur_regles);

		this.remplir_panel();
		this.vue_jeu.addlistener(this);
	}
	
	private void remplir_panel() {
		
		this.vue_jeu.ajouter_plateau(this.controleur_plateau.getJeuEnCours());
		this.vue_jeu.ajouter_action_joueur(this.controleur_action_joueur.getVueBoutons());
		this.vue_jeu.ajouter_historique(this.controleur_historique.getVue_Histo());
		this.vue_jeu.ajouter_regle(this.controleur_regles.getRegles());
		this.vue_jeu.ajouter_score(this.controleur_plateau.getScoreJoueur());
	}


	private void updateFenetre() {
		this.setTourJoueur(this.controleur_plateau.getNomJoueurCourant());
		this.vue_jeu.updateScore(this.controleur_plateau.getScoreJoueur());
		
	}

	private void setTourJoueur(String nomJoueurCourant) {
		this.controleur_regles.getRegles().getLabelNom().setText(nomJoueurCourant);		
	}

	public Vue_Plateau getVue_plateau() {
		return controleur_plateau.getJeuEnCours();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		this.updateFenetre();
		
	}



}
