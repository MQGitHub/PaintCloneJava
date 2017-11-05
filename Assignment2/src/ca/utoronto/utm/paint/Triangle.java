package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Triangle extends Shape {

	private Polyline p;
	
	public Triangle(Color c, int thick, Boolean b, Point p) {
		super(c, thick, b, p);
		this.p.addPoint(p);
	}
	
	public Point getBase() {
		return this.p.getFirstPoint();
	}
	
	public Point getHeight() {
		return this.p.getLastPoint();
	}
	
	public Point getCorner() {
		return this.p.getPoints().get(2);
	}
	
	public void draw() {
		// TODO Auto-generated method stub
		//g2d.drawPolygon
	}

	public void addPoint(Point p2) {
		this.p.addPoint(p2);
		
	}
	
	public boolean hasAllPoints() {
		if (this.p.getPoints().size() == 3) {
			return true;
		}
		return false;
		
	}

}
