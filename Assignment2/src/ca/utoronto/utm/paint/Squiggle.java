package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

public class Squiggle extends Shape {
	
	private ArrayList<Point> p; 

	public Squiggle(Color c, int thick, ArrayList<Point> p) {
		super(c, thick, p);
		this.p = p;
	}
	
	public void addPoint(Point x) {
		this.p.add(x);
	}

	public ArrayList<Point> getPoints(){
		return this.p;
	}
}
