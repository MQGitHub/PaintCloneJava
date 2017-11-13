package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SquiggleManipulator extends ShapeManipulator{
	private Squiggle squiggle;
	
	public SquiggleManipulator(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operationPressed(MouseEvent e) {
		Color c = pp.getColor();
		int thick = pp.getThickness();
		boolean fill = pp.getFilled();
		ArrayList<Point> pts = new ArrayList<Point>();
		pts.add(new Point(this.color, thick, e.getX(), e.getY()));
		this.squiggle = new Squiggle(c, thick, pts);
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
