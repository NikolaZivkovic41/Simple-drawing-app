package program;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Oblik{
	private Tacka goreLevo;
	private int duzinaStranice;
	private int visina;
	

	public Pravougaonik(){

	}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina){
		this.goreLevo = goreLevo;
		this.duzinaStranice = sirina;
		this.visina = visina;
	}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina,Color unuBoja,Color spoljBoja){
		this(goreLevo,sirina,visina);
		setUnuBoja(unuBoja);
		setSpoljBoja(spoljBoja);
	}

	public int povrsina(){
		return visina * duzinaStranice;
	}
	public int obim(){
		return  2 * visina + 2 * duzinaStranice;
	}

	public String toString(){
		return "Tacka gore levo="+goreLevo+", sirina="+duzinaStranice+", visina="+visina;
	}

	public boolean equals(Object obj){
		if(obj instanceof Pravougaonik){
			Pravougaonik pomocni = (Pravougaonik) obj;
			if(goreLevo.equals(pomocni.goreLevo) && duzinaStranice == pomocni.duzinaStranice && visina == pomocni.visina)
				return true;
			else
				return false;

		}
		else
			return false;
	}
	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX() + duzinaStranice,goreLevo.getY() + visina));
	}
	public Tacka centar(){
		return dijagonala().sredinaLinije();
	}
	public void selektovan(Graphics g) {
		if(isSelektovan()==true){
			g.setColor(Color.BLUE);
			Linija gore=new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()));
			gore.setSelektovan(true);
			gore.selektovan(g);
			Linija levo=new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+visina));
			levo.setSelektovan(true);
			levo.selektovan(g);
			Linija desno=new Linija(new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja());
			desno.setSelektovan(true);
			desno.selektovan(g);
			Linija dole=new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+visina), dijagonala().gettKrajnja());
			dole.setSelektovan(true);
			dole.selektovan(g);
		}else{
			g.setColor(Color.WHITE);
			Linija gore=new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()));
			gore.setSelektovan(false);
			gore.selektovan(g);
			Linija levo=new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+visina));
			levo.setSelektovan(false);
			levo.selektovan(g);
			Linija desno=new Linija(new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja());
			desno.setSelektovan(false);
			desno.selektovan(g);
			Linija dole=new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+visina), dijagonala().gettKrajnja());
			dole.setSelektovan(false);
			dole.selektovan(g);
		}
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + duzinaStranice)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + visina))
			return true;
		else 
			return false;

	}
	public void crtajSe(Graphics g){
		g.setColor(this.getSpoljBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), duzinaStranice, visina);
		if(isSelektovan())
			selektovan(g);
	}
	public void popuni(Graphics g) {
		g.setColor(this.getUnuBoja());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, duzinaStranice-1, visina-1);
		
	}
	public int getVisina() {
		return visina;
	}
	public void setVisina(int visina) {
		this.visina = visina;
	}
	public Tacka getGoreLevo() {
		return goreLevo;
	}
	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}
	public int getDuzinaStranice() {
		return duzinaStranice;
	}
	public void setDuzinaStranice(int duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}
}
