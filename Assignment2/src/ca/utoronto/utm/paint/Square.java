package ca.utoronto.utm.paint;

import java.awt.Color;

public class Square extends Rectangle implements DrawShape{

	public Square(Color c, int t, Boolean b,  Point center, int width) {
		super(c, t, b, center, width, width);
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		//g2d.drawRect
	}
}


