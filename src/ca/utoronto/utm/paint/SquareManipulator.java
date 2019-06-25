package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class SquareManipulator extends ShapeManipulator{

	private Square square;
	
	public SquareManipulator(View view) {
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
		this.square = new Square(color, thick, fill, begin, 0, stroke);
		this.model.setDraw(this.square);
	}

	@Override
	public void operationDragged(MouseEvent e) {
		int x = begin.getX() - e.getX();
		int y = begin.getY() - e.getY();
		int width = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		this.square.setWidth(width);
		this.model.setDraw(this.square);
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
