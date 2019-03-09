package program;

import java.awt.Color;
import java.awt.Graphics;

public class Krug extends Oblik {
	private Tacka centar;
	private int r;
	
	
	public Krug(){
		
	}
	public Krug(Tacka centar, int r){
		this.centar = centar;
		this.r = r;
	}
	public Krug(Tacka centar, int r,Color unuBoja,Color spoljBoja){
		this(centar, r);
		setUnuBoja(unuBoja);
		setSpoljBoja(spoljBoja);
	}
	public void pomeriNa(int x, int y){
		centar.pomeriNa(x, y);
	}
	public void pomeriZa(int x, int y){
		centar.pomeriZa(x, y);
	}
	public double povrsina(){
		return r * r * Math.PI;
	}
	public double obim(){
		return 2 * r * Math.PI;
	}

	public String toString(){
		return "Centar="+centar+", poluprecnik="+r;
	}
	public boolean equals(Object obj){
		if(obj instanceof Krug){
			Krug pomocni = (Krug) obj;
			if(centar.equals(pomocni.centar) && r == pomocni.r)
				return true;
			else
				return false;

		}
		else
			return false;
	}
	public boolean sadrzi(int x, int y){
		Tacka mestoKlika = new Tacka(x, y);
		if(mestoKlika.udaljenost(centar)<=r)
			return true;
		else
			return false;
		
	}
	public void selektovan(Graphics g) {
		if(isSelektovan()==true){
			Linija dij=new Linija(new Tacka(centar.getX(), centar.getY()-r), new Tacka(centar.getX(), centar.getY() + r));
			dij.setSelektovan(true);
			dij.selektovan(g);
			Linija hor=new Linija(new Tacka(centar.getX()-r, centar.getY()), new Tacka(centar.getX()+r, centar.getY()));
			hor.setSelektovan(true);
			hor.selektovan(g);
		}else{
			Linija dij=new Linija(new Tacka(centar.getX(), centar.getY()-r), new Tacka(centar.getX(), centar.getY() + r));
			dij.setSelektovan(false);
			dij.selektovan(g);
			Linija hor=new Linija(new Tacka(centar.getX()-r, centar.getY()), new Tacka(centar.getX()+r, centar.getY()));
			hor.setSelektovan(false);
			hor.selektovan(g);
		}	
	}
	public void crtajSe(Graphics g){
		g.setColor(this.getSpoljBoja());
		g.drawOval(centar.getX()-r, centar.getY()-r, 2*r, r+r);
		if(isSelektovan())
			selektovan(g);
	}
	public void popuni(Graphics g) {
		g.setColor(this.getUnuBoja());
		g.fillOval(centar.getX()-r+1, centar.getY()-r+1, 2*r-2, r+r-2);
		
	}
	public int compareTo(Object o) {
		if(o instanceof Krug){
			Krug pomocni = (Krug) o;
			return (int) (this.r - pomocni.r);
		}
		else
			return 0;
	}
	
	
	public Tacka getCentar() {
		return centar;
	}
	public int getR() {
		return r;
	}
	public void setCentar(Tacka centar) {
		this.centar = centar;
	}
	public void setR(int r) {
		this.r = r;
	}

	
	
	
}
