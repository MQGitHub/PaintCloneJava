package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

public class Eraser extends Shape{
	private ArrayList<Point> pts;
	public Eraser(Color c, ArrayList<Point> points) {
		super(c, 20, points);
		this.pts = points;
	}
	
	public ArrayList<Point> getPoints(){
		return this.pts;
	}
	
	public void addPoint(Point p) {
		this.pts.add(p);
	}

}
