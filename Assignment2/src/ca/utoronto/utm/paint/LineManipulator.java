package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class LineManipulator extends ShapeManipulator {

	private Line line;
	
	public LineManipulator(PaintPanel pp) {
		super(pp);
	}
	@Override
	public void operationPressed(MouseEvent e) {
		begin = new Point(e.getX(), e.getY());
		this.line = new Line(this.color, thick, false, begin, begin);	
	}

	@Override
	public void operationDragged(MouseEvent e) {
		end = new Point(e.getX(), e.getY());
		this.line.setEndPoint(end);
		this.model.addShape(this.line);
		this.model.removeShape(this.line);
	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		this.model.addShape(this.line);
	}
	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


