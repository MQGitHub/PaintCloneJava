package ca.utoronto.utm.paint;

import java.awt.Color;

/**
 * Inherits rectangle.
 * Creates a shape of type Square
 */
public class Square extends Rectangle{
	
	/**
	 * Constructs a shape of type Square, a subclass of rectangle.
	 * @param c Color of square.
	 * @param t Thickness of square.
	 * @param b is shape filled.
	 * @param center Center of shape.
	 * @param width Width and height of the square.
	 */
	public Square(Color c, int t, Boolean f,  Point center, int width) {
		super(c, t, f, center, width, width);
	}
}


