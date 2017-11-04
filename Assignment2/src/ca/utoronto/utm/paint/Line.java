package ca.utoronto.utm.paint;

public class Line extends Shape implements DrawShape{
	private Point begin;
	private Point end;
	
	public Line(Point begin, Point end) {
		super(begin);
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
