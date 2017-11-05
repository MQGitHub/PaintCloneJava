package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Shape {
	private Point p;
	private Color c;
	private Boolean fill = false;
	private int thickness;
	private ArrayList<Point> pts;

	
	public Shape(Color c, int thick, Boolean b, Point p) {
		this.c = c;
		this.fill = b;
		this.thickness = thick;
		this.p=p;
	}
	
	public Shape(Color c, int thick, ArrayList<Point> p) {
		this.c = c;
		this.thickness = thick;
		this.pts = p;
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
	
	public int getThickness() {
		return thickness;
	}
}
