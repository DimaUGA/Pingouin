package Modele;

import java.awt.*;
import java.util.*;

public class Modele_Jeu{

	Modele_plateau plateau;

    public Modele_Jeu(){
        plateau = new Modele_plateau(8,16);
    }

    public Modele_plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Modele_plateau plateau) {
        this.plateau = plateau;
    }
}
