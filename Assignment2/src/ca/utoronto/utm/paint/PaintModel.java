package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Represents the model for our paint application. Containing
 * all shapes and and polylines. 
 *
 */
public class PaintModel extends Observable {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<Shape> removedShapes = new ArrayList<Shape>();
	private Shape current;

	/**
	 * if there are no shapes in the ArrayList shapes, then add a circle with
	 * co-ordinates outside of our panel. else add given shape to the shapes 
	 * ArrayList. Then setchanged and notify observers.
	 * 
	 * @param p a shape that will be drawn onto our Panel. 
	 * @see     Observable 
	 */
	public void addShape(Shape p) {
		
		if (p.getUsed()) {
			this.shapes.add(p);
		}
		this.current = null;
		this.setChanged();
		this.notifyObservers();
	}
	
	public void Undo() {
		
		if (shapes.size() > 0) {
			this.removedShapes.add(this.shapes.get(this.shapes.size()-1));
			this.shapes.remove(this.shapes.size()-1);
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public void Redo() {
		
		if (this.removedShapes.size() > 0) {
			this.shapes.add(this.removedShapes.get(this.removedShapes.size()-1));
			this.removedShapes.remove(this.removedShapes.size()-1);
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public void Clear() {
		this.shapes.clear();
		this.removedShapes.clear();
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setDraw(Shape object) {
		this.current = object;
	}
	
	public Shape getDraw() {
		return this.current;
	}
	
	/**
	 * Returns an ArrayList containing all the shapes so that they can
	 * be drawn onto the panel.
	 * 
	 * @return shapes	ArrayList containing all the current shapes.
	 */
	public ArrayList<Shape> getShapes() {
		return shapes;
	}	
}

