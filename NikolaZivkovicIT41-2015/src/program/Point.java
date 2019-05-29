package program;

import java.awt.Color;
import java.awt.Graphics;


public class Point extends Shape {
	private int x;
	private int y;
	
	public Point(){

	}
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point(int x, int y, Color outer){
		this(x, y);
		setOuterColor(outer);
	}
	
	public void moveTo(int newX, int newY){
		x = newX;
		setY(newY);
	}
	public void moveFor(int newX, int newY){
		x = x + newX;
		setY(getY()+newY);
	}

	public double distance(Point t2){
		double dx = x - t2.getX();
		double dy = y - t2.getY();
		double result = Math.sqrt(dx*dx + dy*dy);

		return result;
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}

	public boolean contains(int x, int y){
		Point click = new Point(x, y);
		if(click.distance(this)<=2)
			return true;
		else
			return false;
	}
	
	public void selected(Graphics g){
		if(isSelected()==true){
			g.setColor(Color.blue);
		    g.drawRect(x-3, y-3, 6, 6);
		}else{
			g.setColor(Color.WHITE);
		    g.drawRect(x-3, y-3, 6, 6);
		}		
	}
	
	public void drawSelf(Graphics g) {
		g.setColor(this.getOuterColor());
		g.drawLine(x+2, y, x-2, y);
		g.drawLine(x, y-2, x, y+2);
		if(isSelected())
			selected(g);
	}
	
	public void delete(Graphics g){
		this.x=0;
		this.y=0;
		this.setOuterColor(Color.WHITE);
		g.setColor(Color.WHITE);
		this.setSelected(false);
		this.selected(g);
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
	public void fillSelf(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
