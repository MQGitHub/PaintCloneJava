package ca.utoronto.utm.paint;

import javax.swing.*;

import ca.utoronto.utm.paint.Point;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener {
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view


	private boolean filled;
	private Color colour;// keeps track of the current color
	private Color background; // keeps track of background color
	private int thickness; // sets the thickness of the line
	private String textFont = "Arial Narrow";
	private int fontSize = 10;
	private TextBox tBox;
	private Shape toDraw;
	private BasicStroke stroke;
	private ShapeManipulator shapeManipulator;

	
	public PaintPanel(PaintModel model, View view) {
		background = Color.white;
		this.setBackground(background);
		this.colour = Color.black;
		this.setPreferredSize(new Dimension(300, 300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.stroke = new BasicStroke(this.thickness);
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
		for (Shape s : shapes) {
			s.draw(g2d);
		}
			
		
		if (this.model.getDraw() != null) {
			this.toDraw = this.model.getDraw();
			this.toDraw.draw(g2d);
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
	public void setShape(ShapeManipulator mode) {
		this.shapeManipulator = mode;
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
	 * Set font of text
	 * 
	 * @param font
	 */
	public void setFont(String font) {
		this.textFont = font;

	}

	/**
	 * Set font size of text
	 * 
	 * @param size
	 */
	public void setFontSize(int size) {
		this.fontSize = size;
	}

	/**
	 * Set colour of shape.
	 * 
	 * @param colour
	 */
	public void setColour(Color colour) {
		this.colour = colour;
	}
	/**
	 * Set thickness and stroke style of shape border.
	 * 
	 * @param stroke
	 *            The stroke style
	 * @param thickness
	 *            The thickness
	 */
	public void setStroke(BasicStroke stroke, int thickness) {
		this.thickness = thickness;
		this.stroke = stroke;
	}
	
	/**
	 * 
	 * @return chosen colour
	 */
	public Color getColor() {
		return this.colour;
	}
	
	/**
	 * 
	 * @return chosen thickness
	 */
	public int getThickness() {
		return this.thickness;
	}
	
	/**
	 * 
	 * @return if shape should be filled
	 */
	public boolean getFilled() {
		return this.filled;
	}


	/**
	 * 
	 * @return current model
	 */
	public PaintModel getModel() {
		return this.model;
	}
	
	public int getFontSize() {
		return this.fontSize;
	}
	
	public String getTextFont() {
		return this.textFont;
	}
	
	public BasicStroke getStroke() {
		return this.stroke;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		shapeManipulator.operationMoved(e);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.shapeManipulator.operationPressed(e);
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.shapeManipulator.operationDragged(e);
		repaint();
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
		this.shapeManipulator.operationClicked(e);
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.shapeManipulator.operationReleased(e);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
