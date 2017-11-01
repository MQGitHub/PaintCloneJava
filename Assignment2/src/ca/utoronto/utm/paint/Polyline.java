package ca.utoronto.utm.paint;

public class Polyline {
	private Point[] points;
	private int numPoints;
	private int[] xPoints;
	private int[] yPoints;
	
	public Polyline(Point[] p) {
		this.points = p;
		this.numPoints = this.points.length;
	}
	
	public void setPoint(Point point) {
		this.points[numPoints-1] = point;
	}
	
	public Point getLastPoint() {
		return this.points[-1];
	}
	
	public void addPoint(Point p) {
		numPoints ++;
		this.points[numPoints-1] = p;
	}
	
	public int[] getXPoints() {
		for(int i=0; i< points.length;i++) {
			xPoints[i] = points[i].getX();
		}
		return xPoints;
	}
	
	public int[] getYPoints() {
		for(int i=0; i< points.length; i++) {
			yPoints[i] = points[i].getY();
		}
		return yPoints;
	}
	
	public int getNumPoints() {
		return numPoints;
	}

}
