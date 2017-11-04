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
	private Point begin, end;
	private Rectangle rectangle;
	private Square square;
	private Line line;
	private Oval oval;
	private Shape shape;
	private Graphics g2d;
	
	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		//this.mode="Rectangle"; // bad code here?
		
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
			if ((p1.getX() == -1 && p1.getY() == -1) || (p2.getX() == -1 && p2.getY() == -1)) {
				i = i + 2;
			}else {
				g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
		}
		ArrayList<Shape> shapes = this.model.getShapes();
		for(Shape s: this.model.getShapes()) {
			if(s instanceof Circle) {
				int x = s.getCorner().getX();
				int y = s.getCorner().getY();
				int radius = ((Oval) s).getHeight();
				g2d.drawOval(x-radius,y-radius, radius*2, radius*2);
			}else if(s instanceof Oval){
				int x = s.getCorner().getX();
				int y = s.getCorner().getY();
				int height = ((Oval)s).getHeight();
				int width = ((Oval)s).getWidth();
				g2d.setColor(Color.GREEN);
				g2d.fillOval(x, y, width, height);
				g2d.drawOval(x, y, width, height);
			}else if(s instanceof Square) {
				int x = s.getCorner().getX();
				int y = s.getCorner().getY();
				int width = ((Square)s).getWidth();
				g2d.drawRect(x-width, y-width, width*2, width*2);
			}else if(s instanceof Rectangle){
				int x = s.getCorner().getX();
				int y = s.getCorner().getY();
				int height = ((Rectangle)s).getHeight();
				int width = ((Rectangle)s).getWidth();
				g2d.drawRect(x, y, width, height);
			}else if(s instanceof Line) {
				Point p2 = s.getCorner();
				Point p1 = ((Line)s).getEndPoint();
				g2d.drawLine(p1.getX(), p1.getY(),p2.getX(), p2.getY());
			}
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
			this.model.addShape(this.circle);
		}else if(this.mode == "Rectangle") {
			this.rectangle.setCorner(new Point(min_X, min_Y));
			this.rectangle.setWidth(max_X - min_X);
			this.rectangle.setHeight(max_Y - min_Y);
			this.model.addShape(this.rectangle);
		}else if(this.mode =="Square") {
			int x = begin.getX() - e.getX();
			int y = begin.getY() - e.getY();
			int width = (int) Math.sqrt(Math.pow(x,2) +  Math.pow(y, 2));
			this.square.setWidth(width);
			this.model.addShape(this.square);
		}else if(this.mode=="Line") {
			end = new Point(e.getX(), e.getY());
			this.line.setEndPoint(end);
			this.model.addShape(this.line);
		}else if(this.mode=="Oval") {
			this.oval.setCorner(new Point(min_X, min_Y));
			this.oval.setWidth(max_X - min_X);
			this.oval.setHeight(max_Y - min_Y);
			this.model.addShape(this.oval);
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
		}else if(this.mode=="Line") {
			this.line = new Line(begin,begin);
		}else if(this.mode=="Oval") {
			this.oval = new Oval(begin,0,0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.mode=="Squiggle"){
			this.model.addPoint(new Point(-1,-1));
		} else if(this.mode=="Circle"){
			if(this.circle!=null){
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

