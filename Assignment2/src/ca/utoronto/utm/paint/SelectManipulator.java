package ca.utoronto.utm.paint;


import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class SelectManipulator extends ShapeManipulator{
	
	private Select select;
	private View view;
	private String type;
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
		this.select = new Select(new Point(e.getX(), e.getY()), view);
		
		
	}

	@Override
	public void operationDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(type == "paste") {
			System.out.println(type);
			select.update(e.getX(), e.getY());
			
			
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
		
	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
