package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Controleur.*;
import Vue.Vue_Jeu;
import javax.swing.*;
import java.lang.Object.*;
import java.awt.*;
import Modele.*;

public class Controleur_Souris implements MouseListener{

    Vue_Jeu jeuEnCours;
    boolean pingouinSelectionne;
    int departX	, departY, numPingouinCourant;
    Modele_plateau mp;
    int joueurcourant;
    int nbCoup;

    public Controleur_Souris(Vue_Jeu vue ,Modele_plateau plateau){
      this.jeuEnCours = vue;
      this.mp = plateau;
      pingouinSelectionne = false;
      this.nbCoup = 0;
      this.joueurcourant = 0;
      this.jeuEnCours.setPlateau(plateau);
    }

    void deplacementPingouin(Point p){
        //Est Accessible ne gere que diagonale basse a regler + ne prend pas en compte les cases vides
	    /*
    	//if ( cest le tour de l'ia ){
    		X = simulercoup
    		jouercoup(ia,X.a,X.b);
    		else()if(le truc d'en dessous
    	*/
    		if(this.mp.Contient(p, this.mp.Accessible(new Point(departX, departY)))){
	        	this.mp.Jouer_coup(this.mp.getJoueurs().get(joueurcourant), numPingouinCourant, p);
	        	jeuEnCours.setPlateau(this.mp);
	            jeuEnCours.repaint();
	            pingouinSelectionne = false;
	            this.nbCoup++;
	            this.joueurcourant = nbCoup%this.mp.getJoueurs().size();
	        }
    }

    void selectionPingouin(Point p){
        //Voir comment recup indice du pingouin + verifié si joueur a cliquer sur un pgn, sinon ne rien faire
        int i;
        if ((i = this.mp.getJoueurs().get(joueurcourant).estPingouin(p)) != -1 ){
            numPingouinCourant = i;
            departX = (int)p.getX();
            departY = (int)p.getY();
            pingouinSelectionne = true;
            System.out.println("Pingouin selectionner " + i);
        }
    }

    void posePingouinInitialisation(Point p){
        System.out.println(this.mp.getJoueurs().get(joueurcourant).getNbPingouinPose());
        if (this.mp.getJoueurs().get(joueurcourant).getNbPingouinPose() == 0 || this.mp.getJoueurs().get(joueurcourant).estPingouin(p) == -1)
        	this.mp.getJoueurs().get(joueurcourant).posePingouin(p);
        jeuEnCours.repaint();
        this.nbCoup++;
        this.joueurcourant = nbCoup%this.mp.getJoueurs().size();
    }
    //lES DEUX FONCTIONS DE CALCUL DE POSITION SERONT A MODIFIER APRES IHM
    int calculPositionY (int tailleFenetre,int nombreDeCase, int positionCliqueeY){
        return positionCliqueeY/(tailleFenetre/nombreDeCase);
    }

    int calculPositionX(int tailleFenetre, int nombreDeCase, int positionCliqueeX, int positionCliqueeY){
        //Divise le tableau de taille 500 en 16 partie pour l'horizontale
        int coordonneeX = positionCliqueeX/(tailleFenetre/nombreDeCase);
        if (positionCliqueeY%2 == 0 && coordonneeX % 2 == 1 || positionCliqueeY % 2 != 0 &&  coordonneeX % 2 == 0){
            //ajustement de la position en cas de clic sur la limite d'un hexagone, necessaire car une division en 16 partie coupe un hexagone en deux .
            coordonneeX --;
        }
        return  coordonneeX;
    }

    public void sourisCliquee(MouseEvent e) {
      int coordonneeY = calculPositionY(500, 8,e.getY());
      int coordonneeX = calculPositionX(500, 16, e.getX(), coordonneeY);
      //Gestion des tours, si aucun pingouin selectionner attendre que l'utilisateur en choisisse un, deplacer celui selectionner a la position sinon
      if (this.mp.getJoueurs().get(joueurcourant).initialisation()){
          posePingouinInitialisation(new Point(coordonneeX, coordonneeY));
      }
      else if(!pingouinSelectionne){
        selectionPingouin(new Point(coordonneeX, coordonneeY));
      }
      else {
        deplacementPingouin(new Point(coordonneeX, coordonneeY));
      }
    }
    
    @Override
	public void mouseClicked(MouseEvent mouseEvent) {}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		this.sourisCliquee(mouseEvent);
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {}

}
