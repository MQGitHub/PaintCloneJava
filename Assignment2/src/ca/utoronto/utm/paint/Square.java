package ca.utoronto.utm.paint;

public class Square extends Rectangle implements DrawShape{

	public Square(Point center, int width) {
		super(center, width, width);
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		//g2d.drawRect
	}
}
