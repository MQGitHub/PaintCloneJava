package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EraserManipulator extends ShapeManipulator{
	
	private Eraser eraser;
	
	public EraserManipulator(PaintPanel pp) {
		super(pp);
	}

	@Override
	public void operationPressed(MouseEvent e) {
		ArrayList<Point> er = new ArrayList<Point>();
		er.add(new Point(color.white, 15, e.getX(), e.getY()));
		this.eraser = new Eraser(color.WHITE, er);
		
	}

	@Override
	public void operationDragged(MouseEvent e) {
		this.eraser.addPoint(new Point(Color.WHITE, 15, e.getX(), e.getY()));
		this.model.addShape(this.eraser);
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
