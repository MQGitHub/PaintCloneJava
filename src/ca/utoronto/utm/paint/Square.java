package ca.utoronto.utm.paint;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Inherits rectangle.
 * Creates a shape of type Square
 */
public class Square extends Rectangle {
	
	/**
	 * Constructs a shape of type Square, a subclass of rectangle.
	 * @param c Color of square.
	 * @param t Thickness of square.
	 * @param b is shape filled.
	 * @param center Center of shape.
	 * @param width Width and height of the square.
	 * @param stroke 
	 */
	public Square(Color c, int t, int f,  Point center, int width, BasicStroke stroke) {
		super(c, t, f, center, width, width, stroke);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		int x = this.getCorner().getX();
		int y = this.getCorner().getY();
		int width = this.getWidth();
		int i = this.fillAmt();
		g2d.setColor(this.getColor());
		g2d.setStroke(this.getStroke());
		if (i > 0) {
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, i* 0.1f));
			g2d.fillRect(x - width, y - width, width * 2, width * 2);
		} else {
			g2d.drawRect(x - width, y - width, width * 2, width * 2);
		}
	}
}


