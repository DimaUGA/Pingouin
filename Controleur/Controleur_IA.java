package Controleur;

import java.awt.Point;
import java.util.Random;

import Modele.Modele_Coup;
import Modele.Modele_plateau;

public class Controleur_IA {
	public int IA;
	Random moduleRandom;
	
	public Controleur_IA(int num) {
		moduleRandom = new Random();
		IA = num;
	}
	
	public Modele_Coup joueIA(Modele_plateau jeu) {
		System.out.println("J'ai bougé le pingouin");
		int i = -1;
		Modele_Coup coup = new Modele_Coup();
		Point p = jouerCoup(15,7);;
		if(jeu.getJoueursIndice(IA).initialisation()) {
			while(!jeu.Est_accessible(p, p))
				p = jouerCoup(15,7);
		}
		else {
			i = recupNumPingouin(jeu.getJoueursIndice(IA).getNbPingouinPose());
			while(!jeu.accessible(jeu.getJoueursIndice(IA).getPingouin(i).getCoordonees(), p)){
				p = jouerCoup(15,7);;
				i = recupNumPingouin(jeu.getJoueursIndice(IA).getNbPingouinPose());
			}
		}
		coup.setAll((int)p.getX(), (int)p.getY(), i);
		return coup;
	}

    public Point jouerCoup(int tailleMAXX, int tailleMAXY) {
        return new Point(moduleRandom.nextInt(tailleMAXX), moduleRandom.nextInt(tailleMAXY));
    }

    public int recupNumPingouin(int nb){
        return moduleRandom.nextInt(nb);
    }
}
