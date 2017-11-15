package ca.utoronto.utm.paint;


import java.util.ArrayList;

public class Select {
	private Point corner;
	private ArrayList<Point> corners = new ArrayList<Point>();
	private Point Second_Corner;
	private View  view;
	private ArrayList<Shape> Copied_shapes = new ArrayList<Shape>();
	
	public Select(Point Corner, View view) {
		corner = Corner;
		this.view = view;
		Copied_shapes = view.getPaintPanel().getModel().getCopied_shapes();
		corners = view.getPaintPanel().getModel().getcorners();
	}
	
	
	public void save(Shape shape) {
			int x = shape.getCorner().getX();
			int y = shape.getCorner().getY();
			if ((x >= corner.getX() && x <= Second_Corner.getX()) || (x <= corner.getX() && x >= Second_Corner.getX())) {
	
					view.getPaintPanel().getModel().setCopied_shapes(shape);
					view.getPaintPanel().getModel().setcorners(new Point(shape.getCorner().getX() - corner.getX(),
																		shape.getCorner().getY() - corner.getY()));
			}	
	}
	
	public void setSecondCorner(Point Corner) {
		Second_Corner = Corner;
	}
	
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
	