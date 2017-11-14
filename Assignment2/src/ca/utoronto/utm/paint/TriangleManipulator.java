package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class TriangleManipulator extends ShapeManipulator{
	
	private Triangle triangle;
	
	public TriangleManipulator(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operationPressed(MouseEvent e) {
		color = pp.getColor();
		thick = pp.getThickness();
		fill = pp.getOpacity();
		stroke = pp.getStroke();
		begin = new Point(color, thick, e.getX(), e.getY());
		System.out.println(e.getX() +" " + e.getY());
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
