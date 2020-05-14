package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur_Ajouter_J3 implements ActionListener {

    Controleur_Vue_Jeu b;

    Controleur_Ajouter_J3(Controleur_Vue_Jeu b){
        this.b=b;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        b.setVisibleJ3(true);
    }
}
