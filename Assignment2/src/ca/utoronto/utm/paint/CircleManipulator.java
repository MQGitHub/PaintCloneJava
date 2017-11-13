package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class CircleManipulator extends ShapeManipulator {
	private Circle circle;
	
	public CircleManipulator(View view) {
		super(view);
	}

	@Override
	public void operationPressed(MouseEvent e) {
		Color c = pp.getColor();
		int thick = pp.getThickness();
		boolean fill = pp.getFilled();
		begin = new Point(e.getX(), e.getY());
		this.circle = new Circle(c, thick, fill, begin, 0);
		
	}

	@Override
	public void operationDragged(MouseEvent e) {
		int x = begin.getX() - e.getX();
		int y = begin.getY() - e.getY();
		int radius = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		this.circle.setRadius(radius);
		this.model.addShape(this.circle);
		this.model.removeShape(this.circle);
	}

	@Override
	public void operationClicked(MouseEvent e) {
	}

	@Override
	public void operationReleased(MouseEvent e) {
		this.model.addShape(this.circle);
		
	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
