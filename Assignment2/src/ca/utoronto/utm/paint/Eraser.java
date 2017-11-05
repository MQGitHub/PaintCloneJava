package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

public class Eraser extends Squiggle{
	public Eraser(Color c, ArrayList<Point> points) {
		super(c, 20, points);
	}
	
	public ArrayList<Point> getPoints(){
		return super.getPoints();
	}
	
	public void addPoint(Point p) {
		super.addPoint(p);
	}

}


