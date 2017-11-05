package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

public class Polyline extends Shape{
	private Point point;
	private ArrayList<Point> points;
	private int numPoints;
	private Point startPoint;
	private Point endPoint;
	
	public Polyline(Color c, int t, Boolean b, Point start) {
		super(c, t, b, start);
		this.points = new ArrayList<Point>();
		this.numPoints = 0;
		this.startPoint = new Point(-1, -1);
		this.endPoint = new Point(-1, -1);
	}

	public Point getFirstPoint() {
		return points.get(0);
	}

	public Point getLastPoint() {
		return points.get(points.size() - 1);
	}
	
	public void addPoint(Point P) {
		points.add(P);
		numPoints++;
		if (this.points.size() == 2 && this.points.get(0).getX() == this.points.get(1).getX()
				&& this.points.get(0).getY() == this.points.get(1).getY()) {
			this.points = new ArrayList<Point>();
		}
	}
	
	public boolean completedPolyline() {
		if (this.points.size() > 2 && this.points.get(0).getX() == this.points.get(this.points.size()-1).getX()
					&& this.points.get(0).getY() == this.points.get(this.points.size()-1).getY()) {
				return true;
		} else {
			return false;
		}
	}
	public ArrayList<Point> getPoints() {
		return this.points;
	}
	
	public int getNumPoints() {
		return this.numPoints;
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
