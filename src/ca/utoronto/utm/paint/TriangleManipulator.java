package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

/**
 * 
 * Create the Triangle on the console by listenening to the mouse.
 * TriangleManipulator is a ShapeManipulator and has a View where we draw the
 * triangle.
 *
 */
public class TriangleManipulator extends ShapeManipulator {

	private Triangle triangle;

	/**
	 * Initialize the view by connecting the view and TriangleManipulator.
	 * 
	 * @param view
	 *            The view of Paint model.
	 */
	public TriangleManipulator(View view) {
		super(view);
		// TODO Auto-generated constructor stub
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
		begin = new Point(color, thick, e.getX(), e.getY());
		this.triangle = new Triangle(color, thick, fill, begin, stroke);
		this.triangle.setBase(e.getX());
		this.triangle.setHeight(e.getY());
		this.model.setDraw(this.triangle);
	}

	@Override
	public void operationDragged(MouseEvent e) {
		this.triangle.setBase(e.getX());
		this.triangle.setHeight(e.getY());
	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void operationReleased(MouseEvent e) {
		this.model.addShape(this.triangle);

	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
