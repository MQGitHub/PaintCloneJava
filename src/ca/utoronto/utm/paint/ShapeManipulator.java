package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.MouseEvent;

public abstract class ShapeManipulator {
	protected PaintPanel pp;
	protected Color color;
	protected int thick;
	protected int fill;
	protected Point begin,end;
	protected PaintModel model;
	protected BasicStroke stroke;
	public ShapeManipulator(View view) {
		pp = view.getPaintPanel();
		model = pp.getModel();
		
	}
	
	public abstract void operationPressed(MouseEvent e);
	
	public abstract void operationDragged(MouseEvent e);
	
	public abstract void operationClicked(MouseEvent e);
	
	public abstract void operationReleased(MouseEvent e);
	
	public abstract void operationMoved(MouseEvent e);
}
