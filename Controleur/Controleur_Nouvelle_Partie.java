package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur_Nouvelle_Partie implements ActionListener {
    Controleur_Vue_Jeu cvj;
    public Controleur_Nouvelle_Partie(Controleur_Vue_Jeu cvj){
        this.cvj = cvj;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cvj.NouvellePartie();
    }
}
