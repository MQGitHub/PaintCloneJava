package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

/**
 * 
 * Create the Circle on the console by listenening to the mouse.
 * CircleManipulator is a ShapeManipulator and has a View where we draw the
 * circle.
 *
 */
public class CircleManipulator extends ShapeManipulator {
	private Circle circle;
	
	/**
	 * Initialize the view by connecting the view and CircleManipulator.
	 * 
	 * @param view
	 *            The view of Paint model.
	 */
	public CircleManipulator(View view) {
		super(view);
	}

	/**
	 * Controller aspect of this
	 */
	@Override
	public void operationPressed(MouseEvent e) {
		color = pp.getColor();
		thick = pp.getThickness();
		fill = pp.getOpacity();
		stroke = pp.getStroke();
		begin = new Point(e.getX(), e.getY());
		this.circle = new Circle(color, thick, fill, begin, 0, stroke);
		this.model.setDraw(this.circle);
	}

	@Override
	public void operationDragged(MouseEvent e) {
		int x = begin.getX() - e.getX();
		int y = begin.getY() - e.getY();
		int radius = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		this.circle.setRadius(radius);
		
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
