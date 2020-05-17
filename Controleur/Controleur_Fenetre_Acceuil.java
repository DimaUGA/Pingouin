package Controleur;

import javax.swing.*;
import java.awt.*;

public class Controleur_Fenetre_Acceuil extends JComponent {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2827705133758228991L;
	int X,Y;
    Controleur_Vue_Jeu cvj;
    public Controleur_Fenetre_Acceuil(Controleur_Vue_Jeu cvj){
        Acceuil();
        X = 0;
        Y = 0;
        this.cvj = cvj;
    }

    public void Acceuil() {
        JButton bouton = new JButton("JOUEZ");
        JButton bouton2 = new JButton("REGLES");
        this.setLayout(null);
        this.setBackground(Color.CYAN);
        refreshValue();
        bouton.setBounds(3*X/8 , (int) (Y*0.4 - 20) , X/4, Y/10);
        System.out.println(cvj.getSize().height);
       //bouton.addActionListener(new Controleur_B_JOUEZ(this));

        bouton2.setBounds(3*X/8, (int) (Y*0.5 + 20) , X/4, Y/10);
        //bouton2.addActionListener(new Controleur_B_REGLES(this));
        this.add(bouton);
        this.add(bouton2);
    }

    public void refreshValue(){
        X = this.getSize().width;
        Y = this.getSize().height;
    }


}
