package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class RectangleManipulator extends ShapeManipulator {
	
	private Rectangle rectangle;
	
	public RectangleManipulator(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operationPressed(MouseEvent e) {
		color = pp.getColor();
		thick = pp.getThickness();
		fill = pp.getOpacity();
		stroke = pp.getStroke();
		begin = new Point(e.getX(), e.getY());
		this.rectangle = new Rectangle(color, thick, fill, begin, 0, 0, stroke);
		this.model.setDraw(this.rectangle);
	}

	@Override
	public void operationDragged(MouseEvent e) {
		int min_X = Math.min(begin.getX(), e.getX());
		int min_Y = Math.min(begin.getY(), e.getY());
		int max_X = Math.max(begin.getX(), e.getX());
		int max_Y = Math.max(begin.getY(), e.getY());
		this.rectangle.setCorner(new Point(min_X, min_Y));
		this.rectangle.setWidth(max_X - min_X);
		this.rectangle.setHeight(max_Y - min_Y);
	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		this.model.addShape(this.rectangle);
		
	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
