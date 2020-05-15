package Modele;

import java.awt.Point;

public class Modele_Coup {
	Point p;
	int pingouinAJouer;
	
	public Modele_Coup() {
		this.p = new Point();
		this.pingouinAJouer = 0;
	}
	
	public Point getPoint() {
		return this.p;
	}
	
	public int getPingouin() {
		return this.pingouinAJouer;
	}
	
	public void setPoint(int x, int y) {
		this.p.setLocation(x, y);
	}
	
	public void setPingouin(int num) {
		this.pingouinAJouer = num;
	}
	
	public void setAll(int x, int y, int num) {
		this.setPoint(x, y);
		this.setPingouin(num);
	}
}
