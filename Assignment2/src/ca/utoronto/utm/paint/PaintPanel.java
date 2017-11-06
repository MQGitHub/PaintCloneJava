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
			// Draw Circle
			if (s instanceof Circle) {
				int x = s.getCorner().getX();
				int y = s.getCorner().getY();
				int radius = ((Oval) s).getHeight();
				g2d.setColor(s.getColor());
				g2d.setStroke(new BasicStroke(s.getThickness()));
				if (s.isFilled()) {
					g2d.fillOval(x - radius, y - radius, radius * 2, radius * 2);
				} else {
					g2d.drawOval(x - radius, y - radius, radius * 2, radius * 2);
				}
			} // Draw Oval
			else if (s instanceof Oval) {
				int x = s.getCorner().getX();
				int y = s.getCorner().getY();
				int height = ((Oval) s).getHeight();
				int width = ((Oval) s).getWidth();
				g2d.setColor(s.getColor());
				g2d.setStroke(new BasicStroke(s.getThickness()));
				if (s.isFilled()) {
					g2d.fillOval(x, y, width, height);
				} else {
					g2d.drawOval(x, y, width, height);
				}
			} // Draw Square
			else if (s instanceof Square) {
				int x = s.getCorner().getX();
				int y = s.getCorner().getY();
				int width = ((Square) s).getWidth();
				g2d.setColor(s.getColor());
				g2d.setStroke(new BasicStroke(s.getThickness()));
				if (s.isFilled()) {
					g2d.fillRect(x - width, y - width, width * 2, width * 2);
				} else {
					g2d.drawRect(x - width, y - width, width * 2, width * 2);
				}
			} // Draw with Eraser
			else if (s instanceof Eraser) {
				ArrayList<Point> points = ((Eraser) s).getPoints();
				for (int i = 0; i < points.size() - 1; i++) {
					Point p1 = points.get(i);
					Point p2 = points.get(i + 1);
					g2d.setStroke(new BasicStroke(s.getThickness()));
					g2d.setColor(background);
					g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
				}

			} // Draw Rectangle
			else if (s instanceof Rectangle) {
				int x = s.getCorner().getX();
				int y = s.getCorner().getY();
				int height = ((Rectangle) s).getHeight();
				int width = ((Rectangle) s).getWidth();
				g2d.setColor(s.getColor());
				g2d.setStroke(new BasicStroke(s.getThickness()));
				if (s.isFilled()) {
					g2d.fillRect(x, y, width, height);
				} else {
					g2d.drawRect(x, y, width, height);
				}
			} // Draw Line
			else if (s instanceof Line) {
				Point p2 = s.getCorner();
				Point p1 = ((Line) s).getEndPoint();
				g2d.setColor(s.getColor());
				g2d.setStroke(new BasicStroke(s.getThickness()));
				g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());

			} // Draw Squiggles
			else if (s instanceof Squiggle) {
				ArrayList<Point> points = ((Squiggle) s).getPoints();
				for (int i = 0; i < points.size() - 1; i++) {
					Point p1 = points.get(i);
					Point p2 = points.get(i + 1);
					g2d.setColor(p1.getColor());
					g2d.setStroke(new BasicStroke(p1.getThickness()));
					if ((p1.getX() == -1 && p1.getY() == -1) || (p2.getX() == -1 && p2.getY() == -1)) {
						i = i + 2;
					} else {
						g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					}
				}
			} // Draw Polyline
			else if (s instanceof Polyline) {
				ArrayList<Point> polylinePoints = ((Polyline) s).getPoints();
				for (int i = 0; i < polylinePoints.size() - 1; i++) {
					Point p1 = polylinePoints.get(i);
					Point p2 = polylinePoints.get(i + 1);
					g2d.setColor(p2.getColor());
					g2d.setStroke(new BasicStroke(p2.getThickness()));
					g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
				}
			} // Draw Triangle
			else if (s instanceof Triangle) {
				int x = s.getCorner().getX();
				int y = s.getCorner().getY();
				int height = ((Triangle) s).getHeight();
				int base = ((Triangle) s).getBase();
				g2d.setColor(s.getColor());
				g2d.setStroke(new BasicStroke(s.getThickness()));
				Polygon p = new Polygon();
				p.addPoint((x + base)/ 2, y);
				p.addPoint(x, height);
				p.addPoint(base, height);
				if (s.isFilled()) {
					g2d.fillPolygon(p);
				} else {
					g2d.drawPolygon(p);
				}
			}
			Point end = this.polyline.getEndPoint();
			Point start = this.polyline.getStartPoint();
			if (start.getX() != end.getX() || start.getY() != end.getY()) {
				g2d.setColor(end.getColor());
				g2d.setStroke(new BasicStroke(end.getThickness()));
				g2d.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
			}
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

	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		if (this.mode != "Polyline") {
			this.polyline = new Polyline(this.colour, thickness, false, begin);
		}
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		}
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

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
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {
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
			if (this.polyline != null) {
				this.polyline.addPoint(begin);
			} else {
				this.polyline = new Polyline(this.colour, thickness, false, begin);
				this.polyline.addPoint(begin);
			}
			this.polyline.setStartPoint(begin);

		} else if (this.mode == "Triangle") {
			begin = new Point(this.colour, thickness, e.getX(), e.getY());
			this.triangle = new Triangle(this.colour, thickness, filled, begin);

		}
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
			Point newP = new Point(this.colour, thickness, e.getX(), e.getY());
			this.polyline.setEndPoint(newP);
			this.polyline.setStartPoint(newP);
			this.polyline.addPoint(this.polyline.getEndPoint());
			if (this.polyline.getNumPoints() == 2) {
				this.model.addShape(polyline);
				this.model.addShape(polyline);
			} else if (!this.polyline.completedPolyline()) {
				this.model.addShape(this.polyline);
			} else if (this.polyline.completedPolyline() && this.polyline.getNumPoints() > 2) {
				this.model.addShape(this.polyline);
				this.polyline = new Polyline(this.colour, thickness, false, begin);
			} else {
				this.polyline = new Polyline(this.colour, thickness, false, begin);
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		}
	}

	public void setColour(Color colour) {
		this.colour = colour;

	}
}
