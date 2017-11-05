package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	private ArrayList<Point> points=new ArrayList<Point>();
	private ArrayList<Circle> circles=new ArrayList<Circle>();
	private ArrayList<Rectangle> rectangles=new ArrayList<Rectangle>();
	private ArrayList<Square> squares = new ArrayList<Square>();
	private ArrayList<Polyline> polylines = new ArrayList<Polyline>();
	private Point startPoint = new Point(-1, -1);
	private Point endPoint = new Point(-1, -1);
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public void addShape(Shape p) {
		if(shapes.size() ==0) {
			this.shapes.add( new Circle(Color.WHITE, 0, false, new Point(-1,-1), 0));
		}else {
		this.shapes.add(shapes.size()-1, p);
		}
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	public void addCircle(Circle c){
		this.circles.add(c);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Circle> getCircles(){
		return circles;
	}
	
	public void addRectangle(Rectangle r) {
		this.rectangles.add(r);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Rectangle> getRectangles(){
		return rectangles;
	}
	
	public void addSquare(Square s) {
		this.squares.add(s);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Square> getSquares(){
		return squares;
	}
	
	public void addPolyline(Polyline p) {
		this.polylines.add(p);
		this.setChanged();
		this.notifyObservers();
	}
	
	public ArrayList<Polyline> getPolylines(){
		return polylines;
	}
	
	public void setStartPoint(Point p) {
		this.startPoint = p;
	}
	
	public Point getStartPoint() {
		return this.startPoint;
	}
	
	public void setEndPoint(Point p) {
		this.endPoint = p;
	}
	
	public Point getEndPoint() {
		return this.endPoint;
	}
	
}

