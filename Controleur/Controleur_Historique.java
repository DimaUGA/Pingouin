package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vue.Vue_Historique;

public class Controleur_Historique implements MouseListener{
	private Vue_Historique vue_Histo;

	public Controleur_Historique(Vue_Historique vh) {
		this.vue_Histo = vh;
	}	

	@Override
	public void mouseClicked(MouseEvent e) {
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

	public Vue_Historique getVue_Histo() {
		return vue_Histo;
	}

	public void setVue_Histo(Vue_Historique vue_Histo) {
		this.vue_Histo = vue_Histo;
	}

}
