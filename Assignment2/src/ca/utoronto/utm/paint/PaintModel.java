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

	private ArrayList<Polyline> polylines = new ArrayList<Polyline>();
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	/**
	 * if there are no shapes in the ArrayList shapes, then add a circle with
	 * co-ordinates outside of our panel. else add given shape to the shapes 
	 * ArrayList. Then setchanged and notify observers.
	 * 
	 * @param p a shape that will be drawn onto our Panel. 
	 * @see     Observable 
	 */
	public void addShape(Shape p) {
		if (shapes.size() == 0) {

			this.shapes.add(new Circle(Color.WHITE, 0, false, new Point(-1, -1), 0));
		} else {

			this.shapes.add(shapes.size() - 1, p);
		}

		this.setChanged();
		this.notifyObservers();
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
	

	/**
	 * Add given Polyline to the polyline ArrayList. Then setchanged and 
	 * notify observers.
	 * 
	 * @param p a Polyline that will be drawn onto our Panel. 
	 * @see     Observable 
	 */
	public void addPolyline(Polyline p) {
		this.polylines.add(p);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Returns an ArrayList containing all the Polylines so that they can
	 * be drawn onto the panel.
	 * 
	 * @return shapes	ArrayList containing all the current Polylines.
	 */
	public ArrayList<Polyline> getPolylines() {
		return polylines;
	}

		
}

