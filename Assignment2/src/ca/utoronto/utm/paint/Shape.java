package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Shape {
	private Point p;
	private Color c;
	private Boolean fill;
	private int thickness;
	private ArrayList<Point> pts;

	
	public Shape(Color c, int thick, Boolean b, Point p) {
		this.c = c;
		this.fill = b;
		this.thickness = thick;
		this.p=p;
	}
	
	public Shape(Color c, int thick, ArrayList<Point> pts) {
		this.c = c;
		this.pts = pts;
		this.thickness = thick;
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

//	public boolean contains(java.awt.Point point) {
//		java.awt.Point p = new java.awt.Point(this.p.x, this.p.y);
//		if (point == p) {
//			return true;
//		}
//		return false;
//	}
}
