package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SquiggleManipulator extends ShapeManipulator{
	private Squiggle squiggle;
	
	public SquiggleManipulator(PaintPanel pp) {
		super(pp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operationPressed(MouseEvent e) {
		ArrayList<Point> pts = new ArrayList<Point>();
		pts.add(new Point(this.color, thick, e.getX(), e.getY()));
		this.squiggle = new Squiggle(this.color, thick, pts);
	}

	@Override
	public void operationDragged(MouseEvent e) {
		this.squiggle.addPoint(new Point(color, thick, e.getX(), e.getY()));
		this.model.addShape(this.squiggle);
	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
