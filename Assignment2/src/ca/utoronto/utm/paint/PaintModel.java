package ca.utoronto.utm.paint;

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
	
	
	public void addPoint(Point p){
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Point> getPoints(){
		return points;
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
