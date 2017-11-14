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
		color = pp.getColor();
		thick = pp.getThickness();
		fill = pp.getFilled();
		stroke = pp.getStroke();
		begin = new Point(e.getX(), e.getY());
		this.squiggle = new Squiggle(color, thick, false, begin, stroke);
		this.squiggle.moveto(begin);
	}

	@Override
	public void operationDragged(MouseEvent e) {
		Point newP = new Point(color, thick, e.getX(), e.getY());
        this.squiggle.lineto(newP);
        this.squiggle.moveto(newP);
        this.model.setDraw(this.squiggle);	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		this.model.addShape(this.squiggle);
		
	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
