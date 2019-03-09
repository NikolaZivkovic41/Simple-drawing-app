package program;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class PanelCrtanja extends JPanel {
	private ArrayList<Oblik> oblici=new ArrayList<Oblik>();

	public PanelCrtanja(){
		setBackground(Color.white);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Iterator<Oblik> iterator = oblici.iterator();
		while(iterator.hasNext()){
			Oblik oblik = (Oblik) iterator.next();
			if(oblik instanceof Tacka){
				oblik.crtajSe(g);
			}else if(oblik instanceof Linija){
				oblik.crtajSe(g);
			}else if(oblik instanceof Kvadrat){
				oblik.crtajSe(g);
				oblik.popuni(g);
			}else if(oblik instanceof Krug){
				oblik.crtajSe(g);
				oblik.popuni(g);
			}else if(oblik instanceof Pravougaonik){
				oblik.crtajSe(g);
				oblik.popuni(g);
			}		
		}
		repaint();
	}

	public ArrayList<Oblik> getOblici() {
		return oblici;
	}

	public void setOblici(ArrayList<Oblik> oblici) {
		this.oblici = oblici;
	}	
}
