package Modele;

import java.awt.*;

public class Modele_Pingouin {

    Point coordonees;
    int id_pingouin;

    public Modele_Pingouin(int id){
      id_pingouin = id;
    }

    public Modele_Pingouin(int id, Point pos){
      id_pingouin = id;
      coordonees = pos;
    }

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
