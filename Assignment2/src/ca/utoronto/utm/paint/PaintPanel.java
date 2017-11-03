
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
	private Color colour; // keeps track of the current color
	private ArrayList<Object> ListColours; 
	
	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.blue);
		this.colour = Color.white;
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.ListColours = new ArrayList<Object>();
		this.ListColours.add(Color.WHITE);
		
		this.mode="Circle"; // bad code here?
		
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
		
		g2d.setColor(this.colour);
		
        g2d.drawString ("i="+i, 50, 75);
		i=i+1;
		System.out.println(i);
			int check = 0;
		// Draw Lines
			ArrayList<Point> pointss = this.model.getPoints();
			this.ListColours.add(i);
			for (int i = 0;i< pointss.size()-1; i++) {
				Point p1= pointss.get(i);
				Point p2= pointss.get(i+1);
				if (this.ListColours.get(i) instanceof Color) {
					this.colour = (Color) this.ListColours.get(i);
					g2d.setColor(this.colour);
				}
				if ((p1.getX() == -1 && p1.getY() == -1) || (p2.getX() == -1 && p2.getY() == -1)) {
					// if fake point (-1,-1) as made, skip that point. So you can draw separate scribbles.
					i++;
					
				}else{
					
					
				if((p1.getX() == -2 && p1.getY() == -2) || (p2.getX() == -2 && p2.getY() == -2)) {
						
						// if fake point (-2,-2) was made, change the color, and skip that point
						i++;
						if(check < ListColours.size()-1) {
						//g2d.setColor(ListColours.get(check));
						check++;
						}
					
				}else {
					
					//draw a line between the points given.
					g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
				
					}
				}
		 		
			}
		
		// Draw Circles
		ArrayList<Circle> circles = this.model.getCircles();
		for(Circle c: this.model.getCircles()){
			int x = c.getCentre().getX();
			int y = c.getCentre().getY();
			int radius = c.getRadius();
			g2d.drawOval(x, y, radius, radius);
		}
		
		g2d.dispose();
	}
	
	public void setColour(Color colour) {
		this.colour = colour;
		this.ListColours.set(i-1, colour);
		//ListColours.clear();
		//SecondListColour.add(colour);
		//ListColours = SecondListColour.clone();
		//model.addPoint(new Point(-2,-2));
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
		if(this.mode=="Squiggle"){
			this.model.addPoint(new Point(e.getX(), e.getY()));
			
		} else if(this.mode=="Circle"){
			
		}
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
		if(this.mode=="Squiggle"){
		
		} else if(this.mode=="Circle"){
			// Problematic notion of radius and centre!!
			Point centre = new Point(e.getX(), e.getY());
			int radius = 0;
			this.circle=new Circle(centre, 0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.mode=="Squiggle"){
			//adds fake point, so the paintComponent can know when to skip a point
			this.model.addPoint(new Point(-1,-1));
		} else if(this.mode=="Circle"){
			if(this.circle!=null){
				// Problematic notion of radius and centre!!
				int radius = Math.abs(this.circle.getCentre().getX()-e.getX());
				this.circle.setRadius(radius);
				this.model.addCircle(this.circle);
				this.circle=null;
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

