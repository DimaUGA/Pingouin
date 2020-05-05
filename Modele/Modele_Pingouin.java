package Modele;

import java.awt.*;

public class Modele_Pingouin {

    Point coordonees;
    int id_pingouin;

    public void setCoordonees(Point coord) {
        coordonees = coord;
    }

    public void setId_pingouin(int id_pingouin) {
        this.id_pingouin = id_pingouin;
    }

    public Point getCoordonees() {
        return coordonees;
    }

    public int getId_pingouin() {
        return id_pingouin;
    }

}
