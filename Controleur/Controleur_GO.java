package Controleur;

import Modele.Modele_Jeu;
import Vue.Vue_Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur_GO implements ActionListener {

    public void actionPerformed(ActionEvent e){
        Modele_Jeu mj = new Modele_Jeu();
        Vue_Jeu vj = new Vue_Jeu();
        Controleur_Jeu cj = new Controleur_Jeu(mj, vj);
        vj.getFenetre().setVisible(true);
    }

}