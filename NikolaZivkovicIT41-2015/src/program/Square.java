package program;

import java.awt.Color;
import java.awt.Graphics;


public class Square extends Shape {
	private Point start;
	private int length;
	
	public Square(){}
	
	public Square(Point start, int length){
		this.start = start;
		this.length = length;
	}
	
	public Square(Point start, int length,Color inner,Color outer){
		this(start,length);
		setInnerColor(inner);
		setOuterColor(outer);
	}
	
	public void moveTo(int x, int y){
		start.setX(x);
		start.setY(y);
	}

	public void moveFor(int x, int y){
		start.setX(start.getX()+x);
		start.setY(start.getY()+y);
	}

	public int volume(){
		return 4 * length;
	}
	public int surface(){
		return length * length;
	}

	public String toString(){
		return "Start="+start+", length="+length;
	}
	
	public Line diagonal(){
		return new Line(start, new Point(start.getX() + length,start.getY() + length));
	}

	public Point center(){
		return diagonal().middle();
	}
	public boolean contains(int x, int y) {
		if(this.getStart().getX()<=x 
				&& x<=(this.getStart().getX() + length)
				&& this.getStart().getY()<=y 
				&& y<=(this.getStart().getY() + length))
			return true;
		else 
			return false;

	}
	public void selected(Graphics g) {
		if(isSelected()==true){
			g.setColor(Color.blue);
			Line up=new Line(getStart(), new Point(getStart().getX()+length, getStart().getY()));
			up.setSelected(true);
			up.selected(g);
			Line left=new Line(getStart(), new Point(getStart().getX(), getStart().getY()+length));
			left.setSelected(true);
			left.selected(g);
			Line right=new Line(new Point(getStart().getX()+length, getStart().getY()), diagonal().gettEnd());
			right.setSelected(true);
			right.selected(g);
			Line down=new Line(new Point(getStart().getX(), getStart().getY()+length), diagonal().gettEnd());
			down.setSelected(true);
			down.selected(g);
		}else{
			g.setColor(Color.WHITE);
			Line up=new Line(getStart(), new Point(getStart().getX()+length, getStart().getY()));
			up.setSelected(false);
			up.selected(g);
			Line left=new Line(getStart(), new Point(getStart().getX(), getStart().getY()+length));
			left.setSelected(false);
			left.selected(g);
			Line right=new Line(new Point(getStart().getX()+length, getStart().getY()), diagonal().gettEnd());
			right.setSelected(false);
			right.selected(g);
			Line down=new Line(new Point(getStart().getX(), getStart().getY()+length), diagonal().gettEnd());
			down.setSelected(false);
			down.selected(g);
		}
	}
	public void drawSelf(Graphics g){
		g.setColor(this.getOuterColor());
		g.drawRect(start.getX(), start.getY(), length, length);
		if(isSelected())
			selected(g);
	}
	
	public void fillSelf(Graphics g) {
		g.setColor(this.getInnerColor());
		g.fillRect(start.getX()+1, start.getY()+1, length-1, length-1);
		
	}
	public Point getStart() {
		return start;
	}
	public int getLength() {
		return length;
	}
	public void setStart(Point start) {
		this.start = start;
	}
	public void setLength(int length) {
		this.length = length;
	}

	
	
	
}
