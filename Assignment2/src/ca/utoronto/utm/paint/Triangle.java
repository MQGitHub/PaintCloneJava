package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

/**
 * 
 * A Triangle is a Shape with a base and height value.
 *
 */
public class Triangle extends Shape {

	private int base, height;
	
	/**
	 * Construct a shape with the specified parameters	 
	 * 
	 * @param c
	 *            The color the shape is
	 * @param t
	 *            The thickness the shape is
	 * @param b
	 *            The fill of the shape
	 * @param start
	 *            The beginning point of the shape
	 */
	public Triangle(Color c, int thick, Boolean b, Point corner) {
		super(c, thick, b, corner);
	}
	
	/**
	 * 
	 * @return the base of this.
	 * 
	 */
	public int getBase() {
		return base;
	}

	/**
	 * Set the base of this.
	 * @param base
	 * 			an integer representing the base value
	 */
	public void setBase(int base) {
		this.base = base;
	}

	/**
	 * Set the height of this.
	 * @param height
	 * 			an integer representing the height value
	 */
	public void setHeight(int i) {
		this.height = i;
		
	}
	
	/**
	 * 
	 * @return the height of this.
	 * 
	 */
	public int getHeight() {
		return this.height;
	}

}
