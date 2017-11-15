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
    private Path2D path;
	
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
	public Squiggle(Color c, int thick, int fill, Point startP, BasicStroke stroke) {
		super(c, thick, fill, startP, stroke);
		this.path = new Path2D.Double();
	}
	
	/**
	 * Sets the point p for the current position of the path
	 * @param p point to set for path
	 */
	public void moveto(Point p) {
		path.moveTo(p.getX(), p.getY());
	}

	/**
	 * Creates a line from the point in moveTo to p
	 * @param p point draw line to
	 */
	public void lineto(Point p) {
		path.lineTo(p.getX(), p.getY());
	}
	
	/**
	 * 
	 * @return the path of the squiggle.
	 */
	public Path2D getPath() {
		return this.path;
	}
	
	/**
	 * Closes the path
	 */
	public void endPath() {
		try {
            path.closePath();
        } catch(Exception ingore) {
        }
 
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(this.getColor());
		g2d.setStroke(this.getStroke());
		g2d.draw(path);
	
	}

}
