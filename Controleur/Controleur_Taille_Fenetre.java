package Controleur;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Controleur_Taille_Fenetre implements ComponentListener {

    Controleur_Vue_Jeu b;

    Controleur_Taille_Fenetre(Controleur_Vue_Jeu b) {
        this.b = b;
    }

    public void componentResized(ComponentEvent e) {
        b.refreshValue();
        /*if (b.getLieu()=='a' && b.getTaille()){
            b.Acceuil();
        }
        else if (b.getLieu()=='r' && b.getTaille()){
            b.Regles();
        }
        else if (b.getLieu()=='j' && b.getTaille()){
            b.Jouez();
        }
        else if (b.getLieu()=='n' && b.getTaille()){
            b.NouvellePartie();
        }*/
    }

    public void componentMoved(ComponentEvent e){

    }

    public void componentHidden(ComponentEvent e){

    }

    public void componentShown(ComponentEvent e){

    }
}
