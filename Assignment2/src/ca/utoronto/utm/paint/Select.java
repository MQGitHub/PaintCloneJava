package ca.utoronto.utm.paint;


import java.util.ArrayList;
/**
 * This class creates two points where shapes can be copied and moved.
 * HAS-A: save, setSecondCorner, update.
 *
 */
public class Select {
	private Point corner;
	private ArrayList<Point> corners = new ArrayList<Point>();
	private Point Second_Corner;
	private View  view;
	private ArrayList<Shape> Copied_shapes = new ArrayList<Shape>();
	
	
	
	/**
	 * Gets the view, corner, and current copied shapes and corners of those shapes.
	 * @param Corner
	 * @param view
	 */
	public Select(Point Corner, View view) {
		corner = Corner;
		this.view = view;
		Copied_shapes = view.getPaintPanel().getModel().getCopied_shapes();
		corners = view.getPaintPanel().getModel().getcorners();
	}
	
	/**
	 * checks to see if the given shape is inside the two corners.
	 * if it is inside then add it to the copied shapes and add the
	 * shapes corner to the array lists kept in the model.
	 * @param shape
	 */
	public void save(Shape shape) {
			int x = shape.getCorner().getX();
			int y = shape.getCorner().getY();
			if ((x >= corner.getX() && x <= Second_Corner.getX()) || (x <= corner.getX() && x >= Second_Corner.getX())) {
	
					view.getPaintPanel().getModel().setCopied_shapes(shape);
					view.getPaintPanel().getModel().setcorners(new Point(shape.getCorner().getX() - corner.getX(),
																		shape.getCorner().getY() - corner.getY()));
			}	
	}
	
	
	/**
	 * Sets second_corner point to the point given
	 * @param Corner
	 */
	public void setSecondCorner(Point Corner) {
		Second_Corner = Corner;
	}
	
	/**
	 * Iterates through the copied shapes and updates the corners of said shapes
	 * so that they can be pasted somewhere else. This only is called after shapes 
	 * have been selected.
	 * @param X
	 * @param Y
	 */
	public void update(int X, int Y) {
		int index = 0;
		for(Shape S: Copied_shapes) {
			int x = corners.get(index).getX();
			int y = corners.get(index).getY();
			int x2 = X + (x- x/5);
			int y2 = Y + (y - y/5);
			S.setCorner(new Point(x2,y2));
			index++;
			}
		}
	
	}
	