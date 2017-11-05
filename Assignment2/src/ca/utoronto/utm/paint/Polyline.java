package ca.utoronto.utm.paint;

import java.util.ArrayList;

public class Polyline {
	private Point point;
	private ArrayList<Point> points;
	private int numPoints;
	private ArrayList<Integer> xPoints = new ArrayList<Integer>();
	private ArrayList<Integer> yPoints = new ArrayList<Integer>();
	
	public Polyline() {
		this.points = new ArrayList<Point>();
		this.numPoints = 0;
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
	}
	
	public ArrayList<Point> getPoints() {
		return this.points;
	}
	
	public int getNumPoints() {
		return this.numPoints;
	}
	
	
}