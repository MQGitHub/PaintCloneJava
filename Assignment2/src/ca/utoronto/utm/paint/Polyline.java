package ca.utoronto.utm.paint;

import java.util.ArrayList;

public class Polyline {
	private Point[] points;
	private int numPoints = 0;
	private ArrayList<Integer> xPoints = new ArrayList<Integer>();
	private ArrayList<Integer> yPoints = new ArrayList<Integer>();
	
	

	public Polyline(Point p) {
		points[0] = p;
	}
	
	public void addEndPoint(Point p) {
		this.points[1] = p;
		
		addPoint();
		
	}
	
//	public void setPoint(Point point) {
//		this.points[numPoints-1] = point;
//	}
	
//	public Point getLastPoint() {
//		return this.points[-1];
//	}
	
//	public void addPoint(Point p) {
//		numPoints ++;
//		this.points[numPoints-1] = p;
//	}

	public void addPoint() {
		//bottom left of triangle
		
		xPoints.add(0, points[0].getX());
		yPoints.add(0,points[1].getY());
		
		//top of triangle
		
		xPoints.add(1, (points[0].getX() +points[1].getX())/2);
		yPoints.add(1, points[0].getY());
		
		//bottom right of triangle

		
		xPoints.add(2, points[1].getX());
		yPoints.add(2,points[1].getY());
		

		this.numPoints = 3;
	}
	public int[] getXPoints() {
//		for(int i=0; i< numPoints;i++) {
//			xPoints[i] = points[i].getX();
//		}
		return xPoints;
	}
	
	public int[] getYPoints() {
//		for(int i=0; i< points.length; i++) {
//			yPoints[i] = points[i].getY();
//		}
		return yPoints;
	}
	
	public int getNumPoints() {
		return numPoints;
	}

	
	
}