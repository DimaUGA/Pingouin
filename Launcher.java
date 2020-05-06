import Controleur.Controleur_Jeu;
import Modele.Modele_Jeu;
import Vue.Vue_Jeu;

public class Launcher {
	public static void main(String[] args) {
		Modele_Jeu mj = new Modele_Jeu();
		Vue_Jeu vj = new Vue_Jeu();
		Controleur_Jeu cj = new Controleur_Jeu(mj, vj);
		cj.start();
		//vj.setvisible(true);
	}
}
