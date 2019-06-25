package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * This class creates an abstract class Shape.
 * This class should never be directly created except by it's sublcasses.
 */
public abstract class Shape {
	private Point p;
	private Color c;
	private int fill = 0;
	private int thickness;
	private BasicStroke stroke;
	

	
	/**
	 * Constructs a shape with specific color, thickness, filled, a point, and stroke type.
	 * @param c
	 * @param thick
	 * @param f
	 * @param p
	 * @param stroke 
	 */
	public Shape(Color c, int thick, int f, Point p, BasicStroke stroke) {
		this.c = c;
		this.fill = f;
		this.thickness = thick;
		this.p = p;
		this.stroke = stroke;
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
	public int fillAmt() {
		return fill;
	}
	
	/**
	 * 
	 * @return integer value of thickness.
	 */
	public int getThickness() {
		return thickness;
	}
	

	public BasicStroke getStroke() {
		return stroke;
	}
	
	
	public abstract void draw(Graphics2D g2d);
}
