package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class PolylineManipulator extends ShapeManipulator{
	
	private Polyline polyline;
	public PolylineManipulator(View view) {
		super(view);
	}

	@Override
	public void operationPressed(MouseEvent e) {
		color = pp.getColor();
		thick = pp.getThickness();
		begin = new Point(color, thick, e.getX(), e.getY());
		stroke = pp.getStroke();
		if (this.polyline == null) {
			if (this.polyline == null) {
				this.polyline = new Polyline(this.color, thick, true, begin, stroke);
				this.polyline.setStartPoint(begin);
			}
		}
		this.polyline.setEndPoint(begin);
		this.model.setDraw(this.polyline);
	
		
	}

	@Override
	public void operationDragged(MouseEvent e) {
		Point newP = new Point(color, thick, e.getX(), e.getY());
		this.polyline.setEndPoint(newP);
		
	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		if (this.polyline.getStartPoint() != this.polyline.getEndPoint()) {
			Point newP = new Point(color, thick, e.getX(), e.getY());
			this.polyline.setEndPoint(newP);
			this.polyline.addPoint(this.polyline.getStartPoint());
			this.polyline.setStartPoint(newP);
			this.polyline.addPoint(this.polyline.getEndPoint());
			if (!this.polyline.completedPolyline()) {
				this.model.setDraw(this.polyline);
			} else if (this.polyline.completedPolyline() && this.polyline.getNumPoints() > 2) {
				this.model.addShape(this.polyline);
			}

		}
	}

	@Override
	public void operationMoved(MouseEvent e) {

		
	}
}
