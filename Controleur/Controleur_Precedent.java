package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur_Precedent implements ActionListener {

    Controleur_Vue_Jeu b;

    public Controleur_Precedent(Controleur_Vue_Jeu b) {
        this.b = b;
    }
    public void actionPerformed(ActionEvent e){

        switch (b.page_courante){
            case 2:
                b.page_2.setVisible(false);
                b.page_1.setVisible(true);
                b.bouton_precedent.setVisible(false);
                b.page_courante = 1;
                break;
            case 3:
                b.page_3.setVisible(false);
                b.page_2.setVisible(true);
                b.page_courante = 2;
                break;
            case 4:
                b.page_4.setVisible(false);
                b.page_3.setVisible(true);
                b.page_courante = 3;
                break;
            case 5:
                b.page_5.setVisible(false);
                b.page_4.setVisible(true);
                b.page_courante = 4;
                break;
            case 6:
                b.page_6.setVisible(false);
                b.page_5.setVisible(true);
                b.page_courante = 5;
                break;
            case 7:
                b.page_7.setVisible(false);
                b.page_6.setVisible(true);
                b.page_courante = 6;
                break;
            case 8:
                b.page_8.setVisible(false);
                b.page_7.setVisible(true);
                b.page_courante = 7;
                break;
            case 9:
                b.page_9.setVisible(false);
                b.page_8.setVisible(true);
                b.page_courante = 8;
                break;
            case 10:
                b.page_10.setVisible(false);
                b.page_9.setVisible(true);
                b.bouton_suivant.setVisible(true);
                b.page_courante = 9;
                break;
        }
    }
}
