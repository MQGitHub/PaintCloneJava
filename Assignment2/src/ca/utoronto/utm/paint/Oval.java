package ca.utoronto.utm.paint;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Inherits Shape.
 * This class creates a shape of type Oval.
 * Has-A getWdith, getHeight, setWidth, setHeight.
 */
public class Oval extends Shape{
	
	private int width; //width of Oval
	private int height; //height of Oval
	
	/**
	 * Constructs a shape of type Oval with a specific color, 
	 * thickness, is filled, Corner, width ,height.
	 * @param c Color of the Oval.
	 * @param t Thickness of the Oval.
	 * @param b is Oval filled.
	 * @param corner top left corner of the Oval.
	 * @param width Width of the Oval.
	 * @param height Height of the Oval.
	 * @param stroke 
	 */
	public Oval(Color c, int t, int b,  Point corner, int width, int height, BasicStroke stroke){
		super(c, t, b, corner, stroke);
		this.width = width;
		this.height = height;
	}

	/**
	 * 
	 * @return the width of the oval.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Modifies the width of the oval with new one.
	 * @param width new width of the oval
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * 
	 * @return the height of the oval.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Modifies the height of the oval with new one.
	 * @param height new height of the oval
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
			g2d.fillOval(x, y, width, height);
		} else {
			g2d.drawOval(x, y, width, height);
		}
	}

}