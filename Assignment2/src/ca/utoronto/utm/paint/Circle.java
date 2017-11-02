package ca.utoronto.utm.paint;

public class Circle extends Oval{

	
	public Circle(Point centre, int radius){
		super(centre,radius,radius);
	}
	
	public void setRadius(int radius) {
		this.setHeight(radius);
		this.setWidth(radius);
	}
}
