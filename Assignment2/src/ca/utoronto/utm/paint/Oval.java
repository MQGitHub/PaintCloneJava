package ca.utoronto.utm.paint;

import java.awt.Color;

public class Oval extends Shape implements DrawShape{

	private int width;
	private int height;
	
	public Oval(Color c, int t, Boolean b,  Point corner, int width, int height){
		super(c, t, b, corner);
		this.width = width;
		this.height = height;
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

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}


}