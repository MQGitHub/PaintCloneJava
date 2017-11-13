package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class RightAngleTriangle extends Triangle{

	public RightAngleTriangle(Color c, int thick, Boolean b, Point corner) {
		super(c, thick, b, corner);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		int x = this.getCorner().getX();
		int y = this.getCorner().getY();
		int height = this.getHeight();
		int base = this.getBase();
		g2d.setColor(this.getColor());
		g2d.setStroke(new BasicStroke(this.getThickness()));
		Polygon p = new Polygon();
		p.addPoint(x, y);
		p.addPoint(x, height);
		p.addPoint(base, height);
		if (this.isFilled()) {
			g2d.fillPolygon(p);
		} else {
			g2d.drawPolygon(p);
		}
	} 

}
