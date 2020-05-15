package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur_B_RETOUR implements ActionListener {

    Controleur_Vue_Jeu b;

    Controleur_B_RETOUR(Controleur_Vue_Jeu b){
        this.b=b;
    }

    public void actionPerformed(ActionEvent e){
        if (b.getLieu()=='r' | b.getLieu()=='j'){
            b.Acceuil();
        }
        else if (b.getLieu()=='n'){
            b.Jouez();
        }
    }

}