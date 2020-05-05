package Modele;
import java.awt.*;
import java.util.ArrayList;

public class Modele_Joueur {

    String nom_joueur;
    int score, id_joueur;
    ArrayList<Modele_Pingouin> Pingouins;

    public Modele_Joueur(String nom, int id){
        setNom_joueur(nom);
        setId_joueur(id);
        this.score=0;
    }


    public void deplacer_pingouin(int id_pingouin, Point destination){
        Pingouins.get(id_pingouin).setCoordonees(destination);
    }

    public void ajout_score(int valeur){
        setScore(score+valeur);
    }

    public void setNom_joueur(String nom) {
        this.nom_joueur = nom;
    }

    public void setId_joueur(int id) {
        this.id_joueur = id;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public String getNom_joueur() {
        return nom_joueur;
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Modele_Pingouin> getPingouins() {
        return Pingouins;
    }

    public Modele_Pingouin getPingouin(int ind){
        return Pingouins.get(ind);
    }

    public void setPingouins(ArrayList<Modele_Pingouin> pingouins) {
        Pingouins = pingouins;
    }
}
