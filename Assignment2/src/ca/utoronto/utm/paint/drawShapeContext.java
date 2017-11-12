package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

public class drawShapeContext {
	private drawShape strategy;
	private Graphics2D g2d;
	
	public void drawGeometricShape(){
        strategy.draw(g2d);
    }
	
	public void setStrategy(drawShape strategy){
        this.strategy = strategy;
    }

}
