package Vue;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modele.Modele_plateau;

public class Vue_Jeu {

	private JFrame frame;
	private JTable table;

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

	public Vue_Jeu() {
		// initialize();
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

	public void Affiche_tableau(Modele_plateau plateau) {
		for (int k = 0; k < 8; k++) {
			for (int l = 0; l < 15; l++) {
				System.out.print(plateau.getValeurCase(new Point(k, l)));
			}
			System.out.println();
		}
	}

}
