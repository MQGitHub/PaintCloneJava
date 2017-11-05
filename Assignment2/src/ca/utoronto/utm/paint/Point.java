package ca.utoronto.utm.paint;

import java.awt.Color;

public class Point {
	private int x, y;
	private int thick;
	private Color c;
	Point(int x, int y){
		this.x=x; this.y=y;
	}
	
	Point(Color c, int thick, int x, int y){
		this.c = c;
		this.thick = thick;
		this.x=x; this.y=y;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Color getColor() {
		return c;
	}
	
	public int getThickness() {
		return thick;
	}
	
}
