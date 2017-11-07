package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * 
 * A Polyline is a Shape and has a non-negative startPoint, endPoint, and an
 * arraylist of points to keep track of all the points in the polyline.
 *
 */
public class Polyline extends Shape {
	private ArrayList<Point> points;
	private int numPoints;
	private Point startPoint;
	private Point endPoint;

	/**
	 * Constructs a shape of type Oval with a specific color, 
	 * thickness, is filled, start.
	 * 
	 * @param c
	 *            The color the polyline is
	 * @param t
	 *            The thickness the polyline is
	 * @param b
	 *            The fill of the polyline
	 * @param start
	 *            The beginning point of the polyline
	 */

	public Polyline(Color c, int t, Boolean b, Point start) {
		super(c, t, b, start);
		this.points = new ArrayList<Point>();
		this.numPoints = 0;
		this.startPoint = new Point(-1, -1);
		this.endPoint = new Point(-1, -1);
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
		numPoints++;
		if (this.points.size() == 2 && this.points.get(0).getX() == this.points.get(1).getX()
				&& this.points.get(0).getY() == this.points.get(1).getY()) {
			this.points = new ArrayList<Point>();
		}
	}

	/**
	 * 
	 * @return if Polyline is a closed shape completely.
	 */
	public boolean completedPolyline() {
		if (this.points.size() > 2 && this.points.get(0).getX() == this.points.get(this.points.size() - 1).getX()
				&& this.points.get(0).getY() == this.points.get(this.points.size() - 1).getY()) {
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
	 * Set the start point for new polyline.
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
	 * @return the start point of the polyline.
	 */
	public Point getStartPoint() {
		return this.startPoint;
	}

	/**
	 * Set the end point for new polyline.
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
	 * @return the end point for new polyline.
	 */
	public Point getEndPoint() {
		return this.endPoint;
	}

	@Override
	public void draw(Graphics2D g2d) {
		ArrayList<Point> polylinePoints = this.getPoints();
		for (int i = 0; i < polylinePoints.size() - 1; i++) {
			Point p1 = polylinePoints.get(i);
			Point p2 = polylinePoints.get(i + 1);
			g2d.setColor(p2.getColor());
			g2d.setStroke(new BasicStroke(p2.getThickness()));
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}

}
