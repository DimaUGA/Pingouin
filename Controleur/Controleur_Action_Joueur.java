package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vue.Vue_Action_Joueur;


public class Controleur_Action_Joueur implements MouseListener{
	private Vue_Action_Joueur vaj;
	
	
	Controleur_Action_Joueur(Vue_Action_Joueur vaj){
		this.vaj =vaj;
	}

	public Vue_Action_Joueur getVueBoutons() {
		return this.vaj;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (e.getComponent().getName()) {
		case Vue_Action_Joueur.VALIDER:
			System.out.println(e.getComponent().getName());
			break;
		case Vue_Action_Joueur.SAUVEGARDER:
			System.out.println(e.getComponent().getName());	
			break;
		case Vue_Action_Joueur.AIDE:
			System.out.println(e.getComponent().getName());		
			break;
		case Vue_Action_Joueur.QUITTER:
			System.out.println(e.getComponent().getName());			
			break;

		default:
			System.out.println("default");	
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
