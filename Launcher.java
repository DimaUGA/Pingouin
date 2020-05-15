import Controleur.*;
import Modele.Modele_Jeu;
import Vue.Vue_Plateau;
import Vue.Vue_Jeu_Entier;
public class Launcher{

	public static void main(String[] args)
    {
        new Controleur_Vue_Jeu();
        //Modele_Jeu mj = new Modele_Jeu();
        //Vue_Jeu vj = new Vue_Jeu();
        //Controleur_Jeu cj = new Controleur_Jeu(mj, vj);
        //vj.getFenetre().setVisible(true);
	}
}
