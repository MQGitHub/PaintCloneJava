package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

/**
 * 
 * Create Lines on the console by listenening to the mouse.
 * LineManipulator is a ShapeManipulator and has a View where we draw the
 * Line.
 *
 */
public class LineManipulator extends ShapeManipulator {

	private Line line;
	
	/**
	 * Initialize the view by connecting the view and LineManipulator.
	 * 
	 * @param view
	 *            The view of Paint model.
	 */
	public LineManipulator(View view) {
		super(view);
	}
	
	/**
	 * Control aspect of this
	 */
	@Override
	public void operationPressed(MouseEvent e) {
		color = pp.getColor();
		thick = pp.getThickness();
		stroke = pp.getStroke();
		begin = new Point(e.getX(), e.getY());
		this.line = new Line(color, thick, 0, begin, begin, stroke);	
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


