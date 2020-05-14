package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur_B_JOUEZ implements ActionListener {

    Controleur_Vue_Jeu b;

    Controleur_B_JOUEZ(Controleur_Vue_Jeu b) {
        this.b = b;
    }

    public void actionPerformed(ActionEvent e) {
        b.Jouez();
    }
}