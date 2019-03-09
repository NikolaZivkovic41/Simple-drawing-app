package program;

import java.awt.Color;
import java.awt.Graphics;


public class Tacka extends Oblik {
	private int x;
	private int y;
	
	public Tacka(){

	}
	public Tacka(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Tacka(int x, int y, Color spoljasnja){
		this(x, y);
		setSpoljBoja(spoljasnja);
	}
	
	public void pomeriNa(int novoX, int novoY){
		x = novoX;
		setY(novoY);
	}
	public void pomeriZa(int novoX, int novoY){
		x = x + novoX;
		setY(getY()+novoY);
	}

	public double udaljenost(Tacka t2){
		double dx = x - t2.getX();
		double dy = y - t2.getY();
		double rezultat = Math.sqrt(dx*dx + dy*dy);

		return rezultat;
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}

	public boolean sadrzi(int x, int y){
		Tacka mestoKlika = new Tacka(x, y);
		if(mestoKlika.udaljenost(this)<=2)
			return true;
		else
			return false;
	}
	
	public void selektovan(Graphics g){
		if(isSelektovan()==true){
			g.setColor(Color.blue);
		    g.drawRect(x-3, y-3, 6, 6);
		}else{
			g.setColor(Color.WHITE);
		    g.drawRect(x-3, y-3, 6, 6);
		}		
	}
	
	public void crtajSe(Graphics g) {
		g.setColor(this.getSpoljBoja());
		g.drawLine(x+2, y, x-2, y);
		g.drawLine(x, y-2, x, y+2);
		if(isSelektovan())
			selektovan(g);
	}
	
	public void izbrisi(Graphics g){
		this.x=0;
		this.y=0;
		this.setSpoljBoja(Color.WHITE);
		g.setColor(Color.WHITE);
		this.setSelektovan(false);
		this.selektovan(g);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void popuni(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
