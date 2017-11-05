package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	
	private ArrayList<Polyline> polylines = new ArrayList<Polyline>();
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public void addShape(Shape p) {
		if(shapes.size() ==0) {
			this.shapes.add( new Circle(Color.WHITE, 0, false, new Point(-1,-1), 0));
		}else {
		this.shapes.add(shapes.size()-1, p);
		}
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	
	
	
}

