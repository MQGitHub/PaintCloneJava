package ca.utoronto.utm.paint;

public abstract class Shape {
	private Point p;

	
	public Shape(Point p) {
		this.p=p;
	}
	
	public Point getCorner() {
		return p;
	}

	public void setCorner(Point corner) {
		this.p = corner;
	}
}
