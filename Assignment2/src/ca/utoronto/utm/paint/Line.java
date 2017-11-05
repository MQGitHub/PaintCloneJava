package ca.utoronto.utm.paint;

import java.awt.Color;


/**
 * Represents the lines for our paint application. Containing all the lines
 * color, thickness, and start and end points.
 *
 */
public class Line extends Shape{
	private Point begin;
	private Point end;

	/**
	 * Creates a line with attributes color, thickness, if the line is filled, start
	 * and end point.
	 * 
	 * @param c      the color of the line.
	 * @param t      a int that indicates how thick the line should be.
	 * @param b      a boolean which indicates if the line should be filled.
	 * @param begin  a point that is the start point of the line.
	 * @param end    a point that is end point of the line.
	 * @see Shape
	 * @see DrawShape
	 */
	public Line(Color c, int t, Boolean b, Point begin, Point end) {
		super(c, t, b, begin);
		this.end = end;
	}

	/**
	 * Sets the end point to the point given.
	 * 
	 * @param end a point that is end point of the line.
	 */
	public void setEndPoint(Point end) {
		this.end = end;
	}

	/**
	 * Returns the end point of the line.
	 * 
	 * @return end the end point of the line.
	 */
	public Point getEndPoint() {
		return this.end;
	}


}
