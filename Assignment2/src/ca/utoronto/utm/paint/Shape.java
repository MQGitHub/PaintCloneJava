package ca.utoronto.utm.paint;

import java.awt.Color;

public abstract class Shape {
	private Point p;
	private Color c;

	
	public Shape(Color c, Point p) {
		this.p=p;
		this.c = c;
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
}
