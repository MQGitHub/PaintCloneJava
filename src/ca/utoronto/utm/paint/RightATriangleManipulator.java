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
		fill = pp.getOpacity();
		stroke = pp.getStroke();
		begin = new Point(color, thick, e.getX(), e.getY());
		rightATriangle = new RightAngleTriangle(color, thick, fill, begin, stroke);
		this.rightATriangle.setBase(e.getX());
		this.rightATriangle.setHeight(e.getY());
		this.model.setDraw(this.rightATriangle);
	}

	@Override
	public void operationDragged(MouseEvent e) {
		this.rightATriangle.setBase(e.getX());
		this.rightATriangle.setHeight(e.getY());
	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		this.model.addShape(this.rightATriangle);

	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
