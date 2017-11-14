package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class RightATriangleManipulator extends ShapeManipulator{
	
	private RightAngleTriangle rightATriangle;

	public RightATriangleManipulator(View view) {
		super(view);
	}

	@Override
	public void operationPressed(MouseEvent e) {
		color = pp.getColor();
		thick = pp.getThickness();
		fill = pp.getFilled();
		stroke = pp.getStroke();
		begin = new Point(color, thick, e.getX(), e.getY());
		rightATriangle = new RightAngleTriangle(color, thick, fill, begin, this.stroke);
	}

	@Override
	public void operationDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
