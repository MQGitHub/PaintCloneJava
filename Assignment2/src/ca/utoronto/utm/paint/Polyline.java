package ca.utoronto.utm.paint;

import java.util.ArrayList;

public class Polyline {
	private Point[] points;
	private int numPoints = 0;
	private ArrayList<Integer> xPoints = new ArrayList<Integer>();
	private ArrayList<Integer> yPoints = new ArrayList<Integer>();
	
	

	public Polyline(Point [] p, int numPoints) {
		this.points = p;
		this.numPoints = numPoints;
	}

	public Point getFirstPoint() {
		return points[0];
	}

	public Point getLastPoint() {
		return points[points.length - 1];
	}
	
	
	
	
	
}