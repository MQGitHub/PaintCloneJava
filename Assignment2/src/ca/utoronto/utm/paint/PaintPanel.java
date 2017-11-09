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

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener {
	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private String mode; // modifies how we interpret input (could be better?)
	private Circle circle; // the circle we are building
	private Point begin, end; // beginning and end of a point
	private Rectangle rectangle;
	private Square square;
	private Polyline polyline;
	private Line line;
	private Oval oval;
	private boolean filled;
	private Color colour;// keeps track of the current color
	private Color background; // keeps track of background color
	private Eraser eraser;
	private int thickness; // sets the thickness of the line
	private Squiggle squiggle;
	private Triangle triangle;

	public PaintPanel(PaintModel model, View view) {
		background = Color.white;
		this.setBackground(background);
		this.colour = Color.black;
		this.setPreferredSize(new Dimension(300, 300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.mode = "Circle"; // bad code here?

		this.model = model;
		this.model.addObserver(this);

		this.view = view;
	}

	/**
	 * View aspect of this
	 */
	@Override
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!

		super.paintComponent(g); // paint background
		Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// setBackground (Color.blue);
		// Origin is at the top left of the window 50 over, 75 down
		g2d.setColor(Color.black);

		// Draw the shapes
		ArrayList<Shape> shapes = this.model.getShapes();
		for (Shape s : this.model.getShapes()) {
			//System.out.println(shapes);
			s.draw(g2d);
			}
		}


	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}

	/**
	 * Controller aspect of this
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * Set shape should be filled or not
	 * 
	 * @param fill
	 */
	public void setFill(boolean fill) {
		this.filled = fill;
	}

	/**
	 * Set thickness of shape border.
	 * 
	 * @param thickness
	 */
	public void setThickness(int thickness) {
		this.thickness = thickness;

	}
	
	/**
	 * Set colour of shape.
	 * 
	 * @param colour
	 */
	public void setColour(Color colour) {
		this.colour = colour;
	}

	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		if (this.mode != "Polyline") {
			this.polyline = null;
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		begin = new Point(e.getX(), e.getY());
		if (this.mode == "Squiggle") {
			ArrayList<Point> pts = new ArrayList<Point>();
			pts.add(new Point(this.colour, thickness, e.getX(), e.getY()));
			this.squiggle = new Squiggle(this.colour, thickness, pts);

		} else if (this.mode == "Circle") {
			this.circle = new Circle(this.colour, thickness, filled, begin, 0);

		} else if (this.mode == "Rectangle") {
			this.rectangle = new Rectangle(this.colour, thickness, filled, begin, 0, 0);

		} else if (this.mode == "Square") {
			this.square = new Square(this.colour, thickness, filled, begin, 0);

		} else if (this.mode == "Line") {
			this.line = new Line(this.colour, thickness, false, begin, begin);

		} else if (this.mode == "Oval") {
			this.oval = new Oval(this.colour, thickness, filled, begin, 0, 0);

		} else if (this.mode == "Eraser") {
			ArrayList<Point> er = new ArrayList<Point>();
			er.add(new Point(this.background, 15, e.getX(), e.getY()));
			this.eraser = new Eraser(background, er);

		} else if (this.mode == "Polyline") {
			begin = new Point(this.colour, thickness, e.getX(), e.getY());
			if (this.polyline == null) {
				this.polyline = new Polyline(this.colour, thickness, filled, begin);
			}
			this.polyline.setEndPoint(begin);
		} else if (this.mode == "Triangle") {
			begin = new Point(this.colour, thickness, e.getX(), e.getY());
			this.triangle = new Triangle(this.colour, thickness, filled, begin);

		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int min_X = Math.min(begin.getX(), e.getX());
		int min_Y = Math.min(begin.getY(), e.getY());
		int max_X = Math.max(begin.getX(), e.getX());
		int max_Y = Math.max(begin.getY(), e.getY());

		if (this.mode == "Squiggle") {
			this.squiggle.addPoint(new Point(this.colour, thickness, e.getX(), e.getY()));
			this.model.addShape(this.squiggle);

		} else if (this.mode == "Circle") {
			int x = begin.getX() - e.getX();
			int y = begin.getY() - e.getY();
			int radius = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			this.circle.setRadius(radius);
			this.model.addShape(this.circle);

		} else if (this.mode == "Rectangle") {
			this.rectangle.setCorner(new Point(min_X, min_Y));
			this.rectangle.setWidth(max_X - min_X);
			this.rectangle.setHeight(max_Y - min_Y);
			this.model.addShape(this.rectangle);

		} else if (this.mode == "Square") {
			int x = begin.getX() - e.getX();
			int y = begin.getY() - e.getY();
			int width = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			this.square.setWidth(width);
			this.model.addShape(this.square);

		} else if (this.mode == "Polyline") {
			Point newP = new Point(this.colour, thickness, e.getX(), e.getY());
			this.polyline.setEndPoint(newP);
			this.model.addShape(this.polyline);

		} else if (this.mode == "Line") {
			end = new Point(e.getX(), e.getY());
			this.line.setEndPoint(end);
			this.model.addShape(this.line);

		} else if (this.mode == "Oval") {
			this.oval.setCorner(new Point(min_X, min_Y));
			this.oval.setWidth(max_X - min_X);
			this.oval.setHeight(max_Y - min_Y);
			this.model.addShape(this.oval);

		} else if (this.mode == "Eraser") {
			this.eraser.addPoint(new Point(this.background, 15, e.getX(), e.getY()));
			this.model.addShape(this.eraser);

		} else if (this.mode == "Triangle") {
			this.triangle.setBase(e.getX());
			this.triangle.setHeight(e.getY());
			this.model.addShape(triangle);
		}

		repaint();
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.mode == "Squiggle") {
			this.squiggle.addPoint(new Point(-1, -1));
			this.model.addShape(this.squiggle);

		} else if (this.mode == "Circle") {
			if (this.circle != null) {
			}

		} else if (this.mode == "Polyline") {
			if (this.polyline.getStartPoint() != this.polyline.getEndPoint()) {
				System.out.println(this.polyline);
				Point newP = new Point(this.colour, thickness, e.getX(), e.getY());
				this.polyline.setEndPoint(newP);
				this.polyline.inRadius(newP);
				this.polyline.addPoint(this.polyline.getStartPoint());
				this.polyline.setStartPoint(newP);
				this.polyline.addPoint(this.polyline.getEndPoint());
				if (this.polyline.getNumPoints() == 2) {
					this.model.addShape(polyline);
					this.model.addShape(polyline);
				} else if (!this.polyline.completedPolyline()) {
					this.model.addShape(this.polyline);
				} else if (this.polyline.completedPolyline() && this.polyline.getNumPoints() > 2) {
					this.model.addShape(this.polyline);
					this.polyline = null;
				} else {
					this.polyline = null;
				}
			} else {
				this.polyline = null;
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		}
	}
	
}
