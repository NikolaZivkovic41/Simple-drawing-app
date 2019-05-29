package program;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
	private Point start;
	private int length;
	private int height;
	

	public Rectangle(){

	}
	public Rectangle(Point start, int length, int height){
		this.start = start;
		this.length = length;
		this.height = height;
	}
	public Rectangle(Point start, int length, int height,Color inner,Color outer){
		this(start,length,height);
		setInnerColor(inner);
		setOuterColor(outer);
	}

	public int surface(){
		return height * length;
	}
	public int volume(){
		return  2 * height + 2 * length;
	}

	public String toString(){
		return "Start="+start+", length="+length+", height="+height;
	}

	public boolean equals(Object obj){
		if(obj instanceof Rectangle){
			Rectangle temp = (Rectangle) obj;
			if(start.equals(temp.start) && length == temp.length && height == temp.height)
				return true;
			else
				return false;

		}
		else
			return false;
	}
	public Line diagonal(){
		return new Line(start, new Point(start.getX() + length,start.getY() + height));
	}
	public Point center(){
		return diagonal().middle();
	}
	public void selected(Graphics g) {
		if(isSelected()==true){
			g.setColor(Color.BLUE);
			Line up=new Line(getStart(), new Point(getStart().getX()+length, getStart().getY()));
			up.setSelected(true);
			up.selected(g);
			Line left=new Line(getStart(), new Point(getStart().getX(), getStart().getY()+height));
			left.setSelected(true);
			left.selected(g);
			Line right=new Line(new Point(getStart().getX()+length, getStart().getY()), diagonal().gettEnd());
			right.setSelected(true);
			right.selected(g);
			Line down=new Line(new Point(getStart().getX(), getStart().getY()+height), diagonal().gettEnd());
			down.setSelected(true);
			down.selected(g);
		}else{
			g.setColor(Color.WHITE);
			Line up=new Line(getStart(), new Point(getStart().getX()+length, getStart().getY()));
			up.setSelected(false);
			up.selected(g);
			Line left=new Line(getStart(), new Point(getStart().getX(), getStart().getY()+height));
			left.setSelected(false);
			left.selected(g);
			Line right=new Line(new Point(getStart().getX()+length, getStart().getY()), diagonal().gettEnd());
			right.setSelected(false);
			right.selected(g);
			Line down=new Line(new Point(getStart().getX(), getStart().getY()+height), diagonal().gettEnd());
			down.setSelected(false);
			down.selected(g);
		}
	}
	public boolean contains(int x, int y) {
		if(this.getStart().getX()<=x 
				&& x<=(this.getStart().getX() + length)
				&& this.getStart().getY()<=y 
				&& y<=(this.getStart().getY() + height))
			return true;
		else 
			return false;

	}
	public void drawSelf(Graphics g){
		g.setColor(this.getOuterColor());
		g.drawRect(start.getX(), start.getY(), length, height);
		if(isSelected())
			selected(g);
	}
	public void fillSelf(Graphics g) {
		g.setColor(this.getInnerColor());
		g.fillRect(start.getX()+1, start.getY()+1, length-1, height-1);
		
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Point getStart() {
		return start;
	}
	public void setStart(Point start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
