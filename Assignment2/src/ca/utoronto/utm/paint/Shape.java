package ca.utoronto.utm.paint;

import java.awt.Color;

public abstract class Shape {
	private Point p;
	private Color c;
	private Boolean fill;

	
	public Shape(Color c, Boolean b, Point p) {
		this.c = c;
		this.fill = b;
		this.p=p;
	}
	
	public Point getCorner() {
		return p;
	}

	public void setCorner(Point corner) {
		this.p = corner;
	}
	
	public void setColor(Color c) {
		this.c = c;
	}
	
	public Color getColor() {
		return c;
	}
	
	public Boolean isFilled() {
		return fill;
	}
}
