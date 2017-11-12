package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class TriangleManipulator extends ShapeManipulator{
	
	private Triangle triangle;
	
	public TriangleManipulator(PaintPanel pp) {
		super(pp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operationPressed(MouseEvent e) {
		begin = new Point(this.color, thick, e.getX(), e.getY());
		this.triangle = new Triangle(this.color, thick, fill, begin);
		
	}

	@Override
	public void operationDragged(MouseEvent e) {
		this.triangle.setBase(e.getX());
		this.triangle.setHeight(e.getY());
		this.model.addShape(triangle);
		this.model.removeShape(triangle);
	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		this.model.addShape(triangle);
		
	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
