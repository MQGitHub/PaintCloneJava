package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * 
 * Create the Eraser Lines on the console by listenening to the mouse.
 * EraserManipulator is a ShapeManipulator and has a View where we draw the
 * Eraser.
 *
 */
public class EraserManipulator extends ShapeManipulator{
	
	
	private Eraser eraser;
	private Color c = pp.getBackground();
	
	/**
	 * Initialize the view by connecting the view and EraserManipulator.
	 * 
	 * @param view
	 *            The view of Paint model.
	 */
	public EraserManipulator(View view) {
		super(view);
	}

	/**
	 * Control aspect of this
	 */
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
