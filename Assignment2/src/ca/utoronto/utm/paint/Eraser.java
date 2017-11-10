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
	public Eraser(Color c, Point start) {
		super(c, 20, false, start);
	}
	
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(this.getThickness()));
		g2d.setColor(Color.white);
		//g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		
	}

}
