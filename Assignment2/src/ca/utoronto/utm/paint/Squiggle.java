package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;

/**
 * Represents the squiggles for our paint application. Containing
 * all the points where squiggles have been made. Along with
 * the thickness and color. 
 *
 */
public class Squiggle extends Shape {
	private Point lastP;
	private Point crntP;
    private Point start;
    private Path2D thing;
	
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
	public Squiggle(Color c, int thick, boolean fill, Point startP) {
		super(c, thick, fill, startP);
	}
	
	  /** Remember the specified point */
	public void moveto(Point p) {
		thing.moveTo(p.getX(), p.getY());
	}

	public void lineto(Point p) {
		thing.lineTo(p.getX(), p.getY());
	}
	
	public void setThing(Path2D t) {
		this.thing = t;
	}
	
	public void setStart(Point p) {
		this.start = p;
	}
	
	public Point getStart() {
		return this.start;
	}
	
	public void endPath() {
		try {
            thing.closePath();
        } catch(Exception ingore) {
        }
 
	}
	/**
	 * Returns an ArrayList containing all the points where squiggles
	 * have been made so that they can be drawn onto the panel.
	 * 
	 * @return pts	ArrayList containing all the current points.
	 */

	/**
	 * Adds to pts ArrayList containing all the points for all the 
	 * squiggles.
	 * 
	 * @param p	 adds given point to pts ArrayList containing all previous
	 * 		     points.
	 */
		
	@Override
	public void draw(Graphics2D g2d) {
		if (start != null) {
			g2d.setColor(start.getColor());
			g2d.setStroke(new BasicStroke(start.getThickness()));
			g2d.draw(thing);
		}
	}

}
