package ca.utoronto.utm.paint;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

public class LineThicknessChooser implements ChangeListener {

	private View view; // So we can talk to our parent or other components of the view
	
	public LineThicknessChooser(View view) {	
		this.view=view;
	}
	
	public JMenuBar lineThicknessMenu() {
		
		JMenuBar b = new JMenuBar();
		JMenu line = new JMenu("Line Thickness");
		
		JSlider thickness = new JSlider(0, 10, 0);
		thickness.setPaintLabels(true);
		thickness.addChangeListener(this);
		line.add(thickness);
		b.add(line);
		
		return b;
		}
		
	
	/**
	 * Controller aspect of this
	 */

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider x = (JSlider) e.getSource();
		this.view.getPaintPanel().setThickness(x.getValue());

	}
	
}

