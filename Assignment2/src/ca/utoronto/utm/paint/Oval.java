package ca.utoronto.utm.paint;

public class Oval {
	private Point corner;
	private int width;
	private int height;
	
	public Oval(Point corner, int width, int height){
		this.corner = corner;
		this.width = width;
		this.height = height;
	}
	
	public Point getCorner() {
		return corner;
	}

	public void setCorner(Point corner) {
		this.corner = corner;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


}
