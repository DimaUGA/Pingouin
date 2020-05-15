package Controleur;

import Modele.Modele_Jeu;
import Vue.Vue_Jeu_Entier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controleur_GO implements ActionListener {

    Controleur_Vue_Jeu vj;

    public Controleur_GO(Controleur_Vue_Jeu vj){
        this.vj = vj;
    }

    public void actionPerformed(ActionEvent e){
        vj.remplitArray();
        Modele_Jeu mj = new Modele_Jeu();
        int i = 0;
        for (String s : vj.getListejoueur()){
        	//A gerer en cas d'IA
            mj.getPlateau().ajouterJoueur(s, i++, false);
        }
        Vue_Jeu_Entier vj = new Vue_Jeu_Entier();
        new Controleur_Jeu(mj, vj);
        vj.getFrame().setVisible(true);
    }

}