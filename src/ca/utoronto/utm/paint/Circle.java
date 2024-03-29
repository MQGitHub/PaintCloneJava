package ca.utoronto.utm.paint;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Inherits Oval. 
 * This class creates a shape of type circle,
 * This class has same width and height in order to form a circle.
 * HAS-A setRadius.
 */
public class Circle extends Oval {

	
	/**
	 * Constructs a shape of type circle with
	 * a specific color, thickness, is filled, center, and radius.
	 * @param c Color of the circle.
	 * @param t Thickness of the circle.
	 * @param b is Circle filled.
	 * @param center  center of the circle
	 * @param radius radius of the circle.
	 * @param stroke 
	 */
	public Circle(Color c, int t,int b,  Point center, int radius, BasicStroke stroke) {
		super(c, t, b, center, radius, radius, stroke);
	}
	
	/**
	 * Modifies the height and width of the circle.
	 * @param radius new radius of the circle.
	 */
	public void setRadius(int radius) {
		this.setHeight(radius);
		this.setWidth(radius);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		int x = this.getCorner().getX();
		int y = this.getCorner().getY();
		int radius = this.getHeight();
		int i = this.fillAmt();
		g2d.setColor(this.getColor());
		g2d.setStroke(this.getStroke());
		if (i > 0) {
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, i* 0.1f));
			g2d.fillOval(x - radius, y - radius, radius * 2, radius * 2);
		} else {
			g2d.drawOval(x - radius, y - radius, radius * 2, radius * 2);
		}
	}
}

