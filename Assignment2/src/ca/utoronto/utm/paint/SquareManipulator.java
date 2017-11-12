package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class SquareManipulator extends ShapeManipulator{

	private Square square;
	
	public SquareManipulator(PaintPanel pp) {
		super(pp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operationPressed(MouseEvent e) {
		begin = new Point(e.getX(), e.getY());
		this.square = new Square(this.color, thick, fill, begin, 0);
		
	}

	@Override
	public void operationDragged(MouseEvent e) {
		int x = begin.getX() - e.getX();
		int y = begin.getY() - e.getY();
		int width = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		this.square.setWidth(width);
		this.model.addShape(this.square);
		this.model.removeShape(this.square);
	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		this.model.addShape(this.square);
		
	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
