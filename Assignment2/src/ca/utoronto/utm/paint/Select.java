package ca.utoronto.utm.paint;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
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
		System.out.println("In Save Method");
		
			int x = shape.getCorner().getX();
			//int y = S.getCorner().getY();
			//if  (corner.getX() < Second_Corner.getX()) {
				if ( x > corner.getX() && x < Second_Corner.getX()) {
					System.out.println("50 percent");
					//if(y < corner.getY() && y > Second_Corner.getY()){  
						System.out.println("100 percent");
						view.getPaintPanel().getModel().setCopied_shapes(shape);
						view.getPaintPanel().getModel().setcorners(shape.getCorner());
						
			//	}
			
		//}
				}
	}
	
	public void setSecondCorner(Point Corner) {
		Second_Corner = Corner;
	}

	
	public void update(int X, int Y) {
		int index = 0;
		
		for(Shape S: Copied_shapes) {
			System.out.println("in here");
			int x2 = X + corners.get(index).getX();
			int y2 = Y + corners.get(index).getY();
			S.setCorner(new Point(x2,y2));
			index++;
			
			}
		}
	

	}
	
	


