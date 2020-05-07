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

public class Controleur_Souris implements MouseListener {

    Vue_Jeu jeuEnCours;
    boolean pingouinSelectionne;
    public Controleur_Souris(Vue_Jeu vue ){
      jeuEnCours = vue;
      pingouinSelectionne = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    //Implementer focntion pour calculer le diviseur ( taille fenetre / nb de case)
    int coordonneeY = (int)(e.getY()/62.5);
    int coordonneeX;
    if (coordonneeY%2 == 0){
      coordonneeX = (int)e.getX()/62.5;
    }
    else{
      //Faire cas sur ligne impaire en evitant la partie vide + eviter les depassements memoires
      //Si tu trouves pas go faire un giga switch case en attendant on ameliorera apres
      coordonneeX = (int)e.getX()/83;
    }
    if(!pingouinSelectionne){
      System.out.println("coucou");
    }
    else {
      System.out.println(coordonneeX + " " + coordonneeY);
      jeuEnCours.getJeu().getPlateau().Jouer_coup(jeuEnCours.getJoueurCourant(), 1, new Point(coordonneeX,coordonneeY));
      jeuEnCours.repaint();
    }


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
