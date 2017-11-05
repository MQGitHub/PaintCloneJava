package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Represents the squiggles for our paint application. Containing
 * all the points where squiggles have been made. Along with
 * the thickness and color. 
 *
 */
public class Squiggle extends Shape {
	private ArrayList<Point> pts;

	/**
	 *  Constructor adds where the squiggle is drawn on 
	 *  to pts and keeps track of the squiggles thickness
	 *  and color.
	 *  
	 *  @param c 	   The color of the squiggle.
	 *  @param thick   The thickness of the squiggle.
	 *  @param points  All of the points squiggled on. 
	 *  @see  		   Shape. 
	 */
	public Squiggle(Color c, int thick, ArrayList<Point> points) {
		super(c, thick, points);
		this.pts = points;
	}

	/**
	 * Returns an ArrayList containing all the points where squiggles
	 * have been made so that they can be drawn onto the panel.
	 * 
	 * @return pts	ArrayList containing all the current points.
	 */
	public ArrayList<Point> getPoints() {
		return this.pts;
	}

	/**
	 * Adds to pts ArrayList containing all the points for all the 
	 * squiggles.
	 * 
	 * @param p	 adds given point to pts ArrayList containing all previous
	 * 		     points.
	 */
	public void addPoint(Point p) {
		this.pts.add(p);
	}

}
