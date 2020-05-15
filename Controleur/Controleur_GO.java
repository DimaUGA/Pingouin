package Controleur;

import Modele.Modele_Jeu;
import Vue.Vue_Jeu_Entier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur_GO implements ActionListener {

    public void actionPerformed(ActionEvent e){
        Modele_Jeu mj = new Modele_Jeu();
        Vue_Jeu_Entier vj = new Vue_Jeu_Entier();
        new Controleur_Jeu(mj, vj);
        vj.getFrame().setVisible(true);
    }

}