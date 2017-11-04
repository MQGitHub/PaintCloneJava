package ca.utoronto.utm.paint;

import java.awt.Color;

public class Square extends Rectangle implements DrawShape{

	public Square(Color c, Point center, int width) {
		super(c, center, width, width);
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		//g2d.drawRect
	}
}
