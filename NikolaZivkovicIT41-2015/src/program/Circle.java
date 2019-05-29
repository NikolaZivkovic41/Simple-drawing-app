package program;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	private Point center;
	private int r;
	
	
	public Circle(){
		
	}
	public Circle(Point center, int r){
		this.center = center;
		this.r = r;
	}
	public Circle(Point center, int r,Color innerColor,Color outerColor){
		this(center, r);
		setInnerColor(innerColor);
		setOuterColor(outerColor);
	}
	public void moveTo(int x, int y){
		center.moveTo(x, y);
	}
	public void moveFor(int x, int y){
		center.moveFor(x, y);
	}
	public double surfaceArea(){
		return r * r * Math.PI;
	}
	public double volume(){
		return 2 * r * Math.PI;
	}

	public String toString(){
		return "Center="+center+", radius="+r;
	}
	public boolean equals(Object obj){
		if(obj instanceof Circle){
			Circle temp = (Circle) obj;
			if(center.equals(temp.center) && r == temp.r)
				return true;
			else
				return false;

		}
		else
			return false;
	}
	public boolean contains(int x, int y){
		Point temp = new Point(x, y);
		if(temp.distance(center)<=r)
			return true;
		else
			return false;
		
	}
	public void selected(Graphics g) {
		if(isSelected()==true){
			Line diag=new Line(new Point(center.getX(), center.getY()-r), new Point(center.getX(), center.getY() + r));
			diag.setSelected(true);
			diag.selected(g);
			Line hori=new Line(new Point(center.getX()-r, center.getY()), new Point(center.getX()+r, center.getY()));
			hori.setSelected(true);
			hori.selected(g);
		}else{
			Line diag=new Line(new Point(center.getX(), center.getY()-r), new Point(center.getX(), center.getY() + r));
			diag.setSelected(false);
			diag.selected(g);
			Line hori=new Line(new Point(center.getX()-r, center.getY()), new Point(center.getX()+r, center.getY()));
			hori.setSelected(false);
			hori.selected(g);
		}	
	}
	public void drawSelf(Graphics g){
		g.setColor(this.getOuterColor());
		g.drawOval(center.getX()-r, center.getY()-r, 2*r, r+r);
		if(isSelected())
			selected(g);
	}
	public void fillSelf(Graphics g) {
		g.setColor(this.getInnerColor());
		g.fillOval(center.getX()-r+1, center.getY()-r+1, 2*r-2, r+r-2);
		
	}
	public int compareTo(Object o) {
		if(o instanceof Circle){
			Circle temp = (Circle) o;
			return (int) (this.r - temp.r);
		}
		else
			return 0;
	}
	
	
	public Point getCenter() {
		return center;
	}
	public int getR() {
		return r;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public void setR(int r) {
		this.r = r;
	}

	
	
	
}
