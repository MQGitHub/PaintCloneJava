package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class PolylineManipulator extends ShapeManipulator{
	
	private Polyline polyline;
	private Color c;
	private int thick;

	public PolylineManipulator(View view) {
		super(view);
	}

	@Override
	public void operationPressed(MouseEvent e) {
		c = pp.getColor();
		thick = pp.getThickness();
		begin = new Point(c, thick, e.getX(), e.getY());
		if (this.polyline != null) {
			this.polyline.addPoint(begin);
		} else {
			this.polyline = new Polyline(c, thick, false, begin);
			this.polyline.addPoint(begin);
		}
		this.polyline.setStartPoint(begin);
	
		
	}

	@Override
	public void operationDragged(MouseEvent e) {
		Point newP = new Point(c, thick, e.getX(), e.getY());
		this.polyline.setEndPoint(newP);
		this.model.addShape(this.polyline);
		this.model.removeShape(this.polyline);
	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		Point newP = new Point(c, thick, e.getX(), e.getY());
		this.polyline.setEndPoint(newP);
		this.polyline.setStartPoint(newP);
		this.polyline.addPoint(this.polyline.getEndPoint());
		if (this.polyline.getNumPoints() == 2) {
			this.model.addShape(polyline);
			this.model.addShape(polyline);
		} else if (!this.polyline.completedPolyline()) {
			this.model.addShape(this.polyline);
		} else if (this.polyline.completedPolyline() && this.polyline.getNumPoints() > 2) {
			this.model.addShape(this.polyline);
			this.polyline = new Polyline(c, thick, false, begin);
		} else {
			this.polyline = null;	
		}
		this.model.addShape(this.polyline);
	}

	@Override
	public void operationMoved(MouseEvent e) {
		this.polyline = new Polyline(c, thick, false, begin);
		
	}
	
}
