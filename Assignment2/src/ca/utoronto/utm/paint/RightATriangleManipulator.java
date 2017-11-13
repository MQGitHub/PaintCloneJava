package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class RightATriangleManipulator extends ShapeManipulator{

	public RightATriangleManipulator(View view) {
		super(view);
	}

	@Override
	public void operationPressed(MouseEvent e) {
		Color c = pp.getColor();
		int thick = pp.getThickness();
		boolean fill = pp.getFilled();
		
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
