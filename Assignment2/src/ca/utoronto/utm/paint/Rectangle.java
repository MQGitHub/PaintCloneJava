package ca.utoronto.utm.paint;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Inherits Shape.
 * This class creates a shape of type Rectangle
 * HAS-A: getWidth, getHeight, setHeight, setWidth.
 *
 */
public class Rectangle extends Shape{
	private int width;
	private int height;
	
	/**
	 * Creates a shape of type rectangle
	 * that has a specific color, thickness, filled, Point, width, height.
	 * @param c Color of rectangle.
	 * @param t thickness of rectangle.
	 * @param b is rectangle filled.
	 * @param corner top left corner of the rectangle.
	 * @param width Width of the rectangle.
	 * @param height Height of the rectangle.
	 * @param stroke 
	 */
	public Rectangle(Color c, int t, int f, Point corner, int width, int height, BasicStroke stroke){
		super(c, t, f, corner, stroke);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * 
	 * @return Integer width.
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Modifies current width to integer in width
	 * @param width Integer
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * 
	 * @return Integer height of the rectangle.
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Modifies current height to height in parameter.
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void draw(Graphics2D g2d) {
		int x = this.getCorner().getX();
		int y = this.getCorner().getY();
		int height = this.getHeight();
		int width = this.getWidth();
		int i = this.fillAmt();
		g2d.setColor(this.getColor());
		g2d.setStroke(this.getStroke());
		if (i > 0) {
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, i* 0.1f));
			g2d.fillRect(x, y, width, height);
		} else {
			g2d.drawRect(x, y, width, height);
		}
	}

}

