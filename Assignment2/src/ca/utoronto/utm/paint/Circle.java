package ca.utoronto.utm.paint;

import java.awt.Color;

public class Circle extends Oval implements DrawShape{

	
	public Circle(Color c, int t,Boolean b,  Point center, int radius) {
		super(c, t, b, center, radius, radius);
	}
	public void setRadius(int radius) {
		this.setHeight(radius);
		this.setWidth(radius);
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		//g2d.drawRect

	}
}



