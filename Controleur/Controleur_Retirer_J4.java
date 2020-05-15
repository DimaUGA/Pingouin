package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur_Retirer_J4 implements ActionListener {

    Controleur_Vue_Jeu b;

    Controleur_Retirer_J4(Controleur_Vue_Jeu b){
        this.b=b;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        b.setVisibleJ4(false);
    }
}