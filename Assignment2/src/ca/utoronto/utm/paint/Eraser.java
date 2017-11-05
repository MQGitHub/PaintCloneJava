package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Represents the eraser for our paint application. Containing
 * the points where the eraser was used, the erasers thickness
 * , and the color of the eraser.  
 *
 */
public class Eraser extends Squiggle {
	
	
	/**
	 *  Constructor adds the points where the eraser is used 
	 *  and color. Sets the thickness to 20.
	 *  
	 *  @param c 	   The color of the eraser.
	 *  @param points  All of the points where eraser is used. 
	 *  @see  		   Squiggle. 
	 */
	public Eraser(Color c, ArrayList<Point> points) {
		super(c, 20, points);
	}
	
	/**
	 * Returns an ArrayList containing all the points where eraser
	 * have been used.
	 * 
	 * @return 	ArrayList containing all the current points for eraser.
	 * @see 	Squiggle
	 */
	public ArrayList<Point> getPoints() {
		return super.getPoints();
	}

	/**
	 * Adds to the ArrayList containing all the points for all the
	 * times eraser was used.
	 * 
	 * @param p	 adds given point to pts ArrayList containing all previous
	 * 		     points. The ArrayList is held in the parent class Squiggle.
	 * @see   Squiggle.
	 */
	public void addPoint(Point p) {
		super.addPoint(p);
	}

}
