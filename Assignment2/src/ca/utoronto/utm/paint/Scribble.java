package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

public class Scribble extends Observable{
	@SuppressWarnings("rawtypes")
	private ArrayList<ArrayList> points=new ArrayList<ArrayList>();

	private ArrayList<Point> coordinates =new ArrayList<Point>();

	public void setCurrent(Point p) {
		coordinates.add(p);
	
	}
	public void addPoint() {
		this.points.add(coordinates);
		this.setChanged();
		this.notifyObservers();
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Point> getPoints() {
		return points.get(points.size());
	}


	
	
}
