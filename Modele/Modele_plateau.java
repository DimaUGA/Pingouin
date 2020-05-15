package Modele;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Modele_plateau /*extends AbstractTableModel*/ {
	private int[][] monplateau;
	private Random mod_alea = new Random();
	private int colonne;
 	private int ligne;
	private ArrayList<Modele_Joueur_abs> joueurs;
	Point p = new Point();

	public Modele_plateau(int x,int y) {
		monplateau = new int[x][y];
		this.tracer_plateau();
		this.colonne=y;
		this.ligne=x;
		joueurs = new ArrayList<>();
	}

	public void tracer_plateau() { //Creer le tableau de jeu de maniere aleatoire
		ArrayList<Integer> gestion_poissons = new ArrayList<>();
		gestion_poissons.add(30);
		gestion_poissons.add(20);
		gestion_poissons.add(10);
		int tmp;
		for (int i = 0; i < 8; i++) {
			for (int j = i % 2; j < 15; j = j + 2) {
				for (tmp = mod_alea.nextInt(3); gestion_poissons.get(tmp) == 0; tmp = mod_alea.nextInt(3)) {}
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

	public boolean Contient(Point p, ArrayList<Point> liste) { //Verifie si le point est occupe par un pingouin
		for (Point i : liste) {
			if (i.getX() == p.getX() && i.getY() == p.getY())
				return true;
		}
		return false;
	}

	public boolean ContientPingouin(Point p, ArrayList<Modele_Joueur_abs> liste) {
		for (Modele_Joueur_abs j : liste) {
			for (Modele_Pingouin pingouins : j.getPingouins()) {
				System.out.println("Dans la fonction contient pingouin");
				System.out.println(pingouins.getCoordonees().getX() + " " + pingouins.getCoordonees().getY() + " point à comparer : " + p.getX() + " " + p.getY());
				if (pingouins.getCoordonees().getX() == p.getX() && pingouins.getCoordonees().getY() == p.getY())
					return true;
			}
		}
		return false;
	}
	
	public boolean accessible(Point dep, Point ar) {
		//on vérifie déjà si le point est sur une diagonale ou sur une ligne depuis la position du pingouin, dans ce cas c'est inutile de regarder les autres cases
		if (!Est_accessible(dep, ar)) 
			return false;
		int xDep = (int)dep.getX();
		int yDep = (int)dep.getY();
		int xAr = (int)ar.getX();
		int yAr = (int)ar.getY();
		//Le cas où le pingouin veut se déplacer sur une ligne
		if (dep.getY()-ar.getY() == 0) {
			for (int i = 2; xDep+i < xAr || xDep-i > xAr; i += 2) { 
				System.out.println("Je suis rentrée dans le for 1");
				System.out.println(dep.getX() + " " + dep.getY());
				if (xDep+i < xAr && !Est_accessible(dep, new Point(xDep+i, yDep)) || xDep-i > xAr && !Est_accessible(dep, new Point(xDep-i, yDep))) 
					return false;
			}
		}
		//Le cas où le pingouin veut se déplacer sur une des 4 diagonales
		for (int i = 1; xDep+i < xAr && yDep+i < yAr || xDep+i < xAr && yDep-i > yAr || xDep-i > xAr && yDep+i < yAr || xDep-i > xAr && yDep-i > yAr; i ++) { 
			System.out.println("Je suis rentrée dans le for 2");
			System.out.println(dep.getX() + " " + dep.getY());
			if (xDep+i < xAr && yDep+i < yAr && !Est_accessible(dep, new Point(xDep+i, yDep+i)) || xDep+i < xAr && yDep-i > yAr && !Est_accessible(dep, new Point(xDep+i, yDep-i)) 
					|| xDep-i > xAr && yDep+i < yAr && !Est_accessible(dep, new Point(xDep-i, yDep+i)) 
					|| xDep-i > xAr && yDep-i > yAr && !Est_accessible(dep, new Point(xDep-i, yDep-i))) 
				return false;
		}
		return true;
	}

	public boolean Est_accessible(Point dep, Point ar) { //Verifie si le point ar est accessible est accessible depuis le point dep
		int xDep = (int)dep.getX();
		int yDep = (int)dep.getY();
		int xAr = (int)ar.getX();
		int yAr = (int)ar.getY();
		return xDep < 16 && xDep >= 0 && yDep < 8 && yDep >= 0 && (Math.abs(yDep-yAr) == Math.abs(xDep - xAr) || yAr-yDep == 0)
				&& this.getValeurCase(new Point(xAr, yAr)) != 0 && !ContientPingouin(ar,joueurs);
	}

	public void Jouer_coup(Modele_Joueur joueur, int id_pingouin, Point pArr) { // A coder apres la classe Joueur
		Point coordoneesCourante = joueur.getPingouin(id_pingouin).getCoordonees();
		joueur.ajout_score(getValeurCase(coordoneesCourante));
		monplateau[(int)coordoneesCourante.getY()][(int)coordoneesCourante.getX()] = 0;
		joueur.deplacer_pingouin(id_pingouin,pArr);
	}

	public ArrayList<Point> Remplir_liste_voisin(ArrayList<Point> liste,Point p, int mult_x, int mult_y) {
		int x = (int)p.getX();
		int y = (int)p.getY();
		int temp = 0;
		if(mult_y == 0 && y%2 == 0) temp = 1;
		for ( int i = 1 + temp; Est_accessible(p, new Point(x+(i*mult_x), y+(i*mult_y))); i++) {
			liste.add(new Point(x+(i*mult_x),y+(i*mult_y)));
		}
		return liste;
	}

	public ArrayList<Point> Accessible(Point p) { //Renvoi la liste des points accessibles depuis le point p
		ArrayList<Point> liste_voisin = new ArrayList<>();
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,-1,-1);
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,1,-1);
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,-1,1);
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,1,1);
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,-2,0);
		liste_voisin = Remplir_liste_voisin(liste_voisin,p,2,0);
		return liste_voisin;
	}
	
	public void Jouer_coup(Modele_Joueur_abs joueur, int id_pingouin, Point pArr) { // A coder apres la classe Joueur
		Point coordoneeCourante = joueur.getPingouin(id_pingouin).getCoordonees();
		joueur.ajout_score(getValeurCase(coordoneeCourante));
		monplateau[(int)coordoneeCourante.getY()][(int)coordoneeCourante.getX()] = 0;
		joueur.deplacer_pingouin(id_pingouin,pArr);
	}
	
	public ArrayList<Modele_Joueur_abs> getPosition_Joueur() {
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

	public void setJoueurs(ArrayList<Modele_Joueur_abs> joueurs) {
		this.joueurs = joueurs;
	}

	public ArrayList<Modele_Joueur_abs> getJoueurs() {
		return joueurs;
	}

	public void ajouterJoueur(String nom, int ID, boolean modeIA){
		if (modeIA)
			joueurs.add(new Modele_IA(nom, ID));
		else 
			joueurs.add(new Modele_Joueur(nom, ID));
	}

	public Modele_Joueur_abs getJoueursIndice(int pos){
		return joueurs.get(pos);
	}
}
