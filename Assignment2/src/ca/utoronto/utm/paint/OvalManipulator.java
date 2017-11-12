package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class OvalManipulator extends ShapeManipulator{
	private Oval oval;
	public OvalManipulator(PaintPanel pp) {
		super(pp);
	}
	@Override
	public void operationPressed(MouseEvent e) {
		begin = new Point(e.getX(), e.getY());
		this.oval = new Oval(this.color, thick, fill, begin, 0, 0);
		
	}

	@Override
	public void operationDragged(MouseEvent e) {
		int min_X = Math.min(begin.getX(), e.getX());
		int min_Y = Math.min(begin.getY(), e.getY());
		int max_X = Math.max(begin.getX(), e.getX());
		int max_Y = Math.max(begin.getY(), e.getY());
		this.oval.setCorner(new Point(min_X, min_Y));
		this.oval.setWidth(max_X - min_X);
		this.oval.setHeight(max_Y - min_Y);
		this.model.addShape(this.oval);
		
	}

	@Override
	public void operationClicked(MouseEvent e) {
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		this.model.addShape(this.oval);
		
	}
	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
