package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
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
	public Eraser(Color c, ArrayList<Point> points, BasicStroke stroke) {
		super(c, 20, points, stroke);
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
	
	@Override
	public void draw(Graphics2D g2d) {
		ArrayList<Point> points = this.getPoints();
		for (int i = 0; i < points.size() - 1; i++) {
			Point p1 = points.get(i);
			Point p2 = points.get(i + 1);
			g2d.setStroke(new BasicStroke(this.getThickness()));
			g2d.setColor(this.getColor());
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}

}
