package ca.utoronto.utm.paint;

public class Line {
	private Point begin;
	private Point end;
	
	public Line(Point begin, Point end) {
		this.begin = begin;
		this.end = end;
	}
	
	public void setEndPoint(Point end) {
		this.end = end;
	}
	public void setBeginPoint(Point begin) {
		this.begin = begin;
	}
	
	
	public Point getBeginPoint() {
		return this.begin;
	}
	
	public Point getEndPoint() {
		return this.end;
	}
}
