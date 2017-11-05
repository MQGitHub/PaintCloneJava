package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	
	private ArrayList<Polyline> polylines = new ArrayList<Polyline>();
	private Point startPoint = new Point(-1, -1);
	private Point endPoint = new Point(-1, -1);
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
	
	public void addPolyline(Polyline p) {
		this.polylines.add(p);
		this.setChanged();
		this.notifyObservers();
	}
	
	public ArrayList<Polyline> getPolylines(){
		return polylines;
	}
	
	public void setStartPoint(Point p) {
		this.startPoint = p;
	}
	
	public Point getStartPoint() {
		return this.startPoint;
	}
	
	public void setEndPoint(Point p) {
		this.endPoint = p;
	}
	
	public Point getEndPoint() {
		return this.endPoint;
	}
	
}

