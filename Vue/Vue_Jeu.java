package Vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import Modele.*;

public class Vue_Jeu extends JComponent {

	private JFrame frame;
	private JTable table;
	Modele_Jeu jeu;
	int comp = 0;
	Image un_poisson, deux_poissons, trois_poissons;
	ArrayList <Image> pingouinImage;
	Modele_Joueur joueur_courant;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Vue_Jeu window = new Vue_Jeu();
	 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	 * } }); }
	 */
	/**
	 * Create the application.
	 */

	public Vue_Jeu(Modele_Jeu j) {
		//initialize();
		this.jeu = j;

		pingouinImage = new ArrayList<>();
		chargerImage();

	}

	void chargerImage() {
		InputStream temp1 = ClassLoader.getSystemClassLoader().getResourceAsStream("un_poisson.png");
		InputStream temp2 = ClassLoader.getSystemClassLoader().getResourceAsStream("deux_poissons.png");
		InputStream temp3 = ClassLoader.getSystemClassLoader().getResourceAsStream("trois_poissons.png");
		InputStream pngjoueur1 = ClassLoader.getSystemClassLoader().getResourceAsStream("pingouin1.png");
		InputStream pngjoueur2 = ClassLoader.getSystemClassLoader().getResourceAsStream("pingouin2.png");
		InputStream pngjoueur3 = ClassLoader.getSystemClassLoader().getResourceAsStream("pingouin3.png");
		InputStream pngjoueur4 = ClassLoader.getSystemClassLoader().getResourceAsStream("pingouin4.png");
		try {
			un_poisson = ImageIO.read(temp1);
			deux_poissons = ImageIO.read(temp2);
			trois_poissons = ImageIO.read(temp3);
			try{
				Image png1 = ImageIO.read(pngjoueur1);
				Image png2 = ImageIO.read(pngjoueur2);
				Image png3 = ImageIO.read(pngjoueur3);
				Image png4 = ImageIO.read(pngjoueur4);
				pingouinImage.add(png1);
				pingouinImage.add(png2);
				pingouinImage.add(png3);
				pingouinImage.add(png4);
			}

		 catch (Exception e) {
 			System.out.println(e);
 			System.exit(1);
		}}		catch (Exception e) {
		 			System.out.println(e + "erreur 1");
		 			System.exit(1);
		 		 }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/*
	 * private void initialize() { frame = new JFrame(); frame.setBounds(100, 100,
	 * 450, 300); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	 *
	 * table = new JTable(); table.setModel(new DefaultTableModel(new Object[][] { {
	 * null, null }, { null, null }, }, new String[] { "New column", "New column"
	 * })); frame.getContentPane().add(table); }
	 */

	 public Modele_Joueur getJoueurCourant(){
		 return joueur_courant;
	 }

	 public Modele_Jeu getJeu(){
		 return jeu;
	 }

	 void afficher_plateau(Graphics2D dessin){
		 Image image_en_cours;
		 int taille_case_h = (int)getSize().height/8;
		 int taille_case_l = (int)getSize().width/16;
		 for (int h = 0; h < 8; h++) {
			 for (int l = h%2; l < 15; l++) {
				 switch (jeu.getPlateau().getValeurCase(new Point(h,l))){
					 case 1:
						 image_en_cours = un_poisson;
						 break;
					 case 2:
						 image_en_cours = deux_poissons;
						 break;
					 default:
						 image_en_cours = trois_poissons;
						 break;
				 }
				 if (jeu.getPlateau().getValeurCase(new Point(h,l)) != 0) {
					 dessin.drawImage(image_en_cours, l * taille_case_l, h * taille_case_h, taille_case_l *2 , taille_case_h , null);
				 }
			 }
		 }
	 }

	 void affiche_pingouin(Graphics2D dessin){
		 int couleur = 0;
		 Image image_en_cours;
		 int taille_case_h = (int)getSize().height/8;
		 int taille_case_l = (int)getSize().width/16;
		 for (Modele_Joueur j : jeu.getPlateau().getJoueurs()){
			 image_en_cours = pingouinImage.get(couleur);
			 for(int compteur = 0; compteur < j.getNbPingouinPose(); compteur++){
			 	 Modele_Pingouin p = j.getPingouins().get(compteur);
				 int emplacementX = taille_case_l * (int) p.getCoordonees().getX();
				 int emplacementY = taille_case_h * (int) p.getCoordonees().getY();
				 dessin.drawImage(image_en_cours, emplacementX, emplacementY, taille_case_l *2 , taille_case_h , null);
			 	}
				couleur ++;
			 }
		 }


	public void paintComponent(Graphics g){
		comp ++;
		joueur_courant = jeu.getPlateau().getJoueursIndice(comp%2);
		//System.out.println(jeu.getPlateau().getJoueurs().size());
		Graphics2D dessin = (Graphics2D)g;
		afficher_plateau(dessin);
		if(jeu.getPlateau().getJoueurs().size() > 0)
			affiche_pingouin(dessin);
		if (comp < 20){
			joueur_courant.posePingouin(new Point(1+comp,1+comp));
			repaint();
			System.out.println(comp);
		}
		else if (comp == 20){//tester joueCoup
			Modele_plateau pc = jeu.getPlateau();
			pc.Jouer_coup(joueur_courant, 1, new Point(1,1));
			System.out.println(joueur_courant.getPingouins().get(0).getCoordonees().getX() );
			repaint();
		}
	}
}
