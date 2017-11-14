package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EraserManipulator extends ShapeManipulator{
	
	private Eraser eraser;
	private Color c = pp.getBackground();
	
	public EraserManipulator(View view) {
		super(view);
	}

	@Override
	public void operationPressed(MouseEvent e) {
		color = pp.getBackground();
		thick = pp.getThickness();
		begin = new Point(e.getX(), e.getY());
		this.eraser = new Eraser(color, begin);
		this.eraser.moveto(begin);
		this.model.setDraw(this.eraser);
	}

	@Override
	public void operationDragged(MouseEvent e) {
		Point newP = new Point(color, thick, e.getX(), e.getY());
        this.eraser.lineto(newP);
        this.eraser.moveto(newP);
	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		this.model.addShape(this.eraser);
		
	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
