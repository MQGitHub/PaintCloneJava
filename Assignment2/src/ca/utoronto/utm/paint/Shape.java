package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

/**
 * This class creates an abstract class Shape.
 * This class should never be directly created except by it's sublcasses.
 */
public abstract class Shape {
	private Point p;
	private Color c;
	private Boolean fill = false;
	private int thickness;
	private ArrayList<Point> pts;

	
	/**
	 * Constructs a shape with specific color, thickness, filled, and a point.
	 * @param c
	 * @param thick
	 * @param b
	 * @param p
	 */
	public Shape(Color c, int thick, Boolean b, Point p) {
		this.c = c;
		this.fill = b;
		this.thickness = thick;
		this.p=p;
	}
	
	/**
	 * Constructs a shape with specific color, thickness, and an array of points.
	 * @param c
	 * @param thick
	 * @param p
	 */
	public Shape(Color c, int thick, ArrayList<Point> p) {
		this.c = c;
		this.thickness = thick;
		this.pts = p;
	}
	
	/**
	 * 
	 * @return the current point of the shape.
	 */
	public Point getCorner() {
		return p;
	}
	
	/**
	 * Modifies current point with the point in parameter.
	 * @param corner
	 */
	public void setCorner(Point corner) {
		this.p = corner;
	}
	
	/**
	 * Modifies the color of shape with the color in parameter.
	 * @param c
	 */
	public void setColor(Color c) {
		this.c = c;
	}
	
	/**
	 * 
	 * @return current color of shape.
	 */
	public Color getColor() {
		return c;
	}
	
	/**
	 * 
	 * @return Boolean value of fill.
	 */
	public Boolean isFilled() {
		return fill;
	}
	
	/**
	 * 
	 * @return integer value of thickness.
	 */
	public int getThickness() {
		return thickness;
	}
}
