package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class LineManipulator extends ShapeManipulator {

	private Line line;
	
	public LineManipulator(View view) {
		super(view);
	}
	@Override
	public void operationPressed(MouseEvent e) {
		Color c = pp.getColor();
		int thick = pp.getThickness();
		boolean fill = pp.getFilled();
		begin = new Point(e.getX(), e.getY());
		this.line = new Line(c, thick, false, begin, begin);	
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


