package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

public class Squiggle extends Shape{
	private ArrayList<Point> pts;
	public Squiggle(Color c, int thick, ArrayList<Point> points) {
		super(c, thick, points);
		this.pts = points;
	}
	
	public ArrayList<Point> getPoints(){
		return this.pts;
	}
	
	public void addPoint(Point p) {
		this.pts.add(p);
	}

}
