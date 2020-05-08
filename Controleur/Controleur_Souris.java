package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Controleur.*;
import Modele.Modele_Jeu;
import Vue.Vue_Jeu;
import javax.swing.*;
import java.lang.Object.*;
import java.awt.*;
import Modele.*;

public class Controleur_Souris{

    Vue_Jeu jeuEnCours;
    boolean pingouinSelectionne;
    int departX	, departY, numPingouinCourant;

    public Controleur_Souris(Vue_Jeu vue ){
      jeuEnCours = vue;
      pingouinSelectionne = false;
    }

    void deplacementPingouin(Point p){
        //Est Accessible ne gere que diagonale basse a regler + ne prend pas en compte les cases vides
        if(jeuEnCours.getJeu().getPlateau().Contient(p, jeuEnCours.getJeu().getPlateau().Accessible(new Point(departX, departY)))){
            jeuEnCours.getJeu().getPlateau().Jouer_coup(jeuEnCours.getJoueurCourant(), numPingouinCourant, p);
            jeuEnCours.repaint();
            pingouinSelectionne = false;
        }
    }

    void selectionPingouin(Point p){
        //Voir comment recup indice du pingouin + verifié si joueur a cliquer sur un pgn, sinon ne rien faire
        int i;
        if ((i = jeuEnCours.getJoueurCourant().estPingouin(p)) != -1 ){
            numPingouinCourant = i;
            departX = (int)p.getX();
            departY = (int)p.getY();
            pingouinSelectionne = true;
            System.out.println("Pingouin selectionner " + i);
        }
    }

    void posePingouinInitialisation(Point p){
        System.out.println(jeuEnCours.getJoueurCourant().getNbPingouinPose());
        if (jeuEnCours.getJoueurCourant().getNbPingouinPose() == 0 || jeuEnCours.getJoueurCourant().estPingouin(p) == -1)
            jeuEnCours.getJoueurCourant().posePingouin(p);
        jeuEnCours.repaint();
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
      if (jeuEnCours.getJoueurCourant().initialisation()){
          posePingouinInitialisation(new Point(coordonneeX, coordonneeY));
      }
      else if(!pingouinSelectionne){
        selectionPingouin(new Point(coordonneeX, coordonneeY));
      }
      else {
        deplacementPingouin(new Point(coordonneeX, coordonneeY));
      }
    }

}
