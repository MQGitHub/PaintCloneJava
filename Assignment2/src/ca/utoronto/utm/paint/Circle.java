package ca.utoronto.utm.paint;

public class Circle extends Oval implements DrawShape{

	
	public Circle(Point centre, int radius){
		super(centre,radius,radius);
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
