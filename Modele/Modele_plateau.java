package Modele;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Modele_plateau /*extends AbstractTableModel*/ {

  private int[][] monplateau;
  private Random mod_alea = new Random();
  private int colonne;
  private int ligne;
  private ArrayList<Modele_Joueur> joueurs;
	Point p = new Point();


	public Modele_plateau(int x,int y) {
		monplateau = new int[x][y];
		this.tracer_plateau();
		this.colonne=y;
		this.ligne=x;
		joueurs = new ArrayList<>();
	}

	public void tracer_plateau() { //Creer le tableau de jeu de manière aléatoire
        ArrayList<Integer> gestion_poissons = new ArrayList<>();
        gestion_poissons.add(30);
        gestion_poissons.add(20);
        gestion_poissons.add(10);
        int tmp;
        for (int i = 0; i < 8; i++) {
            for (int j = i % 2; j < 15; j = j + 2) {
                for (tmp = mod_alea.nextInt(3); gestion_poissons.get(tmp) == 0; tmp = mod_alea.nextInt(3)) {
                }
                set_valeur_plateau(i,j,tmp+1);
                gestion_poissons.set(tmp, gestion_poissons.get(tmp) - 1);
            }
        }
    }

	public int[][] getMonplateau() {
		return monplateau;
	}

	public void setMonplateau(int[][] monplateau) {
		this.monplateau = monplateau;
	}

	public void set_valeur_plateau(int x, int y, int v) {
        this.monplateau[x][y]=v;
    }

	public boolean Contient(Point p, ArrayList<Point> liste){ //Vérifie si le point est occupé par un pingouin
		for (Point i : liste){
			if (i.getX() == p.getX() && i.getY() == p.getY()){
				return true;
			}
		}
		return false;
	}

	public boolean ContientPingouin(Point p, ArrayList<Modele_Joueur> liste){
		for (Modele_Joueur j : liste) {
			for (Modele_Pingouin pingouins : j.getPingouins()){
				if (pingouins.getCoordonees().getX() == p.getX()
						&& pingouins.getCoordonees().getY() == p.getY()){
					return true;
				}
			}
		}
		return false;
	}

	public boolean Est_accessible(Point p) { //Vérifie si le point est accessible
		return (int)p.getX() < 16 && (int)p.getX() >= 0 && (int)p.getY() < 8 && (int)p.getY() >= 0
				&& this.getValeurCase(new Point((int)p.getX(), (int)p.getY())) != 0
				&& !ContientPingouin(p,joueurs);
	}

	public void Jouer_coup(Modele_Joueur joueur, int id_pingouin, Point pArr){ // A coder apres la classe Joueur
		Point coordoneesCourante = joueur.getPingouin(id_pingouin).getCoordonees();
		joueur.ajout_score(getValeurCase(coordoneesCourante));
		monplateau[(int)coordoneesCourante.getY()][(int)coordoneesCourante.getX()] = 0;
		joueur.deplacer_pingouin(id_pingouin,pArr);
	}

	public ArrayList<Point> Remplir_liste_voisin(ArrayList<Point> liste,Point p, int mult_x, int mult_y){
		int x = (int)p.getX();
		int y = (int)p.getY();
		int temp = 0;
		if(mult_y == 0 && y%2 == 0) temp = 1;
		for ( int i = 1 + temp; Est_accessible(new Point(x+(i*mult_x), y+(i*mult_y))); i++){
			liste.add(new Point(x+(i*mult_x),y+(i*mult_y)));
		}
		return liste;
	}

	public ArrayList<Point> Accessible(Point p){ //Renvoi la liste des points accessibles depuis le point p
		ArrayList<Point> liste_voisin = new ArrayList<>();
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,-1,-1);
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,1,-1);
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,-1,1);
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,1,1);
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,-2,0);
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,2,0);
		return liste_voisin;
	}

	public ArrayList<Modele_Joueur> getPosition_Joueur() {
		return joueurs;
	}

    public int getValeurCase(Point p) {
    	return this.monplateau[(int)p.getY()][(int)p.getX()];
    }

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public void setJoueurs(ArrayList<Modele_Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public ArrayList<Modele_Joueur> getJoueurs() {
		return joueurs;
	}

	public void ajouterJoueur(String nom, int ID){
			joueurs.add(new Modele_Joueur(nom, ID));
	}

	public Modele_Joueur getJoueursIndice(int pos){
		return joueurs.get(pos);
	}
}
