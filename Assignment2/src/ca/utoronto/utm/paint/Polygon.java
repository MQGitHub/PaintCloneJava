package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * 
 * A Polygon is a Shape and has a non-negative startPoint, endPoint, and an
 * arraylist of points to keep track of all the points in the Polygon.
 *
 */
public class Polygon extends Shape {
	private ArrayList<Point> points;
	private ArrayList<Integer> xPoints;
	private ArrayList<Integer> yPoints;
	private int numPoints;
	private Point startPoint;
	private Point endPoint;
	private double radius;

	/**
	 * Constructs a shape of type Oval with a specific color, 
	 * thickness, is filled, start.
	 * 
	 * @param c
	 *            The color the Polygon is
	 * @param t
	 *            The thickness the Polygon is
	 * @param b
	 *            The fill of the Polygon
	 * @param start
	 *            The beginning point of the Polygon
	 * @param stroke 
	 */

	public Polygon(Color c, int t, int b, Point start, BasicStroke stroke) {
		super(c, t, b, start, stroke);
		this.points = new ArrayList<Point>();
		this.xPoints = new ArrayList<Integer>();
		this.yPoints = new ArrayList<Integer>();
		this.numPoints = 0;
		this.radius = Math.sqrt(18) + (stroke.getLineWidth()/2);
	}

	/**
	 * 
	 * @return the first point from the points array.
	 */
	public Point getFirstPoint() {
		return points.get(0);
	}

	/**
	 * 
	 * @return the last point from the points array.
	 */
	public Point getLastPoint() {
		return points.get(points.size() - 1);
	}

	/**
	 * Add point in points array.
	 * 
	 * @param P
	 *            Point to add in points array.
	 */
	public void addPoint(Point P) {
		points.add(P);
		xPoints.add(P.getX());
		yPoints.add(P.getY());
		numPoints++;
		if (this.points.size() == 2 && this.points.get(0).getX() == this.points.get(1).getX()
				&& this.points.get(0).getY() == this.points.get(1).getY()) {
			this.points = new ArrayList<Point>();
			this.xPoints = new ArrayList<Integer>();
			this.yPoints = new ArrayList<Integer>();
			this.numPoints = 0;
		}
	}
	
	/**
	 * 
	 * @return if Polygon is a closed shape completely.
	 */
	public boolean completedPolygon() {
		if (this.points.size() > 2 && this.points.get(0).getX() == this.points.get(this.points.size() - 1).getX()
				&& this.points.get(0).getY() == this.points.get(this.points.size() - 1).getY()) {
			return true;
		} else if (this.points.size() > 2 && this.inRadius(this.points.get(this.points.size() - 1))) {
			this.Complete();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return the points array.
	 */
	public ArrayList<Point> getPoints() {
		return this.points;
	}

	/**
	 * 
	 * @return the number of points in the points array.
	 */
	public int getNumPoints() {
		return this.numPoints;
	}

	/**
	 * Set the start point for new Polygon.
	 * 
	 * @param p
	 *            Point to set as start point.
	 * 
	 */
	public void setStartPoint(Point p) {
		this.startPoint = p;
	}

	/**
	 * 
	 * @return the start point of the Polygon.
	 */
	public Point getStartPoint() {
		return this.startPoint;
	}

	/**
	 * Set the end point for new Polygon.
	 * 
	 * @param p
	 *            Point to set as end point.
	 * 
	 */
	public void setEndPoint(Point p) {
		this.endPoint = p;
	}

	/**
	 * 
	 * @return the end point for new Polygon.
	 */
	public Point getEndPoint() {
		return this.endPoint;
	}
	
	/**
	 * Completes the polyline, connecting last point to the first point
	 *
	 */
	public void Complete() {
		if (this.points.size() > 2) {
			this.addPoint(this.points.get(0));
		}
	}
	
	/**
	 * Check if the point is in a certain radius from the first point
	 * 
	 * @param p
	 *            Point to check distance.
	 * 
	 */
	public boolean inRadius(Point p) {
		double distance = Math.abs(Math.sqrt(Math.pow((this.points.get(0).getX() - p.getX()), 2) 
				+ Math.pow((this.points.get(0).getY() - p.getY()), 2)));
		return distance < radius;
	}

	@Override
	public void draw(Graphics2D g2d) {
		Point p1 = this.getStartPoint();
		Point p2 = this.getEndPoint();
		if (p1.getX() != p2.getX() || p1.getY() == p2.getY()) {
			g2d.setColor(this.getEndPoint().getColor());
			g2d.setStroke(this.getStroke());
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
		if (this.points.size() > 0) {
			g2d.setColor(this.points.get(this.points.size() - 1).getColor());
			g2d.setStroke(this.getStroke());
			//Taken from https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java
			//Shortest way to convert arraylist of ints to array of ints
			int arrXPoints [] = xPoints.stream().mapToInt(Integer::intValue).toArray();
			int arrYPoints [] = yPoints.stream().mapToInt(Integer::intValue).toArray();
			g2d.drawPolyline(arrXPoints, arrYPoints, numPoints);
		}
	}

}
