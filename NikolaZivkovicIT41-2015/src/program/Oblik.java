package program;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik{
	private Color unuBoja;
	private Color spoljBoja;
	private boolean selektovan;

	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x, int y);
	public abstract void popuni(Graphics g);
	
	public Color getUnuBoja() {
		return unuBoja;
	}

	public void setUnuBoja(Color unuBoja) {
		this.unuBoja = unuBoja;
	}

	public Color getSpoljBoja() {
		return spoljBoja;
	}

	public void setSpoljBoja(Color spoljBoja) {
		this.spoljBoja = spoljBoja;
	}
	public boolean isSelektovan() {
		return selektovan;
	}
	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
	
	
}
