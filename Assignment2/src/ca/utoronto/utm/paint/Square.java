package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Inherits rectangle.
 * Creates a shape of type Square
 */
public class Square extends Rectangle implements drawShape{
	
	/**
	 * Constructs a shape of type Square, a subclass of rectangle.
	 * @param c Color of square.
	 * @param t Thickness of square.
	 * @param b is shape filled.
	 * @param center Center of shape.
	 * @param width Width and height of the square.
	 */
	public Square(Color c, int t, Boolean f,  Point center, int width) {
		super(c, t, f, center, width, width);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		int x = this.getCorner().getX();
		int y = this.getCorner().getY();
		int width = this.getWidth();
		g2d.setColor(this.getColor());
		g2d.setStroke(new BasicStroke(this.getThickness()));
		if (this.isFilled()) {
			g2d.fillRect(x - width, y - width, width * 2, width * 2);
		} else {
			g2d.drawRect(x - width, y - width, width * 2, width * 2);
		}
	}
}


