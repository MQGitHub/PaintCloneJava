package ca.utoronto.utm.paint;


import java.awt.BasicStroke;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class SelectManipulator extends ShapeManipulator{
	
	private Select select;
	private View view;
	private String type;
	private Rectangle rectangle;
	private Point corner;
	/**
	 * Gets the view and string type.
	 * @param view
	 * @param type
	 */
	public SelectManipulator(View view, String type) {
		super(view);
		this.view = view;
		this.type = type;
	}
	
	@Override
	public void operationPressed(MouseEvent e) {
		// TODO Auto-generated method stub
		BasicStroke b = new BasicStroke();
		float dash1 [] = new float[] { 10.0f, 10.0f };
		b = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 1);
		this.corner = new Point(e.getX(), e.getY());
		this.rectangle = new Rectangle(color.black, 1, 0, this.corner, 0, 0, b);
		this.rectangle.setCorner(new Point(e.getX(), e.getY()));
		this.select = new Select(new Point(e.getX(), e.getY()), view);
		int min_X = Math.min(corner.getX(), e.getX());
		int min_Y = Math.min(corner.getY(), e.getY());
		int max_X = Math.max(corner.getX(), e.getX());
		int max_Y = Math.max(corner.getY(), e.getY());
		this.rectangle.setCorner(new Point(min_X, min_Y));
		this.rectangle.setWidth(max_X - min_X);
		this.rectangle.setHeight(max_Y - min_Y);
		view.getPaintPanel().getModel().setDraw(this.rectangle);
		
		
	}

	@Override
	public void operationDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(type == "paste") {
			select.update(e.getX(), e.getY());	
		}else {
			rectangle.setColor(color.black);
			rectangle.setHeight(Math.abs(e.getY() - this.rectangle.getCorner().getY()));
			rectangle.setWidth(Math.abs(e.getX() - this.rectangle.getCorner().getX()));
			view.getPaintPanel().getModel().setDraw(this.rectangle);
		}
		
	}

	@Override
	public void operationClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		select.setSecondCorner(new Point(e.getX(), e.getY()));
		ArrayList<Shape> shapes = view.getPaintPanel().getModel().getShapes();

		for (int i = 0; i < shapes.size() - 1; i++) {
			select.save(shapes.get(i));

		}
		if (type != "paste") {
			type = "paste";
		} else {
			type = "select";
			this.view.getPaintPanel().getModel().resetcopies();
		}
		view.getPaintPanel().getModel().setDraw(null);
	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
