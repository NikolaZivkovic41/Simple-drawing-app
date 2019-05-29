package program;

import java.awt.Color;
import java.awt.Graphics;


public class Line extends Shape {
	private Point start;
	private Point end;
	
	public Line(){

	}
	public Line(Point start, Point end){
		this.start = start;
		this.end = end;
	}
	public Line(Point start, Point end,Color outer){
		this(start,end);
		setOuterColor(outer);
	}

	public void moveFor(int x, int y){
		start.setX(start.getX()+x);
		start.setY(start.getY()+y);
		end.setX(end.getX()+x);
		end.setY(end.getY()+y);		
	}

	public double length(){
		return start.distance(end);
	}

	public String toString(){
		return start+"-->"+end;
	}
	public boolean equals(Object obj){
		if(obj instanceof Line){
			Line temp = (Line) obj;
			if(start.equals(temp.gettStart()) && end.equals(temp.gettEnd()))
				return true;
			else
				return false;

		}
		else
			return false;
	}
	public Point middle(){
		int x = (start.getX() + end.getX()) / 2;
		int y = (start.getY() + end.getY()) / 2;
		return new Point(x, y);
	}
	public boolean contains(int x, int y){
		Point click = new Point(x, y);
		if(click.distance(start)+click.distance(end)-this.length()<0.5)
			return true;
		else 
			return false;
	}
	public void selected(Graphics g){
		if(isSelected()==true){
			g.setColor(Color.BLUE);
			start.setSelected(true);
		    start.selected(g);
		    end.setSelected(true);
		    end.selected(g);
		    middle().setSelected(true);
		    middle().selected(g);
		}else{
			g.setColor(Color.WHITE);
			start.setSelected(false);
		    start.selected(g);
		    end.setSelected(false);
		    end.selected(g);
		    middle().setSelected(false);
		    middle().selected(g);
		}		
	}
	public void drawSelf(Graphics g){
		g.setColor(this.getOuterColor());
		g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
		if(isSelected())
			selected(g);
	}


	public int compareTo(Object o) {
		if(o instanceof Line){
			Line temp = (Line) o;
			return (int) (this.length() - temp.length());
		}
		else
			return 0;
	}
	public Point gettStart(){
		return start;
	}
	public Point gettEnd(){
		return end;
	}
	public void settStart(Point start){
		this.start = start;
	}
	public void settEnd(Point end){
		this.end = end;
	}

	public void fillSelf(Graphics g) {
		
	}
	

	
}
