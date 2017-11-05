package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Triangle extends Shape {

	private int base, height;
	
	public Triangle(Color c, int thick, Boolean b, Point corner) {
		super(c, thick, b, corner);
	}
	
	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}
	
	public void setHeight(int i) {
		this.height = i;
		
	}
	
	public int getHeight() {
		return this.height;
	}

}
