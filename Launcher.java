import Controleur.*;
import Modele.Modele_Jeu;
import Vue.Vue_Jeu;
import javax.swing.*;

public class Launcher{

	public static void main(String[] args)
    {
        Modele_Jeu mj = new Modele_Jeu();
        Vue_Jeu fenetre = new Vue_Jeu(mj);
        Controleur_Jeu cj = new Controleur_Jeu(mj, fenetre);
        fenetre.getFenetre().setVisible(true);
	}
}
