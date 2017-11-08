package ca.utoronto.utm.paint;

import java.awt.Color;
/**
 * Inherits Shape.
 * This class creates a shape of type Rectangle
 * HAS-A: getWidth, getHeight, setHeight, setWidth.
 *
 */
public class Rectangle extends Shape{
	private int width;
	private int height;
	
	/**
	 * Creates a shape of type rectangle
	 * that has a specific color, thickness, filled, Point, width, height.
	 * @param c Color of rectangle.
	 * @param t thickness of rectangle.
	 * @param b is rectangle filled.
	 * @param corner top left corner of the rectangle.
	 * @param width Width of the rectangle.
	 * @param height Height of the rectangle.
	 */
	public Rectangle(Color c, int t, Boolean f, Point corner, int width, int height){
		super(c, t, f, corner);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * 
	 * @return Integer width.
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Modifies current width to integer in width
	 * @param width Integer
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * 
	 * @return Integer height of the rectangle.
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Modifies current height to height in parameter.
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

}

