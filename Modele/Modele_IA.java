package Modele;

import java.awt.Point;
import java.util.Random;

public class Modele_IA extends Modele_Joueur_abs {
	Random moduleRandom;
	
    public Modele_IA(String nom, int id) {
        super(nom,id);
        moduleRandom = new Random();
    }

    public Point jouerCoup(int tailleMAXX, int tailleMAXY) {
        return new Point(moduleRandom.nextInt(tailleMAXX), moduleRandom.nextInt(tailleMAXY));
    }

    public int recupNumPingouin(int nb){
        return moduleRandom.nextInt(nb);
    }
}