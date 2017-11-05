package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

public class Polyline extends Shape{
	private Point point;
	private ArrayList<Point> points;
	private int numPoints;
	private ArrayList<Integer> xPoints = new ArrayList<Integer>();
	private ArrayList<Integer> yPoints = new ArrayList<Integer>();
	
	public Polyline(Color c, int t, Boolean b, Point start) {
		super(c, t, b, start);
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

