package program;

import java.awt.Color;
import java.awt.Graphics;


public class Kvadrat extends Oblik {
	private Tacka goreLevo;
	private int duzinaStranice;
	
	public Kvadrat(){}
	
	public Kvadrat(Tacka goreLevo, int duzinaStranice){
		this.goreLevo = goreLevo;
		this.duzinaStranice = duzinaStranice;
	}
	
	public Kvadrat(Tacka goreLevo, int duzinaStranice,Color unutrasnja,Color spoljasnja){
		this(goreLevo,duzinaStranice);
		setUnuBoja(unutrasnja);
		setSpoljBoja(spoljasnja);
	}
	
	public void pomeriNa(int x, int y){
		goreLevo.setX(x);
		goreLevo.setY(y);
	}

	public void pomeriZa(int x, int y){
		goreLevo.setX(goreLevo.getX()+x);
		goreLevo.setY(goreLevo.getY()+y);
	}

	public int obim(){
		return 4 * duzinaStranice;
	}
	public int povrsina(){
		return duzinaStranice * duzinaStranice;
	}

	public String toString(){
		return "Tacka gore levo="+goreLevo+", duzina stranice="+duzinaStranice;
	}
	
	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX() + duzinaStranice,goreLevo.getY() + duzinaStranice));
	}

	public Tacka centar(){
		return dijagonala().sredinaLinije();
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + duzinaStranice)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + duzinaStranice))
			return true;
		else 
			return false;

	}
	public void selektovan(Graphics g) {
		if(isSelektovan()==true){
			g.setColor(Color.blue);
			Linija gore=new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()));
			gore.setSelektovan(true);
			gore.selektovan(g);
			Linija levo=new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice));
			levo.setSelektovan(true);
			levo.selektovan(g);
			Linija desno=new Linija(new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja());
			desno.setSelektovan(true);
			desno.selektovan(g);
			Linija dole=new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice), dijagonala().gettKrajnja());
			dole.setSelektovan(true);
			dole.selektovan(g);
		}else{
			g.setColor(Color.WHITE);
			Linija gore=new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()));
			gore.setSelektovan(false);
			gore.selektovan(g);
			Linija levo=new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice));
			levo.setSelektovan(false);
			levo.selektovan(g);
			Linija desno=new Linija(new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja());
			desno.setSelektovan(false);
			desno.selektovan(g);
			Linija dole=new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice), dijagonala().gettKrajnja());
			dole.setSelektovan(false);
			dole.selektovan(g);
		}
	}
	public void crtajSe(Graphics g){
		g.setColor(this.getSpoljBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), duzinaStranice, duzinaStranice);
		if(isSelektovan())
			selektovan(g);
	}
	
	public void popuni(Graphics g) {
		g.setColor(this.getUnuBoja());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, duzinaStranice-1, duzinaStranice-1);
		
	}
	public Tacka getGoreLevo() {
		return goreLevo;
	}
	public int getDuzinaStranice() {
		return duzinaStranice;
	}
	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}
	public void setDuzinaStranice(int duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}

	
	
	
}
