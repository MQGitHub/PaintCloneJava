package ca.utoronto.utm.paint;

import java.awt.Color;

public class Line extends Shape implements DrawShape{
	private Point begin;
	private Point end;
	
	public Line(Color c, Point begin, Point end) {
		super(c, begin);
		this.end = end;
	}
	
	public void setEndPoint(Point end) {
		this.end = end;
	}
	
	public Point getEndPoint() {
		return this.end;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
