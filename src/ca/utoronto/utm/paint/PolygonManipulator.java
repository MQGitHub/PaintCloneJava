package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class PolygonManipulator extends ShapeManipulator{
	
	private Polygon polygon;
	public PolygonManipulator(View view) {
		super(view);
	}

	@Override
	public void operationPressed(MouseEvent e) {
		color = pp.getColor();
		thick = pp.getThickness();
		fill = pp.getOpacity();
		begin = new Point(color, thick, e.getX(), e.getY());
		stroke = pp.getStroke();
		if (e.getButton() == MouseEvent.BUTTON3 && this.polygon != null) {
            this.polygon.Complete();
            this.model.addShape(this.polygon);
            this.polygon = null;
            return;
        }
		if (this.polygon == null) {
			if (this.polygon == null) {
				this.polygon = new Polygon(this.color, thick, fill, begin, stroke);
				this.polygon.setStartPoint(begin);
			}
		}
		this.polygon.setEndPoint(begin);
		this.model.setDraw(this.polygon);
	
		
	}

	@Override
	public void operationDragged(MouseEvent e) {
		Point newP = new Point(color, thick, e.getX(), e.getY());
		if (this.polygon != null) {
			this.polygon.setEndPoint(newP);
		}
		
	}

	@Override
	public void operationClicked(MouseEvent e) {
	}

	@Override
	public void operationReleased(MouseEvent e) {
		if (this.polygon != null && !this.polygon.completedPolygon()) {
			Point newP = new Point(color, thick, e.getX(), e.getY());
			this.polygon.setEndPoint(newP);
			this.polygon.addPoint(this.polygon.getStartPoint());
			this.polygon.setStartPoint(newP);
			this.polygon.addPoint(this.polygon.getEndPoint());
			if (!this.polygon.completedPolygon()) {
				this.model.setDraw(this.polygon);
			} else if (this.polygon.completedPolygon() && this.polygon.getNumPoints() > 2) {
				this.model.addShape(this.polygon);
				this.polygon = null;
			} else {
				this.polygon = null;
			}

		} else {
			this.polygon = null;
		}
	}

	@Override
	public void operationMoved(MouseEvent e) {
	}
	

}
