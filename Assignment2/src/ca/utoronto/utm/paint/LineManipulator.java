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
		color = pp.getColor();
		thick = pp.getThickness();
		fill = pp.getFilled();
		stroke = pp.getStroke();
		begin = new Point(e.getX(), e.getY());
		this.line = new Line(color, thick, false, begin, begin, stroke);	
		this.model.setDraw(this.line);
	}

	@Override
	public void operationDragged(MouseEvent e) {
		end = new Point(e.getX(), e.getY());
		this.line.setEndPoint(end);	
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


