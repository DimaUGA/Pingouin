package Modele;
import java.awt.*;
import java.util.ArrayList;

public class Modele_Joueur {

    String nom_joueur;
    int score, id_joueur, nbDePingouinPose;
    ArrayList<Modele_Pingouin> Pingouins;

    public Modele_Joueur(String nom, int id){
        setNom_joueur(nom);
        setId_joueur(id);
        nbDePingouinPose = 0;
        this.score=0;
        Pingouins = new ArrayList<>();
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

    // Ajout des pingouins pour initialisation
   public void ajouterPingouin (int nombre, int ID){
      for(int i = 0; i< nombre; i++){
        Pingouins.add(new Modele_Pingouin(ID));
      }
    }

    public int getNbPingouinPose(){
      return nbDePingouinPose;
    }

    public void posePingouin (Point coordonees){
      //Verifie si tous les png ont ete pose, ameliorable mais pas important tout de suite
      if (nbDePingouinPose != Pingouins.size()){
        //remplace le pingouin avec celui pose, si il en reste a poser
        Pingouins.set(nbDePingouinPose, new Modele_Pingouin(Pingouins.get(nbDePingouinPose).getId_pingouin(), coordonees));
        nbDePingouinPose ++;
      }
    }

}
