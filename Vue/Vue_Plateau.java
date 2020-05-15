package Vue;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import Modele.*;

public class Vue_Plateau extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2939762000101472146L;
	Image un_poisson, deux_poissons, trois_poissons;
	ArrayList <Image> pingouinImage;
	Modele_plateau plateau ;
	
	public Vue_Plateau() {
		pingouinImage = new ArrayList<>();
		chargerImage();

		this.setBackground(Color.DARK_GRAY);
		repaint();
		
	}

	public void ajouterListener(MouseListener souris){
		this.addMouseListener(souris);
	}

	void chargerImage() {
		InputStream temp1 = ClassLoader.getSystemClassLoader().getResourceAsStream("un_poisson.png");
		InputStream temp2 = ClassLoader.getSystemClassLoader().getResourceAsStream("deux_poisson.png");
		InputStream temp3 = ClassLoader.getSystemClassLoader().getResourceAsStream("trois_poissons.png");
		InputStream pngjoueur1 = ClassLoader.getSystemClassLoader().getResourceAsStream("pingouin1.png");
		InputStream pngjoueur2 = ClassLoader.getSystemClassLoader().getResourceAsStream("pingouin2.png");
		InputStream pngjoueur3 = ClassLoader.getSystemClassLoader().getResourceAsStream("pingouin3.png");
		InputStream pngjoueur4 = ClassLoader.getSystemClassLoader().getResourceAsStream("pingouin4.png");
		try {
			un_poisson = ImageIO.read(temp1);
			deux_poissons = ImageIO.read(temp2);
			trois_poissons = ImageIO.read(temp3);
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
			System.out.println(e );
			System.exit(1);
		 }
	}
	 
	 void afficher_plateau(Graphics2D dessin){
		 Image image_en_cours;
		 int taille_case_h = (int)(getSize().height/8*0.96);
		 int taille_case_l = (int)getSize().width/16;
		 for (int h = 0; h < 8; h++) {
			 for (int l = h%2; l < 15; l++) {
				 switch (plateau.getMonplateau()[h][l]){
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
				 if(h%2==1) {
					 if (plateau.getMonplateau()[h][l] != 0) {
						 dessin.drawImage(image_en_cours, l * taille_case_l, h * taille_case_h, taille_case_l *2 , (int)(taille_case_h*1.35), null);
					 }
				 }else {
					 if (plateau.getMonplateau()[h][l] != 0) {
						 dessin.drawImage(image_en_cours, l * taille_case_l, h * taille_case_h, taille_case_l *2 , (int)(taille_case_h*1.35) , null);
					 }
				 }
			 }
		 }
	 }

	 void affiche_pingouin(Graphics2D dessin){
		 int couleur = 0;
		 Image image_en_cours;
		 int taille_case_h = (int)(getSize().height/8*0.96);
		 int taille_case_l = (int)getSize().width/16;
		 for(Modele_Joueur_abs joueur : this.plateau.getJoueurs()) {
			 image_en_cours = pingouinImage.get(couleur);
			 for (Modele_Pingouin px : joueur.getPingouins()) {
				if((int) px.getCoordonees().getX()>=0) {
					 int emplacementX = taille_case_l * (int) px.getCoordonees().getX();
					 int emplacementY = taille_case_h * (int) px.getCoordonees().getY();
					 dessin.drawImage(image_en_cours, (int)(emplacementX+7), (int)(emplacementY+13),(int) ((taille_case_l * 2)*0.8)  ,(int)(taille_case_h*0.8) , null);
				}
			 }
			 couleur ++;
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D dessin = (Graphics2D)g;
		afficher_plateau(dessin);
		if(this.plateau.getJoueurs().size() > 0)
			affiche_pingouin(dessin);
	}

	public JPanel getPanel() {
		return this;
	}
	
	public JPanel getFrame() {
		return this;
	}
	
	public JPanel getFenetre (){
		return this;
	}
	
	public void setPlateau(Modele_plateau mp) {
		this.plateau = mp ;
	}
}
