package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	private ArrayList<Point> points=new ArrayList<Point>();
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public void addShape(Shape p) {
		if(shapes.size() ==0) {
			this.shapes.add(p);
		}else {
		this.shapes.add(shapes.size()-1, p);
		}
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	public void addPoint(Point p){
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Point> getPoints(){
		return points;
	}
	
	
}

