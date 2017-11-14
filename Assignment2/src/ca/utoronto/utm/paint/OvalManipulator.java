package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class OvalManipulator extends ShapeManipulator{
	private Oval oval;
	
	public OvalManipulator(View view) {
		super(view);
	}
	@Override
	public void operationPressed(MouseEvent e) {
		Color c = pp.getColor();
		thick = pp.getThickness();
		fill = pp.getOpacity();
		stroke = pp.getStroke();
		begin = new Point(e.getX(), e.getY());
		this.oval = new Oval(c, thick, fill, begin, 0, 0, stroke);
		this.model.setDraw(this.oval);
	
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
