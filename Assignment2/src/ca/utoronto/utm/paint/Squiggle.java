package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
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
	
	@Override
	public void draw(Graphics2D g2d) {
		ArrayList<Point> points = this.getPoints();
		for (int i = 0; i < points.size() - 1; i++) {
			Point p1 = points.get(i);
			Point p2 = points.get(i + 1);
			g2d.setColor(p1.getColor());
			g2d.setStroke(new BasicStroke(p1.getThickness()));
			if ((p1.getX() == -1 && p1.getY() == -1) || (p2.getX() == -1 && p2.getY() == -1)) {
				i = i + 2;
			} else {
				g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
		}
	}

}
