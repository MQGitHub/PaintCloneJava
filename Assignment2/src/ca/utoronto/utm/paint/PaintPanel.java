package ca.utoronto.utm.paint;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener  {
	private int i=0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	
	private String mode; // modifies how we interpret input (could be better?)
	private Circle circle; // the circle we are building
	private Point begin;
	private Rectangle rectangle;
	private Square square;
	private Polyline polyline;
	private Graphics g2d;
	
	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		this.mode="Rectangle"; // bad code here?
		
		this.model = model;
		this.model.addObserver(this);
		
		this.view=view;
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// setBackground (Color.blue); 
		// Origin is at the top left of the window 50 over, 75 down
		g2d.setColor(Color.white);
        g2d.drawString ("i="+i, 25, 25);
		i=i+1;

		// Draw Lines
		ArrayList<Point> points = this.model.getPoints();
		for(int i=0;i<points.size()-1; i++){
			Point p1=points.get(i);
			Point p2=points.get(i+1);
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
		
		// Draw Circles
		ArrayList<Circle> circles = this.model.getCircles();
		for(Circle c: this.model.getCircles()){
			int x = c.getCentre().getX();
			int y = c.getCentre().getY();
			int radius = c.getRadius();
			g2d.drawOval(x-(radius/2),y-(radius/2), radius, radius);
		}
		
		ArrayList<Rectangle> rectangles = this.model.getRectangles();
		for(Rectangle r: this.model.getRectangles()) {
			int x = r.getCorner().getX();
			int y = r.getCorner().getY();
			int height = r.getHeight();
			int width = r.getWidth();
			g2d.drawRect(x, y, width, height);
			}
		
		ArrayList<Square> squares = this.model.getSquares();
		for(Square s: this.model.getSquares()) {
			int x = s.getCorner().getX();
			int y = s.getCorner().getY();
			int width = s.getWidth();
			g2d.drawRect(x-(width/2), y-(width/2), width, width);
		}
		
		ArrayList<Polyline> polylines = this.model.getPolylines();
		for(Polyline s: polylines) {
			ArrayList<Point> polylinePoints = s.getPoints();
			for (int i = 0; i < polylinePoints.size()-1; i++) {
				Point p1 = polylinePoints.get(i);
				Point p2 = polylinePoints.get(i+1);
				g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
		}
		
		
		Point end = this.model.getEndPoint();
		Point start = this.model.getStartPoint();
		if (start.getX() != end.getX() && start.getY() != end.getY()) {
			g2d.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
		}
	
		
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 *  Controller aspect of this
	 */
	public void setMode(String mode){
		this.mode=mode;
	}
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		if (this.mode != "Polyline") {
			this.polyline = new Polyline();
		}
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
		
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int min_X = Math.min(begin.getX(), e.getX());
		int min_Y = Math.min(begin.getY(), e.getY());
		int max_X = Math.max(begin.getX(), e.getX());
		int max_Y = Math.max(begin.getY(), e.getY());
		if(this.mode=="Squiggle"){
			this.model.addPoint(new Point(e.getX(), e.getY()));
		} else if(this.mode=="Circle"){
			int x = begin.getX()-e.getX();
			int y = begin.getY() - e.getY();
			int radius = (int) Math.sqrt(Math.pow(x,2) + 
					Math.pow(y, 2));
			this.circle.setRadius(radius);
			this.model.addCircle(this.circle);
		}else if(this.mode == "Rectangle") {
			this.rectangle.setCorner(new Point(min_X, min_Y));
			this.rectangle.setWidth(max_X - min_X);
			this.rectangle.setHeight(max_Y - min_Y);
			this.model.addRectangle(this.rectangle);
		}else if(this.mode =="Square") {
			int x = begin.getX() - e.getX();
			int y = begin.getY() - e.getY();
			int width = (int) Math.sqrt(Math.pow(x,2) +  Math.pow(y, 2));
			this.square.setWidth(width);
			this.model.addSquare(this.square);
		} else if(this.mode=="Polyline") {
			Point newP = new Point(e.getX(), e.getY());
			this.model.setEndPoint(newP);
			
		}
		repaint();
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		begin = new Point(e.getX(), e.getY());
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			this.circle = new Circle(begin, 0);
		}else if(this.mode=="Rectangle") {
			this.rectangle = new Rectangle(begin,0,0);

		}else if(this.mode=="Square") {
			this.square = new Square(begin,0);
		}else if(this.mode=="Polyline") {
			this.model.setStartPoint(begin);
			if (this.polyline != null) {
				this.polyline.addPoint(begin);
			} else {
				this.polyline = new Polyline();
				this.polyline.addPoint(begin);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			if(this.circle!=null){
			}
		} else if(this.mode=="Polyline") {
			Point newP = new Point(e.getX(), e.getY());
			this.model.setEndPoint(newP);
			this.model.setStartPoint(newP);
			this.polyline.addPoint(this.model.getEndPoint());
			this.model.setStartPoint(this.model.getEndPoint());
			System.out.println(this.polyline.getNumPoints());
			System.out.println(begin.getX() + " " + begin.getY() + " " + newP.getX() + " " + newP.getY());
			if (this.polyline.getFirstPoint().getX() != this.polyline.getLastPoint().getX()
					&& this.polyline.getFirstPoint().getY() != this.polyline.getLastPoint().getY()) {
				this.model.addPolyline(this.polyline);
			} else if(this.polyline.getFirstPoint().getX() == this.polyline.getLastPoint().getX()
					&& this.polyline.getFirstPoint().getY() == this.polyline.getLastPoint().getY()
					&& this.polyline.getNumPoints() > 2) {
				this.model.addPolyline(this.polyline);
				this.polyline = new Polyline();
			} else {
				this.polyline = new Polyline();
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}
}
