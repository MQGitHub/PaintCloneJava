package ca.utoronto.utm.paint;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class RightAngleTriangle extends Triangle{

	public RightAngleTriangle(Color c, int thick, int fill, Point corner, BasicStroke stroke) {
		super(c, thick, fill, corner, stroke);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		int x = this.getCorner().getX();
		int y = this.getCorner().getY();
		int height = this.getHeight();
		int base = this.getBase();
		int i = this.fillAmt();
		g2d.setColor(this.getColor());
		g2d.setStroke(this.getStroke());
		Polygon p = new Polygon();
		p.addPoint(x, y);
		p.addPoint(x, height);
		p.addPoint(base, height);
		if (i > 0) {
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, i* 0.1f));
			g2d.fillPolygon(p);
		} else {
			g2d.drawPolygon(p);
		}
	} 

}
