package ca.utoronto.utm.paint;

import java.awt.Color;

public class Point {
	private int x, y;
	private int thick;
	private Color c;
	
	/**
	 * Creates a point at x and y coordinate
	 * @param x
	 * @param y
	 */
	Point(int x, int y){
		this.x=x; this.y=y;
	}
	
	/**
	 * Creates a point at x and y coordinate with 
	 * a specific thickness and color
	 * @param c
	 * @param thick
	 * @param x
	 * @param y
	 */
	Point(Color c, int thick, int x, int y){
		this.c = c;
		this.thick = thick;
		this.x=x; this.y=y;
	}
	/**
	 * 
	 * @return current x.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Modifies current x to the x in the parameter.
	 * @param x int
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return current y.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Modifies current y to the y in the parameter
	 * @param y int
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @return current color
	 */
	public Color getColor() {
		return c;
	}
	
	/**
	 * 
	 * @return current thickness.
	 */
	public int getThickness() {
		return thick;
	}
	
}
