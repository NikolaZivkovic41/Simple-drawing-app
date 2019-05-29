package program;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape{
	private Color innerColor;
	private Color outerColor;
	private boolean selected;

	public abstract void drawSelf(Graphics g);
	public abstract void selected(Graphics g);
	public abstract boolean contains(int x, int y);
	public abstract void fillSelf(Graphics g);
	
	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public Color getOuterColor() {
		return outerColor;
	}

	public void setOuterColor(Color outerColor) {
		this.outerColor = outerColor;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
