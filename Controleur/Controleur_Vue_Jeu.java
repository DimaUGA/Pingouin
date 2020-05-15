package Controleur;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Controleur_Vue_Jeu extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6549791221928895502L;
	JPanel pan = new JPanel();
    int X, Y;
    char lieu;
    boolean taille;

    JComboBox<String> joueur3, joueur4;

    JButton ajouter_j3, ajouter_j4, retirer_j3, retirer_j4;

    public void setPan(){
        pan = new JPanel();
        pan.setLayout(null);
        //pan.setLayout(new FlowLayout());
        pan.setBackground(Color.CYAN);
    }

    public void finaliserPan(){
        this.setContentPane(pan);
        this.setVisible(true);
    }

    public Controleur_Vue_Jeu() {
        this.setTitle("HEY! That's my fish!");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);

        refreshValue();
        Acceuil();
        this.setContentPane(pan);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void refreshValue(){
        X = this.getSize().width;
        Y = this.getSize().height;
        taille = true;
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

    public Boolean getTaille() {
        return taille;
    }

    public void Acceuil() {
        setPan();
        lieu = 'a';
        taille = false;
        JButton bouton = new JButton("JOUER");
        JButton bouton2 = new JButton("REGLES");
        JTextArea titre = new JTextArea("HEY! That's my fish !");
        //refreshValue();
        titre.setSize(115,25);
        bouton.setBounds(3*X/8 , (int) (Y*0.4 - 20) , X/4, Y/10);
        bouton.addActionListener(new Controleur_B_JOUEZ(this));
        bouton2.setBounds(3*X/8, (int) (Y*0.5 + 20) , X/4, Y/10);
        bouton2.addActionListener(new Controleur_B_REGLES(this));
        pan.add(bouton);
        pan.add(bouton2);
        pan.add(titre, BorderLayout.CENTER);
        pan.addComponentListener(new Controleur_Taille_Fenetre(this));
        finaliserPan();
    }

    public void Regles(){
        setPan();
        lieu = 'r';
        taille = false;
        JButton bouton = new JButton("RETOUR");
        JTextArea texte = new JTextArea();
        texte.setWrapStyleWord(true);
        texte.setLineWrap(true);
        texte.setPreferredSize(new Dimension(4, 970));
        String chaine = "";
        try {
            InputStream stream = new FileInputStream("src/Controleur/regles.txt");
            Scanner scanner = new Scanner(stream);
            chaine = remplirChaine(scanner);
        }
        catch (Exception e){
            System.err.println(e);
        }
        texte.append(chaine);
        texte.setEditable(false);
        JScrollPane regles = new JScrollPane(texte);
        //refreshValue();

        bouton.setBounds((int)(X*0.375), (int)(0.76*Y), X/4, Y/10);
        bouton.addActionListener(new Controleur_B_RETOUR(this));

        regles.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //regles.setBackground(Color.RED);
        regles.setBounds((int)(X*0.1125),(int)(Y * 0.004),3 * X / 4,3 * Y / 5);
        //regles.getVerticalScrollBar().setValue(regles.getVerticalScrollBar().getMaximum());

        pan.add(regles);
        pan.add(bouton);
        pan.addComponentListener(new Controleur_Taille_Fenetre(this));
        finaliserPan();
    }

    public void Jouez(){
        setPan();
        lieu = 'j';
        taille = false;

        JButton boutonNouvellePartie = new JButton("NOUVELLE PARTIE");
        JButton boutonCharger = new JButton("CHARGER");
        JButton boutonRetourAcceuil = new JButton("RETOUR");

        //refreshValue();

        boutonNouvellePartie.addActionListener(new Controleur_Nouvelle_Partie(this));
        boutonNouvellePartie.setBounds((int)(X*0.1125),(int)(Y * 0.2),3 * X / 4,(int) (Y * 0.13));

        boutonCharger.addActionListener(new Controleur_B_RETOUR(this));
        boutonCharger.setBounds((int)(X*0.1125),(int)(Y * 0.43),3 * X / 4,(int) (Y * 0.13));

        boutonRetourAcceuil.addActionListener(new Controleur_B_RETOUR(this));
        boutonRetourAcceuil.setBounds((int)(X*0.1125),(int)(Y * 0.66),3 * X / 4,(int) (Y * 0.13));

        pan.add(boutonNouvellePartie);
        pan.add(boutonCharger);
        pan.add(boutonRetourAcceuil);
        pan.addComponentListener(new Controleur_Taille_Fenetre(this));
        finaliserPan();
    }

    public void NouvellePartie(){
        setPan();
        lieu = 'n';
        taille = false;

        JComboBox<String> joueur1 = creerComboBox(1);
        JComboBox<String> joueur2 = creerComboBox(2);
        joueur3 = creerComboBox(3);
        joueur4 = creerComboBox(4);

        joueur2.setSelectedIndex(2);
        joueur3.setSelectedIndex(4);
        joueur4.setSelectedIndex(4);
        joueur3.setVisible(false);
        joueur4.setVisible(false);

        ajouter_j3 = new JButton("Ajouter J3");
        ajouter_j4 = new JButton("Ajouter J4");
        retirer_j3 = new JButton("Supprimer J3");
        retirer_j4 = new JButton("Supprimer J4");


        ajouter_j3.setBounds((int)(X*0.1125),(int)(Y * 0.2 + (2 * Y * 0.17) ),3 * X / 4,(int) (Y * 0.125));
        ajouter_j4.setBounds((int)(X*0.1125),(int)(Y * 0.2 + (3 * Y * 0.17) ),3 * X / 4,(int) (Y * 0.125));
        retirer_j3.setBounds((int)(X*0.6000),(int)(Y * 0.2 + (2 * Y * 0.17) ), (X / 4) + 20,(int) (Y * 0.125));
        retirer_j4.setBounds((int)(X*0.6000),(int)(Y * 0.2 + (3 * Y * 0.17) ), (X / 4) + 20,(int) (Y * 0.125));
        retirer_j3.setVisible(false);
        retirer_j4.setVisible(false);
        ajouter_j3.addActionListener(new Controleur_Ajouter_J3(this));
        ajouter_j4.addActionListener(new Controleur_Ajouter_J4(this));
        retirer_j3.addActionListener(new Controleur_Retirer_J3(this));
        retirer_j4.addActionListener(new Controleur_Retirer_J4(this));

        pan.add(joueur1);
        pan.add(joueur2);
        pan.add(joueur3);
        pan.add(joueur4);
        pan.add(ajouter_j3);
        pan.add(ajouter_j4);
        pan.add(retirer_j3);
        pan.add(retirer_j4);

        JButton boutonRetour = new JButton("<");
        boutonRetour.addActionListener(new Controleur_B_RETOUR(this));
        boutonRetour.setBounds(0,0,(int)(X*0.15), (int)(Y*0.1));
        pan.add(boutonRetour);

        JButton boutonJouer = new JButton("GO");
        boutonJouer.setBounds((int)((X-(X*.15))-15),0,(int)(X*.15),(int)(Y*0.1));
        boutonJouer.addActionListener(new Controleur_GO());
        pan.add(boutonJouer);

        pan.addComponentListener(new Controleur_Taille_Fenetre(this));

        finaliserPan();
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
        //joueur1.setBounds((int)(X*0.1125),(int)(Y * 0.2 + ((numero - 1) * Y * 0.17) ),3 * X / 4,(int) (Y * 0.125));
        joueur1.setBounds((int)(X*0.1500)-25,(int)(Y * 0.2 + ((numero - 1) * Y * 0.17) ),2 * X / 4,(int) (Y * 0.125));
        return joueur1;
    }

    public String remplirChaine (Scanner s){
        String temp = "";
        while (s.hasNextLine())
            temp += s.nextLine() + "\n";
        return temp;
    }

}
