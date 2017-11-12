package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;

/**
 * 
 * A Triangle is a Shape which has a base and height value.
 *
 */
public class Triangle extends Shape{

	private int base, height;
	
	/**
	 * Constructs a shape of type Triangle with a specific color, 
	 * thickness, is filled, corner.	 
	 * 
	 * @param c
	 *            The color the shape is
	 * @param t
	 *            The thickness the shape is
	 * @param b
	 *            The fill of the shape
	 * @param start
	 *            The beginning point of the shape
	 */
	public Triangle(Color c, int thick, Boolean b, Point corner) {
		super(c, thick, b, corner);
	}
	
	/**
	 * 
	 * @return the base of this.
	 * 
	 */
	public int getBase() {
		return base;
	}

	/**
	 * Set the base of this.
	 * @param base
	 * 			an integer representing the base value
	 */
	public void setBase(int base) {
		this.base = base;
	}

	/**
	 * Set the height of this.
	 * @param height
	 * 			an integer representing the height value
	 */
	public void setHeight(int i) {
		this.height = i;
		
	}
	
	/**
	 * 
	 * @return the height of this.
	 * 
	 */
	public int getHeight() {
		return this.height;
	}

	@Override
	public void draw(Graphics2D g2d) {
		int x = this.getCorner().getX();
		int y = this.getCorner().getY();
		int height = this.getHeight();
		int base = this.getBase();
		g2d.setColor(this.getColor());
		g2d.setStroke(new BasicStroke(this.getThickness()));
		Polygon p = new Polygon();
		p.addPoint((x + base)/ 2, y);
		p.addPoint(x, height);
		p.addPoint(base, height);
		if (this.isFilled()) {
			g2d.fillPolygon(p);
		} else {
			g2d.drawPolygon(p);
		}
	}

}
