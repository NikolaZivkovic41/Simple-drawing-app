package program;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	private ArrayList<Shape> shapes=new ArrayList<Shape>();

	public DrawingPanel(){
		setBackground(Color.white);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Iterator<Shape> iterator = shapes.iterator();
		while(iterator.hasNext()){
			Shape shape = (Shape) iterator.next();
			if(shape instanceof Point){
				shape.drawSelf(g);
			}else if(shape instanceof Line){
				shape.drawSelf(g);
			}else if(shape instanceof Square){
				shape.drawSelf(g);
				shape.fillSelf(g);
			}else if(shape instanceof Circle){
				shape.drawSelf(g);
				shape.fillSelf(g);
			}else if(shape instanceof Rectangle){
				shape.drawSelf(g);
				shape.fillSelf(g);
			}		
		}
		repaint();
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setOblici(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}	
}
