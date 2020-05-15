package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Vue.Vue_Plateau;
import java.util.Map;
import java.awt.*;
import Modele.*;

public class Controleur_Plateau implements MouseListener {

	Vue_Plateau jeuEnCours;
	boolean pingouinSelectionne;
	int departX, departY, numPingouinCourant;
	Modele_plateau mp;
	int joueurcourant;
	int nbCoup;
	Controleur_IA IA;

	public Controleur_Plateau(Vue_Plateau vue, Modele_plateau plateau, Controleur_IA j) {
		this.jeuEnCours = vue;
		this.mp = plateau;
		pingouinSelectionne = false;
		this.nbCoup = 0;
		this.joueurcourant = 0;
		this.jeuEnCours.setPlateau(plateau);
		IA = j;
	}

	void deplacementPingouin(Point p) {
		// Est Accessible ne gere que diagonale basse a regler + ne prend pas en compte
		// les cases vides
		/*
		 * //if ( cest le tour de l'ia ){ X = simulercoup jouercoup(ia,X.a,X.b);
		 * else()if(le truc d'en dessous
		 */
		if (this.mp.accessible(new Point(departX, departY), p)) {
			this.mp.Jouer_coup(this.mp.getJoueurs().get(joueurcourant), numPingouinCourant, p);
			jeuEnCours.setPlateau(this.mp);
			jeuEnCours.repaint();
			pingouinSelectionne = false;
			this.nbCoup++;
			this.joueurcourant = nbCoup % this.mp.getJoueurs().size();
			Modele_Coup coup = IA.joueIA(mp);
			mp.Jouer_coup(mp.getJoueursIndice(joueurcourant), coup.getPingouin(), coup.getPoint());
			jeuEnCours.repaint();
			nbCoup++;
			this.joueurcourant = nbCoup % this.mp.getJoueurs().size();
		}
	}

	void selectionPingouin(Point p) {
		// Voir comment recup indice du pingouin + verifié si joueur a cliquer sur un
		// pgn, sinon ne rien faire
		int i;
		if ((i = this.mp.getJoueurs().get(joueurcourant).estPingouin(p)) != -1) {
			numPingouinCourant = i;
			departX = (int) p.getX();
			departY = (int) p.getY();
			pingouinSelectionne = true;
			System.out.println("Pingouin selectionner " + i);
		}
	}

	void posePingouinInitialisation(Point p) {
		System.out.println("il t a " + this.mp.getJoueurs().get(joueurcourant).getNbPingouinPose() + " de pos�");
		if (this.mp.getValeurCase(p) == 1 && this.mp.getJoueurs().get(joueurcourant).estPingouin(p) == -1) {
			this.mp.getJoueurs().get(joueurcourant).posePingouin(p);
			jeuEnCours.repaint();
			this.nbCoup++;
			this.joueurcourant = nbCoup % this.mp.getJoueurs().size();
			Modele_Coup coup = IA.joueIA(mp);
			mp.getJoueursIndice(IA.IA).posePingouin(coup.getPoint());
			jeuEnCours.repaint();
			nbCoup++;
			this.joueurcourant = nbCoup % this.mp.getJoueurs().size();
		}
	}

	// LES DEUX FONCTIONS DE CALCUL DE POSITION SERONT A MODIFIER APRES IHM
	int calculPositionY(int tailleFenetre, int nombreDeCase, int positionCliqueeY) {
		return positionCliqueeY / (tailleFenetre / nombreDeCase);
	}

	int calculPositionX(int tailleFenetre, int nombreDeCase, int positionCliqueeX, int positionCliqueeY) {
		// Divise le tableau de taille 500 en 16 partie pour l'horizontale
		int coordonneeX = positionCliqueeX / (tailleFenetre / nombreDeCase);
		if (positionCliqueeY % 2 == 0 && coordonneeX % 2 == 1 || positionCliqueeY % 2 != 0 && coordonneeX % 2 == 0) {
			// ajustement de la position en cas de clic sur la limite d'un hexagone,
			// necessaire car une division en 16 partie coupe un hexagone en deux .
			coordonneeX--;
		}
		return coordonneeX;
	}

	public void sourisCliquee(MouseEvent e) {
	        int coordonneeY = calculPositionY(this.jeuEnCours.getSize().height, 8, e.getY());
	        int coordonneeX = calculPositionX(this.jeuEnCours.getSize().width, 16, e.getX(), coordonneeY);
	        // Gestion des tours, si aucun pingouin selectionner attendre que l'utilisateur
	        // en choisisse un, deplacer celui selectionner a la position sinon
	        if (this.mp.getJoueurs().get(joueurcourant).initialisation()) {
	            posePingouinInitialisation(new Point(coordonneeX, coordonneeY));
	        } else if (!pingouinSelectionne) {
	            selectionPingouin(new Point(coordonneeX, coordonneeY));

	        }
	        else if(pingouinSelectionne && e.getButton() == 3) {
	            System.out.println("je suis rentrer");
	            pingouinSelectionne = false;
	        }
	        else {
	            deplacementPingouin(new Point(coordonneeX, coordonneeY));
	        }
	    }

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		this.sourisCliquee(mouseEvent);
	}

	public Vue_Plateau getJeuEnCours() {
		return jeuEnCours;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public String getNomJoueurCourant() {
		return this.mp.getJoueurs().get(joueurcourant).getNom_joueur();
	}

    public Map<String,Integer> getScoreJoueur(){
    	return this.getMp().getScoreJoueur();
    }

	public Modele_plateau getMp() {
		return mp;
	}

	public void setMp(Modele_plateau mp) {
		this.mp = mp;
	}
}
