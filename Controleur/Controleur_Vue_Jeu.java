package Controleur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controleur_Vue_Jeu extends JFrame {

    JPanel pan = new JPanel();
    int X, Y, page_courante;
    char lieu;
    ArrayList<String> listejoueur = new ArrayList<>();
    JComboBox<String> joueur1, joueur2,  joueur3, joueur4;
    JButton ajouter_j3, ajouter_j4, retirer_j3, retirer_j4, bouton_precedent, bouton_suivant;
    JLabel page_1, page_2, page_3, page_4, page_5, page_6, page_7, page_8, page_9, page_10;



    public Controleur_Vue_Jeu() {
        this.setTitle("PINGOUINS");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        getTaille_Fenetre();
        Acceuil();
        this.setContentPane(pan);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setPan(){
        pan = new JPanel();
        pan.setLayout(null);
    }

    public void finaliserPan(){
        this.setContentPane(pan);
        this.setVisible(true);
    }

    public void getTaille_Fenetre(){
        X = this.getSize().width;
        Y = this.getSize().height;
    }

    private JButton Ajouter_Bouton(int x, int y, int largeur, int hauteur, String chemin_image){

        ImageIcon icone = new ImageIcon(chemin_image);
        Image image = icone.getImage();
        image = image.getScaledInstance(largeur,hauteur,java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(image);

        JButton bouton = new JButton(icone);
        bouton.setBounds(x,y,largeur,hauteur);
        setBoutonTransparent(bouton);

        return bouton;
    }

    private JLabel Ajouter_Label(int x, int y, int largeur, int hauteur, String chemin_image, boolean visible){

        ImageIcon icone = new ImageIcon(chemin_image);
        Image image = icone.getImage();
        image = image.getScaledInstance(largeur,hauteur,java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(image);

        JLabel label = new JLabel();
        label.setBounds(x,y,largeur,hauteur);
        label.setIcon(icone);
        label.setVisible(visible);
        return label;
    }

    public char getLieu() {
        return lieu;
    }

    public void setVisibleJ3(boolean b){
        if (b) {
            joueur3.setSelectedIndex(0);
            ajouter_j3.setVisible(false);
            joueur3.setVisible(true);
            retirer_j3.setVisible(true);
        }
        else{
            joueur3.setSelectedIndex(4);
            ajouter_j3.setVisible(true);
            joueur3.setVisible(false);
            retirer_j3.setVisible(false);
            setVisibleJ4(false);
        }
    }

    public void setVisibleJ4(boolean b){
        if (b) {
            joueur4.setSelectedIndex(0);
            ajouter_j4.setVisible(false);
            joueur4.setVisible(true);
            retirer_j4.setVisible(true);
        }
        else{
            joueur4.setSelectedIndex(4);
            ajouter_j4.setVisible(true);
            joueur4.setVisible(false);
            retirer_j4.setVisible(false);
        }
    }

    private void setArrierePlan(){

        ImageIcon image_arriere_plan = new ImageIcon("src/ImagesBoutons/ARRIERE_PLAN.png");
        Image image4 = image_arriere_plan.getImage();
        image4 = image4.getScaledInstance(400,500,java.awt.Image.SCALE_SMOOTH);
        image_arriere_plan = new ImageIcon(image4);

        JLabel arriere_plan = new JLabel();
        arriere_plan.setIcon(image_arriere_plan);
        arriere_plan.setBounds(0,0,400,500);
        pan.add(arriere_plan);
    }

    private void setBoutonTransparent(JButton bouton){
        bouton.setOpaque(false);
        bouton.setContentAreaFilled(false);
        bouton.setBorderPainted(false);
    }

    public ArrayList<String> getListejoueur() {
        return listejoueur;
    }

    public void Acceuil() {

        setPan();
        lieu = 'a';

        ImageIcon icone_titre = new ImageIcon("src/ImagesBoutons/TITRE.png");
        Image image_titre = icone_titre.getImage();
        image_titre = image_titre.getScaledInstance(3 * X / 4,(int) (Y * 0.20),java.awt.Image.SCALE_SMOOTH);
        icone_titre = new ImageIcon(image_titre);

        JLabel titre = new JLabel();
        titre.setIcon(icone_titre);
        titre.setBounds((X/8)-5 , (int) (Y*0.4)-150 , 3 * X / 4,(int) (Y * 0.25));


        JButton bouton_retour = Ajouter_Bouton((X/8)-5,(int)(Y*0.4 - 20)+50,3 * X / 4,(int) (Y * 0.13)
                ,"src/ImagesBoutons/JOUER.png");
        JButton bouton_regles = Ajouter_Bouton((X/8)-5, (int) (Y*0.5 + 20)+50, 3 * X / 4,(int)(Y * 0.13)
                ,"src/ImagesBoutons/REGLES.png");

        bouton_retour.addActionListener(new Controleur_B_JOUEZ(this));
        bouton_regles.addActionListener(new Controleur_B_REGLES(this));

        pan.add(bouton_retour);
        pan.add(bouton_regles);
        pan.add(titre);

        setArrierePlan();
        finaliserPan();
    }

    public void Regles(){
        setPan();
        lieu = 'r';
        page_courante = 1;

        page_1 = Ajouter_Label(43, 10, 300, 350, "src/ImagesBoutons/PAGE_1.png", true);
        page_2 = Ajouter_Label(43, 10, 300, 350, "src/ImagesBoutons/PAGE_2.png", false);
        page_3 = Ajouter_Label(43, 10, 300, 350, "src/ImagesBoutons/PAGE_3.png", false);
        page_4 = Ajouter_Label(43, 10, 300, 350, "src/ImagesBoutons/PAGE_4.png", false);
        page_5 = Ajouter_Label(43, 10, 300, 350, "src/ImagesBoutons/PAGE_5.png", false);
        page_6 = Ajouter_Label(43, 10, 300, 350, "src/ImagesBoutons/PAGE_6.png", false);
        page_7 = Ajouter_Label(43, 10, 300, 350, "src/ImagesBoutons/PAGE_7.png", false);
        page_8 = Ajouter_Label(43, 10, 300, 350, "src/ImagesBoutons/PAGE_8.png", false);
        page_9 = Ajouter_Label(43, 10, 300, 350, "src/ImagesBoutons/PAGE_9.png", false);
        page_10 = Ajouter_Label(43, 10, 300, 350, "src/ImagesBoutons/PAGE_10.png", false);

        JButton bouton_retour = Ajouter_Bouton((X/8)-5,(int) (Y*0.5 + 20)+110, 3 * X / 4,(int) (Y * 0.13)
                ,"src/ImagesBoutons/RETOUR.png");
        bouton_precedent = Ajouter_Bouton(15,170,14,45
                ,"src/ImagesBoutons/PRECEDENT.png");
        bouton_suivant = Ajouter_Bouton(355,170,14,45
                ,"src/ImagesBoutons/SUIVANT.png");

        bouton_precedent.setVisible(false);

        bouton_retour.addActionListener(new Controleur_B_RETOUR(this));
        bouton_precedent.addActionListener(new Controleur_Precedent(this));
        bouton_suivant.addActionListener(new Controleur_Suivant(this));

        pan.add(page_1);
        pan.add(page_2);
        pan.add(page_3);
        pan.add(page_4);
        pan.add(page_5);
        pan.add(page_6);
        pan.add(page_7);
        pan.add(page_8);
        pan.add(page_9);
        pan.add(page_10);
        pan.add(bouton_retour);
        pan.add(bouton_precedent);
        pan.add(bouton_suivant);

        setArrierePlan();
        finaliserPan();
    }

    public void Jouez(){
        setPan();
        lieu = 'j';

        JButton boutonNouvellePartie = Ajouter_Bouton((int)(X*0.1125),(int)(Y * 0.2),3 * X / 4,(int) (Y * 0.13)
                ,"src/ImagesBoutons/NOUVELLE_PARTIE.png");
        JButton boutonCharger = Ajouter_Bouton((int)(X*0.1125),(int)(Y * 0.43),3 * X / 4,(int) (Y * 0.13)
                ,"src/ImagesBoutons/CHARGER.png");
        JButton boutonRetourAcceuil = Ajouter_Bouton((int)(X*0.1125),(int)(Y * 0.66),3 * X / 4,(int) (Y * 0.13)
                ,"src/ImagesBoutons/RETOUR.png");

        //refreshValue();

        boutonNouvellePartie.addActionListener(new Controleur_Nouvelle_Partie(this));
        boutonCharger.addActionListener(new Controleur_B_RETOUR(this));
        boutonRetourAcceuil.addActionListener(new Controleur_B_RETOUR(this));

        pan.add(boutonNouvellePartie);
        pan.add(boutonCharger);
        pan.add(boutonRetourAcceuil);

        setArrierePlan();
        finaliserPan();
    }

    public void NouvellePartie(){
        setPan();
        lieu = 'n';

        joueur1 = creerComboBox(1);
        joueur2 = creerComboBox(2);
        joueur3 = creerComboBox(3);
        joueur4 = creerComboBox(4);

        joueur2.setSelectedIndex(2);
        joueur3.setSelectedIndex(4);
        joueur4.setSelectedIndex(4);
        joueur3.setVisible(false);
        joueur4.setVisible(false);


        ajouter_j3 = Ajouter_Bouton((int)(X*0.1125),(int)(Y * 0.2 + (2 * Y * 0.17) ),3 * X / 4,(int) (Y * 0.125)
                ,"src/ImagesBoutons/AJOUTER_J3.png");
        ajouter_j4 = Ajouter_Bouton((int)(X*0.1125),(int)(Y * 0.2 + (3 * Y * 0.17) ),3 * X / 4,(int) (Y * 0.125)
                ,"src/ImagesBoutons/AJOUTER_J4.png");
        retirer_j3 = Ajouter_Bouton((int)(X*0.6000),(int)(Y * 0.2 + (2 * Y * 0.17) ), (X / 4) + 20,(int) (Y * 0.125)
                ,"src/ImagesBoutons/RETIRER_J3.png");
        retirer_j4 = Ajouter_Bouton((int)(X*0.6000),(int)(Y * 0.2 + (3 * Y * 0.17) ), (X / 4) + 20,(int) (Y * 0.125)
                ,"src/ImagesBoutons/RETIRER_J4.png");

        JButton boutonRetour = Ajouter_Bouton(0,0,(int)(X*0.15), (int)(Y*0.1)
                ,"src/ImagesBoutons/RETOUR_2.png");
        JButton boutonJouer = Ajouter_Bouton((int)((X-(X*.15))-15),0,(int)(X*.15),(int)(Y*0.1)
                ,"src/ImagesBoutons/JOUER_2.png");

        retirer_j3.setVisible(false);
        retirer_j4.setVisible(false);

        ajouter_j3.addActionListener(new Controleur_Ajouter_J3(this));
        ajouter_j4.addActionListener(new Controleur_Ajouter_J4(this));
        retirer_j3.addActionListener(new Controleur_Retirer_J3(this));
        retirer_j4.addActionListener(new Controleur_Retirer_J4(this));
        boutonRetour.addActionListener(new Controleur_B_RETOUR(this));
        boutonJouer.addActionListener(new Controleur_GO(this));

        pan.add(joueur1);
        pan.add(joueur2);
        pan.add(joueur3);
        pan.add(joueur4);
        pan.add(ajouter_j3);
        pan.add(ajouter_j4);
        pan.add(retirer_j3);
        pan.add(retirer_j4);
        pan.add(boutonRetour);
        pan.add(boutonJouer);

        setArrierePlan();
        finaliserPan();
    }

    public void remplitArray(){
        listejoueur.add(joueur1.getSelectedItem().toString());
        listejoueur.add(joueur2.getSelectedItem().toString());
        if (joueur3.getSelectedItem().toString() != "---"){
            listejoueur.add(joueur3.getSelectedItem().toString());
            if(joueur4.getSelectedItem().toString() != "---") {
                listejoueur.add(joueur4.getSelectedItem().toString());
            }
        }
    }

    public JComboBox<String> creerComboBox(int numero){

        JComboBox<String> joueur1 = new JComboBox<String>();
        joueur1.setEditable(true);
        joueur1.addItem("Choisir nom joueur");
        joueur1.addItem("IA Facile");
        joueur1.addItem("IA Moyen");
        joueur1.addItem("IA Difficile");
        joueur1.addItem("---");
        joueur1.addActionListener(new Controleur_ComboBox(joueur1));
        joueur1.setBounds((int)(X*0.1500)-25,(int)(Y * 0.2 + ((numero - 1) * Y * 0.17) ),2 * X / 4,(int) (Y * 0.125));
        joueur1.setBackground(Color.decode("#3ec0d6"));
        return joueur1;
    }

}
