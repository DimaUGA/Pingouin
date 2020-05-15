package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vue.Vue_Regles;

public class Controleur_Regles implements MouseListener{

	private Vue_Regles vue_Regles;

	public Controleur_Regles(Vue_Regles vue_regles) {
		this.vue_Regles = vue_regles;
	}

	public Vue_Regles getRegles() {
		return vue_Regles;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		System.out.println(e.getComponent().getName());
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
