package ca.utoronto.utm.paint;

import java.awt.Color;

/**
 * Inherits Oval. 
 * This class creates a shape of type circle,
 * This class has same width and height in order to form a circle.
 * HAS-A setRadius.
 */
public class Circle extends Oval {

	
	/**
	 * Constructs a shape of type circle with
	 * a specific color, thickness, is filled, center, and radius.
	 * @param c Color of the circle.
	 * @param t Thickness of the circle.
	 * @param b is Circle filled.
	 * @param center  center of the circle
	 * @param radius radius of the circle.
	 */
	public Circle(Color c, int t,Boolean b,  Point center, int radius) {
		super(c, t, b, center, radius, radius);
	}
	
	/**
	 * Modifies the height and width of the circle.
	 * @param radius new radius of the circle.
	 */
	public void setRadius(int radius) {
		this.setHeight(radius);
		this.setWidth(radius);
	}
}

