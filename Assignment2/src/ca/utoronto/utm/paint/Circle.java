package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Inherits Oval. 
 * This class creates a shape of type circle,
 * This class has same width and height in order to form a circle.
 * HAS-A setRadius.
 */
public class Circle extends Oval implements drawShape{

	
	/**
	 * Constructs a shape of type circle with
	 * a specific color, thickness, is filled, center, and radius.
	 * @param c Color of the circle.
	 * @param t Thickness of the circle.
	 * @param b is Circle filled.
	 * @param center  center of the circle
	 * @param radius radius of the circle.
	 */
	public Circle(Color c, int t,Boolean b,  Point center, int radius) {
		super(c, t, b, center, radius, radius);
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
		g2d.setColor(this.getColor());
		g2d.setStroke(new BasicStroke(this.getThickness()));
		if (this.isFilled()) {
			g2d.fillOval(x - radius, y - radius, radius * 2, radius * 2);
		} else {
			g2d.drawOval(x - radius, y - radius, radius * 2, radius * 2);
		}
	}
}

